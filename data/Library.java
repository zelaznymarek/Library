package data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable {

	public static final int INITIAL_CAPACITY=1;
	private Map<String, LibraryUser> users;
	private Map<String, Publication> publications;
	
	public int getPublNumber(){
		return publications.size();
						
	}
	
	public Map<String, Publication> getPublications() {
	        return publications;
	}
	 
	public Map<String, LibraryUser> getUsers(){
		return users;
	}
	

	public Library(){
		publications = new HashMap<>();
		users = new HashMap<>();
	}
	
	private void addPublication(Publication pub) {
	    publications.put(pub.getTitle(), pub);
	    
	}
	 
	private void removePublication(Publication pub){
		String key = pub.getTitle();
		if(publications.containsValue(pub)){
			publications.remove(pub.getTitle(), pub);
		}
	}
	
	public void addBook(Book book){
		addPublication(book);
		
	} 
	
	public void addMagazine(Magazine mag){
		addPublication(mag);
		
	} 
	
	public void addUser(LibraryUser user){
		users.put(user.getPesel(), user);
	}
	
	
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Publication p: publications.values()){
        	builder.append(p);
        	builder.append("\n");
        }
        return builder.toString();
    }
	
	public static class AlphabeticalComparator implements Comparator<Publication> {

		@Override
		public int compare(Publication publ1, Publication publ2) {
			
			if(publ1 == null && publ2 == null){
				return 0;
			}
			
			if(publ1 == null){
				return 1;
			}
			
			if(publ2 == null){
				return -1;
			}
			
			return publ1.getTitle().compareToIgnoreCase(publ2.getTitle());
		}
		
	}
	
	public static class DateComparator implements Comparator<Publication>{

		@Override
		public int compare(Publication publ1, Publication publ2) {
			
			if(publ1 == null && publ2 == null){
				return 0;
			}
			
			if(publ1 == null){
				return 1;
			}
			
			if(publ2 == null){
				return -1;
			}
			
			Integer i1 = publ1.getDate().getYear();
			Integer i2 = publ2.getDate().getYear();
			return i2.compareTo(i1);
		}
		
	}
	

}
