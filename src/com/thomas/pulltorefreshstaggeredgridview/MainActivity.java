package com.thomas.pulltorefreshstaggeredgridview;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.etsy.android.grid.StaggeredGridView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

@SuppressLint("NewApi")
public class MainActivity extends Activity implements
		OnRefreshListener<StaggeredGridView> {
	private List<PhotoBean> photos;
	private StaggeredGridView mDongTaiGridView;
	private MyPhotoAdapter mAdapter;
	/** 下来刷新 **/
	private PullToRefreshStaggeredGridView mPullToRefreshStaggerdGridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initImageLoader(this);
		setContentView(R.layout.activity_main);
		photos = getPhotos();
		mAdapter = new MyPhotoAdapter(this, photos);
		mPullToRefreshStaggerdGridView = (PullToRefreshStaggeredGridView) this
				.findViewById(R.id.pull_grid_view);
		mPullToRefreshStaggerdGridView.setMode(Mode.PULL_FROM_START);
		mPullToRefreshStaggerdGridView.setMode(Mode.BOTH);
		mPullToRefreshStaggerdGridView.setOnRefreshListener(this);
		mDongTaiGridView = mPullToRefreshStaggerdGridView.getRefreshableView();

		mDongTaiGridView.setAdapter(mAdapter);
	}

	private List<PhotoBean> getPhotos() {
		List<PhotoBean> photos = new ArrayList<PhotoBean>();
		PhotoBean PhotoBean = new PhotoBean(
				"http://img4q.duitang.com/uploads/item/201506/29/20150629140736_5JR8c.jpeg",
				"夏天的风");
		photos.add(PhotoBean);
		PhotoBean = new PhotoBean(
				"http://img5q.duitang.com/uploads/item/201506/29/20150629141607_LNFkx.thumb.700_0.jpeg",
				"夏天的风");
		photos.add(PhotoBean);
		PhotoBean = new PhotoBean(
				"http://img5q.duitang.com/uploads/item/201506/29/20150629141550_MuVm5.jpeg",
				"夏天的风");
		photos.add(PhotoBean);
		PhotoBean = new PhotoBean(
				"http://img5q.duitang.com/uploads/item/201506/29/20150629141740_TUB2H.jpeg",
				"夏天的风");
		photos.add(PhotoBean);

		PhotoBean = new PhotoBean(
				"http://img4q.duitang.com/uploads/item/201506/29/20150629141716_nCUrG.jpeg",
				"夏天的风");
		photos.add(PhotoBean);

		PhotoBean = new PhotoBean(
				"http://cdnq.duitang.com/uploads/item/201506/29/20150629141656_5GBzS.jpeg",
				"夏天的风");
		photos.add(PhotoBean);

		PhotoBean = new PhotoBean(
				"http://img4q.duitang.com/uploads/item/201506/29/20150629141634_CEida.jpeg",
				"夏天的风");
		photos.add(PhotoBean);

		PhotoBean = new PhotoBean(
				"http://img5q.duitang.com/uploads/item/201506/29/20150629141236_sAHim.jpeg",
				"夏天的风");
		photos.add(PhotoBean);

		PhotoBean = new PhotoBean(
				"http://img4q.duitang.com/uploads/item/201506/29/20150629141218_ezRd4.jpeg",
				"夏天的风");
		photos.add(PhotoBean);

		PhotoBean = new PhotoBean(
				"http://cdnq.duitang.com/uploads/item/201506/29/20150629141200_nykzY.jpeg",
				"夏天的风");
		photos.add(PhotoBean);

		PhotoBean = new PhotoBean(
				"http://img4q.duitang.com/uploads/item/201506/29/20150629141125_FCtVN.jpeg",
				"夏天的风");
		photos.add(PhotoBean);

		PhotoBean = new PhotoBean(
				"http://img4q.duitang.com/uploads/item/201506/29/20150629141108_mBrUc.jpeg",
				"夏天的风");
		photos.add(PhotoBean);

		PhotoBean = new PhotoBean(
				"http://cdnq.duitang.com/uploads/item/201506/29/20150629141052_cdFuA.thumb.700_0.jpeg",
				"夏天的风");
		photos.add(PhotoBean);

		PhotoBean = new PhotoBean(
				"http://cdnq.duitang.com/uploads/item/201506/29/20150629141030_zv2Rt.jpeg",
				"夏天的风");
		photos.add(PhotoBean);

		PhotoBean = new PhotoBean(
				"http://img5q.duitang.com/uploads/item/201506/29/20150629140948_UMWTQ.jpeg",
				"夏天的风");
		photos.add(PhotoBean);

		return photos;
	}

	@Override
	public void onRefresh(PullToRefreshBase<StaggeredGridView> refreshView) {
		// TODO Auto-generated method stub
		if (refreshView.isHeaderShown()) {

		} else {
		}
	}

	public void initImageLoader(Context context) {
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.writeDebugLogs() // Remove for release app
				.build();
		ImageLoader.getInstance().init(config);
	}

	
}
