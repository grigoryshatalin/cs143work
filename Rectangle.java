public class Rectangle extends BasicShape {

    private int cornerX;
    private int cornerY;
    private double width;
    private double length;

    // Non-argument constructor
    public Rectangle() {
        super(); // Call the parent constructor (BasicShape)
        cornerX = 1;
        cornerY = 1;
        width = 1;
        length = 1;
    }

    // Constructor with arguments
    public Rectangle(int corner, int corner1, double width, double length, int[] color) {
        super(color); // Call the parent constructor (BasicShape)
        if (width <= 0 || length <= 0) {
            throw new IllegalArgumentException("Width and length must be positive numbers.");
        }
        if (color.length != 3 || !isColorValid(color)) {
            throw new IllegalArgumentException("The color array must be exactly 3 elements long, and each value must be in the range 0-255.");
        }
        this.width = width;
        this.length = length;
        this.cornerX = corner;
        this.cornerY = corner1;
    }
    // Constructor with arguments
    public Rectangle(double width, double length, int[] color) {
        super(color); // Call the parent constructor (BasicShape)
        if (width <= 0 || length <= 0) {
            throw new IllegalArgumentException("Width and length must be positive numbers.");
        }
        if (color.length != 3 || !isColorValid(color)) {
            throw new IllegalArgumentException("The color array must be exactly 3 elements long, and each value must be in the range 0-255.");
        }
        this.width = width;
        this.length = length;
    }

    // Accessor and mutator methods for cornerX, cornerY, width, and length
    public int getCornerX() {
        return cornerX;
    }

    public void setCornerX(int cornerX) {
        this.cornerX = cornerX;
    }

    public int getCornerY() {
        return cornerY;
    }

    public void setCornerY(int cornerY) {
        this.cornerY = cornerY;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be a positive number.");
        }
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be a positive number.");
        }
        this.length = length;
    }

    // Calculate and return the area of the rectangle
    public double getArea() {
        return width * length;
    }

    // Override the toString() method
    @Override
    public String toString() {
        return "Left Upper Corner: (" + cornerX + "," + cornerY + "); Width: " + width + "; Length: " + length + "; Color: (" + getColor()[0] + "," + getColor()[1] + "," + getColor()[2] + ")";
    }

    // Override the clone() method
    @Override
    public Rectangle clone() {
        return new Rectangle(this.width, this.length, this.getColor());
    }

    // Helper method to validate the color array
    private boolean isColorValid(int[] color) {
        for (int c : color) {
            if (c < 0 || c > 255) {
                return false;
            }
        }
        return true;
    }
}
