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
        yeomanDB.execSQL("DROP TABLE Character;");
        yeomanDB.execSQL("CREATE TABLE IF NOT EXISTS Character(Name VARCHAR PRIMARY KEY,str INT, dex INT, con INT, inte INT, wis INT, cha INT);");
        yeomanDB.execSQL("INSERT INTO Character VALUES('Kasgar','16','15','15','11','9','10');");
        yeomanDB.execSQL("INSERT INTO Character VALUES('Elsa','12','14','18','16','14','18');");

        Cursor resultSet = yeomanDB.rawQuery("Select Name from Character",null);

        resultSet.moveToFirst();
        System.out.print(resultSet.getString(0));

        int i = 1;

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

       //nameList[0] = resultSet.getString(0);
       //System.out.print(nameList[i]);


        String[] fakeData =
                new String[]{"Happy",
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


        //create the adapter for the nameList array
        customListAdapter adapter = new customListAdapter(this, nameList);

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


