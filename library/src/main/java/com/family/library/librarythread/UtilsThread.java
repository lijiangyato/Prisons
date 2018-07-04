package com.family.library.librarythread;

/**
 * Created by ThinkPad on 2018/6/13.
 */

import android.os.Handler;
import android.os.Looper;

public class UtilsThread extends Handler {
    private static UtilsThread instance = new UtilsThread(Looper.getMainLooper());

    protected UtilsThread(Looper looper) {
        super(looper);
    }

    public static UtilsThread getInstance() {
        return instance;
    }

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            runnable.run();
        } else {
            instance.post(runnable);
        }

    }
}