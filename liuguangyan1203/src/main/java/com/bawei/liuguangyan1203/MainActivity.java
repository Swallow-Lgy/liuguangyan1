package com.bawei.liuguangyan1203;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
     private SearchDao dao;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LayoutViewGroup lvg = findViewById(R.id.lvg);
        final LayoutViewGroup lvg1 = findViewById(R.id.lvg1);

      dao = new SearchDao(this);
        TitlleBar titlleBar = findViewById(R.id.title);
        titlleBar.setOnButtonClickLister(new TitlleBar.onButtonClickLister() {
            @Override
            public void onButtonClick(String str) {
                UUID uuid = UUID.randomUUID();
                final TextView tv = new TextView(MainActivity.this);
                tv.setText(str);
                tv.setTag(uuid);
                tv.setTextColor(Color.RED);
                tv.setTextSize(20);
                tv.setBackgroundResource(R.drawable.text_bg);
                lvg.addView(tv);
                dao.add(str);
                 tv.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Toast.makeText(MainActivity.this,tv.getText(),Toast.LENGTH_LONG).show();
                     }
                 });
            }
        });
        findViewById(R.id.del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.del();
                lvg.removeAllViews();
            }
        });
        for (int i=0;i<20;i++){
            final TextView tv = new TextView(MainActivity.this);
            tv.setText("热门"+i);
            tv.setTextColor(Color.RED);
            tv.setTextSize(20);
            tv.setBackgroundResource(R.drawable.text_bg);
            dao.add("热门"+i);
            lvg1.addView(tv);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,tv.getText(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
