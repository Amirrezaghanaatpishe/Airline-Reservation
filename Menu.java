import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);


    //----------------First menu methods
    private static  void firstMenuPrint(){
        System.out.println("********************************************\n\tWELCOME TO AIRLINE RESERVATION SYSTEM\n********************************************\n\t(1) Sign in\n\t(2) Sign up" );
    }
    public static int firstMenu() throws IOException, InterruptedException {
        int num;
        firstMenuPrint();
        num = input.nextInt();
        do{
            switch(num){
                case 1 :
                    return 1;
                case 2:
                    return 2;
                default:
                    Cls.cls();
                    firstMenuPrint();
                    System.err.println("try by another number");
                    num = input.nextInt();
            }
        }while(num !=1 || num != 2);
        return 0;
    }


    //----------------Admin menu methods
    private  static void adminPrint(){
        System.out.println("*************************\n\tADMIN MENU OPTION\n*************************\n\t(1) Add \n\t(2) Update\n\t(3) Remove\n\t(4) Flight Schedules\n\t(0) Sign out" );
    }
    public  static int admin() throws IOException, InterruptedException {
        int num ;
        adminPrint();
        num = input.nextInt();
        do {
            switch (num){
                case 0 :
                    return 0;
                case 1 :
                    return 1;
                case 2 :
                    return 2;
                case 3 :
                    return 3;
                case 4 :
                    return 4;
                default:
                    Cls.cls();
                    adminPrint();
                    System.err.println("try by another number");
                    num = input.nextInt();
            }
        }while(num < 0 || num >4);
        return 0;
    }


    //----------------Passenger menu methods
    private static void passengerMenu(){
        System.out.println("*****************************\n\tPassenger MENU OPTION\n*****************************\n\t(1) Change password \n\t(2) Search flight ticket\n\t(3) Booking ticket\n\t(4) Ticket cancellation\n\t(5) Booked tickets\n\t(6) Add charge\n\t(0) Sign out" );
    }
    public static int passenger() throws IOException, InterruptedException {
        int num ;
        passengerMenu();
        num = input.nextInt();
        do {
            switch (num){
                case 0 :
                    return 0;
                case 1 :
                    return 1;
                case 2 :
                    return 2;
                case 3 :
                    return 3;
                case 4 :
                    return 4;
                case 5 :
                    return 5;
                case 6 :
                    return 6;
                default:
                    Cls.cls();
                    passengerMenu();
                    System.err.println("try by another number");
                    num = input.nextInt();
            }
        }while(num < 0 || num >6);
        return 0;
    }
}
