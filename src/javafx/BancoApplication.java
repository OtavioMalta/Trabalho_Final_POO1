package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class BancoApplication extends Application {
   /*@Override
    public void start(Stage stage) throws IOException {
        Pane painel = (Pane) FXMLLoader.load(PaginaInicialController.class.getResource("resources/PaginaInicial.fxml"));
        stage.setScene(new Scene(painel));
        stage.show();
    }*/
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(PaginaInicialController.class.getResource("PaginaInicial.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}