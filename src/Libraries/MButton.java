package Libraries;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static GameMechanic.GameMainVariables.FRAME_SIZE;
import static GameMechanic.GameMainVariables.IMAGE_BUTTON_START;

public class MButton extends JComponent implements MouseListener {
    public Dimension size = new Dimension(1000, 1000);

    public Dimension position = new Dimension();

    public Container container;

    private boolean mouseEntered;

    public MButton(Container container) {
        super();

        this.container = container;

        enableInputMethods(true);
        addMouseListener(this);

        setSize(size.width, size.height);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(IMAGE_BUTTON_START, FRAME_SIZE.width/2-IMAGE_BUTTON_START.getWidth(null)/2, FRAME_SIZE.height/4*3, null);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(getWidth(), getHeight());
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseEntered = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseEntered = false;
    }
}
