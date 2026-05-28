package Enum;
// Override cho mỗi Constant
public enum Operation {
    ADD {
        @Override
        int apply(int a, int b) {
            return a + b;
        }
    },

    SUBTRACT {
        @Override
        int apply(int a, int b) {
            return a - b;
        }
    };

    abstract int apply(int a, int b);
}
