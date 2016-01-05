package com.example.tri.jsontoviewexample.customLayout;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by tri on 1/1/16.
 */
public class HorizontalLayout extends LinearLayout {

    public HorizontalLayout(Context context) {
        super(context);
        this.setOrientation(HORIZONTAL);
        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

}
