package com.waltado.lynknow.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waltado.lynknow.R;
import com.waltado.lynknow.adapters.ChatsRecyclerAdapter;
import com.waltado.lynknow.objects.ChatCustomObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatListFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;

    public ChatListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        ArrayList<ChatCustomObject> chatCustomObjectArrayList = new ArrayList<>();
        chatCustomObjectArrayList.add(new ChatCustomObject());
        chatCustomObjectArrayList.add(new ChatCustomObject());
        chatCustomObjectArrayList.add(new ChatCustomObject());
        chatCustomObjectArrayList.add(new ChatCustomObject());
        chatCustomObjectArrayList.add(new ChatCustomObject());
        chatCustomObjectArrayList.add(new ChatCustomObject());
        chatCustomObjectArrayList.add(new ChatCustomObject());
        chatCustomObjectArrayList.add(new ChatCustomObject());
        chatCustomObjectArrayList.add(new ChatCustomObject());
        chatCustomObjectArrayList.add(new ChatCustomObject());
        chatCustomObjectArrayList.add(new ChatCustomObject());

        ChatsRecyclerAdapter adapter = new ChatsRecyclerAdapter(getActivity(), chatCustomObjectArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);




        return rootView;
    }

}
