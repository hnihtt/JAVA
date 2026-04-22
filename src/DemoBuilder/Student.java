package DemoBuilder;

public class Student {
    private int id;
    private String name;
    private String email;
    private int age;
    private String status;
    private double tuitionFee;
    private String address;

    public Student() {

    }

    public Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.status = builder.status;
        this.tuitionFee = builder.tuitionFee;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + email + " " + age + " " + status + " " + tuitionFee + " " + address;
    }

    public static class Builder {
        private int id;
        private String name;
        private String email;
        private int age;
        private String status;
        private double tuitionFee;
        private String address;

        Builder() {

        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setTuitionFee(double tuitionFee) {
            this.tuitionFee = tuitionFee;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

}
