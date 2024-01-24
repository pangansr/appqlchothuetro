package com.example.qlphongtro.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.qlphongtro.MainActivity;
import com.example.qlphongtro.databinding.FragmentFunctionBinding;
import com.example.qlphongtro.ui.function.KetNoiPhuongTien;
import com.example.qlphongtro.ui.function.Map;
import com.example.qlphongtro.ui.function.TimKiem;

public class GalleryFragment extends Fragment {

    private FragmentFunctionBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFunctionBinding.inflate(inflater, container, false);
        binding.timkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), TimKiem.class) ;
                startActivity(intent);
            }
        });
        binding.ivPhuongTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), KetNoiPhuongTien.class) ;
                startActivity(intent);
            }
        });
        binding.ivmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), Map.class) ;
                startActivity(intent);
            }
        });
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}