package com.example.layouts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_MAIN_SCREEN = "mainScreen";
    private static final String KEY_MEMORY_SCREEN = "memoryScreen";


    private TextView mainScreen;
    private TextView memoryScreen;
    private Calculator calculator;

    TextView textView;
    Button buttonAC, buttonC, buttonDividee, buttonMultiply, buttonPlus, buttonMinus, buttonPercent, buttonEqual, buttonDot, button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainScreen = findViewById(R.id.main_screen);
        memoryScreen = findViewById(R.id.memory_screen);
        calculator = new Calculator(mainScreen, memoryScreen);
        initViews();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_MAIN_SCREEN, mainScreen.getText().toString());
        outState.putString(KEY_MEMORY_SCREEN, memoryScreen.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mainScreen.setText(savedInstanceState.getString(KEY_MAIN_SCREEN));
        memoryScreen.setText(savedInstanceState.getString(KEY_MEMORY_SCREEN));
    }

    private void initViews(){
        initButtons();
        initTextViews();
    }

    private void initButtons(){
        buttonAC = (Button) findViewById(R.id.buttonAC);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonDividee = (Button) findViewById(R.id.buttonDividee);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonPercent = (Button) findViewById(R.id.buttonPercent);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);

        Button[] buttons = {buttonAC, buttonC, buttonDividee, buttonMultiply, buttonPlus, buttonMinus, buttonPercent, buttonEqual, buttonDot, button1, button2, button3, button4, button5, button6, button7, button8, button9, button0};
        for (Button button: buttons) {
            button.setOnClickListener(this);
        }
    }

    private void initTextViews(){
        textView = (TextView) findViewById(R.id.main_screen);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button0) {
            textView.setText("0");
        }
        if(view.getId() == R.id.button1) {
            textView.setText("1");
        }
        if(view.getId() == R.id.button2) {
            textView.setText("2");
        }
        if(view.getId() == R.id.button3) {
            textView.setText("3");
        }
        if(view.getId() == R.id.button4) {
            textView.setText("4");
        }
        if(view.getId() == R.id.button5) {
            textView.setText("5");
        }
        if(view.getId() == R.id.button6) {
            textView.setText("6");
        }
        if(view.getId() == R.id.button7) {
            textView.setText("7");
        }
        if(view.getId() == R.id.button8) {
            textView.setText("8");
        }
        if(view.getId() == R.id.button9) {
            textView.setText("9");
        }
        if(view.getId() == R.id.buttonAC) {
            textView.setText("0");
        }
        if(view.getId() == R.id.buttonC) {
            textView.setText("0");
        }
        if(view.getId() == R.id.buttonPlus) {
            textView.setText("+");
        }
        if(view.getId() == R.id.buttonMinus) {
            textView.setText("-");
        }
        if(view.getId() == R.id.buttonPercent) {
            textView.setText("%");
        }
        if(view.getId() == R.id.buttonDividee) {
            textView.setText("/");
        }
        if(view.getId() == R.id.buttonDot) {
            textView.setText(".");
        }
        if(view.getId() == R.id.buttonMultiply) {
            textView.setText("*");
        }
        if(view.getId() == R.id.buttonEqual) {
            textView.setText("=");
        }
    }
}
