import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField ;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main
{
    public static void main (String args[])throws IOException, Exception
    {
        //----------------------------------------------------------
    
        BufferedReader memberFile = null;
        BufferedReader PremiumMemberFile = null;
        SUPERMEMBER supermember[] = new SUPERMEMBER[100];

        //--------------------------------------------------
        BufferedReader stockFile = null;
        Scanner scanner = new Scanner (System.in);
        int w = 0;
        Stock stock[] = new Stock[100];
        Receipt receipt = new Receipt();
        CUSTOMERSDETAILS customerrr = new CUSTOMERSDETAILS();

        //---------------------------------------UTK USER

        int memberIdCode = 0;
        int insert ;
        int counter = 0; //utk kira member
        int idddz = 0;
        int codebuy;
        int quantitytobuy;
        double discount=0;


        //---------------------------------------
        //utk gambar

        final ImageIcon iconic = new ImageIcon("Kola.png");
        final ImageIcon icon = new ImageIcon("loll.png");
        final ImageIcon iconz = new ImageIcon("lopak.png");
        final ImageIcon icoo = new ImageIcon("found.png");
        final ImageIcon ico = new ImageIcon("takjumpa.png");
        final ImageIcon icZ = new ImageIcon("ALL.png");
        final ImageIcon iconicz = new ImageIcon("THIS.png");

        //UTK BOOLEAN 

        boolean boolVar;
        boolVar=true;     
        boolean booltengok;
        booltengok = true;
        boolean boolnakcheck;
        boolnakcheck = true;
        //UTK KIRA MEMBERS  ----------------------------------------------------------------------------------------------
        try 
        {
            memberFile = new BufferedReader ( new FileReader("NORMAL_MEMBERS.txt"));
            String indata1 = null;

            while ((indata1 = memberFile.readLine()) != null)
            {
                StringTokenizer st = new StringTokenizer(indata1,";");

                String nameMember = st.nextToken();
                int nomborMember = Integer.parseInt(st.nextToken());
                int nomborId = Integer.parseInt(st.nextToken());
                String genderMember = st.nextToken();
                String jobMember = st.nextToken();
                String marriageStatusMember = st.nextToken();

                supermember[counter] = new NORMAL_MEMBER(nomborId,nameMember,nomborMember,jobMember,marriageStatusMember,genderMember);

                counter++;
            } 
            memberFile.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.print("FILE NOT FOUND!");
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        //UTK PREMIUM MEMBER------------------------------------------------------------------- 
        try 
        {
            PremiumMemberFile = new BufferedReader ( new FileReader("PREMIUM_MEMBER.txt"));
            String indata2 = null;

            while ((indata2 = PremiumMemberFile.readLine()) != null)
            {
                StringTokenizer st = new StringTokenizer(indata2,";");

                String nameMemberz = st.nextToken();
                int nomborMemberz = Integer.parseInt(st.nextToken());
                int nomborIdz = Integer.parseInt(st.nextToken());
                String companyNameMember = st.nextToken();
                String typeCompanyM = st.nextToken();
                String companyAddress = st.nextToken();

                supermember[counter] = new PREMIUM_MEMBER(nomborIdz,nameMemberz,nomborMemberz,companyNameMember,companyAddress,typeCompanyM);

                counter++;
            } 
            PremiumMemberFile.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.print("FILE NOT FOUND!");
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        //UTK KIRA STOCK----------------------------------------------------------------------------------------------

        try 
        {
            stockFile = new BufferedReader ( new FileReader("STOCK.txt"));
            String indata = null;

            while ((indata = stockFile.readLine()) != null)
            {
                StringTokenizer st = new StringTokenizer(indata,";");

                int clothCODE = Integer.parseInt (st.nextToken());
                String clothtype = st.nextToken();
                int size = Integer.parseInt(st.nextToken());
                String brands = st.nextToken();
                double price = Double.parseDouble(st.nextToken());
                String material = st.nextToken();

                stock[w] = new Stock(clothCODE,clothtype,size,brands,price,material);

                w++;
            } 
            stockFile.close();
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.print("FILE NOT FOUND!");
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("\f");
        System.out.println("\n=========================================");
        System.out.println("\n    WELCOME TO SEGAMAT CLOTHING STORE    ");
        System.out.println("\n=========================================");
        //-------------------------------------------------------------------------------------

        while (boolVar = true)
        { 
            Object[] messageMenu = { iconic , "                                                                                                   WELCOME TO SEGAMAT CLOTHING STORE                      "}; //+ "\n[1].BUY PRODUCT" + "\n[2]REGISTER MEMBER" + "\n[3].EXIT" + "\n-->" };
            Object[] buttonMenu = { "Buy Product" , "Register Member" , "All Member ", "SEARCH" ,"Exit" };

            insert = JOptionPane.showOptionDialog( null , messageMenu , "THE CLOTHING SYSTEM OPERATOR" , JOptionPane.PLAIN_MESSAGE , JOptionPane.PLAIN_MESSAGE , null , buttonMenu , buttonMenu[0] );
            //nsert = Integer.parseInt(inseno);

            String customername = null;

            if (insert==0)
            {                
                String customerNAMES = null;
                String customerTypeBayar = null;
                String customerPhoneNombor = null;
                JTextField inputName = new JTextField();
                JTextField inputPhoneNum = new JTextField();
                JTextField inputTypePayment = new JTextField();
                //---------

                boolean formProceed;
                int mainForm;
                do
                {

                    formProceed = true;                                 
                    Object[] form = { icon ,"CUSTOMER DETAILS ", "Enter Name : ", inputName , "Enter Phone Number :" , inputPhoneNum , "Enter Type Of Payment C(Cash)/B(Online) :" , inputTypePayment};

                    mainForm = JOptionPane.showConfirmDialog ( null, form , "Main Form",JOptionPane.PLAIN_MESSAGE,JOptionPane.PLAIN_MESSAGE );                

                    customerNAMES = inputName.getText();
                    customerTypeBayar = inputTypePayment.getText();
                    customerPhoneNombor = inputPhoneNum.getText();

                    if ( mainForm == -1 || mainForm == 2) {break;}

                    if ( Pattern.compile("[a-zA-Z]").matcher(customerPhoneNombor ).find() || customerPhoneNombor.equals(" "))
                    {
                        formProceed = false;
                        JOptionPane.showMessageDialog(null, " INVALID PHONE NUMBER INPUT " , "ERR0R",2);    
                    }
                    else if ( Pattern.compile( "[0-9]").matcher(customerNAMES).find() || customerNAMES.equals(" "))
                    {
                        formProceed = false;
                        JOptionPane.showMessageDialog(null, " INVALID NAME INPUT " , "ERR0R",2);
                    }
                    else if ( Pattern.compile( "[0-9]").matcher(customerTypeBayar).find() || customerTypeBayar.equals(" ") || (!customerTypeBayar.equalsIgnoreCase("C") && !customerTypeBayar.equalsIgnoreCase("B") ) )
                    {
                        formProceed = false;
                        JOptionPane.showMessageDialog(null, " INVALID TYPE PAYMENT INPUT " , "ERR0R",2);
                    }
                }
                while(formProceed == false);

                int nakyangbetul = Integer.parseInt(customerPhoneNombor);
                booltengok = true;
                if (JOptionPane.showConfirmDialog(null, "Do you have member :", "Segamat Clothing Store", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                {

                    while(booltengok == true)
                    {

                        String idInString = JOptionPane.showInputDialog("Insert Member ID + \n[0]If don't have member");
                        memberIdCode = Integer.parseInt(idInString);

                        if(memberIdCode != 0)
                        {

                            booltengok = true;
                            for(int zx=0;zx<counter;zx++)
                            {
                                if (supermember[zx].getId() == memberIdCode)
                                {
                                    JOptionPane.showMessageDialog(null,"FOUND MEMBER ID");
                                    JOptionPane.showMessageDialog(null,supermember[zx].toString());

                                    booltengok = false;   
                                }
                            }

                        }
                        else 
                        {
                            booltengok = false;
                        }

                    }
                } 
                else 
                {
                    memberIdCode = 0;
                }

                int you = 200;
                if ( memberIdCode != 0)
                {
                    for(int z=0;z<counter;z++)
                    {
                        if(supermember[z] instanceof NORMAL_MEMBER)
                        {

                            if(supermember[z].getId() == memberIdCode)
                            {
                                discount = 0.1;
                                you = z;
                            }
                        }   
                        else if(supermember[z] instanceof PREMIUM_MEMBER)
                        {

                            if(supermember[z].getId() == memberIdCode)
                            {
                                discount = 0.15;
                                you = z;
                            }
                        }   

                    }

                }

                for (int z=0; z<w;z++)
                {
                    System.out.print("\n========================================");
                    System.out.print("\nCloth Code :" + stock[z].getClothCode());
                    System.out.print("\nCloth Type :" + stock[z].getClothType());
                    System.out.print("\nSize :" + stock[z].getSize());
                    System.out.print("\nBrands :" + stock[z].getBrands());
                    System.out.print("\nPrice :" + stock[z].getPrice());
                    System.out.print("\nMaterial :" + stock[z].getMaterial());
                    System.out.print("\n========================================");
                }

                String forRealQuantity = JOptionPane.showInputDialog("Enter Quantity of Brands To Order :" + "\n(MAX<" + w + ")" + "\n-->");
                int realquantity = Integer.parseInt(forRealQuantity);
                boolean checkini = true;                

                do
                {
                    if (Pattern.compile("[a-zA-Z]").matcher(forRealQuantity).find() || forRealQuantity.equals(" ") || realquantity>w)
                    {
                        forRealQuantity = JOptionPane.showInputDialog("Enter Quantity of Brands To Order :" + "\n(MAX<" + w + ")" + "\n-->");
                        realquantity = Integer.parseInt(forRealQuantity);
                    }
                    else
                    {
                        checkini = false;
                    }
                }while(checkini == true);

                customerrr = new CUSTOMERSDETAILS(customerNAMES,memberIdCode,nakyangbetul,realquantity,customerTypeBayar);

                double govtax = 0.0;
                double nakkira = 0.0;
                for(int zz=0; zz<realquantity; zz++)
                {

                    String entercode;
                    String enterQuantity;
                    JTextField inputCode = new JTextField();
                    JTextField inputQuantity = new JTextField();
                    //---------
                    boolean formProcees;
                    int mainForms;
                    do
                    {

                        formProcees = true;                                 
                        Object[] formd = { iconicz ,"PRODUCT CHOICE ", "ENTER CODE : ", inputCode , "ENTER QUANTITY (Q<=20):" , inputQuantity};     
                        mainForms = JOptionPane.showConfirmDialog ( null , formd , "Main Form", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE );                

                        entercode = inputCode.getText();
                        enterQuantity = inputQuantity.getText();
                        int akuNakTengok;
                        int akuNakKira;
                        int l=0;

                        if ( !Pattern.compile("[0-9]").matcher( entercode ).find() ||  entercode.equals(" ") )
                        {
                            akuNakTengok = 0;
                        }
                        else
                        {
                            akuNakTengok = Integer.parseInt(entercode);                             
                        }

                        if ( !Pattern.compile("[0-9]").matcher( enterQuantity ).find() ||  enterQuantity.equals(" ") )
                        {
                            akuNakKira = 100;
                        }
                        else
                        {
                            akuNakKira = Integer.parseInt(enterQuantity);                           
                        }

                        if ( l==0)
                        {
                            for(int zki=0;zki<w;zki++)
                            {
                                if(akuNakTengok == stock[zki].getClothCode())
                                {
                                    l++;
                                }                              
                            }
                        }

                        if (akuNakKira>20)
                        {
                            formProcees = false;
                            JOptionPane.showMessageDialog(null, " INVALID QUANTITY" , "ERR0R",2);                            
                        }

                        if (l == 0)
                        {
                            formProcees = false;
                            JOptionPane.showMessageDialog(null, " INVALID CLOTH CODE" , "ERR0R",2);    
                        }

                    }while(formProcees == false);

                    codebuy = Integer.parseInt(entercode);
                    quantitytobuy = Integer.parseInt(enterQuantity);

                    for ( int kira=0; kira<w; kira++)
                    {
                        if(stock[kira].getClothCode()==codebuy)
                        {
                            nakkira = nakkira + stock[kira].getPrice()*quantitytobuy;
                            govtax = nakkira*0.06;
                            receipt = new Receipt(customerNAMES,codebuy,stock[kira].getClothType(),stock[kira].getBrands(),stock[kira].getPrice(),quantitytobuy,nakkira,govtax,customerTypeBayar,0.0);
                            JOptionPane.showMessageDialog(null,receipt.toString());
                        }

                    }

                }

                double outputDiscount = 0.0;
                if ( you != 200)
                {
                    for(int z=0;z<counter;z++)
                    {
                        if(supermember[z] instanceof NORMAL_MEMBER)
                        {

                            if(supermember[z].getId() == memberIdCode)
                            {
                                outputDiscount = supermember[z].calDiscount(nakkira,discount);

                            }
                        }   
                        else if(supermember[z] instanceof PREMIUM_MEMBER)
                        {

                            if(supermember[z].getId() == memberIdCode)
                            {
                                outputDiscount = supermember[z].calDiscount(nakkira,discount);

                            }
                        }   

                    }

                }

                receipt = new Receipt(customerNAMES,0,null,null,0.0,0,nakkira,govtax,customerTypeBayar,outputDiscount);
                JOptionPane.showMessageDialog(null,receipt.Display());
                receipt.print();

                JOptionPane.showMessageDialog(null,"PAYMENT HAS BEEN RECEIPT");

                discount = 0;
                memberIdCode = 0;
            }

            //----------------------------------------------------------------------------------------------CREATING MEMBER

            else if (insert == 1)
            {

                int option;
                Object[] messageMenu2 = { iconic , " PLEASE CHOOSE WHICH MEMBER TO REGISTER : "};
                Object[] buttonMenu1 = { "NORMAL MEMBER" , "PREMIUM MEMBER" , "Back" };
                option = JOptionPane.showOptionDialog( null , messageMenu2 , "The Segamat Clothing Store" , JOptionPane.PLAIN_MESSAGE , JOptionPane.PLAIN_MESSAGE , null , buttonMenu1 , buttonMenu1[0] );
                // "[0-9]"[a-zA-Z]
                if (option == 0 )
                {

                    boolean checkinis = true;
                    int sizeee=0;
                    do
                    {
                        String checkperson = JOptionPane.showInputDialog("Enter Number of Person :" + "\n(MAX<5)" + "\n-->");
                        if (!Pattern.compile("[0-9]").matcher(checkperson).find() || checkperson.equals(" ") )
                        {
                            checkinis =true;
                        }
                        else
                        {
                            sizeee = Integer.parseInt(checkperson);
                        }
                        if(sizeee <= 5 && sizeee !=0)
                        {
                            checkinis = false;
                        }
                    }while(checkinis == true);

                    for( int op = 0; op<sizeee; op++)
                    {
                        //System.out.print("\nEnter which member to register" + "\n[N].NORMAL MEMBER" + "\n[P].PREMIUM MEMBER" + "\n-->");
                        //int option = scanner.nextInt();
                        String MemberName = null;
                        boolean checkits = true;
                        do
                        {
                            MemberName = JOptionPane.showInputDialog("Enter Name : " + "\n-->");
                            if (Pattern.compile("[0-9]").matcher(MemberName).find() || MemberName.equals(" ") )
                            {
                                checkits = true;
                            }
                            else
                            {
                                checkits = false;
                            }
                        }while(checkits == true);

                        int MemberPhoneNum = 0;
                        boolean checkint = true;
                        do
                        {
                            String checkfon = JOptionPane.showInputDialog("Enter Phone Number : " + "\n-->");
                            if (!Pattern.compile("[0-9]").matcher(checkfon).find() || checkfon.equals(" ") )
                            {
                                checkint =true;
                            }
                            else
                            {
                                MemberPhoneNum = Integer.parseInt(checkfon);
                                checkint = false;
                            }
                        }while(checkint == true);

                        boolnakcheck = true;
                        while(boolnakcheck == true)
                        {
                            UUID idOne = UUID.randomUUID();
                            String str=""+idOne;        
                            int uid=str.hashCode();
                            String filterStr=""+uid;
                            str=filterStr.replaceAll("-", "");
                            idddz = Integer.parseInt(str);

                            boolnakcheck = false;
                            for (int xy=0;xy<counter;xy++)
                            {
                                if(idddz == supermember[xy].getId())
                                    boolnakcheck = true;
                            }

                        }

                        JOptionPane.showMessageDialog(null,"\nYour ID number :" + idddz);

                        String genderss = null;
                        boolean checkitt = true;
                        do
                        {
                            genderss = JOptionPane.showInputDialog("Enter Gender (M/F) : " + "\n-->");
                            if (Pattern.compile("[0-9]").matcher(genderss).find() || genderss.equals(" ") )
                            {
                                checkitt = true;
                            }
                            if ( genderss.equalsIgnoreCase("M"))
                            {
                                checkitt = false;
                            }
                            if ( genderss.equalsIgnoreCase("F"))
                            {
                                checkitt = false;
                            }
                        }while(checkitt == true);

                        String jobzz = null;
                        boolean checkitzz = true;
                        do
                        {
                            jobzz = JOptionPane.showInputDialog("Enter Occupation : " + "\n-->");
                            if (Pattern.compile("[0-9]").matcher(jobzz).find() || jobzz.equals(" ") )
                            {
                                checkitzz = true;
                            }
                            else
                            {
                                checkitzz = false;
                            }
                        }while(checkitzz == true);

                        String marryStatus = null;
                        boolean checkitta = true;
                        do
                        {
                            marryStatus = JOptionPane.showInputDialog("Marriage Status S(Single)/M(Married) : " + "\n-->");
                            if (Pattern.compile("[0-9]").matcher(marryStatus).find() || marryStatus.equals(" ") )
                            {
                                checkitta = true;
                            }
                            if ( marryStatus.equalsIgnoreCase("S"))
                            {
                                checkitta = false;
                            }
                            if ( marryStatus.equalsIgnoreCase("M"))
                            {
                                checkitta = false;
                            }
                        }while(checkitta == true);

                        JOptionPane.showMessageDialog(null,"complete");
                        supermember[counter] = new NORMAL_MEMBER(idddz,MemberName,MemberPhoneNum,jobzz,marryStatus,genderss);
                        counter++;
                        
                        PrintWriter out = new PrintWriter (new FileWriter("NORMAL_MEMBERS.txt",true));
                        try             
                        {

                            out.print("\n" + MemberName + ";" + MemberPhoneNum + ";" + idddz + ";" + genderss + ";" +jobzz + ";" + marryStatus+ ";");
                            out.close();

                        }
                        catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        }

                        JOptionPane.showMessageDialog(null,"YOUR INFORMATION HAS BEEN KEEP IN DATA");
                    }

                    System.out.println("\f");
                    //System.out.println("Person: ");
                    for(int i = 0 ; i < counter ; i++)
                    {
                        System.out.println(supermember[i].toString());        
                    }

                }

                else if (option == 1)
                {

                    boolean checkinis = true;
                    int sizeee=0;
                    do
                    {
                        String checkperson = JOptionPane.showInputDialog("Enter Number of Person :" + "\n(MAX<5)" + "\n-->");
                        if (!Pattern.compile("[0-9]").matcher(checkperson).find() || checkperson.equals(" ") )
                        {
                            checkinis =true;
                        }
                        else
                        {
                            sizeee = Integer.parseInt(checkperson);
                        }
                        if(sizeee <= 5 && sizeee !=0)
                        {
                            checkinis = false;
                        }
                    }while(checkinis == true);

                    for( int op = 0; op<sizeee; op++)
                    {
                        //System.out.print("\nEnter which member to register" + "\n[N].NORMAL MEMBER" + "\n[P].PREMIUM MEMBER" + "\n-->");
                        //int option = scanner.nextInt();

                        String MemberName = null;
                        boolean checkits = true;
                        do
                        {
                            MemberName = JOptionPane.showInputDialog("Enter Name : " + "\n-->");
                            if (Pattern.compile("[0-9]").matcher(MemberName).find() || MemberName.equals(" ") )
                            {
                                checkits = true;
                            }
                            else
                            {
                                checkits = false;
                            }
                        }while(checkits == true);

                        int MemberPhoneNum = 0;
                        boolean checkint = true;
                        do
                        {
                            String checkfon = JOptionPane.showInputDialog("Enter Phone Number : " + "\n-->");
                            if (!Pattern.compile("[0-9]").matcher(checkfon).find() || checkfon.equals(" ") )
                            {
                                checkint =true;
                            }
                            else
                            {
                                MemberPhoneNum = Integer.parseInt(checkfon);
                                checkint = false;
                            }
                        }while(checkint == true);

                        boolnakcheck = true;
                        while(boolnakcheck == true)
                        {
                            UUID idOne = UUID.randomUUID();
                            String str=""+idOne;        
                            int uid=str.hashCode();
                            String filterStr=""+uid;
                            str=filterStr.replaceAll("-", "");
                            idddz = Integer.parseInt(str);

                            boolnakcheck = false;
                            for (int xy=0;xy<counter;xy++)
                            {
                                if(idddz == supermember[xy].getId())
                                    boolnakcheck = true;
                            }

                        }

                        JOptionPane.showMessageDialog(null,"\nYour ID number :" + idddz);

                        String compName = null;
                        boolean checkitzz = true;
                        do
                        {
                            compName = JOptionPane.showInputDialog("Enter Company Name : " + "\n-->");
                            if (Pattern.compile("[0-9]").matcher(compName).find() || compName.equals(" ") )
                            {
                                checkitzz = true;
                            }
                            else
                            {
                                checkitzz = false;
                            }
                        }while(checkitzz == true);

                        String companyType = null;
                        boolean checkitta = true;
                        do
                        {
                            companyType = JOptionPane.showInputDialog("Enter Company Type G(Goverment)/P(Private) :" + "\n-->");
                            if (Pattern.compile("[0-9]").matcher(companyType).find() || companyType.equals(" ") )
                            {
                                checkitta = true;
                            }
                            if ( companyType.equalsIgnoreCase("G"))
                            {
                                checkitta = false;
                            }
                            if ( companyType.equalsIgnoreCase("P"))
                            {
                                checkitta = false;
                            }
                        }while(checkitta == true);

                        String address = null;
                        boolean checkitzza = true;
                        do
                        {
                            address = JOptionPane.showInputDialog("Enter Company Address : " + "\n-->");
                            if (Pattern.compile("[0-9]").matcher(address).find() || address.equals(" ") )
                            {
                                checkitzza= true;
                            }
                            else
                            {
                                checkitzza = false;
                            }
                        }while(checkitzza == true);

                        JOptionPane.showMessageDialog(null,"complete");

                        supermember[counter] = new PREMIUM_MEMBER(idddz,MemberName,MemberPhoneNum,compName,address,companyType);
                        counter++;

                        try             
                        {
                            PrintWriter out = new PrintWriter (new FileWriter("PREMIUM_MEMBER.txt",true));
                            out.println("\n" +MemberName + ";" + MemberPhoneNum + ";" + idddz + ";" + compName + ";" +companyType + ";" + address +  ";");
                            out.close();
                        }
                        catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        }

                        JOptionPane.showMessageDialog(null,"YOUR INFORMATION HAS BEEN KEEP IN DATA");

                    }    
                    System.out.println("\f");
                    //System.out.println("Person: ");
                    for(int i = 0 ; i < counter ; i++)
                    {
                        System.out.println(supermember[i].toString());        
                    }

                }
            }

            //---------------------------------------------------------------------------------------------------------

            else if (insert == 2)
            {

                if (counter ==0)
                {
                    JOptionPane.showMessageDialog(null,"Unfortunantely there are no member right now");
                }
                else
                {
                    System.out.println("\f");
                    System.out.println("\nALL MEMBER :");
                    System.out.println("ID \t\tNAME \t\tPhone Number");
                    for(int i = 0 ; i < counter ; i++)
                    {
                        System.out.println(supermember[i].NakTunjuk());
                    }
                    JOptionPane.showMessageDialog(null,icZ,"ALL MEMBERS",JOptionPane.PLAIN_MESSAGE);
                }

            }

            //---------------------------------------------------------------------------------------------------------

            else if (insert == 3)
            {
                if (counter ==0)
                {

                    JOptionPane.showMessageDialog(null,"Unfortunantely there are no member right now");

                }
                else
                {
                    int searchID = 0;
                    boolean found = false;
                    boolean checking = true;
                    do
                    {
                        String findID = JOptionPane.showInputDialog(null,"\nEnter id to search :");
                        if (!Pattern.compile("[0-9]").matcher(findID).find() || findID.equals(" ") )
                        {
                            checking =true;
                        }
                        else
                        {
                            searchID = Integer.parseInt(findID);
                            checking = false;
                        }
                    }while(checking == true);

                    for(int i =0;i<counter;i++)
                    {
                        if(supermember[i].getId() == searchID)
                        {
                            JOptionPane.showMessageDialog(null,icoo,"Record Found!",JOptionPane.PLAIN_MESSAGE);
                            JOptionPane.showMessageDialog(null,"Record Found!"+supermember[i].toString());
                            found = true;
                        }
                    }

                    if (!found)
                        JOptionPane.showMessageDialog(null,ico,"Record Not Found! ",JOptionPane.PLAIN_MESSAGE);
                }

            }

            //---------------------------------------------------------------------------------------------------------

            else if (insert == 4)
            {

                //JOptionPane.showMessageDialog(null,"Thank You for Buying at Our Store");
                JOptionPane.showMessageDialog(null,iconz,"Thank You for Buying at Our Store",JOptionPane.PLAIN_MESSAGE);
                break;

            }
        }
    }
}

