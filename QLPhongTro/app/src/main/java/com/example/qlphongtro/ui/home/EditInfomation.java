package com.example.qlphongtro.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.qlphongtro.R;

import com.example.qlphongtro.databinding.ActivityEditInfomationBinding;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
public class EditInfomation extends AppCompatActivity {
    private ActivityEditInfomationBinding binding;
    static  int b = R.drawable.user;
    static Uri  selectedImageUri;
    static  String username="UserName";
    static  String SDT="sdt";
    private static final int PICK_IMAGE_REQUEST = 1;

    private AppCompatImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditInfomationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setEvent();
    }

    private void setEvent() {
        binding.a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ivAnh.setImageResource(R.drawable.nam);
               b = R.drawable.nam;
            }
        });
        binding.a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ivAnh.setImageResource(R.drawable.nam1);
                b = R.drawable.nam1;
            }
        });
        binding.a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ivAnh.setImageResource(R.drawable.buoc);
                b = R.drawable.buoc;
            }
        });
        binding.a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ivAnh.setImageResource(R.drawable.buoc1);
                b = R.drawable.buoc1;
            }
        });
        binding.a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ivAnh.setImageResource(R.drawable.tam);
                b = R.drawable.tam;
            }
        });
        binding.a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.ivAnh.setImageResource(R.drawable.tam1);
                b = R.drawable.tam1;
            }
        });
        binding.btnLayAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
                b = -1;
            }
        });
            if (binding.edtUserName.getText()!=null){
                username = binding.edtUserName.getText().toString();

            }
            if (binding.edtSDT.getText()!=null){
                SDT = binding.edtSDT.getText().toString();

            }
            binding.btnXacNhan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
    }
    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Lấy Uri của ảnh được chọn
             selectedImageUri = data.getData();

            binding.ivAnh.setImageURI(selectedImageUri);
        }
    }

}