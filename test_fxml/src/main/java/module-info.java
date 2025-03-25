module iut.gon.test_fxml {
    requires javafx.controls;
    requires javafx.fxml;

    opens iut.gon.test_fxml to javafx.fxml;
    exports iut.gon.test_fxml;
}
