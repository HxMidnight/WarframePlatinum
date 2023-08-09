import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class RoundedButton extends JButton {
    private boolean isHovered = false;

    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (isHovered) {
            // Create a gradient background with lighter and darker shades of blue
            GradientPaint gradient = new GradientPaint(0, 0, new Color(126, 149, 180).brighter(), 0, getHeight(),
                    new Color(126, 149, 180));
            g2.setPaint(gradient);
        } else {
            g2.setColor(new Color(126, 149, 180));
        }

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

        g2.setColor(getForeground());
        g2.setFont(getFont());
        FontMetrics fm = g2.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
        g2.drawString(getText(), x, y);
        g2.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rounded Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new RoundedButton("Click me!");
        button.setPreferredSize(new Dimension(120, 40));

        frame.getContentPane().add(button);
        frame.pack();
        frame.setVisible(true);
    }
}