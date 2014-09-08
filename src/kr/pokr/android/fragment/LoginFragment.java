package kr.pokr.android.fragment;

import kr.pokr.android.HomeActivity;
import kr.pokr.android.HomeActivity_;
import kr.pokr.android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class LoginFragment extends Fragment {

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.login_fragment, container, false);
		
		Button btnCancle = (Button)v.findViewById(R.id.btnCancel);
		Button btnLogin = (Button)v.findViewById(R.id.btnLogin);
		
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),HomeActivity_.class);
				startActivity(intent);
			}
		});
		
		btnCancle.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getFragmentManager().popBackStack();
				}
		});
		
		

		return v;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
	}
	
	
	
}