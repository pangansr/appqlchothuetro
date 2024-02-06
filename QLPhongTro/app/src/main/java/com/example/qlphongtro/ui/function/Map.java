package com.example.qlphongtro.ui.function;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.qlphongtro.R;

import java.util.List;

public class Map extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        webView = findViewById(R.id.webViewMap);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        String url = "https://www.google.com/maps/search/Ph%C3%B2ng+tr%E1%BB%8D/@10.3680734,107.039127,12z/data=!3m1!4b1?entry=ttu";
        webView.loadUrl(url);
    }
}
