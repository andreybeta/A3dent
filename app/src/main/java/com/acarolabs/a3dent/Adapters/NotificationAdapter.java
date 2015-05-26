package com.acarolabs.a3dent.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.acarolabs.a3dent.Models.Notification;
import com.acarolabs.a3dent.R;

import java.util.ArrayList;



/**
 * Created by ASUS on 25/05/2015.
 */
public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private ArrayList<Notification> notifications;
    private int itemLayout;

    public NotificationAdapter(ArrayList<Notification> notifications,int itemLayout){
        this.notifications = notifications;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(itemLayout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Notification notification = notifications.get(i);
        viewHolder.titleNotification.setText(notification.getTitleNotification());
        viewHolder.descripNotification.setText(notification.getDescriptionNotification());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView titleNotification;
        public TextView descripNotification;
        public ViewHolder(View itemView) {
            super(itemView);
            titleNotification = (TextView) itemView.findViewById(R.id.lblTitleNotification);
            descripNotification = (TextView) itemView.findViewById(R.id.lblDescriptionNotification);
        }
    }
}
