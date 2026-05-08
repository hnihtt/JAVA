package Stream.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

public class User {
    private String name;
    private int age;
    private String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public static User parseUser(String s) throws UserParseException {
        String[] parts = s.split(":");
        if (parts.length != 3) {
            throw new UserParseException("Format khong hop le. Expected input: name:age:email", LocalDateTime.now());
        }

        String name = parts[0];
        String ageStr = parts[1];
        String email = parts[2];

        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            throw new UserParseException("Tuoi khong hop le");
        }

        if (Integer.parseInt(ageStr) < 16 ) {
            throw new UserParseException("Tuoi khong duoc nho hon 16");
        }

        if (!email.contains("@")) {
            throw new UserParseException("Email khong hop le");
        }

        return new User(name, age, email);
    }
}
