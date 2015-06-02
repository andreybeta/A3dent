package com.acarolabs.a3dent.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.acarolabs.a3dent.Models.Rewards;
import com.acarolabs.a3dent.R;

import java.util.ArrayList;

/**
 * Created by personal on 21/05/15.
 */
public class RewardsAdapter extends RecyclerView.Adapter<RewardsAdapter.ViewHolder> {
    public static Activity activity;
    public static ArrayList<Rewards> listRewards;
    private int  itemLayout;

    public RewardsAdapter(ArrayList<Rewards> data, int itemLayout, Activity activity){
        super();
        this.itemLayout = itemLayout;
        this.listRewards = data;
        this.activity = activity;
    }

    @Override
    public RewardsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RewardsAdapter.ViewHolder holder, int position) {

        Rewards beneficio = listRewards.get(position);

        holder.image.setImageBitmap(beneficio.getImagen());
        holder.description.setText(beneficio.getBeneficios());
        holder.points.setText(beneficio.getPuntos());
        holder.itemView.setTag(beneficio);


    }

    @Override
    public int getItemCount() {
        return listRewards.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView description;
        public TextView points;

        public Rewards properties;

        public ViewHolder(View itemView){
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.imageViewRewards);
            description =(TextView) itemView.findViewById(R.id.txtRewardsDescription);
            points =(TextView) itemView.findViewById(R.id.txtRewardsPoints);



        }

    }
}
