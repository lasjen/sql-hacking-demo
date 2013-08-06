package demo.code;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;


public class SQLHackingDemoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnThreadsInStart;

    @FXML
    private Button btnThreadsOutStart;

    @FXML
    private Button btnThreadsOutStop;

    @FXML
    private MenuItem cmdClose;

    @FXML
    private MenuBar menu;

    @FXML
    private TextField txtPort;

    @FXML
    private TextField txtSID;

    @FXML
    private TextField txtServer;

    @FXML
    private TextField txtThreadsInNr;

    @FXML
    private Button txtThreadsInStop;

    @FXML
    private TextField txtThreadsOutNr;

    @FXML
    private TextField txtThreadsOutWait;

    @FXML
    void initialize() {
        assert btnThreadsInStart != null : "fx:id=\"btnThreadsInStart\" was not injected: check your FXML file 'SQLHackingDemo.fxml'.";
        assert btnThreadsOutStart != null : "fx:id=\"btnThreadsOutStart\" was not injected: check your FXML file 'SQLHackingDemo.fxml'.";
        assert btnThreadsOutStop != null : "fx:id=\"btnThreadsOutStop\" was not injected: check your FXML file 'SQLHackingDemo.fxml'.";
        assert cmdClose != null : "fx:id=\"cmdClose\" was not injected: check your FXML file 'SQLHackingDemo.fxml'.";
        assert menu != null : "fx:id=\"menu\" was not injected: check your FXML file 'SQLHackingDemo.fxml'.";
        assert txtPort != null : "fx:id=\"txtPort\" was not injected: check your FXML file 'SQLHackingDemo.fxml'.";
        assert txtSID != null : "fx:id=\"txtSID\" was not injected: check your FXML file 'SQLHackingDemo.fxml'.";
        assert txtServer != null : "fx:id=\"txtServer\" was not injected: check your FXML file 'SQLHackingDemo.fxml'.";
        assert txtThreadsInNr != null : "fx:id=\"txtThreadsInNr\" was not injected: check your FXML file 'SQLHackingDemo.fxml'.";
        assert txtThreadsInStop != null : "fx:id=\"txtThreadsInStop\" was not injected: check your FXML file 'SQLHackingDemo.fxml'.";
        assert txtThreadsOutNr != null : "fx:id=\"txtThreadsOutNr\" was not injected: check your FXML file 'SQLHackingDemo.fxml'.";
        assert txtThreadsOutWait != null : "fx:id=\"txtThreadsOutWait\" was not injected: check your FXML file 'SQLHackingDemo.fxml'.";


     // initialize your logic here: all @FXML variables will have been injected

        cmdClose.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
    }
}
