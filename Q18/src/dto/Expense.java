//b. create a java bean class named dto.Expense with properties expenseId, item, price, purchaseDate.

package dto;

public class Expense {
	private int expenseId;
	private String item;
	private int price;
	private String purchaseDate;
	public Expense() {
	
	}
	public Expense(int expenseId, String item, int price, String purchaseDate) {
		super();
		this.expenseId = expenseId;
		this.item = item;
		this.price = price;
		this.purchaseDate = purchaseDate;
	}
	
	

	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "expenseId = " + expenseId + " item = " + item + " price = " + price + " purchaseDate = "
				+ purchaseDate;
	}
	
	

}
