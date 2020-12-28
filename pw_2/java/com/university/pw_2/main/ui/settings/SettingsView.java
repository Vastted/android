package com.university.pw_2.main.ui.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsView extends ViewModel {
    private MutableLiveData<String> text;

    public SettingsView() {
        text = new MutableLiveData<>();
        text.setValue('Settings fragment');
    }

    public LiveData<String> getText() {
        return text;
    }
}
