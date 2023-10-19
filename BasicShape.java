public abstract class BasicShape extends HasState implements Relatable {

    protected int[] color = new int[3];

    // Non-argument constructor that sets color to white
    public BasicShape() {
        setColor(255, 255, 255);
    }

    // Constructor that takes red, green, and blue parameters
    public BasicShape(int red, int green, int blue) {
        setColor(red, green, blue);
    }

    // Constructor that takes int of colors
    public BasicShape(int[] colors) {
        setColor(colors[0], colors[1], colors[2]);
    }

    // Accessor method for color
    public int[] getColor() {
        return new int[]{color[0], color[1], color[2]}; // Deep copy of the array
    }

    // Mutator method for color
    public void setColor(int red, int green, int blue) {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
            throw new IllegalArgumentException("RGB values must be in the range [0, 255]");
        }
        color[0] = red;
        color[1] = green;
        color[2] = blue;
    }
    // Mutator method for color
    public void setColor(int[] colors) {
        if (colors[0] < 0 || colors[0] > 255 || colors[1] < 0 || colors[1] > 255 || colors[2] < 0 || colors[2] > 255) {
            throw new IllegalArgumentException("RGB values must be in the range [0, 255]");
        }
        color[0] = colors[0];
        color[1] = colors[1];
        color[2] = colors[2];
    }

    // Abstract method to get the area
    public abstract double getArea();

    // Implement the equals method from the Relatable interface
    @Override
    public boolean equals(Object s) {
        if (s instanceof BasicShape) {
            return this.getArea() == ((BasicShape) s).getArea();
        }
        return false;
    }

    // Implement the isGreater method from the Relatable interface
    @Override
    public boolean isGreater(Object s) {
        if (s instanceof BasicShape) {
            return this.getArea() > ((BasicShape) s).getArea();
        }
        return false;
    }

    // Implement the isLess method from the Relatable interface
    @Override
    public boolean isLess(Object s) {
        if (s instanceof BasicShape) {
            return this.getArea() < ((BasicShape) s).getArea();
        }
        return false;
    }
}
