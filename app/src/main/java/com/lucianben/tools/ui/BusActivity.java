package com.lucianben.tools.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.lucianben.tools.R;
import com.lucianben.tools.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BusActivity extends BaseActivity {

    @BindView(R.id.et_bus)
    EditText et_bus;
    @BindView(R.id.wb_bus)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        Toolbar toolbar = findViewById(R.id.toolbar_bus);
        toolbar.setTitle("公交车查询");
        toolbar.setLogo(R.mipmap.bus);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ButterKnife.bind(this);

        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());

//        webView.getSettings().setDomStorageEnabled(true);
//        webView.getSettings().setJavaScriptEnabled(true);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAppCacheEnabled(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

    }

    @OnClick(R.id.et_bus)
    void onClick(View view) {
        if (view.getId() == R.id.et_bus) {
//            Log.d("BusActivity", BaseUrl.InquireBus + MD5.md5(et_bus.getText().toString()));
            webView.loadUrl("http://shanghaicity.openservice.kankanews.com/public/bus"
                    /*BaseUrl.shanghaiFabu*//*BaseUrl.InquireBus+ MD5.md5(et_bus.getText().toString())*/);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
