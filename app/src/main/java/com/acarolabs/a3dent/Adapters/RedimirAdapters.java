package com.acarolabs.a3dent.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.acarolabs.a3dent.Models.Redimir;
import com.acarolabs.a3dent.R;

import java.util.ArrayList;

/**
 * Created by ASUS on 21/05/2015.
 */
public class RedimirAdapters extends RecyclerView.Adapter<RedimirAdapters.ViewHolder> {

    private ArrayList<Redimir> redimirs;
    private int itemLayout;



    public  RedimirAdapters(ArrayList<Redimir> redimirs,int itemLayout){
        this.redimirs = redimirs;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Redimir redimir = redimirs.get(i);
        viewHolder.Ponit.setText(redimir.getPoint());
        viewHolder.aux.setText(redimir.getAux());
        viewHolder.text.setText(redimir.getText());



    }

    @Override
    public int getItemCount() {
        return redimirs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView Ponit;
        public TextView aux;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);

            Ponit = (TextView) itemView.findViewById(R.id.txtPoint);
            aux = (TextView) itemView.findViewById(R.id.txtAux);
            text = (TextView) itemView.findViewById(R.id.txtText);
        }
    }


}
