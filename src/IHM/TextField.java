package IHM;

import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField {

    private Font defaultFont = new Font("Comic Sans MS", Font.BOLD, 12);
    private Dimension defaultDim;
    public TextField(int x, int y, Color backGround, Color foreGround)
    {
        defaultDim = new Dimension(x, y);
        this.setBackground(backGround);
        this.setForeground(foreGround);
        this.setFont(defaultFont);
        this.setPreferredSize(defaultDim);
        this.setBorder(null);

    }
}
