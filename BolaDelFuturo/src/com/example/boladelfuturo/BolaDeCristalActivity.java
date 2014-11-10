package com.example.boladelfuturo;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

public class BolaDeCristalActivity extends ActionBarActivity {
	
	// Declare our views variables
	private TextView answerLabel;
	//private RelativeLayout background;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bola_de_cristal);
		
		
		
		answerLabel = (TextView) findViewById(R.id.textView1);
		//background = (RelativeLayout) findViewById(R.id.background);		
		
	}

	public void questionAction(View v) {
		
		answerLabel.setText(MagicBall.getPrediction(this));
		//background.setBackgroundColor(MagicBall.getColor());
	}
}
