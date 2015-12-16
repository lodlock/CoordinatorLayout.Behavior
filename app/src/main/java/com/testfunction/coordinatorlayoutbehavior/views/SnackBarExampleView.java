package com.testfunction.coordinatorlayoutbehavior.views;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.testfunction.coordinatorlayoutbehavior.behaviors.SnackBarBehavior;

/**
 * Created by lodlock (iamhunted@gmail.com)
 * On 12/14/2015 2:54 PM
 * For the CoordinatorLayout Behavior (com.testfunction.coordinatorlayoutbehavior.views) project
 */
@CoordinatorLayout.DefaultBehavior(SnackBarBehavior.class)
public class SnackBarExampleView extends View {
    public SnackBarExampleView(Context context) {
        super(context);
    }

    public SnackBarExampleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SnackBarExampleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
