// Project: Country
// Author: Indira Mariya
// Country class stores code, name, area, population.

public class Country {
   String code;
   String name;
   double area;
   double population;
   
   public Country() {
   
   }
   
   public Country(String code, String name) {
      this.code = code;
      this.name = name;
   }
   
   public String getCode() {
      return this.code;
   }
   
   public String getName() {
      return this.name;
   }
   
   public double getArea() {
      return area;
   }
   
   public double getPopulation() {
      return population;
   }
   
   public void setCode(String code) {
      this.code = code;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public void setArea(double area) {
      this.area = area;
   }
   
   public void setPopulation(double population) {
      this.population = population;
   }
   
   public String toString() {
      String s = "code='" + this.code + "', name='" + this.name + "', area=";
      
      if (this.area == 0.0) {
         s = s + "-";
      }
      else {
         s = s + this.area;
      }
      
      s = s + ", population=";
      
      if (this.population == 0.0) {
         s = s + "-";
      }
      else {
         s = s + this.population;
      }
      return s;
   }
   
}