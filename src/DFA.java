import java.util.List;

public class DFA extends FiniteAutomata {
    public DFA(int startState, List<Integer> acceptStates,
               TransitionFunctionTable transitionFunctions) {
        super(startState, acceptStates, transitionFunctions);
    }

    public DFA(int startState, int acceptStates,
               TransitionFunctionTable transitionFunctions) {
        super(startState, acceptStates, transitionFunctions);
    }
}
