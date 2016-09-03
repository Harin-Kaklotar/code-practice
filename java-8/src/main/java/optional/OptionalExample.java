package optional;

import java.util.Optional;

/**
 * Created by liju on 9/1/16.
 */
public class OptionalExample {
}

class Computer {
    private Optional<SoundCard> soundCard = Optional.empty();
    // other computer components

    //getter and setter
    public Optional<SoundCard> getSoundCard() {
        return soundCard;
    }
    public void setSoundCard(Optional<SoundCard> soundCard) {
        this.soundCard = soundCard;
    }
}

class SoundCard {
    private Optional<USB> usb = Optional.empty();

    //getter and setter
    public Optional<USB> getUsb() {
        return usb;
    }
    public void setUsb(Optional<USB> usb) {
        this.usb = usb;
    }
}

class USB {
    private String version;

    //getter and setter
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
}

class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();

        String version  = "Unknown";

     /* // pre java 8  -- just for showing
        if (computer != null) {
            final SoundCard soundCard = computer.getSoundCard();
            if (soundCard != null) {
                final USB usb = soundCard.getUsb();
                if (usb != null) {
                    version = usb.getVersion();
                }
            }
        }

      */

        // using java 8 optional
        Optional<Computer> computerOptional  = Optional.of(new Computer());
        computerOptional.flatMap(Computer::getSoundCard)
                        .flatMap(SoundCard::getUsb)
                        .map(USB::getVersion)
                        .orElse("Unknown");

        //Creating empty optional
        final Optional<Computer> emptyComputer = Optional.empty();

        /*
        Creating non-null optional,if Computer were null, a NullPointerException would be immediately thrown (rather than getting a latent error once you try to access properties of the Computer).
        */
        Computer computerInstance1 = null;
        final Optional<Computer> computerOptional1 = Optional.of(computerInstance1);// throws exception
        final Optional<Computer> computerOptional2 = Optional.of(new Computer());// doesn't throws exception

        /*
        Creating optional which can hold null value
        */
        Computer computerInstance2 = new Computer();
        final Optional<Computer> computerOptional3 = Optional.ofNullable(computerInstance2);
        Computer computerInstance3 = null;
        final Optional<Computer> computerOptional4 = Optional.ofNullable(computerInstance3); // doesn't throw any exception

        /*
         * Do something if value if present
         */
        final Optional<Computer> emptyComputer1 = Optional.empty();
         computerOptional1.ifPresent(System.out::print); //doesn't print anything if optional is empty
        /*
         * Set default value if optional is empty
         */
        final Optional<Computer> emptyComputer2 = Optional.empty();
        SoundCard soundCard = emptyComputer2.flatMap(Computer::getSoundCard).orElse(new SoundCard());

        /*
         * Throw exception if optional is empty
         */
        final Optional<Computer> emptyComputer3 = Optional.empty();
         soundCard = computerOptional.flatMap(Computer::getSoundCard).orElseThrow(IllegalStateException::new);

        /**
         * Filtering on optional
         */
        Optional<USB> usbOptional = Optional.ofNullable(new USB());
        usbOptional.filter(usb -> "1.0".equals(usb.getVersion())).ifPresent(System.out::print);

        /**
         * Extracting and transforming values using map method
         *
         */
        final Optional<SoundCard> soundCardOptional = Optional.ofNullable(new SoundCard());
        //checking for null and then extracting (here SoundCard object) using map method
        final Optional<Optional<USB>> usbOptional1 = soundCardOptional.map(SoundCard::getUsb);

        /**
         * Cascading optional objects using flat map
         *
         */

        // pre java 8 , below cascading had issue of handling null reference
        // String usbVersion = computer.getSoundCard().getUsb().getVersion();

        // with java 8 , we can rewrite the above as below
        String usbVersion = computerOptional.flatMap(Computer::getSoundCard)//note we are using flatMap because map of optional will return Optional<Optional<SoundCard>>> and wont compile
                                            .flatMap(SoundCard::getUsb) // same comment as above
                                            .map(USB::getVersion) // here map is required as it would return Optional<String>
            .orElse("Unknown");


    }

}