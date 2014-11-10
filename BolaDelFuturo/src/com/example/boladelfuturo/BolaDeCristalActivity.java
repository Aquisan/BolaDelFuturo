package com.example.boladelfuturo;


import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.boladelfuturo.ShakeDetector.OnShakeListener;

public class BolaDeCristalActivity extends Activity {
	
	// Declare our views variables
	private TextView answerLabel;
	private SensorManager mSensorManager;
	private Sensor mAcelerometer;
	private ShakeDetector mShakeDetector;
	//private RelativeLayout background;
	final static float TRANSPARENTE = 0;
	final static float OPACO = 1;
	final static long DURATION = 1500;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bola_de_cristal);
		//background = (RelativeLayout) findViewById(R.id.background);		

		answerLabel = (TextView) findViewById(R.id.textView1);
		
		mSensorManager =  (SensorManager) getSystemService(SENSOR_SERVICE);
		mAcelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		
		mShakeDetector = new ShakeDetector(new OnShakeListener() {
			
			@Override
			public void onShake() {
				showAnswer();				
			}
		});	
		
		
	}

	
	
	public void questionAction(View v) {
		
		showAnswer();		
		
	}
	
	public void showAnswer(){
		answerLabel.setText(MagicBall.getPrediction(this));
		//background.setBackgroundColor(MagicBall.getColor());
		animateBall();
		animateAnswer();
		playSound();
	}
	
	
	private void animateBall(){
		
		ImageView imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setImageResource(R.drawable.ball_animation);
		AnimationDrawable animation = (AnimationDrawable) imageView.getDrawable();
		if(animation.isRunning())
			animation.stop();
		
		animation.start();
	}
	
	private void animateAnswer(){
		AlphaAnimation animation = new AlphaAnimation(TRANSPARENTE, OPACO);		
		animation.setDuration(DURATION);
		animation.setFillAfter(true);
		answerLabel.setAnimation(animation);
	}
	
	private void playSound(){
		MediaPlayer player = MediaPlayer.create(this, R.raw.magic_ball);
		player.start();
		
		player.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				mp.release();
				
			}
		});
	}	
	
	@Override
	 protected void onResume() {
         super.onResume();
 		mSensorManager.registerListener(mShakeDetector, mAcelerometer, mSensorManager.SENSOR_DELAY_UI);
     }

	@Override
     protected void onPause() {
         super.onPause();
         mSensorManager.unregisterListener(mShakeDetector);
     }
     
     
}
