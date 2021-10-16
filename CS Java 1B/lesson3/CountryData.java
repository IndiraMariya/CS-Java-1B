// Project: CountryData
// Author: Indira Mariya
// CountryData has enrollment, gdp, infant mortality

public class CountryData extends Country {
   double[] enrollment;
   double gdp;
   double infantMortality;
   
   public CountryData() {
   
   }
   
   public CountryData(String code, String name) {
      this.code = code;
      this.name = name;
   }
   
   public double[] getEnrollment() {
      return this.enrollment;
   }
   
   public double getGdp() {
      return this.gdp;
   }
   
   public double getInfantMortality() {
      return this.infantMortality;
   }
   
   public void setEnrollment(double[] enrollment) {
      this.enrollment = enrollment;
   }
   
   public void setGdp(double gdp) {
      this.gdp = gdp;
   }
   
   public void setInfantMortality(double infantMortality) {
      this.infantMortality = infantMortality;
   }
   
   public String toString() {
      String s = "CountryData{" + super.toString() + ", gdp=";
      if (this.gdp == 0.0) {
         s = s + "-";
      }
      else {
         s = s + this.gdp;
      }
      
      s = s + ", infantMorality=";
      
      if (this.infantMortality == 0.0) {
         s = s + "-";
      }
      else {
         s = s + this.infantMortality;
      }
      
      s = s + ", data=[";
      
      for (int i = 0; i < enrollment.length - 1; i++) {
         if (enrollment[i] == 0.0)
            s = s + "-" + ",";
         else
            s = s + enrollment[i] + ",";
      }
      
      if (enrollment[enrollment.length - 1] == 0.0)
         s = s + "-";
      else
         s = s + enrollment[enrollment.length - 1];
      
      s = s + "]}";
      return s;
   }
}