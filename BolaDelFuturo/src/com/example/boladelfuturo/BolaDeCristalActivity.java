package com.example.boladelfuturo;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class BolaDeCristalActivity extends ActionBarActivity {
	
	// Declare our views variables
	private TextView answerLabel;
	//private RelativeLayout background;
	final static float TRANSPARENTE = 0;
	final static float OPACO = 1;
	final static long DURATION = 1500;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bola_de_cristal);
		
		answerLabel = (TextView) findViewById(R.id.textView1);
		
				
		//background = (RelativeLayout) findViewById(R.id.background);		
		
	}

	public void questionAction(View v) {
		
		
		answerLabel.setText(MagicBall.getPrediction(this));
		animateBall();
		animateAnswer();
		//background.setBackgroundColor(MagicBall.getColor());
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
	
	
}
