package com.university.pw_2.main.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.university.pw_2.R;

public class GalleryFragment extends Fragment {
    private GalleryView GalleryView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryView = ViewModelProviders.of(this).get(GalleryView.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView view = root.findViewById(R.id.text_gallery);

        GalleryView.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                view.setText(s);
            }
        });

        return root;
    }
}
