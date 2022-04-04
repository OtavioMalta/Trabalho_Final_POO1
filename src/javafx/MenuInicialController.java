package javafx;

import DTO.Agencia;
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

public class MenuInicialController {
    private Stage stage;
    private Scene scene;
    private Agencia agencia;

    @FXML
    private Button btn_AcessarCliente;

    @FXML
    private Button btn_AcessarFuncionario;

    @FXML
    private Button btn_NovoCliente;

    @FXML
    private Button btn_NovoFuncionario;
    @FXML
    private Label nomeAgencia;
    @FXML
    private Label cidadeAgencia;
    @FXML
    private Label estadoAgencia;
    @FXML
    private Label idAgencia;


    @FXML
    private void AcessarClienteLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AcessoCliente.fxml"));
        Parent root = loader.load();
        AcessoClienteController acessoClienteController = loader.getController();
        acessoClienteController.CarregarAgencia(this.agencia);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void AcessarFuncionarioLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AcessoFuncionario.fxml"));
        Parent root = loader.load();
        AcessoFuncionarioController acessoFuncionarioController = loader.getController();
        acessoFuncionarioController.CarregarAgencia(this.agencia);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void CadastrarCliente(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CadastrarCliente.fxml"));
        Parent root = loader.load();
        CadastrarClienteController cadastrarClienteController = loader.getController();
        cadastrarClienteController.CarregarAgencia(this.agencia);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void CadastrarFuncionario(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CadastrarFuncionario.fxml"));
        Parent root = loader.load();
        CadastrarFuncionarioController cadastrarFuncionarioController = loader.getController();
        cadastrarFuncionarioController.CarregarAgencia(this.agencia);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void CarregarAgencia(Agencia agencia){
        this.agencia = agencia;
        nomeAgencia.setText(this.agencia.getNome());
        cidadeAgencia.setText(this.agencia.getCidade());
        estadoAgencia.setText(this.agencia.getEstado());
        idAgencia.setText(String.valueOf(this.agencia.getId()));
    }
    @FXML
    private void Logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PaginaInicial.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
