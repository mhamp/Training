package patterns;

/**
 * Factory Design Pattern Documentation.
 * <p>
 * The Factory Design Pattern is a creational pattern providing a way to create objects without specifying the exact class of the object that will be created.
 * It encapsulates the instantiation logic, allowing a method to return different classes that implement a common interface or superclass.
 * This pattern promotes loose coupling, flexibility, and scalability by abstracting object creation.
 * </p>
 *
 * <h2>Features:</h2>
 * <ul>
 *   <li><b>Encapsulation of Object Creation:</b> Encapsulates the instantiation logic, allowing for centralized creation.</li>
 *   <li><b>Return of Common Interface:</b> Creates and returns objects of classes that implement a common interface or extend a superclass.</li>
 *   <li><b>Flexible Object Creation:</b> Allows returning different subclasses or implementations based on input parameters.</li>
 * </ul>
 *
 * <h2>Benefits:</h2>
 * <ul>
 *   <li><b>Loose Coupling:</b> Decouples the client code from concrete implementations, making code easier to modify and extend.</li>
 *   <li><b>Improved Maintainability:</b> Reduces repetition in instantiation, allowing updates in a single location.</li>
 *   <li><b>Scalability:</b> New product classes can be added with minimal changes to the existing codebase.</li>
 *   <li><b>Enhanced Readability:</b> Simplifies client code by abstracting object creation, making code cleaner and easier to understand.</li>
 * </ul>
 *
 * <h2>Common Use Cases:</h2>
 * <ul>
 *   <li><b>UI Component Creation:</b> Useful for creating different UI elements (e.g., buttons, text fields) based on theme or environment.</li>
 *   <li><b>Database Connections:</b> Creates connection objects for different database systems (e.g., MySQL, Oracle) based on configuration.</li>
 *   <li><b>Document Generation:</b> Generates different document formats (e.g., PDF, Word, Excel) based on user selection or export type.</li>
 *   <li><b>Loggers:</b> Returns different logger types based on log level or destination (e.g., file, console, remote server).</li>
 * </ul>
 *
 * <h2>Example Implementation:</h2>
 * <pre>
 * {@code
 * public class ShapeFactory {
 *     public Shape createShape(String shapeType) {
 *         switch (shapeType) {
 *             case "CIRCLE":
 *                 return new Circle();
 *             case "SQUARE":
 *                 return new Square();
 *             default:
 *                 throw new IllegalArgumentException("Unknown shape type: " + shapeType);
 *         }
 *     }
 * }
 * }
 * </pre>
 */
public class Factory {
    /**
     * The Shape interface represents a generic shape with a method to draw itself.
     */
    public interface Shape {
        void draw();
    }

    /**
     * Circle class implementing the Shape interface.
     */
    public static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    /**
     * Square class implementing the Shape interface.
     */
    public static class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Square");
        }
    }

    /**
     * Factory method to create a Shape object based on the provided shape type.
     *
     * @param shapeType A string specifying the type of shape to create (e.g., "CIRCLE", "SQUARE", "RECTANGLE").
     * @return A Shape object corresponding to the specified type, or null if the type is not recognized.
     */
    public Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        switch (shapeType.toUpperCase()) {
            case "CIRCLE":
                return new Circle();
            case "SQUARE":
                return new Square();
            default:
                System.out.println("Unknown shape type: " + shapeType);
                return null;
        }
    }
    public Shape createShapeByEnhancedSwitch(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        return switch (shapeType.toUpperCase()) {
            case "CIRCLE" -> new Circle(); // Directly returns a new Circle
            case "SQUARE" -> new Square(); // Directly returns a new Square
            default -> throw new IllegalStateException("Unexpected value: " + shapeType.toUpperCase());
        };
    }
}
