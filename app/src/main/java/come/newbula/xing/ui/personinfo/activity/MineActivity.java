package come.newbula.xing.ui.personinfo.activity;

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
 * 文 件 名:  MineActivity.java
 * 版    权:  xingren
 * 描    述:  <@我的>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月25日
 */
public class MineActivity extends AppCompatActivity  implements View.OnClickListener{

    //返回
    @ViewInject(R.id.rl_back)
    private RelativeLayout rl_back;
    //标题
    @ViewInject(R.id.tv_title)
    private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mine);
        ViewUtils.inject(this);
        init();
    }

    private void init() {
        tv_title.setText("@我的");
        rl_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
        }

    }
}
