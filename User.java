import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.sql.*;

public class User extends JFrame implements ActionListener{//inherit Jframe actionlstener which is interface and action event class
		 JPasswordField userJPasswordField; //insatnce veriable
		 JLabel userJLabel1,userJLabel2;
		 JTextField userJTextField;
		 JButton[] userJButton;	
    
	//constrocture default use same packg or class (access),extra method without overwride
	User(){
		userJButton=new JButton[4];//create instance of JButton
		userJTextField=new JTextField("");
		userJPasswordField=new JPasswordField("");
		userJButton[0]=new JButton();
		userJButton[1]=new JButton();
		userJButton[2]=new JButton();
		userJLabel1=new JLabel();
		userJLabel2=new JLabel();
        
		//text name
		userJLabel1.setText("Email:");
		userJLabel2.setText("Password:");
		userJButton[0].setText("Login");
		userJButton[1].setText("Registration");
		userJButton[2].setText("Exit");
		
		//setBounds seting  x,y,width,height;
		userJLabel1.setBounds(130,80, 100, 30);
		userJLabel2.setBounds(130,120,100,30);
		userJTextField.setBounds(200,85,200,30);
		userJPasswordField.setBounds(200,120,200,30);
		userJButton[0].setBounds(230,170,70,25);
		userJButton[1].setBounds(320,170,110,25);
		userJButton[2].setBounds(490,310,70,25);
		
		//add each button and label
		this.add(userJLabel1);
		this.add(userJLabel2);
		this.add(userJTextField);
		this.add(userJPasswordField);
		this.add(userJButton[0]); 
		this.add(userJButton[1]);
		this.add(userJButton[2]);
		
		//Action listener each button
		userJButton[0].addActionListener(this);
		userJButton[1].addActionListener(this);
		userJButton[2].addActionListener(this);
		
                //window size & title     
		this.getContentPane().setBackground(Color.pink);
		this.setTitle("LOGIN");
		this.setSize(600,400);//600 width and 400 height 
		this.setLayout(null);
		this.setVisible(true);  //frame visible
	 }
    
	 public void actionPerformed(ActionEvent e){//if  anonoymus class use  must be  overwride this method
		if(e.getSource()==userJButton[0]){
			//dialog get
			String u1=userJTextField.getText();
			String u2=userJPasswordField.getText();
			 
		try{
			System.out.println("actionPerformed successfully");
			Class.forName("com.mysql.jdbc.Driver");//use to register driver
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectfinal","root","");//conction  estabilished to database
			Statement stmt = con.createStatement();//conection interface
			String query="SELECT email,Password FROM Users ";
			ResultSet rs=stmt.executeQuery(query);
			int flag=0;
			while(rs.next()){
				if(rs.getString(1).equals(u1) && rs.getString(2).equals(u2)){
				flag=0;
				JOptionPane.showMessageDialog(this,"Successfully Login!");
				new Indoorpatient();
				this.setVisible(false);
				break;
				}

				}
				con.close();//interface close
		}
		      			 
		catch(Exception exp){ exp.printStackTrace();}
        }
				else if(e.getSource()==userJButton[1]){
				new Registration();
				this.setVisible(false);}
			
				else if(e.getSource()==userJButton[2]){
				System.exit(0);
				}
		
	}
	 
	public static void main(String[] args) {
                   new User();
}
}