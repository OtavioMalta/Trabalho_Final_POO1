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
import javafx.stage.Stage;

import java.io.IOException;

public class AcessoClienteController {
    private Stage stage;
    private Scene scene;
    private Agencia agencia;

    @FXML
    private Button btn_EntrarLoginCliente;

    @FXML
    private Button btn_VoltarMenuInicial;

    @FXML
    private TextField tf_login;

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
    @FXML
    private void Acessar(ActionEvent event)throws IOException{
        int id = Integer.parseInt(tf_login.getText());

        for(int i = 0;i<CadastrarAgenciaController.AgenciasCadastradas.size();i++){
            if(CadastrarClienteController.clientes.get(i).getId() == id){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuContaCliente.fxml"));
                Parent root = loader.load();
                MenuContaClienteController menuContaClienteController =  loader.getController();
                menuContaClienteController.CarregarCliente(CadastrarClienteController.clientes.get(i),agencia);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }
}
