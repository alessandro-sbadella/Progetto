package com.example.laruotadipassaparola;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Inizio_multiplayer extends Activity {
	
	int secondi ; int differenza ;
	Intent in ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inizio_multiplayer);
		
		countdown() ;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_inizio_multiplayer, menu);
		return true;
	}
	
public void countdown() {	
		
		secondi = 5 ;
		
		Runnable ru = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			    for(int i = 0 ; i <= secondi ; i++){
			    	
					differenza = secondi - i ;
										
					try {
						Thread.sleep(1000);
						/** Il thread si "addormenta"(non sar� in funzione) per 
						 *  1000 millisecondi = 1 secondo. */
				    } catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
				}
			    
				in = new Intent(Inizio_multiplayer.this, Multiplayer.class);
				startActivity(in);
			}
		}; new Thread(ru).start();	
	} 	

}
