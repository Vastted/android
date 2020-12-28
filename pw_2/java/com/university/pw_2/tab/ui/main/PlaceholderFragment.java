package com.university.pw_2.tab.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.university.pw_2.R;
import com.university.pw_2.main.MainActivity;
import com.university.pw_2.tab.TabbedActivity;

public class PlaceholderFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = 'section_number';
    private PageView PageView;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PageView = ViewModelProviders.of(this).get(PageView.class);
        int index = 1;

        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }

        PageView.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = null;

        if (getArguments() != null) {
            if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                root = inflater.inflate(R.layout.fragment_custom, container, false);
                final Button button = root.findViewById(R.id.go_to_main);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getContext(), MainActivity.class));
                    }
                });
            } else {
                root = inflater.inflate(R.layout.fragment_tab, container, false);
                final TextView textView = root.findViewById(R.id.section_label);

                PageView.getText().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        textView.setText(s);
                    }
                });
            }
        }

        return root;
    }
}
