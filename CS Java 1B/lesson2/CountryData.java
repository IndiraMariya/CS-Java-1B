// Project: CountryData
// Author: [Indira Mariya]
//

public class CountryData extends Country {
	public double[] data;

	public CountryData() {

	}

	public CountryData(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public double[] getData() {
		return this.data;
	}

	public void setData(double[] data) {
		this.data = data;
	}

	public String toString() {
		String s = "CountryData{" + super.toString() + ", data=[";
		for (int i = 0; i < this.data.length-1; i++) {
			if(data[i] == 0.0) {
				s = s + "-,";
			}
			else {
				s = s + data[i] + ",";
			}
		}

		if(data[data.length-1] == 0.0) {
			s = s + "-";
		}
		else {
			s = s + data[data.length-1];
		}
      s = s + "]}" ;
		return s;
	}
}