package javafx;

import DTO.Agencia;
import DTO.Cliente;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static javafx.CadastrarClienteController.clientes;

public class MenuContaClienteController {
    private Stage stage;
    private Scene scene;
    private Cliente cliente;
    private Agencia agencia;
    @FXML
    private Button btn_addConta;

    @FXML
    private Button btn_editInfo;

    @FXML
    private Button btn_slcConta;

    @FXML
    private Label id;

    @FXML
    private Button logout;

    @FXML
    private Label nome;

    @FXML
    private Label ultimoAcesso;

    @FXML
    void AdicionarConta(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NovaConta.fxml"));
        Parent root = loader.load();
        NovaContaController novaContaController = loader.getController();
        novaContaController.CarregarCliente(cliente,agencia);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void Logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuInicial.fxml"));
        Parent root = loader.load();
        MenuInicialController menuInicialController = loader.getController();
        menuInicialController.CarregarAgencia(agencia);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void SelecionarConta(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AcessoConta.fxml"));
        Parent root = loader.load();
        AcessoContaController acessoContaController = loader.getController();
        acessoContaController.CarregarPerfil(cliente,agencia);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CarregarCliente(Cliente cliente, Agencia agencia){
        this.cliente = cliente;
        this.agencia = agencia;
        nome.setText(cliente.getNome());
        id.setText(Long.toString(cliente.getId()));
        LocalDateTime now = LocalDateTime.now();
        ultimoAcesso.setText(now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
