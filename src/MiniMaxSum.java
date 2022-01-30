import java.io.*;
        import java.util.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.toList;

class ResultMiniMax {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
//        arr.forEach(elem -> {
//                    if (elem > 0)
//                        plus.getAndIncrement();
//
//                    else if (elem == 0)
//                        zero.getAndIncrement();
//                    else minus.getAndIncrement();
//                }
//
//        );
        long minSum = 0L;
        long maxSum = 0L;
        for (int j=0; j <5; j++) {
            long sum = 0L;
            for (int i = 0; i < arr.size(); i++) {
                if (i != j)
                    sum += Long.valueOf(arr.get(i));
            }
            if (minSum == 0)
                minSum = sum;
            else
                if (sum < minSum)
                    minSum = sum;
            if (maxSum == 0)
                maxSum = sum;
            else
                if (sum > maxSum)
                    maxSum = sum;

        }
        System.out.println(minSum + " " + maxSum);
    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        ResultMiniMax.miniMaxSum(arr);

        bufferedReader.close();
    }
}
