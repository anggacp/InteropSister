package com.project.interopsister;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

public class FirestoreAdapter extends FirestoreRecyclerAdapter<user_dataModel, FirestoreAdapter.PlaceViewHolder> {

    private OnListItemClick onListItemClick;

    public FirestoreAdapter(@NonNull FirestoreRecyclerOptions<user_dataModel> options, OnListItemClick onListItemClick) {
        super(options);
        this.onListItemClick = onListItemClick;
    }

    @Override
    protected void onBindViewHolder(@NonNull PlaceViewHolder holder, int position, @NonNull user_dataModel model) {
        holder.place_name.setText(model.getNama());
        Picasso.get().load(model.getUrlLogo()).into(holder.place_logo);
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);
        return new PlaceViewHolder(view);
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView place_name;
        private ImageView place_logo;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            place_name = (TextView) itemView.findViewById(R.id.list_nama);
            place_logo = (ImageView) itemView.findViewById(R.id.image_nama);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onListItemClick.onItemClick(getItem(getAdapterPosition()), getAdapterPosition());
        }
    }
    public interface OnListItemClick {
        void onItemClick(user_dataModel snapshot, int position);
    }

}
