// Project: WorldData
// Author: [Indira Mariya]
//

import java.util.Scanner;

public class WorldData {
	public static final int COUNTRY_SIZE = 264;
	public static final int DATA_POINT_COUNT = 60;
	public CountryData countryData[] = new CountryData[COUNTRY_SIZE];
	public int count = 0;

	public WorldData() {

	}

	// add country data into country object array and increment the count
	public void addCountry(CountryData countryDataInput) {
		CountryData countryData1 = new CountryData();
		countryData1.name = countryDataInput.name;
		countryData1.code = countryDataInput.code;
		countryData1.data = countryDataInput.data;
		countryData[count] = countryDataInput;
		count++;
	}

	// load the data from csv file
	public void loadData() {
		int ignore = 0;
		int index = 0;

		Scanner input = new Scanner(System.in);

		while (input.hasNextLine()) {
			double[] dataPoints = new double[DATA_POINT_COUNT];
			index = 0;
			String line = input.nextLine();
			// ignore the first 3 lines in the csv file
			if (ignore < 3) {
				ignore++;
				continue;
			}

			// read data from third line onwards
			Scanner lineScanner = new Scanner(line);
			lineScanner.useDelimiter(",");

			// remove the double quotes from name and code
			String name1 = lineScanner.next();
			String name = name1.substring(1, name1.length()-1);
			String code1 = lineScanner.next();
			String code = code1.substring(1, code1.length()-1);

			// read the enrollment data
			while(lineScanner.hasNext()) {
				String s = lineScanner.next();
				// remove the double quotes
				String temp = s.substring(1, s.length()-1);
				if(temp.equals("")) {
					// store 0.0 if the data is empty
					dataPoints[index] = 0.0;
					index++;
				} else {
					// parse the double value from string
					double d = Double.parseDouble(temp);
					dataPoints[index] = d;
					index++;
				}
			}
			lineScanner.close();
			// store the data parsed from csv file into the object array
			CountryData countryData1 = new CountryData();
			countryData1.setName(name);
			countryData1.setCode(code);
			countryData1.setData(dataPoints);
			this.addCountry(countryData1);
		}
		input.close();
	}

	// lookup enrollment data for the given country code
	public CountryData lookup(String code) {
		CountryData c = new CountryData();
		for (int i = 0; i < COUNTRY_SIZE; i++) {
			if (this.countryData[i].getCode().equals(code)) {
				c =  this.countryData[i];
				break;
			}
		}
      return c;
	}

	// lookup enrollment data for the given country name
	public CountryData lookupCountry(String name) {
		CountryData c = new CountryData();
		for (int i = 0; i < COUNTRY_SIZE; i++) {
			if (this.countryData[i].getName().equals(name)) {
				c =  this.countryData[i];
				break;
			}
		}
		return c;
	}

	// lookup country code for the given country name
	public String lookupCountryCode(String name) {
		String countryCode = "";
		for (int i = 0; i < COUNTRY_SIZE; i++) {
			if (countryData[i].getName().equals(name)) {
				countryCode =  countryData[i].getCode();
				break;
			}
		}
		return countryCode;
	}

	// lookup for the rate of enrollment for the given year for the given country
	public double lookupForYear(String code, int year) {
		double ret = 0.0;
		for (int i = 0; i < COUNTRY_SIZE; i++) {
			if (countryData[i].getCode().equals(code)) {
				// get the enrollment data
				ret = countryData[i].getData()[year-1960];
				break;
			}
		}
		return ret;
	}


	public String toString() {
		String s = "WorldData{ countries[\n";
		for (int i = 0; i < COUNTRY_SIZE; i++) {
			s = s + this.countryData[i].toString() + ",\n";
		}
      s = s + "]}";
		return s;
	}
}