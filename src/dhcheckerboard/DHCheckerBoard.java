/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhcheckerboard;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author DanHuang
 */
public class DHCheckerBoard extends Application {
    
    @Override
    public void start(Stage mainStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLChecker.fxml"));
        Parent root = loader.load();
        FXMLCheckerController controller = loader.getController();
        Scene scene = new Scene(root);
        
        mainStage.setTitle("CheckerBoard");
        mainStage.setScene(scene);
        mainStage.show();
        controller.ready(mainStage);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
