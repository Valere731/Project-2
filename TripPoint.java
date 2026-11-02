

	import java.util.ArrayList;
	import java.util.Scanner;
	import java.io.File;
	import java.io.FileNotFoundException;

	
	public class TripPoint {

	    private int time;
	    private double lat;
	    private double lon;

	    private static ArrayList<TripPoint> trip = new ArrayList<TripPoint>();
		public TripPoint (int time, double lat, double lon) {
	        this.time = time;
	        this.lat = lat;
	        this.lon = lon;
	    }
 public int getTime() {
	        return time;
	    }

	    
	    public double getLat() {
	        return lat;
	    }

	    
	    public double getLon() {
	        return lon;
	    }
		public static ArrayList<TripPoint> getTrip() {
	        return new ArrayList<TripPoint>(trip);
	    }


	   
	    
	      
	}

