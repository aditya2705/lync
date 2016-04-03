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
import com.waltado.lynknow.objects.ChatCustomObject;

import java.util.ArrayList;

/**
 * Created by SHWETHA on 24-02-2016.
 */
public class ChatsRecyclerAdapter extends RecyclerView.Adapter<ChatsCustomViewHolder> {

    private Context context;
    private ArrayList<ChatCustomObject> customObjectArrayList;

    public ChatsRecyclerAdapter(Context context, ArrayList<ChatCustomObject> customObjectArrayList) {
        this.context = context;
        this.customObjectArrayList = customObjectArrayList;
    }

    @Override
    public ChatsCustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_chat_item, parent, false);
        ChatsCustomViewHolder customViewHolder = new ChatsCustomViewHolder(v);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(ChatsCustomViewHolder holder, int position) {
        ChatCustomObject customObject = customObjectArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return customObjectArrayList.size();
    }
}

class ChatsCustomViewHolder extends RecyclerView.ViewHolder {

    public ChatsCustomViewHolder(View itemView) {
        super(itemView);
    }
}


