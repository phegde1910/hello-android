package com.airtel.home.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.airtel.R;
import com.airtel.common.customviews.ui.CirclePageIndicator;
import com.airtel.common.ui.BaseFragment;
import com.airtel.common.ui.BaseFragment.PlayClickListener;
import com.airtel.common.ui.VideoPlayer;
import com.airtel.common.utils.Constants;
import com.airtel.home.ui.adapter.HomePageAdapter;

public class HomeFragment extends BaseFragment implements OnClickListener, PlayClickListener {

	private HomePageAdapter mHomePageAdapter;
	private CirclePageIndicator mIndicator;
	private ViewPager mViewPager;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home, container, false);
		
		initViews(view);
		setOnClickListeners(view);

		return view;
	}

	private void setOnClickListeners(View view) {
		view.findViewById(R.id.home_live_tv).setOnClickListener(this);
		view.findViewById(R.id.home_videos).setOnClickListener(this);
		view.findViewById(R.id.home_catchup_tv).setOnClickListener(this);
		view.findViewById(R.id.home_my_content).setOnClickListener(this);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mViewPager.setAdapter(mHomePageAdapter);
		mViewPager.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), VideoPlayer.class);
				intent.putExtra(Constants.VIDEO_URL, "http://ns.ibnlive.in.com/ipadmp4/08_2012/congress_leaders_on_modi.mp4");
				startActivity(intent);
			}
		});
		mIndicator.setViewPager(mViewPager);
	}
	
	private void initViews(View view) {
		mHomePageAdapter = new HomePageAdapter(this);
		mViewPager = (ViewPager) view.findViewById(R.id.pager);
		mIndicator = (CirclePageIndicator)view.findViewById(R.id.indicator);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		case R.id.home_live_tv:
			break;
			
		case R.id.home_videos:
			break;
			
		case R.id.home_catchup_tv:
			break;
			
		case R.id.home_my_content:
			break;
			
		}
	}

	@Override
	public void onPlayClick() {
		/*Intent intent = new Intent(getActivity(), VideoPlayer.class);
		intent.putExtra(Constants.IS_FROM_CHANNEL, false);
		intent.putExtra(Constants.VIDEO_URL, "http://ns.ibnlive.in.com/ipadmp4/08_2012/congress_leaders_on_modi.mp4");
		startActivity(intent);*/
	}
}
