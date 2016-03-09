package org.gruenewald.mock.mock;

import java.util.TimerTask;

public class CarTimer extends TimerTask {
	
	public LapService lapService;
	private Lap lap;
	private int barCode;
	private long newTime;
	
	public CarTimer(LapService lapService, int barCode, long oldTime, long addedTime) {
		this.lapService = lapService;
		this.barCode = barCode;
		newTime = oldTime+addedTime;
		lap = new Lap(barCode, newTime);
	}

	@Override
	public void run() {
		LapService.laps_driven.add(lap);
		System.out.println(lap.getBarCode() + ": " + lap.getTime());
		if ( LapService.raceRunning == true ) {
			lapService.driveLap(barCode, newTime);
		}
	}
}
