package ma.fstm.contact.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import ma.fstm.contact.controller.ContactCtr;
import ma.fstm.contact.model.bo.Contact;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ajouter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	ContactCtr controller = new ContactCtr();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajouter frame = new Ajouter(eventMask, anchor, anchor, anchor, anchor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @param object4 
	 * @param object3 
	 * @param object2 
	 * @param object 
	 * @param id 
	 * @param selectedRow 
	 * @param table 
	 */
	public Ajouter(Long id, String object, String object2, String object3, String  object4, JTable table, int selectedRow) {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		System.out.println(object);
		textField = new JTextField((String) object);
		textField.setColumns(10);
		textField.setBounds(157, 58, 131, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField((String) object2 );
		textField_1.setColumns(10);
		textField_1.setBounds(157, 100, 131, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField((String)  object3);
		textField_2.setColumns(10);
		textField_2.setBounds(157, 141, 131, 20);
		contentPane.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ami", "Profetionnel", "Famille"}));
		comboBox.setBounds(157, 178, 131, 22);
		 comboBox.setSelectedItem((String)  object4 );
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(87, 61, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setBounds(87, 103, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tel");
		lblNewLabel_2.setBounds(87, 144, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type");
		lblNewLabel_3.setBounds(87, 182, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnModifier = new JButton("Appliquer");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Contact modif=	controller.Modifier(id,textField.getText(), textField_1.getText(), textField_2.getText(), comboBox.getSelectedItem().toString());
			table.setValueAt(id, selectedRow, 0);
			table.setValueAt(textField.getText(), selectedRow, 1);
			table.setValueAt(textField_1.getText(), selectedRow, 2);
			table.setValueAt(textField_2.getText(), selectedRow, 3);
			table.setValueAt( comboBox.getSelectedItem().toString(), selectedRow,4);
			
			}
		});
		btnModifier.setBounds(137, 227, 89, 23);
		contentPane.add(btnModifier);
		
		/*textField.setText((String) object);
		textField_1.setText((String) object2 );
		textField_2.setText((String)  object3);
        comboBox.setSelectedItem((String)  object4 );*/
		
		//setVisible(true);
	}

}
