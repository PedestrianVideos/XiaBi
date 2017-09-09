package come.newbula.xing.ui.findchallenge;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

import come.newbula.xing.R;
import come.newbula.xing.ui.findchallenge.activity.SearchActivity;
import come.newbula.xing.ui.findchallenge.adapter.FindChallendAdapter;
import come.newbula.xing.utils.Views.LoopSwitch.AutoSwitchAdapter;
import come.newbula.xing.utils.Views.LoopSwitch.AutoSwitchView;
import come.newbula.xing.utils.Views.LoopSwitch.LoopModel;

/**
 * 文 件 名:  FindChallengeFragment.java
 * 版    权:  xingren
 * 描    述:  <找挑战fragment>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月21日
 */
public class FindChallengeFragment extends Fragment implements View.OnClickListener {

    /**
     * context
     */
    private Context context;

    /**
     * view
     */
    private View view;

    /**
     * 根布局
     */
    private ScrollView sv_find_challeng;

    /**
     * 轮播图控件
     */
    private AutoSwitchView mAutoSwitchView;

    /**
     * 比一比List
     */
    private ListView lvThan;

    /**
     * 轮播图数据集合
     */
    private List<LoopModel>  datas = new ArrayList<LoopModel>();

    /**
     * 轮播图适配器
     */
    private AutoSwitchAdapter autoSwitchAdapter;

    /**
     * 搜索
     */
    private RelativeLayout rlSearch;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if(null == view){
            view = inflater.inflate(R.layout.fragment_find_challenge, container, false);
        }
        context = getActivity();
        lvThan = (ListView) view.findViewById(R.id.lv_than);
        mAutoSwitchView = (AutoSwitchView) view.findViewById(R.id.loopswitch);
        rlSearch = (RelativeLayout) view.findViewById(R.id.rl_search);
        sv_find_challeng = (ScrollView) view.findViewById(R.id.sv_find_challeng);
        initview();
        initCarousel();
        return view;

    }

    /**
     * 初始化控件
     */
    private void initview() {
        lvThan.setAdapter(new FindChallendAdapter(context));
        autoSwitchAdapter = new AutoSwitchAdapter(context, datas);
        mAutoSwitchView.setAdapter(autoSwitchAdapter);

        rlSearch.setOnClickListener(this);
    }

    /**
     * 初始化轮播图数据
     */
    private void initCarousel() {
        LoopModel model = null;
        model = new LoopModel("第一张", R.mipmap.tp_1);
        datas.add(model);
        model = new LoopModel("第二张", R.mipmap.tp_2);
        datas.add(model);
        model = new LoopModel("第三张", R.mipmap.tp_3);
        datas.add(model);
        autoSwitchAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_search:
                Intent intent = new Intent(context, SearchActivity.class);
                startActivity(intent);
            break;
        }

    }
}
