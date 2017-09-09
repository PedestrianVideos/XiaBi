package come.newbula.xing.ui.personinfo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.util.concurrent.TimeUnit;

import come.newbula.xing.R;
import come.newbula.xing.ui.login.activity.LoginPasswordActivity;
import come.newbula.xing.ui.login.activity.RegisterActivity;
import come.newbula.xing.ui.login.bean.response.LoginResBean;
import come.newbula.xing.ui.login.bean.response.RegisterResBean;
import come.newbula.xing.ui.personinfo.activity.AddFriendActivity;
import come.newbula.xing.ui.personinfo.activity.NewsActivity;
import come.newbula.xing.ui.personinfo.activity.PersonalActivity;
import come.newbula.xing.ui.personinfo.activity.SetUpActivity;
import come.newbula.xing.ui.personinfo.bean.response.UserInfoResBean;

/**
 * 文 件 名:  PersonInFoFragment.java
 * 版    权:  xingren
 * 描    述:  <我的fragment>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月21日
 */
public class PersonInFoFragment extends Fragment implements View.OnClickListener
{

    /**
     * context
     */
    private Context context;


    /**
     * view
     */
    private View view;
    //添加好友
   @ViewInject(R.id.rl_add_friend)
    private RelativeLayout rl_add_friends;
    //编辑主页
    @ViewInject(R.id.tv_edit_zhuye)
    private TextView tv_edit_zhuye;
    //设置
    @ViewInject(R.id.rl_set_up)
    private RelativeLayout rl_set_up;
    //消息
    @ViewInject(R.id.img_xiaoxi)
    private ImageView img_xiaoxi;
    //标题姓名
    @ViewInject(R.id.tv_title_username)
    private TextView tv_title_username;
    //姓名
    @ViewInject(R.id.tv_username)
    private TextView tv_username;
    //签名
    @ViewInject(R.id.tv_autograph)
    private TextView tv_autograph;
    //token
    private String token;
    //Uid
    private String uid;

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    String url = "http://139.224.228.169:8089/xiabi/user/profile/";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_personinfo, container, false);
        context = getActivity();
        ViewUtils.inject(this,view);
        SharedPreferences sharedPre = context.getSharedPreferences("Access_token", context.MODE_PRIVATE);
         token  = sharedPre.getString("access_token","");
        SharedPreferences sharedPreUid = context.getSharedPreferences("Uid", context.MODE_PRIVATE);
        uid  = sharedPreUid.getString("uid","");
        init();
        userInfoReq();
        return view;

    }

    private void init() {
        rl_add_friends.setOnClickListener(this);
        tv_edit_zhuye.setOnClickListener(this);
        rl_set_up.setOnClickListener(this);
        img_xiaoxi.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_add_friend:  //添加好友
                startActivity(new Intent(context, AddFriendActivity.class));
                break;
            case R.id.tv_edit_zhuye: //编辑主页
                startActivity(new Intent(context, PersonalActivity.class));
                break;
            case R.id.rl_set_up://设置
                startActivity(new Intent(context, SetUpActivity.class));
                break;
            case R.id.img_xiaoxi: //消息
                startActivity(new Intent(context, NewsActivity.class));
                break;
        }
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
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv_title_username.setText(userInfoResBean.getData().getNickName());
                                tv_username.setText(userInfoResBean.getData().getNickName());
                                tv_autograph.setText(userInfoResBean.getData().getSignature());
                            }
                        });

                    }
                }
            }
        });
    }

}
