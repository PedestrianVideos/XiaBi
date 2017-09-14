package come.newbula.xing.ui.login.activity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.io.IOException;

import come.newbula.xing.BaseActivity;
import come.newbula.xing.R;
import come.newbula.xing.ui.homepage.HomeFragmentActivity;
import come.newbula.xing.ui.login.bean.request.LoginReqBean;
import come.newbula.xing.ui.login.bean.response.LoginResBean;
import come.newbula.xing.utils.MD5;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginPasswordActivity extends BaseActivity implements View.OnClickListener{

    private Context context;
    //手机号
    private String phone;
    //号码
    @ViewInject(R.id.tv_phone)
    private TextView tv_phone;
    //找回密码
    @ViewInject(R.id.tv_findpassword)
    private TextView tv_findpassword;
    //返回
    @ViewInject(R.id.rl_back)
    private RelativeLayout rl_back;
    //下一步
    @ViewInject(R.id.img_go)
    private ImageView img_go;
    //密码
    @ViewInject(R.id.ed_password)
    private EditText ed_password;

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    String url = "http://139.224.228.169:8089/xiabi/user/login/phone";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_password);
        context=LoginPasswordActivity.this;

        ViewUtils.inject(this);
        init();
    }
    private void init(){
        Intent intent=getIntent();
        phone=intent.getStringExtra("Phone");
        tv_phone.setText(phone);
        tv_findpassword.setOnClickListener(this);
        rl_back.setOnClickListener(this);
        img_go.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_findpassword: //找回密码
                Intent intent=new Intent(context, FindPasswordActivity.class);
                intent.putExtra("Phone",tv_phone.getText().toString());
                startActivity(intent);
                break;
            case R.id.rl_back: //返回
                finish();
                break;
            case R.id.img_go: //下一步
                loginPost();
                break;
        }
    }
    private   void loginPost() {
        OkHttpClient client = new OkHttpClient();
        LoginReqBean query = new LoginReqBean();
        query.setAccess_token("");
        query.setPhone(tv_phone.getText().toString().trim());
        query.setPasswd(new MD5().md5(ed_password.getText().toString().trim()));
        String s = new Gson().toJson(query);
        RequestBody body = RequestBody.create(JSON, s);
        final Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(context,"网络异常，请稍候重试",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    Gson gson = new Gson();

                    LoginResBean loginBean = gson.fromJson(response.body().string(), LoginResBean.class);
                    if (loginBean.getMeta().getCode().equals("0000")){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context,"登录成功！",Toast.LENGTH_SHORT).show();

                            }
                        });
                        SharedPreferences sharedialog = context.getSharedPreferences("Access_token", context.MODE_PRIVATE);
                        SharedPreferences.Editor Convened = sharedialog.edit();
                        Convened.putString("access_token", loginBean.getAaa().getAccess_token().toString());
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
                        editUid.putString("uid",loginBean.getData().getUid());
                        editUid.commit();
                        startActivity(new Intent(context, HomeFragmentActivity.class));
                        finish();
                    }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(context,"登录失败！",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }
        });
    }
}
