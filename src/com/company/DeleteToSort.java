package com.company;
import java.util.ArrayList;
import java.util.List;

/**
 * finds the indices that disrupt the order of the array list
 * lab is complete
 */
public class DeleteToSort {

    private ArrayList<Integer> indices = new ArrayList<Integer>();
    private boolean ordered = true;


    /**
     * returns the indices of the columns that are not sorted, returns empty brackets if they are
     * @param A
     * @return indices
     */
    ArrayList<Integer> minDeletionSize(String[] A) {
        indices.clear();        //resets the indices

        for (int i=0; i<A.length-1; i++) {
            if (A[i].length() != A[i+1].length()) {
                indices.add(-1);
                return indices;
            }
        }

        for (int l=0; l<A[0].length(); l++) {
            for (int w=0; w<A.length-1; w++) {
                if (A[w].charAt(l) > A[w+1].charAt(l)) {
                    indices.add(l);
                    ordered = false;
                    break;
                }
            }
        }

        if (ordered) {
            return new ArrayList<Integer>();
        }

        return indices;
    }

    /**
     * calls the minDeletionSize function above and tests a list
     * @param args
     */
    public static void main(String[] args) {
        //String[] A = {"cba", "daf", "ghi"};       output: [1]
        //String[] A = {"a", "b"};                  output: []
        //String[] A = {"zyx", "wvu", "tsr"};       output: [0, 1, 2]
        String[] A = {"Captain", "Marvel", "saved", "the", "Avengers"};     //output: -1

        DeleteToSort test = new DeleteToSort();

        System.out.println(test.minDeletionSize(A));
    }
}
