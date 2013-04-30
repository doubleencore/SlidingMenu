package com.slidingmenu.lib;

import android.view.animation.Interpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;

public class WiggleInterpolator implements Interpolator {

    private boolean mReached = false;
    private Interpolator mDecelerateInterpolator = new DecelerateInterpolator();
    private Interpolator mBounceInterpolator = new BounceInterpolator();

    @Override
    public float getInterpolation(float t) {
        // The purpose of this is pretty simple :
        // - mDecelerateInterpolator for t < 0.33
        // - mBounceInterpolator for t >= 0.33
        if (t < 0.33) {
            return mDecelerateInterpolator.getInterpolation(t / 0.33f);
        } else {
            return 1f - mBounceInterpolator.getInterpolation((t - 0.33f) / 0.67f);
        }
    }

    public boolean endReached() {
        return mReached;
    }

    public void setEndReached(boolean set) {
        mReached = set;
    }

}