package come.newbula.xing.ui.login.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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
import come.newbula.xing.ui.login.bean.request.FindPasswordReqBean;
import come.newbula.xing.ui.login.bean.request.RegisterReqBean;
import come.newbula.xing.ui.login.bean.response.FindPasswordResBean;
import come.newbula.xing.ui.login.bean.response.RegisterResBean;
import come.newbula.xing.utils.MD5;

public class FindPasswordActivity extends BaseActivity {

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
    //验证码
    @ViewInject(R.id.ed_verification)
    private EditText ed_verification;
    //新密码
    @ViewInject(R.id.ed_new_password)
    private EditText ed_new_password;
    //下一步
    @ViewInject(R.id.img_jinru)
    private ImageView img_jinru;
    //重新发送
    @ViewInject(R.id.tv_resend)
    private TextView tv_resend;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    String url = "http://139.224.228.169:8089/xiabi/verify/create";
    String  validateUrl="http://139.224.228.169:8089/xiabi/verify/validate";
    String  findpasswdUrl="http://139.224.228.169:8089/xiabi/user/passwd/back";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
        context=FindPasswordActivity.this;
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
        tv_resend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_back: //返回
                finish();
                break;
            case R.id.rl_resend: //重新发送
                timer.schedule(task, 1000, 1000);       // timeTask
                tv_jishi.setVisibility(View.VISIBLE);
                rl_resend.setVisibility(View.GONE);
                break;
            case R.id.img_jinru: //下一步
                validateReq();
                break;
            case R.id.tv_resend: //重新发送
                verifyReq();
                timer.schedule(task, 1000, 1000);
                tv_jishi.setVisibility(View.VISIBLE);
                rl_resend.setVisibility(View.GONE);
                break;
        }
    }


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
                    findPasswordReq();
                }
            }
        });
    }


    //找回密码请求
    private   void findPasswordReq() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(10, TimeUnit.SECONDS);
        client.setReadTimeout(10, TimeUnit.SECONDS);
        client.setWriteTimeout(30,TimeUnit.SECONDS);
        FindPasswordReqBean query = new FindPasswordReqBean();
        query.setPhone(phone.trim());
        query.setPasswd(new MD5().md5(ed_new_password.getText().toString().trim()));
        String s = new Gson().toJson(query);
        RequestBody body = RequestBody.create(JSON, s);
        final Request request = new Request.Builder()
                .url(findpasswdUrl)
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
//                    Log.d("------------", response.body().string());
                    FindPasswordResBean findPasswordResBean = gson.fromJson(response.body().string(), FindPasswordResBean.class);
                    if (findPasswordResBean.getMeta().getCode().equals("0000")){
                        Log.e("------------","新密码设置成功！");
                        finish();
                    }

                }
            }
        });
    }


    /**
     * 倒计时
     * */
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
}
