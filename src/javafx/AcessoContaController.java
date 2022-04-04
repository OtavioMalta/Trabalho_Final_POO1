package javafx;

import DTO.Agencia;
import DTO.Cliente;
import DTO.Conta;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AcessoContaController {
    private Cliente cliente;
    private Agencia agencia;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button btn_selecionar;

    @FXML
    private Button btn_voltar;

    @FXML
    private TextField tf_idConta;

    @FXML
    void SelecionarConta(ActionEvent event) throws IOException {
        for(int i = 0; i<cliente.getConta().size();i++){
            if(Integer.parseInt(tf_idConta.getText()) == cliente.getConta().get(i).getId()){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("OperacoesConta.fxml"));
                Parent root = loader.load();
                OperacoesContaController operacoesContaController =  loader.getController();
                operacoesContaController.CarregarConta(cliente.getConta().get(i),agencia,this.cliente);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    @FXML
    void VoltarPagina(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuContaCliente.fxml"));
        Parent root = loader.load();
        MenuContaClienteController menuContaClienteController = loader.getController();
        menuContaClienteController.CarregarCliente(cliente,agencia);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CarregarPerfil(Cliente cliente, Agencia agencia){
        this.cliente = cliente;
        this.agencia = agencia;
    }
}
