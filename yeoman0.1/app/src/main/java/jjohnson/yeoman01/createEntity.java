package jjohnson.yeoman01;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


//public class createEntity extends ActionBarActivity implements OnKeyListener{
public class createEntity extends ActionBarActivity {

    //EditText[] textFields = new EditText[18];
    String[] values = new String[18];

    EditText name = (EditText) findViewById(R.id.name);
      //  name.setOnKeyListener(this );
   // name.setOnKeyListener(this);
    EditText level = (EditText) findViewById(R.id.level);
    EditText STR = (EditText) findViewById(R.id.STR);
    EditText DEX = (EditText) findViewById(R.id.DEX);
    EditText CON = (EditText) findViewById(R.id.CON);
    EditText INT = (EditText) findViewById(R.id.INT);
    EditText WIS = (EditText) findViewById(R.id.WIS);
    EditText CHA = (EditText) findViewById(R.id.CHA);
    EditText HP = (EditText) findViewById(R.id.HP);
    EditText init = (EditText) findViewById(R.id.init);
    EditText speed = (EditText) findViewById(R.id.speed);
    EditText fort = (EditText) findViewById(R.id.fort);
    EditText reflex = (EditText) findViewById(R.id.reflex);
    EditText will = (EditText) findViewById(R.id.will);
    EditText AC = (EditText) findViewById(R.id.AC);
    EditText flatfoot = (EditText) findViewById(R.id.flatfoot);
    EditText touch = (EditText) findViewById(R.id.touch);
    EditText baseattack = (EditText) findViewById(R.id.baseattack);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_entity);

        //  EditText[] textFields = new EditText[18];
/*
        textFields[0] = (EditText) findViewById(R.id.name);
        textFields[0].setOnKeyListener(this);
        textFields[1] = (EditText) findViewById(R.id.level);
        textFields[1].setOnKeyListener(this);
        textFields[2] = (EditText) findViewById(R.id.STR);
        textFields[2].setOnKeyListener(this);
        textFields[3] = (EditText) findViewById(R.id.DEX);
        textFields[3].setOnKeyListener(this);
        textFields[4] = (EditText) findViewById(R.id.CON);
        textFields[4].setOnKeyListener(this);
        textFields[5] = (EditText) findViewById(R.id.INT);
        textFields[5].setOnKeyListener(this);
        textFields[6] = (EditText) findViewById(R.id.WIS);
        textFields[6].setOnKeyListener(this);
        textFields[7] = (EditText) findViewById(R.id.CHA);
        textFields[7].setOnKeyListener(this);
        textFields[8] = (EditText) findViewById(R.id.HP);
        textFields[8].setOnKeyListener(this);
        textFields[9] = (EditText) findViewById(R.id.init);
        textFields[9].setOnKeyListener(this);
        textFields[10] = (EditText) findViewById(R.id.speed);
        textFields[10].setOnKeyListener(this);
        textFields[11] = (EditText) findViewById(R.id.fort);
        textFields[11].setOnKeyListener(this);
        textFields[12] = (EditText) findViewById(R.id.reflex);
        textFields[12].setOnKeyListener(this);
        textFields[13] = (EditText) findViewById(R.id.will);
        textFields[13].setOnKeyListener(this);
        textFields[14] = (EditText) findViewById(R.id.AC);
        textFields[14].setOnKeyListener(this);
        textFields[15] = (EditText) findViewById(R.id.flatfoot);
        textFields[15].setOnKeyListener(this);
        textFields[16] = (EditText) findViewById(R.id.touch);
        textFields[16].setOnKeyListener(this);
        textFields[17] = (EditText) findViewById(R.id.baseattack);
        textFields[17].setOnKeyListener(this);
*/

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
        values[8]   = HP.getText().toString();
        values[9]   = init.getText().toString();
        values[10]  = speed.getText().toString();
        values[11]  = fort.getText().toString();
        values[12]  = reflex.getText().toString();
        values[13]  = will.getText().toString();
        values[14]  = AC.getText().toString();
        values[15]  = flatfoot.getText().toString();
        values[16]  = touch.getText().toString();
        values[17]  = baseattack.getText().toString();

        SQLiteDatabase yeomanDB = openOrCreateDatabase("Yeoman",MODE_PRIVATE,null);
        yeomanDB.rawQuery("INSERT INTO CHARACTER VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",values);

    }
}





