import java.util.Scanner;

public class task1 {

    public static String cycle (int i, int n, int m, StringBuilder path) {
        path.append(i);
        i += m - 1;
        if (i > n) {
            i -= n;
        }
        if (i == 1) {
            return  path.toString();
        }
        return cycle(i, n, m, path);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type size of array: ");
        int n = scanner.nextInt();
        System.out.println("\nType size of the step: ");
        int m = scanner.nextInt();
        System.out.println("\nFound path: " + cycle(1, n, m, new StringBuilder()));

    }
}
