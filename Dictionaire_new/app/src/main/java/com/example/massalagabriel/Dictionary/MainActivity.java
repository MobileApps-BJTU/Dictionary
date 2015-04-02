package com.example.massalagabriel.Dictionary;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity
        implements  FirstFragment.OnFragmentInteractionListener {

    @Override





    public void sendPositionToFragment2(int position){

       getFragmentManager().beginTransaction()
               .replace(R.id.fragment_holder,
                       SecondFragment.newInstance(position))
               .addToBackStack(null)// faire revenir a l'ancien fragment
               .commit();

    }
    @Override
    public void onBackPresse(){

        FragmentManager fm = getFragmentManager();
        if(fm.getBackStackEntryCount() > 0){

            fm.popBackStack();
        }else{
            super.onBackPressed();
        }
        fm.popBackStack();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .add(R.id.fragment_holder,new FirstFragment())
                .commit();


         //   super.onCreate(savedInstanceState);
          //  setContentView(R.layout.activity_main);


            final Button History =
                    (Button) findViewById(R.id.history_button);




            History.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent fragment_firstIntent =new Intent(getApplicationContext(),
                            FirstFragment.class);
                    startActivity(fragment_firstIntent);
                }
            });


            final Button Search =
                    (Button) findViewById(R.id.search_button);




            Search.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent activity_result_fragmentIntent =new Intent(getApplicationContext(),
                            SecondFragment.class);
                    startActivity(activity_result_fragmentIntent);
                }
            });

        }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onFragment1ListItemClicked(int position) {

    }
}
