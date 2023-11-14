import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class SimpleFrameTest {
    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            var frame=new SimpleFrame();
            frame.setTitle("Hello World");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        });
    }

}
class SimpleFrame extends JFrame{

    public SimpleFrame()
    {
       add(new SimpleFrameComponent());
       pack();
    }
}
class SimpleFrameComponent extends JComponent{

    private static final int DEFAULT_WIDTH=400;
    private static final int DEFAULT_HEIGTH=400;
    public void paintComponent(Graphics g)
    {
//      var g2 =(Graphics2D)g;
//      double x=100,y=100,width=200,height=150;
//      var rect=new Rectangle2D.Double(x,y,width,height);
//      g2.draw(rect);
//
//      var circle=new Ellipse2D.Double();
//      double centerX=rect.getCenterX();
//      double centerY= rect.getCenterY();
//      double radius=150;
//      circle.setFrameFromCenter(centerX,centerY,centerX+radius,centerY+radius);
//      g2.draw(circle);

        var g2 =(Graphics2D)g;
        var message="Hello World!";
        var f=new Font("Serif",Font.BOLD,36);
        g2.setFont(f);

        FontRenderContext context=g2.getFontRenderContext();
        Rectangle2D bounds=f.getStringBounds(message,context);

        double x=(getWidth()-bounds.getWidth())/2;
        double y=(getHeight()-bounds.getHeight())/2;

        double accent=-bounds.getY();
        double baseY=y+accent;

        g2.drawString(message,(int)x,(int)baseY);
        g2.setPaint(Color.LIGHT_GRAY);

        g2.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY) );

        var rect=new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
        g2.draw(rect);
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGTH);
    }











}
