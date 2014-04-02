package com.tbccster.rotategridview;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.widget.GridView;

public class MainActivity extends Activity {

	private GridView mGridView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mGridView = (GridView)findViewById(R.id.gridview);
		mGridView.setLayoutAnimation(getLayoutAnimationController());
		mGridView.setAdapter(new GridAdapter(getApplicationContext()));
		
	}

	private static LayoutAnimationController getLayoutAnimationController()
	{
		AnimationSet set = new AnimationSet(true);
		Animation animation = new RotateAnimation(-180, 0);
		animation.setDuration(500);
	//	animation.setInterpolator(new AccelerateDecelerateInterpolator());
		set.addAnimation(animation);
	
		LayoutAnimationController controller = new LayoutAnimationController(set, 0.0f);
		controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
		controller.setDelay((float) 0.1);
		controller.willOverlap();
		
		return controller;
	}
	
}
