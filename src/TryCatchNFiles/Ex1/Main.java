package TryCatchNFiles.Ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        //Split
//        String str1 = "Name,    9";
//        System.out.println(str1);
//        String[] parts = str1.split(",");
//        System.out.println(parts[0]);
//        System.out.println(parts[1]);
//
//        //Trim
//        String name = parts[0].trim();
//        String scoreStr = parts[1].trim();
//        System.out.println(name);
//        System.out.println(scoreStr);
//
//        //Parse int
//        int score = Integer.parseInt(scoreStr);
//        System.out.println(score);

        List<Integer> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("./src/TryCatchNFiles/Ex1/students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0].trim();
                String scoreStr = parts[1].trim();
                try {
                    int score = Integer.parseInt(scoreStr);
                    System.out.println(name + ": " + score);
                    scores.add(score);
                } catch (NumberFormatException nfe) {
                    System.out.println("Sai format/ " + nfe.getMessage());
                }
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found!");
        } catch (IOException ioe) {  //Do .close của reader.close(); throws -> buộc catch
            ioe.printStackTrace();
        }

        int total = scores.size();
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        double avgScore = (double) sum / total;
        System.out.println("Diem trung binh: " + avgScore);
    }
}
