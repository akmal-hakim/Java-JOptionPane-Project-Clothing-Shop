public abstract class SUPERMEMBER
{
    private int id;
    private String name;
    private int phoneNumber;
    abstract double calDiscount(double k,double d);

    public SUPERMEMBER()
    {
        id = 0;
        name = null;
        phoneNumber = 0;
    }

    public SUPERMEMBER(int id, String name, int phoneNumber)
    {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber; 
    }
    //normal constructor 

    public int getId(){return id;}

    public String getName(){return name;}

    public int getPhone(){return phoneNumber;}

    public void setDate(int newId, String newName, int newPhone)
    {
        id = newId;
        name = newName;
        phoneNumber = newPhone;
    }

    public String toString()
    {
        return "\nID\t: " + id + "\nName\t: " + name + "\nPhone No\t: " + phoneNumber;
    }
    
    public String NakTunjuk()
    {
        return id + "\t: " + name + "\t: " + phoneNumber;
    }
}
 

