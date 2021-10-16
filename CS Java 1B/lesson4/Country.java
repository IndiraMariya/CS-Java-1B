// Project: Country
// Author: Indira Mariya
// Country class stores code, name, area, population.

public abstract class Country {
   String code;
   String name;
   
   public Country() {
   
   }
   
   public String getCode() {
      return this.code;
   }
   
   public String getName() {
      return this.name;
   }
   public void setCode(String code) {
      this.code = code;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   public abstract String toString();
   
}