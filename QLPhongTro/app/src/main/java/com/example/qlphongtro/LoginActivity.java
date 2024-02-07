package com.example.qlphongtro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.qlphongtro.databinding.ActivityLoginMainBinding;
import com.example.qlphongtro.ui.function.TimKiem;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
private  ActivityLoginMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = firebaseDatabase.getReference("User/User1");

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        boolean userFound = false;

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            String username = dataSnapshot.getValue(String.class);
                            if (username != null && username.equals(binding.edtTen.getText().toString())) {
                                userFound = true;
                                // Nếu tìm thấy tên người dùng, chuyển sang màn hình MainActivity
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                break; // Thoát khỏi vòng lặp khi đã tìm thấy người dùng
                            }
                        }

                        if (!userFound) {
                            // Nếu không tìm thấy tên người dùng, hiển thị thông báo
                            Toast.makeText(LoginActivity.this, "Tên người dùng không hợp lệ", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Xử lý lỗi nếu có
                        Log.e("FirebaseError", "Lỗi khi đọc dữ liệu từ Firebase", error.toException());
                    }
                });
            }
        });
    }
}