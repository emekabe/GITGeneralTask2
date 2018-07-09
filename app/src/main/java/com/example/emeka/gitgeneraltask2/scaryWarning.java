package com.example.emeka.gitgeneraltask2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class scaryWarning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scary_warning);
    }

    public void OYA(View view)
    {
        Intent j = new Intent(this, Crypto.class);
        startActivity(j);
    }
}
