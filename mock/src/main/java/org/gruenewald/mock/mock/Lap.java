package org.gruenewald.mock.mock;

public class Lap {
	
	private int id;
	private int barCode;
	private int time;
	
	public Lap() {
	}
	
	Lap(int id, int barCode, int time) {
		this.id = id;
		this.barCode = barCode;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBarCode() {
		return barCode;
	}

	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	
}
