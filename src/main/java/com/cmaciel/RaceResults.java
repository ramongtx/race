package com.cmaciel;

import java.util.ArrayList;
import java.util.Collections;

public class RaceResults {
	private class RaceResult implements Comparable<RaceResult> {
		private String tagNumber;
		private TimeDuration time;

		public RaceResult(String tagNumber, TimeDuration time) {
			this.setTagNumber(tagNumber);
			this.setTime(time);
		}

		public void setTagNumber(String tagNumber) {
			this.tagNumber = tagNumber;
		}
		public TimeDuration getTime() {
			return time;
		}
		public void setTime(TimeDuration time) {
			this.time = time;
		}

		public String toString() {
			return String.format("%s - %s", tagNumber, time.toString());
		}

		public int compareTo(RaceResult other) {
			return this.time.compareTo(other.getTime());
		}
	}

	private ArrayList<RaceResult> resultsList;

	public RaceResults() {
		resultsList = new ArrayList<RaceResult>(); 
	}

	public void onNewResult(String tagNumber, TimeDuration resultTime) {
		resultsList.add(new RaceResult(tagNumber, resultTime));
	}

	public void printResults() {
		Collections.sort(resultsList);
		for (RaceResult result: resultsList) {
			System.out.println(result.toString());
		}
	}

	public static void main(String[] args) throws BadBadValueException {

		// One thing that can go wrong with the system is that
		// depending on the examples, it can throw an exception

		RaceResults raceResults = new RaceResults();

		raceResults.onNewResult("AAA", new TimeDuration(300));
		raceResults.onNewResult("BBB", new TimeDuration(340));
		raceResults.onNewResult("CCC", new TimeDuration(124));
		raceResults.onNewResult("DDD", new TimeDuration(80));
		raceResults.onNewResult("EEE", new TimeDuration(730));
		raceResults.onNewResult("FFF", new TimeDuration(7134));

		raceResults.printResults();
	}

}
