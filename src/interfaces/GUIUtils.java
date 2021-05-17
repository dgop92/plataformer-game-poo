
package interfaces;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;


public class GUIUtils {
    public static Rectangle getBounds(int width, int height) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - width) / 2);
        int y = (int) ((dimension.getHeight() - height) / 2);
        return new Rectangle(x, y, width, height);
    }
}
