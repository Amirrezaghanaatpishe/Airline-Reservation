import java.io.IOException;
import java.util.Scanner;

public class Passenger {
    static Scanner input = new Scanner(System.in);
    private String id;
    private int pin;
    private double charge ;
    private Tickets tickets = new Tickets();

    private void booking (FlightList flightList , Tickets tickets){
        Admin.schedules(flightList);
        System.out.println("press 0 to return to the menu or press 1 to continue");
        int cancel = input.nextInt();
        if (cancel  == 0 )
            return;
        System.out.println("Enter num to booking");
        int i = input.nextInt();
        i++;
        if (this.charge >= flightList.getPrice(i) && flightList.getSeats(i+1) != 0) {
            String A1 = flightList.getOrigin(i);
            String A2 = flightList.getDestination(i);
            String A3 = flightList.getDate(i);
            String A4 = flightList.getTime(i);
            String A5 = flightList.getFlightId(i);
            tickets.setNum( A5, A1, A2, A3, A4);
            int j = flightList.getSeats(i) - 1;
            flightList.setSeats(i, j);
            System.out.println("Press 0 to return to the main menu");
            input.nextInt();
        }
        else {
            System.out.println("check your charge and flight seats then try again \tPress 0 to return to the main menu");
            input.nextInt();
        }
    }

    private void canceling (FlightList flightList, Tickets tickets){
        booked(tickets);
        System.out.println("press 0 to return to the menu or press 1 to continue");
        int cancel = input.nextInt();
        if (cancel  == 0 )
            return;
        System.out.println("Enter num to remove");
        int i = input.nextInt();
        i--;
        tickets.remove(i);
        int j = flightList.getSeats(i) + 1;
        flightList.setSeats(i , j);
        System.out.println("Press 0 to return to the main menu");
        input.nextInt();
    }

    private  void booked (Tickets tickets) {

        int num = tickets.size();
        System.out.println("num\tFlightId\t\tOrigin\tDestination\t\tDate\t\tTime");
        for (int i = 0; i < num; i++) {
            System.out.println("(" + (1+i) + ")\t" + tickets.getFlightId(i) + "\t" + tickets.getOrigin(i) + "\t" + tickets.getDestination(i) + "\t\t\t" + tickets.getDate(i) + "\t" + tickets.getTime(i) + "\t");
        }
    }

    private void search (FlightList flightList) throws IOException, InterruptedException {
        Cls.cls();
        Admin.schedules(flightList);
        System.out.println("press 0 to return to the menu or press 1 to continue");
        int cancel = input.nextInt();
        if (cancel  == 0 )
            return;
        System.out.println("Enter origin");
        String A1 = input.next();
        System.out.println("Enter destination");
        String A2 = input.next();
        int length =  flightList.size();
        System.out.println("numFlightId\t\tOrigin\tDestination\t\tDate\t\tTime\tPrice\tSeats");
        for(int i = 0; i <length ; i++){
            if( A1.equals( flightList.getOrigin(i)) && A2.equals(flightList.getDestination(i))) {
                System.out.println("(" + (i + 1) + ")\t" + flightList.getFlightId(i) + "\t" + flightList.getOrigin(i) + "\t" + flightList.getDestination(i) + "\t\t\t" + flightList.getDate(i) + "\t" + flightList.getTime(i) + "\t" + flightList.getPrice(i) + "\t\t" +
                        flightList.getSeats(i));
            }
        }
        System.out.println("Press 0 to return to the main menu");
        input.nextInt();
    }

    public void passenger(FlightList flightList) throws IOException, InterruptedException {
        int num;
        do {
            Cls.cls();
            num = Menu.passenger();
            switch (num) {
                case 0:
                    return;
                case 1:
                    Cls.cls();
                    System.out.println("Enter new password");
                    int pin1 =input.nextInt();
                    this.pin = pin1;
                    break;
                case 2:
                    search(flightList);
                    break;
                case 3:
                    Cls.cls();
                    booking(flightList , this.tickets);
                    break;
                case 4:
                    Cls.cls();
                    canceling(flightList, this.tickets);
                    break;
                case 5:
                    Cls.cls();
                    booked(this.tickets);
                    System.out.println("Press 0 to return to the main menu");
                    input.nextInt();
                    break;
                case 6:
                    Cls.cls();
                    System.out.println("your charge is: ");
                    System.out.println(this.charge);
                    System.out.println("How much do you want");
                    double money = input.nextDouble();
                    this.charge = money;
                    System.out.println("your new charge is: ");
                    System.out.println(this.charge);
                    System.out.println("Press 0 to return to the main menu");
                    input.nextInt();
                    break;
            }
        }while (true);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}

