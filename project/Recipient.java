import java.util.Scanner;

class Recipient{
    private String RecName, RecType;
    private Address RecAddress;

    public Recipient(){
        //input creation
        Scanner input = new Scanner(System.in);
        
        System.out.println("+==============================================+");
        System.out.println("|            Recipient Registration            |");
        System.out.println("+==============================================+" + "\n");

        System.out.print("Recipient's Name                : ");
        RecName = input.nextLine();
        RecAddress = new Address();
        System.out.print("Recipient's Type                : ");
        RecType = input.nextLine();
        
        System.out.println();
        System.out.println("+===========================================+" + "\n");
    }

    public Recipient(String RecName, Address RecAddress, String RecType){
        this.RecName = RecName;
        this.RecAddress = RecAddress;
        this.RecType = RecType;
    }
    public Address getAddress(){
        return RecAddress;
    }
    public String getName(){
        return RecName;
    }
    public String getType(){
        return RecType;
    }
}