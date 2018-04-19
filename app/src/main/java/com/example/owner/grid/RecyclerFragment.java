package com.example.owner.grid;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class RecyclerFragment extends Fragment {

    public static String ARRAY = "array";

    public static String VALUES = "values";

    RecyclerView recyclerView;

    ItemClickListener itemClickListener = new MyListener();

    Context context;

    List<String> values = new ArrayList<>();

    RecyclerView.Adapter recyclerViewAdapter;

    RecyclerView.LayoutManager recyclerViewLayoutManager;

    String[] numbers = {
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11"
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = Objects.requireNonNull(container).getContext();

        final LinearLayout view = (LinearLayout) inflater.inflate(R.layout.portrait_fragment, container, false);

        recyclerView = view.findViewById(R.id.recycler_view1);

        Integer spanCount;

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 5;
        } else {
            spanCount = 3;
        }
        recyclerViewLayoutManager = new GridLayoutManager(context, spanCount);

        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(context,numbers, itemClickListener);

        recyclerView.setAdapter(recyclerViewAdapter);

        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(new ButtonListener());

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARRAY, numbers);
        outState.putStringArrayList(VALUES, (ArrayList<String>) values);
    }

    class MyListener implements ItemClickListener {
        @Override
        public void onItemClick(String value) {
            values.add(value);
        }
    }

    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            ResultFragment resultFragment = new ResultFragment();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(VALUES, (ArrayList<String>) values);
            Log.i("ALL ", values.toString());
            resultFragment.setArguments(bundle);
            Objects.requireNonNull(getFragmentManager()).beginTransaction().replace(R.id.container, resultFragment).
                    addToBackStack(null).commit();
        }
    }
}
