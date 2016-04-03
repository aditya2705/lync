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
import com.waltado.lynknow.adapters.ContactsRecyclerAdapter;
import com.waltado.lynknow.adapters.ContactsRequestRecyclerAdapter;
import com.waltado.lynknow.customViews.LatoFontHeavyTextView;
import com.waltado.lynknow.objects.ContactCustomObject;
import com.waltado.lynknow.objects.ContactRequestCustomObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactListFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private boolean requestListBoolean = false;
    private ImageView titleIconView;
    private LatoFontHeavyTextView titleTextView;

    public ContactListFragment() {
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

            ArrayList<ContactCustomObject> contactCustomObjectArrayList = new ArrayList<>();
            contactCustomObjectArrayList.add(new ContactCustomObject());
            contactCustomObjectArrayList.add(new ContactCustomObject());
            contactCustomObjectArrayList.add(new ContactCustomObject());
            contactCustomObjectArrayList.add(new ContactCustomObject());
            contactCustomObjectArrayList.add(new ContactCustomObject());
            contactCustomObjectArrayList.add(new ContactCustomObject());
            contactCustomObjectArrayList.add(new ContactCustomObject());
            contactCustomObjectArrayList.add(new ContactCustomObject());
            contactCustomObjectArrayList.add(new ContactCustomObject());

            ContactsRecyclerAdapter adapter = new ContactsRecyclerAdapter(getActivity(), contactCustomObjectArrayList);
            recyclerView.setAdapter(adapter);
            titleTextView.setText("Friends");
            titleIconView.setImageResource(R.drawable.ic_person_theme);
            requestListBoolean = false;

        }else{


            ArrayList<ContactRequestCustomObject> contactRequestCustomObjectArrayList = new ArrayList<>();
            contactRequestCustomObjectArrayList.add(new ContactRequestCustomObject());
            contactRequestCustomObjectArrayList.add(new ContactRequestCustomObject());
            contactRequestCustomObjectArrayList.add(new ContactRequestCustomObject());
            contactRequestCustomObjectArrayList.add(new ContactRequestCustomObject());
            contactRequestCustomObjectArrayList.add(new ContactRequestCustomObject());
            contactRequestCustomObjectArrayList.add(new ContactRequestCustomObject());
            contactRequestCustomObjectArrayList.add(new ContactRequestCustomObject());
            contactRequestCustomObjectArrayList.add(new ContactRequestCustomObject());
            contactRequestCustomObjectArrayList.add(new ContactRequestCustomObject());

            ContactsRequestRecyclerAdapter adapter = new ContactsRequestRecyclerAdapter(getActivity(), contactRequestCustomObjectArrayList);
            recyclerView.setAdapter(adapter);
            titleTextView.setText("Requests");
            titleIconView.setImageResource(R.drawable.ic_person_add_theme);

            requestListBoolean = true;
        }

    }

}
