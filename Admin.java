import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    static Scanner input = new Scanner(System.in);

    //----------------Add
    private static void add (FlightList flightList ){
        System.out.println("press 0 to return to the menu or press 1 to continue");
        int cancel = input.nextInt();
        if (cancel  == 0 )
            return;
        System.out.println("Type the Origin");
        String A1 = input.next();
        System.out.println("Type the Destination");
        String A2 = input.next();
        System.out.println("Type the Date");
        String A3 = input.next();
        System.out.println("Type the Time");
        String A4 = input.next();
        System.out.println("Type the Price");
        double A5 = input.nextDouble();
        System.out.println("Type the Number of seats");
        int A6 = input.nextInt();
        String A7 = A1.charAt(1) + A2.substring(0 , 2) + A3.substring(1,4) + A3.substring(5 , 7) +A3.substring(8,10) + A4.substring (0 , 2) +A4.substring(3 , 5);
        flightList.add(A1 , A2 , A3 , A4 , A5 , A6 , A7);
        System.out.println("flight id is"+ A7 +"\n Press 0 to return to the main menu");
        input.nextInt();
    }

    //----------------Default List
    public static void defaultList (FlightList f){
        f.add("Yazd" , "Shiraz" , "1402/2/1" , "20:30" , 1.3 , 340 , "YSh40202012030");
        f.add("Yazd" , "Tehran" , "1402/2/4" , "20:30" , 1.00 , 260 , "YTe40202042030");
        f.add("Yazd" , "Mashhad" , "1402/2/6" , "21:30" , 1.50 , 140 , "YMa40202062130");
        f.add("Yazd" , "Tabriz" , "1402/2/1" , "22:30" , 2.00 , 200 , "YTa40202012230");
        f.add("Yazd" , "Shiraz" , "1402/2/2" , "14:30" , 1.5 , 340 , "YSh40202021430");


    }

    //----------------Update
    private static void update(FlightList flightList){
        int i = remove(flightList);
        if (i == 0){
            return ;
        }
        add(flightList);

    }

    //----------------Schedules
    public static  int schedules (FlightList flightList){
        ArrayList <String> f = flightList.getFlightId1();
        System.out.println("numFlightId\t\tOrigin\tDestination\t\tDate\t\tTime\tPrice\tSeats");
        int j = 0;
        for(int i = 0; i <f.size() ; i++){
            System.out.println("(" + (i+1) + ")\t" + flightList.getFlightId(i) +"\t"+flightList.getOrigin(i)+"\t"+flightList.getDestination(i)+"\t\t\t"+flightList.getDate(i)+"\t" +flightList.getTime(i)+"\t"+flightList.getPrice(i)+"\t\t" +
                    flightList.getSeats(i));
            j = i;
        }
        return j;
    }

    //----------------Remove
    private static int remove (FlightList flightList){
        int j = schedules(flightList);

        System.out.println("Enter num to update \n Enter 0 to return to the admin menu");
        int i ;
        do {
            i = input.nextInt();
            if (i == 0){
                return 0 ;
            }
            flightList.remove((i - 1));
        }while (i < 0 && i >= j);
        return i ;
    }


    public static void admin(FlightList flightList) throws IOException, InterruptedException {
        int num;
        do {
            Cls.cls();
            num = Menu.admin();
            switch (num) {
                case 0:
                    return;
                case 1:
                    Cls.cls();
                    add(flightList);
                    break;
                case 2:
                    Cls.cls();
                    update(flightList);
                    break;
                case 3:
                    Cls.cls();
                    remove(flightList);
                    break;
                case 4:
                    schedules(flightList);
                    System.out.println("Press 0 to return to the main menu");
                    input.nextInt();
                    break;

            }
        }while (true);
    }
}
