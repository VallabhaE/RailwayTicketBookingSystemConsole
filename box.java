import java.util.*;

public class box {
    int totalSeats = 24;
    Queue<Integer> lower = new LinkedList<>();
    Queue<Integer> upper = new LinkedList<>();
    Queue<Integer> middle = new LinkedList<>();
    Set<Person> seatsOccupied = new HashSet<>();
    Set<Integer> ticketsPnr = new HashSet<>();
    int[] totalSeatsYet= new int[3];
    
    public box() {
        for (int i = 1; i <= totalSeats; i++) {
            if (i % 3 == 1) {
                lower.add(i);
            } else if (i % 3 == 2) {
                middle.add(i);
            } else {
                upper.add(i);
            }
        }



        totalSeatsYet[0]=8;
        totalSeatsYet[1]=8;
        totalSeatsYet[2]= 8;
    }
   


}


 class Person{
    String name;
    int age;
    int phonenumber;
    int tktId;
    int seatNumber;
    String seatingpos;
}
