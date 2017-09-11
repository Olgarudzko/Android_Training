package com.rudzko.firstapp.hw_14;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.base.BaseSpinnerAdapter;

import butterknife.ButterKnife;


/**
 * @author Olga Rudzko
 */

public class MySpinnerAdapter extends BaseSpinnerAdapter<MyCountry> {

    @Override
    public long getItemId(int position) {
        return this.list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.spinner_line, parent, false);
        }

        MyCountry country = this.list.get(position);

        TextView code = (TextView)convertView.findViewById(R.id.country_code);
        code.setText(country.getName());

        return convertView;
    }
}
