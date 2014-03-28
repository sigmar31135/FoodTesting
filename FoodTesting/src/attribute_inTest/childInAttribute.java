package attribute_inTest;

import java.util.ArrayList;

public class childInAttribute {
	
	ArrayList<String> child_point = new ArrayList<String>();
	String Attribute_name;
	public childInAttribute(int n) {
		for(int i=0;i<n;i++)
		{
			child_point.add(i, "0.0");
		}
	}
	
	public void set_point(int n,String point){
		child_point.set(n, point);
	}
	
	public void set_Attribute(String Attribute){
		this.Attribute_name = Attribute;
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
