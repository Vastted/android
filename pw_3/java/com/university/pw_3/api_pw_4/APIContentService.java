package com.university.pw_3.api_pw_4;

import com.university.pw_3.model.AbstractContent;
import java.io.IOException;
import java.util.List;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIContentService {
    private static final String HOST = 'https://ruby.db.elephantsql.com/';
    private static APIContentService instance;
    private final ContentService contentService;
    private APIContentService() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        contentService = retrofit.create(ContentService.class);
    }

    public synchronized static APIContentService get() {
        if (instance == null) {
            instance = new APIContentService();
        }

        return instance;
    }

    public List<AbstractContent> getContent(Callback<List<AbstractContent>> callback) {
        if (null == callback) {
            try {
                return contentService.getData().execute().body();
            } catch (IOException e) {
                return null;
            }
        } else {
            contentService.getData().enqueue(callback);
            return null;
        }
    }
}
