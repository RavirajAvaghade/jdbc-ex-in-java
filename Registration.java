package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Registration 
{

	public static void main(String[] args) 
	{
       Scanner sc = new Scanner(System.in);
       try
       {
    	     Class.forName("oracle.jdbc.OracleDriver");
    	     
    	     Connection con = DriverManager.getConnection(
    	    		 "jdbc:oracle:thin:@localhost:1521:orcl",
    	    		 "System",
    	    		 "Raviraj1710");
    	     System.out.println(" Oracle connected");
    	     
    	     System.out.println(" Enter Student Roll No  : ");
    	     int Rono = sc.nextInt();
    	     
    	     System.out.println(" Enter Student Name : ");
    	     String Name = sc.next();
    	     
    	     System.out.println(" Enter student course :" );
         String course = sc.next();
         
         System.out.println(" Enter Student fee : ");
	     int fee = sc.nextInt();
	     
         
         String sql = "INSERT INTO STUDENT(RONO,SNAME,COURSE,SFEE)VALUES(?, ?, ?, ?)";
         
         
		 PreparedStatement ps = con.prepareStatement(sql);
         ps.setInt(1, Rono);
         ps.setString(2, Name);
         ps.setNString(3, course);
         ps.setInt(4, fee);

         
         int rows = ps.executeUpdate();
         if(rows>0)
         {
        	  System.out.println("Student data added Succesfully");
         }
         else
         {
        	   System.out.println(" inseret failed");
         }
         con.close();
         sc.close();
         
       }catch(Exception e)
       {
    	      e.printStackTrace();
       }
       
	}

	

}
