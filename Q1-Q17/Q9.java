package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Q9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rno;
		float marks;
		String dob;
		String name;
		
		System.out.println("Enter the Choice :"
				+ " \n1.Insert the record."
				+ " \n2.Read the record."
				+ " \n3.Update the record."
				+ " \n4.Delete the record.");
		
		int choice = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java20","root","shankar@17"); 
			
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
				String q = "insert into student values("+rno+",'"+name+"',"+marks+",'"+dob+"')";
				PreparedStatement s = con.prepareStatement(q);
				int i = s.executeUpdate();
				
				System.out.println(i+" record added");
				con.close();
				break;
				
				
			
			case 2 :
				
					q = "select * from student";
					s = con.prepareStatement(q);
					ResultSet rs = s.executeQuery();
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
					q="update student set name = '"+name+"' where rno="+rno;
					s=con.prepareStatement(q);
					i=s.executeUpdate();
					System.out.println(i+" record updated");
					con.close();
					break;
				
			case 4 :
				
					System.out.println("Enter the roll number : ");
					rno = sc.nextInt();
					q="delete from student where rno="+rno;
					s=con.prepareStatement(q);
					i=s.executeUpdate();
					System.out.println(i+" record deleted");
					con.close();
					break;
			default :
					System.out.println("Please enter valid choice !!!");
					break;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
