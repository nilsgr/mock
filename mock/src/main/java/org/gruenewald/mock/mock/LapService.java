package org.gruenewald.mock.mock;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class LapService {
	
	private boolean raceRunning = false;
	public static ArrayList<Lap> laps_driven = new ArrayList<Lap>();
	private Random random;
	
	public static int test = 0; 
	
	public void startRace() {
		random = new Random();
		raceRunning = true;
		
		for (int i=0; i<3; i++) {
			driveLap(i);
		}
	}
	
	public Boolean checkNewData() {
		return true;
	}
	
	public void driveLap(int id) {
		int time = (random.nextInt(5000)+10000);
		Timer timer = new Timer();
		timer.schedule(new CarTimer(this, id, id, time), time);
	}

	public Lap getLap() {
		Lap lap = laps_driven.get(0);
		laps_driven.remove(0);
		return lap;
	}
	
}
