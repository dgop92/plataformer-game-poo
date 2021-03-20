package plataformer.entities.alive;

public abstract class Stats {
    
    private float life;
    private float vx;
    private float vy;

    public Stats(float life, float vx, float vy) {
        this.life = life;
        this.vx = vx;
        this.vy = vy;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public float getLife() {
        return life;
    }

    public void reduceLifeBy(float value){
        this.life -= value;
    }

    public float getVx() {
        return vx;
    }

    public void setVx(float vx) {
        this.vx = vx;
    }

    public float getVy() {
        return vy;
    }

    public void setVy(float vy) {
        this.vy = vy;
    }
}
