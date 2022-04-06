import java.util.*;

public class Company extends Client implements Allocation
{
	private double companyBonus;
    private int companyNo;
	private Vector<Campaign> kempen = new Vector<Campaign>();

	public Company()
    {
		super();
        Scanner input = new Scanner(System.in);
        System.out.print("Company Annual Bonus		: RM ");
        this.companyBonus = input.nextDouble();
        System.out.print("Company Phone Number		: ");
        this.companyNo = input.nextInt();

        System.out.println();
        System.out.println("+=======================================+" + "\n");
    }

    public Company(String aClientName, Address aClientAddress, String aClientBankAccNo, double companyBonus, int companyNo)
	{
		super(aClientName, aClientAddress, aClientBankAccNo);
		this.companyBonus = companyBonus;
        this.companyNo = companyNo;
	}

    public double getCompanyBonus(){
        return companyBonus;
    }

    public int getCompanyNo(){
        return companyNo;
    }

    public String toString(){
        return getClientName();
    }

	public double calcAllocation()
	{
		return companyBonus*PERCENT;
	}

	public void donates(Donation aDonation){
        super.donates(aDonation);
        getClientDonations().addElement(new Donation(getClientDonations().lastElement().getCampaign().getFund() + calcAllocation(), getClientDonations().lastElement().getCampaign(), getClientDonations().lastElement().getDate() ,getClientDonations().lastElement().getRecipient()));
        getClientDonations().removeElementAt(getClientDonations().size() - 2);
		kempen.addElement(getClientDonations().lastElement().getCampaign());
    }

	public Vector<Campaign> getKempen() {
		return kempen;
	}

    public void displayClientSummary()
    {
        System.out.println("+====================================+");
        System.out.println("|        Summary of Company          |");
        System.out.println("+====================================+" + "\n");

        System.out.println("Company             : " + getClientName());
        System.out.println("Address             : " + getClientAddress());
        System.out.println("Company Bank Account: " + getClientBankAccNo());
        System.out.println("Handphone No        : " + companyNo);
        System.out.println("No of Donations     : " + (getClientDonations().size()));
        System.out.println("Last Donation       : RM " + getClientDonations().lastElement().getAmount());
        System.out.println("Last Campaign       : " + kempen.lastElement().getName());
        

        System.out.println();
        System.out.println("+=====================================+");
        System.out.println("\n");
    }

	public void displayClientDonations()
	{
		System.out.println("+====================================+");
        System.out.println("|        Summary of Donations        |");
        System.out.println("+====================================+" + "\n");

		double total = 0;
		for(int i = 0; i < kempen.size(); i++)
		{
			System.out.printf("#%d %-20s RM %.2f %n", (i+1), kempen.elementAt(i).getName(), kempen.elementAt(i).getFund());
			total += getClientDonations().elementAt(i).getAmount();
		}
		System.out.printf("Allocation from the company is RM %.2f %n", calcAllocation());
		System.out.printf("Total donation from %s is RM %.2f %n", getClientName(), total);

        System.out.println();
        System.out.println("+=====================================+");
        System.out.println("\n");
	}
}
