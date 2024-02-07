package com.example.qlphongtro.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.qlphongtro.databinding.FragmentHomeBinding;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    ArrayAdapter<String> ds;
    List<String> strings = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), EditInfomation.class) ;
                startActivity(intent);
            }
        });
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("Students");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                strings.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    strings.add(dataSnapshot.getValue(String.class));

                }
               ds.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ds = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, strings);
        binding.lvds.setAdapter(ds);

        return root;

    }
    @Override
    public void onResume() {
        super.onResume();
       if (EditInfomation.b==-1){
           binding.ivAnh.setImageURI(EditInfomation.selectedImageUri);
       }else {
           binding.ivAnh.setImageResource(EditInfomation.b);
       }
       binding.tvTen.setText(EditInfomation.username);
       binding.tvSDT.setText(EditInfomation.SDT);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}