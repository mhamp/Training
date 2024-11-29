package patterns;

/**
 * <b>Facade Pattern Demo</b>
 * Demonstrates the Facade Pattern using a home theater system example.
 * <p>
 * The Facade Pattern simplifies the interaction with complex subsystems
 * by providing a unified interface. In this example, the Facade abstracts
 * the operations required to prepare and use a home theater system.
 */
public class Facade {


    // Subsystem: Television
    private static class TV {
        void turnOn() {
            System.out.println("TV: Turning on.");
        }

        void setHDMIInput() {
            System.out.println("TV: Setting HDMI input.");
        }
    }

    // Subsystem: Sound System
    private static class SoundSystem {
        void turnOn() {
            System.out.println("Sound System: Powering up.");
        }

        void setSurroundSound() {
            System.out.println("Sound System: Enabling surround sound.");
        }
    }

    // Subsystem: Streaming Device
    private static class StreamingDevice {
        void powerOn() {
            System.out.println("Streaming Device: Powering on.");
        }

        void playMovie(String movie) {
            System.out.println("Streaming Device: Playing movie \"" + movie + "\".");
        }
    }

    // Facade encapsulating subsystems
    private TV tv;
    private SoundSystem soundSystem;
    private StreamingDevice streamingDevice;

    /**
     * Constructs a new HomeTheaterFacade and initializes the subsystems.
     */
    public Facade() {
        this.tv = new TV();
        this.soundSystem = new SoundSystem();
        this.streamingDevice = new StreamingDevice();
    }

    /**
     * Simplifies the process of setting up the home theater to watch a movie.
     *
     * @param movie the name of the movie to watch
     */
    public void watchMovie(String movie) {
        System.out.println("Starting home theater setup...");
        tv.turnOn();
        tv.setHDMIInput();
        soundSystem.turnOn();
        soundSystem.setSurroundSound();
        streamingDevice.powerOn();
        streamingDevice.playMovie(movie);
        System.out.println("Home theater is ready. Enjoy your movie!");
    }
}

