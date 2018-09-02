package com.example.thallescezar.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ItemHolder> {

    Context context;
    List<String> itemList;

    public MyAdapter(List<String> itemList, Context context){
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View textView = LayoutInflater.from(this.context).inflate(R.layout.item_list, viewGroup, false);
        ItemHolder itemHolder = new ItemHolder(textView);

        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int position) {
        itemHolder.setText(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public void updateItemList(List<String> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }
}
