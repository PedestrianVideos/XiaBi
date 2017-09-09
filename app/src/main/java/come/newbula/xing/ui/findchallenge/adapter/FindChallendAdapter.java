package come.newbula.xing.ui.findchallenge.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import come.newbula.xing.R;

/**
 *  比一比适配器
 */

public class FindChallendAdapter extends BaseAdapter {

    Context context;

    public FindChallendAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 5;
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
            convertView = View.inflate(context, R.layout.item_find_challenge_list,null);
        }

        return convertView;
    }
}
