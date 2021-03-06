package com.cmaciel;

public class TimeDuration implements Comparable<TimeDuration> {
	private int seconds;

	public TimeDuration(int seconds) throws BadBadValueException {
		this.setSeconds(seconds);
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) throws BadBadValueException {
		if (seconds < 0) throw new BadBadValueException();
		this.seconds = seconds;
	}
	
	public String toString() {
		int hours = seconds / 3600;
		int minutes = ((seconds % 3600) / 60);
		int remainder = seconds % 60;
		
		if (hours > 0) {
			return String.format("%dh %dm %ds", hours, minutes, remainder);
		} else if (minutes > 0) {
			return String.format("%dm %ds", minutes, remainder);
		}
		
		return String.format("%ds", remainder);
	}

	public int compareTo(TimeDuration other) {
		return seconds - other.getSeconds();
	}

}
