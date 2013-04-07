package com.example.laruotadipassaparola;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class FinePartitaMultiplayer extends Activity {
	
	int Punteggio_giocatore_1 ; int Punteggio_giocatore_2 ; int secondi ; int differenza ;
	Intent in ;
	String giocatore_1 ; String giocatore_2 ; String spazio ;
    TextView vince_il_giocatore ; TextView sfida ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fine_partita_multiplayer);
		
		spazio = "          " ;
		
		Punteggio_giocatore_1 = getIntent().getExtras().getInt("CONTATORE_1");
		Punteggio_giocatore_2 = getIntent().getExtras().getInt("CONTATORE_2");

		vince_il_giocatore = (TextView) findViewById(R.id.textView31);
		sfida = (TextView) findViewById(R.id.textView34);
		
		sfida.setText("'Giocatore 1': " + Punteggio_giocatore_1 + spazio + "VS" + spazio + 
				"'Giocatore 2': " + Punteggio_giocatore_2);
		
		if(Punteggio_giocatore_1 > Punteggio_giocatore_2){
			vince_il_giocatore.setText("Vince il Giocatore 1");
		}
		else if(Punteggio_giocatore_2 > Punteggio_giocatore_1){
			vince_il_giocatore.setText("Vince il Giocatore 2");
		}
		else{
			vince_il_giocatore.setText("Partita Patta");
		}
		
		countdown() ;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_fine_partita_multiplayer,menu);
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
			    
				in = new Intent(FinePartitaMultiplayer.this, MainActivity.class);
				startActivity(in);
			}
		}; new Thread(ru).start();	
	} 

}
