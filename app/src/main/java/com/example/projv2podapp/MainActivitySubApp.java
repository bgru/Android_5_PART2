package com.example.projv2podapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivitySubApp extends AppCompatActivity {

    final String operation = "addition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showToast("Starting " + operation + " operation");
        Intent data = getIntent();
        if (!data.hasExtra("key1")) {
            showToast("no arguments");
            finish();
            return;
        }
        int arg1 = Integer.parseInt(data.getStringExtra("key1"));
        int arg2 = Integer.parseInt(data.getStringExtra("key2"));
        showToast("arguments: arg1: " + arg1 + ", arg2: " + arg2);

        Intent result = new Intent();
        result.putExtra("operation", operation.toString());
        int addedArgs = arg1 + arg2;
        result.putExtra("result", arg1 + arg2);
        setResult(Activity.RESULT_OK, result);
        finish();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}