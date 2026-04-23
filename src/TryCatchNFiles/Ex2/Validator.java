package TryCatchNFiles.Ex2;

public final class Validator {
    Validator(){}

    public static Integer checkQuant(String quantStr) {
        //Check cho ""
        if (quantStr.isEmpty()) {
            throw new MissingQuantityException("Thieu truong Quantity");
        }
        //Check cho "string"
        int value;
        try {
            value =  Integer.parseInt(quantStr);
        } catch (NumberFormatException nfe) {
            throw new InvalidFormatException("Sai dinh dang Quantity");
        }
        //Check negative
        if (value < 0) {
            throw new NegativeValueException("Quantity am");
        }

        return value;

        //Thu tu: null/empty -> parse -> business rule
    }

    public static Double checkPrice(String priceStr) {
        double value = Double.parseDouble(priceStr);
        if (value < 0) {
            throw new NegativeValueException("Gia am");
        }
        return value;
    }
}
