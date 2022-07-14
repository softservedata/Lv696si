package org.example;

public class DrawLineTest {

    public enum LineType {
        SOLID ("solid"), DOTTED ("dotted"), DASHED ("dashed"), DOUBLE ("double");

        private String type;
        LineType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static String drawLine(LineType lineType) {
        return ("The line is " + lineType.getType() + " type");
    }
}
