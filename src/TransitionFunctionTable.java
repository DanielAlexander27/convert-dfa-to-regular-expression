import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransitionFunctionTable {
    private final List<Integer> states;
    private final List<List<String>> matrix;

    TransitionFunctionTable(List<Integer> states) {
        this.states = states;
        this.matrix = generateMatrix(states.size());
    }

    TransitionFunctionTable(List<Integer> states, List<List<String>> matrix) {
        this.states = states;

        this.matrix = new ArrayList<List<String>>();

        for (List<String> row : matrix) {
            List<String> newRow = new ArrayList<String>(row);

            this.matrix.add(newRow);
        }
    }

    public List<Integer> getStates() {
        return new ArrayList<Integer>(states);
    }

    public List<List<String>> getMatrix() {
        List<List<String>> copyMatrix = new ArrayList<>();

        for (List<String> row : this.matrix) {
            List<String> copyRow = new ArrayList<>(row);
            copyMatrix.add(copyRow);
        }

        return copyMatrix;
    }

    public void insertState(int newState, int position) {
        this.states.add(position, newState);
        List<String> newRow = new ArrayList<>(Collections.nCopies(this.states.size(), null));

        for (List<String> row : matrix) {
            row.add(position, null);
        }

        this.matrix.add(position, newRow);
    }

    public void insertState(int newState) {
        this.states.add(newState);
        List<String> newRow = new ArrayList<>(Collections.nCopies(this.states.size(), null));

        for (List<String> row : matrix) {
            row.add(null);
        }

        this.matrix.add(newRow);
    }


    public String getLabelElement(int stateFrom, int stateTo) {
        final int indexFrom = states.indexOf(stateFrom);
        final int indexTo = states.indexOf(stateTo);

        if (indexFrom == -1 || indexTo == -1) return null;

        return matrix.get(indexFrom).get(indexTo);
    }

    public void insertLabelElement(int stateFrom, int stateTo, String label) {
        final int indexFrom = states.indexOf(stateFrom);
        final int indexTo = states.indexOf(stateTo);

        if (indexFrom == -1 || indexTo == -1) return;

        matrix.get(indexFrom).set(indexTo, label);
    }


    // Generates a matrix nxn
    public static List<List<String>> generateMatrix(int size) {
        final List<List<String>> matrix = new ArrayList<List<String>>();

        for (int i = 0; i < size; i++) {
            List<String> row = new ArrayList<>(Collections.nCopies(size, null));
            matrix.add(row);
        }

        return matrix;
    }

}
