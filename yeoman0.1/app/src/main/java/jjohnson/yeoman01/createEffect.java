package jjohnson.yeoman01;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class createEffect extends ActionBarActivity {


    String[] values = new String[18];

    EditText name;
    EditText level;
    EditText STR;
    EditText DEX;
    EditText CON;
    EditText INT;
    EditText WIS;
    EditText CHA;
    EditText HP;
    EditText init;
    EditText speed;
    EditText fort;
    EditText reflex;
    EditText will;
    EditText AC;
    EditText flatfoot;
    EditText touch;
    EditText baseattack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_effect);

        name = (EditText) findViewById(R.id.name);
        level = (EditText) findViewById(R.id.level);
        STR = (EditText) findViewById(R.id.STR);
        DEX = (EditText) findViewById(R.id.DEX);
        CON = (EditText) findViewById(R.id.CON);
        INT = (EditText) findViewById(R.id.INT);
        WIS = (EditText) findViewById(R.id.WIS);
        CHA = (EditText) findViewById(R.id.CHA);
        HP = (EditText) findViewById(R.id.HP);
        init = (EditText) findViewById(R.id.init);
        speed = (EditText) findViewById(R.id.speed);
        fort = (EditText) findViewById(R.id.fort);
        reflex = (EditText) findViewById(R.id.reflex);
        will = (EditText) findViewById(R.id.will);
        AC = (EditText) findViewById(R.id.AC);
        flatfoot = (EditText) findViewById(R.id.flatfoot);
        touch = (EditText) findViewById(R.id.touch);
        baseattack = (EditText) findViewById(R.id.baseattack);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_entity, menu);
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

    /*
        @Override
        public boolean onKey(View view, int keyCode, KeyEvent event) {

            EditText myEditText = (EditText) view;

            if (keyCode == 66) {
                    int index = 0;
                    int i;
                    int id = view.getId();
                    for (i = 0; i < 18; ++i) {
                        if (id == textFields[i].getId())
                            index = i;
                    }
                    System.out.println("index is " + index);
                    if ((index + 1) > 17)
                        index = -1;
                    textFields[index + 1].requestFocus();
                    return true;
            }
            return false; // pass on to other listeners.
        }
*/
    public void commit(View view) {


        values[0]   = name.getText().toString();
        values[1]   = level.getText().toString();
        values[2]   = STR.getText().toString();
        values[3]   = DEX.getText().toString();
        values[4]   = CON.getText().toString();
        values[5]   = INT.getText().toString();
        values[6]   = WIS.getText().toString();
        values[7]   = CHA.getText().toString();
        values[8]   = AC.getText().toString();
        values[9]   = flatfoot.getText().toString();
        values[10]  = touch.getText().toString();
        values[11]  = HP.getText().toString();
        values[12]  = init.getText().toString();
        values[13]  = speed.getText().toString();
        values[14]  = fort.getText().toString();
        values[15]  = reflex.getText().toString();
        values[16]  = will.getText().toString();
        values[17]  = baseattack.getText().toString();

        SQLiteDatabase yeomanDB = openOrCreateDatabase("Yeoman",MODE_PRIVATE,null);
//        yeomanDB.rawQuery("INSERT INTO CHARACTER VALUES(bobo,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)");

        yeomanDB.execSQL("INSERT INTO EFFECT VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?)", new String[] {values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8],values[9],values[10],values[11],values[12],values[13],values[14],values[15],values[16],values[17]});
        Cursor resultSet = yeomanDB.rawQuery("Select Name from Character",null);
        int count = resultSet.getCount();
        System.out.println("Count: " + count);
        Intent intent = new Intent(this, MainViewScreen.class);
        startActivity(intent);
    }
}





