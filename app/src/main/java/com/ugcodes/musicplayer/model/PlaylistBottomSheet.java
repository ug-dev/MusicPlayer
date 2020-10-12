package com.ugcodes.musicplayer.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ugcodes.musicplayer.R;

public class PlaylistBottomSheet extends BottomSheetDialogFragment {
    private RelativeLayout sortPlaylist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.playlist_bottom_sheet, container, false);

        sortPlaylist = view.findViewById(R.id.sort_playlist);

        sortPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                SortPlaylistBottomSheet bottomSheet = new SortPlaylistBottomSheet();
                bottomSheet.show(getParentFragmentManager(), "SortPlaylistBottomSheet");
            }
        });

        return view;
    }
}
