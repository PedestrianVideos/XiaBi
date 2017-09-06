package come.newbula.xing.ui.challenge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import come.newbula.xing.R;

/**
 * 
 * 文 件 名:  HotFragmentAdapter.java
 * 版    权:  cttq
 * 描    述:  <热门adapter>
 * 版    本： <版本号> 
 * 创 建 人:  ma
 * 创建时间:  2017年8月21日
 */
public class HotFragmentAdapter extends BaseAdapter
{
    /**
     * Context
     */
    private Context mcontext;

    /**
     * 数据集合
     */
    private List<Map<String ,String>> list=new ArrayList<>();
//    private DisplayImageOptions options;



    public HotFragmentAdapter(Context context,List<Map<String ,String>> list
  )
    {
        this.mcontext = context;
        this.list = list;
    }
    
    @Override
    public int getCount()
    {
        return list.size();

    }
    
    @Override
    public Object getItem(int arg0)
    {
        return list.get(arg0);

    }
    
    @Override
    public long getItemId(int arg0)
    {
        return arg0;
    }
    
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        final Holder holder;
        if (convertView == null)
        {
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.item_hot_fragment, null);
            holder = new Holder();

//            holder.send_doctor=(TextView) convertView.findViewById(R.id.send_doctor);
            convertView.setTag(holder);
        }
        else
        {
            holder = (Holder)convertView.getTag();
        }

        return convertView;
    }


    class Holder
    {
        /**
         * 药品icon
         */
        private ImageView medicine_icon;
        /**
         * 药品名
         */
        private TextView medicine_name;
        /**
         * 本月销售
         */
        private TextView this_sales;
        /**
         * 已维护药店
         */
        private TextView pharmacy_counts;
        /**
         * 上月销售
         */
        private TextView last_sales;
        /**
         * 已发送医生
         * */
        private TextView doctor_counts;
        /**
         * 药店管理
         * */
        private TextView drugstore_management;
        /**
         * 发送给医生
         * */
        private TextView send_doctor;
    }



}
