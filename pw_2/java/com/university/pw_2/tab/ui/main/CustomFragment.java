package com.university.pw_2.tab.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import com.university.pw_2.R;
import com.university.pw_2.tab.TabbedActivity;
import java.util.Objects;

public class CustomFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        return inflater.inflate(R.layout.fragment_custom, container, false);
    }
}
