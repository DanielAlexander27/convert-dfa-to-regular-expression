import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiniteAutomata {
    protected final int startState;
    protected final List<Integer> acceptStates;
    protected final List<Integer> states;
    protected final TransitionFunctionTable transitionFunctions;

    public FiniteAutomata(int startState, List<Integer> acceptStates, List<Integer> states) {
        this.startState = startState;
        this.acceptStates = acceptStates;
        this.states = states;
        this.transitionFunctions = new TransitionFunctionTable(states);
    }

    public FiniteAutomata(int startState, int acceptState, List<Integer> states) {
        this.startState = startState;
        this.acceptStates = new ArrayList<Integer>(List.of(acceptState));
        this.states = states;
        this.transitionFunctions = new TransitionFunctionTable(states);
    }

    public FiniteAutomata(int startState, List<Integer> acceptStates,
                          TransitionFunctionTable transitionFunctions) {
        this.startState = startState;
        this.acceptStates = acceptStates;
        this.states = transitionFunctions.getStates();
        this.transitionFunctions = transitionFunctions;
    }

    public FiniteAutomata(int startState, int acceptState,
                          TransitionFunctionTable transitionFunctions) {
        this.startState = startState;
        this.acceptStates = new ArrayList<Integer>(List.of(acceptState));
        this.states = transitionFunctions.getStates();
        this.transitionFunctions = transitionFunctions;
    }

    public int getStartState() {
        return startState;
    }

    public List<Integer> getAcceptStates() {
        return acceptStates;
    }

    public List<Integer> getStates() {
        return new ArrayList<>(this.states);
    }

    public TransitionFunctionTable getTransitionFunctions() {
        return transitionFunctions;
    }
}
