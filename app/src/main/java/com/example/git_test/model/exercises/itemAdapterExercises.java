package com.example.git_test.model.exercises;

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
import com.example.git_test.model.repetitionWorkout.CardRepetitionWorkout;
import com.example.git_test.model.repetitionWorkout.CardSourceRepetitionWorkout;
import com.example.git_test.model.repetitionWorkout.itemAdapterRepetitionWorkout;

public class itemAdapterExercises  extends RecyclerView.Adapter<itemAdapterExercises.ItemViewHolder> {

    private final CardSourceExersises dataSource;
    private itemAdapterExercises.OnItemClickListener listener;
    public static final String TAG = "ItemAdapter";

  //  public static String TestTextDeliteIt = "TestTextDeliteIt";
  //  public static final int TestIntDeliteIt = 0;

    public itemAdapterExercises(CardSourceExersises dataSource) {
        this.dataSource = dataSource;
        Log.d(TAG, "ItemAdapter");
    }

    public void setListener(@Nullable itemAdapterExercises.OnItemClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public itemAdapterExercises.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercisese_item_rw_card, parent, false);
        return new itemAdapterExercises.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemAdapterExercises.ItemViewHolder holder, int position) {

        holder.bind(dataSource.getCardData(position));

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView titleExercises;        // заголовок
        private final TextView descriptionExercises;    // описание
        private final ImageView pictureExercises;        // изображение

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            titleExercises = itemView.findViewById(R.id.ExersisesTitle);
            descriptionExercises = itemView.findViewById(R.id.ExercisesDescription);
            pictureExercises = itemView.findViewById(R.id.ExersisesImageView);
        }

        public void bind(CardExercises cardExercises) {

            titleExercises.setText(cardExercises.getTitleExercises());
            descriptionExercises.setText(cardExercises.getDescriptionExercises());
            pictureExercises.setImageResource(cardExercises.getPictureExercises());

        }


    }

    interface OnItemClickListener {
        void onItemClick(View view, int position); // which position is clicked
    }

}
