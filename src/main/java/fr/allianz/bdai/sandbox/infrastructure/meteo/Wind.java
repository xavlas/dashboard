package fr.allianz.bdai.sandbox.infrastructure.meteo;


public class Wind {
    private float speed;
    private float deg;


    // Getter Methods

    public float getSpeed() {
        return speed;
    }

    public float getDeg() {
        return deg;
    }

    // Setter Methods

    public void setSpeed( float speed ) {
        this.speed = speed;
    }

    public void setDeg( float deg ) {
        this.deg = deg;
    }
}