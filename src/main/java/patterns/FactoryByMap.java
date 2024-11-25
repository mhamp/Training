package patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * <h1>Shape Factory Implementation</h1>
 * <p>
 * The ShapeFactory class demonstrates the Factory Design Pattern using a mapping of shape types to
 * their corresponding constructors via the Supplier functional interface. This approach allows
 * for flexible and dynamic object creation while maintaining loose coupling between the factory and
 * the shape implementations.
 * </p>
 *
 * <h2>Features:</h2>
 * <ul>
 *   <li><b>Decoupled Object Creation:</b> The factory method is not tightly coupled to specific shape classes, enabling easier changes to the implementations.</li>
 *   <li><b>Lazy Initialization:</b> Shapes are created only when needed, improving performance and resource management.</li>
 *   <li><b>Flexible and Extensible:</b> New shapes can be added with minimal changes to the existing codebase, simply by updating the shape mapping.</li>
 *   <li><b>Improved Readability:</b> The use of a Map and Supplier streamlines the logic of shape creation, enhancing clarity and maintainability.</li>
 * </ul>
 *
 * <h2>Benefits:</h2>
 * <ul>
 *   <li><b>Loose Coupling:</b> Reduces dependencies between the factory and the shape classes, making it easier to modify or replace implementations.</li>
 *   <li><b>Enhanced Maintainability:</b> Centralizes object creation logic, allowing for updates to be made in one place rather than scattered throughout the code.</li>
 *   <li><b>Clearer Code Structure:</b> Simplifies the process of adding or modifying shapes, reducing the complexity of the factory method.</li>
 *   <li><b>Alignment with Functional Programming:</b> Utilizes Java's functional programming features, making the code more expressive and concise.</li>
 * </ul>
 *
 * <h2>Usage:</h2>
 * <p>
 * To use the ShapeFactory, instantiate it and call the <code>createShape</code> method with a string
 * representing the desired shape type (e.g., "CIRCLE", "SQUARE", "RECTANGLE"). The factory will return
 * an instance of the corresponding shape, or <code>null</code> if the shape type is not recognized.
 * </p>
 *
 * <h2>Example:</h2>
 * <pre>
 * {@code
 * ShapeFactory factory = new ShapeFactory();
 * Shape circle = factory.createShape("CIRCLE");
 * if (circle != null) circle.draw();
 * }
 * </pre>
 *
 * <h2>Note:</h2>
 * <p>
 * This implementation emphasizes the Factory Design Pattern's principles while leveraging Java's
 * functional interfaces to enhance flexibility and maintainability.
 * </p>
 */
public class FactoryByMap {
    // Map associating shape type strings with their respective constructors
    private static final Map<String, Supplier<Shape>> shapeMap = new HashMap<>();

    static {
        shapeMap.put("CIRCLE", Circle::new);
        shapeMap.put("SQUARE", Square::new);
        shapeMap.put("RECTANGLE", Rectangle::new);
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

        Supplier<Shape> shapeSupplier = shapeMap.get(shapeType.toUpperCase());

        if (shapeSupplier != null) {
            return shapeSupplier.get();
        } else {
            System.out.println("Unknown shape type: " + shapeType);
            return null;
        }
    }

    // Shape interface and shape implementations
    public interface Shape {
        void draw();
    }

    public static class Circle implements Shape {
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    public static class Square implements Shape {
        public void draw() {
            System.out.println("Drawing a Square");
        }
    }

    public static class Rectangle implements Shape {
        public void draw() {
            System.out.println("Drawing a Rectangle");
        }
    }

//    // Main method to test the factory pattern implementation
//    public static void main(String[] args) {
//        FactoryByMap factory = new FactoryByMap();
//
//        Shape circle = factory.createShape("CIRCLE");
//        if (circle != null) circle.draw();
//
//        Shape square = factory.createShape("SQUARE");
//        if (square != null) square.draw();
//
//        Shape rectangle = factory.createShape("RECTANGLE");
//        if (rectangle != null) rectangle.draw();
//
//        Shape unknown = factory.createShape("TRIANGLE"); // Will print "Unknown shape type"
//    }
}
