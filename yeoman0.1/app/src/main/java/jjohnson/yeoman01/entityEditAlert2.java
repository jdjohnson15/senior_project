package jjohnson.yeoman01;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;

/**
 * Created by Jesse Johnson on 2/25/2015.
 */
public class entityEditAlert2 extends DialogFragment {
    Activity myActivity;
   // @Override
    public Dialog onCreateDialog(Activity activity){
        //super(activity);
        myActivity = activity;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("And here you would edit it. But we haven't gotten to this part yet.").setNeutralButton("got it",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        return builder.create();
    }
}