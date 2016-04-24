package com.waltado.lynknow.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.waltado.lynknow.R;
import com.waltado.lynknow.activities.GroupDetailsActivity;
import com.waltado.lynknow.adapters.GroupsRecyclerAdapter;
import com.waltado.lynknow.adapters.GroupsRequestRecyclerAdapter;
import com.waltado.lynknow.customViews.LatoFontHeavyTextView;
import com.waltado.lynknow.interfaces.RecyclerItemClickListener;
import com.waltado.lynknow.objects.GroupCustomObject;
import com.waltado.lynknow.objects.GroupRequestCustomObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupListFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private boolean requestListBoolean;
    private ImageView titleIconView;
    private LatoFontHeavyTextView titleTextView, buttonTitleView;

    public GroupListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_recycler_view_with_title_button, container, false);

        titleIconView = (ImageView)rootView.findViewById(R.id.title_icon);
        titleTextView = (LatoFontHeavyTextView)rootView.findViewById(R.id.title_text);
        buttonTitleView = (LatoFontHeavyTextView)rootView.findViewById(R.id.title_button);
        buttonTitleView.setText("CREATE GROUP");

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), GroupDetailsActivity.class);
                startActivity(intent);
            }
        }));

        requestListBoolean = true;
        toggleRequestList();



        return rootView;
    }

    public void toggleRequestList(){

        if(requestListBoolean){

            ArrayList<GroupCustomObject> groupCustomObjectArrayList = new ArrayList<>();
            groupCustomObjectArrayList.add(new GroupCustomObject());
            groupCustomObjectArrayList.add(new GroupCustomObject());
            groupCustomObjectArrayList.add(new GroupCustomObject());
            groupCustomObjectArrayList.add(new GroupCustomObject());
            groupCustomObjectArrayList.add(new GroupCustomObject());
            groupCustomObjectArrayList.add(new GroupCustomObject());
            groupCustomObjectArrayList.add(new GroupCustomObject());
            groupCustomObjectArrayList.add(new GroupCustomObject());
            groupCustomObjectArrayList.add(new GroupCustomObject());

            GroupsRecyclerAdapter adapter = new GroupsRecyclerAdapter(getActivity(), groupCustomObjectArrayList);
            recyclerView.setAdapter(adapter);
            titleTextView.setText("My Groups");
            titleIconView.setImageResource(R.drawable.ic_group_theme);
            requestListBoolean = false;

        }else{


            ArrayList<GroupRequestCustomObject> groupRequestCustomObjectArrayList = new ArrayList<>();
            groupRequestCustomObjectArrayList.add(new GroupRequestCustomObject());
            groupRequestCustomObjectArrayList.add(new GroupRequestCustomObject());
            groupRequestCustomObjectArrayList.add(new GroupRequestCustomObject());
            groupRequestCustomObjectArrayList.add(new GroupRequestCustomObject());
            groupRequestCustomObjectArrayList.add(new GroupRequestCustomObject());
            groupRequestCustomObjectArrayList.add(new GroupRequestCustomObject());
            groupRequestCustomObjectArrayList.add(new GroupRequestCustomObject());
            groupRequestCustomObjectArrayList.add(new GroupRequestCustomObject());
            groupRequestCustomObjectArrayList.add(new GroupRequestCustomObject());

            GroupsRequestRecyclerAdapter adapter = new GroupsRequestRecyclerAdapter(getActivity(), groupRequestCustomObjectArrayList);
            recyclerView.setAdapter(adapter);
            titleTextView.setText("Requests");
            titleIconView.setImageResource(R.drawable.ic_group_add_theme);

            requestListBoolean = true;
        }

    }

}
