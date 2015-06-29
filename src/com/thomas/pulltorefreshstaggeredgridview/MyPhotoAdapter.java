package com.thomas.pulltorefreshstaggeredgridview;

import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.etsy.android.grid.util.DynamicHeightImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

public class MyPhotoAdapter extends BaseAdapter {
	private static final String TAG = "MyPhotoAdapter";

	private final LayoutInflater mLayoutInflater;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	private List<PhotoBean> data;
	private final Random mRandom;
	Context context;

	private static final SparseArray<Double> sPositionHeightRatios = new SparseArray<Double>();

	public MyPhotoAdapter(Context context, List<PhotoBean> data) {
		mLayoutInflater = LayoutInflater.from(context);
		mRandom = new Random();
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(final int position, View convertView,
			final ViewGroup parent) {

		ViewHolder vh;
		if (convertView == null) {
			convertView = mLayoutInflater.inflate(R.layout.list_item_dongtai,
					parent, false);
			vh = new ViewHolder();
			vh.imgContent = (DynamicHeightImageView) convertView
					.findViewById(R.id.iv_content_img);
			vh.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
			vh.ll_user = (LinearLayout) convertView.findViewById(R.id.ll_user);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}

		double positionHeight = getPositionRatio(position);
		Log.d(TAG, "getView position:" + position + " h:" + positionHeight);
		if (position % 2 == 0) {
			vh.imgContent.setHeightRatio(1);
		} else {
			vh.imgContent.setHeightRatio(1.5);
		}
		vh.tv_name.setText(data.get(position).getUserName());
		// “Ï≤Ωº”‘ÿÕº∆¨
		ImageLoader.getInstance().displayImage(
				data.get(position).getImagePath(), vh.imgContent, options, null);// ∂ØÃ¨Õº∆¨

		return convertView;
	}

	protected DisplayImageOptions options;// Õº∆¨œ‘ æøÿ÷∆¿‡

	public void initOption() {
		// TODO Auto-generated method stub
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.b_load_default)
				.showImageForEmptyUri(R.drawable.b_load_default)
				.showImageOnFail(R.drawable.b_load_default)
				.resetViewBeforeLoading(false).cacheOnDisc(true)
				.cacheInMemory(true).imageScaleType(ImageScaleType.EXACTLY)
				.bitmapConfig(Bitmap.Config.RGB_565).considerExifParams(true)
				.displayer(new FadeInBitmapDisplayer(100)).build();
	}

	static class ViewHolder {
		DynamicHeightImageView imgContent;
		TextView tv_name;
		LinearLayout ll_user;
	}

	private double getPositionRatio(final int position) {
		double ratio = sPositionHeightRatios.get(position, 0.0);
		if (ratio == 0) {
			ratio = getRandomHeightRatio();
			sPositionHeightRatios.append(position, ratio);
			Log.d(TAG, "getPositionRatio:" + position + " ratio:" + ratio);
		}
		return ratio;
	}

	private double getRandomHeightRatio() {
		return (mRandom.nextDouble() / 2.0) + 1.0; // height will be 1.0 - 1.5
													// the width
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
}
