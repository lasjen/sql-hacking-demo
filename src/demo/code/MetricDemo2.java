package demo.code;

import java.io.IOException;

import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MetricDemo2 extends Application{

	/**
	 * @param args
	 */
	public static void main(String[] args)  {
        launch(args);
    }
	
	@Override
    public void start(Stage primaryStage) {
		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("SQLHackingDemo.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Oracle SQL Hacking Session");
		primaryStage.sizeToScene();
		primaryStage.show();
        
    }
	
	public static void oldmain(String[] args) throws Exception {
		
		// Get Oracle Connection and setup Metrics object
		DemoService s = new DemoService();
		
		// Simulate service "Counting Employees (cntEmp)"
		System.out.println("Counting Employees .... (Waiting) ");
		int cnt = s.cntEmp();
		System.out.println("Number of employees: " + cnt);
		System.out.println("");
		
		// Simulate service "Counting Employees by deptno (cntEmpByDeptNo)"
		System.out.println("Counting Employees by deptno.... (Waiting) ");
		cnt = s.cntEmpByDeptNo(null);
		System.out.println("Number of employees: " + cnt);
		System.out.println("");
				
		// Simulate service "Counting Objects (cntObjects)"
		//System.out.println("Counting objects .... (Waiting) ");
		//cnt = s.cntObjects();
		//System.out.println("Number of objects:" + cnt);

	}

}
