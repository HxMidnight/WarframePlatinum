import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RoundedButton extends JButton {

    public RoundedButton(String text, Color background, Color foreground) {
        super(text);

        setPreferredSize(new Dimension(200, 50));
        setFont(new Font("Arial", Font.PLAIN, 16));
        setBackground(background);
        setForeground(foreground);

        // Create a rounded border with corner radius
        Border roundedBorder = new LineBorder(background, 2, true);
        setBorder(roundedBorder);
    }
}
