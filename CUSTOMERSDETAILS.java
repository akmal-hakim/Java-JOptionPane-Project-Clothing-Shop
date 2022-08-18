public class CUSTOMERSDETAILS 
{
    private String customerName;
    private int customerID;
    private int customerPhone;
    private int quantity;
    private String typePayment;

    public CUSTOMERSDETAILS()
    {
        customerName = null;
        customerID = 0;
        customerPhone = 0;
        quantity = 0;
        typePayment = null;
    }

    public CUSTOMERSDETAILS(String n,int c, int p, int b,String t)
    {
        customerName = n;
        customerID = c;
        customerPhone = p;
        quantity = b;
        typePayment = t;
    }

    public void setCustomerID (int NewCustomerID) { customerID = NewCustomerID;}


    public void setCustomerName (String NewCustomerName) { customerName = NewCustomerName ;}


    public void setCustomerPhon (int NewCustomerPhon) { customerPhone = NewCustomerPhon;} 


    public void setBuyQuantity (int NewBuyQuantity) { quantity = NewBuyQuantity;}


    public void setTypePayment (String NewTypePayment) { typePayment = NewTypePayment;}

    //-----------------------------------------------------------------------------------
    
    public int getCustomerID () { return customerID;}


    public String getCustomerName () { return customerName;}


    public int getCustomerPhon () { return customerPhone;}


    public int getBuyQuantity () { return quantity;}


    public String getTypePayment () { return typePayment;}

    //-----------------------------------------------------------------------------------
    

    
}