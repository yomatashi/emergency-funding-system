import java.util.Scanner;

public class Address {
    final public int length = 4;
    private String [] address = new String[length];

    Address(String add1, String add2, String postcode, String state){
        address[0] = add1;
        address[1] = add2;
        address[2] = postcode;
        address[3] = state;
    }

    Address(){
        Scanner input = new Scanner(System.in);

        System.out.print("Address Line 1                  : ");
        address[0] = input.nextLine();
        System.out.print("Address Line 2                  : ");
        address[1] = input.nextLine();
        System.out.print("Postcode                        : ");
        address[2] = input.nextLine();
        System.out.print("State                           : ");
        address[3] = input.nextLine();
    }

    public String toString(){
        String fullAddress = new String();
        for(String aAddress: address){
            if(aAddress.equals(address[3]))
                fullAddress += aAddress;
            else
                fullAddress += aAddress + ", ";
        }
        
        return fullAddress;
    }

    public String[] getAddress(){
        return address;
    }
}
