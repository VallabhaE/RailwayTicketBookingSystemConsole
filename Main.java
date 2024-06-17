import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Booking chennai = new Booking(1);
        chennai.BookTickets(2);
        chennai.PrintParticipents();
        System.out.println("Enter PNR NUMBER TO SEARCH");
        Scanner sc = new Scanner(System.in);
        int PNR = sc.nextInt();

        chennai.Search(PNR);
        chennai.CancelTicket(PNR);
        chennai.Search(PNR);
    }
}
