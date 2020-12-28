package com.university.pw_2.main.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowView extends ViewModel {
    private MutableLiveData<String> text;

    public SlideshowView() {
        text = new MutableLiveData<>();
        text.setValue('SlideShow fragment');
    }

    public LiveData<String> getText() {
        return text;
    }
}
