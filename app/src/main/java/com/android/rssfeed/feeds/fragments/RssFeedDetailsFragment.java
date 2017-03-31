package com.android.rssfeed.feeds.fragments;

import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.android.rssfeed.R;
import com.android.rssfeed.common.BaseFragment;
import com.android.rssfeed.di.components.RssFeedAppComponent;
import com.android.rssfeed.util.ResourceUtil;

import butterknife.BindView;

/**
 * Created by Alen Siljan on 28.3.2017..
 * alen.siljan@gmail.com
 */

public class RssFeedDetailsFragment extends BaseFragment {

    public static final String TAG = "rss_feed_details_fragment";
    private static final String BUNDLE_EXTRA_ARG = "rss_feed_url_arg";

    @BindView(R.id.webviewHolder)
    RelativeLayout mWebViewHolder;

    private String mRssFeedUrl;
    private WebView mWebView;

    @Override
    protected void injectDependencies(RssFeedAppComponent appComponent) {

    }

    public static RssFeedDetailsFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString(BUNDLE_EXTRA_ARG, url);
        RssFeedDetailsFragment fragment = new RssFeedDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();

        if (bundle != null) {
            mRssFeedUrl = bundle.getString(BUNDLE_EXTRA_ARG);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_rssfeed_details, container, false);

        setHasOptionsMenu(true);
        bindViews();
        setToolbar(ResourceUtil.getStringById(getContext(), R.string.rssFeedToolbarTitle), true);
        showLoadingBar();

        initWebView();
        loadWebViewUrl();

        return mView;
    }

    private void initWebView() {
        mWebView = new WebView(getContext());
        acceptCookies();
        WebSettings wSettings = mWebView.getSettings();

        RelativeLayout.LayoutParams par_webview = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        mWebView.setLayoutParams(par_webview);
        wSettings.setJavaScriptEnabled(true);
        wSettings.setBuiltInZoomControls(true);
        wSettings.setSupportZoom(true);
        wSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        try {
            wSettings.setLoadWithOverviewMode(true);
            wSettings.setUseWideViewPort(true);
        } catch (Exception e) {
            e.fillInStackTrace();
        }

        mWebViewHolder.addView(mWebView);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                hideLoadingBar();
            }

            @Override
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("");
                builder.setPositiveButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        hideLoadingBar();
                        handler.proceed();
                    }
                });
                builder.setNegativeButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        hideLoadingBar();
                        handler.cancel();
                    }
                });

                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                hideLoadingBar();
            }
        });
    }

    private void loadWebViewUrl() {
        mWebView.loadUrl(mRssFeedUrl);
    }

    private void acceptCookies() {
        try {
            android.webkit.CookieManager.getInstance().setAcceptCookie(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mCallback.onBackRequest();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
