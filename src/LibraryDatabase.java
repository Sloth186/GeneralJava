class Library {
	private class Book {
		String title;
		String author;
		String isbn;
		byte copies;
		Book next;
		Book prev;
		
		public Book(String title, String author, String isbn, byte copies, Book next, Book prev) {
			this.title = title;
			this.author = author;
			this.isbn = isbn;
			this.copies = copies;
			this.next = next;
			this.prev = prev;
		}
		
		public Book(String title, String author, String isbn, Book prev) {
			this(title, author, isbn, (byte) 1, null, prev);
		}
		
		public boolean addCopy() {
			if (copies == Byte.MAX_VALUE)
				return false;
			else {
				++copies;
				return true;
			}
		}
		
		public boolean removeCopy() {
			if (copies == 1)
				return false;
			else {
				--copies;
				return true;
			}
		}
	}
	
	public enum VALUE_TYPE {
		TITLE,
		AUTHOR,
		ISBN
	}
	
	public enum ORDER {
		ASCENDING,
		DESCENDING
	}
	
	Book head;
	Book tail;
	int books;
	
	public Book searchBook(String key) {
		return searchBook(key, VALUE_TYPE.TITLE);
	}
	
	public Book searchBook(String key, VALUE_TYPE keyType) {
		Book current = head;
		
		switch (keyType) {
			case TITLE:
				while (current != null) {
					if (current.title.compareToIgnoreCase(key) == 0)
						return current;
					current = current.next;
				}
				break;
			case AUTHOR:
				while (current != null) {
					if (current.author.compareToIgnoreCase(key) == 0)
						return current;
					current = current.next;
				}
				break;
			case ISBN:
				while (current != null) {
					if (current.isbn.compareToIgnoreCase(key) == 0)
						return current;
					current = current.next;
				}
				break;
		}
		
		return null;
	}
	
	public int searchBookPosition(String key) {
		return searchBookPosition(key, VALUE_TYPE.TITLE);
	}
	
	public int searchBookPosition(String key, VALUE_TYPE keyType) {
		Book current = head;
		int index = 0;
		
		switch (keyType) {
			case TITLE:
				while (current != null) {
					if (current.title.compareToIgnoreCase(key) == 0)
						return index;
					++index;
					current = current.next;
				}
				break;
			case AUTHOR:
				while (current != null) {
					if (current.author.compareToIgnoreCase(key) == 0)
						return index;
					++index;
					current = current.next;
				}
				break;
			case ISBN:
				while (current != null) {
					if (current.isbn.compareToIgnoreCase(key) == 0)
						return index;
					++index;
					current = current.next;
				}
				break;
		}
		
		return -1;
	}
	
	public boolean addBook(String title, String author, String isbn, int copies) {
		Book current = searchBook(title);
		
		if (current == null) {
			if (copies > Byte.MAX_VALUE)
				return false;
			
			Book newBook = new Book(title, author, isbn, (byte) copies, null, tail);
			if (head == null)
				head = newBook;
			else
				tail.next = newBook;
			tail = newBook;
		} else {
			for (int i = 0; i < copies; ++i) {
				if (current.addCopy())
					return false;
			}
		}
		return true;
	}
	
	public boolean removeBook(String key) {
		Book current = searchBook(key);
		
		if (current == null)
			return false;
		else {
			return current.removeCopy();
		}
	}
	
	public boolean deleteBook(String key) {
		Book current = searchBook(key);
		
		if (current == null)
			return false;
		else {
			if (head == current)
				head = current.next;
			else if (tail == current)
				tail = current.prev;
			if (current.prev != null)
				current.prev.next = current.next;
			if (current.next != null)
				current.next.prev = current.prev;
			return true;
		}
	}
	
	public void swapBookWithNext(Book book) {
		if (book.next != null) {
			Book temp = book.next;
			
			if (book.prev != null)
				book.prev.next = temp;
			if (temp.next != null)
				temp.next.prev = book;
			book.next = temp.next;
			temp.prev = book.prev;
			book.prev = temp;
			temp.next = book;
		}
	}
	
	public boolean sortBooks(ORDER order, VALUE_TYPE orderType) {
		Book cycleForward = head.next, cycleBack = head;
		String temp;
		
		switch (orderType) {
			case TITLE -> {
				switch (order) {
					case ASCENDING -> {
						while (cycleForward != null) {
							temp = cycleForward.title;
							while (cycleBack != null && temp.compareToIgnoreCase(cycleBack.title) < 0) {
								swapBookWithNext(cycleBack);
								cycleBack = cycleBack.prev.prev;
							}
							
							cycleBack = cycleForward;
							cycleForward = cycleForward.next;
						}
						return true;
					}
					case DESCENDING -> {
						while (cycleForward != null) {
							temp = cycleForward.title;
							while (cycleBack != null && temp.compareToIgnoreCase(cycleBack.title) > 0) {
								swapBookWithNext(cycleBack);
								cycleBack = cycleBack.prev.prev;
							}
							
							cycleBack = cycleForward;
							cycleForward = cycleForward.next;
						}
						return true;
					}
				}
			}
			
			case AUTHOR -> {
				switch (order) {
					case ASCENDING -> {
						while (cycleForward != null) {
							temp = cycleForward.author;
							while (cycleBack != null && temp.compareToIgnoreCase(cycleBack.author) < 0) {
								swapBookWithNext(cycleBack);
								cycleBack = cycleBack.prev.prev;
							}
							
							cycleBack = cycleForward;
							cycleForward = cycleForward.next;
						}
						return true;
					}
					case DESCENDING -> {
						while (cycleForward != null) {
							temp = cycleForward.author;
							while (cycleBack != null && temp.compareToIgnoreCase(cycleBack.author) > 0) {
								swapBookWithNext(cycleBack);
								cycleBack = cycleBack.prev.prev;
							}
							
							cycleBack = cycleForward;
							cycleForward = cycleForward.next;
						}
						return true;
					}
				}
			}
			
			case ISBN -> {
				switch (order) {
					case ASCENDING -> {
						while (cycleForward != null) {
							temp = cycleForward.isbn;
							while (cycleBack != null && temp.compareToIgnoreCase(cycleBack.isbn) < 0) {
								swapBookWithNext(cycleBack);
								cycleBack = cycleBack.prev.prev;
							}
							
							cycleBack = cycleForward;
							cycleForward = cycleForward.next;
						}
						return true;
					}
					case DESCENDING -> {
						while (cycleForward != null) {
							temp = cycleForward.isbn;
							while (cycleBack != null && temp.compareToIgnoreCase(cycleBack.isbn) > 0) {
								swapBookWithNext(cycleBack);
								cycleBack = cycleBack.prev.prev;
							}
							
							cycleBack = cycleForward;
							cycleForward = cycleForward.next;
						}
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public void printLibrary() {
	
	}
}

public class LibraryDatabase {

}