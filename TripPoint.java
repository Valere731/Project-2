

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
 public static void readFile(String filename) {
	        trip.clear();
	        try {
	            Scanner scanner = new Scanner(new File(filename));
	            
	            
	            if (scanner.hasNextLine()) {
	                scanner.nextLine();
	            }

	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine().trim();
	                if (line.isEmpty()) {
	                    continue;
	                }
	                String[] values = line.split(",");
	                if (values.length < 3) {
	                    continue;
	                }
	                int time = Integer.parseInt(values[0].trim());
	                double lat = Double.parseDouble(values[1].trim());
	                double lon = Double.parseDouble(values[2].trim());

	                TripPoint point = new TripPoint(time, lat, lon);
	                trip.add(point);
	            }
	            scanner.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("File not found.");
	        }
	    }
public static double totalTime() {
	        if (trip.size() <= 1) {
	            return 0.0;
	        }
	        TripPoint first = trip.get(0);
	        TripPoint last = trip.get(trip.size() - 1);
	        int startTime = first.getTime();
	        int endTime = last.getTime();
	        return (endTime - startTime) / 60.0;
	    }
	   
	    
	      
	}

