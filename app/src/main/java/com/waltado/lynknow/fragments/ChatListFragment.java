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
import com.waltado.lynknow.adapters.ChatsRecyclerAdapter;
import com.waltado.lynknow.adapters.ContactsRecyclerAdapter;
import com.waltado.lynknow.adapters.ContactsRequestRecyclerAdapter;
import com.waltado.lynknow.adapters.PingsRecyclerAdapter;
import com.waltado.lynknow.customViews.LatoFontHeavyTextView;
import com.waltado.lynknow.objects.ChatCustomObject;
import com.waltado.lynknow.objects.ContactCustomObject;
import com.waltado.lynknow.objects.ContactRequestCustomObject;
import com.waltado.lynknow.objects.PingCustomObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatListFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private boolean requestListBoolean;
    private ImageView titleIconView;
    private LatoFontHeavyTextView titleTextView;

    public ChatListFragment() {
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

        ChatsRecyclerAdapter adapter = new ChatsRecyclerAdapter(getActivity(), chatCustomObjectArrayList);

        recyclerView.setAdapter(adapter);
        titleTextView.setText("Chats");
        titleIconView.setImageResource(R.drawable.ic_chat_theme);




        return rootView;
    }

    public void toggleRequestList(){

        if(requestListBoolean){

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

            ChatsRecyclerAdapter adapter = new ChatsRecyclerAdapter(getActivity(), chatCustomObjectArrayList);
            recyclerView.setAdapter(adapter);
            titleTextView.setText("Chats");
            titleIconView.setImageResource(R.drawable.ic_chat_theme);
            requestListBoolean = false;

        }else{


            ArrayList<PingCustomObject> PingCustomObjectArrayList = new ArrayList<>();
            PingCustomObjectArrayList.add(new PingCustomObject());
            PingCustomObjectArrayList.add(new PingCustomObject());
            PingCustomObjectArrayList.add(new PingCustomObject());
            PingCustomObjectArrayList.add(new PingCustomObject());
            PingCustomObjectArrayList.add(new PingCustomObject());
            PingCustomObjectArrayList.add(new PingCustomObject());
            PingCustomObjectArrayList.add(new PingCustomObject());
            PingCustomObjectArrayList.add(new PingCustomObject());
            PingCustomObjectArrayList.add(new PingCustomObject());

            PingsRecyclerAdapter adapter = new PingsRecyclerAdapter(getActivity(), PingCustomObjectArrayList);
            recyclerView.setAdapter(adapter);
            titleTextView.setText("Pings");
            titleIconView.setImageResource(R.drawable.ic_ping_theme);

            requestListBoolean = true;
        }

    }

}
