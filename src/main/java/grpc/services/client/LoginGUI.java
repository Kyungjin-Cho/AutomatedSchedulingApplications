package grpc.services.client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import grpc.services.service1.ScheduleServiceGrpc;

public class LoginGUI{

	private JFrame frame;
	private JTextField staffNameField;
	private JTextField staffPositionField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// create a frame
		frame = new JFrame();
		// set frame size
		frame.setBounds(100, 100, 1044, 550);
		// set close function
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// position components absolutely
		frame.getContentPane().setLayout(null);

		// create a panel
		JPanel panel = new JPanel();
		// set panel size
		panel.setBounds(0, 0, 1026, 550);
		// set panel background
		panel.setBackground(new Color(247, 237, 226));
		// position components absolutely
		panel.setLayout(null);
		// add panel to frame
		frame.getContentPane().add(panel);
		
		// create a label "loginNotice" for showing login guideline
	    JLabel loginNotice = new JLabel("Please enter staff name and position");
	    // set label font style
	    loginNotice.setFont(new Font("Segoe print", Font.BOLD, 20));
	    // set size and location of label
	    loginNotice.setBounds(34, 23, 400, 46);
	    // set label font color
	    loginNotice.setForeground(new Color(246, 189, 96));
	    // add label to panel
	    panel.add(loginNotice);

	    // create a label "userID" for indicating ID text field
	    JLabel staffName = new JLabel("ID   : ");
	    // set label font style
	    staffName.setFont(new Font("Segoe print", Font.BOLD, 40));
	    // set size and location of label
	    staffName.setBounds(162, 150, 213, 46);
	    // set label font color
	    staffName.setForeground(new Color(174, 127, 108));
	    // add label to panel
	    panel.add(staffName);

	    // create a text field "userIDField" receiving ID input
	    staffNameField = new JTextField();
	    // set size and location of text field
	    staffNameField.setBounds(350, 150, 300, 46);
	    // set text field font style
	    staffNameField.setFont(new Font("Segoe print", Font.BOLD, 20));
	    // add text field to panel
	    panel.add(staffNameField);

	    // create a label "userPin" for indicating PIN text field
	    JLabel staffPosition = new JLabel("PIN : ");
	    // set label font style
	    staffPosition.setFont(new Font("Segoe print", Font.BOLD, 40));
	    // set size and location of label
	    staffPosition.setBounds(162, 300, 213, 46);
	    // set label font color
	    staffPosition.setForeground(new Color(174, 127, 108));
	    // add label to panel
	    panel.add(staffPosition);

	    // create a text field "userPinField" receiving PIN input
	    staffPositionField = new JTextField();
	    // set size and location of text field
	    staffPositionField.setBounds(350, 300, 300, 46);
	    // set text field font style
	    staffPositionField.setFont(new Font("Segoe print", Font.BOLD, 20));
	    // add text field to panel
	    panel.add(staffPositionField);

	    // create a button "enterButton" allowing users to try login
	    JButton enterButton = new JButton("Enter");
	    // set button font style
	    enterButton.setFont(new Font("Segoe print", Font.BOLD, 20));
	    // set size and location of button
	    enterButton.setBounds(800, 120, 150, 100);
	    // set button background color
	    enterButton.setBackground(new Color(183, 215, 216));
	    // add button to panel
	    panel.add(enterButton);

	    // add action(function) to enterButton button
	    enterButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        // set correct ID and correct PIN
	        String correctID = "//";
	        String correctPin = "//";
	        // store text field input as userID and userPin
	        String userID = staffNameField.getText();
	        String userPin = staffPositionField.getText();
	        // if input is correct, show AtmMenu frame
	        if (userID.equals(correctID) && userPin.equals(correctPin)) {
	          // show user login success message
	          JOptionPane.showMessageDialog(null, "You have successfully logged in!", "Successful Login",
	              JOptionPane.PLAIN_MESSAGE);
	          // close the current frame
	          frame.setVisible(false);
	        } else {
	          // if input is incorrect, show user login failure message
	          JOptionPane.showMessageDialog(null, "Invalid User ID or PIN.\nPlease enter the ID and PIN again",
	              "Login Failure", JOptionPane.ERROR_MESSAGE);
	        }
	      }
	    });

	    // create a button "clearButton" clearing text field input
	    JButton clearButton = new JButton("Clear");
	    // set button font style
	    clearButton.setFont(new Font("Segoe print", Font.BOLD, 20));
	    // set size and location of button
	    clearButton.setBounds(800, 270, 150, 100);
	    // set button background color
	    clearButton.setBackground(new Color(254, 192, 207));
	    // add button to panel
	    panel.add(clearButton);
	    // add action(function) to clearButton button
	    clearButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        // clear both text fields
	    	staffNameField.setText("");
	    	staffPositionField.setText("");
	      }
	    });

	    // Align buttons vertically
	    enterButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
	    clearButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

	}
}