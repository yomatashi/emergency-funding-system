// import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

class Admin{
    private String userID, pw;

    public Admin(String userID, String pw){
        this.userID = userID;
        this.pw = pw;
    }
    public String getUserID(){
        return userID;
    }
    public String getPw(){
        return pw;
    }
    public void viewIndvName(Vector<Individual> indv){
        System.out.println("\nList of individual client's name: ");
        for(int j = 1; j <= indv.size(); j++){
            System.out.println("["+j+"] "+indv.elementAt(j-1).getClientName());
        }
        System.out.print("Select: ");
    }
    public void viewCompName(Vector<Company> comp){
        System.out.println("\nList of company client's name: ");
        for(int j = 1; j <= comp.size(); j++){
            System.out.println("["+j+"] "+comp.elementAt(j-1).getClientName());
        }
        System.out.print("Select: ");
    }
    public void editDonationAmount(Vector<Individual> indv, Vector<Company> comp, int i){
        Scanner input = new Scanner(System.in);
        int selectCli, selectDon;
        if(i == 1){
            //individual
            viewIndvName(indv);
            selectCli = input.nextInt();
            Vector<Donation> donate = indv.elementAt(selectCli-1).getClientDonations();
            if(donate.isEmpty()){
                System.out.println("There are no donations data for "+indv.elementAt(selectCli-1).getClientName()+" in the app.");
            }
            else{
                System.out.println("\n"+indv.elementAt(selectCli-1).getClientName()+"'s donations: ");
                for(int j= 1; j <= donate.size(); j++){
                    System.out.print("["+j+"] RM");
                    System.out.printf("%.2f", donate.elementAt(j-1).getAmount());
                    System.out.println(" "+donate.elementAt(j-1).getRecipient().getName());
                }
                System.out.print("Select: ");
                selectDon = input.nextInt();
                System.out.print("Enter new amount: RM");
                donate.insertElementAt(new Donation(input.nextDouble(), donate.elementAt(selectDon-1).getDate(), donate.elementAt(selectDon-1).getRecipient()), selectDon-1);
                donate.removeElementAt(selectDon);
                System.out.println("Successfully edited donation amount.");
            }    
        }
        else{
            //company
            // viewCompName(comp);
            System.out.println("\nList of company client's name and bonus: ");
            for(int j = 1; j <= comp.size(); j++){
                System.out.print("["+j+"] "+comp.elementAt(j-1).getClientName()+" RM");
                System.out.printf("%.2f\n", comp.elementAt(j-1).getCompanyBonus());
            }
            System.out.print("Select: ");
            selectCli = input.nextInt();

            Vector<Donation> donate = comp.elementAt(selectCli-1).getClientDonations();
            if(donate.isEmpty()){
                System.out.println("There are no donations data for "+comp.elementAt(selectCli-1).getClientName()+" in the app.");
            }
            else{
                System.out.print("Enter new company's bonus amount: RM");
                comp.insertElementAt(new Company(comp.elementAt(selectCli-1).getClientName(), comp.elementAt(selectCli-1).getClientAddress(), comp.elementAt(selectCli-1).getClientBankAccNo(), input.nextDouble(), comp.elementAt(selectCli-1).getCompanyNo()), selectCli-1);
                
                for(int j = 0; j < donate.size(); j ++){
                    comp.elementAt(selectCli-1).donates(new Donation(donate.elementAt(0).getCampaign(), donate.elementAt(0).getDate(), donate.elementAt(0).getRecipient()));
                    donate.removeElementAt(0);
                }

                comp.removeElementAt(selectCli);
                System.out.println("Successfully edited company's bonus.");
            }   
        }
    }
    public void editDonationCampaign(Vector<Company> comp){ 
        int select, selectCli, selectCam;
        Scanner input = new Scanner(System.in);
        viewCompName(comp);
        selectCli = input.nextInt();
        Campaign campaign;
        Vector<Donation> donate = comp.elementAt(selectCli-1).getClientDonations();
        if(donate.isEmpty()){
            System.out.println("There are no donations data for "+comp.elementAt(selectCli-1).getClientName()+" in the app.");
        } 
        else{
            System.out.println("\nWhich to edit for campaign: \n"+
            "[1] Edit campaign's name\n"+
            "[2] Edit campaign's fund");
            System.out.print("Select: ");
            select = input.nextInt();
            switch(select){
            case 1:
                System.out.println("\nList of campaign's name for "+comp.elementAt(selectCli-1).getClientName());
                for(int j = 1; j<= donate.size(); j++){
                    System.out.println("["+j+"] "+donate.elementAt(j-1).getCampaign().getName());
                }
                System.out.print("Select: ");
                selectCam = input.nextInt();
                System.out.print("Enter new campaign name: ");
                input.nextLine();
                campaign = new Campaign(input.nextLine(), donate.elementAt(selectCam-1).getCampaign().getFund());
                comp.elementAt(selectCli-1).donates(new Donation(campaign, donate.elementAt(selectCam-1).getDate(), donate.elementAt(selectCam-1).getRecipient()));
                // donate.insertElementAt(new Donation(donate.elementAt(selectCam-1).getAmount(), campaign, donate.elementAt(selectCam-1).getDate(), donate.elementAt(selectCam-1).getRecipient()), selectCam-1);
                comp.elementAt(selectCli-1).getKempen().removeElementAt(selectCam-1);
                donate.removeElementAt(selectCam-1);
                break;
            case 2:
                System.out.println("\nList of campaign's name and fund for "+comp.elementAt(selectCli-1).getClientName());
                for(int j = 1; j<= donate.size(); j++){
                    System.out.print("["+j+"] "+donate.elementAt(j-1).getCampaign().getName());
                    System.out.printf(" RM%.2f\n", donate.elementAt(j-1).getCampaign().getFund());
                }
                System.out.print("Select: ");
                selectCam = input.nextInt();
                System.out.print("Enter new campaign fund: RM");
                campaign = new Campaign(donate.elementAt(selectCam-1).getCampaign().getName(), input.nextDouble());
                comp.elementAt(selectCli-1).donates(new Donation(campaign, donate.elementAt(selectCam-1).getDate(), donate.elementAt(selectCam-1).getRecipient()));
                // donate.insertElementAt(new Donation(donate.elementAt(selectCam-1).getAmount(), campaign, donate.elementAt(selectCam-1).getDate(), donate.elementAt(selectCam-1).getRecipient()), selectCam-1);
                comp.elementAt(selectCli-1).getKempen().removeElementAt(selectCam-1);
                donate.removeElementAt(selectCam-1);
                break;
            }
            System.out.println("Successfully edited campaign detail.");
        } 

    }
    public void editDonationDate(Vector<Individual> indv, Vector<Company> comp, int i){
        Scanner input = new Scanner(System.in);
        int selectCli, selectDate;
        if(i == 1){
            //individual
            viewIndvName(indv);
            selectCli = input.nextInt();
            Vector<Donation> donate = indv.elementAt(selectCli-1).getClientDonations();
            if(donate.isEmpty()){
                System.out.println("There are no donations data for "+indv.elementAt(selectCli-1).getClientName()+" in the app.");
            } 
            else{
                System.out.println("\n"+indv.elementAt(selectCli-1).getClientName()+"'s donations: ");
                for(int j= 1; j <= donate.size(); j++){
                    System.out.print("["+j+"] RM");
                    System.out.printf("%.2f", donate.elementAt(j-1).getAmount());
                    System.out.println(" "+donate.elementAt(j-1).getRecipient().getName()+" "+donate.elementAt(j-1).getDate());
                }
                System.out.print("Select: ");
                selectDate = input.nextInt();
                donate.insertElementAt(new Donation(donate.elementAt(selectDate-1).getAmount(), donate.elementAt(selectDate-1).getCampaign(), new Date(), donate.elementAt(selectDate-1).getRecipient()), selectDate-1);
                donate.removeElementAt(selectDate);
                System.out.println("Successfully edited donation date.");
            }    
        }
        else{
            //company
            viewCompName(comp);
            selectCli = input.nextInt();
            Vector<Donation> donate = comp.elementAt(selectCli-1).getClientDonations();  
            if(donate.isEmpty()){
                System.out.println("There are no donations data for "+comp.elementAt(selectCli-1).getClientName()+" in the app.");
            } 
            else{
                System.out.println("\n"+comp.elementAt(selectCli-1).getClientName()+"'s donations: ");
                for(int j= 1; j <= donate.size(); j++){
                    System.out.print("["+j+"] RM");
                    System.out.printf("%.2f", donate.elementAt(j-1).getAmount());
                    System.out.println(" "+donate.elementAt(j-1).getRecipient().getName()+" "+donate.elementAt(j-1).getDate());
                }
                System.out.print("Select: ");
                selectDate = input.nextInt();
                donate.insertElementAt(new Donation(donate.elementAt(selectDate-1).getAmount(), donate.elementAt(selectDate-1).getCampaign(), new Date(), donate.elementAt(selectDate-1).getRecipient()), selectDate-1);
                donate.removeElementAt(selectDate);
                System.out.println("Successfully edited donation date.");
            }  
        }
    }
    public void editDonationRecipient(Vector<Individual> indv, Vector<Company> comp, int i){
        Scanner input = new Scanner(System.in);
        int selectCli, selectRec, select;
        if(i == 1){
            viewIndvName(indv);
            selectCli = input.nextInt();
            Recipient rec;
            Vector<Donation> donate = indv.elementAt(selectCli-1).getClientDonations();
            if(donate.isEmpty()){
                System.out.println("There are no donations data for "+indv.elementAt(selectCli-1).getClientName()+" in the app.");
            }
            else{
                System.out.println("\n"+indv.elementAt(selectCli-1).getClientName()+"'s donations: ");
                for(int j= 1; j <= donate.size(); j++){
                    System.out.print("["+j+"] RM");
                    System.out.printf("%.2f", donate.elementAt(j-1).getAmount());
                    System.out.println(" "+donate.elementAt(j-1).getRecipient().getName()+" "+donate.elementAt(j-1).getRecipient().getType());
                }
                System.out.print("Select: ");
                selectRec = input.nextInt();
                System.out.println("\nWhich to edit for recipient: \n"+
                                   "[1] Edit recipient's name\n"+
                                   "[2] Edit recipient's type\n"+
                                   "[3] Edit recipient's address");
                System.out.print("Select: ");
                select = input.nextInt();
                switch(select){
                    case 1:
                        System.out.print("Enter new recipient name: ");
                        input.nextLine();
                        rec = new Recipient(input.nextLine(), donate.elementAt(selectRec-1).getRecipient().getAddress(), donate.elementAt(selectRec-1).getRecipient().getType());
                        donate.insertElementAt(new Donation(donate.elementAt(selectRec-1).getAmount(), donate.elementAt(selectRec-1).getCampaign(), donate.elementAt(selectRec-1).getDate(), rec), selectRec-1);
                        donate.removeElementAt(selectRec);
                        break;
                    case 2:
                        System.out.print("Enter new recipient type: ");
                        input.nextLine();
                        rec = new Recipient(donate.elementAt(selectRec-1).getRecipient().getName(), donate.elementAt(selectRec-1).getRecipient().getAddress(), input.nextLine());
                        donate.insertElementAt(new Donation(donate.elementAt(selectRec-1).getAmount(), donate.elementAt(selectRec-1).getCampaign(), donate.elementAt(selectRec-1).getDate(), rec), selectRec-1);
                        donate.removeElementAt(selectRec);
                        break;
                    case 3:
                        System.out.println("Enter new recipient address: ");
                        input.nextLine();
                        rec = new Recipient(donate.elementAt(selectRec-1).getRecipient().getName(), new Address(), donate.elementAt(selectRec-1).getRecipient().getType());
                        donate.insertElementAt(new Donation(donate.elementAt(selectRec-1).getAmount(), donate.elementAt(selectRec-1).getCampaign(), donate.elementAt(selectRec-1).getDate(), rec), selectRec-1);
                        donate.removeElementAt(selectRec);
                        break;
                }
                System.out.println("Successfully edited recipient details.");
            }    
        }
        else{
            viewCompName(comp);
            selectCli = input.nextInt();
            Recipient rec;
            Vector<Donation> donate = comp.elementAt(selectCli-1).getClientDonations();
            if(donate.isEmpty()){
                System.out.println("There are no donations data for "+comp.elementAt(selectCli-1).getClientName()+" in the app.");
            }
            else{
                System.out.println("\n"+comp.elementAt(selectCli-1).getClientName()+"'s donations: ");
                for(int j= 1; j <= donate.size(); j++){
                    System.out.print("["+j+"] RM");
                    System.out.printf("%.2f", donate.elementAt(j-1).getAmount());
                    System.out.println(" "+donate.elementAt(j-1).getRecipient().getName()+" "+donate.elementAt(j-1).getRecipient().getType());
                }
                System.out.print("Select: ");
                selectRec = input.nextInt();
                System.out.println("\nWhich to edit for recipient: \n"+
                                   "[1] Edit recipient's name\n"+
                                   "[2] Edit recipient's type\n"+
                                   "[3] Edit recipient's address");
                System.out.print("Select: ");
                select = input.nextInt();
                switch(select){
                    case 1:
                        System.out.print("Enter new recipient name: ");
                        input.nextLine();
                        rec = new Recipient(input.nextLine(), donate.elementAt(selectRec-1).getRecipient().getAddress(), donate.elementAt(selectRec-1).getRecipient().getType());
                        donate.insertElementAt(new Donation(donate.elementAt(selectRec-1).getAmount(), donate.elementAt(selectRec-1).getCampaign(), donate.elementAt(selectRec-1).getDate(), rec), selectRec-1);
                        donate.removeElementAt(selectRec);
                        break;
                    case 2:
                        System.out.print("Enter new recipient type: ");
                        input.nextLine();
                        rec = new Recipient(donate.elementAt(selectRec-1).getRecipient().getName(), donate.elementAt(selectRec-1).getRecipient().getAddress(), input.nextLine());
                        donate.insertElementAt(new Donation(donate.elementAt(selectRec-1).getAmount(), donate.elementAt(selectRec-1).getCampaign(), donate.elementAt(selectRec-1).getDate(), rec), selectRec-1);
                        donate.removeElementAt(selectRec);
                        break;
                    case 3:
                        System.out.println("Enter new recipient address: ");
                        input.nextLine();
                        rec = new Recipient(donate.elementAt(selectRec-1).getRecipient().getName(), new Address(), donate.elementAt(selectRec-1).getRecipient().getType());
                        donate.insertElementAt(new Donation(donate.elementAt(selectRec-1).getAmount(), donate.elementAt(selectRec-1).getCampaign(), donate.elementAt(selectRec-1).getDate(), rec), selectRec-1);
                        donate.removeElementAt(selectRec);
                        break;
                }
                System.out.println("Successfully edited recipient details.");
            }    
        }
    }
    public void deleteDonation(Vector<Individual> indv, Vector<Company> comp, int i){
        Scanner input = new Scanner(System.in);
        int selectCli, selectDon;

        if(i == 1){
            //individual
            viewIndvName(indv);
            selectCli = input.nextInt();
            Vector<Donation> donate = indv.elementAt(selectCli-1).getClientDonations();
            if(donate.isEmpty()){
                System.out.println("There are no donations data for "+indv.elementAt(selectCli-1).getClientName()+" in the app.");
            }
            else{
                System.out.println("\n"+indv.elementAt(selectCli-1).getClientName()+"'s donations: ");
                for(int j= 1; j <= donate.size(); j++){
                    System.out.print("["+j+"] RM");
                    System.out.printf("%.2f", donate.elementAt(j-1).getAmount());
                    System.out.println(" "+donate.elementAt(j-1).getRecipient().getName()+" "+donate.elementAt(j-1).getDate());
                }
                System.out.print("Select: ");
                selectDon = input.nextInt();
                System.out.println("Deleting "+donate.elementAt(selectDon-1).getAmount()+" "+donate.elementAt(selectDon-1).getRecipient().getName()+" "+donate.elementAt(selectDon-1).getDate());
                donate.removeElementAt(selectDon-1);
                System.out.println("Successfully deleted");
            }
        }
        else{
            //company
            viewCompName(comp);
            selectCli = input.nextInt();
            Vector<Donation> donate = comp.elementAt(selectCli-1).getClientDonations();
            if(donate.isEmpty()){
                System.out.println("There are no donations data for "+comp.elementAt(selectCli-1).getClientName()+" in the app.");
            }
            else{
                System.out.println("\n"+comp.elementAt(selectCli-1).getClientName()+"'s donations: ");
                for(int j= 1; j <= donate.size(); j++){
                    System.out.print("["+j+"] RM");
                    System.out.printf("%.2f", donate.elementAt(j-1).getAmount());
                    System.out.println(" "+donate.elementAt(j-1).getRecipient().getName()+" "+donate.elementAt(j-1).getDate());
                }
                System.out.print("Select: ");
                selectDon = input.nextInt();
                System.out.println("Deleting "+donate.elementAt(selectDon-1).getAmount()+" "+donate.elementAt(selectDon-1).getRecipient().getName()+" "+donate.elementAt(selectDon-1).getDate());
                donate.removeElementAt(selectDon-1);
                System.out.println("Successfully deleted");
            }
        }
    }
}