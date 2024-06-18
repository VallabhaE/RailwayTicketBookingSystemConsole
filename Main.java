import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Booking chennai = new Booking(1);
        Scanner sc = new Scanner(System.in);
        int PNR;

        while(true){
            System.out.println("Hay Welcome To Bunti RailWay Station\n1.selct this option to book tickes\n2.Search Your Tickets\n3.CancelTickets\n4.Exit");
            int optionNumber = sc.nextInt();
            switch (optionNumber){
                case 1:
                    System.out.println("Enter Number of Tickets You Want To Book");
                    sc.nextLine();
                    int tickets = sc.nextInt();
                    chennai.BookTickets(tickets);
                    break;
                case 2:
                    System.out.println("Search tickent Needs PNR Please Enter");
                    PNR = sc.nextInt();
                    chennai.Search(PNR);
                    break;
                case 3:
                    System.out.println("Delete Ticket");
                    PNR = sc.nextInt();
                    chennai.CancelTicket(PNR);
                    break;
                case 4:
                    return;
            }
        }
    }
}
