import java.io.IOException;

public class MeshPayments {
    public static boolean solution(String S) {
        // write your code in Java SE 8

        // return true in case all 'a' left 'b' or only 'b' or 'a' in string
        boolean hasB = false;
        for(int i=0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'b') {
                hasB = true;
            }
            if (c == 'a' && hasB) {
                return false;
            }
        }
        return true;
    }

    public static int[] solutionBankTransfer(String R, int[] V) {
        // you can also use imports, for example:
        // import java.util.*;

        // you can write to stdout for debugging purposes, e.g.
        // System.out.println("this is a debug message");

        // write your code in Java SE 8
        //public int[] solution(String R, int[] V) {
            // write your code in Java SE 8
            int a = 0, b = 0, balA = 0, balB = 0;
            for(int i=0; i < R.length(); i++) {
                char c = R.charAt(i);
                if (c == 'A') {
                    balA += V[i];
                    balB -= V[i];
                    if (balB < 0) {
                        b = Math.min(b, balB);
                    }
                } else if (c == 'B') {
                    balA -= V[i];
                    balB += V[i];
                    if (balA < 0) {
                        a = Math.min(a, balA);
                    }
                }
            }
            return new int[]{-a,-b};
//        }
    }

    public static void main(String[] args) {
        // solution
        System.out.println(solution("bbaab"));//aabb
        // solutionBankTransfer
//        System.out.println(solutionBankTransfer("BAABA", new int[]{2, 4, 1, 1, 2});

//        Compilation successful.
//
//        Example test:   ('BAABA', [2, 4, 1, 1, 2])
//        OK
//
//        Example test:   ('ABAB', [10, 5, 10, 15])
//        WRONG ANSWER (got [15, 10] expected [0, 15])
//
//        Example test:   ('B', [100])
//        OK
    }
}



//--order by 1
//
//
//        --, NoOfCreatedRoles, NoOfCreatedAndEnabledRoles, NoOfUpdatedRoles
//        --from ( select CreatedBy,