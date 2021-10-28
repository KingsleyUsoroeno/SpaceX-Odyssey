package main.java.spacex;


public class FairWalletSystem {

    private int walletBalance;


    public void loadWallet(int amount) {
        this.walletBalance = amount;
    }

    public int viewWalletBalance() {
        return walletBalance;
    }

    private void deductFromWallet(int amount) {
        if (walletBalance < amount) throw new IllegalStateException("Please fund your wallet");
        walletBalance -= amount;
    }

    // falcon 9 is twice as expensive
    public void takeTrip(Station currentStation, Station destinationStation, JetType jetType) {
        int tripBetweenOrbits = 250; // Assume this is in BTC
        int royaltyCostForManMadeStations = 200;
        int journeyWithinOrbit = 50;

        if (jetType == JetType.FALCON_9) {
            journeyWithinOrbit *= 2;
            tripBetweenOrbits *= 2;
        }

        if (currentStation.stationType != destinationStation.stationType) {
            deductFromWallet(royaltyCostForManMadeStations);
        } else if (currentStation.orbit != destinationStation.orbit) {
            deductFromWallet(tripBetweenOrbits);
        } else {
            deductFromWallet(journeyWithinOrbit);
        }
    }
}

