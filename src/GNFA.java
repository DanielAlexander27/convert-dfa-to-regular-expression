import java.util.List;

public class GNFA extends FiniteAutomata {
    public GNFA(DFA dfa) {
        super(0, calculateGNFAcceptState(dfa.getStates()), getTransitionFunctionsFromDFA(dfa));
    }

    public GNFA(int startState, int acceptState, List<Integer> states) {
        super(startState, acceptState, states);
    }

    private static TransitionFunctionTable getTransitionFunctionsFromDFA(DFA dfa) {
        TransitionFunctionTable newTransitionFunctions = new TransitionFunctionTable(dfa.getStates(), dfa.getTransitionFunctions().getMatrix());

        final int gnfaStartState = 0;
        final int gnfaAcceptState = calculateGNFAcceptState(dfa.getStates());

        newTransitionFunctions.insertState(gnfaStartState, 0);
        newTransitionFunctions.insertState(gnfaAcceptState);

        newTransitionFunctions.insertLabelElement(gnfaStartState, dfa.startState, "EPS");

        for (int dfaAcceptState : dfa.acceptStates) {
            newTransitionFunctions.insertLabelElement(dfaAcceptState, gnfaAcceptState, "EPS");
        }

        return newTransitionFunctions;
    }

    public int getSecondState() {
        if (this.states.size() < 2) {
            return -1;
        }

        return this.states.get(1);
    }

    private static int calculateGNFAcceptState(List<Integer> dfaStates) {
        final int lastIndex = dfaStates.size() - 1;

        return dfaStates.get(lastIndex) + 1;
    }
}
