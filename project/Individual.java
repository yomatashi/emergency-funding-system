import java.util.Scanner;

public class Individual extends Client{
    private String aIndividualTelNo, aIndividualICNo;

    Individual(){
        super();
        Scanner input = new Scanner(System.in);
        
        System.out.println("+=======================================+");
        System.out.println("|        Individual Registration        |");
        System.out.println("+=======================================+" + "\n");

        System.out.print("Client's Handphone No.          : ");
        aIndividualTelNo = input.nextLine();
        System.out.print("Client's Identification No.     : ");
        aIndividualICNo = input.nextLine();
        
        System.out.println();
        System.out.println("+=======================================+" + "\n");
    }

    Individual(String aClientName, Address aClientAddress, String aClientBankAccNo, String aIndividualTelNo, String aIndividualICNo){
        super(aClientName, aClientAddress, aClientBankAccNo);
        this.aIndividualTelNo = aIndividualTelNo;
        this.aIndividualICNo = aIndividualICNo;
    }

    public String toString(){
        return getClientName();
    }

    void displayClientSummary(){
        //display
        System.out.println("+=====================================+");
        System.out.println("|        Summary of Individual        |");
        System.out.println("+=====================================+" + "\n\n");

        System.out.println("Name                : " + getClientName());
        System.out.println("Address             : " + getClientAddress());
        System.out.println("Bank Account        : " + getClientBankAccNo());
        System.out.println("Handphone No        : " + aIndividualTelNo);
        System.out.println("Identification No   : " + aIndividualICNo);
        System.out.println("No of Donations     : " + (getClientDonations().size()));

        System.out.println();
        System.out.println("+=====================================+");
        System.out.println("\n");
    }

    void displayClientDonations(){
        //display
        System.out.println( "+====================================+");
        System.out.println( "|        Summary of Donations        |");
        System.out.println( "+====================================+" + "\n\n");

        double total = 0;
        int i = 1;
        for(Donation aDonation: getClientDonations()){
            aDonation.displayDonation(i);
            total += aDonation.getAmount();
            i++;
        }
		System.out.printf(  "Total donation from %s is RM %.2f %n", getClientName(), total);

        System.out.println();
        System.out.println("+====================================+");
        System.out.println("\n");
    }
}
