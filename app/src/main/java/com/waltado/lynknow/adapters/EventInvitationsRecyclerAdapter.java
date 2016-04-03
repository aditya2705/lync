package com.waltado.lynknow.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waltado.lynknow.R;
import com.waltado.lynknow.objects.EventInvitationCustomObject;

import java.util.ArrayList;


public class EventInvitationsRecyclerAdapter extends RecyclerView.Adapter<EventInvitationsCustomViewHolder> {

    private Context context;
    private ArrayList<EventInvitationCustomObject> customObjectArrayList;

    public EventInvitationsRecyclerAdapter(Context context, ArrayList<EventInvitationCustomObject> customObjectArrayList) {
        this.context = context;
        this.customObjectArrayList = customObjectArrayList;
    }

    @Override
    public EventInvitationsCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_event_invitation_item, parent, false);
        EventInvitationsCustomViewHolder customViewHolder = new EventInvitationsCustomViewHolder(v);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(EventInvitationsCustomViewHolder holder, int position) {
        EventInvitationCustomObject customObject = customObjectArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return customObjectArrayList.size();
    }
}

class EventInvitationsCustomViewHolder extends RecyclerView.ViewHolder {


    public EventInvitationsCustomViewHolder(View itemView) {
        super(itemView);
    }
}



