package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rno;
		float marks;
		String dob;
		String name;
		
		System.out.println("Enter the Choice : "
				+ "\n1.Insert the record. "
				+ "\n2.Read the record."
				+ " \n3.Update the record."
				+ " \n4.Delete the record.");
		
		int choice = sc.nextInt();
		
		    try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java20","root","shankar@17"); 
				Statement s = con.createStatement();
				
				switch(choice) {
				case 1: 
					System.out.println("Enter the roll number : ");
					rno=sc.nextInt();
					System.out.println("Enter the name : ");
					name = sc.next();
					System.out.println("Enter the marks : ");
					marks=sc.nextFloat();
					System.out.println("Enter the date of birth (yyyy-mm-dd) : ");
					dob = sc.next();
					
					int i=s.executeUpdate("insert into student values("+rno+",'"+name+"',"+marks+",'"+dob+"')");
					System.out.println(i+" record added");
					con.close();
					break;
					
				case 2 :
					ResultSet rs = s.executeQuery("select * from student");
					while(rs.next()) {
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getDate(4));
					}
					con.close();
					break;
					
				case 3 :
					
					System.out.println("Enter the name : ");
					name=sc.next();
					System.out.println("Enter the roll number : ");
					rno = sc.nextInt();
					
					i=s.executeUpdate("update student set name = '"+name+"' where rno="+rno);
					System.out.println(i+" record updated");
					con.close();
					break;
					
				case 4 :
					
					System.out.println("Enter the roll number : ");
					rno = sc.nextInt();
					i=s.executeUpdate("delete from student where rno="+rno);
					System.out.println(i+" record deleted");
					con.close();
					break;
					
				default :
					System.out.println("Please enter valid choice !!!");
					break;
					
				}
				
				
				
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		
		
			

	}

}
