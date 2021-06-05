package com.example.layouts;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_MAIN_SCREEN = "mainScreen";
    private static final String KEY_MEMORY_SCREEN = "memoryScreen";
    public static final String MY_PREFERENCES = "nightModePreferences";
    private static final String KEY_NIGHT_MODE = "nightMode";
    SharedPreferences sharedPreferences;


    private TextView mainScreen;
    private TextView memoryScreen;
    private Calculator calculator;
    SwitchCompat changeTheme;

    TextView textView;
    Button buttonAC, buttonC, buttonDividee, buttonMultiply, buttonPlus, buttonMinus, buttonEqual, button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);

        changeTheme = findViewById(R.id.change_theme);
        mainScreen = findViewById(R.id.main_screen);
        memoryScreen = findViewById(R.id.memory_screen);

        checkNightModeActivated();

        changeTheme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                saveNightModeState(true);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                saveNightModeState(false);
            }
            recreate();
        });
    }

    private void saveNightModeState(boolean nightMode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_NIGHT_MODE, nightMode).apply();
    }

    public void checkNightModeActivated() {
        if (sharedPreferences.getBoolean(KEY_NIGHT_MODE, false)) {
            changeTheme.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            changeTheme.setChecked(false);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

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

    private void initViews() {
        initButtons();
        initTextViews();
    }

    private void initButtons() {
        buttonAC = (Button) findViewById(R.id.buttonAC);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonDividee = (Button) findViewById(R.id.buttonDividee);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
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

        Button[] buttons = {buttonAC, buttonC, buttonDividee, buttonMultiply, buttonPlus, buttonMinus, buttonEqual, button1, button2, button3, button4, button5, button6, button7, button8, button9, button0};
        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
    }

    private void initTextViews() {
        textView = (TextView) findViewById(R.id.main_screen);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button0) {
            textView.setText("0");
        }
        if (view.getId() == R.id.button1) {
            textView.setText("1");
        }
        if (view.getId() == R.id.button2) {
            textView.setText("2");
        }
        if (view.getId() == R.id.button3) {
            textView.setText("3");
        }
        if (view.getId() == R.id.button4) {
            textView.setText("4");
        }
        if (view.getId() == R.id.button5) {
            textView.setText("5");
        }
        if (view.getId() == R.id.button6) {
            textView.setText("6");
        }
        if (view.getId() == R.id.button7) {
            textView.setText("7");
        }
        if (view.getId() == R.id.button8) {
            textView.setText("8");
        }
        if (view.getId() == R.id.button9) {
            textView.setText("9");
        }
        if (view.getId() == R.id.buttonAC) {
            textView.setText("0");
        }
        if (view.getId() == R.id.buttonC) {
            textView.setText("0");
        }
        if (view.getId() == R.id.buttonPlus) {
            textView.setText("+");
        }
        if (view.getId() == R.id.buttonMinus) {
            textView.setText("-");
        }
        if (view.getId() == R.id.buttonDividee) {
            textView.setText("/");
        }
        if (view.getId() == R.id.buttonMultiply) {
            textView.setText("*");
        }
        if (view.getId() == R.id.buttonEqual) {
            textView.setText("=");
        }
    }
}
