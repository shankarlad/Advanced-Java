//e. create p01.Main class to demonstrate CRUD operation written in DAO class.

package p01;

import java.util.ArrayList;
import java.util.Scanner;

import dao.ExpenseDaoImple;
import dto.Expense;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("0 to exit");
			System.out.println("1 to show student list");
			System.out.println("2 to add student record");
			System.out.println("3 to mofify student record");
			System.out.println("4 to remove student record");
			int choice = sc.nextInt();
			switch(choice) {
			case 0:
				System.exit(0);
			
			case 1:
				ExpenseDaoImple expenseDao = new ExpenseDaoImple();
				ArrayList<Expense> l = expenseDao.selectData();
				for(Expense e : l) {
					System.out.println(e);
				}
				break;
				
			case 2 :
				System.out.println("Enter expense Id :");
				int expenseId = sc.nextInt();
				System.out.println("Enter item name :");
				String item = sc.next();
				System.out.println("Enter price :");
				int price = sc.nextInt();
				System.out.println("Enter purchase date :");
				String date = sc.next();
				Expense expense = new Expense(expenseId,item,price,date);
				expenseDao = new ExpenseDaoImple();
				int i = expenseDao.insertData(expense);
				System.out.println(i+" record added");
				break;
			case 3 :
				System.out.println("Enter expense Id :");
				expenseId = sc.nextInt();
				System.out.println("Enter item name :");
				item = sc.next();
				System.out.println("Enter price :");
				price = sc.nextInt();
				System.out.println("Enter purchase date :");
				date = sc.next();
				expense = new Expense(expenseId,item,price,date);
				expenseDao = new ExpenseDaoImple();
				i = expenseDao.updateData(expense);
				System.out.println(i+" record modified");
				break;
			case 4 :
				System.out.println("Enter expense Id :");
				expenseId = sc.nextInt();
				expenseDao = new ExpenseDaoImple();
				i = expenseDao.deleteData(expenseId);
				System.out.println(i+" record deleted");
				break;
			default :
				System.out.println("Invalid Input ");
				break;
			}	
		}
	}
}
