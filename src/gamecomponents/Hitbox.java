package gamecomponents;

import java.awt.Rectangle;
import java.awt.Point;

public class Hitbox {
    
    private Rectangle rectContainer;

    public Hitbox(int x, int y, int width, int height) {
        this.rectContainer = new Rectangle(x, y, width, height);
    }

    public void moveRelative(float x, float y) {
        this.rectContainer.x += (int)x; 
        this.rectContainer.y += (int)y; 
    }

    public void moveTo(float x, float y){
        this.rectContainer.x = (int)x; 
        this.rectContainer.y = (int)y; 
    }

    public Point getMidPoint(){
        int midX = (int) (this.rectContainer.getMaxX()) / 2; 

        int midY = (int) (this.rectContainer.getMaxY()) / 2;

        return new Point(midX, midY);
    }

    public void setX(float x){
        this.rectContainer.x = (int)x;
    }

    public void setY(float x){
        this.rectContainer.x = (int)x;
    }

    public float getX(){
        return this.rectContainer.x;
    }

    public float getY(){
        return this.rectContainer.y;
    }

    public float getWidth(){
        return (float)this.rectContainer.getWidth();
    }

    public float getHeight(){
        return (float)this.rectContainer.getHeight();
    }


    public Rectangle getRectContainer() {
        return rectContainer;
    }

    public void setRectContainer(Rectangle rectContainer) {
        this.rectContainer = rectContainer;
    }

    
}
