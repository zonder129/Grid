package com.example.owner.grid;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Serializable {

        private String[] values;
        private Context context1;
        private ItemClickListener itemClickListener;

        private List<Integer> idValuesPicked = new ArrayList<>();

        RecyclerViewAdapter(Context context2, String[] values2, ItemClickListener clickListener){

            values = values2;

            context1 = context2;
            itemClickListener = clickListener;
        }

        static class ViewHolder extends RecyclerView.ViewHolder{

            TextView textView;

            ViewHolder(View v){

                super(v);

                textView = v.findViewById(R.id.textview1);

            }
        }

        @NonNull
        @Override
        public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

            View view1 = LayoutInflater.from(context1).inflate(R.layout.recycler_view_items,parent,false);

            return new ViewHolder(view1);
        }


        @Override
        public void onBindViewHolder(@NonNull final ViewHolder vholder, final int position){

            vholder.textView.setText(values[position]);
            vholder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    v.setBackgroundColor(Color.GREEN);
                    itemClickListener.onItemClick(values[vholder.getAdapterPosition()]);
                }
            });

        }

        @Override
        public int getItemCount() {

            return values.length;
        }
}
