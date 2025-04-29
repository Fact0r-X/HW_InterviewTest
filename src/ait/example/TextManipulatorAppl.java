package ait.example;

import ait.example.action.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TextManipulatorAppl {
    public interface TextAction {
        String getName();

        void execute(List<String> input, List<String> output);
    }

    private static final Map<String, TextAction> ACTIONS = new HashMap<>();

    static {
        ACTIONS.put("reverse", new ReverseAction());
        ACTIONS.put("sort", new SortAction());
        ACTIONS.put("shuffle", new ShuffleAction());
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java TextManipulatorAppl <input> <output> <action>");
            System.err.println("Available actions: " + ACTIONS.keySet());
            System.exit(1);
        }

        try {
            List<String> lines = Files.readAllLines(Paths.get(args[0]));
            List<String> result = new ArrayList<>();

            TextAction action = ACTIONS.get(args[2].toLowerCase());
            if (action == null) {
                throw new IllegalArgumentException("Unknown action: " + args[2]);
            }

            action.execute(lines, result);
            Files.write(Paths.get(args[1]), result);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(2);
        }
    }
}