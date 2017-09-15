package come.newbula.xing.ui.video;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import come.newbula.xing.BaseActivity;
import come.newbula.xing.R;
/**
 * 文 件 名:  ReleaseVideoActivity.java
 * 版    权:  xingren
 * 描    述:  <视频发布>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月21日
 */
public class ReleaseVideoActivity extends BaseActivity {

    private Context context;
    //返回
    @ViewInject(R.id.rl_back)
    private RelativeLayout rl_back;
    //VIdeoVIew
    @ViewInject(R.id.videoview)
    private VideoView videoview;
    private String url="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release_video);
        context=ReleaseVideoActivity.this;
        ViewUtils.inject(this);
        init();
    }
    private void init(){
        Intent intent=getIntent();
        url=intent.getStringExtra("Url");
     Uri  mUri = Uri.parse(url);

        //Create media controller，组件可以控制视频的播放，暂停，回复，seek等操作，不需要你实现
        MediaController     mMediaController = new MediaController(this);
        videoview.setMediaController(mMediaController);
        videoview.setVideoURI(mUri);
        videoview.start();
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                //播放结束后的动作
                videoview.start();
            }
        });
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

    @Override
    protected void onResume() {
        super.onResume();
        videoview.start();
    }
}
