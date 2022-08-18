public class NORMAL_MEMBER extends SUPERMEMBER
{
    private String JorS;
    private String marriageStatus;
    private String gender;

    public NORMAL_MEMBER()
    {
        super();
        JorS = null;
        marriageStatus = null;
        gender = null;
    }

    public NORMAL_MEMBER(int id, String name, int phoneNumber, String JorS, String marriageStatus, String gender)
    {
        super (id,name,phoneNumber);
        this.JorS = JorS;
        this.marriageStatus = marriageStatus;
        this.gender = gender;
    }

    public double calDiscount(double k,double d)
    {
        double s = k*d;
        return s;

    }

    public String getJorS(){return JorS;}

    public String getMarriageStatus(){return marriageStatus;}

    public String getGender(){return gender;}

    public void setJorS(String NewJorS){JorS = NewJorS;}

    public void setMarriageStatus(String NewMarriageStatus){marriageStatus = NewMarriageStatus;}

    public void setGender(String NewGender){gender = NewGender;}

    public String toString()
    {
        return super.toString() + "\nJob Name: " + JorS + "\nGender : " + gender + "\nMarriage Status : " + marriageStatus; 
    }

}