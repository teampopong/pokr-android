package kr.pokr.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * The Class Login is an Activity class that shows the login screen to users.
 * The current implementation simply start the MainActivity. You can write your
 * own logic for actual login and for login using Facebook and Twitter.
 */
public class Login extends FragmentActivity
{

	/* (non-Javadoc)
	 * @see com.chatt.custom.CustomActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		//setTouchNClick(R.id.btnLogin);
		//setTouchNClick(R.id.btnFb);
	}

	/* (non-Javadoc)
	 * @see com.chatt.custom.CustomActivity#onClick(android.view.View)
	 */
	/*@Override
	public void onClick(View v)
	{
		super.onClick(v);
		if (v.getId() != R.id.btnReg)
		{
			startActivity(new Intent(this, MainActivity.class));
			finish();
		}
	}
	*/
}
