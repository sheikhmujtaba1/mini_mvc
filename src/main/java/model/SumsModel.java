package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SumsModel
{
	DoubleProperty sum = new SimpleDoubleProperty();
	
	
	/**
	 * @return the sum
	 */
	public DoubleProperty getSum()
	{
		return sum;
	}


	public SumsModel()
	{
	}
	
	public void add_nums(double num1, double num2)
	{
		sum.set(num1+num2);
	}
	
	
}
