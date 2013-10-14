package kr.pork.android;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	
	private WebView mWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mWebView = (WebView) findViewById(R.id.webview);
		// enable java sciript
        mWebView.getSettings().setJavaScriptEnabled(true); 
        // designate the URL to load
        mWebView.loadUrl("http://pokr.kr");
        // set a WebViewClient
        mWebView.setWebViewClient(new WebViewClientClass());  
         
	}


    private class WebViewClientClass extends WebViewClient { 
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { 
            view.loadUrl(url); 
            return true; 
        } 
    }


}
