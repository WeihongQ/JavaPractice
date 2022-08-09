import org.apache.commons.csv.*;
import java.io.*;

public class Temperature {
	public static CSVRecord HottestHourInFile(CSVParser parser) {
		//start with the largest so far
		CSVRecord largestSoFar = null;
		// for each row (currentRow) in the CSV File:
		for (CSVRecord currentRow: parser) {
			//if largest so far is nothing
			if (largestSoFar == null) {
				largestSoFar = currentRow;
			}
			else {
				double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
				double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
				
				if(currentTemp > largestTemp) {
					largestSoFar = currentRow;
				}
			}
			
		}
		
		return largestSoFar;
	}
	
	public static void tester() throws IOException {
		String file = "src//nc_weather/2015/weather-2015-01-01.csv";
		BufferedReader reader = null;
		
		reader = new BufferedReader(new FileReader(file));
		CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
		CSVRecord largest = HottestHourInFile(parser);
		
		System.out.println("hottest temperature was " + largest.get("TemperatureF")+ " at " + largest.get("TimeEST"));
	}
	
	public static CSVRecord hottestInManyDays() throws IOException {
		CSVRecord largestSoFar = null;
		
		File drPath = new File("src//nc_weather/2015");
		
		for (File f: drPath.listFiles()) {
			BufferedReader reader= null;
			
			reader = new BufferedReader(new FileReader(f));
			CSVRecord currentRow = HottestHourInFile(new CSVParser(reader, CSVFormat.DEFAULT.withHeader()));
			if (largestSoFar == null) {
				largestSoFar = currentRow;
			}
			else {
				double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
				double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
				
				if(currentTemp > largestTemp) {
					largestSoFar = currentRow;
				}
			}
		}
		
		return largestSoFar;
		
	}
	
	public static void testHottestInManyDays() throws IOException {
		CSVRecord largest = hottestInManyDays();
		System.out.println("hottest temperature was " + largest.get("TemperatureF")+ " at " + largest.get("DateUTC"));
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		tester();
		testHottestInManyDays();

	}

}
