package come.newbula.xing.utils.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 
 * 文 件 名:  MyListView.java
 * 版    权:  cttq
 * 描    述:  <重写listview 解决listview嵌套问题>
 * 版    本： <版本号> 
 * 创 建 人:  姜飞
 * 创建时间:  2015年10月14日
 */
public class MyListView extends ListView
{
    
    public MyListView(Context context, AttributeSet attrs)
    {
        
        super(context, attrs);
        
    }
    
    public MyListView(Context context)
    {
        
        super(context);
        
    }
    
    public MyListView(Context context, AttributeSet attrs, int defStyle)
    {
        
        super(context, attrs, defStyle);
        
    }
    
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        
        super.onMeasure(widthMeasureSpec, expandSpec);
        
    }
    
}
