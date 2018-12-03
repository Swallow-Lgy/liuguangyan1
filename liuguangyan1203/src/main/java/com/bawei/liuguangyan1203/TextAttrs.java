package com.bawei.liuguangyan1203;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class TextAttrs extends TextView {
    public TextAttrs(Context context) {
        super(context);
    }

    public TextAttrs(Context context,  AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextAttrs);
        int color = typedArray.getColor(R.styleable.TextAttrs_textColor, Color.BLACK);
        float dimension = typedArray.getDimension(R.styleable.TextAttrs_textSize, 20);
        setTextColor(color);
        setTextSize(dimension);
    }
}
