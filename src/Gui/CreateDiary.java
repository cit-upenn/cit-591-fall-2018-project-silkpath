
package Gui;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Code.User;
import Gui.MainGui;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.JPanel;

public class CreateDiary {

	/**
	 * Instance Variables
	 */
	private JFrame CreateMatch;
	private JTextField txtMatchName;
	private JTextField txtAddress;
	private JTextField txtDate;
	String username;
	String pwd;
	User currentUser = new User(username , pwd);
	private JTextPane txtNotes;
	private JLabel lblNote;
	private JButton btnSave;
	private JTextField tfAge;
	private JLabel lblPhoto;
	private String photo;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	


	/**
	 * Create the application.
	 */
	public CreateDiary(User currentUser) {
		this.currentUser = currentUser;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		CreateMatch = new JFrame();
		CreateMatch.getContentPane().setBackground(new Color(100, 149, 237));
		CreateMatch.setBounds(100, 100, 664, 592);
		CreateMatch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblMatchName = new JLabel("*Match Name:");
		lblMatchName.setBounds(36, 33, 100, 18);
		lblMatchName.setForeground(new Color(255, 255, 255));
		lblMatchName.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		
		txtMatchName = new JTextField();
		txtMatchName.setBounds(154, 33, 146, 21);
		txtMatchName.setColumns(10);
		txtMatchName.setFont(new Font("AR JULIAN", Font.PLAIN, 12));
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		lblAge.setBounds(43, 73, 78, 18);
		CreateMatch.getContentPane().add(lblAge);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(154, 73, 240, 21);
		tfAge.setFont(new Font("AR JULIAN", Font.PLAIN, 12));
		CreateMatch.getContentPane().add(tfAge);
		
		JLabel lblBlurb = new JLabel("Blurb:");
		lblBlurb.setForeground(Color.WHITE);
		lblBlurb.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		lblBlurb.setBounds(43, 112, 85, 18);
		CreateMatch.getContentPane().add(lblBlurb);
		
		JTextArea tfBlurb = new JTextArea();
		tfBlurb.setBounds(154, 110, 240, 86);
		tfBlurb.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		CreateMatch.getContentPane().add(tfBlurb);
		
		JLabel lblNewLabel = new JLabel("*Place:");
		lblNewLabel.setBounds(326, 217, 57, 18);
		lblNewLabel.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		txtAddress = new JTextField();
		txtAddress.setBounds(393, 217, 173, 21);
		txtAddress.setColumns(10);
		txtAddress.setFont(new Font("AR JULIAN", Font.PLAIN, 12));
		
		lblNote = new JLabel("Notes:");
		lblNote.setBounds(49, 268, 52, 18);
		lblNote.setForeground(new Color(255, 255, 255));
		lblNote.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		
		btnSave = new JButton("Save");
		btnSave.setBounds(501, 477, 70, 27);
		btnSave.setBackground(new Color(112, 128, 144));
		btnSave.setFont(new Font("AR JULIAN", Font.PLAIN, 16));
		btnSave.setForeground(new Color(255, 255, 255));
		
		
		txtDate = new JTextField();
		txtDate.setBounds(154, 217, 162, 21);
		txtDate.setColumns(10);
		txtDate.setFont(new Font("AR JULIAN", Font.PLAIN, 12));
		
		JLabel lblDate = new JLabel("*Date:");
		lblDate.setBounds(45, 217, 76, 18);
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 261, 412, 206);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton btnPhoto = new JButton("+ Photo");
		btnPhoto.setBounds(310, 30, 85, 27);
		
		btnPhoto.setForeground(new Color(105, 105, 105));
		btnPhoto.setFont(new Font("AR JULIAN", Font.PLAIN, 12));
		btnPhoto.setBackground(new Color(255, 218, 185));
		
		//add a photo from local file
		btnPhoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				JFileChooser chooser = new JFileChooser(); 
				chooser.setDialogTitle("Please choose a photo");
				chooser.setMultiSelectionEnabled(true); 
				FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "jpg");
				chooser.setFileFilter(filter);
				chooser.showOpenDialog(null); 
				
				File file = chooser.getSelectedFile();
				String dest_path = System.getProperty("user.dir")+"/"+file.getName(); 
				File new_file = new File(dest_path);

				
				try {
					Files.copy(file.toPath(), new_file.toPath()); //copy the photo path to source file

				
					CreateMatch.getContentPane().add(lblPhoto); // add the photo in the frame
					
					JPanel pnPhoto = new JPanel();
					pnPhoto.setBounds(419, 33, 146, 165);
					CreateMatch.getContentPane().add(pnPhoto);
					ImageIcon image = new ImageIcon(new_file.getAbsolutePath());
					JLabel label = new JLabel("", image, JLabel.CENTER);
					pnPhoto.add( label, BorderLayout.CENTER );
					pnPhoto.invalidate();
					pnPhoto.validate();
					pnPhoto.repaint();										
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//save the information from textField
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String newName = txtMatchName.getText();
						String date = txtDate.getText();
						String place = txtAddress.getText();
						String Notes = txtNotes.getText();
						String age = tfAge.getText();
						String blurb = tfBlurb.getText();
						photo = new_file.getAbsolutePath();
						
						//check if textFiled is empty
						if(newName.isEmpty()) {
							JOptionPane.showMessageDialog(CreateMatch, "Please enter match name.");
						}
						
						if(date.isEmpty()) {
							JOptionPane.showMessageDialog(CreateMatch, "Please enter the date.");
						}
						
						if(place.isEmpty()) {
							JOptionPane.showMessageDialog(CreateMatch, "Please enter the place.");
						}
						
						//save default information if empty
						if(age.isEmpty()) {
							age ="Unknown";
						}
						
						if(Notes.isEmpty()) {
							Notes ="***";
						}
						if(blurb.isEmpty()) {
							blurb = "No blurb for this match.";
						}
						

						//write the data into a file
						if(!newName.isEmpty()|| !date.isEmpty() || !place.isEmpty()) {
						String fileName = currentUser.getUsername() + ".txt";
						try {
							FileWriter fw = new FileWriter(fileName, true);
						    BufferedWriter bw = new BufferedWriter(fw);
						    PrintWriter out = new PrintWriter(bw);
						    
						    //seperate with delimeter "==="
						    out.println(newName + "===" +age + "==="+ photo +"===" +blurb + "===" + date + "==="+ place + "==="+ Notes );
							out.close();
							
							
							JOptionPane.showMessageDialog(CreateMatch, "Diary saved!");
							
							CreateMatch.dispose();
							
							//show up the home page after creating a diary
							MainGui window = new MainGui(currentUser);
							int w = window.getFrame().getSize().width;
						    int h = window.getFrame().getSize().height;
						    int x = (dim.width-w)/2;
						    int y = (dim.height-h)/2;
							window.getFrame().setVisible(true);
							window.getFrame().setLocation(x, y);												
						} catch (IOException e) {
							System.out.println("Diary cannot be created, please try again");
							
						}
						
					}}
				});
				
					
			}
		});
		
		txtNotes = new JTextPane();
		txtNotes.setFont(new Font("AR JULIAN", Font.PLAIN, 15));
		scrollPane.setViewportView(txtNotes);
		CreateMatch.getContentPane().setLayout(null);
		CreateMatch.getContentPane().add(lblMatchName);
		CreateMatch.getContentPane().add(lblDate);
		CreateMatch.getContentPane().add(lblNewLabel);
		CreateMatch.getContentPane().add(lblNote);
		CreateMatch.getContentPane().add(txtAddress);
		CreateMatch.getContentPane().add(txtDate);
		CreateMatch.getContentPane().add(txtMatchName);
		CreateMatch.getContentPane().add(btnPhoto);
		CreateMatch.getContentPane().add(scrollPane);
		CreateMatch.getContentPane().add(btnSave);
		
		lblPhoto = new JLabel("   ");
		lblPhoto.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		lblPhoto.setBackground(new Color(211, 211, 211));
		lblPhoto.setBounds(419, 33, 144, 165);
		CreateMatch.getContentPane().add(lblPhoto);
		

	}
	
	/**
	 * Getters and setters
	 */
	public JTextField getTxtMatchName() {
		return txtMatchName;
	}

	public void setTxtMatchName(JTextField txtMatchName) {
		this.txtMatchName = txtMatchName;
	}

	public JTextField getTxtAddress() {
		return txtAddress;
	}

	public void setTxtAddress(JTextField txtAddress) {
		this.txtAddress = txtAddress;
	}

	public JTextField getTxtDate() {
		return txtDate;
	}

	public void setTxtDate(JTextField txtDate) {
		this.txtDate = txtDate;
	}

	public JTextPane getTxtNotes() {
		return txtNotes;
	}

	public void setTxtNotes(JTextPane txtNotes) {
		this.txtNotes = txtNotes;
	}

	public JTextField getTfAge() {
		return tfAge;
	}

	public void setTfAge(JTextField tfAge) {
		this.tfAge = tfAge;
	}

	public JButton getBtnSave() {
		return btnSave;
	}
	
	public JFrame getCreateMatch() {
		return CreateMatch;
	}
	
	

}
