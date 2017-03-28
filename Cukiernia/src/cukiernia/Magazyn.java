package cukiernia;

public class Magazyn {
	private int ilosc_paczkow = 10;
	
	public synchronized void nowaDostawa(int ilosc){
		ilosc_paczkow += ilosc;
		System.out.println("Dostarczone " + ilosc + " paczkow. Teraz jest "+getZapas()+" szt.");
		notify();
	}
	public synchronized void wezPaczka(){
		while(ilosc_paczkow == 0)
		{
			try {
				wait(100);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Magazyn wydal "+getZapas());
		ilosc_paczkow --;
		notify();
	}
	public synchronized int getZapas(){
		return ilosc_paczkow;
	}
}
