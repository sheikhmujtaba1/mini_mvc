package views;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import Views.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.Main;
import model.SumsModel;

@ExtendWith(ApplicationExtension.class)
public class Testadd_number_view
{
	@Start //Before 
	private void start(Stage stage)
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../Views/MainView.fxml"));
		
		BorderPane view;
		try
		{
			view = loader.load();
			MainController cont = loader.getController();
			SumsModel sm = new SumsModel();
			cont.setModel(sm);
			
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show(); 
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void enternum1(FxRobot robot, String num1)
	{
		robot.clickOn("#enternum1");
		robot.write(num1);
	}
	
	private void enternum2(FxRobot robot, String num2)
	{
		robot.clickOn("#enternum2");
		robot.write(num2);
	}
	
	
	private void checksum(FxRobot robot, String sum)
	{
		Assertions.assertThat(robot.lookup("#displaynum")
				.queryAs(Label.class)).hasText(sum);
	}
	
	private void checkadd(FxRobot robot, String before, String num1, String num2, String after)
	{
		checksum(robot, before);
		enternum1(robot, num1);
		enternum2(robot, num2);
		robot.clickOn("#addnumsbutton");
		checksum(robot,after);
	}
	
	
	
	@Test
	public void testAddButton(FxRobot robot)
	{
		try
		{
			
			Thread.sleep(1000);
			enternum1(robot, "5");
			enternum2(robot, "10");
			robot.clickOn("#addnumsbutton");
			checksum(robot, "15");
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAdds(FxRobot robot)
	{
		checkadd(robot, "0", "10", "10", "20");
		checkadd(robot, "20", "7.3", "12", "19.3");
		checkadd(robot, "19.3", "2", "-12", "-10");
	}
}
