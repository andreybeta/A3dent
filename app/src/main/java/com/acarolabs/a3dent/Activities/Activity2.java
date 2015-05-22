package com.acarolabs.a3dent.Activities;


import android.os.Bundle;


import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.acarolabs.a3dent.Adapters.ViewPagerAdapter;
import com.acarolabs.a3dent.Asyntask.BeneficiosTask;

import com.acarolabs.a3dent.Fragments.Tab1Fragment;
import com.acarolabs.a3dent.Fragments.Tab2Fragment;
import com.acarolabs.a3dent.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;


public class Activity2 extends ActionBarActivity implements MaterialTabListener {



    //private Tab1Fragment fragments = new Tab1Fragment();

   /* MaterialTabHost tabHost;
    ViewPager pager;
    ViewPagerAdapter adapter;
    CharSequence Titles[]={"Home","Events"};
    int Numboftabs =2;
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);
        toolbar.setTitle("A3Dent");
        setSupportActionBar(toolbar);





        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Beneficios", Tab1Fragment.class)
                .add("Puntos", Tab2Fragment.class)
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.

      /*  tabHost = (MaterialTabHost) this.findViewById(R.id.tabHost);
        pager = (ViewPager) this.findViewById(R.id.pager );

        adapter = new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                tabHost.setSelectedNavigationItem(position);

            }
        });
*/
        /*
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter)
        */
        //BeneficiosAdapter mAdapter = new BeneficiosAdapter()

       /* mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));   */              // Setting the layout Manager
        // Letting the system know that the list objects are of fixed size

       // Tab1Fragment fragments = new Tab1Fragment();
       // FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
// Replace the contents of the container with the new fragment
       // ft.replace(R.id.principal, fragments);
// or ft.add(R.id.your_placeholder, new FooFragment());
// Complete the changes added above
       // ft.commit();

      //  FragmentManager manager = getSupportFragmentManager();//llevar fragmnetos a nivel de cofigo



     /*   FragmentTransaction fragmentTransaccion = getSupportFragmentManager().beginTransaction();//agregar , remover , pasar cosas al fragmento

        fragmentTransaccion.add(R.id.principal, fragments).hide(fragments);//por cada fragmento que tenga lo añado a la vista. hide()pa que no los muestre todos a lavez entnces mientras ocultalo

        fragmentTransaccion.show(fragments).commit();

*/
  //      new BeneficiosTask(this).execute();



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

    @Override
    public void onTabSelected(MaterialTab materialTab) {

    }

    @Override
    public void onTabReselected(MaterialTab materialTab) {

    }

    @Override
    public void onTabUnselected(MaterialTab materialTab) {

    }
}
