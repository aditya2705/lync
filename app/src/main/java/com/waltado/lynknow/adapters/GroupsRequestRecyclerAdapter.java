package com.waltado.lynknow.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waltado.lynknow.R;
import com.waltado.lynknow.objects.GroupRequestCustomObject;

import java.util.ArrayList;

public class GroupsRequestRecyclerAdapter extends RecyclerView.Adapter<GroupsRequestCustomViewHolder> {

    private Context context;
    private ArrayList<GroupRequestCustomObject> customObjectArrayList;

    public GroupsRequestRecyclerAdapter(Context context, ArrayList<GroupRequestCustomObject> customObjectArrayList) {
        this.context = context;
        this.customObjectArrayList = customObjectArrayList;
    }

    @Override
    public GroupsRequestCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_group_request_item, parent, false);
        GroupsRequestCustomViewHolder customViewHolder = new GroupsRequestCustomViewHolder(v);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(GroupsRequestCustomViewHolder holder, int position) {
        GroupRequestCustomObject customObject = customObjectArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return customObjectArrayList.size();
    }
}

class GroupsRequestCustomViewHolder extends RecyclerView.ViewHolder {


    public GroupsRequestCustomViewHolder(View itemView) {
        super(itemView);
    }
}



