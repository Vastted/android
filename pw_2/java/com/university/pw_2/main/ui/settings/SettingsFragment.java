package com.university.pw_2.main.ui.settings;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.university.pw_2.R;

public class SettingsFragment extends Fragment {
    private SettingsView SettingsView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingsView = ViewModelProviders.of(this).get(SettingsView.class);
        View root = inflater.inflate(R.layout.fragment_settings, container, false);
        final TextView view = root.findViewById(R.id.text_settings);

        SettingsView.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                view.setText(s);
            }
        });

        return root;
    }
}
