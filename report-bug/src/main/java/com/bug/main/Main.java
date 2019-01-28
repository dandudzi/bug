package com.bug.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bug")
public class Main extends Application {


    private ConfigurableApplicationContext context;
    private Parent root;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
        context = builder.run(getParameters().getRaw().toArray(new String[0]));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene.fxml"));
        loader.setControllerFactory(context::getBean);
        root = loader.load();
    }


    @Override
    public void start(Stage primaryStage){
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setTitle("JavaFX and Maven");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        context.close();
    }
}
