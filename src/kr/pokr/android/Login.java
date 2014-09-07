package kr.pokr.android;

import kr.pokr.android.fragment.LoginFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

/**
 * The Class Login is an Activity class that shows the login screen to users.
 * The current implementation simply start the MainActivity. You can write your
 * own logic for actual login and for login using Facebook and Twitter.
 */
public class Login extends FragmentActivity
{

	int mCurrentFragmentIndex;
	/* (non-Javadoc)
	 * @see com.chatt.custom.CustomActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		mCurrentFragmentIndex = 0;

		fragmentReplace(mCurrentFragmentIndex);
	}
	
	public void fragmentReplace(int reqNewFragmentIndex) {

		Fragment newFragment = null;

//		Log.d(TAG, "fragmentReplace " + reqNewFragmentIndex);

		newFragment = getFragment(reqNewFragmentIndex);

		// replace fragment
		final FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();

		transaction.replace(R.id.login_fragment, newFragment);

		// Commit the transaction
		transaction.commit();

	}
	
	private Fragment getFragment(int idx) {
		Fragment newFragment = null;

		switch (idx) {
		case 0:
			newFragment = new LoginFragment();
			break;
		case 1:
			newFragment = null;
			break;

		default:
//			Log.d(TAG, "Unhandle case");
			break;
		}

		return newFragment;
	}

}
