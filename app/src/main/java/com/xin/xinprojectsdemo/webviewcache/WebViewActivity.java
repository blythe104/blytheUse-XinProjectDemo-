package com.xin.xinprojectsdemo.webviewcache;

import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;

public class WebViewActivity extends BaseActivity {


    private Button btn;
    private WebView webview;
    private static final String url="file:///android_asset/test.html";
    @Override
    public void initView() {
        setContentView(R.layout.activity_web_view);
        btn = (Button) findViewById(R.id.btn);
        webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl(url);

    }

    @Override
    public void initListener() {
        btn.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void processClick(View v) {
        switch (v.getId())
        {
            case R.id.webview:
                ImageView imageView=new ImageView(WebViewActivity.this);
                break;
        }

    }
}
