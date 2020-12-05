package com.project.interopsister;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class HomeFragment extends Fragment implements FirestoreAdapter.OnListItemClick, FireStoreAdapter2.OnListPromoClick {

    private RecyclerView placeItems;
    private RecyclerView promoItems;
    private FirebaseFirestore place;
    private FirebaseFirestore promo;
    private FirestoreAdapter adapter;
    private FirestoreRecyclerAdapter adapter1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //place recycler
        place = place.getInstance();
        placeItems = view.findViewById(R.id.recycler_place);

        //Query
        Query query = place.collection("user_data");
        //RecyclerOptions
        FirestoreRecyclerOptions<user_dataModel> options = new FirestoreRecyclerOptions.Builder<user_dataModel>()
                .setQuery(query, user_dataModel.class)
                .build();

        adapter = new FirestoreAdapter(options, this);
        placeItems.setHasFixedSize(true);
        placeItems.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        placeItems.setAdapter(adapter);


        //promo recycler
        promo = promo.getInstance();
        promoItems = view.findViewById(R.id.recycler_promo);

        //Query
        Query query1 = promo.collection("myvoucher").limit(10).orderBy("id");

        //RecyclerOptions
        FirestoreRecyclerOptions<myvoucherModel> options1 = new FirestoreRecyclerOptions.Builder<myvoucherModel>()
                .setQuery(query1, myvoucherModel.class)
                .build();

        adapter1 = new FireStoreAdapter2(options1, this);
        promoItems.setHasFixedSize(true);
        promoItems.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        promoItems.setAdapter(adapter1);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
        adapter1.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
        adapter1.stopListening();
    }

    @Override
    public void onItemClick(user_dataModel snapshot, int position) {
        Log.d("CLICK", "Clicked the " + position + "and the id is " + snapshot.getNama());
        Intent intent = Intent
    }

    @Override
    public void onPromoClick(myvoucherModel snapshot, int position) {
        Log.d("CLICK", "kepencet " + snapshot.getKode_voucher());
    }
}
