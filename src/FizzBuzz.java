import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {

    private static FizzBuzz instance;

    private FizzBuzz() {
    }

    public static FizzBuzz of() {
        if (instance != null) {
            return instance;
        }
        return instance = new FizzBuzz();
    }

    public List<String> fizzBuzz(int n) {

        List<String> resList = new LinkedList<>();
        String fizz = "Fizz";
        String Buzz = "Buzz";
        String tmp = "";
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0 && i % 5 == 0) {
                    tmp = fizz + Buzz;
                } else {
                    if (i % 3 == 0) {
                        tmp = fizz;
                    }
                    if (i % 5 == 0) {
                        tmp = Buzz;
                    }
                }
            } else {
                tmp = String.valueOf(i);
            }

            resList.add(tmp);
        }
        return resList;
    }

    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("FizzBuzz");
        System.out.println(
                clz.getMethod("fizzBuzz", int.class).invoke(clz.getMethod("getInstance").invoke(new Object()), 5));
    }
}
