package com.example.qlphongtro.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.qlphongtro.MainActivity;
import com.example.qlphongtro.R;
import com.example.qlphongtro.databinding.ActivityEditInfomationBinding;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.storage.StorageReference;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EditInfomation extends AppCompatActivity {
    private ActivityEditInfomationBinding binding;
    static int b = R.drawable.user;
    static Uri selectedImageUri;
    static String username = "username";
    static String SDT = "+84";
    private static final int PICK_IMAGE_REQUEST = 1;
    StorageReference storageReference;
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

        binding.btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = binding.edtUserName.getText() + "";
                SDT = binding.edtSDT.getText() + "";
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