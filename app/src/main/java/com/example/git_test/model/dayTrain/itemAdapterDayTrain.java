package com.example.git_test.model.dayTrain;

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
import com.example.git_test.model.trainRecyclerView.itemAdapterTrain;

public class itemAdapterDayTrain extends RecyclerView.Adapter<itemAdapterDayTrain.ItemViewHolder> {

    private final CardSourceDayTrain dataSource;
    private itemAdapterDayTrain.OnItemClickListener listener;
    public static final String TAG = "ItemAdapter";

    public itemAdapterDayTrain(CardSourceDayTrain dataSource) {
        this.dataSource = dataSource;
        Log.d(TAG, "ItemAdapter");
    }


    public void setListener(@Nullable itemAdapterDayTrain.OnItemClickListener listener) {
        this.listener = listener;
    }




    @NonNull
    @Override
    public itemAdapterDayTrain.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.train_list_item, parent, false);
        return new itemAdapterDayTrain.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemAdapterDayTrain.ItemViewHolder holder, int position) {
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
     //   private final CheckBox like;
        //  private final ImageView imageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.day_train_main_text);
            description = itemView.findViewById(R.id.day_train_secondary_text);
            imageView = itemView.findViewById(R.id.day_train_image);
          //  like = itemView.findViewById(R.id.Programlike);
        }

        public void bind(CardDataTrain cardData) {
            title.setText(cardData.getTitle());
            description.setText(cardData.getDescription());
            imageView.setImageResource(cardData.getPicture());
        //    like.setChecked(cardData.isLike());


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
