package data;

public class Book {
	
	private String title;
	private String author;
	private String isbn;
	private int year;
	private int pageNumber;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Book(String title, String author, String isbn, int year, int pageNumber){
		this.setTitle(title);
		this.setAuthor(author);
		this.setIsbn(isbn);
		this.setYear(year);
		this.setPageNumber(pageNumber);
		
	}
	
	public Book(Book book){
		this(book.title, book.author, book.isbn, book.year, book.pageNumber);
	}
	
	public void showBook(){
		String info = getAuthor();
		info += ", " + getTitle();
		info += ", " + getYear();
		info += ", " + getPageNumber();
		info += ", " + getIsbn();
		
		System.out.println(info);
	}

}
