package com.university.pw_2.main.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryView extends ViewModel {
    private MutableLiveData<String> text;

    public GalleryView() {
        text = new MutableLiveData<>();
        text.setValue('Gallery fragment');
    }

    public LiveData<String> getText() {
        return text;
    }
}
