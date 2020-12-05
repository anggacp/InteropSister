package com.project.interopsister;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MerchFragment extends Fragment {

    private FirebaseFirestore db;
    private ImageView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_merch, container, false);

//      recyclerview untuk promo
        db = db.getInstance();
        Query query = db.collection("myvoucher").whereArrayContains("nama_merch", );

        return view;
    }
}
