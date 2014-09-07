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

public class RegisterFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.register_fragment, container, false);
		
		return v;
	}
	

	@Override
	public void onResume() {
		super.onResume();
		Button btn_login = (Button)getView().findViewById(R.id.btnToLogin);
		btn_login.setOnClickListener(toLoginListener);
		
		Button btn_email_reg = (Button)getView().findViewById(R.id.btnEmailReg);
		btn_email_reg.setOnClickListener(toEmailRegListener);
	}


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		customListener = (FragmentClickListener)activity;
	}
	
    
	   public interface FragmentClickListener{
	       public void onClicked(int id);
	   }
	   private FragmentClickListener customListener;
    

    
   OnClickListener toLoginListener = new OnClickListener(){
       @Override
       public void onClick(View v) {
           customListener.onClicked(ConstantData.FRAG_LOGIN);
       }
   };
   OnClickListener toEmailRegListener = new OnClickListener(){
       @Override
       public void onClick(View v) {
           customListener.onClicked(ConstantData.FRAG_EMAIL_REG);
       }
   };
	
	
}