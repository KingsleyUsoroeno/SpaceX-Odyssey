package main.java.spacex;

public class Station {
    final String name;
    final StationType stationType;
    final OrbitType orbit;

    Station(String name, StationType stationType, OrbitType orbit) {
        this.name = name;
        this.stationType = stationType;
        this.orbit = orbit;
    }
}
