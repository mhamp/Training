package patterns;

/**
 * <b>Singleton Pattern</b><br><br>
 * <p>The Singleton pattern is a creational design pattern that ensures a class has only one instance, providing a global point of access to that instance</p><br>
 * <b>Key Elements in This Implementation:</b>
 * <ul>
 * <li>Single Instance: Ensures that only one instance of the class exists throughout the application.</li>
 * <li>Private Constructor: Prevents instantiation from outside the class.</li>
 * <li>Global Access Point: Provides a static method (e.g., <code>getInstance())</code> to access the instance from anywhere in the application.</li>
 * <li>Lazy Initialization (optional): The instance is only created when getInstance is first called.</li>
 * <li>Thread Safety (optional): Uses double-checked locking with synchronized for thread safety.</li>
 * </ul>
 */
public class Singleton {
    // Volatile keyword ensures that multiple threads handle the singleton instance correctly
    private static volatile Singleton singleton;

    // Private constructor prevents instantiation from other classes
    private Singleton() {}

    // Double-checked locking principle to ensure thread safety
    public static Singleton getInstance() {
        if (singleton == null) {  // First check without locking
            synchronized (Singleton.class) {  // Lock only if instance is null
                if (singleton == null) {  // Second check with lock
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
