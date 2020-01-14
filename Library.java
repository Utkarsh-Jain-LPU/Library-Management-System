import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.regex.*;

class Library
{
 static int ch;
 static String un;

 public static void main(String arg[])
 {
  Scanner s_obj = new Scanner(System.in);
  while(true)
  {
   System.out.print("\n\n\n\t\t\t\t-------------------------------\n");
   System.out.print("\t\t\t\t   Library Management System \n"); 
   System.out.print("\t\t\t\t-------------------------------\n\n");
   System.out.print("\n\t\t\t\t\t 1) Login");
   System.out.print("\n\t\t\t\t\t 2) Register");
   System.out.print("\n\t\t\t\t\t 3) Exit");
   System.out.print("\n\n\n\t\t\t\t     Enter your Choice = ");
   ch = s_obj.nextInt();
   s_obj.nextLine();
   switch(ch)
   {
    case 1:
    {
     Login obj = new Login();
     obj.Login();
    }
    break;
    case 2:
    {
     Register obj = new Register();
     obj.Register();
    }
    break;
    case 3:
    {
     System.exit(0);
    }
    break;
    default:
    {
     System.out.print("\n\n\t\t\t\t     ... Wrong Choice ...\n");
    }
   }
  }
 }
}

class Register
{
 static int i,ch,c;
 static String n,cn,temp,pass,cpass,email;
 Scanner obj = new Scanner(System.in);

 public void Register()
 {  
  System.out.print("\n\n\n\t\t\t    Select 0 to Continue and 1 to Back ...");
  System.out.print("\n\n\t\t\t\t    Enter your Choice = ");
  ch = obj.nextInt();
  obj.nextLine();
  if(ch == 1)
  {
  }
  else if(ch == 0)
  {
   System.out.print("\n\n\n\t\t\t\t-------------------------------\n");
   System.out.print("\t\t\t\t            Register          \n"); 
   System.out.print("\t\t\t\t-------------------------------\n\n");
   System.out.print("\n\t\t\t\t         Name = ");
   n = obj.nextLine();
   Main: 
   while(true)
   {
    System.out.print("\t\t\t\t     Password = ");
    temp = obj.nextLine();
    pass = temp.trim();
    if(pass.length()<6 || pass.length()>10)
    {
     System.out.print("\n\n\t\t\t   Password must be of 6 to 10 characters...!!\n");
     System.out.print("\n\n\t\t\t\t         Name = "+n);   
     System.out.print("\n"); 
     continue;
    }
    else
    {
     while(true)
     {
      System.out.print("\t\t\t     Confirm Password = ");
      temp = obj.nextLine();
      cpass = temp.trim();
      if(!pass.equals(cpass))
      {
       System.out.print("\n\n\t\t\t     Confirm Password didn't Matched ...!!\n");
       System.out.print("\n\n\t\t\t\t         Name = "+n);
       System.out.print("\n\t\t\t\t     Password = "+pass);
       System.out.print("\n");
       continue;
      }
      else
      { 
       while(true)
       {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$"; 
        Pattern pat = Pattern.compile(emailRegex); 
        System.out.print("\t\t\t\t       E-mail = ");
        temp = obj.nextLine();
        email = temp.trim();
        if(pat.matcher(email).matches() == false)
        {
         System.out.print("\n\n\t\t\t\t  E-mail must be valid ...!!\n");
         System.out.print("\n\n\t\t\t\t         Name = "+n);
         System.out.print("\n\t\t\t\t     Password = "+pass);
         System.out.print("\n\t\t\t     Confirm Password = "+cpass);
         System.out.print("\n");
         continue;
        }
        else
        {
         Contact:
         while(true)
         {
          System.out.print("\t\t\t\t  Contact No. = ");
          cn = obj.nextLine();
          c = cn.length();
          for(i=0;i<c;i++)
          {
           if((cn.charAt(i)>='a' && cn.charAt(i)<='z') || (cn.charAt(i)>='A' && cn.charAt(i)<='Z'))
           {
            System.out.print("\n\n\t\t\t    Contact Number must be in digits ...!!\n");
            System.out.print("\n\n\t\t\t\t         Name = "+n);
            System.out.print("\n\t\t\t\t     Password = "+pass);
            System.out.print("\n\t\t\t     Confirm Password = "+cpass);
            System.out.print("\n\t\t\t\t       E-mail = "+email);
            System.out.print("\n");
            continue Contact;
           }
          }
          if(c != 10)
          {
           System.out.print("\n\n\t\t\t   Contact Number must be of 10 digits ...!!\n");
           System.out.print("\n\n\t\t\t\t         Name = "+n);
           System.out.print("\n\t\t\t\t     Password = "+pass);
           System.out.print("\n\t\t\t     Confirm Password = "+cpass);
           System.out.print("\n\t\t\t\t       E-mail = "+email);
           System.out.print("\n");
           continue;
          }
          else
          {
           System.out.print("\n\n\t\t\t     Congrats.. Registered Successfull ...");
           FileWriter fw = null;
           FileWriter fw1 = null;
           FileWriter fw2 = null;
           try
           {
            fw = new FileWriter(n+".txt");
            fw1 = new FileWriter(n+"_Books.txt");
            fw2 = new FileWriter("Users.txt",true);
            PrintWriter pw = new PrintWriter(fw);
            PrintWriter pw1 = new PrintWriter(fw1);
            PrintWriter pw2 = new PrintWriter(fw2);
            pw.println(n);
            pw.print(pass);
            pw2.println(n);
            pw.close();
            pw1.close();
            pw2.close();
           }
           catch(IOException e)
           {
            // Exception Caught
           }
           break Main;
          }
         }
        }
       }
      }
     }
    }
   }
  }
  else
  {
   System.out.print("\n\n\t\t\t\t     ... Wrong Choice ...\n");
  }
 }
}

class Login
{
 static int ch;
 static String name,pass,fname,fpass;
 Scanner obj = new Scanner(System.in);

 public void Login()
 {
  System.out.print("\n\n\n\t\t\t    Select 0 to Continue and 1 to Back ...");
  System.out.print("\n\n\t\t\t\t    Enter your Choice = ");
  ch = obj.nextInt();
  obj.nextLine();
  if(ch == 1)
  {
  }
  else if(ch == 0)
  {
   int c=0,p=0;
   System.out.print("\n\n\n\t\t\t\t-------------------------------\n");
   System.out.print("\t\t\t\t             Login            \n"); 
   System.out.print("\t\t\t\t-------------------------------\n");
   System.out.print("\n\t\t\t\t  You have only 3 Attempts...\n");
   while(true)
   {
    System.out.print("\n\n\t\t\t\t         Name = ");
    name = obj.nextLine();
    FileReader fr = null;
    try
    {
     fr = new FileReader(name+".txt");
     BufferedReader br = new BufferedReader(fr);
     fname = br.readLine();
     fpass = br.readLine();
     br.close();
     while(true)
     {
      System.out.print("\t\t\t\t     Password = ");
      pass = obj.nextLine();
      if(!pass.equals(fpass))
      {
       p = p+1;
       System.out.print("\n\n\t\t\t           Password not Matched ...!!\n");
       if(p < 3)
       {
        System.out.print("\n\t\t\t\tYou have only "+(3-p)+" Attempt left...\n");
        System.out.print("\n\n\t\t\t\t         Name = "+name);   
        System.out.print("\n"); 
        continue;
       }
       else
       {
        break;
       }
      }
      else
      {
       System.out.print("\n\n\t\t\t\t     Login Successfull ...");     
       Main obj1 = new Main();
       obj1.Main(name);
       break;
      }
     }
     break;
    }
    catch(FileNotFoundException e)
    { 
     c = c+1;
     System.out.print("\n\n\t\t\t      Name not Available in Database ...!!\n");
     if(c < 3)
     {
      System.out.print("\n\t\t\t\tYou have only "+(3-c)+" Attempt left...\n");
      continue;
     }
     else
     {
      break;
     }
    }
    catch(IOException e)
    {
     // Exception Caught
    }
   }
  }
  else
  {
   System.out.print("\n\n\t\t\t\t     ... Wrong Choice ...\n");
  }
 }
}

class Main
{
 static int ch;
 Scanner obj = new Scanner(System.in);

 public void Main(String name)
 {
  Main:
  while(true)
  {
   System.out.print("\n\n\n\t\t\t\t-------------------------------\n");
   System.out.print("\t\t\t\t   Library Management System \n"); 
   System.out.print("\t\t\t\t-------------------------------\n\n\n");
   System.out.print("\t\t\t\t        ... Welcome ...        \n"); 
   System.out.print("\n\t\t\t\t\t 1) My Books");
   System.out.print("\n\t\t\t\t\t 2) Show Books");
   System.out.print("\n\t\t\t\t\t 3) Issue Books");
   System.out.print("\n\t\t\t\t\t 4) Search Books");
   System.out.print("\n\t\t\t\t\t 5) Return Books");
   System.out.print("\n\t\t\t\t\t 6) Exit");
   System.out.print("\n\n\n\t\t\t\t     Enter your Choice = ");
   ch = obj.nextInt();
   switch(ch)
   {
    case 1:
    {
     int i=1;
     String line;
     FileReader fr = null;
     System.out.print("\n\n\n\t\t\t\t       <-- My Books -->\n\n");
     try
     {
      fr = new FileReader(name+"_Books.txt");
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      while(line != null)
      {
       System.out.print("\n\t\t\t\t"+i+") "+line);
       line = br.readLine();
       i = i+1;
      }
      br.close();
     }
     catch(IOException e)
     {
      // Exception Caught
     }
    }
    break;
    case 2:
    {
     int i=1;
     String line;
     FileReader fr = null;
     System.out.print("\n\n\n\t\t\t\t       <-- All Books -->\n\n");
     try
     {
      fr = new FileReader("Books.txt");
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      while(line != null)
      {
       System.out.print("\n\t\t\t\t\t "+i+") "+line);
       line = br.readLine();
       i = i+1;
      }
      br.close();
     }
     catch(IOException e)
     {
      // Exception Caught
     }
    }
    break;
    case 3:
    {
     
    }
    break;
    case 4:
    {
     
    }
    break;
    case 5:
    {

    }
    break;
    case 6:
    {
     break Main;
    }
    default:
    {
     System.out.print("\n\n\t\t\t\t     ... Wrong Choice ...\n");
    }
   }
  }
 }
}