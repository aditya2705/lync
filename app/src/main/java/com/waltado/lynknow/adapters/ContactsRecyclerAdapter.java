package com.waltado.lynknow.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.waltado.lynknow.R;
import com.waltado.lynknow.objects.ContactCustomObject;

import java.util.ArrayList;


public class ContactsRecyclerAdapter extends RecyclerView.Adapter<ContactsCustomViewHolder> {

    private Context context;
    private ArrayList<ContactCustomObject> customObjectArrayList;

    public ContactsRecyclerAdapter(Context context, ArrayList<ContactCustomObject> customObjectArrayList) {
        this.context = context;
        this.customObjectArrayList = customObjectArrayList;
    }

    @Override
    public ContactsCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_contact_item, parent, false);
        ContactsCustomViewHolder customViewHolder = new ContactsCustomViewHolder(v);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactsCustomViewHolder holder, int position) {
        ContactCustomObject customObject = customObjectArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return customObjectArrayList.size();
    }
}

class ContactsCustomViewHolder extends RecyclerView.ViewHolder {


    public ContactsCustomViewHolder(View itemView) {
        super(itemView);
    }
}


