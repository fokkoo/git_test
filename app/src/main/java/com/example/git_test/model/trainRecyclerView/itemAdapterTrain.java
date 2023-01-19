package com.example.git_test.model.trainRecyclerView;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.git_test.R;

public class itemAdapterTrain extends RecyclerView.Adapter<itemAdapterTrain.ItemViewHolder> {

    private final CardSourceTrain dataSource;
    private OnItemClickListener listener;
    public static final String TAG = "ItemAdapter";



    public itemAdapterTrain(CardSourceTrain dataSource) {
        this.dataSource = dataSource;
        Log.d(TAG, "ItemAdapter");
    }


    public void setListener(@Nullable OnItemClickListener listener) {
        this.listener = listener;
    }

    public void testVOID() {
        /// test method can be deleted
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        Log.d(TAG, "onCreateViewHolder" + viewType);
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.program_item_recycler_view_card_view, parent, false);
        return new ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull itemAdapterTrain.ItemViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder" + position);

        holder.bind(dataSource.getCardData(position));


    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView description;
        private final ImageView imageView;
        private final CheckBox like;
        //  private final ImageView imageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.ProgramTitle);
            description = itemView.findViewById(R.id.ProgramDescription);
            imageView = itemView.findViewById(R.id.ProgramImageView);
            like = itemView.findViewById(R.id.Programlike);
        }

        public void bind(CardDataTrain cardData) {
            title.setText(cardData.getTitle());
            description.setText(cardData.getDescription());
            imageView.setImageResource(cardData.getPicture());
            like.setChecked(cardData.isLike());


            imageView.setOnClickListener(v -> listener.onItemClick(imageView, getLayoutPosition()));

            Bundle bundle = new Bundle();
            bundle.putString("key","1");
            TrainFragment trainFragment = new TrainFragment();
            trainFragment.setArguments(bundle);

        }

    }


    interface OnItemClickListener {
        void onItemClick(View view, int position); // which position is clicked
    }


}




