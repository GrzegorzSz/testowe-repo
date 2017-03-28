package cukiernia;

import java.util.concurrent.TimeUnit;

public class TestCukierni {

	public static void main(String[] args) {
	Magazyn magazyn = new Magazyn();
	System.out.println("Na poczatku w magazynie "+magazyn.getZapas()+" szt.");
	Okno okno1 = new Okno(magazyn, "okno_1");
	Okno okno2 = new Okno(magazyn, "okno_2");

	try {
		TimeUnit.SECONDS.sleep(2);
	} catch (InterruptedException e) {
		System.out.println("Blad sleep.");
	}
	magazyn.nowaDostawa(49);
	for (int i=0; i<5; i++){
		magazyn.wezPaczka();
	}
	System.out.println("Zapas: "+magazyn.getZapas()+" szt.");
	
	}

}
