package com.example.git_test.model.repetitionWorkout;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.git_test.R;
import com.example.git_test.model.dayTrain.CardSourceDayTrain;
import com.example.git_test.model.trainRecyclerView.CardDataTrain;
import com.example.git_test.model.trainRecyclerView.TrainFragment;

public class itemAdapterRepetitionWorkout extends RecyclerView.Adapter<itemAdapterRepetitionWorkout.ItemViewHolder> {

    private final CardSourceRepetitionWorkout dataSource;
   // private itemAdapterRepetitionWorkout.OnItemClickListener listener;
    public static final String TAG = "ItemAdapter";

    public itemAdapterRepetitionWorkout(CardSourceRepetitionWorkout dataSource) {
        this.dataSource = dataSource;
        Log.d(TAG, "ItemAdapter");
    }




/*
    public void setListener(@Nullable itemAdapterRepetitionWorkout.OnItemClickListener listener) {
        this.listener = listener;
    }
*/



    @NonNull
    @Override
    public itemAdapterRepetitionWorkout.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repetition_workout_item_list, parent, false);
        return new itemAdapterRepetitionWorkout.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemAdapterRepetitionWorkout.ItemViewHolder holder, int position) {
       // holder.bind(dataSource.getCardData(position));

    }



    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
      //  private final TextView title;
      //  private final TextView description;
       // private final ImageView imageView;

        private final TextView numberSET;        // номер подхода
        private final TextView weight;        // вес снаряда
        private final TextView repetition;        // количество повторений

        /*
     private String titleWorkout;       // заголовок
    private String descriptionWorkout; // описание
    private int pictureWorkout;        // изображение
    private int numberSET;        // номер подхода
    private int weight;        // вес снаряда
    private int repetition;        // количество повторений
    private boolean likeWorkout;       // флажок

         */


     //   private final CheckBox like;
        //  private final ImageView imageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
          /*  title = itemView.findViewById(R.id.day_train_main_text);
            description = itemView.findViewById(R.id.day_train_secondary_text);
            imageView = itemView.findViewById(R.id.day_train_image);*/
          //  like = itemView.findViewById(R.id.Programlike);
            numberSET = itemView.findViewById(R.id.RepetitionWorkoutItemSet);
            weight = itemView.findViewById(R.id.RepetitionWorkoutItemRepetition);
            repetition = itemView.findViewById(R.id.RepetitionWorkoutItemListMainID);
        }

        public void bind(CardDataTrain cardDataTrain) {
            numberSET.setText(cardDataTrain.getTitle());
            weight.setText(cardDataTrain.getDescription());
            repetition.setText(cardDataTrain.getPicture());
        //    like.setChecked(cardData.isLike());


            /*
            imageView.setOnClickListener(v -> listener.onItemClick(imageView, getLayoutPosition()));

            Bundle bundle = new Bundle();
            bundle.putString("key","1");
            TrainFragment trainFragment = new TrainFragment();
            trainFragment.setArguments(bundle);
*/
        }

    }


}
