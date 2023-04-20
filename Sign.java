import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Sign {
    static Scanner input = new Scanner(System.in);

    private static void guide (){
        System.out.println("All amounts are in millions of Tomans\nEnter any number to continue");
        input.nextInt();
    }
    private static void signIn (Passenger[] passengers , FlightList flightList , int i) throws IOException, InterruptedException {
        int flag = 0 ;
        String adminId = "40238243";
        int adminPin = 1382;
        while (flag==0){
            System.out.println("Enter your user name");
            String id= input.next();
            System.out.println("Enter your pin");
            int pin = input.nextInt();
            if (id.equals("40238243") && pin ==1382){
                guide();
                Admin.admin(flightList);
                return;
            }
            for (int j = 0; j <= i ; j++) {
                if (id.equals(passengers[j].getId())  && pin == passengers[j].getPin()) {
                    guide();
                    passengers[j].passenger(flightList);
                    return;
                }
            }
            System.err.println("username or PIN is incorrect");
        }
    }

    private static int idChecker (Passenger[] passengers , String id , int i){
        for (int j = 0 ; j <= i ; j++){
            if (id.equals(passengers[j].getId())){
                return 0;
            }
        }
        return 1 ;
    }
    private static  void signUp (Passenger[] passengers , int i) throws IOException, InterruptedException {
        passengers[i+1] = new Passenger();
        String id ;
        System.out.println("Enter your user name is : " );
        int flag = 0;
        while (flag == 0){
            id = input.next();
            flag = idChecker( passengers , id , i);
            if ( flag == 1 ) {
                passengers[i + 1].setId(id);
                break;
            }
            else
                System.out.println("try by another number");
        }
        System.out.println("Enter your pin (only number)");
        passengers[i+1].setPin(input.nextInt());

    }
    public static void sign () throws IOException, InterruptedException {
        FlightList flightList = new FlightList();
        Admin.defaultList(flightList);
        Passenger[] passengers = new Passenger[100];
        passengers[0] = new Passenger();
        passengers[0].setId("402000");
        passengers[0].setPin(1111);
        int i = 0;
        while (true) {
            Cls.cls();
            int num = Menu.firstMenu();
            switch (num) {
                case 1:
                    Cls.cls();
                    signIn(passengers , flightList , i);
                    break;
                case 2:
                    Cls.cls();
                    signUp(passengers , i);
                    i++;
                    break;
            }
        }
    }
}
