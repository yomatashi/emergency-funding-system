import java.util.Scanner;

public class Campaign
{
	private String campaignName;
	private double fund;

    public Campaign()
	{
        Scanner input = new Scanner(System.in);

		System.out.println("+=====================================================+");
        System.out.println("|                     New Campaign                    |");
        System.out.println("+=====================================================+" + "\n");
        System.out.print("Enter campaign name: ");
        this.campaignName = input.nextLine();
        System.out.print("Enter fund raised: RM");
		this.fund = input.nextDouble();
        
	}

	public Campaign(String campaignName, double fund)
	{
		this.campaignName = campaignName;
		this.fund = fund;
	}

	public String getName()
	{ return campaignName;}

	public double getFund()
	{ return fund; }
}