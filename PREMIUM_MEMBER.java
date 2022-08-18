public class PREMIUM_MEMBER extends SUPERMEMBER
{
    private String companyName;    
    private String address;
    private String companyType;

    public PREMIUM_MEMBER()
    {
        super();
        companyName = null;
        address = null;
        companyType = null;
    }

    public PREMIUM_MEMBER(int id,String name,int phone,String companyName,String address,String companyType)
    {
        super(id,name,phone);
        this.companyName = companyName;
        this.address = address;
        this.companyType = companyType;
    }

    public String getCompanyName() { return companyName;}

    public String getAddress() { return address;}

    public String getCompanyType() {return companyType;}

    public void setData(String newCompanyName, String newAddress, String newCompanyType)
    {
        companyName = newCompanyName;
        address = newAddress;
        companyType = newCompanyType;        
    }

    public double calDiscount(double k,double d)
    {
        double s = k*d;
        return s;

    }

    public String determineType()
    {
        String compty = null;
        if(companyType.equalsIgnoreCase("G"))
            compty ="Goverment Company";    
        else if (companyType.equalsIgnoreCase("P"))
            compty = "Private Company";

        return compty;
    }

    public String toString()
    {
        return super.toString() + "\nCompany Name: " + companyName + "\nCompany Type : " + determineType() + "\nAddress : " + address;
    }
}
