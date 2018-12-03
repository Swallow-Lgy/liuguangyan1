package com.bawei.liuguangyan1203;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitlleBar extends LinearLayout {
    private Context mContext;
    public TitlleBar(Context context) {
        super(context);
        mContext=context;
        init();
    }

    public TitlleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        init();
    }

    private void init() {
        View view = View.inflate(mContext,R.layout.titilebar,null);
       final EditText editText =  view.findViewById(R.id.edit);
       view.findViewById(R.id.image).setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               if (monButtonClickLister!=null){
                   monButtonClickLister.onButtonClick(editText.getText().toString());
               }
           }
       });
       addView(view);
    }

    //定义全局的成员变量
    onButtonClickLister monButtonClickLister;
    //定义方法
    public void setOnButtonClickLister(onButtonClickLister onButtonClickLister){
        monButtonClickLister=onButtonClickLister;
    }
    //定义接口
    public interface onButtonClickLister{
        void onButtonClick(String str);
    }
}
