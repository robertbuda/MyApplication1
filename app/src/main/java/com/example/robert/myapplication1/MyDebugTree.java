package com.example.robert.myapplication1;

import timber.log.Timber;

/**
 * Created by Robert on 2018-03-07.
 */

public class MyDebugTree extends Timber.DebugTree {

    @Override
    protected String createStackElementTag(StackTraceElement element) {
        return String.format(" *** [L:%s] [M:%s] [C:%s]",
                element.getLineNumber(),
                element.getMethodName(),
                super.createStackElementTag(element));
    }
}
