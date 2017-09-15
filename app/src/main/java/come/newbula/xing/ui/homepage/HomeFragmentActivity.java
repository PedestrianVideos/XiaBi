package come.newbula.xing.ui.homepage;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aliyun.demo.crop.AliyunVideoCrop;
import com.aliyun.demo.crop.MediaActivity;
import com.aliyun.demo.recorder.AliyunVideoRecorder;
import com.aliyun.struct.recorder.CameraType;
import com.aliyun.struct.recorder.FlashType;
import com.aliyun.struct.snap.AliyunSnapVideoParam;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import come.newbula.xing.R;
import come.newbula.xing.ui.challenge.ChallengeFragment;
import come.newbula.xing.ui.findchallenge.FindChallengeFragment;
import come.newbula.xing.ui.login.LoginActivity;
import come.newbula.xing.ui.pedestrianlist.PedestrianListFragment;
import come.newbula.xing.ui.personinfo.PersonInFoFragment;
import come.newbula.xing.ui.video.ReleaseVideoActivity;
import come.newbula.xing.ui.video.VideoFragment;
import come.newbula.xing.utils.Shanchuan;


/**
 * 文 件 名:  HomeFragmentActivity.java
 * 版    权:  xingren
 * 描    述:  <主页fragmentActivity>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月18日
 */
public class HomeFragmentActivity extends AppCompatActivity implements View.OnClickListener {

     //Tab标签
    private String[] tags;
    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

    /**
     * Fragment事物
     */
    private FragmentTransaction fragmentTransaction;
    /**
     * 当前的Fragment Tag
     */
    private String curFragmentTag;
    /**
    * 是否满足退出
    */
    private boolean isBack = false;

    /**
     * 上次退出的时间
     */
    private long downTime;

    /**
     * 挑战
     * */
    private ChallengeFragment challengeFragment;

    /**
     * 找挑战
     * */
    private FindChallengeFragment findChallengeFragment;

    /**
     * 视频
     * */
    private VideoFragment videoFragment;

    /**
     * 行拍榜
     * */
    private PedestrianListFragment pedestrianListFragment;

    /**
     * 个人中心
     * */
    private PersonInFoFragment personInFoFragment;


   //挑战RelativeLayout
    @ViewInject(R.id.homeChallengeRelative)
    private RelativeLayout homeChallengeRelative;
    //Text
    @ViewInject(R.id.homeChallengeImgTxt)
    private TextView homeChallengeImgTxt;
    //imageView
    @ViewInject(R.id.homeChallengeImg)
    private ImageView homeChallengeImg;

    //找挑战RelativeLayout
    @ViewInject(R.id.homeFindchallengeRelative)
    private RelativeLayout homeFindchallengeRelative;
    //Text
    @ViewInject(R.id.homeFindchallengeTxt)
    private TextView homeFindchallengeTxt;
    //imageView
    @ViewInject(R.id.homeFindchallengeImg)
    private ImageView homeFindchallengeImg;

    //视频RelativeLayout
    @ViewInject(R.id.homeViodeRelative)
    private RelativeLayout homeViodeRelative;
    //Text
    @ViewInject(R.id.homeViodeTxt)
    private TextView homeViodeTxt;
    //imageView
    @ViewInject(R.id.homeViodeImg)
    private ImageView homeViodeImg;

    //行人榜RelativeLayout
    @ViewInject(R.id.homePedestrianRelative)
    private RelativeLayout homePedestrianRelative;
    //Text
    @ViewInject(R.id.homePedestrianTxt)
    private TextView homePedestrianTxt;
    //imageView
    @ViewInject(R.id.homePedestrianImg)
    private ImageView homePedestrianImg;

    //我RelativeLayout
    @ViewInject(R.id.homeMineRelative)
    private RelativeLayout homeMineRelative;
    //Text
    @ViewInject(R.id.homemineTxt)
    private TextView homemineTxt;
    //imageView
    @ViewInject(R.id.homemineImg)
    private ImageView homemineImg;

    private Context mcontext;
    //是否登录
    private Boolean isLogin;

    //拍摄
    private  AliyunSnapVideoParam shotVideo;
    //剪切
    private  AliyunSnapVideoParam shearVideo;
    //拍摄页面 请求Code
    private final static  int shotCode = 0*100;
    //剪切页面 请求Code
    private final static  int shearCode = 0*101;

    public Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏状态栏、标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);
        mcontext=this;
        ViewUtils.inject(this);
        SharedPreferences sharedPre = mcontext.getSharedPreferences("IsLogin", mcontext.MODE_PRIVATE);
        isLogin = sharedPre.getBoolean("isLogin", false);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA,
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                },
                0);

        initQuPai();

        init();

    }



    private void init() {
        initView();
        fragmentmanger();
    }

    /**
     * fragmentManager
     */

    private void fragmentmanger() {
        tags =
                new String[]{getString(R.string.challenge), getString(R.string.find_challenge),
                        getString(R.string.video),
                        getString(R.string.pedestrian_list),
                        getString(R.string.mine),
                };
        fragmentManager = getSupportFragmentManager();
        // 第一次启动时默认选中第一个tab
        setTabSelection(getString(R.string.challenge));
        curFragmentTag = getString(R.string.challenge);
        fragmentTransaction = fragmentManager.beginTransaction();
        //挑战
        fragmentTransaction.show(challengeFragment);
    }


    /**
     * <开始事务>
     * <功能详细描述>
     *
     * @return 返 回 类 型：FragmentTransaction
     */
    private FragmentTransaction ensureTransaction()
    {
        if (fragmentTransaction == null)
        {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        }
        return fragmentTransaction;

    }
    /**
     * 控件初始化
     * */
    private void initView() {
        homeChallengeRelative.setOnClickListener(this);
        homeFindchallengeRelative.setOnClickListener(this);
        homeViodeRelative.setOnClickListener(this);
        homePedestrianRelative.setOnClickListener(this);
        homeMineRelative.setOnClickListener(this);

    }

    /**
     * <清楚所有选中状态>
     * <功能详细描述>
     * 返 回 类 型：void
     */
    private void clearSelection()
    {
        //图片未设置
//        homeExpertImg.setImageResource(R.drawable.dh_tab_dongtai);
        homeChallengeImgTxt.setTextColor(getResources().getColor(R.color.white));
        homeChallengeImg.setImageResource(R.mipmap.tab_1);
        homeFindchallengeTxt.setTextColor(getResources().getColor(R.color.white));
        homeFindchallengeImg.setImageResource(R.mipmap.tab_2);
        homeViodeTxt.setTextColor(getResources().getColor(R.color.white));
        homeViodeImg.setImageResource(R.mipmap.camera);
        homePedestrianTxt.setTextColor(getResources().getColor(R.color.white));
        homePedestrianImg.setImageResource(R.mipmap.tab_4);
        homemineTxt.setTextColor(getResources().getColor(R.color.white));
        homemineImg.setImageResource(R.mipmap.tab_5);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.homeChallengeRelative:  //挑战
                setTabSelection(getString(R.string.challenge));
                curFragmentTag=getString(R.string.challenge);
                break;
            case R.id.homeFindchallengeRelative: // 找挑战
                setTabSelection(getString(R.string.find_challenge));
                curFragmentTag=getString(R.string.find_challenge);
                break;
            case R.id.homeViodeRelative: //视频拍摄

                showPhotoDiaLog();

                break;
            case R.id.homePedestrianRelative: // 行人榜
                setTabSelection(getString(R.string.pedestrian_list));
                curFragmentTag=getString(R.string.pedestrian_list);
                break;
            case R.id.homeMineRelative: // 我
                if (isLogin){
                    setTabSelection(getString(R.string.mine));
                    curFragmentTag=getString(R.string.mine);
                }else {
                    startActivity(new Intent(mcontext, LoginActivity.class));
                }

                break;


               }
    }
    /**
     * <设置控件的选择状态>
     * <功能详细描述>
     */
    private void setSelection(int id)
    {
        switch (id)
        {
            case R.id.homeChallengeRelative:  //挑战
                homeChallengeImg.setImageResource(R.mipmap.tab_1s);
                homeChallengeImgTxt.setTextColor(getResources().getColor(R.color.color_C95530));
                break;
            case R.id.homeFindchallengeRelative: // 找挑战
//                homeHospitalImg.setImageResource(R.drawable.s12_3_tab_xsq_s);
                homeFindchallengeTxt.setTextColor(getResources().getColor(R.color.color_C95530));
                break;
            case R.id.homeViodeRelative: //视频拍摄
//                homeMyReservationImg.setImageResource(R.drawable.dh_tab_kangfuquan_s);
//                homeMyReservationTxt.setTextColor(getResources().getColor(R.color.tab_sel_color));
                break;
            case R.id.homePedestrianRelative: // 行人榜
//                homeRehabCircleImg.setImageResource(R.drawable.s12_3_tab_my_s);
                homePedestrianTxt.setTextColor(getResources().getColor(R.color.color_C95530));
                break;
            case R.id.homeMineRelative: // 我
//                homeRehabCircleImg.setImageResource(R.drawable.s12_3_tab_my_s);
                homemineTxt.setTextColor(getResources().getColor(R.color.color_C95530));
                break;
            default:
                break;
        }
    }
    /**
     * <设置选中的Tab>
     * <功能详细描述>
     *
     * @param tag 返 回 类 型：void
     */
    public void setTabSelection(String tag) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        fragmentTransaction = fragmentManager.beginTransaction();

        //挑战
        if (TextUtils.equals(tag, getString(R.string.challenge))) {
            // 当点击了消息tab时，改变控件的图片和文字颜色
            setSelection(R.id.homeChallengeRelative);

            if (challengeFragment == null) {

                challengeFragment = new ChallengeFragment();
            }

//            if (challengeFragment.getUserVisibleHint() && challengeFragment.isAdded() && !curFragmentTag.equals(tag)) {
//                //刷新
//                challengeFragment.refreshData();
//            }
        }
        //找挑战
        if (TextUtils.equals(tag, getString(R.string.find_challenge))) {

            setSelection(R.id.homeFindchallengeRelative);

            if (findChallengeFragment == null) {

                findChallengeFragment = new FindChallengeFragment();
            }
//            if (findChallengeFragment.getUserVisibleHint() && findChallengeFragment.isAdded() && !findChallengeFragment.equals(tag)) {
//                //方法刷新数据
//                //TODO
//                findChallengeFragment.refreshData();
//            }
        }
        //视频
        if (TextUtils.equals(tag, getString(R.string.video))) {
            setSelection(R.id.homeViodeRelative);

            if (videoFragment == null) {
                videoFragment = new VideoFragment();
            }

        }
        //行拍榜
        if (TextUtils.equals(tag, getString(R.string.pedestrian_list)
        )) {

            setSelection(R.id.homePedestrianRelative);

            if (pedestrianListFragment == null) {

                pedestrianListFragment = new PedestrianListFragment();
            }

        }
        //我的
        if (TextUtils.equals(tag, getString(R.string.mine))) {

            setSelection(R.id.homeMineRelative);

            if (personInFoFragment == null) {

                personInFoFragment = new PersonInFoFragment();
            }

        }
        switchFragment(tag);
    }



    /**
     * <一句话功能简述>
     * <功能详细描述>
     *
     * @param tag tag
     * @return 返 回 类 型：Fragment
     */
    private Fragment getFragment(String tag)
    {

        Fragment f = fragmentManager.findFragmentByTag(tag);

        if (f == null)
        {
            //挑战
            if (TextUtils.equals(tag, getString(R.string.challenge))) {

                if (challengeFragment == null) {

                    challengeFragment = new ChallengeFragment();
                }
                return challengeFragment;
            }
            //找挑战
            if (TextUtils.equals(tag, getString(R.string.find_challenge))) {

                if (findChallengeFragment == null) {

                    findChallengeFragment = new FindChallengeFragment();
                }
                return findChallengeFragment;
            }
            //视频
            if (TextUtils.equals(tag, getString(R.string.video))) {

                if (videoFragment == null) {

                    videoFragment = new VideoFragment();
                }
                return videoFragment;
            }
            //行拍榜
            if (TextUtils.equals(tag, getString(R.string.pedestrian_list))) {

                if (pedestrianListFragment == null) {

                    pedestrianListFragment = new PedestrianListFragment();
                }
                return pedestrianListFragment;
            }
            //我的
            if (TextUtils.equals(tag, getString(R.string.mine))) {

                if (personInFoFragment == null) {

                    personInFoFragment = new PersonInFoFragment();
                }
                return personInFoFragment;
            }
        }
        return f;

    }

    /**
     * <加入Fragment>
     * <功能详细描述>
     *
     * @param layout 显示布局
     * @param f      fragment
     * @param tag    tag
     * @see [类、类#方法、类#成员]
     */
    private void attachFragment(int layout, Fragment f, String tag)
    {
        if (f != null)
        {
            if (f.isHidden())
            {
                fragmentTransaction.show(f);
            } else if (f.isDetached())
            {
                fragmentTransaction.attach(f);
            } else if (!f.isAdded())
            {
                fragmentTransaction.add(layout, f, tag);
            }
        }
    }


    /**
     * <根据传入的tag切换fragment>
     * <功能详细描述>
     *
     * @param tag 返 回 类 型：void
     */
    private void switchFragment(String tag)
    {
        detachFragment(tag);
        //getSupportFragmentManager().popBackStack();
        attachFragment(R.id.content, getFragment(tag), tag);
        curFragmentTag = tag;
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty())
        {
            fragmentTransaction.commit();
        }
        onResume();
    }

    /**
     * <一句话功能简述>
     * <功能详细描述>
     *
     * @param tagCurrent 返回类型:void
     */
    private void detachFragment(String tagCurrent)
    {
        ensureTransaction();
        for (int i = 0; i < tags.length; i++)
        {
            Fragment fragment = fragmentManager.findFragmentByTag(tags[i]);
            if (fragment != null && !fragment.isDetached() && !TextUtils.equals(tagCurrent, tags[i]))
            {
                fragmentTransaction.hide(fragment);
            }
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
        {
            if (curFragmentTag.equals(getString(R.string.challenge)))
            {
                if (!isBack)
                {
                    Toast.makeText(HomeFragmentActivity.this, getString(R.string.home_back), Toast.LENGTH_SHORT).show();
                    downTime = event.getDownTime();
                    isBack = true;
                    return true;
                } else
                {
                    if (event.getDownTime() - downTime <= 2000)
                    {
                        System.exit(0);
                    } else
                    {
                        Toast.makeText(HomeFragmentActivity.this, getString(R.string.home_back), Toast.LENGTH_SHORT)
                                .show();
                        downTime = event.getDownTime();
                        return true;
                    }
                }
            }else {
                setTabSelection(getString(R.string.challenge));
                isBack = false;
                //
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == shotCode || requestCode == shearCode){
            if(resultCode == Activity.RESULT_OK && data!= null){
                int type = data.getIntExtra(MediaActivity.RESULT_TYPE,0);
                if(type ==  MediaActivity.RESULT_TYPE_CROP){   //裁剪

                    String path = data.getStringExtra(AliyunVideoCrop.RESULT_KEY_CROP_PATH);
                    Toast.makeText(this,"文件路径为 "+ path + " 时长为 " +
                            data.getLongExtra(AliyunVideoCrop.RESULT_KEY_DURATION,0),Toast.LENGTH_SHORT).show();
                    Log.d("dou","裁剪完成");

                }else if(type ==  MediaActivity.RESULT_TYPE_RECORD){  //拍摄

//                    Toast.makeText(this,"文件路径为 "+
//                            data.getStringExtra(AliyunVideoRecorder.OUTPUT_PATH),Toast.LENGTH_SHORT).show();

                    String VideoPath = data.getStringExtra(AliyunVideoRecorder.OUTPUT_PATH);
                    Log.d("dou","  "+VideoPath);
                    Intent intent=new Intent (mcontext, ReleaseVideoActivity.class);
                    intent.putExtra("Url",VideoPath);
                    startActivity(intent);
                    Shanchuan.getShanchuan(getApplicationContext()).ShanChuanShiPin(VideoPath);  //上传视频
                }
            }else if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this,"用户取消拍摄",Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 趣拍Diaolog
     * */
    public void showPhotoDiaLog()
    {
        //      photoPath = Constants.USER_NAME + "_" + System.currentTimeMillis() + ".jpg";
        dialog = new Dialog(mcontext, R.style.image_select_dialog);
        dialog.setContentView(R.layout.image_select_dialog);
        dialog.getWindow().getAttributes().width = ViewPager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().getAttributes().height = ViewPager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().getAttributes().gravity = Gravity.BOTTOM;
        dialog.getWindow().setWindowAnimations(R.style.dialog_two_style);
        TextView camera = (TextView)dialog.findViewById(R.id.camera);
        //        camera.setOnClickListener(this);
        TextView gallery = (TextView)dialog.findViewById(R.id.gallery);
        //        gallery.setOnClickListener(this);
        TextView cancel = (TextView)dialog.findViewById(R.id.cancel);
        //        cancel.setOnClickListener(this);
        dialog.show();
        /**
         * 从相册选取照片
         */
        gallery.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                dialog.dismiss();
                AliyunVideoRecorder.startRecordForResult(HomeFragmentActivity.this,shotCode,shotVideo);
            }
        });
        /**
         * 从相机拍摄照片
         */
        camera.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                // 先验证手机是否有sdcard
                dialog.dismiss();
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
                {
                    try
                    {
                        AliyunVideoCrop.startCropForResult(HomeFragmentActivity.this,shearCode,shearVideo);
                    }
                    catch (ActivityNotFoundException e)
                    {
                        Toast.makeText(mcontext, "没有找到储存目录", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(mcontext, "没有储存卡", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                dialog.dismiss();
            }
        });
    }




    //初始化 趣拍 拍摄和剪切
    private void initQuPai() {

       shotVideo = new AliyunSnapVideoParam.Builder()
                //设置录制分辨率，目前支持360p，480p，540p，720p
//                .setResulutionMode(AliyunVideoRecorder.RESOLUTION_360P)
                //设置视频比例，目前支持1:1,3:4,9:16
//                .setRatioMode(AliyunVideoRecorder.RATIO_MODE_9_16)
//                .setRecordMode(RecorderDemo.RECORD_MODE_AUTO) //设置录制模式，目前支持按录，点录和混合模式
//                .setFilterList(eff_dirs) //设置滤镜地址列表,具体滤镜接口接收的是一个滤镜数组
                .setBeautyLevel(80) //设置美颜度
                .setBeautyStatus(true) //设置美颜开关
                .setCameraType(CameraType.BACK) //设置前后置摄像头
                .setFlashType(FlashType.ON) // 设置闪光灯模式
                .setNeedClip(true) //设置是否需要支持片段录制
                .setMaxDuration(10000) //设置最大录制时长 单位毫秒
                .setMinDuration(1000) //设置最小录制时长 单位毫秒

//                .setVideQuality(videoQuality) //设置视频质量
//                .setGop(gop) //设置关键帧间隔
                .build();


      shearVideo = new AliyunSnapVideoParam.Builder()
//                .setFrameRate(100) //设置帧率
//                .setGop(1) //设置关键帧间隔
//                .setCropMode(ScaleMode.PS) //设置裁剪模式，目前支持有黑边和无黑边两种
//                .setVideQuality(VideoQuality.HD) //设置裁剪质量
//                .setResulutionMode(AliyunSnapVideoParam.RESOLUTION_720P) //设置分辨率，目前支持360p，480p，540p，720p
//                .setRatioMode(AliyunSnapVideoParam.RATIO_MODE_9_16)//设置裁剪比例 目前支持1:1,3:4,9:16
                .setNeedRecord(true)//设置是否需要开放录制入口
                .setMinVideoDuration(1000) //设置过滤的视频最小长度 单位毫秒
                .setMaxVideoDuration(10000) //设置过滤的视频最大长度 单位毫秒
                .setMinCropDuration(1000) //设置视频最小裁剪时间 单位毫秒
                .build();

    }

}
