package javafx;

import DTO.*;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class CadastrarFuncionarioController {
    private Stage stage;
    private Scene scene;
    private Agencia agencia;
    static ArrayList<Funcionario>funcionarios = new ArrayList<>();
    @FXML
    private Button btn_SalvarNovoFuncionario;

    @FXML
    private Button btn_VoltarMenuInicial;

    @FXML
    private TextField tf_agencia;

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_supervisor;

    @FXML
    private TextField tf_telefone;
    @FXML
    void CarregarAgencia(Agencia agencia){
        this.agencia = agencia;
    }
    @FXML
    private void VoltarParaMenuInicial(ActionEvent event) throws IOException{
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
    private void SalvarFuncionario(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuContaFuncionario.fxml"));
        Parent root = loader.load();
        Funcionario NovoFuncionario;
        if(tf_supervisor.getText().equals("")){
            NovoFuncionario = new Supervisor(tf_nome.getText(),tf_telefone.getText(), new Date(),agencia.getId());
        }
        else{
            NovoFuncionario = new Gerente(tf_nome.getText(),tf_telefone.getText(),0l, new Date(),agencia.getId());
            
        }
        MenuContaFuncionarioController menuContaFuncionarioController = loader.getController();
        funcionarios.add(NovoFuncionario);
        menuContaFuncionarioController.CarregarFuncionario(this.agencia,NovoFuncionario);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
