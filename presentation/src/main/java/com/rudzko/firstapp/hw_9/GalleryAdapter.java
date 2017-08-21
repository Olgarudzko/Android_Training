package com.rudzko.firstapp.hw_9;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.rudzko.firstapp.databinding.ItemViewmodelBinding;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * @author Olga Rudzko
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyItemHolder> {

    private ItemViewModel[] items;

    GalleryAdapter(ItemViewModel[] items) {
        this.items = items;
    }

    @Override
    public MyItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewmodelBinding binding = ItemViewmodelBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyItemHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(MyItemHolder holder, int position) {
        holder.binding.setItemModel(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }



    class MyItemHolder extends RecyclerView.ViewHolder {

        ItemViewmodelBinding binding;

        MyItemHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    @BindingAdapter({"bind:item_image"})
    public static void loadImg(ImageView view, String url) {
        Glide.with(view.getContext()).load(url)
                .bitmapTransform(new CenterCrop(view.getContext()),
                        new RoundedCornersTransformation(view.getContext(), 30, 0)).into(view);
    }
}
