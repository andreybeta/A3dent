package com.acarolabs.a3dent.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.view.View;
import android.widget.TextView;



import com.acarolabs.a3dent.Fragments.RedimirFragment;
import com.acarolabs.a3dent.R;

public class RedimirActivity extends ActionBarActivity {
    int total;
    int point;
    String service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redimir);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);
        toolbar.setTitle("A3Dent");
        setSupportActionBar(toolbar);
        total = getIntent().getIntExtra("total", 0);
        point = getIntent().getIntExtra("point",0);
        service = getIntent().getStringExtra("service");
        RedimirFragment fragment = (RedimirFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentRedimir);
        fragment.setAdapter(Integer.toString(total),Integer.toString(point),service);




    }

    public void dialog(View view){


       /* Intent intent = new Intent(this,Login.class);
        startActivity(intent);*/

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Redimir...");
        alertDialog.setMessage("Estás seguro?");

        alertDialog.setButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                // aquí puedes añadir funciones

            }
        });
        //alertDialog.setIcon(R.drawable.icon);
        alertDialog.show();


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_redimir, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
