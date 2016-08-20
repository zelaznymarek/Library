package app;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import data.Book;
import data.Library;
import data.LibraryUser;
import data.Magazine;
import logic.DataReader;
import logic.FileManager;
import logic.LibraryUtils;

public class LibraryControl {
		
	//zmienna do komunikacji z uzytkownikiem
	private DataReader dataReader;
	
	//zmienna do zapisu i odczytu plików
	private FileManager fileManager;
	
	//'biblioteka' przechowujaca dane
	private Library library;
	
	public LibraryControl(){
		dataReader = new DataReader();
		fileManager = new FileManager();
		
		try{
			library = fileManager.readLibraryFromFile();
			System.out.println("Uda³o siê wczytaæ dane z pliku");
		} catch(ClassNotFoundException | IOException e){
			library = new Library();
			System.out.println("Utworzono nowy plik");
		}
	}
	
	//petla do wyboru opcji
	
	public void controlLoop(Options options){
		
			printOptions();
			
			try{
				options = Options.createFromInt(dataReader.getInt());
				
				switch(options){
				case ADD_BOOK:
					addBook();
					break;
				case ADD_MAG:
					addMagazine();
					break;
				case PRINT_BOOK:
					printBooks();
					break;
				case PRINT_MAG:
					printMagazines();
					break;
				case ADD_USER:
					addUser();
					break;
				case PRINT_USERS:
					printUsers();
					break;
				case EXIT:
					exit();
					break;
				default: System.out.println("Bledny wybor, wybierz poownie");
				}
			} catch (InputMismatchException e){
				System.out.println("Wprowadzi³eœ nieprawid³owe dane");
			} catch (NoSuchElementException e){
				System.out.println("Nie ma takiej opcji, wybierz ponownie");
			}
			
		if(options == options.EXIT){
			dataReader.close();
			System.out.println("Do widzenia");
		} else {
			controlLoop(options);
		}
		
		
		
	}
	
	public void printOptions(){
		System.out.println("Wybierz opcje:");
		for(Options o: Options.values()){
			System.out.println(o);
		}
	}
	
	public void addBook(){
		Book book = dataReader.readAndCreateBook();
		library.addBook(book);
		
	}
	
	public void printBooks(){
		LibraryUtils.printBooks(library);
	}
	
	public void addMagazine(){
		Magazine magazine = dataReader.readAndCreateMagazine();
		library.addMagazine(magazine);
		
	}
	
	public void printMagazines(){
		LibraryUtils.printMagazines(library);	
	}
	
	public void addUser(){
		LibraryUser user = dataReader.createLibraryUser();
		library.addUser(user);
		
	}
	
	public void printUsers(){
		LibraryUtils.printUsers(library);
	}
	
	public void exit(){
		fileManager.writeLibraryToFile(library);
	}
	
	private enum Options {
		EXIT(0, "Wyjscie"),
		ADD_BOOK(1, "Dodaj ksiazke"),
		ADD_MAG(2, "Dodaj magazyn"),
		PRINT_BOOK(3, "Pokaz ksiazki"),
		PRINT_MAG(4, "Pokaz magazyny"),
		ADD_USER(5, "Dodaj u¿ytkownika"),
		PRINT_USERS(6, "Poka¿ u¿ytkowników");
		
		
		private int value;
		private String desc;
		
		Options(int value, String desc){
			this.value=value;
			this.desc=desc;
		}
		
		@Override
		public String toString(){
			
			return value + ". " + desc;
		}
		
		public static Options createFromInt(int option) throws NoSuchElementException {
	        Options result = null;
	        try {
	            result = Options.values()[option];
	        } catch(ArrayIndexOutOfBoundsException e) {
	            throw new NoSuchElementException("Brak elementu o wskazanym ID");
	        }
	         
	        return result;
	    }

	}
	

}
