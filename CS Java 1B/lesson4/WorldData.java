// Project: WorldData
// Author: Indira Mariya
// World data contians all the data points for each country.

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WorldData {
   static final int COUNTRY_SIZE = 264;
   static final int DATA_POINT_COUNT = 60;
   static final int ATTRIBUTE_COUNT = 44;
   CountryData countryData[] = new CountryData[COUNTRY_SIZE];
   int count = 0;
   
   public WorldData() {
   
   }
   
   // add country data into country object array and increment the count
   public void addCountry(CountryData countryDataInput) {
      CountryData countryData1 = new CountryData();
      countryData1.name = countryDataInput.name;
      countryData1.code = countryDataInput.code;
      countryData1.enrollment = countryDataInput.enrollment;
      countryData[count] = countryDataInput;
      count++;
   }
   
   // load the data from csv file
   public void loadEnrollmentData() throws FileNotFoundException {
      int ignore = 0;
      int index = 0;
      
      File file = new File("data.csv");
      Scanner input = new Scanner(file);
      
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
         String name = name1.substring(1, name1.length() - 1);
         String code1 = lineScanner.next();
         String code = code1.substring(1, code1.length() - 1);
         
         // read the enrollment data
         while (lineScanner.hasNext()) {
            String s = lineScanner.next();
            // remove the double quotes
            String temp = s.substring(1, s.length() - 1);
            if (temp.equals("")) {
               // store 0.0 if the data is empty
               dataPoints[index] = 0.0;
               index++;
            }
            else {
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
         countryData1.setEnrollment(dataPoints);
         this.addCountry(countryData1);
      }
      input.close();
   }
   
   // Load data into the arrays: countries, attributes
   // from local copy of factbook.csv
   // ignore the first 2 lines in factbook.csv
   public void importFactBookData() throws FileNotFoundException, ImportException {
      int ignore = 0;
      int failCount = 0;
      
      File file = new File("factbook.csv");
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
         String line = scanner.nextLine();
         // ignore the first 2 lines in factbook.csv
         if (ignore < 2) {
            ignore++;
            continue;
         }
         // read data from third line onwards
         Scanner lineScanner = new Scanner(line);
         lineScanner.useDelimiter(";");
         // load data into countries array
         String country = lineScanner.next();
         
         // lookup for country object
         CountryData c1 = this.lookup(country);
         
         // if country is not found, read next country data
         if (c1 == null) {
            failCount++;
            continue;
         }
         
         // load data into attributes array
         for (int i = 0; i < ATTRIBUTE_COUNT; i++) {
            double attr = 0.0;
            if (lineScanner.hasNextDouble()) {
               attr = lineScanner.nextDouble();
            }
            else if (lineScanner.hasNext()) {
               // skip the data if it is empty
               lineScanner.next();
            }
            // set the area
            if (i == 0) {
               c1.setArea(attr);
            }
            // set the population
            if (i == 36) {
               c1.setPopulation(attr);
            }
            // set the GDP
            if (i == 8) {
               c1.setGdp(attr);
            }
            // set the infant mortality
            if (i == 17) {
               c1.setInfantMortality(attr);
            }
         }
         lineScanner.close();
      }
      scanner.close();
      // throw ImportException if failCount is > 0
      if (failCount > 0) {
         throw new ImportException(failCount);
      }
   }
   
   // lookup data with country code or country name
   public CountryData lookup(String codeOrName) {
      for (int i = 0; i < COUNTRY_SIZE; i++) {
         if (this.countryData[i].getCode().equals(codeOrName) || this.countryData[i].getName().equals(codeOrName)) {
            return this.countryData[i];
         }
      }
      return null;
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