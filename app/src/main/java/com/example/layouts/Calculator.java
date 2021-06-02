package com.example.layouts;

import android.widget.TextView;

public class Calculator {

    private TextView mainScreen;
    private TextView memoryScreen;

    public Calculator(TextView mainScreen, TextView memoryScreen) {
        this.mainScreen = mainScreen;
        this.memoryScreen = memoryScreen;
    }
}
