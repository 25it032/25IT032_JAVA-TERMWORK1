package  P6;

interface Switchable {
    void on();
    void off();

    default void toggle() {
        on();
    }
}

class Fan implements Switchable {
    public void on() {
        System.out.println("Fan is ON");
    }

    public void off() {
        System.out.println("Fan is OFF");
    }
}

class Light implements Switchable {
    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}

@FunctionalInterface
interface Permission {
    boolean canSwitchOn(Switchable device, int hour);
}

public class RemoteControl {
    public static void main(String[] args) {

        Switchable[] devices = {
            new Fan(),
            new Light(),
        };

        System.out.println("Toggling devices:");

        for (Switchable device : devices) {
            device.toggle();
        }

        System.out.println();

        System.out.println("Turning devices OFF:");

        for (Switchable device : devices) {
            device.off();
        }

        Permission anonymousPermission = new Permission() {
            public boolean canSwitchOn(Switchable device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        Permission lambdaPermission =
                (device, hour) -> hour >= 6 && hour <= 22;

        System.out.println();

        System.out.println("Anonymous Class:");

        System.out.println(
            anonymousPermission.canSwitchOn(devices[0], 10)
        );

        System.out.println();

        System.out.println("Lambda:");

        System.out.println(
            lambdaPermission.canSwitchOn(devices[1], 23)
        );
    }
}