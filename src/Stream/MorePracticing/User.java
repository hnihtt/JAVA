package Stream.MorePracticing;

public class User {
    private long id;
    private String name;
    private String role;
    private boolean isActive;

    public User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.role = builder.role;
        this.isActive = builder.isActive;
    }

    public String getRole() {
        return role;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public boolean isActive() {
        return isActive;
    }

    public static class Builder {
        private long id;
        private String name;
        private String role;
        private boolean isActive;


        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


}
