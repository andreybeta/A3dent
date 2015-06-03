package com.acarolabs.a3dent.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acarolabs.a3dent.Adapters.GalleryAdapter;
import com.acarolabs.a3dent.Models.Gallery;
import com.acarolabs.a3dent.R;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {


    public GalleryFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<Gallery> galleryArrayList = new ArrayList<>();
        Gallery gallery = new Gallery();
        for(int i=0;i<10;i++) {
            gallery.setTitleGallery("RADIOGRAFÍAS PANORAMICAS");
            gallery.setDescriptionGallery("Hazte tu radiografía panorámica desde $16.000 pesos");
            galleryArrayList.add(gallery);
        }



        RecyclerView January = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_January);
        January.setAdapter(new GalleryAdapter(galleryArrayList,R.layout.row_gallery));
        January.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerView February = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_February);
        February.setAdapter(new GalleryAdapter(galleryArrayList,R.layout.row_gallery));
        February.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerView March = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_March);
        March.setAdapter(new GalleryAdapter(galleryArrayList,R.layout.row_gallery));
        March.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerView April = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_April);
        April.setAdapter(new GalleryAdapter(galleryArrayList,R.layout.row_gallery));
        April.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerView May = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_May);
        May.setAdapter(new GalleryAdapter(galleryArrayList,R.layout.row_gallery));
        May.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerView June = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_June);
        June.setAdapter(new GalleryAdapter(galleryArrayList,R.layout.row_gallery));
        June.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerView July = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_July);
        July.setAdapter(new GalleryAdapter(galleryArrayList,R.layout.row_gallery));
        July.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerView August = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_August);
        August.setAdapter(new GalleryAdapter(galleryArrayList,R.layout.row_gallery));
        August.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerView September = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_September);
        September.setAdapter(new GalleryAdapter(galleryArrayList,R.layout.row_gallery));
        September.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerView October = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_October);
        October.setAdapter(new GalleryAdapter(galleryArrayList,R.layout.row_gallery));
        October.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerView November = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_November);
        November.setAdapter(new GalleryAdapter(galleryArrayList,R.layout.row_gallery));
        November.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        RecyclerView December = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view_December);
        December.setAdapter(new GalleryAdapter(galleryArrayList,R.layout.row_gallery));
        December.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));







    }
}
