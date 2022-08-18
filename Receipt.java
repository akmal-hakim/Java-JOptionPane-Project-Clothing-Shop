import java.io.*;
import java.util.StringTokenizer; 
import java.text.DecimalFormat;
public class Receipt
{
    private String name;
    private int code;
    private String clothtype;
    private String brands;
    private double price;
    private int quantity;
    private double totalprice;
    private double govtax;
    private static DecimalFormat df2 = new DecimalFormat(".00");
    private String typePayment;
    private double discount;


    public Receipt()
    {
        name = null;
        code = 0;
        clothtype =null;
        brands = null;
        price = 0.0;
        quantity = 0;
        totalprice = 0;
        govtax = 0.0;
        typePayment = null;
        discount = 0.0;
    }

    public Receipt(String n, int c, String ct, String b, double p, int q, double tp,double tt,String ty,double d)
    {
        name = n;
        code = c;
        clothtype = ct;
        brands = b;
        price = p;
        quantity = q;
        totalprice = tp;
        govtax = tt;
        typePayment = ty;
        discount = d;
    }

    public String getName(){return name;}

    public int getCode(){return code;}

    public String getClothType(){return clothtype;}

    public String getBrands(){return brands;}

    public double getPrice(){return price;}

    public int getQuantity(){return quantity;}

    public double getTotalPrice(){return totalprice;}

    public double getGovTax(){return govtax;}

    public String getPaymentType(){return typePayment;}

    public double getDiscount(){return discount;}

    //================================================================================

    public void setName(String newName){name=newName;}

    public void setCode(int newCode){code=newCode;}

    public void setClothType(String newClothType){clothtype=newClothType;}

    public void setBrands(String newBrands){brands=newBrands;}

    public void setPrice(double newPrice){price=newPrice;}

    public void setQuantity(int newQuantity){quantity=newQuantity;}

    public void setTotalPrice(double newTotalPrice){totalprice=newTotalPrice;}

    public void setGovTax(double newGovTax){govtax=newGovTax;}

    public void setPaymentType(String newTypePayment){typePayment=newTypePayment;}

    public void setDiscount(double newDiscount){discount=newDiscount;}

    public String toString()//toString()
    {
        return "\nProduct code: " + code + "\nCloth type: " + clothtype + "\nBrands: " + brands + "\nQuantity : " + quantity + "\nPrice : RM" + price + "\nTotal Price : RM" + price*quantity + 
        "\nAccumulated Price (Excluded Gov Tax) : RM" + totalprice + "\nGoverment Tax :"+ df2.format(govtax) ;
    }
    

    public String Display()
    {     
        return ("              TOTAL RECEIPT                  ") +
        ("\n=============================================") +
        ("\nCustomer Name : " + name)+
        ("\nPayment Type : " + typePayment)+
        ("\nAccumulated Price (Excluded Gov Tax) : RM" + df2.format(totalprice))+
        ("\nGoverment Tax :" + df2.format(govtax) )+
        ("\nDiscount Price: " + df2.format(discount)) +
        ("\n=============================================");

    }

    public void print()throws IOException, Exception
    {
        FileWriter fr = new FileWriter("Receipt.txt");
        PrintWriter outfile = new PrintWriter(fr);
        outfile.println("              TOTAL RECEIPT                  ");
        outfile.println("=============================================");
        outfile.println("Customer Name : " + name); 
        outfile.println("Payment Type : " + typePayment);
        outfile.println("Accumulated Price (Excluded Gov Tax) : RM" + totalprice); 
        outfile.println("Goverment Tax :" + govtax ); 
        outfile.println("Discount Price: " + df2.format(discount));
        outfile.println("=============================================");

        outfile.close();

    }

}