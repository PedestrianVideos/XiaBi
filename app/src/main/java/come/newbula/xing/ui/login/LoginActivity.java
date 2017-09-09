package come.newbula.xing.ui.login;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import come.newbula.xing.BaseActivity;
import come.newbula.xing.R;
import come.newbula.xing.ui.homepage.HomeFragmentActivity;
import come.newbula.xing.ui.login.activity.LoginPasswordActivity;
import come.newbula.xing.ui.login.activity.RegisterActivity;
import come.newbula.xing.ui.login.bean.request.LoginReqBean;
import come.newbula.xing.ui.login.bean.response.LoginResBean;
import come.newbula.xing.utils.MD5;


public class LoginActivity extends BaseActivity implements TextWatcher,View.OnClickListener{
    private Context context;
    //手机号输入
    @ViewInject(R.id.ed_phone)
    private EditText ed_phone;
    //进入输入密码
    @ViewInject(R.id.rl_password)
    private RelativeLayout rl_password;
    //第三方登录
    @ViewInject(R.id.rl_qitadenglv)
    private RelativeLayout rl_qitadenglv;
    //进入输入密码
    @ViewInject(R.id.img_jinru)
    private ImageView img_jinru;
    //用户协议
    @ViewInject(R.id.tv_xiabixieyi)
     private TextView tv_xiabixieyi;
    //返回
    @ViewInject(R.id.tv_back)
     private TextView tv_back;
    //获取手机mac地址
    String result = "";
    String Mac = "";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    String url = "http://139.224.228.169:8089/xiabi/user/login/phone";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context=LoginActivity.this;
        ViewUtils.inject(this);
        rl_title.setVisibility(View.GONE);
        init();
        getMacAddress();
    }


    private void init(){
        tv_back.setOnClickListener(this);
        ed_phone.addTextChangedListener(this);
        img_jinru.setOnClickListener(this);
        tv_xiabixieyi.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_back: //返回
                Intent intent=new Intent(context, HomeFragmentActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_jinru: //点击登录
                if (ed_phone.getText().length()==11){
                    loginPost();
                }else {
                    Toast.makeText(context,"手机号码不正确",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_xiabixieyi: //用户协议
                Toast.makeText(context,"暂未开发",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 手机号输入监听
     * */
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (ed_phone.getText().length()>0){
            rl_password.setVisibility(View.VISIBLE);
            rl_qitadenglv.setVisibility(View.GONE);
        }else {
            rl_password.setVisibility(View.GONE);
            rl_qitadenglv.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 获取手机mac地址
     * */
    public String getMacAddress() {

        result = callCmd("busybox ifconfig", "HWaddr");

        if (result == null) {
            return "网络出错，请检查网络";
        }
        if (result.length() > 0 && result.contains("HWaddr")) {
            Mac = result.substring(result.indexOf("HWaddr") + 6, result.length() - 1);
            if (Mac.length() > 1) {
                result = Mac.toLowerCase();
            }
        }
        return result.trim();
    }

    public String callCmd(String cmd,String filter) {
        String result = "";
        String line = "";
        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            InputStreamReader is = new InputStreamReader(proc.getInputStream());
            BufferedReader br = new BufferedReader (is);

            //执行命令cmd，只取结果中含有filter的这一行
            while ((line = br.readLine ()) != null && line.contains(filter)== false) {
                //result += line;
                Log.i("test","line: "+line);
            }
            result = line;
            Log.i("test","result: "+result);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private   void loginPost() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(10, TimeUnit.SECONDS);
        client.setReadTimeout(10, TimeUnit.SECONDS);
        client.setWriteTimeout(30,TimeUnit.SECONDS);
        LoginReqBean query = new LoginReqBean();
        query.setAccess_token("");
        query.setPhone(ed_phone.getText().toString().trim());
        query.setPasswd(new MD5().md5(""));
       String s = new Gson().toJson(query);
        RequestBody body = RequestBody.create(JSON, s);
        final Request request = new Request.Builder()
                .url(url)
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
                    LoginResBean loginBean = gson.fromJson(response.body().string(), LoginResBean.class);
                    if (loginBean.getData().isHasRegistered()){
                        //输入密码
                        Intent intent=new Intent(context, LoginPasswordActivity.class);
                        intent.putExtra("Phone",ed_phone.getText().toString());
                        startActivity(intent);
                    }else {
                        //注册
                        Intent intent=new Intent(context, RegisterActivity.class);
                        intent.putExtra("Phone",ed_phone.getText().toString());
                        intent.addFlags(intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                    }
                }
            }
        });
    }



    }