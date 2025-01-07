package management;

public class BankMan {
	private int id;
	private String name;
	private String dob;
	private int balance;
	
	public BankMan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankMan(int id, String name, String dob, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankMan [id=" + id + ", name=" + name + ", dob=" + dob + ", balance=" + balance + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getDob()=" + getDob() + ", getBalance()=" + getBalance()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
