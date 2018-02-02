/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhcheckerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author DanHuang
 */




public class FXMLCheckerController  implements Initializable {
    
    @FXML
    private AnchorPane anchor;
    
    private CheckerBoard board;
    
    private Stage stage;
    @FXML
    private VBox vb;
    
    private double stageIniWei,stageIniHei,anchorIniWei,anchorIniHei;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
    

    
    
    public void ready(Stage stage) 
    {
        this.stage = stage;
        stageIniWei=stage.getWidth();
        stageIniHei=stage.getHeight();
        anchorIniWei=anchor.getWidth();
        anchorIniHei=anchor.getHeight();
        
        ChangeListener<Number> listener = new ChangeListener<Number>() 
        {
            @Override 
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) 
            {
                anchor.getChildren().clear();
                board= new CheckerBoard(board.getCols(),board.getRows(),stage.getWidth()+anchorIniWei-stageIniWei,stage.getHeight()+anchorIniHei-stageIniHei,board.getColor1(),board.getColor2());
                render();
            }
        };
        stage.widthProperty().addListener(listener);
        stage.heightProperty().addListener(listener);
        board= new CheckerBoard(8,8,anchor.getWidth(),anchor.getHeight());
        render();
    }
    
        protected void render(){
        anchor=board.build();
        vb.getChildren().add(anchor);
        System.out.println(stage.getWidth());
        System.out.println(stage.getHeight());
        System.out.println(board.getCols()*board.getRectangleWidth());
        System.out.println(board.getWidth());
        System.out.println("-----------");
    }

    @FXML
    private void showGrid1(ActionEvent event) {
        anchor.getChildren().clear();        
        board= new CheckerBoard(16,16,board.getWidth(),board.getHeight(),board.getColor1(),board.getColor2());
        render();
    } 
    @FXML
    private void showGrid2(ActionEvent event) {
        anchor.getChildren().clear();        
        board= new CheckerBoard(10,10,board.getWidth(),board.getHeight(),board.getColor1(),board.getColor2());
        render();
    } 
    @FXML
    private void showGrid3(ActionEvent event) {
        anchor.getChildren().clear();        
        board= new CheckerBoard(8,8,board.getWidth(),board.getHeight(),board.getColor1(),board.getColor2());
        render();
    } 
    @FXML
    private void showGrid4(ActionEvent event) {
        anchor.getChildren().clear();        
        board= new CheckerBoard(3,3,board.getWidth(),board.getHeight(),board.getColor1(),board.getColor2());
        render();
    } 
    @FXML
    private void showColor1(ActionEvent event) {
        anchor.getChildren().clear();        
        board= new CheckerBoard(board.getCols(),board.getRows(),board.getWidth(),board.getHeight());
        render();
    } 
    @FXML
    private void showColor2(ActionEvent event) {
        anchor.getChildren().clear();        
        board= new CheckerBoard(board.getCols(),board.getRows(),board.getWidth(),board.getHeight(),Color.SKYBLUE,Color.DARKBLUE);
        render();
    }

}
