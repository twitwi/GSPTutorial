
// this is a simple example: no real package definition... but don't imitate it
package simplecode;


import fr.prima.gsp.framework.ModuleParameter;
import fr.prima.gsp.framework.spi.*;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;


public class OverlayInfo extends AbstractModuleEnablable {

    // GSP Parameters just need you to put an annotation on a public field.

    @ModuleParameter public String overlayFormat = "Hello frame%d";
    @ModuleParameter public double rotationSpeed = 0.066;
    @ModuleParameter public double x = 150;
    @ModuleParameter public double y = 150;

    private int currentFrame = 0;

    // Any public method can be used as a GSP input.
    // The method name becomes the input name.

    public void input(BufferedImage im) {
        if (!isEnabled()) {
            // it is good to make such modules enablable
            return;
        }
        // let's write directly on the image without copy...
        Graphics2D g = im.createGraphics();
        g.setColor(Color.RED);
        g.translate(x, y);
        g.rotate(currentFrame * rotationSpeed * 3.14);
        g.scale(2., 2.);
        g.drawString(String.format(overlayFormat, currentFrame), -30f, 0f);
        // and send the result (same reference through our output).
        // by convention, we will have a (private) method for each output
        output(im);
        currentFrame++;
    }

    // By convention, we use a method for each output.
    // Using the "emitEvent" automatically takes the name of the current method and use it as the name of the output output.
    
    private void output(BufferedImage o) {
        emitEvent(o);
    }

    // Lifecycle related methods
    
    @Override protected void initModule() {
        // this method is optionnal, only used if initialization is required
        System.out.println("Hi, I'm initing myself");
                
    }
    @Override protected void stopModule() {
        // same here
        System.out.println("See you, I'm stopping myself");
    }


}
