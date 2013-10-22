package com.airtel.home.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.airtel.R;
import com.airtel.common.io.ProvisionTask;
import com.airtel.common.ui.BaseActivity;
import com.airtel.common.utils.Constants;
import com.airtel.common.utils.FragmentHelper;

public class HomeScreen extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle arg0) {	
		super.onCreate(arg0);
		
		Fragment frg = new HomeFragment();
		/*Intent intent = null;
		if ((intent = getIntent()) == null) 
			return;
			
		String userId = intent.getStringExtra(Constants.USER_ID);
		Bundle bundle = new Bundle();
		bundle.putString(Constants.USER_ID, userId);
		frg.setArguments(bundle);*/
		
		FragmentHelper.replaceContentFragment(this, R.id.base_frgmnt_container, frg);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		setPageTitle(getString(R.string.airtel_multi_screen_home_page));
	}
}
