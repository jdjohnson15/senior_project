package jjohnson.yeoman01;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class editEntity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_entity);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // Get the name of Entity from user
        // For now, Kasgar is a safe value
        String entityName = "Kasgar";
        int[] entityStats = new int[6];

        SQLiteDatabase yeomanDB = openOrCreateDatabase("Yeoman",MODE_PRIVATE,null);
        Cursor resultSet = yeomanDB.rawQuery("Select * from Character WHERE Name = ?", new String[] {entityName});

        resultSet.moveToFirst();
        entityStats[0] = resultSet.getInt(0);
        System.out.println("Str: " + entityStats[0]);
        int i = 0;
        while (resultSet.moveToNext())
        {
            entityStats[i] = resultSet.getInt(0);
            System.out.println("Stat: " + entityStats[i]);
            i++;
        }
        // entityStats now contains the entity's stats.
        // In order:
        // 0 = str, 1 = dex, 2 = con, 3 = int, 4 = wis, 5 = cha
        // Just stick it into whatever to display it.

        // Get values from user, put them directly into entityStats (and entityName, if need be)





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_entity, menu);
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

    public void mainMenu (View view)
    {
        Intent intent = new Intent(this, MainViewScreen.class);
        startActivity(intent);
    }
}
