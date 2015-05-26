package com.acarolabs.a3dent.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acarolabs.a3dent.Adapters.NotificationAdapter;
import com.acarolabs.a3dent.Models.Notification;
import com.acarolabs.a3dent.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {


    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<Notification> notificationArrayList = new ArrayList<>();
        Notification notification = new Notification();
        notification.setTitleNotification("RADIOGRAFÍAS PANORAMICAS");
        notification.setDescriptionNotification("Hazte tu radiografía panorámica desde $16.000 pesos, manejamos la mejor tecnología y calidad odontológica.");
        notificationArrayList.add(notification);
        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_notification);
        recyclerView.setHasFixedSize( true);
        recyclerView.setAdapter(new NotificationAdapter(notificationArrayList,R.layout.row_notification));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
