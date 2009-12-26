import javax.swing.JApplet;

/**
 * This applet contains a SimpleMouseTrackPanel that displays informaion about
 * mouse events on the applet.  
 */
public class SimpleTrackMouseApplet extends JApplet {

   public void init() {
      SimpleTrackMousePanel content = new SimpleTrackMousePanel();
      setContentPane(content);
   }

}
