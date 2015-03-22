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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_screen);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // Database Stuff

        SQLiteDatabase yeomanDB = openOrCreateDatabase("Yeoman",MODE_PRIVATE,null);
        yeomanDB.execSQL("CREATE TABLE IF NOT EXISTS Character(Name VARCHAR,str INT);");
        yeomanDB.execSQL("INSERT INTO Character VALUES('Kasgar','50');");

        Cursor resultSet = yeomanDB.rawQuery("Select Name from Character",null);
        resultSet.moveToFirst();
        String name = resultSet.getString(0);


        //array of fake data

        String[] fakeData =
                new String[]{name,
                            "Sleepy",
                            "Dopey",
                            "Grumpy",
                            "Doc",
                            "Sneezy",
                            "Bashful",
                            "Thorin",
                            "Fili",
                            "Kili",
                            "Balin",
                            "Dwalin",
                            "Oin",
                            "Gloin",
                            "Dori",
                            "Nori",
                            "Ori",
                            "Bifur",
                            "Bofur",
                            "Bombur",
                            "Dain"};

        //create the adapter for fake data array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, R.id.name, fakeData);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
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
                alert = new entityAddAlert();
                alert.show(getSupportFragmentManager(), "add entity alert");
                intent = new Intent(this, editEntity.class);
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
}


