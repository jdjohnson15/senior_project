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
        builder.setMessage("This action will show you more information about this effect, and give you the option to add it to an entity").setNeutralButton("gotchya", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // nothing
            }
        });

        return builder.create();
    }
}
