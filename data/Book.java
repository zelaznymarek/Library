package data;

import java.time.LocalDate;

public class Book extends Publication {
	
	private String author;
	private String isbn;
	private int pages;
	
	public Book(String title, String author, String isbn, int year, int pages, String publisher){
		super(year, title, publisher);
		this.setAuthor(author);
		this.setIsbn(isbn);
		this.setPages(pages);
		
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


	public int getPages() {
		return pages;
	}

	public void setPages(int pageNumber) {
		this.pages = pageNumber;
	}

	
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder(32);
		builder.append(getAuthor());
		builder.append(", ");
		builder.append(getTitle());
		builder.append(", ");
		builder.append(getDate().getYear());
		builder.append(", ");
		builder.append(getPages());
		builder.append(", ");
		builder.append(getIsbn());
		builder.append(", ");
		builder.append(getPublisher());
	
		return builder.toString();
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + pages;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (pages != other.pages)
			return false;
		return true;
	}

}
