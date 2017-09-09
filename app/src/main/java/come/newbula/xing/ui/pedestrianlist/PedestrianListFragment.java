package come.newbula.xing.ui.pedestrianlist;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import come.newbula.xing.R;
import come.newbula.xing.ui.pedestrianlist.adapter.PedestrianAdapter;

/**
 * 文 件 名:  PedestrianListFragment.java
 * 版    权:  xingren
 * 描    述:  <行拍榜fragment>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月21日
 */
public class PedestrianListFragment extends Fragment
{

    /**
     * context
     */
    private Context context;

    /**
     * view
     */
    private View view;

    /**
     * 看一看布局
     */
    private ListView lvSee;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if(null == view){
            view = inflater.inflate(R.layout.fragment_pedestrian_list, container, false);
            context = getActivity();
        }

        lvSee = (ListView) view.findViewById(R.id.lv_see);

        lvSee.setAdapter(new PedestrianAdapter(context));
        return view;
    }

}
