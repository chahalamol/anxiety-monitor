package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GadFrame extends JFrame implements ActionListener {

    GadFrame() {
        this.setVisible(true);
        this.setTitle("Anxiety Monitor"); // sets the title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dimension.width / 6) - (this.getWidth() / 8);
        int y = (dimension.height) - (this.getHeight());
        setSize(x, y);
        this.setResizable(true); // prevents from resizing
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
