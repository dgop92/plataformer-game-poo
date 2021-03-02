package gamecomponents;

public class Hitbox {
    
    public float w;
    public float h;

    public float l;
    public float r;
    public float t;
    public float b;
    
    public float vx;
    public float vy;

    public Hitbox(int l, int t, int w, int h) {
        this.l = l; 
        this.r = l + w;
        this.t = t; 
        this.b = t + h;

        this.w = w;
        this.h = h;
        this.vx = this.vy = 0;
    }

    public void moveRelative(float vx, float vy) {
        this.l += vx; 
        this.t += vy;
        this.r = this.l + this.w;
        this.b = this.t + this.h;
    }

    public void moveTo(float x, float y){
        this.l = x; 
        this.t = y;
        this.r = this.l + this.w;
        this.b = this.t + this.h;
    }

    public void setBottom(float b) {
        this.b = b;
        this.t = b - this.h;
    }

    public void setLeft(float l) {
        this.l = l;
        this.r = l + this.w;
    }

    public void setRight(float r) {
        this.r = r;
        this.l = r - this.w;
    }

    public void setTop(float t) {
        this.t = t;
        this.b = t + this.h;
    }
    
}
