package opgave1note0_1b;

import javafx.scene.shape.*;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MainApp extends Application
{
   
    @Override
    public void start(Stage stage)
    {
        Pane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent()
    {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        this.drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane)
    {
        Circle circle = new Circle(70, 15, 30);
        pane.getChildren().add(circle);
        circle.setFill(Color.CORNFLOWERBLUE);
        circle.setStroke(Color.PINK);
        
        Rectangle rec1 = new Rectangle(50, 100, 30, 40);
        pane.getChildren().add(rec1);
        rec1.setFill(Color.AQUAMARINE);
        
        Line l1 = new Line(0,50, 200,50);
        pane.getChildren().add(l1);
        l1.setStroke(Color.ORANGE);

        
        
        
        
    }
}
