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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CadastrarAgenciaController {
    public static ArrayList<Agencia> AgenciasCadastradas = new ArrayList<>();
    private Stage stage;
    private Scene scene;
    private Parent parent;
    @FXML
    private Button btn_CadastrarNovaAgencia;

    @FXML
    private Button btn_VoltarPaginaInicial;

    @FXML
    private TextField tf_cidade;

    @FXML
    private TextField tf_estado;

    @FXML
    private TextField tf_nome;


    @FXML
    private void VoltarPagina(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PaginaInicial.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void SalvarAgencia(ActionEvent event)throws IOException{
        Agencia novaAgencia = new Agencia(tf_cidade.getText(),tf_estado.getText(),tf_nome.getText());
        AgenciasCadastradas.add(novaAgencia);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuInicial.fxml"));
        Parent root = loader.load();
        MenuInicialController menuInicialController =  loader.getController();
        menuInicialController.CarregarAgencia(novaAgencia);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
