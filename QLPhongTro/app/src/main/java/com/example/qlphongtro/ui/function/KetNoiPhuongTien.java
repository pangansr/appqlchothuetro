package com.example.qlphongtro.ui.function;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.qlphongtro.databinding.ActivityKetNoiPhuongTienBinding;

import java.util.Random;

public class KetNoiPhuongTien extends AppCompatActivity {
    private ActivityKetNoiPhuongTienBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKetNoiPhuongTienBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Xử lý sự kiện khi nút gọi được nhấn
        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Số điện thoại bạn muốn gọi

                Random random = new Random();
              String[] danhSachChuoi = {"0889213537", "0384353091", "0345443020"};
              //  String[] danhSachChuoi = {"0123444444", "08998989", "065465"};
                int index = random.nextInt(danhSachChuoi.length);
                String soDienThoai = "tel:"+ danhSachChuoi[index];
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    // Nếu phiên bản Android là Marshmallow (23) trở lên, kiểm tra quyền CALL_PHONE
                    if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == 0) {
                        // Nếu quyền đã được cấp, tạo Intent để thực hiện cuộc gọi
                        Intent intentCuocGoi = new Intent(Intent.ACTION_CALL);
                        intentCuocGoi.setData(Uri.parse(soDienThoai));
                        startActivity(intentCuocGoi);
                    } else {
                        // Nếu quyền chưa được cấp, yêu cầu người dùng cấp quyền
                        requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE}, 1);
                    }
                } else {
                    // Nếu phiên bản Android là thấp hơn Marshmallow, không cần kiểm tra quyền
                    Intent intentCuocGoi = new Intent(Intent.ACTION_CALL);
                    intentCuocGoi.setData(Uri.parse(soDienThoai));
                    startActivity(intentCuocGoi);
                }
            }
        });
    }
}
