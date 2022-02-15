package com.grayquest.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebView_Activity extends AppCompatActivity {

    private static final String TAG = WebView_Activity.class.getSimpleName();
    WebView webview;
    String value = "This message is from Android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webview = (WebView) findViewById(R.id.webview);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.clearCache(true);
        webview.addJavascriptInterface(new WebAppInterface(WebView_Activity.this), "Android");
        webview.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url){
                Log.e(TAG, "URL: "+url);
                //Here you want to use .loadUrl again
                //on the webview object and pass in
                //"javascript:<your javaScript function"
//                webview.evaluateJavascript("javascript:alert('Hi');",null); //if passing in an object. Mapping may need to take place
//                webview.loadUrl("javascript:testShowAlert('" + value + "')");
//                webview.loadUrl("javascript:testShowAlert();");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    view.evaluateJavascript("javascript:testShowAlert()", null);
                } else {
                    view.loadUrl("javascript:testShowAlert()");
                }
            }
        });
        webview.loadUrl("https://vibrant-spence-d1fbfc.netlify.app");
//        webview.evaluateJavascript("javascript:alert('Hiii');",null);
    }
}