package edu.kit.calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formula {
    private Formula() {
    }

    @FunctionalInterface
    private interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    private static String repl(String formula, Pattern pattern, TriFunction<Double, String, Double, Double> op) {
        while (true) {
            Matcher matcher = pattern.matcher(formula);
            if (!matcher.find()) return formula;
            final var a = Double.parseDouble(matcher.group(1));
            final var o = matcher.group(2);
            final var b = Double.parseDouble(matcher.group(3));
            final var result = op.apply(a, o, b);
            formula = matcher.replaceFirst(Double.toString(result));
        }
    }

    private static String calculate_basic(String formula) {
        final var mlt_div = Pattern.compile("([0-9]+(?:\\.[0-9]*)?)([*/])([0-9]+(?:\\.[0-9]*)?)", Pattern.MULTILINE);
        final var add_sub = Pattern.compile("([0-9]+(?:\\.[0-9]*)?)([+-])([0-9]+(?:\\.[0-9]*)?)", Pattern.MULTILINE);
        formula = repl(formula, mlt_div, (a, op, b) -> Objects.equals(op, "*") ? a * b : a / b);
        formula = repl(formula, add_sub, (a, op, b) -> Objects.equals(op, "+") ? a + b : a - b);
        return formula;
    }

    private static String calculate_braces(String formula) {
        final var pattern = Pattern.compile("\\(([^()]*)\\)", Pattern.MULTILINE);

        while (true) {
            Matcher matcher = pattern.matcher(formula);
            if (!matcher.find()) break;

            formula = matcher.replaceFirst(calculate_braces(matcher.group(1)));
        }

        formula = calculate_basic(formula);
        return formula;
    }

    public static String calculate(String formula) {
        formula = formula.replaceAll("×", "*");
        formula = formula.replaceAll("÷", "/");
        formula = formula.replaceAll(",", ".");
        formula = formula.replaceAll("π", String.valueOf(Math.PI));
        formula = calculate_braces(formula);
        formula = formula.replaceAll("\\.", ",");
        return formula;
    }
}
