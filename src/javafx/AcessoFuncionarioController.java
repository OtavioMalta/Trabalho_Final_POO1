package javafx;

import DTO.Agencia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.io.IOException;

public class AcessoFuncionarioController {
    private Stage stage;
    private Scene scene;
    private Agencia agencia;
    @FXML
    private Button btn_EntrarLoginFuncionario;

    @FXML
    private Button btn_VoltarMenuInicial;

    @FXML
    private ToggleButton tbt_CargoGerente;

    @FXML
    private TextField tf_login;

    @FXML
    private TextField tf_senha;
    @FXML
    void CarregarAgencia(Agencia agencia){
        this.agencia = agencia;
    }
    @FXML
    private void VoltarParaMenuInicial(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuInicial.fxml"));
        Parent root = loader.load();
        MenuInicialController menuInicialController = loader.getController();
        menuInicialController.CarregarAgencia(this.agencia);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
