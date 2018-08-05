package com.example.hp.loadurl;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import android.widget.Toast;

public class WebActivity extends Activity
{

    Button b1;
    private WebView wv1;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        // CODE FOR PROGRESS DIALOG
        progressDialog = new ProgressDialog(WebActivity.this);
        progressDialog.setMax(600);
        progressDialog.setMessage("Please wait...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);
        progressDialog.setCancelable(false);

        // GET THE URL ENTER BY USER
        String url = getIntent().getExtras().getString("website");

        // SETTING WEBVIEW OR WEBVIEW CLIENT
        wv1 = (WebView) findViewById(R.id.webView);
        wv1.setWebViewClient(new MyBrowser()
        {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(WebActivity.this, description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressDialog.show();
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                progressDialog.dismiss();

                String webUrl = wv1.getUrl();

            }

        });

        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.loadUrl(url);
    }

    class MyBrowser extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }

    // CODE FOR BACK PRESS
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.wv1.canGoBack())
        {
            this.wv1.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}