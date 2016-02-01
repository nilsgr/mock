package org.gruenewald.mock.mock;

import java.util.TimerTask;

public class CarTimer extends TimerTask {
	
	public LapService lapService;
	private Lap lap;
	private int id;
	
	public CarTimer(LapService lapService, int id, int barCode, int time) {
		this.lapService = lapService;
		this.id = id;
		lap = new Lap(id, barCode, time);
	}

	@Override
	public void run() {
		lapService.laps_driven.add(lap);
		System.out.println(lap.getId() + ": " + lap.getTime());
		lapService.driveLap(id);
	}
}
