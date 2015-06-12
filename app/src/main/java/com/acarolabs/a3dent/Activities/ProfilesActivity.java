package com.acarolabs.a3dent.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import com.acarolabs.a3dent.R;

public class ProfilesActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
    }
    public void onClickSaveProfile(View view){

        //Ponit = (TextView) itemView.findViewById(R.id.txtPoint);


        Intent intent = new Intent(this,SaveProfileActivity.class);
        startActivity(intent);
        

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_profiles, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings:
                return true;
            case R.id.action_contact:
                Intent intent = new Intent(this,ContactActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_profile:
                Intent intents = new Intent(this,ProfilesActivity.class);
                startActivity(intents);
            case R.id.action_quit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }
    }
}
