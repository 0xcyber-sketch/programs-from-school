package opgave2.copy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.*;
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
         String name = "Stodder";
         
         Rectangle rec = new Rectangle(50, 100, 100, 50);
         pane.getChildren().add(rec);
         rec.setFill(null);
         rec.setStroke(Color.BLACK);
         
         System.out.println(rec.getHeight());
         System.out.println(rec.getWidth());
         
         Text textName = new Text(((rec.getWidth()/2 + 50)-20), (rec.getHeight()/2 + 100), name);
         pane.getChildren().add(textName);
         textName.setFill(Color.BLACK);
         
        		 
        
        
    }
}
