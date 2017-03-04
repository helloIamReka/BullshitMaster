
package bullshitmaster;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BSFrame extends JFrame {
    private JTextArea taInsert;
    private JButton btCount;
    private JPanel pn;
    private JLabel lbInstr;
    Calculator calc;
    String text;
    
    public BSFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bullshit Calculator");
        setSize(600, 400);
        setResizable(true);
        setLocationRelativeTo(this);
        pn=new JPanel();
        taInsert=new JTextArea(15, 30);
        taInsert.setLineWrap(true);
        taInsert.setWrapStyleWord(true);
        btCount=new JButton("Calculate Bullshit %!");
        lbInstr=new JLabel("Insert text");
        add(pn, BorderLayout.CENTER);
        pn.add(lbInstr);
        pn.add(new JScrollPane(taInsert));
        pn.add(btCount);
        taInsert.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) {
        btCount.setEnabled(taInsert.getText().length()!=0);
      }
    });
        btCount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text=taInsert.getText();
                calc=new Calculator(text);
                calc.setVisible(true);
            }
        });
        
        setVisible(true);
    }
    
    
    
}
