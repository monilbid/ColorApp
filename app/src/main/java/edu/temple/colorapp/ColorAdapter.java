package edu.temple.colorapp;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Monil on 10/23/17.
 */

public class ColorAdapter extends BaseAdapter {
    Context context;
    String[] colorValues;
    String[] colorNames;

    public ColorAdapter(Context context, String[] colorValues, String[] colorNames) {
        this.context = context;
        this.colorValues = colorValues;
        this.colorNames = colorNames;
    }

    @Override
    public int getCount() {
        return colorValues.length;
    }

    @Override
    public Object getItem(int i) {
        return colorValues[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        textView.setText(colorNames[i]);
        textView.setBackgroundColor(Color.parseColor(colorValues[i]));
        textView.setHeight(300);
        textView.setTextSize(30);
        if(!(colorValues[i].equals("YELLOW") || colorValues[i].equals("GREEN"))){
            textView.setTextColor(Color.WHITE);
        }
        textView.setGravity(11);
        textView.setPadding(20, 0, 0, 0);

        return textView;
    }
}
