package attribute_inTest;

import java.util.ArrayList;

public class childInAttribute {
	
	ArrayList<String> child_point = new ArrayList<String>();
	String Attribute_name;
	public childInAttribute() {
	}
	
	public void set_point(int n,String point){
		child_point.set(n, point);
	}
	
	public void set_Attribute(String Attribute_name){
		this.Attribute_name = Attribute_name;
	}
	
	public String get_point(int n)
	{
		return child_point.get(n);
	}
	
	public String get_attribute()
	{
		return Attribute_name;
	}
}
