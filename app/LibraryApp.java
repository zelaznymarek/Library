package app;

public class LibraryApp {

	public static void main(String[] args) {
		final String appName="Biblioteka v1.01";
		LibraryControl libCon = new LibraryControl();
		
		System.out.println(appName);
		libCon.controlLoop(null);

	}

}
