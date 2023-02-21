import javax.swing.*;
import java.awt.*;
class gui{
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Delete Material");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar mm = new JMenuBar();
        JMenu m1 = new JMenu("Manage Material");
        JMenu m2 = new JMenu("Help");
        mm.add(m1);
        mm.add(m2);
        JMenuItem m11 = new JMenuItem("Add Material");
        JMenuItem m22 = new JMenuItem("Edit Material");
        JMenuItem m33 = new JMenuItem("Delete Material");

        m1.add(m11);
        m1.add(m22);
        m1.add(m33);
        

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Material to be deleted:");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Delete");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mm);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        //send.addActionListener();
        frame.setVisible(true);
    }

    //public void actionPerformed(ActionEvent e){
   // textArea.setText(textArea.getText().concat("Material Deleted!"));
   // }

}
