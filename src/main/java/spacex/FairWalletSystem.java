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

        final int tripBetweenOrbitsOnF1 = 250; // Assume this is in BTC
        final int royaltyCostForManMadeStations = 200;
        final int journeyWithOrbitsOnf1 = 50;


        switch (jetType) {
            case FALCON_1 -> {
                if (currentStation.stationType != destinationStation.stationType) {
                    deductFromWallet(royaltyCostForManMadeStations);
                } else if (currentStation.orbit != destinationStation.orbit) {
                    // travelling outside orbits
                    deductFromWallet(tripBetweenOrbitsOnF1);
                } else {
                    deductFromWallet(journeyWithOrbitsOnf1);
                }
            }
            case FALCON_9 -> {
                if (currentStation.stationType != destinationStation.stationType) {
                    deductFromWallet(royaltyCostForManMadeStations);
                } else if (currentStation.orbit != destinationStation.orbit) {
                    deductFromWallet(tripBetweenOrbitsOnF1 * 2);
                } else {
                    deductFromWallet(journeyWithOrbitsOnf1 * 2);
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + jetType);
        }
    }
}

