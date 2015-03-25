package jjohnson.yeoman01;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by Jesse Johnson on 2/25/2015.
 */
public class effectListAlert extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceStates){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("An issue occured with implementing this activity, so it has not been completed").setNeutralButton("laaaaaaaaaame", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // nothing
            }
        });

        return builder.create();
    }
}
