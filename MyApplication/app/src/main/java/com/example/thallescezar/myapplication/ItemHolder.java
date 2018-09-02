package com.example.thallescezar.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ItemHolder extends RecyclerView.ViewHolder {

    TextView item;

    public ItemHolder(@NonNull View itemView) {
        super(itemView);
        item = itemView.findViewById(R.id.textViewItem);
    }

    public void setText(String text) {
        item.setText(text);
    }
}
