package jjohnson.yeoman01;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.database.sqlite.*;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainViewScreen extends ActionBarActivity implements AdapterView.OnItemClickListener {

    SQLiteDatabase yeomanDB;
    Cursor resultSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_screen);


        // Database Stuff
        yeomanDB = openOrCreateDatabase("Yeoman",MODE_PRIVATE,null);
        resultSet = yeomanDB.rawQuery("Select Name from Character",null);
        yeomanDB.execSQL("CREATE TABLE IF NOT EXISTS Character(Name VARCHAR PRIMARY KEY, lvl int, str INT, dex INT, con INT, inte INT, wis INT, cha INT, ac int, flat int, touch int, hp int, init int, spd int, fort int, ref int, will int, baseattack int);");


        //create the adapter for the nameList array

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_view_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Intent intent;
        DialogFragment alert;
        switch (item.getItemId())
        {
            case R.id.editEntity:
                alert = new entityEditAlert();
                alert.show(getSupportFragmentManager(), "edit effect alert");
                return true;
            case R.id.editEffect:
                alert = new entityEditAlert();
                alert.show(getSupportFragmentManager(), "edit entity alert");
                return true;
            case R.id.effectList:
                intent = new Intent(this, effectList.class);
                startActivity(intent);
                return true;
            case R.id.addEntity:
                intent = new Intent(this, createEntity.class);
                startActivity(intent);
                return true;
            case R.id.addEffect:
                alert = new effectAddAlert();
                alert.show(getSupportFragmentManager(), "add effect alert");
                intent = new Intent(this, editEffect.class);
                startActivity(intent);
                return true;
            case R.id.deleteEntity:
                alert = new entityDeleteAlert();
                alert.show(getSupportFragmentManager(), "delete entity alert");
                return true;
            case R.id.deleteEffect:
                alert = new effectDeleteAlert();
                alert.show(getSupportFragmentManager(), "delete effect alert");
                return true;
            case R.id.timer:
                alert = new timerAlert();
                alert.show(getSupportFragmentManager(), "timer alert");
                return true;
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DialogFragment alert = new mainViewAlert();
        alert.show(getSupportFragmentManager(), "main view alert");
    }


    public void refresh (View view){
        System.out.println("im gonna wreck it");
        int i = 1;
        int count = resultSet.getCount();
        System.out.println("Count: " + count);
        if (resultSet.getCount() != 0)
        {
            System.out.println("hi!");
            while (resultSet.moveToNext())
            {
                i++;
            }


            String[] nameList = new String[i]; //////////THIS NEEDS OPTIMIZED

            resultSet.moveToFirst();
            nameList[0] = resultSet.getString(0);

            i = 1;
            while (resultSet.moveToNext())
            {
                nameList[i] = resultSet.getString(0);
                System.out.println("Name: " + nameList[i]);
                i++;
            }
            customListAdapter adapter = new customListAdapter(this, nameList);

            ListView listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(adapter);



            listView.setOnItemClickListener(this);
        }
        else
        {

        }

    }
}


