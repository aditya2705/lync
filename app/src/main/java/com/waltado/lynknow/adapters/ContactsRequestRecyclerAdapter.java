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
import com.waltado.lynknow.objects.ContactCustomObject;
import com.waltado.lynknow.objects.ContactRequestCustomObject;

import java.util.ArrayList;

/**
 * Created by SHWETHA on 24-02-2016.
 */
public class ContactsRequestRecyclerAdapter extends RecyclerView.Adapter<ContactsCustomViewHolder> {

    private Context context;
    private ArrayList<ContactRequestCustomObject> customObjectArrayList;

    public ContactsRequestRecyclerAdapter(Context context, ArrayList<ContactRequestCustomObject> customObjectArrayList) {
        this.context = context;
        this.customObjectArrayList = customObjectArrayList;
    }

    @Override
    public ContactsCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_contact_request_item, parent, false);
        ContactsCustomViewHolder customViewHolder = new ContactsCustomViewHolder(v);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactsCustomViewHolder holder, int position) {
        ContactRequestCustomObject customObject = customObjectArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return customObjectArrayList.size();
    }
}

class ContactsRequestCustomViewHolder extends RecyclerView.ViewHolder {


    public ContactsRequestCustomViewHolder(View itemView) {
        super(itemView);
    }
}

