package com.soucriador.jhonattas.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.soucriador.jhonattas.R;

public class SectionsActivity extends ActionBarActivity implements NavigationDrawerCallbacks {

    boolean exit = false;
    Toolbar main_toolbar;
    NavigationDrawerFragment navigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);

        main_toolbar = (Toolbar) findViewById(R.id.criador_toolbar_actionbar);
        setSupportActionBar(main_toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        main_toolbar.setBackgroundColor(getResources().getColor(R.color.color_primary));

        navigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.criador_fragment_drawer);
        navigationDrawerFragment.setup(R.id.criador_fragment_drawer, (DrawerLayout) findViewById(R.id.criador_drawer), main_toolbar);
        //Intent i = new Intent(this, IntroductionActivity.class);
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

        FragmentManager fragmentManager = getFragmentManager();
        // Toast.makeText(this, "MenuItem selected -> " + position, Toast.LENGTH_SHORT).show();

        switch (position){

            // projects
            case 0:
                // substitui o fragment
                fragmentManager.beginTransaction().replace(R.id.criador_container, EducationFragment.newInstance()).commit();
                // substitui o titulo
                setTitle(getString(R.string.section_projects));
                break;

            // education
            case 1:
                // substitui o fragment
                fragmentManager.beginTransaction().replace(R.id.criador_container, EducationFragment.newInstance()).commit();
                // substitui o titulo
                setTitle(getString(R.string.section_education));
                break;

            // work experience
            case 2:
                // substitui o fragment
                fragmentManager.beginTransaction().replace(R.id.criador_container, WorkExperienceFragment.newInstance()).commit();
                // substitui o titulo
                setTitle(getString(R.string.section_work_experience));
                break;

            // contact
            case 3:
                // substitui o fragment
                fragmentManager.beginTransaction().replace(R.id.criador_container, ContactFragment.newInstance()).commit();
                // substitui o titulo
                setTitle(getString(R.string.section_contact));
                break;

            // about me
            case 4:
                // substitui o fragment
                fragmentManager.beginTransaction().replace(R.id.criador_container, AboutMeFragment.newInstance()).commit();
                // substitui o titulo
                setTitle(getString(R.string.section_about_me));
                break;
        }

    }

    // no caso de o usuario clicar em voltar, ele exibe um toast para que o usuario confirme sua saida
    @Override
    public void onBackPressed(){
        if(navigationDrawerFragment.isDrawerOpen()){
            navigationDrawerFragment.closeDrawer();
        } else {
            if(!exit){
                Toast.makeText(this, getString(R.string.press_back_to_quit), Toast.LENGTH_SHORT).show();
                exit = true;
            } else {
                finish();
            }
            // super.onBackPressed();
        }
    }
}
