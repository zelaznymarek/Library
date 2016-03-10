package app;

import data.Book;
import data.Library;
import logic.DataReader;

public class LibraryControl {
	//zmienne do kontrolowania programu
	public static final int EXIT=0;
	public static final int ADD=1;
	public static final int PRINT=2;
	
	
	//zmienna do komunikacji z użytkownikiem
	private DataReader dataReader;
	
	//'biblioteka' przechowująca dane
	private Library library;
	
	public LibraryControl(){
		dataReader=new DataReader();
		library=new Library();
	}
	
	//pętla do wyboru opcji
	
	public void controlLoop(){
		int option=1;
		
		while(option != EXIT){
			
			printOptions();
			option=dataReader.getInt();
			
			switch(option){
			case EXIT:
				break;
			case ADD:
				addBook();
				break;
			case PRINT:
				printBooks();
				break;
				default: System.out.println("Błędny wybór, wybierz poownie");
			}
		}
		
		System.out.println("Do widzenia");
		
	}
	
	public void printOptions(){
		System.out.println("/nWybierz opcję: ");
        System.out.println("0 - wyjście z programu");
        System.out.println("1 - dodanie nowej książki");
        System.out.println("2 - wyświetl dostępne książki");
	}
	
	public void addBook(){
		Book book = dataReader.readAndCreateBook();
		library.addBook(book);
		
	}
	
	public void printBooks(){
		library.printBooks();
	}
	
	

}
