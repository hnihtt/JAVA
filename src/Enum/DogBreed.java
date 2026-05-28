package Enum;
// Implement với Enum
public enum DogBreed implements Animal{
    HUSKY,
    CORGI;


    @Override
    public void sound() {
        System.out.println("Woof");
    }
}
