package com.acarolabs.a3dent.Activities;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.acarolabs.a3dent.Asyntask.LoginTask;
import com.acarolabs.a3dent.R;

public class Login extends ActionBarActivity {


    private EditText editEmail, editPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editEmail = (EditText) findViewById(R.id.txtEmailLogin);
        editPassword = (EditText) findViewById(R.id.txtPasswordLogin);
    }


    public void onclick(View view) throws Exception {
        new LoginTask(this).execute("cortes.pablo@hotmail.es","secret");
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
        finish();

    }
 }


