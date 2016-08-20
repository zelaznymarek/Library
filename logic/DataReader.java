package logic;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import data.Book;
import data.LibraryUser;
import data.Magazine;

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
	
	public Book readAndCreateBook() throws InputMismatchException{
		System.out.print("Podaj autora: ");
		String author=input.nextLine();
		System.out.print("Podaj tytul: ");
		String title=input.nextLine();
		System.out.print("Podaj numer isbn: ");
		String isbn=input.nextLine();
		System.out.print("Podaj nazwe wydawcy: ");
		String publisher=input.nextLine();
		System.out.print("Podaj ilosc stron: ");
		int year = 0;
		int pages = 0;
		try{
		pages=input.nextInt();
		input.nextLine();
		System.out.print("Podaj rok wydania: ");
		year=input.nextInt();
		input.nextLine();
		
		} catch (InputMismatchException e){
			input.nextLine();
			throw e;
		}
				
		return new Book(title, author, isbn, year, pages, publisher);
				
	}
	
	public Magazine readAndCreateMagazine() throws InputMismatchException{
		System.out.print("Podaj nazwe wydawcy: ");
		String publisher=input.nextLine();
		System.out.print("Podaj tytul: ");
		String title=input.nextLine();
		System.out.print("Podaj jezyk wydania: ");
		String language=input.nextLine();
		System.out.print("Podaj dzien wydania: ");
		int day=0;
		int month=0;
		int year=0;
		try{		
		day=input.nextInt();
		input.nextLine();
		System.out.print("Podaj miesiac wydania: ");
		month=input.nextInt();
		input.nextLine();
		System.out.print("Podaj rok wydania: ");
		year=input.nextInt();
		input.nextLine();
		} catch (InputMismatchException e){
			input.nextLine();
			throw e;
		}
		
				
		return new Magazine(month, day, language, year, title, publisher);
		
				
	}
	
	public LibraryUser createLibraryUser(){
		System.out.println("Podaj imiê: ");
		String firstName = input.nextLine();
		System.out.println("Podaj nazwisko: ");
		String name = input.nextLine();
		System.out.println("Podaj PESEL: ");
		String pesel = input.nextLine();
		
		return new LibraryUser(firstName, name, pesel);
	}

}
