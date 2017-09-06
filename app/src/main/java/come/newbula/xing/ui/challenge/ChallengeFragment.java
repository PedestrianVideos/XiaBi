package come.newbula.xing.ui.challenge;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.lidroid.xutils.ViewUtils;

import come.newbula.xing.R;
import come.newbula.xing.ui.challenge.fragments.HotFragment;
import come.newbula.xing.ui.challenge.fragments.NewestFragment;

/**
 * 文 件 名:  ChallengeFragment.java
 * 版    权:  xingren
 * 描    述:  <挑战fragment>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月21日
 */
public class ChallengeFragment extends Fragment implements View.OnClickListener
{
    /**
     * context
     */
    private Context context;
    /**
     * view
     */
    private View view;
    //用于对Fragment进行管理
    private FragmentManager fragmentManager;
    //热门
    private RelativeLayout rl_hot;
    private TextView tv_lines;
    //最新
    private RelativeLayout rl_newest;
    private TextView tv_lins;
    //FrameLayout
    private FrameLayout frameLayout;
    //热门Fragment
    private HotFragment hotfragment;
    //最新
    private NewestFragment newestfragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_challenge, container, false);
        context = getActivity();
        ViewUtils.inject(this,view);
        initView();
        init();
        return view;

    }

    private void init() {

        fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction  fragmentTransaction = fragmentManager.beginTransaction();
        if (hotfragment==null){
            hotfragment=new HotFragment();
        }
        fragmentTransaction.replace(R.id.frameLayout,hotfragment);
        fragmentTransaction.commit();
        tv_lines.setBackgroundColor(getResources().getColor(R.color.color_CF5730));
        tv_lins.setBackgroundColor(getResources().getColor(R.color.color_2B2E35));
    }

    private void initView() {
        rl_hot=(RelativeLayout)view.findViewById(R.id.rl_hot);
        rl_newest=(RelativeLayout)view.findViewById(R.id.rl_newest);
        frameLayout= (FrameLayout) view.findViewById(R.id.frameLayout);
        tv_lines= (TextView) view.findViewById(R.id.tv_lins1);
        tv_lins=(TextView)view.findViewById(R.id.tv_lins);
        rl_hot.setOnClickListener(this);
        rl_newest.setOnClickListener(this);
    }

    /**
     * 刷新页面数据
     * 首页点击使用
     * 返回类型:void
     */
    public void refreshData() {
//        loadMoreLayout.setCurrentPage(1);
//        loadData(1);
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction  fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.rl_hot: //热门
                if (hotfragment==null){
                    hotfragment=new HotFragment();
                }
                fragmentTransaction.replace(R.id.frameLayout,hotfragment);
                tv_lines.setBackgroundColor(getResources().getColor(R.color.color_CF5730));
                tv_lins.setBackgroundColor(getResources().getColor(R.color.color_2B2E35));
                break;

            case R.id.rl_newest: //最新
                if (newestfragment==null){
                    newestfragment=new NewestFragment();
                }
                fragmentTransaction.replace(R.id.frameLayout,newestfragment);
                tv_lines.setBackgroundColor(getResources().getColor(R.color.color_2B2E35));
                tv_lins.setBackgroundColor(getResources().getColor(R.color.color_CF5730));
                break;
        }
        fragmentTransaction.commit();
    }
}
