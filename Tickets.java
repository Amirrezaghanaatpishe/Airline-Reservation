import java.util.ArrayList;

public class Tickets {
    private ArrayList<Integer> num = new ArrayList<Integer>();
    private ArrayList<String> flightId = new ArrayList<String>();
    private ArrayList<String> origin = new ArrayList<String>();
    private ArrayList<String> destination = new ArrayList<String>();
    private ArrayList<String> date = new ArrayList<String>();
    private ArrayList<String> time = new ArrayList<String>();

    public void setNum( String flightId , String origin , String destination ,String date, String time) {
        this.flightId.add(flightId);
        this.origin.add(origin)  ;
        this.destination.add(destination) ;
        this.date.add(date);
        this.time.add(time);
    }

    public int size() {
        return flightId.size();
    }

    public Integer getNum(int i) {
        return num.get(i);
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
    public void remove (int i){
        this.origin.remove (i);
        this.destination.remove (i);
        this.date.remove (i);
        this.time.remove (i);
        this.flightId.remove (i);
    }
}
