import java.text.DecimalFormat;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {
    public static void plusMinus(List<Integer> arr) {
        AtomicInteger plus = new AtomicInteger();
        AtomicInteger zero = new AtomicInteger();
        AtomicInteger minus = new AtomicInteger();
        arr.forEach(elem -> {
                if (elem > 0)
                    plus.getAndIncrement();

                else if (elem == 0)
                    zero.getAndIncrement();
                else minus.getAndIncrement();
                }
        );

        System.out.printf("%.6f %n", plus.get()*1.0/arr.size());
        System.out.printf("%.6f %n", minus.get()*1.0/arr.size());
        System.out.printf("%.6f %n", zero.get()*1.0/arr.size());
    }
}

    public class PlusMinusSolution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());
            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            Result.plusMinus(arr);

            bufferedReader.close();
        }
    }

