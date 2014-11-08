package kr.pokr.android.fragment;

import kr.pokr.android.R;
import kr.pokr.android.data.ConstantData;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.facebook.widget.LoginButton.UserInfoChangedCallback;

public class RegisterFragment extends Fragment {
	
	LoginButton authButton;
	private UiLifecycleHelper uiHelper;
	private GraphUser user;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		uiHelper = new UiLifecycleHelper(getActivity(), callback);
		uiHelper.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.register_fragment, container, false);

		authButton = (LoginButton) v.findViewById(R.id.btnFbReg);
		authButton.setFragment(this);

		authButton.setUserInfoChangedCallback(userInforChangedCallback);

		return v;
	}

	@Override
	public void onResume() {
		super.onResume();
		Button btn_login = (Button) getView().findViewById(R.id.btnToLogin);
		btn_login.setOnClickListener(toLoginListener);

		Button btn_email_reg = (Button) getView().findViewById(R.id.btnEmailReg);
		btn_email_reg.setOnClickListener(toEmailRegListener);

		uiHelper.onResume();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		customListener = (FragmentClickListener) activity;
	}

	public interface FragmentClickListener {
		public void onClicked(int id);
	}

	private FragmentClickListener customListener;

	OnClickListener toLoginListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			customListener.onClicked(ConstantData.FRAG_LOGIN);
		}
	};
	OnClickListener toEmailRegListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			customListener.onClicked(ConstantData.FRAG_EMAIL_REG);
		}
	};
	UserInfoChangedCallback userInforChangedCallback =  new LoginButton.UserInfoChangedCallback() {
        @Override
        public void onUserInfoFetched(GraphUser user) {
            RegisterFragment.this.user = user;
            Log.i("test",String.valueOf(user.toString()));
            Log.i("test",String.valueOf(user.asMap().get("email")));
            //updateUI();
            // It's possible that we were waiting for this.user to be populated in order to post a
            // status update.
            //handlePendingAction();
        }
    };
	private Session.StatusCallback callback = new Session.StatusCallback() {
		@Override
		public void call(Session session, SessionState state,
				Exception exception) {
			onSessionStateChange(session, state, exception);
		}
	};

	private void onSessionStateChange(Session session, SessionState state,
			Exception exception) {
		if (state.isOpened()) {
			Log.i("test", "Logged in...");
		} else if (state.isClosed()) {
			Log.i("test", "Logged out...");
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPause() {
		super.onPause();
		uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		uiHelper.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}

}