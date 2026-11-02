

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
	   
	      public static double haversineDistance(TripPoint a, TripPoint b) {
	        double radius = 6371.0;

	        double lat1 = Math.toRadians(a.getLat());
	        double lat2 = Math.toRadians(b.getLat());
	        double lon1 = Math.toRadians(a.getLon());
	        double lon2 = Math.toRadians(b.getLon());

	        double dLat = lat2 - lat1;
	        double dLon = lon2 - lon1;

	        double h = Math.pow(Math.sin(dLat / 2), 2)
	                + Math.cos(lat1) * Math.cos(lat2)
	                * Math.pow(Math.sin(dLon / 2), 2);

	        double angle = 2 * Math.asin(Math.sqrt(Math.min(1.0, Math.max(0.0, h))));

	        return radius * angle;
	    }
		 public static double totalDistance() {
	        if (trip.size() < 2) {
	            return 0.0;
	        }
	        double total = 0.0;
	        for (int i = 1; i < trip.size(); i++) {
	            TripPoint previous = trip.get(i - 1);
	            TripPoint current = trip.get(i);
	            total += haversineDistance(previous, current);
	        }
	        return total;
	    }

	      
	}

