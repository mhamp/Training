package patterns;

/**
 * <b>Builder Pattern</b><br><br>
 *
 * <p>The Builder pattern is a creational design pattern that helps construct complex objects step-by-step.
 * It is especially useful for creating immutable objects or objects that require several optional parameters.</p><br>
 *
 * Advantages:
 * <ul>
 * <li><b>Flexibility</b>: Handles both required and optional parameters cleanly.</li>
 * <li><b>Readability</b>: Improves readability by using descriptive setter methods.</li>
 * <li><b>Maintainability</b>: Simplifies the addition or removal of parameters in the object.</li>
 * <li><b>Error Prevention</b>: Reduces errors due to parameter order or missing fields.</li>
 *</ul>
 *
 *  Features:
 *  <ol>
 *  <li><b>Separation of Construction and Representation</b>
 *  <ul>
 *  <li>The Builder pattern separates the construction of an object from its representation,
 *  making it possible to create different representations of an object using the same construction process.</li>
 *  <li>It focuses on simplifying the construction process by handling each part of the object incrementally,
 *  allowing for flexibility and control.</li>
 *  </ul>
 *  </li>
 *  <li><b>Immutable Objects</b>
 *  <ul>
 *  <li>The Builder pattern is often used to create immutable objects where fields are set only once during the object’s construction.</li>
 *  <li>By allowing values to be set only through the builder, once the object is built, it cannot be modified.</li>
 *  </ul>
 *  </li>
 *  </li>
 *  <li><b>Chainable and Fluent Interface</b>
 *  <ul>
 *  <li>Builder classes typically provide chainable (or fluent) methods for setting different attributes.</li>
 *  <li>Each method returns the builder instance itself, allowing the user to set multiple properties in a single statement.</li>
 *  </ul>
 *  </li>
 *  <li><b>Optional Parameters</b>
 *  <ul>
 *  <li>The Builder pattern is particularly beneficial when there are many optional parameters, as it avoids the need for numerous constructors with varying arguments.</li>
 *  <li>This makes the code more readable and avoids "constructor telescoping," where constructors are overloaded with every possible combination of optional parameters.</li>
 *  </ul>
 *  </li>
 *  <li><b>Increased Readability and Maintainability</b>
 *  <ul>
 *  <li>By providing named methods for setting each field, the Builder pattern enhances readability.</li>
 *  <li>The parameter names and methods clearly indicate what each value represents, reducing errors that occur from mixing up parameters in constructor calls.</li>
 *  <li>It also allows for easy refactoring; additional fields can be added to the builder without breaking existing code.</li>
 *  </ul>
 *  </li>
 *  </li>
 *  <li><b>Validation and Consistency Checks</b>
 *  <ul>
 *  <li>Builders can include validation logic within the <code>build()</code> method to ensure the object is consistent and meets required conditions.</li>
 *  <li>For example, the <code>build()</code> method can throw exceptions if required fields are not set or if certain values are invalid.</li>
 *  </ul>
 *  </li>
 *  <li><b>Support for Complex Object Construction</b>
 *  <ul>
 *  <li>Builders can manage the construction of objects that involve multiple subcomponents, calculations, or a specific order of operations.</li>
 *  <li>By controlling how each part of an object is initialized and setting fields as needed, the Builder pattern can be used to create complex, multi-part objects step-by-step.</li>
 *  </ul>
 *  </li>
 *  <li><b>Decoupling of Client Code from Implementation Details</b>
 *  <ul>
 *  <li>The client code does not need to know the details of the object construction; it only needs to know about the builder’s methods.</li>
 *  <li>The builder encapsulates the object’s construction logic, allowing changes to the construction process without affecting client code.</li>
 *  </ul>
 *  </li>
 *  </ol>
 *
 */
public class Builder {
    private final String name;   // Required
    private final double price;  // Required
    private final String color;  // Optional
    private final String category; // Optional

    private Builder(BuilderDemo builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.color = builder.color;
        this.category = builder.category;
    }

    public static class BuilderDemo {
        private final String name;
        private final double price;
        private String color = "Default";      // Optional with default value
        private String category = "General";   // Optional with default value

        public BuilderDemo(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public BuilderDemo setColor(String color) {
            this.color = color;
            return this;
        }

        public BuilderDemo setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder build() {
            // Validation if necessary
            if (name == null || price <= 0) {
                throw new IllegalArgumentException("Name and price are required and must be valid.");
            }
            return new Builder(this);
        }
    }

}
