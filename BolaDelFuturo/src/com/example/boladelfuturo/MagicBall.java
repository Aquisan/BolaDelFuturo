package com.example.boladelfuturo;

import java.util.Random;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

public class MagicBall {

	// private Context context;
	private static String[] answers;
	private static int color;
	

	/*
	 * MagicBall(Context context){ this.context=context; }
	 */
	public  static String getPrediction(Context context) {

		Resources res = context.getResources();
		answers = res.getStringArray(R.array.answers);

		Random aleatorio = new Random();
		int randomNumber = aleatorio.nextInt(answers.length);

		if (randomNumber < 11)
			color = Color.GREEN;
		else if (randomNumber < 16)
			color = Color.YELLOW;
		else
			color = Color.RED;

		return answers[randomNumber];
	}
	
	public static int getColor() {
			if(color!=0)
				return color;
			else return Color.WHITE;
	}
}
