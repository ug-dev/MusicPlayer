package com.ugcodes.musicplayer;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
    private RelativeLayout search_layout, search_back_layout;
    private TextView searchTitle;
    private EditText searchEditText;
    private ImageView backButton, cancelButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        search_layout = view.findViewById(R.id.search_layout);
        search_back_layout = view.findViewById(R.id.search_back_layout);
        searchTitle = view.findViewById(R.id.searchBox_title);
        searchEditText = view.findViewById(R.id.search_editText);
        backButton = view.findViewById(R.id.search_back_button);
        cancelButton = view.findViewById(R.id.search_cancel_button);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(charSequence.toString())) {
                    cancelButton.setVisibility(View.GONE);
                } else {
                    cancelButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        search_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeSearchBox();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchEditText.getText().clear();
                defaultSearchBox();
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
        search_layout.setVisibility(View.VISIBLE);
        search_back_layout.setVisibility(View.GONE);

        ObjectAnimator animX = ObjectAnimator
                .ofFloat(search_layout, "scaleX", 1f)
                .setDuration(200);

        ObjectAnimator animY = ObjectAnimator
                .ofFloat(search_layout, "scaleY", 1f)
                .setDuration(200);

        AnimatorSet animSet = new AnimatorSet();
        animSet.playTogether(animX, animY);
        animSet.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                searchTitle.setVisibility(View.VISIBLE);
            }
        }, 200);
    }

    private void changeSearchBox() {
        searchTitle.setVisibility(View.GONE);

        ObjectAnimator animX = ObjectAnimator
                .ofFloat(search_layout, "scaleX", 1.3f)
                .setDuration(200);

        ObjectAnimator animY = ObjectAnimator
                .ofFloat(search_layout, "scaleY", 1.3f)
                .setDuration(200);

        AnimatorSet animSet = new AnimatorSet();
        animSet.playTogether(animX, animY);
        animSet.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                search_layout.setVisibility(View.GONE);
                search_back_layout.setVisibility(View.VISIBLE);
            }
        }, 200);
    }
}