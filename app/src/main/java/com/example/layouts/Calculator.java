package com.example.layouts;

import android.widget.TextView;

public class Calculator {

    private TextView mainScreen;
    private TextView memoryScreen;
    private String equality = "";

    public Calculator(TextView mainScreen, TextView memoryScreen) {
        this.mainScreen = mainScreen;
        this.memoryScreen = memoryScreen;
    }

    public void addToEquality(String key) {
        String input = mainScreen.getText().toString();
        String operation = String.format(" %s ", key);
        if (equality.length() > 3 && equality.endsWith(" ") && input.equals("")) {
            equality = equality.substring(0, equality.length() - 3);
        }
        equality = String.format("%s%s%s", equality, input, operation);
        memoryScreen.setText(equality);
        mainScreen.setText("");
    }

    public String calculate() {
        String[] equalitys = equality.split(" = ");
        String currentEqualitys = equalitys[equalitys.length - 1];
        String[] inputs = currentEqualitys.split(" ");
        double total = 0;
        String operator = "+";
        for (String value : inputs) {
            if (value.matches("([+\\-*/])")) {
                operator = value;
            } else if (!value.equals("=")) {
                switch (operator) {
                    case "+":
                        total += Double.parseDouble(value);
                        break;
                    case "-":
                        total -= Double.parseDouble(value);
                        break;
                    case "*":
                        total *= Double.parseDouble(value);
                        break;
                    case "/":
                        total /= Double.parseDouble(value);
                        break;
                }
            }
        }
        return String.valueOf(total);
    }

    public String getEquality() {
        return equality;
    }

    public void setEquality(String equality) {
        this.equality = equality;
    }
}

