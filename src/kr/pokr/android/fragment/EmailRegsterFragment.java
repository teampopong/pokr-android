package kr.pokr.android.fragment;

import kr.pokr.android.Login;
import kr.pokr.android.R;
import kr.pokr.android.data.ConstantData;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class EmailRegsterFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.email_register_fragment, container, false);
		
		Button btnCancle = (Button)v.findViewById(R.id.btnCancel);
		Button btnLogin = (Button)v.findViewById(R.id.btnEmailReg);
		
		
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