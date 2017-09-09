package come.newbula.xing.ui.pedestrianlist.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import come.newbula.xing.R;

/**
 * 看一看 模块适配器
 */

public class PedestrianAdapter extends BaseAdapter {

    Context context;

    public PedestrianAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null == convertView){
            convertView = View.inflate(context, R.layout.item_pedestrian_list,null);
        }
        return convertView;
    }
}
