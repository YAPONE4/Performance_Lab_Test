import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task2 {

    public static double[] coordinatesReader() {
        double[] coordinates = new double[3];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/CircleCoordinates.txt"));
            String line = reader.readLine();
            String[] coords = line.split(" ");
            coordinates[0] = Double.parseDouble(coords[0]);
            coordinates[1] = Double.parseDouble(coords[1]);
            line = reader.readLine();
            coordinates[2] = Double.parseDouble(line);
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return coordinates;
    }

    public static List<String> getPositions() {
        List<String> positions = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/DotsCoordinates.txt"));
            for (;;) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                positions.add(line);
            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return positions;
    }

    public static List<Integer> relativePositions() {
        List<Integer> answers = new ArrayList<Integer>();
        ArrayList<String> positions = new ArrayList<String>(getPositions());
        double[] coordinates = coordinatesReader();
        positions.stream().forEach(
                e -> {
                    String[] coords = e.split(" ");
                    double x = Double.parseDouble(coords[0]);
                    double y = Double.parseDouble(coords[1]);
                    double len = Math.sqrt(Math.pow((coordinates[0] - x), 2) + Math.pow((coordinates[1] - y), 2));
                    if (len > coordinates[2]) {
                        answers.add(2);
                    } else {
                        if (len < coordinates[2]) {
                            answers.add(1);
                        } else {
                            answers.add(0);
                        }
                    }
                }
        );
        return answers;
    }

    public static void main(String[] args) {
        relativePositions().forEach(System.out::println);
    }
}
