package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.MyConn;
import dto.Expense;

public class ExpenseDaoImple implements ExpenseDao {
	private MyConn myConn;

	public ExpenseDaoImple() {
		myConn = new MyConn();
	}

	@Override
	public int insertData(Expense expense) {
		int i = 0;
		try {
			Connection con = myConn.getConn();
			PreparedStatement s = con.prepareStatement(
					"insert into expense values(?,?,?,?)");
			s.setInt(1, expense.getExpenseId());
			s.setString(2, expense.getItem());
			s.setInt(3, expense.getPrice());
			s.setString(4, expense.getPurchaseDate());
			i = s.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateData(Expense expense) {
		int i = 0;
		try {
			Connection con = myConn.getConn();
			PreparedStatement s = con.prepareStatement(
					"update expense set item = ?, price = ?, purchase_Date = ? where expense_Id = ?");	
			s.setString(1, expense.getItem());
			s.setInt(2, expense.getPrice());
			s.setString(3, expense.getPurchaseDate());
			s.setInt(4, expense.getExpenseId());
			i = s.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteData(int expenseId) {
		int i = 0;
		try {
			Connection con = myConn.getConn();
			PreparedStatement s = con.prepareStatement(
					"delete from expense where expenseId = ?");	
			s.setInt(1, expenseId); 
			i = s.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		}
		return i;
	}

	@Override
	public ArrayList<Expense> selectData() {
		ArrayList<Expense> al = new ArrayList<>();
		try {
			Connection con = myConn.getConn();
			PreparedStatement s = con.prepareStatement(
					"select * from expense");	
			ResultSet rs = s.executeQuery();
			while(rs.next()) {
				Expense std = new Expense();
				std.setExpenseId(rs.getInt(1));
				std.setItem(rs.getString(2));
				std.setPrice(rs.getInt(3));
				std.setPurchaseDate(rs.getString(4));
				al.add(std);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		}
		return al;
	}
	
}
