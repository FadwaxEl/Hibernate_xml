package ma.fstm.contact.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import ma.fstm.contact.controller.ContactCtr;
import ma.fstm.contact.model.bo.Contact;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Set;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Contactview extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private DefaultTableModel model;
	ContactCtr controller = new ContactCtr();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contactview frame = new Contactview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Contactview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(107, 88, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 130, 131, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(107, 171, 131, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ami", "Profetionnel", "Famille"}));
		comboBox.setBounds(107, 208, 131, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(37, 91, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setBounds(37, 133, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tel");
		lblNewLabel_2.setBounds(37, 174, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type");
		lblNewLabel_3.setBounds(37, 212, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long id=controller.Ajouter_cont(textField.getText(), textField_1.getText(), textField_2.getText(), comboBox.getSelectedItem().toString());
				model.addRow(new Object[] {
						
						id,
						textField.getText(),
						textField_1.getText(),
						textField_2.getText(),
						
						comboBox.getSelectedItem().toString()
						
				});
				System.out.println("l'id est "+id);
			}
		});
		btnNewButton.setBounds(87, 257, 89, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(264, 11, 485, 369);
		contentPane.add(panel);
		//panel.setLayout(null);
		
		
		
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Liste des contacts");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_4.setBounds(42, 11, 186, 29);
		panel.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(478, 236, -466, -176);
		panel.add(scrollPane);
		
         table = new JTable();
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				"id","Nom", "Prenom", "Tel","Type"
				}
			) {
				Class[] columnTypes = new Class[] {
					Long.class , String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					true, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		    table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setWidth(0);
			table.getColumnModel().getColumn(0).setWidth(0);
			table.getColumnModel().getColumn(0).setWidth(0);
			scrollPane.setViewportView(table);
			ContactCtr myCont = new ContactCtr();
			Collection<Contact> contacts= myCont.Afficher();
			addContactstoModel(table, contacts);
			
			JButton btnNewButton_1 = new JButton("Delete");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRow=table.getSelectedRow();
					if(selectedRow>=0) {
						Long id=(Long) table.getValueAt(selectedRow, 0);
						//System.out.println(id);
						//while(model.getRowCount()>0)	model.removeRow(0);
						myCont.Delete(id);
						model.removeRow(table.getSelectedRow());
						
						//new Controller().Delete(id);
						//ctrl.deleteContact(id);
						/*Collection<Contact> contacts= myCont.Afficher();
						addContactstoModel(table, contacts);*/
						
					}
					else JOptionPane.showMessageDialog( contentPane, "please select a row");
					}
				
			});

			btnNewButton_1.setBounds(332, 427, 89, 23);
			contentPane.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Update");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					int selectedRow=table.getSelectedRow();
					if(selectedRow>=0) {
						Long id=(Long) table.getValueAt(selectedRow, 0);
						Ajouter A = new Ajouter(id,(String) table.getValueAt(selectedRow, 1), (String)  table.getValueAt(selectedRow, 2), (String)  table.getValueAt(selectedRow, 3), (String)  table.getValueAt(selectedRow, 4),table,selectedRow);
						A.setVisible(true);
						//table.setValueAt("XXXXXX", 1, 1);
						/*Long id=(Long) table.getValueAt(selectedRow, 0);
						//System.out.println(id);
						//while(model.getRowCount()>0)	model.removeRow(0);
						textField.setText((String) table.getValueAt(selectedRow, 1));
						textField_1.setText((String)  table.getValueAt(selectedRow, 2));
						textField_2.setText((String)  table.getValueAt(selectedRow, 3));
				        comboBox.setSelectedItem((String)  table.getValueAt(selectedRow, 4));
				       // myCont.Modifier(null)
						//model.removeRow(table.getSelectedRow());
						
						//new Controller().Delete(id);
						//ctrl.deleteContact(id);
						/*Collection<Contact> contacts= myCont.Afficher();
						addContactstoModel(table, contacts);*/
						
					}
					else JOptionPane.showMessageDialog( contentPane, "please select a row");
					}
				
			});
			btnNewButton_2.setBounds(602, 427, 89, 23);
			contentPane.add(btnNewButton_2);
			
	}
	public void addContactstoModel(JTable table,Collection<Contact> contacts) {
		model=(DefaultTableModel)table.getModel();
		for(Contact contact:contacts) {
			model.addRow(new Object[] {
					
					contact.getId(),
					contact.getNom(),
					contact.getPrenom(),
					contact.getTel(),
					contact.getType().getTitre()
					
			});
		}
	}
}
