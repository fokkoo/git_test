package com.example.git_test;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapterProgram extends RecyclerView.Adapter<ItemAdapterProgram.ItemViewHolderProgram> {

    private static final String TAG = "onBindViewHolder";
    private final String[] dataSource;
    private OnItemClickListner listner;

    public ItemAdapterProgram(String[] dataSource) {
        this.dataSource = dataSource;
    }

    public void setListner(OnItemClickListner listner) {
        this.listner = listner;
    }

    @NonNull
    @Override
    public ItemViewHolderProgram onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d(TAG,"onCreateViewHolder "+viewType);

        View view;
/*
        if (viewType == 0){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
            Log.d(TAG,"onCreateViewHolder viewType "+viewType);
        }else{
           // view = LayoutInflater.from(parent.getContext()).inflate(R.layout.program_item_recycler_view, parent, false);
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.program_item_recycler_view, parent, false);
            Log.d(TAG,"onCreateViewHolder viewType "+viewType);
        }*/


       // view = LayoutInflater.from(parent.getContext()).inflate(R.layout.program_item_recycler_view, parent, false);

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.program_item_recycler_view, parent, false);

        return new ItemViewHolderProgram(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 3){
           return 0;
        }else{
            return 1;
        }

      //  return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolderProgram holder, int position) {
        Log.d(TAG,"onBindViewHolder"+position);
        if (getItemViewType(position)==1){
           // holder.getImageView().setImageResource
        }
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

       /* public ImageView getImageView(){
            return imageView;
        }*/

    }


    // обработка нажатия на элемент

    interface OnItemClickListner{
        void onItemClick(int position);
    }
}
