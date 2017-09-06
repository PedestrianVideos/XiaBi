package come.newbula.xing.ui.personinfo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import come.newbula.xing.R;
/**
 * 文 件 名:  AddFriendActivity.java
 * 版    权:  xingren
 * 描    述:  <添加好友>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月23日
 */
public class AddFriendActivity extends AppCompatActivity implements View.OnClickListener {

    //返回
    @ViewInject(R.id.rl_back)
    private RelativeLayout rl_back;
    //联系人
    @ViewInject(R.id.tv_lianxiren)
    private TextView tv_lianxiren;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏状态栏、标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_friend);
        ViewUtils.inject(this);
        init();
    }

    private void init() {
        rl_back.setOnClickListener(this);
        tv_lianxiren.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_back: //返回
                finish();
                break;
            case R.id.tv_lianxiren: //联系人
                startActivity(new Intent(this,MailListActivity.class));
                break;
        }
    }
}
