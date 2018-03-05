package com.example.robert.myapplication1;

import android.content.Intent;
import android.opengl.ETC1;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

/**
 * Created by Robert on 2018-02-20.
 */

public class WebViewActivity2 extends AppCompatActivity {

    private String editTextFromWebView1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        editTextFromWebView1 = intent.getStringExtra(WebViewActivity1.KEY_DATA_WEB_VIEW);

        WebView webView = new WebView(this);
        setContentView(webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://"+editTextFromWebView1);
    }
}
