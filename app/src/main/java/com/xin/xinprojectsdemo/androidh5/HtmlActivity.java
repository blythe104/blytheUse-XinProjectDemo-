package com.xin.xinprojectsdemo.androidh5;

import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.xin.xinprojectsdemo.R;
import com.xin.xinprojectsdemo.base.BaseActivity;

public class HtmlActivity extends BaseActivity {


    private WebView wvdetail;
    private TextView mTitle;
    private TextView mTitleTag;
    private String url;
    private FrameLayout mFrBack;

    @Override
    public void initView() {
        setContentView(R.layout.activity_html);
        this.wvdetail = (WebView) findViewById(R.id.wv_detail);

        mTitle = (TextView) findViewById(R.id.tv_title);
        mTitleTag = (TextView) findViewById(R.id.tv_title_tag);
        mFrBack = (FrameLayout) findViewById(R.id.fr_back);

        mTitleTag.setVisibility(View.INVISIBLE);

        WebSettings settings = wvdetail.getSettings();

        settings.setJavaScriptEnabled(true);


        url = getIntent().getStringExtra("url");

        wvdetail.loadUrl(url);

        wvdetail.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        // TODO: 2016/4/21 WebView中的H5内部跳转问题  change by mx
        mFrBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wvdetail.canGoBack()) {
                    //可以在H5内部进行跳转
                    wvdetail.goBack();
                } else {
                    //否则返回到App中
                    finish();
                }
            }
        });
    }

    @Override
    public void initListener() {

    }


    @Override
    public void initData() {
        mTitle.setText(getIntent().getStringExtra("title"));
    }

    @Override
    public void processClick(View v) {

    }


    // TODO: 2016/4/21 WebView中的H5内部跳转问题  change by mx
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && wvdetail.canGoBack()) {
            wvdetail.goBack();// 返回前一个页面
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
