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
		//getAnswerButton = (Button) findViewById(R.id.button1);
		
		//Resources res = getResources();
		//answers = res.getStringArray(R.array.answers);
		//magicBall = new MagicBall(this);
		/*
		getAnswerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Random aleatorio = new Random();
		
				//answerLabel.setText(answers[aleatorio.nextInt(answers.length)]);
				answerLabel.setText(magicBall.getPrediction());

			}
		});*/
	}

	public void questionAction(View v) {
		

		//answerLabel.setText(answers[aleatorio.nextInt(answers.length)]);
		answerLabel.setText(MagicBall.getPrediction(this));
	}
}
