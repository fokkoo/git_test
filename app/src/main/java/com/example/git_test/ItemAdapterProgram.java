package com.example.git_test;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapterProgram extends RecyclerView.Adapter<ItemAdapterProgram.ItemViewHolderProgram> {

    private final CardSource dataSource;
    private OnItemClickListner listener;
    private static final String TAG = "onBindViewHolder";




    //private OnItemClickListener listener;
// private final String[] dataSource;
    public ItemAdapterProgram(CardSource dataSource) {
        this.dataSource = dataSource;
        Log.d(TAG, "ItemAdapter");
    }

    public void setListener(OnItemClickListner listener) {
        this.listener = listener;
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
        }


        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.program_item_recycler_view, parent, false);*/

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.program_item_recycler_view, parent, false);

        return new ItemViewHolderProgram(view);
    }

    @Override
    public int getItemViewType(int position) {
       /* if (position == 3){
           return 0;
        }else{
            return 1;
        }*/

        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolderProgram holder, int position) {
        Log.d(TAG,"onBindViewHolder"+position);
        holder.bind(dataSource.getCardData(position));


    /*   if (getItemViewType(position)==1){
           // holder.getImageView().setImageResource
   //     }
       holder.getTextView().setText(dataSource[position]);*/
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class ItemViewHolderProgram extends RecyclerView.ViewHolder{

        private final TextView textView;
        private final TextView titleProgram;
     //   private final TextView description;
        private final ImageView imageViewProgram;
      //  private final CheckBox like;

        public ItemViewHolderProgram(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.TextViewItemProgram);

             titleProgram = itemView.findViewById(R.id.ProgramTitle);;
           //  description = itemView.findViewById(R.id.description);;
            imageViewProgram = itemView.findViewById(R.id.ProgramImageView);;
         //    like = itemView.findViewById(R.id.like);;


        }

        public void bind(CardData cardData) {

            titleProgram.setText(cardData.getTitle());
          //  description.setText(cardData.getDescription());
            imageViewProgram.setImageResource(cardData.getPicture());
          //  like.setChecked(cardData.isLike());


            imageViewProgram.setOnClickListener(v -> listener.onItemClick(imageViewProgram, getLayoutPosition()));
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
        void onItemClick(ImageView imageViewProgram, int position);
    }
}
