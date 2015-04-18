import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SpellCheckGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField TextFile_textField;
	private JTextField Dictionary_textField;
	private static JTextPane Misspelled_textPane;
 	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpellCheckGUI frame = new SpellCheckGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SpellCheckGUI() {
		setTitle("Spell Check");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextFile_textField = new JTextField();
		TextFile_textField.setText("MyDocument.txt");
		TextFile_textField.setBounds(6, 30, 312, 28);
		contentPane.add(TextFile_textField);
		TextFile_textField.setColumns(10);
		
		Misspelled_textPane = new JTextPane();
		Misspelled_textPane.setEditable(false);
		Misspelled_textPane.setBounds(6, 98, 290, 174);
		contentPane.add(Misspelled_textPane);
		
		JButton ImportText_JButton = new JButton("Import Text");
		ImportText_JButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Import Button Pressed
				FileStorage.importText(TextFile_textField.getText());
					SpellCheckGUI.Misspelled_textPane.setText(HashTable.GetFlagged());
			}
		});
		ImportText_JButton.setBounds(317, 31, 127, 29);
		contentPane.add(ImportText_JButton);
		
		JLabel MisspelledWords_lbl = new JLabel("Misspelled Words");
		MisspelledWords_lbl.setBounds(6, 70, 149, 16);
		contentPane.add(MisspelledWords_lbl);
		
		JButton AddToDictionary_btn = new JButton("Add to Dictionary");
		AddToDictionary_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Add to Dictionary Button Pressed
				HashTable.Insert(Dictionary_textField.getText());
			}
		});
		AddToDictionary_btn.setBounds(308, 206, 136, 29);
		contentPane.add(AddToDictionary_btn);
		
		Dictionary_textField = new JTextField();
		Dictionary_textField.setBounds(310, 172, 134, 28);
		contentPane.add(Dictionary_textField);
		Dictionary_textField.setColumns(10);
		
		JButton QuitProgram_btn = new JButton("Quit Program");
		QuitProgram_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Quit Program Button Pressed
				System.exit(0);
			}
		});
		QuitProgram_btn.setBounds(308, 243, 136, 29);
		contentPane.add(QuitProgram_btn);
	}
}
