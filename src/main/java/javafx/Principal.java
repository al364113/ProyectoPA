package javafx;

import javafx.controlador.Controlador;
import javafx.modelo.KNNModelo;
import javafx.vista.Vista;
import javafx.application.Application;
import javafx.stage.Stage;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controlador controlador = new Controlador();
        KNNModelo modelo = new KNNModelo();
        Vista vista = new Vista(primaryStage);

        modelo.setVista(vista);
        controlador.setVista(vista);
        controlador.setModelo(modelo);
        vista.setModelo(modelo);
        vista.setControlador(controlador);
        vista.creaGUI();
    }
}
