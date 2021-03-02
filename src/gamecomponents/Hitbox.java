package gamecomponents;

public class Hitbox {
    
    public float w;
    public float h;

    public float l;
    public float r;
    public float t;
    public float b;

    public float ol;
    public float or;
    public float ot;
    public float ob;
    
    public float vx;
    public float vy;

    public Hitbox(int l, int t, int w, int h) {
        this.l = this.ol = l; // left and old left
        this.r = this.or = l + w; // right and old right
        this.t = this.ot = t; // top and old top
        this.b = this.ob = t + h; // bottom and old bottom

        this.ol = l; // left and old left
        this.or = l + w; // right and old right
        this.ot = t; // top and old top
        this.ob = t + h; // bottom and old bottom

        this.w = w; // width
        this.h = h; // height
        this.vx = this.vy = 0; // velocity x and y
    }

    public void moveRelative(float vx, float vy) {

        updateOldPositions();

        this.l += vx; 
        this.t += vy;
        this.r = this.l + this.w;
        this.b = this.t + this.h;
    }

    public void moveTo(float x, float y){
        this.l = x; 
        this.t = y; 
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

    private void updateOldPositions(){
        this.ob = this.b; // update the old positions to the current positions
        this.ol = this.l;
        this.or = this.r;
        this.ot = this.t;
    }
    
}
