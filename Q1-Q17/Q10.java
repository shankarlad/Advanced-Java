package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java20", "root", "shankar@17");
			Statement s = con.createStatement();
			int rno = sc.nextInt();
			String query = "select * from student where rno="+rno;
			ResultSet rs = s.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "
						+rs.getString(2)+" "
						+rs.getFloat(3)+" "
						+rs.getString(4)); 
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
