package come.newbula.xing.ui.homepage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import come.newbula.xing.R;
import come.newbula.xing.ui.challenge.ChallengeFragment;
import come.newbula.xing.ui.findchallenge.FindChallengeFragment;
import come.newbula.xing.ui.pedestrianlist.PedestrianListFragment;
import come.newbula.xing.ui.personinfo.PersonInFoFragment;
import come.newbula.xing.ui.video.VideoFragment;


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

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏状态栏、标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);
        context=getApplication();
        ViewUtils.inject(this);
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

                Toast.makeText(context,"此功能暂未开发",Toast.LENGTH_SHORT).show();

//                setTabSelection(getString(R.string.video));
//                curFragmentTag=getString(R.string.video);
                break;
            case R.id.homePedestrianRelative: // 行人榜
                setTabSelection(getString(R.string.pedestrian_list));
                curFragmentTag=getString(R.string.pedestrian_list);
                break;
            case R.id.homeMineRelative: // 我
                setTabSelection(getString(R.string.mine));
                curFragmentTag=getString(R.string.mine);
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


}
