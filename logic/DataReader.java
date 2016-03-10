package logic;

import java.util.Scanner;

import data.Book;

public class DataReader {
	
	private Scanner input;
	
	public DataReader(){
		input=new Scanner(System.in);
	}
	
	public void close(){
		input.close();
	}
	
	public int getInt(){
		int number=input.nextInt();
		input.nextLine();
		return number;
	}
	
	public Book readAndCreateBook(){
		System.out.print("Podaj autora: ");
		String author=input.nextLine();
		System.out.print("Podaj tytuł: ");
		String title=input.nextLine();
		System.out.print("Podaj numer isbn: ");
		String isbn=input.nextLine();
		System.out.print("Podaj ilość stron: ");
		int pageNumber=input.nextInt();
		input.nextLine();
		System.out.print("Podaj rok wydania: ");
		int year=input.nextInt();
		input.nextLine();
		System.out.println();
				
		return new Book(title, author, isbn, year, pageNumber);
		
		
		
	}

}
