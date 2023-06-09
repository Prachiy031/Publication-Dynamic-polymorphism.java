import java.util.*;
import java.util.Scanner;


class publication                //parent class
{
    private String title;
    private int price;
    private int copies;
    private int total;
    Scanner sc = new Scanner(System.in);
    public void settitle(String title) 
    {
        this.title=title;
    }
    public void setcopies(int copies) 
    {
        this.copies=copies;
    }
    public String gettitle() 
    {
        return title;
    }
    public int getCopies() 
    {
        return copies;
    }
    public int getTotal() 
    {
        return total;
    }
    public int getprice() 
    {
        return price;
    }
    void read_publ()                //overriden method
    {
        System.out.print("Enter title : ");
        title=sc.next();
        System.out.print("Enter price: ");
        price=sc.nextInt();
        System.out.print("Enter number of copies: ");
        copies=sc.nextInt();
        
    }
    void display()          //overriden method
    {
        System.out.print(title+"\t"+price+"\t"+copies);
    }
    void sale_copy(int number)         //overriden method
    {
        if (number <= copies)
        {
            copies = copies-number;
            total = total + number*price;
            System.out.println("\tYou Purchased "+number +" Copies and you have to pay : "+(price*number));
        }
        else
        System.out.println(" INSUFFICIENT STOCK!!!!!!!!!");
    }
}

class book extends publication          //child class
{
    private String author;
    void order_copies(int number) 
    {
        int x = getCopies()+number;         
        setcopies(getCopies()+number);        
        System.out.println("\n\tORDER SUCESSFUL....");
        System.out.println("\tCopies Available : "+x);
    }
    void read_book()
    {
        read_publ();        //overriding method
        System.out.print("Enter author of book: ");
        author = sc.next();
    }
    void display_book()
    {
        System.out.println("title \tprice \tcopy \tauthor");
        display();            //overriding method
        System.out.println("\t"+author);
    }
}

class magazine extends publication              //child class
{
    private int order_qty;
    private String issue_date;
    void receive_issue(String new_issue_date) 
    {
        System.out.println("Enter new copies ordered: ");
        order_qty = sc.nextInt();
        setcopies(order_qty);           
        issue_date = new_issue_date;
        System.out.println("\tThe Magazine "+gettitle()+" \n\t with issue date "+issue_date+"available");
    }
    void read_mag() 
    {
        read_publ();          //overriding method
        System.out.print("Enter the Current Issue Date [dd/mm/yyyy]");
        issue_date = sc.next();
    }
    void display_mag() 
    {
        System.out.println("title \tprice \tcopy \tdate");
        display();       //overriding method
        System.out.println("\t"+issue_date);
    }
}

public class Publication 
{
  public static void main(String[] args) 
  {
      Scanner sc=new Scanner(System.in);
      book b=new book();
      magazine m=new magazine();
      int outer;
      do {
          System.out.println("\tEnter your choice:\n\t1.BOOK \t\t2.MAGAZINE"
          + "\n\t3.TOTAL SALE AMOUNT\t4.REVENUE OF PUBLICATION\n");
          System.out.print("Choice:");
          int choice = sc.nextInt();
          int a;
          aa:
          if(choice==1) 
          {
              do {
                  int c;
                  System.out.print("\n\tMENU FOR BOOK\n");
                  System.out.print("\t1.read book \t2.display \n\t3.sale copies \t4.order copies");
                  System.out.print("\n\tChoice :");
                  c=sc.nextInt();
                  switch (c)
                  {
                      case 1:
                          System.out.println("==============================================================================\n");
                          b.read_book();
                          System.out.println("==============================================================================\n");
                          break;
                      case 2:
                          System.out.println("==============================================================================\n");
                          b.display_book();
                          System.out.println("==============================================================================\n");
                          break;
                      case 3:
                          System.out.println("==============================================================================\n");
                          System.out.print("how many copies do you(for customer)want?");
                          int n1=sc.nextInt();
                          b.sale_copy(n1);
                          System.out.println("==============================================================================\n");
                          break;
                      case 4:
                          System.out.println("==============================================================================\n");
                          System.out.print("How many copies do you want to order(for shopkeeper)?");
                          int n2=sc.nextInt();
                          b.order_copies(n2);
                          System.out.println("==============================================================================\n");
                          break;
                          default:
                          System.out.println("Invalid");
                  }
                  System.out.println("Do you want to continue with book section[1/0]\n\t1.YES \t\t0.NO");
                  System.out.print("\tChoice:");
                  a=sc.nextInt();
                  if(a==0)
                  break aa;
                  
              }while(a==1);
              
          }
          else if(choice==2)
          {
              mm:
              do 
              {
                  System.out.println("\n\t\tMENU FOR MAGAZINE...\n\n\t1.READ \t\t2.DISPLAY \n\t3.SALE MAGAZINE COPIES \t4.RECEIVE NEW ISSUE\n");
                  int d;
                  System.out.print("\n\tChoice::");
                  d=sc.nextInt();
                  switch(d) {
                      case 1:
                          System.out.println("==============================================================================\n");
                          m.read_mag();
                          System.out.println("==============================================================================\n");
                          break;
                      case 2:
                          System.out.println("==============================================================================\n");
                          m.display_mag();
                          System.out.println("==============================================================================\n");
                          break;
                      case 3:
                          System.out.println("==============================================================================\n");
                          System.out.println("how many copies do you(for customer)want?");
                          int n3 = sc.nextInt();
                          m.sale_copy(n3);
                          System.out.println("==============================================================================\n");
                          break;
                      case 4:
                          System.out.println("==============================================================================\n");
                          System.out.println("Enter the new issue date[dd/mm/yyyy]: ");
                          String date = sc.next();
                          m.receive_issue(date);
                          System.out.println("==============================================================================\n");
                          break;
                      
                  }
                  System.out.println("DO YOU WANT TO CONTINUE WITH MAGAZINE SECTION [1/0]\n\t1.YES\t0.NO");
                  System.out.print("\tChoice::");
                  a=sc.nextInt();
                  if(a==0)
                  break mm;
                  
              }while(a==1);
          }

else if (choice==3) 
{
    System.out.println("\n\tTotal sale amount is(to be paid by customer) = "+(b.getTotal()+m.getTotal())+ " ");
}
else if(choice==4) 
{
    System.out.println("\n\tTotal revenue of publication is : "+ (b.getCopies()*b.getprice() + m.getCopies()*m.getprice()));
}
else
System.out.println("invalid key....");
System.out.println("DO YOU WANT TO CONTINUE WITH PUBLICATION???\n\t1.CONTINUE \t0.TERMINATE");
outer = sc.nextInt();
      }
      while(outer!=0);
      sc.close();
      
  }
}
