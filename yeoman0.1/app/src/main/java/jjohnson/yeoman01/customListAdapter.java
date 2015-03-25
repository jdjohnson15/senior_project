package jjohnson.yeoman01;

import android.content.Context;
import android.database.sqlite.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class customListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;


    public customListAdapter(Context context, String[] values) {
        super(context, android.R.layout.activity_list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());

        View rowView = inflater.inflate(R.layout.list_item, null);

        TextView name = (TextView) rowView.findViewById(R.id.name);
        TextView letter = (TextView) rowView.findViewById(R.id.letter);
        ImageView imageView = (ImageView) rowView.findViewById(android.R.id.icon);
        String letters;
        if (values[position].length() > 0){
           letters = values[position].substring(0,1);
        }
        else{
            letters = "!";
        }

        name.setText(values[position]);
        letter.setText(letters);


        return rowView;
    }


} 
