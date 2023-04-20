import java.util.ArrayList;

public class FlightList {
    private ArrayList<String> flightId = new ArrayList<String>();
    private ArrayList<String> origin = new ArrayList<String>();
    private ArrayList<String> destination = new ArrayList<String>();
    private ArrayList<String> date = new ArrayList<String>();
    private ArrayList<String> time = new ArrayList<String>();
    private ArrayList<Double> price = new ArrayList<Double>();
    private ArrayList<Integer> seats = new ArrayList<Integer>();

    public void add(String origin, String destination, String date, String time, Double price, Integer seats , String flightId) {
        this.origin.add ( origin );
        this.destination.add (destination);
        this.date.add (date);
        this.time.add (time);
        this.price.add (price);
        this.seats.add (seats);
        this.flightId.add (flightId);
    }

    public ArrayList<String> getFlightId1() {
        return flightId;
    }
     public int size (){
        return this.origin.size();
     }

    public String getFlightId(int i) {
        return flightId.get(i);
    }

    public String getOrigin(int i) {
        return origin.get(i);
    }

    public String getDestination(int i) {
        return destination.get(i);
    }

    public String getDate(int i) {
        return date.get(i);
    }

    public String getTime(int i) {
        return time.get(i);
    }

    public Double getPrice(int i) {
        return price.get(i);
    }

    public Integer getSeats(int i) {
        return seats.get(i);
    }

    public void remove (int i){
        this.origin.remove ( i );
        this.destination.remove (i);
        this.date.remove (i);
        this.time.remove (i);
        this.price.remove (i);
        this.seats.remove (i);
        this.flightId.remove (i);
    }

    public void setSeats (int i , int j) {
        this.seats.set(i , j);
    }
}
