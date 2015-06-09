package com.acarolabs.a3dent.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.acarolabs.a3dent.MainActivity;
import com.acarolabs.a3dent.R;

public class Login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void onclick(View view){
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
        finish();
    }
    //



}

