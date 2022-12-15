package com.example.git_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapterProgram extends RecyclerView.Adapter<ItemAdapterProgram.ItemViewHolderProgram> {

    private final String[] dataSource;

    public ItemAdapterProgram(String[] dataSource) {
        this.dataSource = dataSource;
    }


    @NonNull
    @Override
    public ItemViewHolderProgram onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.program_item_recycler_view, parent, false);
        return new ItemViewHolderProgram(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolderProgram holder, int position) {
        holder.getTextView().setText(dataSource[position]);
    }

    @Override
    public int getItemCount() {
        return dataSource.length;
    }

    public class ItemViewHolderProgram extends RecyclerView.ViewHolder{

        private final TextView textView;

        public ItemViewHolderProgram(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.TextViewItemProgram);
        }
        public TextView getTextView(){
            return textView;
        }
    }
}
