package org.gruenewald.mock.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Timer;

public class LapService {
	
	static boolean raceRunning = false;
	static ArrayList<Lap> laps_driven = new ArrayList<Lap>();
	private Random random;
	private long time;
	
	/**
	 * starts the race if no one is already running
	 */
	public void startRace(int amountOfCars) {
		time = new Date().getTime();
		if (!raceRunning) {
			random = new Random();
			raceRunning = true;
			
			for (int i=0; i<amountOfCars; i++) {
				driveLap(random.nextInt(1000000), time);
			}
		}
	}
	
	/**
	 * checks if a race is already running
	 * 
	 * @return boolean raceRunning, true = race is running
	 * 								false = race is NOT running
	 */
	public Boolean checkRaceRunning() {
		return raceRunning;
	}
	
	/**
	 * checks, if there are new laps in the cache
	 * 
	 * @return boolean, true = new laps in cache
	 * 					false = no laps in cache
	 */
	public Boolean checkNewLaps() {
		if (laps_driven.size() > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
     * returns the quantity of laps in cache
     * 
     * @return int, quantity of laps
     */
	public int quantityOfLaps() {
		return laps_driven.size();
	}
	
	/**
     * returns last driven lap
     * 
     * @return Lap lap, last lap
     */
	public Lap getLastLap() {
		Lap lap = null;
		if (laps_driven.size() > 0) {
			lap = laps_driven.get(0);
			laps_driven.remove(0);
		}
		return lap;
	}
	
	/**
	 * stops current race
	 */
	public void stopRace() {
		raceRunning = false;
	}
	
	/**
	 * simulates a car
	 * 
	 * @param int barCode
	 */
	public void driveLap(int barCode, long time) {
		int addedTime = (random.nextInt(5000)+10000);
		Timer timer = new Timer();
		timer.schedule(new CarTimer(this, barCode, time, addedTime), addedTime);
	}
}
