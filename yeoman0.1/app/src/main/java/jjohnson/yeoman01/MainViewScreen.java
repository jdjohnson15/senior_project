package jjohnson.yeoman01;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
//import android.database;
//import android.database.sqlite;
import android.view.MenuItem;
import android.view.View;


public class MainViewScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_screen);
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
        switch (item.getItemId())
        {
            case R.id.editEntity:
                intent = new Intent(this, editEntity.class);
                startActivity(intent);
                return true;
            case R.id.editEffect:
                intent = new Intent(this, editEffect.class);
                startActivity(intent);
                return true;
            case R.id.effectList:
                intent = new Intent(this, effectList.class);
                startActivity(intent);
                return true;
        }
        return true;
    }
}
