import java.io.*;
import java.lang.*;
import java.util.*;

class Admin
{
 public static void main(String arg[])
 {
  int c=0;
  String name,pass;
  Scanner s_obj = new Scanner(System.in);

  Login:
  while(true)
  { 
   System.out.print("\n\n\n\t\t\t\t-------------------------------\n");
   System.out.print("\t\t\t\t         LMS for Admin  \n"); 
   System.out.print("\t\t\t\t-------------------------------\n\n");
   System.out.print("\n\t\t\t\t  You have only 3 Attempts...\n");
   while(true)
   {
    System.out.print("\n\n\t\t\t\t         Name = ");
    name = s_obj.nextLine();
    if(!name.equals("Utkarsh"))
    {
     c = c+1;
     System.out.print("\n\n\t\t\t\t       Invalid Name ...!!\n");
     if(c < 3)
     {
      System.out.print("\n\t\t\t\tYou have only "+(3-c)+" Attempt left...\n");
      continue;
     }
     else
     {
      break Login;
     }
    }
    else
    {
     while(true)
     {
      System.out.print("\t\t\t\t     Password = ");
      pass = s_obj.nextLine();
      if(!pass.equals("qwerty"))
      {
       c = c+1;
       System.out.print("\n\n\t\t\t           Password not Matched ...!!\n");
       if(c < 3)
       {
        System.out.print("\n\t\t\t\tYou have only "+(3-c)+" Attempt left...\n");
        System.out.print("\n\n\t\t\t\t         Name = "+name);   
        System.out.print("\n"); 
        continue;
       }
       else
       {
        break Login;
       }
      }
      else
      {
       System.out.print("\n\n\t\t\t\t     Login Successfull ...");   
       Data obj = new Data();
       obj.Data();  
       break Login;
      }
     }
    }
   }
  }
 }
}

class Data
{
 static int ch;
 Scanner obj = new Scanner(System.in);

 public void Data()
 {
  while(true)
  {
   System.out.print("\n\n\n\t\t\t\t-------------------------------\n");
   System.out.print("\t\t\t\t\t  Admin Module \n"); 
   System.out.print("\t\t\t\t-------------------------------\n\n");
   System.out.print("\t\t\t\t        ... Welcome ...        \n\n"); 
   System.out.print("\n\t\t\t\t\t1) User Module");
   System.out.print("\n\t\t\t\t\t2) Library Module");
   System.out.print("\n\t\t\t\t\t3) Exit");
   System.out.print("\n\n\n\t\t\t\t     Enter your Choice = ");
   ch = obj.nextInt();
   switch(ch)
   {
    case 1:
    {
     User obj = new User();
     obj.User();
    }
    break;
    case 2:
    {
     Books obj = new Books();
     obj.Books();
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

class User
{
 static int ch;
 static String un;
 Scanner obj = new Scanner(System.in);

 public void User()
 {
  Users:
  while(true)
  {
   System.out.print("\n\n\n\t\t\t\t-------------------------------\n");
   System.out.print("\t\t\t\t\t  User Module \n"); 
   System.out.print("\t\t\t\t-------------------------------\n\n");
   System.out.print("\n\t\t\t\t       1) Show Users");
   System.out.print("\n\t\t\t\t       2) Search Users");
   System.out.print("\n\t\t\t\t       3) Delete Users");
   System.out.print("\n\t\t\t\t       4) Exit");
   System.out.print("\n\n\n\t\t\t\t     Enter your Choice = ");
   ch = obj.nextInt();
   obj.nextLine();
   switch(ch)
   {
    case 1:
    {
     int i=1;
     String line;
     FileReader fr = null;
     System.out.print("\n\n\n\t\t\t\t       <-- All Users -->\n\n");
     try
     {
      fr = new FileReader("Users.txt");
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
    case 2:
    {
     int i=1;
     String line;
     FileReader fr = null;
     System.out.print("\n\n\n\t\t\t\t  Enter User's Name = ");
     un = obj.nextLine();
     System.out.print("\n\n");
     try
     {
      fr = new FileReader("Users.txt");
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      while(line != null)
      {
       if(line.equals(un) == true)
       {
        i = i*0;
        System.out.print("\n\t\t\t  Congrats.. "+un+" is found in the Database ...\n");
        break;
       }
       else
       {
        i = i+1;
        line = br.readLine();
        continue;
       }
      }
      if(i>0)
      {
       System.out.print("\n\t\t\t Sorry.. "+un+" is not found in the Database...!!\n");
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
     int i=0;
     String line;
     File file = null;
     FileReader fr = null;
     FileWriter fw = null;
     System.out.print("\n\n\n\t\t\t\t  Enter User's Name = ");
     un = obj.nextLine();
     System.out.print("\n\n");
     try
     {
      fr = new FileReader("Users.txt");
      file = new File("temp.txt");
      fw = new FileWriter("temp.txt",true);
      PrintWriter pw = new PrintWriter(fw);
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      while(line != null)
      {
       if(line.equals(un) == false)
       {
        pw.println(line);
       }
       else
       {
        i = i+1;
       }
       line = br.readLine();
      }
      FileWriter fr10 = new FileWriter("Users.txt");
      PrintWriter pw10 = new PrintWriter(fr10);
      pw10.print(""); 
      pw10.close();
      br.close();
      pw.close();
      try
      {
       FileReader fr1 = new FileReader("temp.txt"); 
       FileWriter fw1 = new FileWriter("Users.txt",true); 
       PrintWriter pw1 = new PrintWriter(fw1);
       BufferedReader br1 = new BufferedReader(fr1);
       line = br1.readLine();
       while(line != null)
       {
        pw1.println(line);
        line = br1.readLine();
       } 
       br1.close();
       pw1.close();
       file.delete();
      }
      catch(IOException e)
      {
       // Exception Caught
      }
      catch(NullPointerException e)
      {
       // Exception Caught
      }
      if(i>0)
      { 
       File file0 = new File(un+".txt");
       File file1 = new File(un+"_Books.txt");
       file0.delete();
       file1.delete();
       System.out.print("\n\t\t\t  Congrats.. "+un+" is Successfully deleted ...\n");
      }
      else
      {
       System.out.print("\n\t\t\t Sorry.. "+un+" is not found in the Database...!!\n");
      }
     }
     catch(IOException e)
     {
      // Exception Caught
     }
    }
    break;
    case 4:
    {
     break Users;
    }
    default:
    {
     System.out.print("\n\n\t\t\t\t     ... Wrong Choice ...\n");
    }
   }
  }
 }
}

class Books
{
 static int ch;
 static String un; 
 Scanner obj = new Scanner(System.in);

 public void Books()
 {
  Books:
  while(true)
  {
   System.out.print("\n\n\n\t\t\t\t-------------------------------\n");
   System.out.print("\t\t\t\t\tLibrary Module \n"); 
   System.out.print("\t\t\t\t-------------------------------\n\n");
   System.out.print("\n\t\t\t\t     1) Add Books");
   System.out.print("\n\t\t\t\t     2) Show Books");
   System.out.print("\n\t\t\t\t     3) Search Books");
   System.out.print("\n\t\t\t\t     4) Delete Books");
   System.out.print("\n\t\t\t\t     5) Show Issued Books");
   System.out.print("\n\t\t\t\t     6) Show Returned Books");
   System.out.print("\n\t\t\t\t     7) Exit");
   System.out.print("\n\n\n\t\t\t\t     Enter your Choice = ");
   ch = obj.nextInt();
   obj.nextLine();
   switch(ch)
   {
    case 1:
    {

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
     int i=0;
     String line;
     File file = null;
     FileReader fr = null;
     FileWriter fw = null;
     System.out.print("\n\n\n\t\t\t\t  Enter Book's Name = ");
     un = obj.nextLine();
     System.out.print("\n\n");
     try
     {
      fr = new FileReader("Books.txt");
      file = new File("temp.txt");
      fw = new FileWriter("temp.txt",true);
      PrintWriter pw = new PrintWriter(fw);
      BufferedReader br = new BufferedReader(fr);
      line = br.readLine();
      while(line != null)
      {
       if(line.equals(un) == false)
       {
        pw.println(line);
       }
       else
       {
        i = i+1;
       }
       line = br.readLine();
      }
      FileWriter fr10 = new FileWriter("Books.txt");
      PrintWriter pw10 = new PrintWriter(fr10);
      pw10.print(""); 
      pw10.close();
      br.close();
      pw.close();
      try
      {
       FileReader fr1 = new FileReader("temp.txt"); 
       FileWriter fw1 = new FileWriter("Books.txt",true); 
       PrintWriter pw1 = new PrintWriter(fw1);
       BufferedReader br1 = new BufferedReader(fr1);
       line = br1.readLine();
       while(line != null)
       {
        pw1.println(line);
        line = br1.readLine();
       } 
       br1.close();
       pw1.close();
       file.delete();
      }
      catch(IOException e)
      {
       // Exception Caught
      }
      catch(NullPointerException e)
      {
       // Exception Caught
      }
      if(i>0)
      { 
       System.out.print("\n\t\t\t  Congrats.. "+un+" is Successfully deleted ...\n");
      }
      else
      {
       System.out.print("\n\t\t\t Sorry.. "+un+" is not found in the Database...!!\n");
      }
     }
     catch(IOException e)
     {
      // Exception Caught
     }
    }
    break;
    case 5:
    {
     int i=1;
     String line;
     FileReader fr = null;
     System.out.print("\n\n\n\t\t\t\t    <-- All Issued Books -->\n\n");
     try
     {
      fr = new FileReader("Issued_Books.txt");
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
    case 6:
    {
     int i=1;
     String line;
     FileReader fr = null;
     System.out.print("\n\n\n\t\t\t\t   <-- All Returned Books -->\n\n");
     try
     {
      fr = new FileReader("Returned_Books.txt");
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
    case 7:
    {
     break Books;
    }
    default:
    {
     System.out.print("\n\n\t\t\t\t     ... Wrong Choice ...\n");
    }
   }
  }
 }
}