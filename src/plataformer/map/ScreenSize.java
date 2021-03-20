package plataformer.map;

public class ScreenSize {
    
    private int width;
    private int height;
    private int tileSize;

    public ScreenSize(int width, int height, int tileSize) {
        this.width = width;
        this.height = height;
        this.tileSize = tileSize;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTileSize() {
        return tileSize;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public int getNRows() {
        return this.height / tileSize;
    }

    public int getNColumns() {
        return this.width / tileSize;
    }

}
