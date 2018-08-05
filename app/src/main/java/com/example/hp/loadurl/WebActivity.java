package com.example.hp.loadurl;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {


    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        String url = "https://www.google.com";

        progressDialog = new ProgressDialog(WebActivity.this);
        progressDialog.setMax(600);
        progressDialog.setMessage("Please wait...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);
        progressDialog.setCancelable(false);

        WebView web = (WebView)findViewById(R.id.web);
        //String url = getIntent().getExtras().getString("website");
        web.loadUrl(url);
        /*web.setWebChromeClient(new WebChromeClient()
        {
            public void onProgressChanged(WebView view, int progress)
            {
                progressDialog.setProgress(progress);
                if (progress==100)
                {
                    progressDialog.dismiss();
                }
                else
                {
                    progressDialog.show();
                }
            }

        });*/

    }

    public void onProgressChanged(WebView view, int progress)
    {
        progressDialog.setProgress(progress);
        if (progress==100)
        {
            progressDialog.dismiss();
        }
        else
        {
            progressDialog.show();
        }
    }
}
