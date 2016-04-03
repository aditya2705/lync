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
import com.waltado.lynknow.objects.LKMCustomObject;

import java.util.ArrayList;

/**
 * Created by SHWETHA on 24-02-2016.
 */
public class LKMRecyclerAdapter extends RecyclerView.Adapter<ContactsCustomViewHolder> {

    private Context context;
    private ArrayList<LKMCustomObject> customObjectArrayList;

    public LKMRecyclerAdapter(Context context, ArrayList<LKMCustomObject> customObjectArrayList) {
        this.context = context;
        this.customObjectArrayList = customObjectArrayList;
    }

    @Override
    public ContactsCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lkm_item, parent, false);
        ContactsCustomViewHolder customViewHolder = new ContactsCustomViewHolder(v);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactsCustomViewHolder holder, int position) {
        LKMCustomObject customObject = customObjectArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return customObjectArrayList.size();
    }
}

class LKMCustomViewHolder extends RecyclerView.ViewHolder {

    public LKMCustomViewHolder(View itemView) {
        super(itemView);
    }
}

