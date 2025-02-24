module edu.kit.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    opens edu.kit.calculator to javafx.fxml;
    exports edu.kit.calculator;
}
