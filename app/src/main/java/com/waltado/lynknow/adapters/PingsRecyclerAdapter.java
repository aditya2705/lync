package com.waltado.lynknow.adapters;

/**
 * Created by SHWETHA on 26-02-2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waltado.lynknow.R;
import com.waltado.lynknow.objects.PingCustomObject;

import java.util.ArrayList;

/**
 * Created by SHWETHA on 24-02-2016.
 */
public class PingsRecyclerAdapter extends RecyclerView.Adapter<PingsCustomViewHolder> {

    private Context context;
    private ArrayList<PingCustomObject> customObjectArrayList;

    public PingsRecyclerAdapter(Context context, ArrayList<PingCustomObject> customObjectArrayList) {
        this.context = context;
        this.customObjectArrayList = customObjectArrayList;
    }

    @Override
    public PingsCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_ping_item, parent, false);
        PingsCustomViewHolder customViewHolder = new PingsCustomViewHolder(v);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(PingsCustomViewHolder holder, int position) {
        PingCustomObject customObject = customObjectArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return customObjectArrayList.size();
    }
}

class PingsCustomViewHolder extends RecyclerView.ViewHolder {

    public PingsCustomViewHolder(View itemView) {
        super(itemView);
    }
}




