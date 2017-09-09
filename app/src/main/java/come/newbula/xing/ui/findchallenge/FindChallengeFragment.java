package come.newbula.xing.ui.findchallenge;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import come.newbula.xing.R;
import come.newbula.xing.ui.findchallenge.adapter.FindChallendAdapter;

/**
 * 文 件 名:  FindChallengeFragment.java
 * 版    权:  xingren
 * 描    述:  <找挑战fragment>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月21日
 */
public class FindChallengeFragment extends Fragment
{

    /**
     * context
     */
    private Context context;


    /**
     * view
     */
    private View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if(null == view){
            view = inflater.inflate(R.layout.fragment_find_challenge, container, false);
        }
        context = getActivity();

        ListView lvThan = (ListView) view.findViewById(R.id.lv_than);
        lvThan.setAdapter(new FindChallendAdapter(context));
        return view;

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
}
