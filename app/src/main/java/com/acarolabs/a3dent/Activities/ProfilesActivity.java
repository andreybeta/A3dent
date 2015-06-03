package com.acarolabs.a3dent.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.acarolabs.a3dent.R;

public class ProfilesActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);
    }
    public void onClickSaveProfile(View view){

        //Ponit = (TextView) itemView.findViewById(R.id.txtPoint);


        Intent intent = new Intent(this,SaveProfileActivity.class);
        startActivity(intent);
    }
}
