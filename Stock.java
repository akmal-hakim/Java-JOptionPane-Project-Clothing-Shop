public class Stock 
{
    private String clothtype;
    private int size;
    private String brands; 
    private double price;
    private String material;
    private int clothCODE;

    public Stock ()
    {
        clothtype = null;
        size = 0;
        brands = null;
        price = 0.0;
        material = null;  
        clothCODE = 0;
    }

    public Stock (int cc , String c, int s, String b, double p, String m)
    {
        clothCODE = cc;
        clothtype = c;
        size = s;
        brands = b;
        price = p;
        material = m;       
    }

    //-----------------------------------------------------------------------------------
    public void setClothCode (int NewClothCode) { clothCODE = NewClothCode ;}

    public void setClothType (String Newclothtype) { clothtype = Newclothtype;}

    public void setSize (int Newsize) { size = Newsize ;}

    public void setBrands (String NewBrands) { brands = NewBrands;} 

    public void setPrice (double Newprice) {price = Newprice;}

    public void setMaterial (String NewMaterial) { material = NewMaterial;}

    //-----------------------------------------------------------------------------------
    public int getClothCode () { return clothCODE;}
  
    public String getClothType () { return clothtype;}

    public int getSize () { return size;}

    public String getBrands () { return brands;}

    public double getPrice () { return price;}

    public String getMaterial () { return material;}

    //-----------------------------------------------------------------------------------

}