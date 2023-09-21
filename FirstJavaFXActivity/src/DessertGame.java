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



    Random random=new Random();
    Button[]buttons=new Button[8];
    Button Dessert=new Button("Dessert");
    Button Desert1=new Button("Desert");
    Button Desert2=new Button("Desert");
    Button Desert3=new Button("Desert");
    Button Desert4=new Button("Desert");
    Button Desert5=new Button("Desert");
    Button Desert6=new Button("Desert");
    Button Desert7=new Button("Desert");


    buttons[0]=Dessert;
    buttons[1]=Desert1;
    buttons[2]=Desert2;
    buttons[3]=Desert3;
    buttons[4]=Desert4;
    buttons[5]=Desert5;
    buttons[6]=Desert6;
    buttons[7]=Desert7;

    exitButton.requestFocus();
    randomizeButtonPositions( random,  buttons) ; //randomize at the start



    for(int i=0;i<buttons.length;i++) {
      pane.getChildren().add(buttons[i]);
    }





    buttons[0].setOnAction(event ->       {score++;
    scoreLabel.setText("Score: "+score );
    randomizeButtonPositions( random, buttons);
    exitButton.requestFocus();});


    for(int i=1;i<buttons.length;i++) {
      buttons[i].setOnAction(event ->  {score-- ; 

      for(int x=1;x<buttons.length;x++) {
        scoreLabel.setText("Score: "+score );
      }
      randomizeButtonPositions( random, buttons);
      exitButton.requestFocus();});
    }





    stage.setScene(scene);
    stage.show();
  }

  private void randomizeButtonPositions(Random random, Button[] buttons) {

    for(int i=0;i<buttons.length;i++) {
      buttons[i].setLayoutX(random.nextInt(600));
      buttons[i].setLayoutY(random.nextInt(400));
    }
  }

  public static void main(String[] args) {
    Application.launch();
  }
}