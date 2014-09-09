package kr.pokr.android;

import kr.pokr.android.data.ConstantData;
import kr.pokr.android.fragment.HomeFragment_;
import kr.pokr.android.fragment.LoginFragment;
import kr.pokr.android.network.PopongDataRestClient;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.rest.RestService;

import android.support.v4.app.FragmentActivity;
import android.util.Log;

@EActivity(R.layout.home_layout)
public class HomeActivity extends FragmentActivity 
{
	
	
    @RestService
    PopongDataRestClient restClient; //Inject it

    @AfterViews
    @Background
    void afterViews() {
        Object result = restClient.getEvents(); //Play with it
        Log.d("test",result.toString());
    }
    
	
	@Click
	void btn_home(){
		Log.d(ConstantData.LogTag,"home");
		HomeFragment_ home_fragment = new HomeFragment_();
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.home_fl, home_fragment)
		.commit();
	}
	@Click
	void btn_star(){
		Log.d(ConstantData.LogTag,"star");

		// TODO: login_fragment is temporary things.
		// replace correct start fragment.
		LoginFragment login_fragment = new LoginFragment();
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.home_fl, login_fragment)
		.commit();
	}
	@Click
	void btn_search(){
		Log.d(ConstantData.LogTag,"search");
	}
	@Click
	void btn_settings(){
		Log.d(ConstantData.LogTag,"settings");
	}

}
