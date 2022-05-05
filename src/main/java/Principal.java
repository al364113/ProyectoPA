import Algorithm.controlador.Controller;
import Algorithm.modelo.KNN.KNNModel;
import Algorithm.vista.Vista;
import javafx.application.Application;
import javafx.stage.Stage;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controlador = new Controller();
        KNNModel modelo = new KNNModel();
        Vista vista = new Vista(primaryStage);

        modelo.setVista(vista);
        controlador.setVista(vista);
        controlador.setModel(modelo);
        vista.setModelo(modelo);
        vista.setControlador(controlador);
        vista.creaGUI();
    }
}
