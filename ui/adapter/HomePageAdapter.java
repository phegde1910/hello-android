package com.airtel.home.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.airtel.R;
import com.airtel.common.ui.BaseFragment.PlayClickListener;

public class HomePageAdapter extends PagerAdapter {
	PlayClickListener mPlayClickLstnr;
	
	/*public HomePageAdapter(List<Video> videoList, OnClickListener onClickListener) {
		mPagerItemClickInterfaceListener = castPagerItemClickInterfaceListener(fragment);
		mVideosList = videoList;
		mOptnsClkListner = onClickListener;
		mCtx = new WeakReference<Context>(fragment.getActivity().getApplicationContext());
	}*/
	
	public HomePageAdapter(Fragment fragment) {
		mPlayClickLstnr = castPagerItemClickInterfaceListener(fragment);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == ((View) arg1);
	}
	
	public Object instantiateItem(View collection, int position) {
		LayoutInflater inflater = (LayoutInflater) collection.getContext().getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.home_view_pgr_item, null);
		view.findViewById(R.id.home_img_play_btn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPlayClickLstnr.onPlayClick();
			}
		});
		((ViewPager) collection).addView(view, 0);
		
		if (position == 1 || position == 3) {
			ImageView videoThumbnail = (ImageView) view.findViewById(R.id.home_video_img);
			videoThumbnail.setBackgroundResource(R.drawable.batman_poster);
		}
		
		return view;
	}
	
	
	@Override
	public void destroyItem(View arg0, int arg1, Object arg2) {
		((ViewPager) arg0).removeView((View) arg2);

	}
	
	private static PlayClickListener castPagerItemClickInterfaceListener(Object object) {
		try {
			return (PlayClickListener) object;
		} catch (ClassCastException e) {
			throw new ClassCastException(object.getClass().getName() + " must implement "
					+ PlayClickListener.class.getName());
		}
	}
}
