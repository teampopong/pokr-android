package kr.pokr.android;

import kr.pokr.android.data.PokrData;
import kr.pokr.android.service.MQTTService;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	private WebView mWebView;
	private ProgressBar progressBar;


	private StatusUpdateReceiver statusUpdateIntentReceiver;
	private MQTTMessageReceiver  messageIntentReceiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	    statusUpdateIntentReceiver = new StatusUpdateReceiver();
	    IntentFilter intentSFilter = new IntentFilter(MQTTService.MQTT_STATUS_INTENT);
	    registerReceiver(statusUpdateIntentReceiver, intentSFilter);

	    messageIntentReceiver = new MQTTMessageReceiver();
	    IntentFilter intentCFilter = new IntentFilter(MQTTService.MQTT_MSG_RECEIVED_INTENT);
	    registerReceiver(messageIntentReceiver, intentCFilter);


		SharedPreferences settings = getSharedPreferences(MQTTService.APP_ID, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("broker", PokrData.preferenceBrokerHost);
		editor.putString("topic",  PokrData.preferenceBrokerTopic);
		editor.commit();

		Intent svc = new Intent(this, MQTTService.class);
		startService(svc);

		mWebView = (WebView) findViewById(R.id.webview);
		progressBar = (ProgressBar) this.findViewById(R.id.progress);
		// enable java sciript
        mWebView.getSettings().setJavaScriptEnabled(true);
        // set a WebViewClient
        mWebView.setWebViewClient(new WebViewClientClass());
        mWebView.setWebChromeClient(new WebChromeClientClass());
        // designate the URL to load
        mWebView.loadUrl("http://pokr.kr");

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    // Check if the key event was the Back button and if there's history
	    if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
	    	mWebView.goBack();
	        return true;
	    }
	    // If it wasn't the Back key or there's no web page history, bubble up to the default
	    // system behavior (probably exit the activity)
	    return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onDestroy()
	{
	    unregisterReceiver(statusUpdateIntentReceiver);
	    unregisterReceiver(messageIntentReceiver);

	}

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

		public void onPageStarted(WebView view, String url,
				android.graphics.Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			progressBar.setVisibility(View.VISIBLE);
		}

		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			progressBar.setVisibility(View.INVISIBLE);
		}
		public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
			super.onReceivedError(view, errorCode, description, failingUrl);
			Toast.makeText(MainActivity.this, "Fail to load" + description,
					Toast.LENGTH_SHORT).show();
		}
    }
    private class WebChromeClientClass extends WebChromeClient {
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			progressBar.setProgress(newProgress);
		}
	}

	public class StatusUpdateReceiver extends BroadcastReceiver
	{
	    @Override
	    public void onReceive(Context context, Intent intent)
	    {
	        Bundle notificationData = intent.getExtras();
	        String newStatus = notificationData.getString(MQTTService.MQTT_STATUS_MSG);	    	
	    }
	}
	public class MQTTMessageReceiver extends BroadcastReceiver
	{
	    @Override
	    public void onReceive(Context context, Intent intent)
	    {
	        Bundle notificationData = intent.getExtras();
	        String newTopic = notificationData.getString(MQTTService.MQTT_MSG_RECEIVED_TOPIC);
	        String newData  = notificationData.getString(MQTTService.MQTT_MSG_RECEIVED_MSG);	
	        Log.i("MQTT",newData);
	    }
	}
	@Override
	public void onWindowFocusChanged(boolean hasFocus)
	{
	    super.onWindowFocusChanged(hasFocus);
	    if (hasFocus)
	    {
	        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	        mNotificationManager.cancel(MQTTService.MQTT_NOTIFICATION_UPDATE);
	    }
	}

}
