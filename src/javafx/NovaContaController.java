package javafx;

import DTO.Agencia;
import DTO.Cliente;
import DTO.ContaCorrente;
import DTO.ContaPoupanca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.io.IOException;

public class NovaContaController {
    private Cliente cliente;
    private Agencia agencia;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button btn_salvar;

    @FXML
    private Button btn_voltar;

    @FXML
    private ToggleButton tb_tipo;

    @FXML
    private TextField tf_saldo;

    @FXML
    private TextField tf_taxa;

    @FXML
    void SalvarConta(ActionEvent event) throws IOException {
        if(tb_tipo.isSelected()){
         ContaCorrente NovaConta = new ContaCorrente(agencia.getId(), Double.parseDouble(tf_saldo.getText()),Double.parseDouble(tf_taxa.getText()));
         cliente.adicionarConta(NovaConta);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuContaCLiente.fxml"));
            Parent root = loader.load();
            MenuContaClienteController menuContaClienteController = loader.getController();
            menuContaClienteController.CarregarCliente(this.cliente,this.agencia);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            ContaPoupanca NovaConta = new ContaPoupanca(agencia.getId(), Double.parseDouble(tf_saldo.getText()),Double.parseDouble(tf_taxa.getText()));
            cliente.adicionarConta(NovaConta);
            NovaConta.atribuirCliente(cliente.getId());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuContaCLiente.fxml"));
            Parent root = loader.load();
            MenuContaClienteController menuContaClienteController = loader.getController();
            menuContaClienteController.CarregarCliente(this.cliente,this.agencia);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void VoltarPagina(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuContaCLiente.fxml"));
        Parent root = loader.load();
        MenuContaClienteController menuContaClienteController = loader.getController();
        menuContaClienteController.CarregarCliente(this.cliente,this.agencia);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CarregarCliente(Cliente cliente, Agencia agencia){
        this.cliente = cliente;
        this.agencia = agencia;
    }
}
