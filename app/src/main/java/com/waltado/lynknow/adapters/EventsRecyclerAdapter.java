package com.waltado.lynknow.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waltado.lynknow.R;
import com.waltado.lynknow.objects.EventCustomObject;

import java.util.ArrayList;


public class EventsRecyclerAdapter extends RecyclerView.Adapter<EventsCustomViewHolder> {

    private Context context;
    private ArrayList<EventCustomObject> customObjectArrayList;

    public EventsRecyclerAdapter(Context context, ArrayList<EventCustomObject> customObjectArrayList) {
        this.context = context;
        this.customObjectArrayList = customObjectArrayList;
    }

    @Override
    public EventsCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_event_item, parent, false);
        EventsCustomViewHolder customViewHolder = new EventsCustomViewHolder(v);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(EventsCustomViewHolder holder, int position) {
        EventCustomObject customObject = customObjectArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return customObjectArrayList.size();
    }
}

class EventsCustomViewHolder extends RecyclerView.ViewHolder {


    public EventsCustomViewHolder(View itemView) {
        super(itemView);
    }
}



