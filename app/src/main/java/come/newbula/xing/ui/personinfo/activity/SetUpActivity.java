package come.newbula.xing.ui.personinfo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.squareup.okhttp.Callback;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import come.newbula.xing.BaseActivity;
import come.newbula.xing.R;
import come.newbula.xing.ui.login.LoginActivity;
import come.newbula.xing.ui.personinfo.bean.request.ChangePasswordReqBean;
import come.newbula.xing.utils.MD5;

/**
 * 文 件 名:  SetUpActivity.java
 * 版    权:  xingren
 * 描    述:  <设置>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月24日
 */
public class SetUpActivity extends BaseActivity implements View.OnClickListener {

    private Context context;
    //返回
    @ViewInject(R.id.rl_back)
    private RelativeLayout rl_back;
    //更改密码
    @ViewInject(R.id.rl_change_passward)
    private RelativeLayout rl_change_passward;
    //退出登录
    @ViewInject(R.id.tv_sign_out)
    private TextView tv_sign_out;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        ViewUtils.inject(this);
        context=SetUpActivity.this;
        SharedPreferences sharedPre = context.getSharedPreferences("Phone", context.MODE_PRIVATE);
        phone = sharedPre.getString("phone", "");

        inin();
    }

    private void inin() {
        rl_back.setOnClickListener(this);
        rl_change_passward.setOnClickListener(this);
        tv_sign_out.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_change_passward:
                startActivity(new Intent(this,ChangePasswordActivity.class));
                break;
            case R.id.tv_sign_out:
                startActivity(new Intent(context, LoginActivity.class));
                SharedPreferences share = context.getSharedPreferences("IsLogin", context.MODE_PRIVATE);
                SharedPreferences.Editor Conven = share.edit();
                Conven.putBoolean("isLogin",false);
                Conven.commit();
                finish();
                break;

        }
    }



}
