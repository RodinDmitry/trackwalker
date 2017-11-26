package com.example.eshlykov.trackwalker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SplashActivity extends AppCompatActivity {

    static final String OPERATOR_NAME = "operator_name";
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        String operator = getSharedPreferences(OPERATOR_NAME, MODE_APPEND).getString(OPERATOR_NAME, "");
        /*if (!operator.equals("")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }*/


        mEditText = (EditText) findViewById(R.id.editText);
        mEditText.setText(operator);
        Button button = (Button) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String operator = mEditText.getText().toString();
                if (operator.equals("")) return;
                SharedPreferences.Editor ed = getSharedPreferences(OPERATOR_NAME, MODE_APPEND).edit();
                ed.putString(OPERATOR_NAME, operator).commit();
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
