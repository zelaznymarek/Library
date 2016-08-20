package data;

import java.time.LocalDate;

public class Magazine extends Publication {
	
	private String language;
	
	public Magazine(int month, int day, String language, int year, String title, String publisher) {
		super(year, title, publisher);
		setDate(LocalDate.of(year, month, day));
		this.language = language;
	}

	public int getMonth() {
		return getDate().getMonthValue();
	}

	public int getDay() {
		return getDate().getDayOfMonth();
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder(32);
		builder.append(getTitle());
		builder.append(", ");
		builder.append(getPublisher());
		builder.append(", ");
		builder.append(getDate().getYear());
		builder.append("-");
		builder.append(getMonth());
		builder.append("-");
		builder.append(getDay());
		builder.append(", ");
		builder.append(getLanguage());
	
		return builder.toString();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((language == null) ? 0 : language.hashCode());
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
		Magazine other = (Magazine) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		return true;
	}

	
	

}
