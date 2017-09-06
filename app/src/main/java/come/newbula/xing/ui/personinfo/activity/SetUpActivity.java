package come.newbula.xing.ui.personinfo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import come.newbula.xing.R;
/**
 * 文 件 名:  SetUpActivity.java
 * 版    权:  xingren
 * 描    述:  <设置>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月24日
 */
public class SetUpActivity extends AppCompatActivity implements View.OnClickListener {

    //返回
    @ViewInject(R.id.rl_back)
    private RelativeLayout rl_back;
    //更改密码
    @ViewInject(R.id.rl_change_passward)
    private RelativeLayout rl_change_passward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏状态栏、标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_set_up);
        ViewUtils.inject(this);
        inin();
    }

    private void inin() {
        rl_back.setOnClickListener(this);
        rl_change_passward.setOnClickListener(this);
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


        }
    }
}
