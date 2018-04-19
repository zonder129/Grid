package com.example.owner.grid;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResultFragment extends Fragment {

    List<String> array;


    Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedInstanceState = getArguments();
        final LinearLayout view = (LinearLayout) inflater.inflate(R.layout.result_fragment, container, false);
        array = Objects.requireNonNull(savedInstanceState).getStringArrayList(RecyclerFragment.VALUES);
        context = Objects.requireNonNull(container).getContext();

        TextView textView = view.findViewById(R.id.textview2);

        StringBuilder stringBuilder = new StringBuilder();

        for (String anArray : array) {
            stringBuilder.append(anArray);
            stringBuilder.append(" ");
        }
        textView.setText(stringBuilder.toString());

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(RecyclerFragment.VALUES, (ArrayList<String>) array);
    }

}
