// Project: CountryData
// Author: Indira Mariya
// CountryData has enrollment, gdp, infant mortality

public class CountryData extends Country implements Findable {
   double[] enrollment;
   double[] facts;
   
   public CountryData() {
   
   }
   
   public double[] getEnrollment() {
      return this.enrollment;
   }
   
   public double[] getFacts() {
      return facts;
   }
   
   public void setEnrollment(double[] enrollment) {
      this.enrollment = enrollment;
   }
   
   public void setFacts(double[] facts) {
      this.facts = facts;
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