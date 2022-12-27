package com.example.git_test;


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

public class itemAdapter2 extends RecyclerView.Adapter<itemAdapter2.ItemViewHolder2> {
    //
    //    public static final int VIEW_TYPE_IMAGE = 1;
    //   public static final int VIEW_TYPE_TEXT = 0;
    // public static final int NO_POSITION = -1;
    //  private int currentPosition = NO_POSITION; // позиция элемента для его последующего удаления
    //
    private final CardSource2 dataSource;

    private OnItemClickListener listener;
    public static final String TAG = "ItemAdapter";


    public itemAdapter2(CardSource2 dataSource) {
        this.dataSource = dataSource;
        Log.d(TAG, "ItemAdapter");
    }


    public void setListener(@Nullable OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        Log.d(TAG, "onCreateViewHolder" + viewType);
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.program_item_recycler_view_card_view, parent, false);
        return new ItemViewHolder2(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder2 holder, int position) {

        Log.d(TAG, "onBindViewHolder" + position);

        holder.bind(dataSource.getCardData(position));


    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }


    public class ItemViewHolder2 extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView description;
        private final ImageView imageView;
        private final CheckBox like;
        //  private final ImageView imageView;

        public ItemViewHolder2(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.imageView);
            like = itemView.findViewById(R.id.like);
        }

        public void bind(CardData cardData) {
            title.setText(cardData.getTitle());
            description.setText(cardData.getDescription());
            imageView.setImageResource(cardData.getPicture());
            like.setChecked(cardData.isLike());


            imageView.setOnClickListener(v -> listener.onItemClick(imageView, getLayoutPosition()));
        }
        //   imageView = itemView.findViewById(R.id.image);
    }

// 1:03

    interface OnItemClickListener {
        void onItemClick(View view, int position); // which position is clicked
    }

}




