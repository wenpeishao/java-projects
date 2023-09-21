import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;


public class DessertGame extends Application {
  private int score=0;
    @Override
    public void start(final Stage stage) {
        // Step 3 & 4
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("Dessert in the Desert JavaFX Game");
        
        // Step 5
        Label scoreLabel = new Label("Score: 0");
        borderPane.setTop(scoreLabel);
        BorderPane.setAlignment(scoreLabel, Pos.TOP_LEFT);

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        borderPane.setBottom(exitButton);
        BorderPane.setAlignment(exitButton, Pos.BOTTOM_RIGHT);
        
        // Step 6
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);

        // TODO: Step 7-10
        Random random = new Random();
        Button dessert = new Button("Dessert");
        Button[] Deserts = new Button[8]; 
        for(int i = 1; i<8; i++) {
          Deserts[i]= new Button("Desert");;
        }
        Deserts[0] = dessert;
        exitButton.requestFocus();

        randomizeButtonPositions(random,Deserts);
        
        Deserts[0].setOnAction(event -> {score++;
        scoreLabel.setText("Score: " + score);
        randomizeButtonPositions(random, Deserts);
        exitButton.requestFocus();
        });
        
        for(int i = 1; i<Deserts.length;i++) {
          Deserts[i].setOnAction(event -> {score--;
          for(int j = 1; j<Deserts.length;j++) {
            scoreLabel.setText("Score: "+score );
            
          }
          randomizeButtonPositions(random,Deserts);
          exitButton.requestFocus();});

        }
        for(int i=0;i<Deserts.length;i++) {
          pane.getChildren().add(Deserts[i]);
        }

        stage.setScene(scene);
        stage.show();
    }
    
    private void randomizeButtonPositions(Random generator, Button[] b ) {
      for(int i = 0; i<b.length; i++) {
        b[i].setLayoutX(generator.nextInt(600));
        b[i].setLayoutY(generator.nextInt(400));

        
      }
    }

    public static void main(String[] args) {
        Application.launch();

    }
}
