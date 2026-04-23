package TryCatchNFiles.Ex3;

public class Computer {
    private String cpu;
    private Integer ram;
    private double storage;
    private String gpu;

    public Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
    }

    @Override
    public String toString() {
        return "cpu:" + cpu + " ram:" + ram + " storage:" + storage + " gpu:" + gpu;
    }

    public static class Builder {
        private String cpu;
        private Integer ram;
        private double storage;
        private String gpu;
        Builder() {}

        public Builder ram(Integer ram) {
            this.ram = ram;
            return this;
        }
        public Builder storage(double storage) {
            this.storage = storage;
            return this;
        }
        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Computer build() {
            if (cpu == null || cpu.isEmpty()) {
                throw new IllegalArgumentException("cpu va ram la bat buoc");
            } else {
                return new Computer(this);
            }
        }
    }
}
