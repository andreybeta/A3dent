package com.acarolabs.a3dent.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.acarolabs.a3dent.Models.Gallery;
import com.acarolabs.a3dent.R;

import java.util.ArrayList;


/**
 * Created by ASUS on 02/06/2015.
 */
public class GalleryAdapter  extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>{
    public static ArrayList<Gallery> galleries;
    private int  itemLayout;

    public GalleryAdapter(ArrayList<Gallery> galleries,int itemLayout){
        this.galleries = galleries;
        this.itemLayout = itemLayout;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        Gallery gallery = galleries.get(i);
        viewHolder.titleGallery.setText(gallery.getTitleGallery());
        viewHolder.descriptionGallery.setText(gallery.getDescriptionGallery());
        viewHolder.imgGallery.setTag(gallery);
        //viewHolder.datetimeGallery.setText(gallery.getDateTimeGallery());
    }

    @Override
    public int getItemCount() {
        return galleries.size();
    }

    public  static  class  ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgGallery;
        public TextView  titleGallery;
        public TextView  descriptionGallery;
        public TextView  datetimeGallery;
        public ViewHolder(View itemView) {
            super(itemView);
            //            imagen = (ImageView) itemView.findViewById(R.id.imageView);
            imgGallery =  (ImageView)  itemView.findViewById(R.id.imgGallery);
            titleGallery = (TextView) itemView.findViewById(R.id.txtTitleGallery);
            descriptionGallery = (TextView) itemView.findViewById(R.id.txtDescriptionGallery);
            datetimeGallery = (TextView) itemView.findViewById(R.id.txtDateTimeGallery);

        }
    }
}
