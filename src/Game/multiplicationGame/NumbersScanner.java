package Game.multiplicationGame;

import java.util.*;

/**
 * Creates two lists of text strings. This simulates some pairs of
 * multiplication problems with solved answers on corresponding positions in the lists.
 * @author Robert Rosencrantz
 * @version 3.0
 */
public class NumbersScanner {

    private int SIZE = 50;

    private Random random;

    private ArrayList<String> problems;
    private ArrayList<String> solved;

    public NumbersScanner() {
        createLists();
    }

    private void createLists() {
        random = new Random();

        problems = new ArrayList<>();
        solved = new ArrayList<>();

//        TEST*
//        LinkedList<String> same = new LinkedList<>();
//        LinkedList<Integer> sameCount = new LinkedList<>();

        for (int i = 0; i < SIZE; i++) {
            int factor1 = random.nextInt(10);
            int factor2 = random.nextInt(10);
            // Even out (sufficiently) the chances of matching factors. (See TEST*)
            if (factor2 != factor1) {
                factor2 = random.nextInt(10);
            }
            int product = (factor1 * factor2);
            String problem = factor1 + "*" + factor2;
            String productStr = String.valueOf(product);

            problems.add(problem);
            solved.add(productStr);
//        TEST* - change SIZE to large number like 100000
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
//        TEST*
//        int i1 = same.indexOf("1*2");
//        int i2 = same.indexOf("2*1");
//        int i3 = same.indexOf("1*1");
//        System.out.println("Ratio between count of 1*2 and 2*1 combined and count of 1*1 is " +
//                ( (double)(sameCount.get(i1) + sameCount.get(i2)) / sameCount.get(i3) ) );
//        // Result is close enough to 1
    }

    public ArrayList<String> getProblems() {
        return problems;
    }

    public ArrayList<String> getSolved() {
        return solved;
    }
}