package com.example.qlphongtro.ui.function;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.qlphongtro.R;
import android.content.Intent;
import android.net.Uri;

public class TimKiem extends AppCompatActivity {

    Button btnTimKiem;
    EditText edtGia, edtDT;
    Spinner spLoaiNha;
    ArrayAdapter<String> adapter;
    String loaiNha="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        setConTrol();
        setEvent();
    }

    private void setConTrol() {
        btnTimKiem = findViewById(R.id.btntiemkiem);
        edtDT = findViewById(R.id.edtdientich);
        edtGia = findViewById(R.id.edtgia);
        spLoaiNha = findViewById(R.id.sploainha);
        String[] data = {"Phòng trọ, nhà trọ", "Nhà thuê nguyên căn", "Căn hộ", "Mặt bằng, văn phòng"};
         adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);

    }

    private void setEvent() {
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLoaiNha.setAdapter(adapter);
        spLoaiNha.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                  loaiNha = "cho-thue-phong-tro";
                }
                if (position == 1) {
                    loaiNha = "nha-cho-thue";
                }
                if (position == 2) {
                    loaiNha = "cho-thue-can-ho";
                }
                if (position == 3) {
                    loaiNha = "cho-thue-mat-bang";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://phongtro123.com/"+loaiNha+"?dien_tich_den="+edtDT.getText()+"&gia_den="+edtGia.getText() ;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
