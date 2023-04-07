package View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class chat extends JFrame{
    private JTextField enter;
    private JTextArea textbox;
    private LoginAuthenticator ui;
    public JButton send;
    public chat(LoginAuthenticator ui)
    {
          // add the panel to the frame
          setSize(500, 500);
          this.ui = ui;
          this.setLayout(null);
          JPanel main = new JPanel();
          main.setLayout(null);
          main.setBounds(0, 0, 500, 500);

          enter = new JTextField();
          enter.setBounds(50, 200, 200, 30);
          main.add(enter);

          send = new JButton("Send");
          send.setBounds(270, 200, 70, 30);
          main.add(send);
          send.addActionListener(new addlistener());

          textbox = new JTextArea("");
          textbox.setBounds(35, 10, 300, 180);
          textbox.setEditable(false);
      
    
          main.add(textbox);

          this.add(main);
        
          // set the frame properties
          this.setTitle("Supplier GUI");
          this.setSize(400, 300);
          this.setLocationRelativeTo(null);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setVisible(true);
    }


    public void set()
    {
        textbox.setText(ui.mess);
    }

    public class addlistener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String mes =  "Supplier: "+ enter.getText();
            //String text = textbox.getText();
            String text = ui.mess;
            ui.mess =  text + "\n"+ mes;
            textbox.setText(ui.mess);
            ui.sup.set();
        }
    }
  
    
}
