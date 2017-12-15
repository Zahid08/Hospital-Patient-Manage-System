import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class Registration extends JFrame implements ActionListener{
	JLabel[]   registrationlJLabel;        
	ButtonGroup bg;
	JRadioButton registrationJRadioButton,registrationJRadioButton1;       
	JButton[] registrationJButton; 
	JTextField[] registrationJTextField; 
	JPasswordField     registrationJPasswordField ;
	
	public Registration(){
		registrationlJLabel=new JLabel[15];
		registrationJTextField=new JTextField[10];
		registrationJButton=new JButton[10];
		
		registrationlJLabel[0]=new JLabel("Please Fill Up The Registration Form :");
		registrationlJLabel[1]=new JLabel("First Name : ");
		registrationlJLabel[2]=new JLabel("Last Name : ");
		registrationlJLabel[3]=new JLabel("Email : ");
		registrationlJLabel[4]=new JLabel("Username: ");
		registrationlJLabel[5]=new JLabel("Gender : ");
		registrationlJLabel[6]=new JLabel("Mobile Number : " );
		registrationlJLabel[7]=new JLabel("Password : ");
		registrationlJLabel[8]=new JLabel("Re-Enter Password:");
		
		registrationJTextField[0]=new JTextField();
		registrationJTextField[1]=new JTextField();
		registrationJTextField[2]=new JTextField();
		registrationJTextField[3]=new JTextField();
	        registrationJTextField[4]=new JTextField();
		registrationJTextField[5]=new JPasswordField();
		registrationJPasswordField=new JPasswordField();
		
		registrationJButton[0]=new JButton("Create");
		registrationJButton[1]=new JButton("Reset");
		registrationJButton[2]=new JButton("Exit");
		
		registrationJRadioButton=new JRadioButton();
		registrationJRadioButton1=new JRadioButton();
		registrationlJLabel[0].setBounds(200,20,300,30);
		this.add(registrationlJLabel[0]);
		registrationlJLabel[1].setBounds(50,80,70,30);
		this.add(registrationlJLabel[1]);
		registrationlJLabel[2].setBounds(50,120,70,30);
		this.add(registrationlJLabel[2]);
		registrationlJLabel[3].setBounds(75,160,70,30);
		this.add(registrationlJLabel[3]);
		registrationlJLabel[4].setBounds(50,200,70,30);
		this.add(registrationlJLabel[4]);
		registrationlJLabel[5].setBounds(70,240,70,30);
		this.add(registrationlJLabel[4]);
		registrationlJLabel[6].setBounds(30,280,110,30);
		this.add(registrationlJLabel[6]);
		registrationlJLabel[7].setBounds(50,320,70,30);
		this.add(registrationlJLabel[7]);
		registrationlJLabel[8].setBounds(15,360,130,30);
		this.add(registrationlJLabel[8]);
		
		
		registrationJTextField[0].setBounds(150,80,200,30);
		this.add(registrationJTextField[0]);
		registrationJTextField[1].setBounds(150,120,200,30);
		this.add(registrationJTextField[1]);
		registrationJTextField[2].setBounds(150,160,200,30);
		this.add(registrationJTextField[2]);
		registrationJTextField[3].setBounds(150,200,200,30);
		this.add(registrationJTextField[3]);
		
		registrationJRadioButton.setBounds(150,240,70,30);
		registrationJRadioButton.addActionListener(this);
		registrationJRadioButton.setText("Male");
		this.add(registrationJRadioButton);
		
		registrationJRadioButton1.setBounds(220,240,70,30);
		registrationJRadioButton1.setText("Female");
		registrationJRadioButton1.addActionListener(this);
		this.add(registrationJRadioButton1);
		
		registrationJTextField[4].setBounds(150,280,200,30);
		this.add(registrationJTextField[4]);
		registrationJTextField[5].setBounds(150,320,200,30);
		this.add(registrationJTextField[5]);
		registrationJPasswordField.setBounds(150,360,200,30);
		this.add(registrationJPasswordField);
		
		registrationJButton[0].setBounds(150,420,80,30);
		registrationJButton[0].addActionListener(this);
		this.add(registrationJButton[0]);
		registrationJButton[1].setBounds(240,420,80,30);
			registrationJButton[1].addActionListener(this);
		this.add(registrationJButton[1]);
		registrationJButton[2].setBounds(440,510,80,30);
	        registrationJButton[2].addActionListener(this);
		this.add(registrationJButton[2]);
		
		this.getContentPane().setBackground(Color.lightGray);
		this.setTitle("Registration");
		this.setLayout(null);
		this.setSize(550,600);
		this.setVisible(true);
		
		bg=new ButtonGroup();
		bg.add(registrationJRadioButton);
		bg.add(registrationJRadioButton1);
	}
	public void actionPerformed(ActionEvent e)
	{
		String gender = null;
		if(e.getSource() ==registrationJButton[0])
		{
			if(registrationJRadioButton.isSelected())
			{
				gender = "Male";
			}
			else if(registrationJRadioButton1.isSelected())
			{
				gender = "Female";
			}
			
			//JOptionPane.showMessageDialog(this,gender);
			
			String firstname = registrationJTextField[0].getText();
			String lastname= registrationJTextField[1].getText();
			String email= registrationJTextField[2].getText();
			String username= registrationJTextField[3].getText();
			int  phoneno = Integer.parseInt(registrationJTextField[4].getText());
			String password= registrationJTextField[5].getText();
			
			
			//for insert information
			
			try{
				System.out.println("actionPerformed successfully");
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectfinal","root","");
				
				Statement stmt = con.createStatement();
				//stmt.executeUpdate("INSERT INTO Reg where 
				stmt.executeUpdate("INSERT INTO Users(firstname, lastname, email, Username, Gender, Phone, Password) VALUES ('"+firstname+"','"+lastname+"', '"+email+"' , '"+username+"','"+gender+"','"+phoneno+"','"+password+"')");
				JOptionPane.showMessageDialog(this,"Successfully inserted !");
				new User();
				this.setVisible(false);
				con.close();
			}
			catch(Exception exp){ JOptionPane.showMessageDialog(this, "Some Error Occured");}
			
		
		}
		
		else if(e.getSource() == registrationJButton[1] )
		{	
			registrationJTextField[0].setText(null);
			registrationJTextField[1].setText(null);
			registrationJTextField[2].setText(null);
			registrationJTextField[3].setText(null);
			registrationJTextField[4].setText(null);
			registrationJTextField[5].setText(null);
			registrationJPasswordField.setText(null);
			
		}
		else if(e.getSource()==registrationJButton[2]){
			System.exit(0);
		}
			
	}
	public static void main(String[] args){
		new Registration();
	}
}