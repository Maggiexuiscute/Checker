/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhcheckerboard;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author DanHuang
 */
public class CheckerBoard {
    private int rowNums;
    private int colNums;
    private double boardWidth;
    private double boardHeight;
    private Color color1;
    private Color color2;
    private AnchorPane anchor2;
    public CheckerBoard(int rowNums, int colNums, double boardWidth, double boardHeight, Color color1, Color color2)
    {
        int w=0,h=0;
                        switch(rowNums)
                        {
                            case 3:w=16;h=65;break;
                            case 8:w=20;h=65;break;
                            case 10:w=20;h=70;break;
                            case 16:w=25;h=70;break;
                        }
        w=0;h=0;
        
        this.rowNums=rowNums;
        this.colNums=colNums;
        this.boardWidth=boardWidth-w;
        this.boardHeight=boardHeight-h;
        this.color1=color1;
        this.color2=color2;
    }
    
    public CheckerBoard(int rowNums, int colNums, double boardWidth, double boardHeight)
    {
        this(rowNums, colNums, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    public int getRows()
    {
        return rowNums;
    }
    public int getCols()
    {
        return colNums;
    }
    public double getWidth()
    {
        return boardWidth;
    }
    public double getHeight()
    {
        return boardHeight;
    }
    public Color getColor1()
    {
        return color1;
    }
    public Color getColor2()
    {
        return color2;
    }
    public double getRectangleWidth()
    {
        return boardWidth/colNums;
    }
    public double getRectangleHeight()
    {
        return boardHeight/rowNums;
    }
    
    public AnchorPane build()
    {
        anchor2= new AnchorPane();
        for (int row = 0; row < getRows(); row++) 
        {
            for (int col = 0; col < getCols(); col++) 
            {
                Rectangle rect;
                if((row+col)%2==0)
                {
                    rect = new Rectangle(getRectangleWidth(), getRectangleHeight(), getColor1());
                }
                else
                {
                    rect = new Rectangle(getRectangleWidth(), getRectangleHeight(), getColor2());
                }
                AnchorPane.setTopAnchor(rect,row*getRectangleHeight());
                AnchorPane.setLeftAnchor(rect,col*getRectangleWidth());
                anchor2.getChildren().add(rect);
                
            }
        }
        return anchor2;
    }
    
    public AnchorPane getBoard()
    {
        return anchor2;
    }
}
