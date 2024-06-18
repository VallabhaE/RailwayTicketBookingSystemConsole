import java.util.Random;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Booking {
    int Boxes = 1;
    box[] data;
    int currBox=0;
    Random random = new Random();
    int PnrHold = 98793453;

    
    Scanner myObj = new Scanner(System.in);
    public Booking(int numberOfboxs){
        this.Boxes = numberOfboxs;
        data = new box[numberOfboxs];
        for(int i=0;i<numberOfboxs;i++) data[i] = new box();
    }

    int getPnr(int boxNumber){
        int PNR = PnrHold-random.nextInt();
        if(data[boxNumber].ticketsPnr.contains(PNR)) {
            
            return getPnr(boxNumber);
        }
        if (PNR<0) return getPnr(boxNumber);
        return PNR;
    }
    void BookTickets(int totalticketstobebooked){
        if(currBox>=data.length ) {
            System.out.println("Only this seats are Available:"+data[currBox].totalSeats);
            return;
        }
        if(data[currBox].totalSeats ==0 ) {
            System.out.println("Seats Are Over");
            return;
        }
        if(data[currBox].totalSeats>=totalticketstobebooked){
            data[currBox].totalSeats-=totalticketstobebooked;
            for (int i=1;i<=totalticketstobebooked;i++){
                Person datas = new Person();
                System.out.println("Enter Person name");
                datas.name = myObj.nextLine();
                System.out.println("Enter Person age");
                datas.age = myObj.nextInt();
                System.out.println("Enter Person PhoneNumber");
                datas.phonenumber = myObj.nextInt();
                datas.tktId = getPnr(currBox);
                datas.seatingpos = myObj.nextLine();
                System.out.println("Enter Person PrefSeatingLoc");
                datas.seatingpos = myObj.nextLine();
                boolean occupied = false;
                if (datas.seatingpos.equals("l") && !data[currBox].lower.isEmpty()){
                    System.out.println("You Got your Prefred Seating Location");
                    datas.seatNumber = data[currBox].lower.poll();
                    data[currBox].seatsOccupied.add(datas);
                    PrintTickes(datas);
                    data[currBox].totalSeatsYet[0]--;
                    occupied = true;
                }
                else if (datas.seatingpos.equals("m") && !data[currBox].middle.isEmpty()){
                    System.out.println("You Got your Prefred Seating Location");
                    datas.seatNumber = data[currBox].middle.poll();
                    data[currBox].seatsOccupied.add(datas);
                    PrintTickes(datas);

                    data[currBox].totalSeatsYet[1]--;
                    occupied = true;

                }
                else if (datas.seatingpos.equals("u") && !data[currBox].upper.isEmpty()){
                    System.out.println("You Got your Prefred Seating Location");
                    datas.seatNumber = data[currBox].upper.poll();
                    data[currBox].seatsOccupied.add(datas);
                    data[currBox].totalSeatsYet[2]--;
                    PrintTickes(datas);
                    occupied = true;
                }
                if (!occupied){
                    if(data[currBox].totalSeatsYet[0]>0){
                        System.out.println("You Got your Prefred Seating Location");
                        datas.seatNumber = data[currBox].lower.poll();
                        datas.seatingpos = "l";
                    }else if(data[currBox].totalSeatsYet[1]>0){
                        System.out.println("You Got your Prefred Seating Location");
                        datas.seatNumber = data[currBox].middle.poll();
                        datas.seatingpos = "m";
                    }else if(data[currBox].totalSeatsYet[2]>0){
                        System.out.println("You Got your Prefred Seating Location");
                        datas.seatNumber = data[currBox].upper.poll();
                        datas.seatingpos = "u";
                    }
                    data[currBox].seatsOccupied.add(datas);
                    PrintTickes(datas);
                }
            
            }
        }else{
            currBox++;
            BookTickets(totalticketstobebooked);
        }
    }


    void PrintTickes(Person data){
        System.out.println("name: "+data.name+"Age:"+data.age+"Seatnumber - Pos"+data.seatNumber+"-"+data.seatingpos+"\nPNR NUMBER(NOTE: DONT SHARE WITH ANYONE):= "+data.tktId );
    }

    void PrintParticipents(){
        for (box d : data) {
            for(Person p :d.seatsOccupied){
                System.out.println("Name and SeatingPos: "+p.name+" - "+p.seatingpos);
            }
            
        }
    }

    void Search(int PNR){
        for (box d : data) {
            for(Person p :d.seatsOccupied){
                if(p.tktId == PNR){
                    System.out.println("name: "+p.name+"Age:"+p.age+"Seatnumber - Pos"+p.seatNumber+"-"+p.seatingpos);
                    return;
                }
            }
            
        }

        System.out.println("No This PNR NOT EXIST!!!!!!!");
    }



    void CancelTicket(int PNR) {
        boolean removed = false;
    
        outerLoop:
        for(int i = 0; i < data.length; i++) {
            for(Person p : data[i].seatsOccupied){
                if (p.tktId == PNR) {
                    data[i].seatsOccupied.remove(p);
                    removed = true;
                    break outerLoop;
                }
            }
        }
    
        if (removed) {
            System.out.println("Successfully Deleted");
        } else {
            System.out.println("This seat is not found with the PNR number. Please check it");
        }
    }
    
}
