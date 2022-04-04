package javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;

public class PaginaInicialController {
    private Stage stage;
    private Scene scene;
    private Parent parent;

    @FXML
    private Button btn_CadastrarAgencia;


    @FXML
    private Button btn_LerArquivo;

    @FXML
    private Pane scr_Banco;

    @FXML
    private void CadastrarAgencia(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CadastrarAgencia.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void AcessarAgencia(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AcessoAgencia.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
