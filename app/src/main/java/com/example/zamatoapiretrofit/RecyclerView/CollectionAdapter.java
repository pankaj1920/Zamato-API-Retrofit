package com.example.zamatoapiretrofit.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zamatoapiretrofit.Json.Collection;
import com.example.zamatoapiretrofit.Json.CollectionData;
import com.example.zamatoapiretrofit.R;
import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Picasso;

import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.collection_VH> {

    List<Collection> detail;

    public CollectionAdapter(List<Collection> detail) {
        this.detail = detail;
    }

    @NonNull
    @Override
    public collection_VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.collections, viewGroup, false);
        return new collection_VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull collection_VH collection_vh, int i) {
        CollectionData collection = detail.get(i).getCollectionData();
        collection_vh.titles.setText(collection.getTitle());
        collection_vh.description.setText(collection.getDescription());
        collection_vh.rest_count.setText(String.valueOf(collection.getRes_count()));

        Picasso.with(collection_vh.titles.getContext()).load(detail.get(i).getCollectionData().getImage_url()).into(collection_vh.image_view);



    }

    @Override
    public int getItemCount() {
        return detail.size();
    }

    class collection_VH extends RecyclerView.ViewHolder {
        ImageView image_view;
        TextView titles, description, rest_count;

        public collection_VH(@NonNull View itemView) {
            super(itemView);

            image_view = (ImageView) itemView.findViewById(R.id.image_view);
            titles = (TextView) itemView.findViewById(R.id.titles);
            description = (TextView) itemView.findViewById(R.id.description);
            rest_count = (TextView) itemView.findViewById(R.id.rest_count);

        }
    }
}
