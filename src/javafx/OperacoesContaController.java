package javafx;

import DTO.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class OperacoesContaController {
        private Conta conta;
        private Cliente cliente;
        private Agencia agencia;
        private Scene scene;
        private Stage stage;


    @FXML
    private Button Btn_confirmaSaque;

    @FXML
    private Button brn_emprestimo;

    @FXML
    private Button btn_confirmaDeposito;

    @FXML
    private Button btn_extrato;

    @FXML
    private Button btn_retornarMenu;

    @FXML
    private Label nConta;

    @FXML
    private TextField tf_deposito;

    @FXML
    private TextField tf_saque;

    @FXML
    private Label tipoConta;

    @FXML
    private Label valor;

    @FXML
    void RetornarParaMenuConta(ActionEvent event) throws IOException {
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
    void SalvarDeposito(ActionEvent event) {
        conta.setSaldo(conta.getSaldo() + Double.parseDouble(tf_deposito.getText()));
        valor.setText(Double.toString(conta.getSaldo()));
    }

    @FXML
    void SalvarSaque(ActionEvent event) {
        if(conta instanceof ContaPoupanca){
            if(conta.getSaldo() - Double.parseDouble(tf_saque.getText()) >=0){
                conta.setSaldo(conta.getSaldo() - Double.parseDouble(tf_saque.getText()));
                valor.setText(Double.toString(conta.getSaldo()));
            }
        }
        else{
            conta.setSaldo(conta.getSaldo() - Double.parseDouble(tf_saque.getText()));
            valor.setText(Double.toString(conta.getSaldo()));
        }

    }

    @FXML
    void SolicitarEmprestimo(ActionEvent event) throws IOException {

    }

    @FXML
    void VerificarExtrato(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Extrato.fxml"));
        Parent root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CarregarConta(Conta conta, Agencia agencia, Cliente  cliente) {
        this.conta = conta;
        this.agencia = agencia;
        this.cliente = cliente;
        valor.setText(Double.toString(conta.getSaldo()));
        if (conta instanceof ContaCorrente) tipoConta.setText("Conta Corrente");
        if (conta instanceof ContaPoupanca) tipoConta.setText("Conta Poupança");
        nConta.setText(Long.toString((conta.getId())));
        conta.setIdAgencia(agencia.getId());
    }

}
