package ait.example.action;

import ait.example.TextManipulatorAppl.TextAction;
import java.util.Collections;
import java.util.List;

public class ReverseAction implements TextAction {
    @Override
    public String getName() {
        return "reverse";
    }

    @Override
    public void execute(List<String> input, List<String> output) {
        Collections.reverse(input);
        output.addAll(input);
    }
}