package come.newbula.xing.ui.login.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import come.newbula.xing.BaseActivity;
import come.newbula.xing.R;
import come.newbula.xing.ui.homepage.HomeFragmentActivity;
import come.newbula.xing.ui.login.bean.request.LoginReqBean;
import come.newbula.xing.ui.login.bean.request.RegisterReqBean;
import come.newbula.xing.ui.login.bean.response.LoginResBean;
import come.newbula.xing.ui.login.bean.response.RegisterResBean;
import come.newbula.xing.utils.MD5;

public class RegisterActivity extends BaseActivity {
    private int recLen = 60;
    Timer timer = new Timer();
    private Context context;
    //手机号
    @ViewInject(R.id.tv_phone)
    private TextView tv_phone;
    //返回
    @ViewInject(R.id.rl_back)
    private RelativeLayout rl_back;
    //带出来的手机号
    private String phone;
    //倒计时
    @ViewInject(R.id.tv_jishi)
    private TextView tv_jishi;
    //重新发送
    @ViewInject(R.id.rl_resend)
    private RelativeLayout rl_resend;
    //进入
    @ViewInject(R.id.img_jinru)
    private ImageView img_jinru;
    //验证码
    @ViewInject(R.id.ed_verification)
    private EditText ed_verification;
    //密码
    @ViewInject(R.id.ed_new_password)
    private EditText ed_new_password;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    String url = "http://139.224.228.169:8089/xiabi/verify/create";
    String  validateUrl="http://139.224.228.169:8089/xiabi/verify/validate";
    String registerUrl="http://139.224.228.169:8089/xiabi/user/register/phone";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        context=RegisterActivity.this;
        ViewUtils.inject(this);
        init();
        //获取验证码
        verifyReq();
    }

    private void init(){
        Intent intent=getIntent();
        phone=intent.getStringExtra("Phone");
        timer.schedule(task, 1000, 1000);       // timeTask
        rl_back.setOnClickListener(this);
        rl_resend.setOnClickListener(this);
        img_jinru.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_back: //返回
                finish();
                break;
            case R.id.rl_resend: //重新发送
                //获取验证码
                verifyReq();
                timer.schedule(task, 1000, 1000);       // timeTask
                tv_jishi.setVisibility(View.VISIBLE);
                rl_resend.setVisibility(View.GONE);
                break;
            case R.id.img_jinru: //下一步
                validateReq();
                break;
        }
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            runOnUiThread(new Runnable() {      // UI thread
                @Override
                public void run() {
                    recLen--;
                    tv_jishi.setText(""+recLen+"s");
                    if(recLen < 1){
                        timer.cancel();
                        tv_jishi.setVisibility(View.GONE);
                        rl_resend.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    };


    //获取验证码
    private   void verifyReq() {
        url=url+"?phone="+phone;
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(10, TimeUnit.SECONDS);
        client.setReadTimeout(10, TimeUnit.SECONDS);
        client.setWriteTimeout(30,TimeUnit.SECONDS);
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Toast.makeText(context,"网络异常，请稍候重试",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(Response response) throws IOException {
               Log.e("-----","短信验证码发送成功");
            }
        });
    }


    //校验短信验证码
    private   void validateReq() {
        validateUrl=validateUrl+"?phone="+phone+"&verifyNumber="+ed_verification.getText().toString().trim();
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(10, TimeUnit.SECONDS);
        client.setReadTimeout(10, TimeUnit.SECONDS);
        client.setWriteTimeout(30,TimeUnit.SECONDS);
        final Request request = new Request.Builder()
                .url(validateUrl)
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Toast.makeText(context,"网络异常，请稍候重试",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(Response response) throws IOException {

                if (response.isSuccessful()){
                    Log.e("-----","短信验证码校验成功");
                    registerReq();
                }
            }
        });
    }

    //注册请求
    private   void registerReq() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(10, TimeUnit.SECONDS);
        client.setReadTimeout(10, TimeUnit.SECONDS);
        client.setWriteTimeout(30,TimeUnit.SECONDS);
        RegisterReqBean query = new RegisterReqBean();
        query.setPhone(phone.trim());
        query.setPasswd(new MD5().md5(ed_new_password.getText().toString().trim()));
        String s = new Gson().toJson(query);
        RequestBody body = RequestBody.create(JSON, s);
        final Request request = new Request.Builder()
                .url(registerUrl)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Toast.makeText(context,"网络异常，请稍候重试",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()){
                    Gson gson = new Gson();
                    RegisterResBean registerResBean = gson.fromJson(response.body().string(), RegisterResBean.class);
                    if (registerResBean.getMeta().getCode().equals("0000")){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context,"注册成功！",Toast.LENGTH_SHORT).show();
                            }
                        });
                        SharedPreferences sharedialog = context.getSharedPreferences("Access_token", context.MODE_PRIVATE);
                        SharedPreferences.Editor Convened = sharedialog.edit();
                        Convened.putString("access_token", registerResBean.getAaa().getAccess_token().toString());
                        Convened.commit();
                        SharedPreferences share = context.getSharedPreferences("IsLogin", context.MODE_PRIVATE);
                        SharedPreferences.Editor Conven = share.edit();
                        Conven.putBoolean("isLogin",true);
                        Conven.commit();
                        SharedPreferences sharePhone = context.getSharedPreferences("Phone", context.MODE_PRIVATE);
                        SharedPreferences.Editor editPhone = sharePhone.edit();
                        editPhone.putString("phone",phone);
                        editPhone.commit();
                        SharedPreferences shareuid = context.getSharedPreferences("Uid", context.MODE_PRIVATE);
                        SharedPreferences.Editor editUid = shareuid.edit();
                        editUid.putString("uid",registerResBean.getData().getUid());
                        editUid.commit();
                        startActivity(new Intent(context, HomeFragmentActivity.class));
                        finish();
                    }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context,"注册失败！",Toast.LENGTH_SHORT).show();

                            }
                        });
                    }


                }
            }
        });
    }


}
