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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CadastrarClienteController {
    private Stage stage;
    private Scene scene;
    private Agencia agencia;
    public static ArrayList<Cliente> clientes =new ArrayList<>();
    @FXML
    private Button btn_SalvarNovoUsuario;

    @FXML
    private Button btn_VoltarMenuInicial;

    @FXML
    private PasswordField pf_senha;

    @FXML
    private TextField tf_cidade;

    @FXML
    private TextField tf_cpf;

    @FXML
    private TextField tf_endereco;

    @FXML
    private TextField tf_estado;

    @FXML
    private TextField tf_nascimento;

    @FXML
    private TextField tf_nome;
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
    private void SalvarCliente(ActionEvent event) throws IOException, ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(tf_nascimento.getText());
        Cliente novoCliente = new Cliente(tf_nome.getText(),tf_cpf.getText(), date,tf_endereco.getText(),tf_cidade.getText(),tf_estado.getText(),0l);
        clientes.add(novoCliente);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuContaCLiente.fxml"));
        Parent root = loader.load();
        MenuContaClienteController menuContaClienteController = loader.getController();
        menuContaClienteController.CarregarCliente(clientes.get((int) novoCliente.getId()-1),this.agencia);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
