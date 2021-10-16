// Project: Findable
// Author: Indira Mariya
//
import java.io.IOException;

public interface Findable {
   public static double NO_DATA = -1.0;
   public static int AREA = 1;
   public static int BIRTH_RATE = 2;
   public static int DEATH_RATE = 3;
   public static int GDP = 4;
   public static int HIV_DEATHS = 5;
   public static int INFANT_MORTALITY = 6;
   public static int LABOR_FORCE = 7;
   public static int LIFE_EXPECTANCY = 8;
   public static int POPULATION = 9;
   public static int MOBILE_PHONES = 10;
   public static int FERTILITY_RATE = 11;
   public static int UNEMPLOYMENT = 12;
   
   public abstract double findFact(int attribute) throws IOException {
   
   }
   
   public abstract double findEnrollmentByYear(int year) throws IOException {
   
   }
   

}