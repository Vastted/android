package com.university.pw_3;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.university.pw_3.api_pw_4.APIContentService;
import com.university.pw_3.db.ContentDataBase;
import com.university.pw_3.model.AbstractContent;
import com.university.pw_3.model.Content;
import com.university.pw_3.model.ad.Ad;
import com.university.pw_3.model.item.Item;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Content> contents = new ArrayList<>();
    private RecyclerView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clearBtn = findViewById(R.id.clear_db_button);
        clearBtn.setOnClickListener(view -> {
            contents.clear();
            view.getAdapter().notifyDataSetChanged();
        });

        Button getFromDbBtn = findViewById(R.id.get_from_db);
        getFromDbBtn.setOnClickListener(view -> new Thread(() -> {
            List<Item> itemsFromDB = ContentDataBase.getDB(getApplicationContext()).contentDAO().getAllItemsFromBD();
            contents.addAll(itemsFromDB);
            List<Ad> adFromDB = ContentDataBase.getDB(getApplicationContext()).contentDAO().getAllAdsFromBD();
            contents.addAll(adFromDB);
            runOnUiThread(() -> view.getAdapter().notifyDataSetChanged());
        }).start());

        Button downloadFromApiBtn = findViewById(R.id.download_from_api);
        downloadFromApiBtn.setOnClickListener(view -> new Thread(this::downloadContentFromApi).start());

        view = findViewById(R.id.recycler_view);
        view.setHasFixedSize(true);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(new ContentAdapter(contents));

        downloadContentFromApi();
    }

    private void downloadContentFromApi() {
        new Thread(() -> {
            List<AbstractContent> response = APIContentService.get().getContent(null);

            for (AbstractContent content : response) {
                Content content = content.getContent();
                switch (content.getType()) {
                    case 1:
                        ContentDataBase.getDB(getApplicationContext()).contentDAO().insertItem((Item) content);
                        break;
                    case 2:
                        ContentDataBase.getDB(getApplicationContext()).contentDAO().insertAd((Ad) content);
                        break;
                }
                contents.add(content.getContent());
            }

            runOnUiThread(() -> view.getAdapter().notifyDataSetChanged());
        }).start();
    }
}
