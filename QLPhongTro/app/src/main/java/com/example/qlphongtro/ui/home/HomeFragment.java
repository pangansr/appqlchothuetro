package com.example.qlphongtro.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.qlphongtro.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

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
       binding.tvSDT.setText(EditInfomation.username);
       binding.tvSDT.setText(EditInfomation.SDT);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}