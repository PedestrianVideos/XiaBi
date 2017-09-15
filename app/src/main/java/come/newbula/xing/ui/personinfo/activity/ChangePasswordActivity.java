package come.newbula.xing.ui.personinfo.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.io.IOException;

import come.newbula.xing.BaseActivity;
import come.newbula.xing.R;
import come.newbula.xing.ui.personinfo.bean.request.ChangePasswordReqBean;
import come.newbula.xing.utils.MD5;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 文 件 名:  ChangePasswordActivity.java
 * 版    权:  xingren
 * 描    述:  <修改密码>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月24日
 */
public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener{

    @ViewInject(R.id.rl_back)
    private RelativeLayout rl_back;
    private Context context;
    //号码
    private String phone;
    //当前密码
    @ViewInject(R.id.ed_old_password)
    private EditText ed_old_password;
    //新密码
    @ViewInject(R.id.ed_new_password)
    private EditText ed_new_password;
    //再次输入新密码
    @ViewInject(R.id.ed_agin_password)
    private EditText ed_agin_password;
    //完成
    @ViewInject(R.id.tv_complate)
    private TextView tv_complate;

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    String url = "http://139.224.228.169:8089/xiabi/user/passwd/modify";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ViewUtils.inject(this);
        context=ChangePasswordActivity.this;
        SharedPreferences sharedPre = context.getSharedPreferences("UserInfo", context.MODE_PRIVATE);
        phone = sharedPre.getString("phone", "");
        init();
    }

    private void init() {
        rl_back.setOnClickListener(this);
        tv_complate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_back: //返回
                finish();
                break;
            case R.id.tv_complate: //完成
                if (ed_new_password.getText().toString().equals(ed_agin_password.getText().toString())){
                    loginPost();
                }else {
                    Toast.makeText(context,"新密码输入不一致，请重新输入", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }



    //请求更改密码
    private   void loginPost() {
        OkHttpClient client = new OkHttpClient();
        ChangePasswordReqBean query = new ChangePasswordReqBean();
        query.setPhone(phone);
        query.setOldPasswd(new MD5().md5(ed_old_password.getText().toString().trim()));
        query.setNewPasswd(new MD5().md5(ed_new_password.getText().toString().trim()));
        String s = new Gson().toJson(query);
        RequestBody body = RequestBody.create(JSON, s);
        final Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(context,"网络异常，请稍候重试", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    Gson gson = new Gson();
//                    Log.d("---------", response.body().string());
//                    String s1=response.body().string();
//                    try {
//                        JSONObject jsonObject=new JSONObject(s1);
//                        JSONObject jsonObject1=jsonObject.getJSONObject("meta");
//                        String  code=jsonObject1.optString("code");
//                        Log.e("---------","=="+code);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }


//                    ChangePasswordResBean changePasswordResBean = gson.fromJson(response.body().string(), ChangePasswordResBean.class);
//                    if (changePasswordResBean.getMeta().getCode().equals("0000")){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context,"密码更改成功！", Toast.LENGTH_SHORT).show();
                        }
                    });
                    finish();
//                    }else {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Toast.makeText(context,"原密码输入有误", Toast.LENGTH_SHORT).show();                            }
//                        });
//                    }
                }
            }
        });
    }
}
