package com.acarolabs.a3dent.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.acarolabs.a3dent.Activities.RedimirActivity;
import com.acarolabs.a3dent.Models.Point;
import com.acarolabs.a3dent.Models.Redimir;
import com.acarolabs.a3dent.R;

import java.util.ArrayList;

/**
 * Created by personal on 24/05/15.
 */
public class PointsAdapter extends RecyclerView.Adapter<PointsAdapter.ViewHolder> {

    public static Activity activity;
    public static ArrayList<Point> listaPoint;
    private int itemLayout;

    public PointsAdapter(ArrayList<Point> data, int itemLayout, Activity activity) {
        super();
        this.itemLayout = itemLayout;
        this.listaPoint = data;
        this.activity = activity;
    }

    @Override
    public PointsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(PointsAdapter.ViewHolder holder, int position) {

        Point point = listaPoint.get(position);
        holder.descripcion.setText(point.getService());
        holder.puntos.setText(Integer.toString(point.getPoints()));
        holder.itemView.setTag(point);
        holder.propiedades = point;


    }

    @Override
    public int getItemCount() {
        return listaPoint.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView descripcion;
        public TextView puntos;
        public Point propiedades;

        public ViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imageViewPoints);
            descripcion = (TextView) itemView.findViewById(R.id.txtDescribePoints);
            puntos = (TextView) itemView.findViewById(R.id.txtPointsPoints);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Intent i = new Inten
                    Intent i = new Intent (activity, RedimirActivity.class);
                    i.putExtra("total",getTotalPoints());
                    i.putExtra("service",propiedades.getService());
                    i.putExtra("point",propiedades.getPoints());

                    //i.putExtra("nombre", propiedades.getNombreEmpresa());
                    activity.startActivity(i);


                    // Toast.makeText(view.getContext(),"llave de consulta: "+ propiedades.getWebsafeKey(),Toast.LENGTH_SHORT).show();
                }
            });


        }

    }
    public static  int getTotalPoints(){
        int total = 0;
        for (int i = 0; i < listaPoint.size(); i++) {
            total += listaPoint.get(i).getPoints();
        }
        return total;
    }
}