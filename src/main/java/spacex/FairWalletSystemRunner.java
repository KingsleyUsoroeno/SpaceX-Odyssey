package main.java.spacex;

public class FairWalletSystemRunner {
    public static void main(String[] args) {

        final Station abujaStation = new Station("Abuja", StationType.NATURAL, OrbitType.EARTH);
        final Station spockStation = new Station("Spock", StationType.NATURAL, OrbitType.MARS);
        final Station issStation = new Station("International Space Station", StationType.MAN_MADE, OrbitType.EARTH);
        final Station moonStation = new Station("Moon", StationType.NATURAL, OrbitType.EARTH);

        final FairWalletSystem walletSystem = new FairWalletSystem();

        // funding wallet
        walletSystem.loadWallet(3000);

        // Taking trips

        walletSystem.takeTrip(abujaStation, moonStation, JetType.FALCON_9);
        walletSystem.takeTrip(moonStation, spockStation, JetType.FALCON_1);
        walletSystem.takeTrip(spockStation, issStation, JetType.FALCON_9);


        System.out.println(walletSystem.viewWalletBalance());
    }
}
