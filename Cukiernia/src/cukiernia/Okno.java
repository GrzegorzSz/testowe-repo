package cukiernia;

import java.util.Random;

public class Okno implements Runnable {
	boolean maPaczka = false;
	String nazwa;
	Magazyn magazyn;
	Random generator = new Random();
	Thread thread;

	Okno(Magazyn mag, String naz) {
		thread = new Thread(this);
		nazwa = naz;
		magazyn = mag;
		thread.start();
	}

	synchronized void wezPaczka() {
		magazyn.wezPaczka();
		maPaczka = true;
	}

	@Override
	public void run() {
		System.out.println(nazwa+" rusza...");
		while (true) {
			if (!maPaczka) {
				wezPaczka();
			}
			try {
				Thread.sleep(1000 + generator.nextInt(1000));
			} catch (InterruptedException e) {
				
			}
			maPaczka = false;
			System.out.println(nazwa+" zjadlo");
		}
	}

	

}
