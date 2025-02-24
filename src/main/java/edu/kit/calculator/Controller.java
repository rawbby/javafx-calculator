package edu.kit.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private TextField formula;

    @FXML
    private TextField result;

    @FXML
    protected void onButtonClick(MouseEvent event) {
        final var button = (Button) event.getSource();

        switch (button.getText()) {
            case "π":
            case "1":
            case "4":
            case "7":
            case "2":
            case "5":
            case "8":
            case "0":
            case "3":
            case "6":
            case "9":
            case "+":
            case "-":
            case "×":
            case "÷":
            case ",":
            case "(":
            case ")":
                formula.appendText(button.getText());
                break;

            case "⌫":
                final var text = formula.getText();
                if (!text.isEmpty())
                    formula.setText(text.substring(0, text.length() - 1));
                break;

            case "=":
                result.setText(Formula.calculate(formula.getText()));
                break;

            default:
                break;
        }

    }
}
