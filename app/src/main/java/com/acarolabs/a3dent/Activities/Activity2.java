package com.acarolabs.a3dent.Activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.acarolabs.a3dent.Asyntask.BeneficiosTask;
import com.acarolabs.a3dent.Fragments.Tab1Fragment;
import com.acarolabs.a3dent.Models.Beneficios;
import com.acarolabs.a3dent.R;


public class Activity2 extends ActionBarActivity {

    private Tab1Fragment fragments = new Tab1Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);
        toolbar.setTitle("A3Dent");
        setSupportActionBar(toolbar);

        //BeneficiosAdapter mAdapter = new BeneficiosAdapter()

       /* mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));   */              // Setting the layout Manager
        // Letting the system know that the list objects are of fixed size

        Tab1Fragment fragments = new Tab1Fragment();

        FragmentManager manager = getFragmentManager();//llevar fragmnetos a nivel de cofigo
        FragmentTransaction fragmentTransaccion = manager.beginTransaction();//agregar , remover , pasar cosas al fragmento

        fragmentTransaccion.add(R.id.principal, fragments).hide(fragments);//por cada fragmento que tenga lo añado a la vista. hide()pa que no los muestre todos a lavez entnces mientras ocultalo

        fragmentTransaccion.show(fragments).commit();

        new BeneficiosTask(this).execute();




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
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
