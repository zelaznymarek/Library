package logic;

import java.util.Collection;

import data.Book;
import data.Library;
import data.LibraryUser;
import data.Magazine;
import data.Publication;
 
public class LibraryUtils {
     
    public static void printBooks(Library lib) {
    	printPublications(lib, Book.class);
    }
     
    public static void printMagazines(Library lib) {
        printPublications(lib, Magazine.class);
    }
    
    private static void printPublications(Library lib, Class cl){
    	
    	long countPublications = lib.getPublications().values().stream().filter(cl::isInstance)
    																	.sorted(new Library.AlphabeticalComparator())
    																	.peek(System.out::println)
    																	.count();
    	
    	if(countPublications == 0) {
    		System.out.println("Brak publikacji");
    	}
    	
    }
    
    public static void printUsers(Library lib){
    	
    	lib.getUsers().values().stream().sorted((a, b) -> a.getName().compareTo(b.getName())).peek(System.out::println);
    	
    }
}