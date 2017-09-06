package come.newbula.xing.ui.personinfo.activity;

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
 * 文 件 名:  ChangePasswordActivity.java
 * 版    权:  xingren
 * 描    述:  <修改密码>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月24日
 */
public class ChangePasswordActivity extends AppCompatActivity  implements View.OnClickListener{

    @ViewInject(R.id.rl_back)
    private RelativeLayout rl_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_change_password);
        ViewUtils.inject(this);
        init();
    }

    private void init() {
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
