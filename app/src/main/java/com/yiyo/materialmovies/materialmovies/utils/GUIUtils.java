package com.yiyo.materialmovies.materialmovies.utils;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.yiyo.materialmovies.materialmovies.R;

import butterknife.ButterKnife;

/**
 * Created by sumset on 27/05/15.
 */
public class GUIUtils {

    public static final int DEFAULT_DELAY = 30;

    public static void tintAndSetCompoundDrawable(Context context, @DrawableRes int drawableRes,
                                                  int color, TextView textView) {
        Resources res = context.getResources();
        int padding = (int) res.getDimension(R.dimen.activity_horizontal_margin);

        Drawable drawable = res.getDrawable(drawableRes);
        drawable.setColorFilter(color, PorterDuff.Mode.MULTIPLY);

        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null);

        textView.setCompoundDrawablePadding(padding);
    }

    public static ViewPropertyAnimator showViewByScale(View v) {
        ViewPropertyAnimator propertyAnimator = v.animate().setStartDelay(DEFAULT_DELAY)
                .scaleX(1).scaleY(1);
        return propertyAnimator;
    }

    public static void showViewByRevealEffect(View hiddenView, View centerPointView, int height) {
        int cx = (centerPointView.getLeft() + centerPointView.getRight())   / 2;
        int cy = (centerPointView.getTop()  + centerPointView.getBottom())  / 2;

        Animator anim = ViewAnimationUtils.createCircularReveal(
                hiddenView, cx, cy, 0, height);

        hiddenView.setVisibility(View.VISIBLE);
        anim.start();
    }

    public static void makeTheStatusbarTranslucent (Activity activity) {

        Window w = activity.getWindow();
        w.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        w.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    public static final ButterKnife.Setter<TextView, Integer> setter = new ButterKnife.Setter<TextView, Integer>() {
        @Override
        public void set(TextView view, Integer value, int index) {
            view.setTextColor(value);
        }
    };
}
