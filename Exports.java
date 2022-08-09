import java.io.*;
import org.apache.commons.csv.*;

public class Exports {
	public static void tester() throws IOException {
		String file = "src//exports/exports_small.csv";
		BufferedReader reader = null;
		
		reader = new BufferedReader(new FileReader(file));
		CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
		
		String country = "Germany";
		String result = countryinfo(parser, country);
		System.out.println(result);
		
		//for(CSVRecord record: parser) {
			//System.out.println(record.get("Country"));
		//}
	}
	
	public static String countryinfo(CSVParser parser, String country) {
		String info = "NOT FOUND";
		
		for(CSVRecord record: parser) {
			String CountryName = record.get("Country");
			
			
			if(CountryName.contains(country)) {
				String info0 = record.get(0);
				String info1 = record.get(1);
				String info2 = record.get(2);
				info = info0 + ": " + info1 + ": " + info2;
				//System.out.println(info);
			
			}
			
		}
		
		return info;		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		tester();

	}

}
