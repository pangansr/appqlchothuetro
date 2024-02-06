package com.example.qlphongtro.ui.function;


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.example.qlphongtro.R;
import com.example.qlphongtro.databinding.ActivityChatTvptBinding;

import java.util.List;

public class ChatTVPT extends AppCompatActivity {
    private ActivityChatTvptBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatTvptBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        WebSettings webSettings = binding.webViewChat.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        binding.webViewChat.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                binding.webViewChat.loadUrl("javascript:(function() { document.documentElement.lang = 'en'; })()");
//            }
//        });
//        String url = "https://www.aichatting.net/ai-character/psychologist/";
//        binding.webViewChat.loadUrl(url);
        String url1 = "https://www.aichatting.net/ai-character/psychologist/" ;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
        startActivity(intent);
    }
}
