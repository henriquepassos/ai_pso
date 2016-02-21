package br.com.henriquespassos.ai_pso.service;

public class Particle {

    private Location location;
    private Velocity velocity;

    public Particle() {
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }
}