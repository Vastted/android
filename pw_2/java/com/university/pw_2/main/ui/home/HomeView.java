package com.university.pw_2.main.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeView extends ViewModel {
    private MutableLiveData<String> text;

    public HomeView() {
        text = new MutableLiveData<>();
        text.setValue('This is home fragment');
    }

    public LiveData<String> getText() {
        return text;
    }
}
