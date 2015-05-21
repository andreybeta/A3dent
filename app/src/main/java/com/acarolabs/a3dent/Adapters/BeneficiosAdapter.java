package com.acarolabs.a3dent.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.acarolabs.a3dent.Models.Beneficios;
import com.acarolabs.a3dent.R;

import java.util.List;

/**
 * Created by personal on 21/05/15.
 */
public class BeneficiosAdapter extends RecyclerView.Adapter<BeneficiosAdapter.ViewHolder> {
    public static Activity activity;
    public static List<Beneficios> listaBeneficios;
    private int  itemLayout;

    public BeneficiosAdapter(List<Beneficios> data, int itemLayout, Activity activity){
        super();
        this.itemLayout = itemLayout;
        this.listaBeneficios = data;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView descripcion;
        public TextView puntos;

        public ViewHolder(View itemView){
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imageView);
            descripcion =(TextView) itemView.findViewById(R.id.txtDescripcion);
            puntos =(TextView) itemView.findViewById(R.id.txtPuntos);




        }

    }
}
