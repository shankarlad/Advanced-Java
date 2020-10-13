//c. create a dao interface dao.ExpenseDao that has method declaration for insert, update, delete and select the expense record.

package dao;

import java.util.ArrayList;

import dto.Expense;

public interface ExpenseDao {
	int insertData(Expense expense);
	int updateData(Expense expense);
	int deleteData(int expenseId);
	ArrayList<Expense> selectData();
}
