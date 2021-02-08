package src;

public class Book {

	private String number; // a 5-digit serial number unique to the book
	private String name;
	private boolean checkedOut; // set to true if the book has been checked out
	private Date datePublished;
	public static int COUNT = 10001;

	public Book(String number, String name, Date datePublished) {
		this.number = Integer.toString(COUNT);
		this.name = name;
		this.datePublished = datePublished;
		COUNT++;
	}
	
	public Book(String number, String name, Date datePublished, boolean checkedOut) {
		this.checkedOut = checkedOut;
		this.number = Integer.toString(COUNT);
		this.name = name;
		this.datePublished = datePublished;
		COUNT++;
	}

	public String getNumber() {
		return this.number;
	}

	public String getName() {
		return this.name;
	}

	public Date getDatePublished() {
		return this.datePublished;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book book = (Book) obj;
			return book.number.equals(this.number);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Book#" + this.number + "::" + this.name + "::" + this.datePublished + "is available.";
		// Book#10007::Design Patterns::5/30/1996::is available.
	}

}
