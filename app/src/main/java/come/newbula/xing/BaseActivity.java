package come.newbula.xing;


import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;


public class BaseActivity extends FragmentActivity implements View.OnClickListener {

    //标题
    private TextView tv_title;
    //返回
    public RelativeLayout rl_back;
    //标题布局
    public RelativeLayout rl_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏状态栏、标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        ViewUtils.inject(this);
        initView();
        rl_back.setOnClickListener(this);
    }

    private void initView() {
        tv_title= (TextView) findViewById(R.id.tv_title);
        rl_back=(RelativeLayout)findViewById(R.id.rl_back);
        rl_title=(RelativeLayout)findViewById(R.id.rl_title);
    }

    /**
     * 设置标题
     * */
    public void setTitle(String title){
        tv_title.setText(title);
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
