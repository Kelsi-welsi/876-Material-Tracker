package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.LoginAuthenticator;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class qsGui extends JFrame implements ActionListener {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/quantity_surveying";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "password";
    private static final String[] SEARCH_OPTIONS = { "Project Name", "Client Name", "Date" };
    private static final String[] TABLE_COLUMNS = { "Project Name", "Client Name", "Date", "Materials Quantity", "Labor Cost" };
    private JTextField enter;

    private JLabel searchLabel, resultLabel;
    private JTextField searchField;
    private JComboBox<String> searchOptions;
    private JButton searchButton, resetButton;
    private JTable resultTable;
    private JTextArea messages;
    private LoginAuthenticator ui;
    public JButton send;
    private supplier sup;

    public qsGui(LoginAuthenticator ui, supplier realsup) {
        this.ui  =ui;
        this.sup =  sup;
        setTitle("Quantity Surveyor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel searchPanel = new JPanel();
        searchLabel = new JLabel("Search by:");
        searchPanel.add(searchLabel);
        searchOptions = new JComboBox<>(SEARCH_OPTIONS);
        searchPanel.add(searchOptions);
        searchField = new JTextField(20);
        searchPanel.add(searchField);
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        searchPanel.add(searchButton);
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        searchPanel.add(resetButton);
        add(searchPanel, BorderLayout.NORTH);

        messages = new JTextArea();
        messages.setBounds(35, 160, 700, 180);
        messages.setEditable(false);

        enter = new JTextField();
        enter.setBounds(230, 420, 200, 30);
        add(enter);

          send = new JButton("Send");
          send.setBounds(450, 420, 70, 30);
          add(send);
          send.addActionListener(new addlistener());


        add(messages);
        resultLabel = new JLabel("Search results:");
        add(resultLabel, BorderLayout.CENTER);

        resultTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(resultTable);
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String searchOption = (String) searchOptions.getSelectedItem();
            String searchText = searchField.getText();
            String query = "SELECT project_name, client_name, date, materials_quantity, labor_cost " +
                    "FROM projects WHERE " + searchOption.toLowerCase().replace(" ", "_") + " LIKE '%" + searchText + "%';";
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                resultTable.setModel(buildTableModel(rs));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == resetButton) {
            resultTable.setModel(new DefaultTableModel());
            searchField.setText("");
        }
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }
        Object[][] data = new Object[100][columnCount];
        int rowCount = 0;
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            data[rowCount++] = row;
        }
        return new DefaultTableModel(data, columnNames);
    }

    public static void main(String[] args) {
    }

    public void set()
    {
        messages.setText(ui.mess);
    }
    public class addlistener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String mess =  "Quantity Surveyor: "+ enter.getText();
            String text = ui.mess;
            ui.mess =  text + "\n"+ mess;
            messages.setText(ui.mess);
            ui.realsup.chatui.set(); 
        }
    }
}
