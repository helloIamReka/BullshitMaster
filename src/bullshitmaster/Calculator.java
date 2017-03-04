
package bullshitmaster;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Calculator extends JDialog {
    private JPanel pnResult;
    private JTextArea taResult;
    List list=new List();
    int wordCount;
    String result;
    double counter;
        public Calculator (String text){
        Rectangle parent=getParent().getBounds();
        setBounds(parent.x+400, parent.y+200, 500, 300);
        countWords(text);
        calculate(text);
        
        pnResult=new JPanel();
        add(pnResult, BorderLayout.CENTER);
        taResult=new JTextArea(5, 20);
        taResult.setFont(new Font("Serif", Font.BOLD, 16));
        taResult.setLineWrap(true);
        taResult.setWrapStyleWord(true);
        pnResult.add(new JScrollPane(taResult));
        taResult.setText(result);

        setResizable(false);
        setVisible(false);
    }
        
    
    public int countWords(String text){
    wordCount = 0;
    boolean word = false;
    int endOfLine = text.length() - 1;
    for (int i = 0; i < text.length(); i++) {
        // if the char is a letter, word = true.
        if (Character.isLetter(text.charAt(i)) && i != endOfLine) {
            word = true;
            // if char isn't a letter and there have been letters before,
            // counter goes up.
        } else if (!Character.isLetter(text.charAt(i)) && word) {
            wordCount++;
            word = false;
            // last word of String; if it doesn't end with a non letter, it
            // wouldn't count without this.
        } else if (Character.isLetter(text.charAt(i)) && i == endOfLine) {
            wordCount++;
        }
    }
    return wordCount;
}
    
    public String calculate(String text){
        for (int i = 0; i < list.theWords.size(); i++) {
            String test=(String)list.theWords.get(i);
            if (text.contains(test)){
                counter+=5;
            }
        }
        if ((counter*100/wordCount)<=20){
            result="You are straightforward. Only "+((int)(counter*100/wordCount))+" % bullshit. You talk just like me. You will never be promoted.";}
        else if ((counter*100/wordCount) >20 &&(counter*100/wordCount) <=40){
            result="Way too high information content with only "+((int)(counter*100/wordCount))+" % bullshit, which is way too little to make a career.";}
        else if ((counter*100/wordCount)>40 &&(counter*100/wordCount) <=55){
            result="Some basic level of bullshit is detected, but you need more than "+((int)(counter*100/wordCount))+" % bullshitting for a promotion";}
        else if ((counter*100/wordCount)>55 &&(counter*100/wordCount) <=70){
            result="Nice! You must be a manager, or definitely on the way. Not everyone is capable of bullshitting "+((int)(counter*100/wordCount))+" % of the time!";}
        else if ((counter*100/wordCount)>70 &&(counter*100/wordCount) <=100){
            result="Congratulations! The information content of what you are saying is minimal, with "+((int)(counter*100/wordCount))+" % bullshit. This is CEO level!";}
        else if ((counter*100/wordCount) >100){
            result="Congratulations! The information content of what you are saying is minimal, with 100% bullshit. This is CEO level!";}
        return result;
        
    }
    

}
