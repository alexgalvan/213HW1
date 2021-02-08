package src;

public class Library {

	private final int NOT_FOUND = -1;
	private final int GROW_SIZE = 4;
	private Book[] books; // array-based implementation of the bag data structure
	private int numBooks; // the number of books currently in the bag

	public Library() { // default constructor to create an empty bag
		this.numBooks = 0;
		this.books = new Book[GROW_SIZE];
	}

	private int find(Book book) { // helper method to find a book in the bag
		if (isEmpty()) {
			return NOT_FOUND;
		}
		for (int i = 0; i < numBooks; i++) {
			if (book.equals(books[i])) {
				return i;
			}
		}
		return NOT_FOUND;
	}

	private void grow() { // helper method to grow the capacity by 4
		Book newBooks[] = new Book[numBooks + GROW_SIZE];
		for (int i = 0; i < numBooks; i++) {
			newBooks[i] = this.books[i];
		}
		this.books = newBooks;
	}

	public void add(Book book) {
		if (this.books.length <= numBooks) {
			grow();
		}
		this.books[numBooks] = book;
		numBooks++;

	}

	public boolean remove(Book book) {
		int ptr = find(book);
		if (ptr == -1) {
			return false;
		} else {
			this.books[ptr] = null;
			Book newBooks[] = new Book[numBooks];
			for (int i = 0; i < ptr; i++) {
				newBooks[i] = this.books[i];
			}
			for (int i = ptr; i < numBooks - 1; i++) {
				newBooks[i] = this.books[i + 1];
			}
			numBooks--;
			this.books = newBooks;
			return true;
		}

	}

	public boolean checkOut(Book book) { // true if checking out is successful
		int ptr = find(book);
		if (ptr == -1) {
			return false;
		} else {
			Book newBook = new Book(book.getNumber(), book.getName(), book.getDatePublished(), true);
			this.books[ptr] = newBook;
			return true;
		}

	}

	public boolean returns(Book book) {
		int ptr = find(book);
		if (ptr == -1) {
			return false;
		} else {
			Book newBook = new Book(book.getNumber(), book.getName(), book.getDatePublished(), false);
			this.books[ptr] = newBook;
			return true;
		}
	}

	public void print() { // print the list of books in the bag
		for (int i = 0; i < numBooks; i++) {
			if (this.books[i] == null)
				break;
			System.out.println(this.books[i].toString());
		}
	}

	public void printByDate() { // print the list of books by datePublished (ascending)
		sortByDate(this.books);
		print();
	}

	public void printByNumber() { // print the list of books by number (ascending)
		sortByNumber(this.books);
		print();
	}

	public void sortByNumber(Book arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key1 = Integer.parseInt(arr[i].getNumber());
			int j = i - 1;
			Book temp = arr[i];

			while (j >= 0 && Integer.parseInt(arr[j].getNumber()) > key1) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = temp;
		}
	}

	public void sortByDate(Book arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int keyY = arr[i].getDatePublished().getYear();
			int keyM = arr[i].getDatePublished().getMonth();
			int keyD = arr[i].getDatePublished().getDay();
			int j = i - 1;
			Book temp = arr[i];

			while (j >= 0 && arr[j].getDatePublished().getYear() >= keyY) {
				if (arr[j].getDatePublished().getYear() == keyY) {
					if (arr[j].getDatePublished().getMonth() >= keyD) {
						if (arr[j].getDatePublished().getMonth() == keyM) {
							if (arr[j].getDatePublished().getDay() > keyD) {
								arr[j + 1] = arr[j];
								j = j - 1;
							} else {
							}
						} else {
							arr[j + 1] = arr[j];
							j = j - 1;
						}
					} else {
					}
				} else {
					arr[j + 1] = arr[j];
					j = j - 1;
				}
			}
			arr[j + 1] = temp;
		}
	}

	public boolean isEmpty() {
		if (books[0] == null) {
			return true;
		}
		return false;
	}
}