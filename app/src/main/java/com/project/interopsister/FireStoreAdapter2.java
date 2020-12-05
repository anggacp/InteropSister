package com.project.interopsister;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.squareup.picasso.Picasso;

public class FireStoreAdapter2 extends FirestoreRecyclerAdapter<myvoucherModel, FireStoreAdapter2.PromoViewHolder>{

    private OnListPromoClick onListPromoClick;

    public FireStoreAdapter2(@NonNull FirestoreRecyclerOptions<myvoucherModel> options, OnListPromoClick onListPromoClick) {
        super(options);
        this.onListPromoClick = onListPromoClick;
    }

    @Override
    protected void onBindViewHolder(@NonNull PromoViewHolder holder, int position, @NonNull myvoucherModel model) {
        holder.promo_diskon.setText(model.getDiskon());
        Picasso.get().load(model.getInfo()).into(holder.promo_image);
        holder.promo_name.setText(model.getKode_voucher());
        holder.promo_merch.setText(model.getNama_merch());
        holder.promo_location.setText(model.getAlamat());
    }

    @NonNull
    @Override
    public PromoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_promo, parent, false);
        return new PromoViewHolder(view1);
    }

    public class PromoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView promo_diskon;
        private ImageView promo_image;
        private TextView promo_name;
        private TextView promo_merch;
        private TextView promo_location;

        public PromoViewHolder(@NonNull View itemView) {
            super(itemView);

            promo_diskon = (TextView) itemView.findViewById(R.id.promo_discount);
            promo_image = (ImageView) itemView.findViewById(R.id.promo_image);
            promo_name = (TextView) itemView.findViewById(R.id.promo_title);
            promo_merch = (TextView) itemView.findViewById(R.id.promo_merch);
            promo_location = (TextView) itemView.findViewById(R.id.promo_location);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onListPromoClick.onPromoClick(getItem(getAdapterPosition()), getAdapterPosition());
        }
    }
    public interface OnListPromoClick {
        void onPromoClick(myvoucherModel snapshot, int position);
    }
}
