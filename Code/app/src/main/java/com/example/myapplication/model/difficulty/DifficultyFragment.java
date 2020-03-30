package com.example.myapplication.model.difficulty;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import org.w3c.dom.Text;

public class DifficultyFragment extends Fragment {

    private View view;
    private View test;

    /**
     *
     * @param inflater that is the layoutInflater
     * @return view, the fragment
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_difficulty,container,false);
        return view;

    }

    /**
     * Change the text of the textView on the fragment
     * @param text is the new text to set
     */
    public void setText(String text){
        TextView textView = view.findViewById(R.id.difficultyfragmenttextbox);

        textView.setText(text);

    }

    /**
     * Change the color of the fragment
     * @param color is the new color
     */
    public void setColor(int color){
        view.setBackgroundColor(getResources().getColor(color));
    }

}
