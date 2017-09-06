package come.newbula.xing.ui.challenge.fragments;



import android.app.Dialog;
import android.content.Context;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import come.newbula.xing.R;


/**
 * 文 件 名:  HotFragment.java
 * 版    权:  xingren
 * 描    述:  <热门fragment>
 * 版    本： <版本号>
 * 创 建 人:  ma
 * 创建时间:  2017年8月21日
 */
public class HotFragment extends Fragment implements View.OnClickListener
{
    /**
     * context
     */
    private Context context;
    /**
     * view
     */
    private View view;
    //listView
    private ListView lv_hot;
    //评论输入框
    private EditText ed_input;
    //dialog对象
    Dialog dialog;

    /**
     *  item 布局
     * */
    //评论
    private ImageView img_comment;
    //分享
    private ImageView img_share;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_hot, container, false);

        context = getActivity();
        initView();
        return view;
    }

    private void initView() {
//        lv_hot= (ListView) view.findViewById(R.id.lv_hot);
        img_comment= (ImageView) view.findViewById(R.id.img_comment);
        img_share= (ImageView) view.findViewById(R.id.img_share);

        img_comment.setOnClickListener(this);
        img_share.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_comment: //评论
                showDialog(R.layout.dialog_comment);
                TextView tv_send= (TextView) dialog.findViewById(R.id.tv_send);
                ed_input= (EditText) dialog.findViewById(R.id.ed_input);
                tv_send.setOnClickListener(this);

                break;
            case R.id.img_share: //分享
                showDialog(R.layout.dialog_share);
                break;
            case R.id.tv_send:  //发送
                ed_input.setText("");
                Toast.makeText(context,"发送成功",Toast.LENGTH_SHORT).show();
                break;



        }

    }

            /**
             * 底部弹框
             * */
    private void showDialog(int layoutResID){
         dialog = new Dialog(getContext(), R.style.BottomDialogTheme);

        //获得dialog的window窗口
        Window window = dialog.getWindow();
        //设置dialog在屏幕底部
        window.setGravity(Gravity.BOTTOM);
        //设置dialog弹出时的动画效果，从屏幕底部向上弹出
        window.setWindowAnimations(R.style.popupAnimation);
        window.getDecorView().setPadding(0, 0, 0, 0);
        //获得window窗口的属性
        android.view.WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
        //将自定义布局加载到dialog上
        dialog.setContentView(layoutResID);
        dialog.show();
    }


}
