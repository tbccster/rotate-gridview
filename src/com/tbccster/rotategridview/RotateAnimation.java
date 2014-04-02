package com.tbccster.rotategridview;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class RotateAnimation extends Animation {
	// 3d rotate
	private float mFromDegrees;
	private float mToDegrees;
	private float mCenterX;
	private float mCenterY;
	
	private Camera mCamera;
	
    public RotateAnimation(float fromDegrees, float toDegrees) 
    {
    	mFromDegrees = fromDegrees;
    	mToDegrees = toDegrees;
    }

	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight)
	{
		super.initialize(width, height, parentWidth, parentHeight);
		mCenterX = width / 2;
		mCenterY = height / 2;
		mCamera = new Camera();
	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t)
	{
		
		final float fromDegrees = mFromDegrees;
		float degrees = fromDegrees + (mToDegrees - mFromDegrees) * interpolatedTime;
		
		final Matrix matrix = t.getMatrix();
		
		mCamera.save();
		
		mCamera.rotateY(degrees);
		mCamera.getMatrix(matrix);
		mCamera.restore();
		
		matrix.preTranslate(-mCenterX, -mCenterY);
		matrix.postTranslate(mCenterX, mCenterY);
	}
}
