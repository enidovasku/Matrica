package matrix;

import matrix.math.Matrix;
import matrix.math.Solver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChooserLayout extends JPanel implements ActionListener {

    ChooseListener chooseListener;
    JButton matrica2;
    JButton matrica3;

    public ChooserLayout() {
        setBorder(BorderFactory.createEtchedBorder());
        Dimension dim = getPreferredSize();
        dim.width = 300;
        setSize(dim);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setVisible(true);

        matrica2 = new JButton("Matrica 2x2");
        matrica3 = new JButton("Matrica 3x3");

        matrica2.addActionListener(this);
        matrica3.addActionListener(this);

        add(new JLabel("Zgjidh:"));
        add(matrica2);
        add(matrica3);


    }

    public void setChooseListener(ChooseListener chooseListener) {
        this.chooseListener = chooseListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton klikuar = (JButton) e.getSource();

        if (klikuar == matrica2) {
            if (chooseListener != null) {
                chooseListener.chooseOption(0);
                //TODO: fix this
//                Matrix matrix = new Matrix(1, 1, 2, 1, -1, 0);
                Matrix matrix = null;
                Solver solver = new Solver();
                solver.generateNextMatrice(matrix, 1);

            }
        }
        if (klikuar == matrica3) {
            if (chooseListener != null) {
                chooseListener.chooseOption(1);
            }
        }

    }
}
