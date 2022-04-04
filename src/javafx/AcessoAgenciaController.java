package javafx;

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

public class AcessoAgenciaController {
    private Stage stage;
    private Scene scene;
    @FXML
    private Button btn_selecionar;

    @FXML
    private TextField tf_idAgencia;

    @FXML
    void CarregarAgencia(ActionEvent event) throws IOException {
        int id = Integer.parseInt(tf_idAgencia.getText());

        for(int i = 0;i<CadastrarAgenciaController.AgenciasCadastradas.size();i++){
            if(CadastrarAgenciaController.AgenciasCadastradas.get(i).getId() == id){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuInicial.fxml"));
                Parent root = loader.load();
                MenuInicialController menuInicialController =  loader.getController();
                menuInicialController.CarregarAgencia(CadastrarAgenciaController.AgenciasCadastradas.get(i));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }
    @FXML
    private void VoltarPagina(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PaginaInicial.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
