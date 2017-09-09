package come.newbula.xing.ui.personinfo.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.CalendarView;
import android.widget.EditText;
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
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import come.newbula.xing.R;
import come.newbula.xing.ui.personinfo.bean.response.UserInfoResBean;

/**
 * 文 件 名:  MailListActivity.java
 * 版    权:  xingren
 * 描    述:  <个人资料>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月24日
 */
public class PersonalActivity extends AppCompatActivity implements View.OnClickListener {
  //返回
    @ViewInject(R.id.rl_back)
    private RelativeLayout rl_back;
    private Context context;
    //用户名
    @ViewInject(R.id.ed_name)
    private EditText ed_name;
    //用户ID
    @ViewInject(R.id.ed_user_id)
    private EditText ed_user_id;
    //个性签名
    @ViewInject(R.id.et_qianm)
    private EditText et_qianm;
    //微博
    @ViewInject(R.id.rl_weibo)
    private RelativeLayout rl_weibo;
    //性别
    @ViewInject(R.id.rl_sex)
    private RelativeLayout rl_sex;
    @ViewInject(R.id.tv_sex)
    private TextView tv_sex;
    //生日
    @ViewInject(R.id.rl_brithday)
    private RelativeLayout rl_brithday;
    @ViewInject(R.id.tv_brithday)
    private TextView tv_brithday;
    //token
    private String token;
    //Uid
    private String uid;

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    String url = "http://139.224.228.169:8089/xiabi/user/profile/";
    //日历对象
    private Dialog alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        //默认不弹出键盘
        getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        context=PersonalActivity.this;
        ViewUtils.inject(this);
        SharedPreferences sharedPre = context.getSharedPreferences("Access_token", context.MODE_PRIVATE);
        token  = sharedPre.getString("access_token","");
        SharedPreferences sharedPreUid = context.getSharedPreferences("Uid", context.MODE_PRIVATE);
        uid  = sharedPreUid.getString("uid","");
        init();
        userInfoReq();
    }

    private void init() {
        rl_back.setOnClickListener(this);
        rl_sex.setOnClickListener(this);
        rl_sex.setOnCreateContextMenuListener(new MyContextMenu());
        rl_brithday.setOnClickListener(this);

        }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_back: //返回
                finish();
                break;

            case R.id.rl_sex:
                rl_sex.showContextMenu();
            break;

            case R.id.rl_brithday:
                EjectCalendarDialog();
            break;
        }
    }

    //日历选择对话框
    private void EjectCalendarDialog() {

        if(null == alert){
            alert = new Dialog(context);
            View view = View.inflate(context,R.layout.dialog_eject,null);
            CalendarView calendarView = (CalendarView) view.findViewById(R.id.cal);
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                    tv_brithday.setText(year+"/"+month+"/"+dayOfMonth);
                    alert.dismiss();
                }
            });
            alert.setContentView(view);
        }
        alert.show();
    }


    class MyContextMenu implements View.OnCreateContextMenuListener {

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(0, 0, 0, "男");
            menu.add(0, 1, 0, "女");
            menu.add(0, 2, 0, "取消");
        }
    }

    //  原生Menu弹出框 点击回调
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 0:
                tv_sex.setText("男");
            break;

            case 1:
                tv_sex.setText("女");
                break;
        }
        return true;
    }


    /**
     * 获取个人信息
     * */
    private   void userInfoReq() {
        url=url+uid+"?access_token="+token;
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

                if (response.isSuccessful()){
                    Gson gson = new Gson();
                    final UserInfoResBean userInfoResBean = gson.fromJson(response.body().string(), UserInfoResBean.class);
                    if (userInfoResBean.getMeta().getCode().equals("0000")){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ed_name.setText(userInfoResBean.getData().getNickName());
                                ed_user_id.setText(userInfoResBean.getData().getUid());
                                et_qianm.setText(userInfoResBean.getData().getSignature());
                                if (userInfoResBean.getData().getBirthday()!=null){
                                    tv_brithday.setText(userInfoResBean.getData().getBirthday());
                                }else {
                                    tv_brithday.setText("生日");
                                }
                                if (userInfoResBean.getData().getGender()>0){
                                    if (userInfoResBean.getData().getGender()==1){
                                        tv_sex.setText("男");
                                    }else {
                                        tv_sex.setText("女");
                                    }
                                }else {
                                    tv_sex.setText("性别");
                                }

                            }
                        });

                    }
                }
            }
        });
    }
}
