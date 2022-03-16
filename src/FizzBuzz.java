import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class FizzBuzzResult {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        // Write your code here
        for (int i=1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }


    }

}
public class FizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//        LocalDateTime localDateTime = LocalDateTime.parse("2018-06-23T05:55:55");
//        LocalDateTime endOfDate = localDateTime.toLocalDate().atTime(LocalTime.MIN);
//        System.out.println(endOfDate);
String [] arr = {"1","rger"};
List<String> le = Arrays.asList(arr);
Collections.sort(le);
        //System.out.println(Arrays.toString("1","rger")); //le));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        FizzBuzzResult.fizzBuzz(n);

        bufferedReader.close();
    }
}
