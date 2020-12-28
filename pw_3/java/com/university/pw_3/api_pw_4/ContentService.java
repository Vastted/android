package com.university.pw_3.api_pw_4;

import com.university.pw_3.model.AbstractContent;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ContentService {
    @GET('content.json')
    Call<List<AbstractContent>> getData();
}
