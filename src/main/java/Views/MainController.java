package Views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import model.SumsModel;

public class MainController
{
	SumsModel model;
	
	public void setModel(SumsModel newmodel)
	{
		this.model = newmodel;
		
		//bind
		StringConverter<Number> fmt = new NumberStringConverter();
	
		Bindings.bindBidirectional(SumLabel.textProperty(), model.getSum(), fmt) ;
	}
	
	@FXML
	private TextField FnumTextField;

	@FXML
	private TextField SnumTextField;

	@FXML
	private Label SumLabel;

	@FXML
	void OnAdd(ActionEvent event) 
	{
		double num1 = getnum1();
		double num2 = getnum2();
		model.add_nums(num1, num2);
	}
	
	private double getnum1()
	{
		String val = FnumTextField.textProperty().get();
		double amt = 0;
		try
		{
			amt = Double.parseDouble(val);
		}
		catch(NumberFormatException e)
		{
			FnumTextField.accessibleTextProperty().set("");
		}
		return amt;
	}
	private double getnum2()
	{
		String val = SnumTextField.textProperty().get();
		double amt = 0;
		try
		{
			amt = Double.parseDouble(val);
		}
		catch(NumberFormatException e)
		{
			SnumTextField.accessibleTextProperty().set("");
		}
		return amt;
	}
}
