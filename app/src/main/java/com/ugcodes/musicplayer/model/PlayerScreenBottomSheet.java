package com.ugcodes.musicplayer.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ugcodes.musicplayer.R;

public class PlayerScreenBottomSheet extends BottomSheetDialogFragment {
    private RelativeLayout sleepTimer, like, liked;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player_screen_bottom_sheet, container, false);

        sleepTimer = view.findViewById(R.id.player_screen_sleep_timer);
        like = view.findViewById(R.id.player_screen_like);
        liked = view.findViewById(R.id.player_screen_liked);

        sleepTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayerScreenSleepBottomSheet bottomSheet2 = new PlayerScreenSleepBottomSheet();
                bottomSheet2.show(getParentFragmentManager(), "PlayerScreenSleepBottomSheet");
            }
        });

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like.setVisibility(View.GONE);
                liked.setVisibility(View.VISIBLE);
            }
        });

        liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liked.setVisibility(View.GONE);
                like.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }
}
