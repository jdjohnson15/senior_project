package jjohnson.yeoman01;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by Jesse Johnson on 2/25/2015.
 */
public class entityEditAlert extends DialogFragment {
   // @Override
    public Dialog onCreateDialog(Bundle savedInstanceStates){
        //super(activity);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("This will bring up a list of game entities, then take you to the entity creation screen, where all fields are auto-filled with the entity's info.").setNeutralButton("cool story, bro", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        return builder.create();
    }
}