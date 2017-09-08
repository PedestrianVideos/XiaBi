package come.newbula.xing.ui.personinfo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;


import come.newbula.xing.R;
import come.newbula.xing.ui.login.LoginActivity;
import come.newbula.xing.ui.personinfo.activity.AddFriendActivity;
import come.newbula.xing.ui.personinfo.activity.NewsActivity;
import come.newbula.xing.ui.personinfo.activity.PersonalActivity;
import come.newbula.xing.ui.personinfo.activity.SetUpActivity;

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
    //token
    private String token;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_personinfo, container, false);
        context = getActivity();
        ViewUtils.inject(this,view);
        SharedPreferences sharedPre = context.getSharedPreferences("Access_token", context.MODE_PRIVATE);
         token  = sharedPre.getString("access_token","");
        init();
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
//                startActivity(new Intent(context, PersonalActivity.class));
                startActivity(new Intent(context, LoginActivity.class));
                break;
            case R.id.rl_set_up://设置
                startActivity(new Intent(context, SetUpActivity.class));
                break;
            case R.id.img_xiaoxi: //消息
                startActivity(new Intent(context, NewsActivity.class));
                break;
        }
    }
}
