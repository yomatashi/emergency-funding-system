/*  
    Group 13
    Section 08
    EMERGENCY FUNDING SYSTEM
    Ahmad Irfan bin Ishak               A19EC0007
    Adam Najmi bin Mat Noh              A19EC0003
    Muhammad Khairuzzaman bin Kassim    A19EC0101
*/

import java.util.Scanner;
import java.util.Vector;
import java.io.*;

public class DonationApp {
    public static void Welcome(){
        System.out.println("\n---------------------\n"+
                           "Emergency funding app\n"+
                           "---------------------\n\n");
        System.out.println("Which user are you?");
        System.out.println("[1] Admin\n"+
                           "[2] Regular user\n"+
                           "[3} Quit");
    }

    public static void UserView(){
        System.out.println( "\n*****Regular user view*****");
        System.out.println( "[1] Individual\n"+
                            "[2] Company\n"+
                            "[3] Quit");
        System.out.print(   "Select: ");
    }

    public static void CompanyView(){
	        System.out.println( "\n------Company------");
	        System.out.println( "[1] Add new company\n"+
	                            "[2] Display company details\n"+
	                            "[3] Quit");
	        System.out.print(   "Select: ");
    }

    public static void IndividualView(){
		        System.out.println( "\n------Individual------");
		        System.out.println( "[1] Add new donation\n"+
		                            "[2] Display individual details\n"+
		                            "[3] Quit");
		        System.out.print(   "Select: ");
    }
    
    public static void AdminView(){
        System.out.println( "\n*****Admin view*****");
        System.out.println( "[1] Edit donation\n"+
                            "[2] Delete donation\n"+
                            "[3] Quit");
        System.out.print(   "Select: ");
    }

    public static void AdminEditView(){
        System.out.println( "\n------Edit menu------");
        System.out.println( "[1] Edit individual client's donation\n"+
                            "[2] Edit company client's donation");
        System.out.print(   "Select: ");
    }

    public static void AdminEditIndiView(){
        System.out.println( "\n-----Edit individual client-----");
        System.out.println( "[1] Edit donation amount\n"+
                            "[2] Edit donation date\n"+
                            "[3] Edit donation recipient");
        System.out.print(   "Select: ");
    }

    public static void AdminEditCompView(){
        System.out.println( "\n-----Edit company client-----");
        System.out.println( "[1] Edit company bonus\n"+
                            "[2] Edit campaign\n"+
                            "[3] Edit donation date\n"+
                            "[4] Edit donation recipient");
        System.out.print(   "Select: ");
    }

    public static void AdminDeleteView(){
        System.out.println( "\n------Delete menu------");
        System.out.println( "[1] Delete individual client's donation\n"+
                            "[2] Delete company client's donation");
        System.out.print(   "Select: ");
    }

    public static Admin loadProgramAdmin() throws FileNotFoundException{
        //  load admin
        Scanner inputFile = new Scanner(new FileReader("admin.txt"));
        String str1 = inputFile.next();
        String str2 = inputFile.next();
        inputFile.close();

        return new Admin(str1, str2);
    }
    public static Vector<Company> loadProgramComp(){
        //  load comp
        Vector<Company> comp = new Vector<Company>();
        comp.addElement(new Company("Manza Holdings"                , new Address("Floor 8, Ergo Building"          , "Jalan Palembang"                     , "23000"   , "Johor Bahru, Johor"  ), "27569388"   , 50340.60        , 1300832525));
        comp.addElement(new Company("Hyperion"                      , new Address("No. 45, Jalan Gacha 50/50"       , "Kampung Discord"                     , "40460"   , "Shah Alam, Selangor" ), "75978432"   , 25453.70        , 1300832626));
        comp.addElement(new Company("Yoma Sdn Bhd"                  , new Address("No. 8, Jalan BA 4/1"             , "Kawasan Perindustrian Bukit Angkat 4", "43000"   , "Kajang, Selangor"    ), "33569420"   , 33545.50        , 1300832727));

        comp.elementAt(0).donates(new Donation(new Campaign("Kill Hunger"        , 22000 ), new Date(12  , "JAN", 2012), new Recipient("Yayasan Food Bank Malaysia"          , new Address("No. 8, Jalan BA 4/1"   , "Kawasan Perindustrian Bukit Angkat 4", "43000", "Kajang, Selangor"), "Food")));
        comp.elementAt(1).donates(new Donation(new Campaign("Punch Cancer"       , 10000 ), new Date(2   , "MAR", 2009), new Recipient("Hospital Enche' Besar Hajjah Khalsom", new Address("Hostpital Kluang"      , "KM 5, Jalan Kota Tinggi"             , "86000", "Kluang, Selangor"), "Health")));
        comp.elementAt(2).donates(new Donation(new Campaign("Murdering CoViD"    , 50000 ), new Date(3   , "SEP", 2007), new Recipient("Mercy Malaysia"                      , new Address("Unit 19-8, 19th Floor" , "Menara Oval Damansara"               , "60000", "Kuala Lumpur")    , "Health")));

        return comp;
    }
    public static Vector<Individual> loadProgramIndi(){
        
        //  load indv
        Vector<Individual> indv = new Vector<Individual>();
        indv.addElement(new Individual("Adam Najmi"     , new Address("No 38, Jln Azam 13"      , "Taman Sri Lambak"            , "86000"   , "Kluang, Johor"       ), "84234479",  "0105510581",   "000805010623"));
        indv.addElement(new Individual("Ahmad Irfan"    , new Address("No 88, Jalan Simpang 3"  , "Kampung sebelah Petronas"    , "36290"   , "London, Selangor"    ), "832465294", "0113231443",   "001231143113"));
        indv.addElement(new Individual("Khairuzzaman"   , new Address("Floor 77"                , "Taman Universiti"            , "87290"   , "Johor Bahru, Johor"  ), "714673424", "017342734",    "001111011011"));

        indv.elementAt(0).donates(new Donation(100  , new Date(2    , "FEB", 2020), new Recipient("Yayasan Food Bank Malaysia"          , new Address("No. 8, Jalan BA 4/1"   , "Kawasan Perindustrian Bukit Angkat 4", "43000", "Kajang, Selangor"), "Food")));
        indv.elementAt(1).donates(new Donation(50   , new Date(31   , "JAN", 2021), new Recipient("Hospital Enche' Besar Hajjah Khalsom", new Address("Hostpital Kluang"      , "KM 5, Jalan Kota Tinggi"             , "86000", "Kluang, Selangor"), "Health")));
        indv.elementAt(2).donates(new Donation(2.50 , new Date(15   , "MAR", 2019), new Recipient("Mercy Malaysia"                      , new Address("Unit 19-8, 19th Floor" , "Menara Oval Damansara"               , "60000", "Kuala Lumpur")    , "Health")));

        return indv;
    }

    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        Vector<Company> comp    = loadProgramComp();
        Vector<Individual> indv = loadProgramIndi();
        Admin admin1            = loadProgramAdmin();
        
        int choice = -1;
        do{
            Welcome();
            System.out.print("Input: ");
            choice = input.nextInt();
            String ID, pw;
            
            if(choice == 1){
                //admin
                input.nextLine();
                System.out.print("\nStaff ID: ");
                ID = input.nextLine();
                System.out.print("Password: ");
                pw = input.nextLine();
                if(ID.equals(admin1.getUserID()) && pw.equals(admin1.getPw())){
                    int inchoice2 = -1;
                    do{
                        AdminView();
                        inchoice2 = input.nextInt();
                        switch(inchoice2){
                            case 1:
                                //edit
                                AdminEditView();
                                int inchoice3 = input.nextInt();
                                if(inchoice3 == 1){
                                    AdminEditIndiView();
                                    int inchoice4 = input.nextInt();
                                    switch(inchoice4){
                                        case 1:
                                            admin1.editDonationAmount(indv, comp, inchoice3);
                                            break;
                                        case 2:
                                            admin1.editDonationDate(indv, comp, inchoice3);
                                            break;
                                        case 3:
                                            admin1.editDonationRecipient(indv, comp, inchoice3);
                                            break;
                                    }
                                }
                                else if(inchoice3 == 2){
                                    AdminEditCompView();
                                    int inchoice4 = input.nextInt();
                                    switch(inchoice4){
                                        case 1:
                                            admin1.editDonationAmount(indv, comp, inchoice3);
                                            break;
                                        case 2:
                                            admin1.editDonationCampaign(comp);
                                            break;
                                        case 3:
                                            admin1.editDonationDate(indv, comp, inchoice3);
                                            break;
                                        case 4:
                                            admin1.editDonationRecipient(indv, comp, inchoice3);
                                            break;
                                    }
                                }
                                else{
                                    System.out.println("Wrong input!");
                                }
                                break;
                            case 2:
                                //delete
                                AdminDeleteView();
                                inchoice3 = input.nextInt();
                                if(inchoice3 == 1 || inchoice3 == 2){
                                    admin1.deleteDonation(indv, comp, inchoice3);
                                }
                                else{
                                    System.out.println("Wrong input!");
                                }   
                                break;
                            case 3:
                                System.out.println("Exiting admin interface...");
                                break;
                            default:
                                System.out.println("Wrong input!");
                        }
                    }while(inchoice2 != 3);
                }
                else{
                    System.out.println("Wrong staff ID or password!");
                }
            } else if(choice == 2){
                //regular user
                int inchoice2, x, y;
                do{
                        UserView();
                        inchoice2 = input.nextInt();
                        boolean duplicate = false;
                        int indexDuplicate = -1;
                        switch(inchoice2){
                            case 1:
                                //individual
                                IndividualView();
                                x = input.nextInt();
                                switch(x){
                            		case 1:
										//check for dupes
										Individual newIndividual = new Individual();
										duplicate = false;
										indexDuplicate = -1;
										for(Individual aIndividual: indv){
											if(newIndividual.getClientName().equals(aIndividual.getClientName()))   {  duplicate = true;   indexDuplicate = indv.indexOf(aIndividual); }
											else                                    {  duplicate = false;  }
										}

										if(!duplicate){     indv.addElement(newIndividual);     indv.lastElement().donates(new Donation("INDIVIDUAL"));}
										else                                                    indv.elementAt(indexDuplicate).donates(new Donation("INDIVIDUAL"));
										break;
									case 2:
										System.out.println("\nList of individual that have donated:");
										for(int i = 0; i < indv.size(); i++)
										{
											System.out.printf("[%d] %s %n", (i+1), indv.elementAt(i));
										}
										System.out.print("\nChoose an individual information to be display: ");
										int a = input.nextInt();
										indv.elementAt(a-1).displayClientSummary(); 
										indv.elementAt(a-1).displayClientDonations();
										break;
									case 3:
									    System.out.println("Exiting...\n");
									    break;
								}
                                break;
                            case 2:
                                //company
                                //check for dupes
                                do{
								CompanyView();
                                y = input.nextInt();
                                switch(y){
                            		case 1:
										Company newCompany = new Company();
										duplicate = false;
										indexDuplicate = -1;
										for(Company aCompany: comp){
											if(newCompany.getClientName().equals(aCompany.getClientName()))   {  duplicate = true;   indexDuplicate = comp.indexOf(aCompany); }
											else                              {  duplicate = false;  }
										}

										if(!duplicate)  {   comp.addElement(newCompany);  comp.lastElement().donates(new Donation("COMPANY"));}
										else            {   comp.elementAt(indexDuplicate).donates(new Donation("COMPANY")); }
										break;
									case 2:
										System.out.println("\nList of company have donated:");
										for(int i = 0; i < comp.size(); i++)
										{
											System.out.printf("[%d] %s %n", (i+1), comp.elementAt(i));
										}
										System.out.print("\nChoose a company information to be display: ");
										int a = input.nextInt();
										comp.elementAt(a-1).displayClientSummary();
										comp.elementAt(a-1).displayClientDonations();
										break;
									case 3:
										System.out.println("Exiting...\n");
										break;
								}
								}while(y < 3);
								break;
                            case 3:
                                System.out.println("Exiting user interface...\n");
                                break;

                            default:
                                System.out.println("Wrong input!");
                        }
                    }while(inchoice2 < 3);
            }
            else if(choice == 3){
                System.out.println("\nExiting...\nThank you for using the emergency funding app!");
            }
            else{
                System.out.println("Wrong input!");
            }
        }while(choice < 3);
    }
}
