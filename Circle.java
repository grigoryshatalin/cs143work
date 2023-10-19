import java.util.Arrays;

public class Circle extends BasicShape implements Cloneable {

    private int centerX;
    private int centerY;
    private double radius;

    // Non-argument constructor
    public Circle() {
        super(); // Call the parent constructor to set color to white
        centerX = 1;
        centerY = 1;
        radius = 1.0;
    }

    // Constructor with parameters
    public Circle(int centerX, int centerY, double radius, int[] color) {
        super(color); // Call the parent constructor to set the color field
        if (radius <= 0 || color.length != 3 || color[0] < 0 || color[0] > 255 || color[1] < 0 || color[1] > 255
                || color[2] < 0 || color[2] > 255) {
            throw new IllegalArgumentException("Invalid parameters for Circle");
        }
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    // Accessor method for centerX
    public int getCenterX() {
        return centerX;
    }

    // Mutator method for centerX
    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    // Accessor method for centerY
    public int getCenterY() {
        return centerY;
    }

    // Mutator method for centerY
    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    // Accessor method for radius
    public double getRadius() {
        return radius;
    }

    // Mutator method for radius
    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be a positive number");
        }
        this.radius = radius;
    }

    // Calculate and return the area of the circle
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Clone method
    @Override
    public Circle clone() {
        try {
            Circle clonedCircle = (Circle) super.clone(); // Shallow copy using Object.clone()

            // Copy the properties from the original Circle to the new one
            clonedCircle.setCenterX(this.getCenterX());
            clonedCircle.setCenterY(this.getCenterY());
            clonedCircle.setRadius(this.getRadius());

            int[] originalColor = this.getColor();
            int[] clonedColor = new int[originalColor.length];
            
            for(int i=0; i<3; i++){
                clonedColor[i]=originalColor[i];
            }
            clonedCircle.setColor(clonedColor);

            return clonedCircle;
        } catch (CloneNotSupportedException e) {
            // Handle the exception, e.g., by rethrowing it as a RuntimeException
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        // Do not change this implementation
        String str = "Center: (" + centerX + "," + centerY + "); Radius: " + radius + "; Color: (" + color[0] + ","
                + color[1] + "," + color[2] + ")";
        return str;
    }

    @Override
    public boolean equals(Object s) {
        if (s instanceof Circle) {
            Circle otherCircle = (Circle) s;
            return this.getArea() == otherCircle.getArea();
        }
        return false;
    }

    // Implement the isGreater method from the Relatable interface
    @Override
    public boolean isGreater(Object s) {
        if (s instanceof Circle) {
            Circle otherCircle = (Circle) s;
            return this.getArea() > otherCircle.getArea();
        }
        return false;
    }

    // Implement the isLess method from the Relatable interface
    @Override
    public boolean isLess(Object s) {
        if (s instanceof Circle) {
            Circle otherCircle = (Circle) s;
            return this.getArea() < otherCircle.getArea();
        }
        return false;
    }
}
