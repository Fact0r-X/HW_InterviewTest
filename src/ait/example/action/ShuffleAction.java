package ait.example.action;

import ait.example.TextManipulatorAppl.TextAction;
import java.util.Collections;
import java.util.List;

public class ShuffleAction implements TextAction {
    @Override
    public String getName() {
        return "shuffle";
    }

    @Override
    public void execute(List<String> input, List<String> output) {
        Collections.shuffle(input);
        output.addAll(input);
    }
}