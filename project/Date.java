import java.util.Scanner;

enum Month {
    JAN(1), FEB(2), MAR(3), APR(4), MAY(5), JUN(6), JUL(7), AUG(8), SEP(9), OCT(10), NOV(11), DEC(12);

    private int index;
    Month(int index){
        this.index = index;
    }
    public int getindex(){
        return index;
    }
}

public class Date {
    int day, year;
    Month month;

    Date(int day, String month, int year){
        this.day = day;
        this.month = Enum.valueOf(Month.class, month);
        this.year = year;
    }

    Date(){
        // input creation
        Scanner input = new Scanner(System.in);
        
        Boolean errorDetect = false;
        do{

            System.out.print(   "Date (in dd-mm-yyyy)            : ");
            String date = input.nextLine();
            try {
                if(date.charAt(2) == '-' && date.charAt(5) == '-'){
                    day = Integer.parseInt(date.substring(0, 2));
                    month = Month.values()[Integer.parseInt(date.substring(3, 5)) - 1];
                    year = Integer.parseInt(date.substring(6, 10));
                    errorDetect = false;
                }
                else {
                    throw new Exception();
                }

            } catch (Exception e) {
                errorDetect = true;
                System.out.println("+============================================+");
                System.out.println("|              ERROR DETECTED!               |");
                System.out.println("|       DATE SUBMISSION IS INCORRECT!        |");
                System.out.println("|             PLEASE TRY AGAIN!              |");
                System.out.println("+============================================+" + "\n");
            }
        } while(errorDetect);
        
        System.out.println();
        System.out.println("+=============================+" + "\n");
    }

    public String toString(){
        return day + " " + month + " " + year;
    }
}
