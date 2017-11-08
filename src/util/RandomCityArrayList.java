package util;

public class RandomCityArrayList {
	
	public static String getRandomCity;

	static String getRandomCity() { 
		int r =(int)(Math.random() *5);
		String name = new String[] {
				"SFO",
				"SAN"
		}[r];
		return name;
		}
	}

