package com.waltado.lynknow.adapters;

/**
 * Created by SHWETHA on 26-02-2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.waltado.lynknow.R;
import com.waltado.lynknow.objects.ContactCustomObject;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by SHWETHA on 24-02-2016.
 */
public class ContactsRecyclerAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private ArrayList<ContactCustomObject> customObjectArrayList;

    public ContactsRecyclerAdapter(Context context, ArrayList<ContactCustomObject> customObjectArrayList) {
        this.context = context;
        this.customObjectArrayList = customObjectArrayList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_contact_item, parent, false);
        CustomViewHolder customViewHolder = new CustomViewHolder(v);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        ContactCustomObject customObject = customObjectArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return customObjectArrayList.size();
    }
}

class CustomViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTextView, descriptionTextView, timeTextView;
    public CircleImageView imageView;

    public CustomViewHolder(View itemView) {
        super(itemView);
        titleTextView = (TextView) itemView.findViewById(R.id.contact_title);
        descriptionTextView = (TextView) itemView.findViewById(R.id.contact_description);
        timeTextView = (TextView) itemView.findViewById(R.id.time_text);
        imageView = (CircleImageView) itemView.findViewById(R.id.image);
    }
}


