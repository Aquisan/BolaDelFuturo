package com.example.boladelfuturo;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BolaDeCristalActivity extends ActionBarActivity {
	
	// Declare our views variables
	TextView answerLabel;
	Button getAnswerButton;
	MagicBall magicBall;
	
	String[] answers ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bola_de_cristal);
		
		
		// Assign the Views from the layout file
		answerLabel = (TextView) findViewById(R.id.textView1);
	
	}

	public void questionAction(View v) {
		
		answerLabel.setText(MagicBall.getPrediction(this));
	}
}
