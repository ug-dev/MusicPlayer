package com.ugcodes.musicplayer;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FragmentSearch extends Fragment {
    private RelativeLayout search_layout;
    private TextView searchTitle;
    private EditText searchEditText;
    private ImageView backButton, cancelButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        search_layout = view.findViewById(R.id.search_layout);
//        searchTitle = view.findViewById(R.id.searchBox_title);
//        searchEditText = view.findViewById(R.id.search_editText);
//        backButton = view.findViewById(R.id.search_back_button);
//        cancelButton = view.findViewById(R.id.search_cancel_button);

        search_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeSearchBox();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                defaultSearchBox();
                Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchEditText.getText().clear();
            }
        });

        return view;
    }

    private void defaultSearchBox() {
        searchTitle.setVisibility(View.VISIBLE);
        searchEditText.setVisibility(View.GONE);
        backButton.setVisibility(View.GONE);
        cancelButton.setVisibility(View.GONE);

        ObjectAnimator animX = ObjectAnimator
                .ofFloat(search_layout, "scaleX", 1f)
                .setDuration(200);

        ObjectAnimator animY = ObjectAnimator
                .ofFloat(search_layout, "scaleY", 1f)
                .setDuration(200);

        AnimatorSet animSet = new AnimatorSet();
        animSet.playTogether(animX, animY);
        animSet.start();
    }

    private void changeSearchBox() {
        searchTitle.setVisibility(View.GONE);
        searchEditText.setVisibility(View.VISIBLE);
        backButton.setVisibility(View.VISIBLE);
        cancelButton.setVisibility(View.VISIBLE);

        ObjectAnimator animX = ObjectAnimator
                .ofFloat(search_layout, "scaleX", 1.2f)
                .setDuration(200);

        ObjectAnimator animY = ObjectAnimator
                .ofFloat(search_layout, "scaleY", 1.2f)
                .setDuration(200);

        AnimatorSet animSet = new AnimatorSet();
        animSet.playTogether(animX, animY);
        animSet.start();
    }
}