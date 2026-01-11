import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


class BaseFrame extends JFrame{
    public BaseFrame(){
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("Elite Gym");
        this.getContentPane().setBackground(new Color(80,100,180));
        this.setLocationRelativeTo(null);
    }

}

class Buttons extends JButton{
    public Buttons(String text, ActionListener a){
        this.setText(text);
        addActionListener(a);
        setFocusable(false);
    }
}