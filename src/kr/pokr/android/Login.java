package kr.pokr.android;

import kr.pokr.android.data.ConstantData;
import kr.pokr.android.fragment.EmailRegsterFragment;
import kr.pokr.android.fragment.LoginFragment;
import kr.pokr.android.fragment.RegisterFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.facebook.widget.LoginButton;


public class Login extends FragmentActivity implements RegisterFragment.FragmentClickListener
{

	int mCurrentFragmentIndex;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		// setting initial fragment
		mCurrentFragmentIndex = ConstantData.FRAG_REG;
		fragmentReplace(mCurrentFragmentIndex, false);

		
	}
	
	public void fragmentReplace(int reqNewFragmentIndex, boolean stacked) {

		Fragment newFragment = null;

		// get fragment
		newFragment = getFragment(reqNewFragmentIndex);

		// replace fragment
		final FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.login_fragment, newFragment);
		if (stacked){ transaction.addToBackStack(null);	}
		
		// Commit the transaction
		transaction.commit();
	}
	
	private Fragment getFragment(int idx) {
		Fragment newFragment = null;

		switch (idx) {
		case ConstantData.FRAG_REG:
			newFragment = new RegisterFragment();
			break;
		case ConstantData.FRAG_LOGIN:
			newFragment = new LoginFragment();
			break;
		case ConstantData.FRAG_EMAIL_REG:
			newFragment = new EmailRegsterFragment();
			break;

		default:
			newFragment = null;
			break;
		}

		return newFragment;
	}

	@Override
	public void onClicked(int id) {
		fragmentReplace(id, true);
	}

}
