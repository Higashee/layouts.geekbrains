package com.example.layouts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;


public class MainActivity extends AppCompatActivity {

    private static final String KEY_MAIN_SCREEN = "mainScreen";
    private static final String KEY_MEMORY_SCREEN = "memoryScreen";
    public static final String MY_PREFERENCES = "nightModePreferences";
    private static final String KEY_NIGHT_MODE = "nightMode";
    private static final String KEY_EQUALITY = "equality";
    SharedPreferences sharedPreferences;



    private TextView mainScreen;
    private TextView memoryScreen;
    private Calculator calculator;
    SwitchCompat changeTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);

        changeTheme = findViewById(R.id.change_theme);
        mainScreen = findViewById(R.id.main_screen);
        memoryScreen = findViewById(R.id.memory_screen);

        calculator = new Calculator(mainScreen, memoryScreen);

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
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_MAIN_SCREEN, mainScreen.getText().toString());
        outState.putString(KEY_MEMORY_SCREEN, memoryScreen.getText().toString());
        outState.putString(KEY_EQUALITY, calculator.getEquality());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mainScreen.setText(savedInstanceState.getString(KEY_MAIN_SCREEN));
        memoryScreen.setText(savedInstanceState.getString(KEY_MEMORY_SCREEN));
        calculator.setEquality(savedInstanceState.getString(KEY_EQUALITY));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != RESULT_CANCELED) {
            super.onActivityResult(requestCode, resultCode, data);
        } else if (resultCode == RESULT_OK) {
            saveNightModeState(data.getExtras().getBoolean(KEY_NIGHT_MODE));
            recreate();
        }
    }
    public void press(View view) {
        String input = mainScreen.getText().toString();
        Button button = (Button) view;
        switch (button.getId()) {
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
            case R.id.button0: {
                String last = !calculator.getEquality().isEmpty() ? calculator.getEquality().substring(calculator.getEquality().length() - 3) : "";
                if (last.contains("=")) {
                    Toast.makeText(this, "Enter operator", Toast.LENGTH_LONG).show();
                    break;
                }
                mainScreen.setText(String.format("%s%s", input, button.getText().toString()));
                break;
            }
            case R.id.buttonPlus:
            case R.id.buttonMinus:
            case R.id.buttonDividee:
            case R.id.buttonMultiply: {
                if (!calculator.getEquality().isEmpty() || !input.isEmpty()) {
                    calculator.addToEquality(button.getText().toString());
                }
                break;
            }
            case R.id.buttonEqual: {
                if (!calculator.getEquality().isEmpty() || !input.isEmpty()) {
                    calculator.addToEquality(button.getText().toString());
                    mainScreen.setText(calculator.calculate());
                }
            }
        }
    }

    public void clear(View view) {
        memoryScreen.setText("");
        mainScreen.setText("");
        calculator.setEquality("");
    }
}

