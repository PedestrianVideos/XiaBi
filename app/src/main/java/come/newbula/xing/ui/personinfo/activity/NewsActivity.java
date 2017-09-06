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
 * 文 件 名:  NewsActivity.java
 * 版    权:  xingren
 * 描    述:  <消息>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月25日
 */
public class NewsActivity extends AppCompatActivity implements View.OnClickListener {

    //返回
    @ViewInject(R.id.rl_back)
    private RelativeLayout rl_back;
    //我的
    @ViewInject(R.id.tv_mine)
    private TextView tv_mine;
    //粉丝
    @ViewInject(R.id.rl_fans)
    private RelativeLayout rl_fans;
    //赞
    @ViewInject(R.id.rl_fabulous)
    private RelativeLayout rl_fabulous;
    //@我的
    @ViewInject(R.id.rl_mine)
    private RelativeLayout rl_mine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏状态栏、标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_news);
        ViewUtils.inject(this);
        init();
    }

    private void init() {
        tv_mine.setText("@我的");
        rl_back.setOnClickListener(this);
        rl_fans.setOnClickListener(this);
        rl_fabulous.setOnClickListener(this);
        rl_mine.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_back: //返回
                 finish();
                break;
            case R.id.rl_fans: //粉丝
                startActivity(new Intent(this,FansActivity.class));
                break;
            case R.id.rl_fabulous: //赞
                startActivity(new Intent(this,FabulousActivity.class));
                break;
            case R.id.rl_mine: //@我的
                startActivity(new Intent(this,MineActivity.class));
                break;
        }

    }
}
