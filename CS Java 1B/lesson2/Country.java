// Project: Country
// Author: [Indira Mariya]
//

public class Country {
	public String code;
	public String name;

	public Country(){

	}

	public Country(String code, String name){
		this.code = code;
		this.name = name;
	}

	public String getCode(){
		return this.code;
	}

	public String getName(){
		return this.name;
	}

	public void setCode(String code){
		this.code = code;
	}

	public void setName(String name){
		this.name = name;
	}

	public String toString(){
		String s = "code='" + this.code +"', name='"+ this.name +"'";
		return s;
	}

}