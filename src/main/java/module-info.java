module com.unidad1.actividad2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.unidad1.actividad2 to javafx.fxml;
    exports com.unidad1.actividad2;
}