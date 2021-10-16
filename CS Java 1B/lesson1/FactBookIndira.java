// Project: FactBook
// Author: [Indira Mariya]
//
import java.util.Scanner;

public class FactBookIndira {
    // number of countries (rows) in input file
    static final int COUNTRY_COUNT = 265;

    // number of attributes (columns) in the input file
    static final int ATTRIBUTE_COUNT = 44;

    // list of country names
    static String[] countries = new String[COUNTRY_COUNT];
    // list of country attributes
    static double[][] attributes = new double[COUNTRY_COUNT][ATTRIBUTE_COUNT];

    // Load data into the arrays: countries, attributes
    // from local copy of factbook.csv
    // ignore the first 2 lines in factbook.csv
    public static void loadData() {
        int ignore = 0;
        int index = 0;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            // ignore the first 2 lines in factbook.csv
            if (ignore < 2)
            {
                ignore++;
                continue;
            }
            // read data from third line onwards
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(";");
            // load data into countries array
            String country = lineScanner.next();
            countries[index] = country;
            // load data into attributes array
            for (int i = 0; i < ATTRIBUTE_COUNT; i++)
            {
                if (lineScanner.hasNextDouble())
                {
                    double attr = lineScanner.nextDouble();
                    attributes[index][i] = attr;
                }
                else if (lineScanner.hasNext())
                {
                    // skip the data if it is empty
                    lineScanner.next();
                }
            }
            lineScanner.close();
            index++;
        }
        scanner.close();
    }

    // Returns country with largest Area
    public static String largestCountry() {
        final int AREA_ATTRIBUTE_INDEX = 0;
        String country = countries[0];
        double maxArea = attributes[0][AREA_ATTRIBUTE_INDEX];
        for (int i = 1; i < COUNTRY_COUNT; i++)
        {
            if (attributes[i][AREA_ATTRIBUTE_INDEX] > maxArea)
            {
                country = countries[i];
                maxArea = attributes[i][AREA_ATTRIBUTE_INDEX];
            }
        }
        return country;
    }

    // Returns number of countries reporting unemployment higher than rate
    public static int unemploymentCount(int rate) {
        final int UNEMPLOYMENT_ATTRIBUTE_INDEX = 43;
        int count = 0;
        for (int i = 0; i < COUNTRY_COUNT; i++)
        {
            if (attributes[i][UNEMPLOYMENT_ATTRIBUTE_INDEX] > rate)
            {
                count++;
            }
        }
        return count;
    }

    // Returns total HIV/AIDS deaths reported
    public static int hivDeaths() {
        final int HIV_ATTRIBUTE_INDEX = 12;
        int count = 0;
        for (int i = 0; i < COUNTRY_COUNT; i++)
        {
            count += attributes[i][HIV_ATTRIBUTE_INDEX];
        }
        return count;
    }

    // Returns the country with highest population
    public static String largestPopulation() {
        final int POPULATION_ATTRIBUTE_INDEX = 36;
        String country = countries[0];
        double maxPopulation = attributes[0][POPULATION_ATTRIBUTE_INDEX];
        for (int i = 1; i < COUNTRY_COUNT; i++)
        {
            if (attributes[i][POPULATION_ATTRIBUTE_INDEX] > maxPopulation)
            {
                country = countries[i];
                maxPopulation = attributes[i][POPULATION_ATTRIBUTE_INDEX];
            }
        }
        return country;
    }

    // Returns the country with highest account balance
    public static String highestAccountBalance() {
        final int ACCT_BALANCE_ATTRIBUTE_INDEX = 2;
        String country = countries[0];
        double maxAcctBalance = attributes[0][ACCT_BALANCE_ATTRIBUTE_INDEX];
        for (int i = 1; i < COUNTRY_COUNT; i++)
        {
            if (attributes[i][ACCT_BALANCE_ATTRIBUTE_INDEX] > maxAcctBalance)
            {
                country = countries[i];
                maxAcctBalance = attributes[i][ACCT_BALANCE_ATTRIBUTE_INDEX];
            }
        }
        return country;
    }

    public static void main(String[] args) {
        /* --- do not modify below --- */
        loadData();
        System.out.println("The largest country is " + largestCountry());
        System.out.println(unemploymentCount(50) + " countries have unemployment rate > 50%");
        System.out.println(unemploymentCount(40) + " countries have unemployment rate > 40%");
        System.out.println(unemploymentCount(30) + " countries have unemployment rate > 30%");
        System.out.println("Total HIV/AIDS deaths were " + hivDeaths());
        /* --- do not modify above --- */

        // make up your own interesting question and answer using the data
        System.out.println("The country with highest population is " + largestPopulation());

        // make up another interesting question and answer using the data
        System.out.println("The country with highest account balance is " + highestAccountBalance());
    }
}

/*
The largest country is Russia
5 countries have unemployment rate > 50%
13 countries have unemployment rate > 40%
23 countries have unemployment rate > 30%
Total HIV/AIDS deaths were 2835808
The country with highest population is China
The country with highest account balance is Japan
 */
