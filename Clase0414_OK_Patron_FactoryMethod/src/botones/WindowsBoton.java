package botones;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Windows button implementation. Los productos concretos proporcionan varias
 * implementaciones de la interfaz de producto.
 *
 * @author refactoring.guru
 */
public class WindowsBoton implements IBoton {

    //CAMPOS
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JButton button;

    /**
     * Representa un botón en estilo Windows.
     */
    @Override
    public void render() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hola mundo!");
        label.setOpaque(true);
        label.setBackground(new Color(235, 233, 126));
        label.setFont(new Font("Dialog", Font.BOLD, 44));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(panel);
        panel.add(label);
        onClick();
        panel.add(button);

        frame.setSize(320, 200);
        frame.setVisible(true);
        onClick();
    }

    /**
     * Vincula un evento clic de Sistema Operativo nativo.
     */
    @Override
    public void onClick() {
        button = new JButton("Exit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });
    }

}
