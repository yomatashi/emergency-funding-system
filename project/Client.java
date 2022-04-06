import java.util.Scanner;
import java.util.Vector;

public abstract class Client {
    private String aClientName;
    private Address aClientAddress;
    private String aClientBankAccNo;
    private Vector<Donation> aClientDonations = new Vector<Donation>();

    Client(String aClientName, Address aClientAddress, String aClientBankAccNo){
        this.aClientName = aClientName;
        this.aClientAddress = aClientAddress;
        this.aClientBankAccNo = aClientBankAccNo;
    }

    Client(){
        //input creation
        Scanner input = new Scanner(System.in);
        
        System.out.println("+===========================================+");
        System.out.println("|            Client Registration            |");
        System.out.println("+===========================================+" + "\n");

        System.out.print("Client's Name                   : ");
        aClientName = input.nextLine();
        aClientAddress = new Address();
        System.out.print("Client's Bank Account Number    : ");
        aClientBankAccNo = input.nextLine();
    }

    void donates(Donation aDonation){
        aClientDonations.addElement(aDonation);
    };

    void donates(String clientType){
        aClientDonations.addElement(new Donation(clientType));
    };

    public Address getClientAddress() {
        return aClientAddress;
    }

    public String getClientBankAccNo() {
        return aClientBankAccNo;
    }

    public Vector<Donation> getClientDonations() {
        return aClientDonations;
    }

    public String getClientName() {
        return aClientName;
    }
    
    abstract void displayClientSummary();
    abstract void displayClientDonations();
}
