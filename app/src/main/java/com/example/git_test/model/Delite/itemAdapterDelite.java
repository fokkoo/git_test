package com.example.git_test.model.Delite;


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
import androidx.recyclerview.widget.RecyclerView;

import com.example.git_test.R;
import com.example.git_test.model.trainRecyclerView.CardDataTrain;
import com.example.git_test.model.trainRecyclerView.CardSourceTrain;
import com.example.git_test.model.trainRecyclerView.TrainFragment;

public class itemAdapterDelite extends RecyclerView.Adapter<itemAdapterDelite.ItemViewHolder> {

    private final CardSourceDelite dataSource;
    private OnItemClickListener listener;
    public static final String TAG = "ItemAdapter";



    public itemAdapterDelite(CardSourceDelite dataSource) {
        this.dataSource = dataSource;
        Log.d(TAG, "ItemAdapter");
    }


    public void setListener(@Nullable OnItemClickListener listener) {
        this.listener = listener;
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
    public void onBindViewHolder(@NonNull itemAdapterDelite.ItemViewHolder holder, int position) {

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

        public void bind(CardDataDelite cardData) {
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


    public interface OnItemClickListener {
        void onItemClick(View view, int position); // which position is clicked
    }


}




