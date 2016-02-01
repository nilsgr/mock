package org.gruenewald.mock.mock;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class Main {

	private LapService lapService = new LapService();
	
    @GET
    @Path("check")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean checkNewData() {
        return lapService.checkNewData();
    }
    
    @GET
    @Path("start")
    public void start() {
    	lapService.startRace();
    }
    
    @GET
    @Path("getLap")
    public Lap getLap() {
    	return lapService.getLap();
    }
}
