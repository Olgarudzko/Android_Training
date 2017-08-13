package com.rudzko.firstapp.cw_6;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rudzko.firstapp.R;

import java.util.ArrayList;


/**
 * @author Olga Rudzko
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    private String[] items;
    private ArrayList<Drawable> images;
    private OnItemClickListener listener;

    void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    MyAdapter(String[] items, ArrayList<Drawable> images) {
        this.items = items;
        this.images=images;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle, parent, false);
        Log.e("msg_cteate_holder", "onCreateViewHolder");
        return new Holder(root);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.e("msg_bind_holder", "onBindViewHolder: position " + position);
        final String item = items[position];
        holder.tV.setText(item);
        holder.iV.setBackground(images.get(position));

        holder.tV.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onItemClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.length;
    }

    static class Holder extends RecyclerView.ViewHolder {

        ImageView iV;
        TextView tV;

        Holder(View itemView) {
            super(itemView);
            iV = (ImageView) itemView.findViewById(R.id.pic);
            tV = (TextView) itemView.findViewById(R.id.label);
        }
    }

    interface OnItemClickListener{
        void onItemClick(String item);
    }

}
