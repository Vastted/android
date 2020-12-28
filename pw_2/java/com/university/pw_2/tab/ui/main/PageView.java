package com.university.pw_2.tab.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageView extends ViewModel {
    private MutableLiveData<Integer> index = new MutableLiveData<>();
    private LiveData<String> text = Transformations.map(index, new Function<Integer, String>() {
        @Override
        public String apply(Integer original_index) {
            return 'Section: ' + original_index;
        }
    });

    public void setIndex(int original_index) {
        index.setValue(original_index);
    }

    public LiveData<String> getText() {
        return text;
    }
}
