package newbula.com.xing.ui.findchallenge;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import newbula.com.xing.R;


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
        view = inflater.inflate(R.layout.fragment_find_challenge, container, false);

        context = getActivity();
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
