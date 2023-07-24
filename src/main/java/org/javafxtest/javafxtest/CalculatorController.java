package org.javafxtest.javafxtest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.List;

public class CalculatorController {

    double initialValue = 0;
    double tempValue = 0;
    boolean isInitValue = true;
    double finalValue = 0;
    String operator = "";
    List<String> simpleOperators = Arrays.asList("+", "-", "x", "/");

    @FXML
    private Label initialValueLabel;
    @FXML
    private Label finalValueLabel;

    private void addValueToCalc(int num) {
        if (isInitValue) {
            initialValue = initialValue * 10 + num;
            finalValueLabel.setText(String.valueOf(initialValue));
        } else {
            tempValue = tempValue * 10 + num;
            finalValueLabel.setText(String.valueOf(tempValue));
        }
        System.out.println("Initial value");
        System.out.println(initialValue);
        System.out.println("Temp value");
        System.out.println(tempValue);
        System.out.println("Final value");
        System.out.println(finalValue);
    }

    private void calculateFinalResult() {
        switch (operator) {
            case "+":
                finalValue = initialValue + tempValue;
                break;
            case "-":
                finalValue = initialValue - tempValue;
                break;
            case "x":
                finalValue = initialValue * tempValue;
                break;
            case "/":
                finalValue = initialValue / tempValue;
                break;
            case "pow":
                finalValue = Math.pow(initialValue, 2);
                break;
            case "sqrt":
                finalValue = Math.sqrt(initialValue);
                break;
            case "fraction":
                finalValue = 1 / initialValue;
                break;
        }
        System.out.println("Initial value");
        System.out.println(initialValue);
        System.out.println("Temp value");
        System.out.println(tempValue);
        System.out.println("Final value");
        System.out.println(finalValue);
    }

    private void resetAll() {
        initialValue = 0;
        tempValue = 0;
        finalValue = 0;
        initialValueLabel.setText("");
        finalValueLabel.setText(String.valueOf(finalValue));
    }

    private void prepareOperator(String op) {
        operator = op;
        isInitValue = false;
        if (simpleOperators.contains(operator)) {
            initialValueLabel.setText(String.format("%s%s", String.valueOf(initialValue), operator));
        }
//        else {
//            switch (operator) {
//                case "pow" ->
//                        initialValueLabel.setText(String.format("%s(%s)", operator, String.valueOf(initialValue)));
//                case "sqrt" -> initialValueLabel.setText(String.format("√(%s)", String.valueOf(initialValue)));
//            }
//            System.out.println("Not simple");
//        }

    }

    @FXML
    protected void onZeroButtonClick() {
        addValueToCalc(0);
    }

    @FXML
    protected void onOneButtonClick() {
        addValueToCalc(1);
    }

    @FXML
    protected void onTwoButtonClick() {
        addValueToCalc(2);
    }

    @FXML
    protected void onThreeButtonClick() {
        addValueToCalc(3);
    }

    @FXML
    protected void onFourButtonClick() {
        addValueToCalc(4);
    }

    @FXML
    protected void onFiveButtonClick() {
        addValueToCalc(5);
    }

    @FXML
    protected void onSixButtonClick() {
        addValueToCalc(6);
    }

    @FXML
    protected void onSevenButtonClick() {
        addValueToCalc(7);
    }

    @FXML
    protected void onEightButtonClick() {
        addValueToCalc(8);
    }

    @FXML
    protected void onNineButtonClick() {
        addValueToCalc(9);
    }

    @FXML
    protected void onEqualsButtonClick() {
        calculateFinalResult();
        initialValueLabel.setText(String.format("%s %s %s =", initialValue, operator, tempValue));
        finalValueLabel.setText(String.valueOf(finalValue));
    }

    @FXML
    protected void onCancelButtonClick() {
        resetAll();
    }

    @FXML
    protected void onAddButtonClick() {
        prepareOperator("+");
    }

    @FXML
    protected void onSubtractButtonClick() {
        prepareOperator("-");
    }

    @FXML
    protected void onMultiplyButtonClick() {
        prepareOperator("x");
    }

    @FXML
    protected void onDivideButtonClick() {
        prepareOperator("/");
    }

    @FXML
    protected void onPowButtonClick() {
        prepareOperator("pow");
        calculateFinalResult();
        initialValueLabel.setText(String.format("sqr(%s) =", initialValue));
        finalValueLabel.setText(String.valueOf(finalValue));
    }

    @FXML
    protected void onSqrtButtonClick() {
        prepareOperator("sqrt");
        calculateFinalResult();
        initialValueLabel.setText(String.format("√(%s)", initialValue));
        finalValueLabel.setText(String.valueOf(finalValue));
    }

    @FXML
    protected void onFractionButtonClick() {
        prepareOperator("fraction");
        calculateFinalResult();
        initialValueLabel.setText(String.format("1/(%s)", initialValue));
        finalValueLabel.setText(String.valueOf(finalValue));
    }

    @FXML
    protected void onInvertSignButtonClick() {
        if (isInitValue) {
            initialValue *= -1;
            finalValueLabel.setText(String.format("%s", initialValue));
        } else {
            tempValue *= -1;
        }
    }
}