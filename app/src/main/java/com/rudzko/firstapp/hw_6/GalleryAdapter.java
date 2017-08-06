package com.rudzko.firstapp.hw_6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.rudzko.firstapp.R;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * @author Olga Rudzko
 */

class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.Holder> {

    private String[] url;
    private Context context;

    GalleryAdapter(String[] url) {
        this.url = url;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View cap = LayoutInflater.from(context).inflate(R.layout.item_grid, parent, false);
        return new Holder(cap);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.pb.setVisibility(View.VISIBLE);
        Glide.with(context).load(url[position])
                .bitmapTransform(new CenterCrop(context), new RoundedCornersTransformation(context, 30, 0))
                .into(holder.iv);

        holder.pb.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return url.length;
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView iv;
        ProgressBar pb;

        Holder(View itemView) {
            super(itemView);

            pb = (ProgressBar) itemView.findViewById(R.id.my_bar);

            iv = (ImageView) itemView.findViewById(R.id.gallery_element);
        }
    }
}
