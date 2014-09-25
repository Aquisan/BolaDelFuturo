package com.example.boladelfuturo;

import java.util.Random;

import android.content.Context;
import android.content.res.Resources;

public class MagicBall {
	
	//private Context context;
	private static String[] answers;
   /*
	MagicBall(Context context){
		this.context=context;
	}

	*/
	public static String getPrediction(Context context){
		
		Resources res = context.getResources();
		answers = res.getStringArray(R.array.answers);
		Random aleatorio = new Random();
		
		return answers[aleatorio.nextInt(answers.length)];
	}

}
