package com.soucriador.jhonattas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.poliveira.apps.materialtests.NavigationDrawerCallbacks;
import com.poliveira.apps.materialtests.NavigationDrawerFragment;
import com.soucriador.jhonattas.ui.Introduction;


public class Main extends ActionBarActivity implements NavigationDrawerCallbacks {

    Toolbar main_toolbar;
    NavigationDrawerFragment navigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        main_toolbar = (Toolbar) findViewById(R.id.criador_toolbar_actionbar);
        setSupportActionBar(main_toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        navigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.criador_fragment_drawer);
        navigationDrawerFragment.setup(R.id.criador_fragment_drawer, (DrawerLayout) findViewById(R.id.criador_drawer), main_toolbar );
        Intent i = new Intent(this, Introduction.class);
        //startActivity();
        //finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_a_main, menu);
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
    public void onNavigationDrawerItemSelected(int position) {
        Toast.makeText(this, "MenuItem selected -> " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed(){
        if(navigationDrawerFragment.isDrawerOpen()){
            navigationDrawerFragment.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
