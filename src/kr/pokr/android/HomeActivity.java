package kr.pokr.android;

import kr.pokr.android.data.ConstantData;
import kr.pokr.android.fragment.EmailRegsterFragment;
import kr.pokr.android.fragment.HomeFragment;
import kr.pokr.android.fragment.LoginFragment;
import kr.pokr.android.fragment.RegisterFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class HomeActivity extends FragmentActivity 
{
	int mCurrentFragmentIndex;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);

		// setting initial fragment
		mCurrentFragmentIndex = ConstantData.HOME;
		fragmentReplace(mCurrentFragmentIndex, false);
		
	}
	
	public void fragmentReplace(int reqNewFragmentIndex, boolean stacked) {

		Fragment newFragment = null;

		// get fragment
		newFragment = getFragment(reqNewFragmentIndex);

		// replace fragment
		final FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.home_fragment, newFragment);
		if (stacked){ transaction.addToBackStack(null);	}
		
		// Commit the transaction
		transaction.commit();
	}
	
	private Fragment getFragment(int idx) {
		Fragment newFragment = null;

		switch (idx) {
		case ConstantData.HOME:
			newFragment = new HomeFragment();
			break;
			/*
		case ConstantData.SCRAP:
			newFragment = new ViewScrapFragment();
			break;
		case ConstantData.SEARCH:
			newFragment = new SearchFragment();
			break;
		case ConstantData.SETTING:
			newFragment = new SettingFragment();
			break;
			 */
		default:
			newFragment = null;
			break;
		}

		return newFragment;
	}
}
