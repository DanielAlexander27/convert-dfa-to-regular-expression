import java.util.*;

public class ConvertAlgorithm {
    public static GNFA convertAlgorithm(GNFA actualGNFA) {
        if (actualGNFA.states.size() == 2) {
            return actualGNFA;
        }

        int qRip = actualGNFA.getSecondState();
        List<Integer> newStates = new ArrayList<>();

        for (int state : actualGNFA.getStates()) {
            if (state != qRip) {
                newStates.add(state);
            }
        }

        GNFA newGNFA = new GNFA(actualGNFA.startState, actualGNFA.acceptStates.get(0), newStates);

        List<Map.Entry<Integer, Integer>> cartesianProduct = generateCartesianProduct(newStates);

        for (final Map.Entry<Integer, Integer> pair : cartesianProduct) {
            int i = pair.getKey();
            int j = pair.getValue();

            String result = generateNewTransitionFunction(i, j, qRip, actualGNFA.transitionFunctions);
            result = result != null && result.isBlank() ? "EPS" : result;

            newGNFA.transitionFunctions.insertLabelElement(i, j, result);
        }

        return convertAlgorithm(newGNFA);
    }

    public static List<Map.Entry<Integer, Integer>> generateCartesianProduct(List<Integer> newStates) {
        List<Integer> iStates = new ArrayList<Integer>(newStates);
        List<Integer> jStates = new ArrayList<Integer>(newStates);

        iStates.remove(newStates.size() - 1);
        jStates.remove(0);

        List<Map.Entry<Integer, Integer>> cartesianProduct = new ArrayList<>();

        for (final int iState : iStates) {
            for (int jState : jStates) {
                cartesianProduct.add(new AbstractMap.SimpleEntry<>(iState, jState));
            }
        }

        return cartesianProduct;
    }

    public static String generateNewTransitionFunction(Integer stateI, Integer stateJ, Integer stateRip,
                                                       TransitionFunctionTable transitionFunctionTable) {
        String r1;
        String r2;
        String r3;
        String r4;

        r1 = formatR(transitionFunctionTable.getLabelElement(stateI, stateRip), false, false);
        r2 = formatR(transitionFunctionTable.getLabelElement(stateRip, stateRip), true, false);
        r3 = formatR(transitionFunctionTable.getLabelElement(stateRip, stateJ), false, false);
        r4 = formatR(transitionFunctionTable.getLabelElement(stateI, stateJ), false, true);

        String prevResult = "";

        if (r1 == null || r3 == null) {
            if (r4 != null) {
                return r4;
            }
        }

        prevResult = String.format("%s%s%s", r1, r2, r3);

        if (r4 == null) {
            if (r1 == null || r3 == null) {
                return null;
            }

            return prevResult;
        }

        return String.format("%s U %s", prevResult, r4);
    }

    public static String formatR(String label, boolean isR2, boolean isR4) {
        if (label == null) {
            return isR2 ? "" : null;
        }

        if (label.equals("EPS")) {
            return isR4 ? label : "";
        }

        if (isR2) {
            if (label.length() == 1) {
                return String.format("%s*", label);
            }

            return String.format("(%s)*", label);
        }

        if (label.length() == 2 && label.contains("*")) {
            return label;
        }

        return label.length() == 1 ? label : String.format("(%s)", label);
    }


}

