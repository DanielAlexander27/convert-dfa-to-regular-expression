import org.ietf.jgss.GSSName;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        example3();
    }

    // example 1.66 from book
    public static void example1() {
        ArrayList<Integer> states = new ArrayList<>(Arrays.asList(1, 2));

        TransitionFunctionTable transitionTable = new TransitionFunctionTable(states);
        transitionTable.insertLabelElement(1, 2, "b");
        transitionTable.insertLabelElement(1, 1, "a");
        transitionTable.insertLabelElement(2, 2, "a|b");

        DFA dfa = new DFA(1, 2, transitionTable);
        GNFA gnfa = new GNFA(dfa);

        GNFA convertedGNFA = ConvertAlgorithm.convertAlgorithm(gnfa);

        System.out.println(convertedGNFA.transitionFunctions.getMatrix().get(0).get(1));
    }

    // example 1.68 from book
    public static void example2() {
        ArrayList<Integer> states = new ArrayList<>(Arrays.asList(1, 2, 3));

        TransitionFunctionTable transitionTable = new TransitionFunctionTable(states);
        transitionTable.insertLabelElement(1, 2, "a");
        transitionTable.insertLabelElement(2, 1, "a");
        transitionTable.insertLabelElement(1, 3, "b");
        transitionTable.insertLabelElement(3, 1, "b");
        transitionTable.insertLabelElement(2, 2, "b");
        transitionTable.insertLabelElement(3, 2, "a");

        DFA dfa = new DFA(1, Arrays.asList(2, 3), transitionTable);
        GNFA gnfa = new GNFA(dfa);

        GNFA convertedGNFA = ConvertAlgorithm.convertAlgorithm(gnfa);

        System.out.println(convertedGNFA.transitionFunctions.getMatrix().get(0).get(1));
    }

    // exercise 1.21 - a)
    public static void example3() {
        ArrayList<Integer> states = new ArrayList<>(Arrays.asList(1, 2));

        TransitionFunctionTable transitionTable = new TransitionFunctionTable(states);
        transitionTable.insertLabelElement(1, 2, "b");
        transitionTable.insertLabelElement(2, 1, "b");
        transitionTable.insertLabelElement(1, 1, "a");
        transitionTable.insertLabelElement(2, 2, "a");

        DFA dfa = new DFA(1, Arrays.asList(2, 3), transitionTable);
        GNFA gnfa = new GNFA(dfa);

        GNFA convertedGNFA = ConvertAlgorithm.convertAlgorithm(gnfa);

        System.out.println(convertedGNFA.transitionFunctions.getMatrix().get(0).get(1));
    }

    // exercise 1.21 - b)
    public static void example4() {
        ArrayList<Integer> states = new ArrayList<>(Arrays.asList(1, 2, 3));

        TransitionFunctionTable transitionTable = new TransitionFunctionTable(states);
        transitionTable.insertLabelElement(1, 2, "a U b");
        transitionTable.insertLabelElement(2, 2, "a");
        transitionTable.insertLabelElement(2, 3, "b");
        transitionTable.insertLabelElement(3, 2, "b");
        transitionTable.insertLabelElement(3, 1, "a");

        DFA dfa = new DFA(1, Arrays.asList(1, 3), transitionTable);
        GNFA gnfa = new GNFA(dfa);

        GNFA convertedGNFA = ConvertAlgorithm.convertAlgorithm(gnfa);

        System.out.println(convertedGNFA.transitionFunctions.getMatrix().get(0).get(1));
    }

    // short quiz made on monday 11/march
    public static void example5() {
        ArrayList<Integer> states = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        TransitionFunctionTable transitionTable = new TransitionFunctionTable(states);
        transitionTable.insertLabelElement(1, 1, "0");
        transitionTable.insertLabelElement(1, 2, "1");
        transitionTable.insertLabelElement(2, 3, "1");
        transitionTable.insertLabelElement(3, 3, "1");
        transitionTable.insertLabelElement(3, 4, "0");
        transitionTable.insertLabelElement(4, 1, "1");
        transitionTable.insertLabelElement(2, 4, "0");

        DFA dfa = new DFA(1, Arrays.asList(1, 4), transitionTable);
        GNFA gnfa = new GNFA(dfa);

        GNFA convertedGNFA = ConvertAlgorithm.convertAlgorithm(gnfa);

        System.out.println(convertedGNFA.transitionFunctions.getMatrix().get(0).get(1));
    }
}