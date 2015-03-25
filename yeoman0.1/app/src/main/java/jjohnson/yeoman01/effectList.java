package jjohnson.yeoman01;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class effectList extends ActionBarActivity implements AdapterView.OnItemClickListener{

    SQLiteDatabase yeomanDB;
    Cursor resultSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // refreshVoid();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_effect_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Intent intent;
        DialogFragment alert;
        /*
        switch (item.getItemId())
        {

            case R.id.effectList:
                intent = new Intent(this, effectList.class);
                startActivity(intent);
                return true;
            case R.id.addEntity:
                intent = new Intent(this, createEntity.class);
                startActivity(intent);
                return true;
            case R.id.addEffect:
                intent = new Intent(this, createEffect.class);
                startActivity(intent);
                return true;
            case R.id.timer:
                alert = new timerAlert();
                alert.show(getSupportFragmentManager(), "timer alert");
                return true;
            case R.id.clear:
                yeomanDB.execSQL("DROP TABLE CHARACTER;");
                System.out.println("Clear!");
                refreshVoid();
                return true;
        }*/
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DialogFragment alert = new mainViewAlert();
        alert.show(getSupportFragmentManager(), "main view alert");
    }

    public void refreshVoid (){

        setContentView(R.layout.activity_effect_list);

        yeomanDB.execSQL("CREATE TABLE IF NOT EXISTS Effect(Name VARCHAR PRIMARY KEY, lvl int, str INT, dex INT, con INT, inte INT, wis INT, cha INT, ac int, flat int, touch int, hp int, init int, spd int, fort int, ref int, will int, baseattack int);");
        resultSet = yeomanDB.rawQuery("Select Name from Effect",null);

        int i = 0;

        if (resultSet.getCount() != 0)
        {
            System.out.println("hi!");
            while (resultSet.moveToNext())
            {
                i++;
                System.out.println("i is : " +i);
            }


            String[] effectList = new String[i]; //////////THIS NEEDS OPTIMIZED

            resultSet.moveToFirst();
            effectList[0] = resultSet.getString(0);

            i = 1;
            while (resultSet.moveToNext())
            {
                effectList[i] = resultSet.getString(0);
                System.out.println("Name: " +effectList[i]);
                i++;
            }
            customListAdapter adapter = new customListAdapter(this, effectList);

            ListView listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(this);
        }
        else
        {

        }

    }

    public void refresh (View view){
        refreshVoid();
    }


    public void deleteWrapper(View view, SQLiteDatabase yeomanDB){
        TextView name = (TextView) findViewById(R.id.name);

        String nameString = name.getText().toString();
        System.out.println("name: " + nameString);
        yeomanDB.execSQL("DELETE FROM EFFECT WHERE NAME = ?", new String[]{nameString});
        refreshVoid();
    }
    public void delete(View view) {
        SQLiteDatabase yeomanDB = openOrCreateDatabase("Yeoman",MODE_PRIVATE,null);
        deleteWrapper(view, yeomanDB);
    }
}
