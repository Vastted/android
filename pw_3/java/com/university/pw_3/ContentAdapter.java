package com.university.pw_3;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.university.pw_3.model.Content;
import com.university.pw_3.model.ad.Ad;
import com.university.pw_3.model.ad.AdHolder;
import com.university.pw_3.model.item.Item;
import com.university.pw_3.model.item.ItemHolder;
import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Content> list;
    public ContentAdapter(List<Content> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new ItemHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false));
        } else {
            return new AdHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ad_layout, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Content content = list.get(position);

        switch (holder.getItemViewType()){
            case 1:
                ItemHolder itemHolder = (ItemHolder) holder;
                Item item = (Item) content;
                itemHolder.getTitle().setText(item.getTitle());
                itemHolder.getMessage().setText(item.getMessage());
                itemHolder.getDate().setText(item.getDate());
                break;
            case 2:
                AdHolder adHolder = (AdHolder) holder;
                Ad ad = (Ad) content;
                adHolder.getTitle().setText(ad.getTitle());
                adHolder.getLink().setText(ad.getLink());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
