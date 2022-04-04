package javafx;

import DTO.Agencia;
import DTO.Funcionario;
import DTO.Gerente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuContaFuncionarioController {
    private Agencia agencia;
    private Funcionario funcionario;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btn_addDependente;

    @FXML
    private Button btn_logout;

    @FXML
    private Button btn_realizarSorteio;

    @FXML
    private Label nID;

    @FXML
    private Label nome;

    @FXML
    private Label tipoCargo;

    @FXML
    void AddDependente(ActionEvent event) {

    }

    @FXML
    void Logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuInicial.fxml"));
        Parent root = loader.load();
        MenuInicialController menuInicialController =  loader.getController();
        menuInicialController.CarregarAgencia(this.agencia);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void RealizarSorteio(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sorteio.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CarregarFuncionario(Agencia agencia, Funcionario funcionario){
        this.agencia = agencia;
        this.funcionario = funcionario;
        nome.setText(funcionario.getNome());
        nID.setText(String.valueOf(funcionario.getId()));
        if(funcionario instanceof Gerente) tipoCargo.setText("Gerente");
        else tipoCargo.setText("Supervisor");
    }

}
