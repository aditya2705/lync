package com.waltado.lynknow.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.waltado.lynknow.R;
import com.waltado.lynknow.adapters.EventInvitationsRecyclerAdapter;
import com.waltado.lynknow.adapters.EventsRecyclerAdapter;
import com.waltado.lynknow.customViews.LatoFontHeavyTextView;
import com.waltado.lynknow.objects.EventCustomObject;
import com.waltado.lynknow.objects.EventInvitationCustomObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventListFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private boolean requestListBoolean;
    private ImageView titleIconView;
    private LatoFontHeavyTextView titleTextView;

    public EventListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_recycler_view_with_title, container, false);

        titleIconView = (ImageView)rootView.findViewById(R.id.title_icon);
        titleTextView = (LatoFontHeavyTextView)rootView.findViewById(R.id.title_text);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        requestListBoolean = true;
        toggleRequestList();




        return rootView;
    }

    public void toggleRequestList(){

        if(requestListBoolean){

            ArrayList<EventCustomObject> eventCustomObjectArrayList = new ArrayList<>();
            eventCustomObjectArrayList.add(new EventCustomObject());
            eventCustomObjectArrayList.add(new EventCustomObject());
            eventCustomObjectArrayList.add(new EventCustomObject());
            eventCustomObjectArrayList.add(new EventCustomObject());
            eventCustomObjectArrayList.add(new EventCustomObject());
            eventCustomObjectArrayList.add(new EventCustomObject());
            eventCustomObjectArrayList.add(new EventCustomObject());
            eventCustomObjectArrayList.add(new EventCustomObject());
            eventCustomObjectArrayList.add(new EventCustomObject());

            EventsRecyclerAdapter adapter = new EventsRecyclerAdapter(getActivity(), eventCustomObjectArrayList);
            recyclerView.setAdapter(adapter);
            titleTextView.setText("My Events");
            titleIconView.setImageResource(R.drawable.ic_event_theme);
            requestListBoolean = false;

        }else{


            ArrayList<EventInvitationCustomObject> eventInvitationCustomObjectArrayList = new ArrayList<>();
            eventInvitationCustomObjectArrayList.add(new EventInvitationCustomObject());
            eventInvitationCustomObjectArrayList.add(new EventInvitationCustomObject());
            eventInvitationCustomObjectArrayList.add(new EventInvitationCustomObject());
            eventInvitationCustomObjectArrayList.add(new EventInvitationCustomObject());
            eventInvitationCustomObjectArrayList.add(new EventInvitationCustomObject());
            eventInvitationCustomObjectArrayList.add(new EventInvitationCustomObject());
            eventInvitationCustomObjectArrayList.add(new EventInvitationCustomObject());
            eventInvitationCustomObjectArrayList.add(new EventInvitationCustomObject());
            eventInvitationCustomObjectArrayList.add(new EventInvitationCustomObject());

            EventInvitationsRecyclerAdapter adapter = new EventInvitationsRecyclerAdapter(getActivity(), eventInvitationCustomObjectArrayList);
            recyclerView.setAdapter(adapter);
            titleTextView.setText("Invitations");
            titleIconView.setImageResource(R.drawable.ic_event_invitation_theme);

            requestListBoolean = true;
        }

    }

}
