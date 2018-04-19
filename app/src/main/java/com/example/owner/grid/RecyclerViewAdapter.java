package com.example.owner.grid;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Map;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

        private String[] numbers;
        private Context context;
        private ItemClickListener itemClickListener;
        private Map<Integer, String> idsToValuesMap;

        RecyclerViewAdapter(Context context, String[] numbers, Map<Integer, String> idsToValuesMap, ItemClickListener itemClickListener) {
            this.numbers = numbers;
            this.idsToValuesMap = idsToValuesMap;
            this.context = context;
            this.itemClickListener = itemClickListener;
        }

        static class ViewHolder extends RecyclerView.ViewHolder{

            TextView textView;

            ViewHolder(View view){
                super(view);
                textView = view.findViewById(R.id.textview1);
            }
        }

        @NonNull
        @Override
        public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view1 = LayoutInflater.from(context).inflate(R.layout.recycler_view_items, parent,false);

            return new ViewHolder(view1);
        }


        @Override
        public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
            viewHolder.textView.setText(numbers[position]);
            if(idsToValuesMap.containsKey(position)){
                viewHolder.itemView.setBackgroundColor(Color.CYAN);
            } else {
                viewHolder.itemView.setBackgroundColor(Color.WHITE);
            }
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    itemClickListener.onItemClick(viewHolder, view);
                }

            });

        }

        @Override
        public int getItemCount() {
            return numbers.length;
        }
}
