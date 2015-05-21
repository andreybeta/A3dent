package com.acarolabs.a3dent.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.acarolabs.a3dent.Models.Redimir;

import java.util.ArrayList;

/**
 * Created by ASUS on 21/05/2015.
 */
public class RedimirAdapters extends RecyclerView.Adapter<RedimirAdapters.ViewHolder> {

    private ArrayList<Redimir> redimirs;
    private int itemLayout;


    public RedimirAdapters(Context context) {
        super(context);
    }

    public  RedimirAdapters(ArrayList<Redimir> redimirs,int itemLayout){
        this.redimirs = redimirs;
        this.itemLayout = itemLayout;

    }

    Ad


}
