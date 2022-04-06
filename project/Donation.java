import java.util.Scanner;

public class Donation {
    private double aAmount;
    private Campaign aCampaign;
    private Recipient aRecipient;
    private Date aDate;
    

    Donation(String clientType){
        //input creation
        Scanner input = new Scanner(System.in);
        
        

        
        try {
            if(clientType.equals("COMPANY")){
                
                aRecipient = new Recipient();
                aDate = new Date();
                clientType.toUpperCase();
                aCampaign = new Campaign();
            }
            else
            if(clientType.equals("INDIVIDUAL")){

                System.out.print("Donation's Amount               : RM");
                aAmount = input.nextDouble();
                aRecipient = new Recipient();
                aDate = new Date();
                clientType.toUpperCase();
            }
            else {
                throw new Exception();
            }
            
        } catch (Exception e) {
            System.out.println("+=======================================+");
            System.out.println("|            ERROR DETECTED!            |");
            System.out.println("|       TYPE OF CLIENT IS INVALID!      |");
            System.out.println("|       CALL ADMIN FOR ASSISTANCE!      |");
            System.out.println("+=======================================+" + "\n");
        }
        
        System.out.println();
        System.out.println("+===========================================+" + "\n");
    };

    Donation(double aAmount, Campaign aCampaign, Date aDate, Recipient aRecipient){
        this.aAmount = aAmount;
        this.aCampaign = aCampaign;
        this.aDate = aDate;
        this.aRecipient = aRecipient;
    };

    Donation(Campaign aCampaign, Date aDate, Recipient aRecipient){
        this.aCampaign = aCampaign;
        this.aDate = aDate;
        this.aRecipient = aRecipient;
    }

    Donation(double aAmount, Date aDate, Recipient aRecipient){
        this.aAmount = aAmount;
        this.aDate = aDate;
        this.aRecipient = aRecipient;
    }

    public double getAmount() {
        return aAmount;
    }

    public Recipient getRecipient(){
        return aRecipient;
    }

    public Campaign getCampaign() {
        return aCampaign;
    }

    public Date getDate() {
        return aDate;
    }

    public void setAmount(double aAmount) {
        this.aAmount = aAmount;
    }

    public void setCampaign(Campaign aCampaign) {
        this.aCampaign = aCampaign;
    }

    public void setDate(Date aDate) {
        this.aDate = aDate;
    }

    public void setRecipient(Recipient aRecipient) {
        this.aRecipient = aRecipient;
    }

    public void displayDonation(int i){
        System.out.println(String.format(   "   Summary of Donation %d", i));
        System.out.println(                 "   Amount              : RM" + String.format("%.2f", aAmount));
        if(aCampaign != null)
            System.out.println(             "   Campaign            : " + aCampaign.getName());
        else
            System.out.println(             "   Campaign            : Not applicable");
        System.out.println(                 "   Date of donation    : " + aDate);
        System.out.println();

        System.out.println(                 "    +=================================+    ");
        System.out.println(                 "    |        Recipient Details        |    ");
        System.out.println(                 "    +=================================+    " + "\n");
        System.out.println(                 "   Name                : " + aRecipient.getName());
        System.out.println(                 "   Type                : " + aRecipient.getType());
        System.out.println(                 "   Address             : " + aRecipient.getAddress());

        System.out.println();
        System.out.println(                 "+==============================================+");
        System.out.println("\n");
    }
}
