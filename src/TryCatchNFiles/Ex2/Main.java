package TryCatchNFiles.Ex2;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Order test = new Order.Builder().id(12).quant(12).build();
//        System.out.println(test);

        int totalOrder = 0;
        int invalidOrder = 0;
        int validOrder = 0;
        double revenue = 0;
        int currentLine = 0;


        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./src/TryCatchNFiles/Ex2/error.log"))) {
            try (BufferedReader reader = new BufferedReader(new FileReader("./src/TryCatchNFiles/Ex2/orders.csv"))) {
                String line;

                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    currentLine++;
                    boolean isValid = true;
                    String[] parts = line.split(",");
                    for (int i = 0; i < parts.length; i++) {
                        parts[i] = parts[i].trim();
                    }
                    int quant = 0;
                    double price = 0;

                    try {
                        quant = Validator.checkQuant(parts[2]);
                    } catch (MissingQuantityException | NegativeValueException | InvalidFormatException e) {
                        System.out.println(e.getMessage());

                        writer.write("Loi o dong: " + currentLine + " - error: " + e.getMessage());
                        writer.newLine();

                        isValid = false;
                    }
                    try {
                        price = Validator.checkPrice(parts[3]);
                    } catch (NegativeValueException e) {
                        System.out.println(e.getMessage());

                        writer.write("Loi o dong: " + currentLine + " - error: " + e.getMessage());
                        writer.newLine();


                        isValid = false;
                    }
                    totalOrder++;
                    if (isValid) {
                        revenue += price * quant;
                        validOrder++;
                    } else {
                        invalidOrder++;
                    }
                }
            } catch (FileNotFoundException fnf) {
                System.out.println("Khong tim thay file");
            } catch (IOException ioe) {
                System.out.println("Loi reader");
            }
        } catch (IOException ioe) {
            System.out.println("Loi writer");
        }




        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("Doanh thu: " + df.format(revenue));


        System.out.println("Tong don hang: " + totalOrder);
        System.out.println("Valid Order: " + validOrder);
        System.out.println("Invalid order: " + invalidOrder);
    }
}
