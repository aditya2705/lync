package com.waltado.lynknow.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waltado.lynknow.R;
import com.waltado.lynknow.objects.GroupCustomObject;

import java.util.ArrayList;

public class GroupsRecyclerAdapter extends RecyclerView.Adapter<GroupsCustomViewHolder> {

    private Context context;
    private ArrayList<GroupCustomObject> customObjectArrayList;

    public GroupsRecyclerAdapter(Context context, ArrayList<GroupCustomObject> customObjectArrayList) {
        this.context = context;
        this.customObjectArrayList = customObjectArrayList;
    }

    @Override
    public GroupsCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_group_item, parent, false);
        GroupsCustomViewHolder customViewHolder = new GroupsCustomViewHolder(v);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(GroupsCustomViewHolder holder, int position) {
        GroupCustomObject customObject = customObjectArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return customObjectArrayList.size();
    }
}

class GroupsCustomViewHolder extends RecyclerView.ViewHolder {


    public GroupsCustomViewHolder(View itemView) {
        super(itemView);
    }
}



