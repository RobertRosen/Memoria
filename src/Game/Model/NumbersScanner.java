package Game.Model;

import java.util.*;

/**
 * Creates two lists of text strings. This simulates some pairs of
 * multiplication problems with solved answers on corresponding positions in the lists.
 * @author Robert Rosencrantz
 * @version 4.0
 */
public class NumbersScanner {
    private final int SIZE = 50;
    private Random random;
    private ArrayList<String> problems;     // The multiplication problems.
    private ArrayList<String> solved;       // The answers to the problems.

    /**
     * Construct and initialize the lists.
     */
    public NumbersScanner() {
        createLists();
    }

    /**
     * Creates the lists from a random variable, representing the problems and answers as strings.
     */
    private void createLists() {
        random = new Random();
        problems = new ArrayList<>();
        solved = new ArrayList<>();
//        LinkedList<String> same = new LinkedList<>();         //TEST
//        LinkedList<Integer> sameCount = new LinkedList<>();   //TEST
        for (int i = 0; i < SIZE; i++) {
            int factor1 = random.nextInt(10);
            int factor2 = random.nextInt(10);
            // Even out (sufficiently) the probability of matching factors (Tested for a large number).
            if (factor2 != factor1) {
                factor2 = random.nextInt(10);
            }
            int product = (factor1 * factor2);
            String problem = factor1 + "*" + factor2;
            String productStr = String.valueOf(product);

            problems.add(problem);
            solved.add(productStr);
//        TEST - change SIZE to large number like 100000
//            if (!same.contains(problem)) {
//                same.addLast(problem);
//                sameCount.addLast(1);
//            } else {
//                int index = same.indexOf(problem);
//                int sameCountIncremented = (sameCount.get(index) + 1);
//                sameCount.add(index, sameCountIncremented);
//                sameCount.remove(index +1);
//            }
        }
//        TEST
//        int i1 = same.indexOf("1*2");
//        int i2 = same.indexOf("2*1");
//        int i3 = same.indexOf("1*1");
//        System.out.println("Ratio between count of 1*2 and 2*1 combined and count of 1*1 is " +
//                ( (double)(sameCount.get(i1) + sameCount.get(i2)) / sameCount.get(i3) ) );
//        // Result is close enough to 1
    }

    /**
     * Access to the list representing some multiplication problems.
     * @return the list
     */
    public ArrayList<String> getProblems() {
        return problems;
    }

    /**
     * Access to the list representing the answers to the problems list.
     * @return the list
     */
    public ArrayList<String> getSolved() {
        return solved;
    }
}