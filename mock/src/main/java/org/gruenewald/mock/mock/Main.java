package org.gruenewald.mock.mock;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class Main {

	private LapService lapService = new LapService();
	
	/**
	 * starts the race with 3 cars
	 */
	@GET
    @Path("startRace")
    public void startRace() {
    	lapService.startRace(3);
    }
	
	/**
	 * checks if a race is already running
	 * 
	 * @return boolean raceRunning, true = race is running
	 * 								false = race is NOT running
	 */
	@GET
	@Path("checkRaceRunning")
	public Boolean checkRaceRunning() {
		return lapService.checkRaceRunning();
	}
	
	/**
	 * checks, if there are new laps in the cache
	 * 
	 * @return boolean, true = new laps in cache
	 * 					false = no laps in cache
	 */
    @GET
    @Path("checkNewLaps")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean checkNewLaps() {
        return lapService.checkNewLaps();
    }
    
    /**
     * returns the quantity of laps in cache
     * 
     * @return int, quantity of laps
     */
    @GET
    @Path("quantityOfLaps")
    public int quantityOfLaps() {
		return lapService.quantityOfLaps();
    }
    
    /**
     * returns last driven lap
     * 
     * @return lap, last lap
     */
    @GET
    @Path("getLastLap")
    @Produces(MediaType.APPLICATION_JSON)
    public Lap getLastLap() {
    	return lapService.getLastLap();
    }
    
    /**
     * stops current race
     */
    @GET
    @Path("stopRace")
    public void stopRace() {
    	lapService.stopRace();
    }
}
