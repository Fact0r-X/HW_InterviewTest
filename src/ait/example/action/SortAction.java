package ait.example.action;

import ait.example.TextManipulatorAppl.TextAction;
import java.util.Collections;
import java.util.List;

public class SortAction implements TextAction {
    @Override
    public String getName() {
        return "sort";
    }

    @Override
    public void execute(List<String> input, List<String> output) {
        Collections.sort(input);
        output.addAll(input);
    }
}