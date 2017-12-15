import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;

public class Catagorypatient extends JFrame  implements ActionListener {
	
	JButton newJButton,oldJButton,LogoutButton;
	JLabel selcteventJLabel;
	
	public Catagorypatient(){
	
		newJButton=new JButton("New_Patient");//create instance of JButton
		oldJButton=new JButton("Old_Patient");
		LogoutButton=new JButton("Logout");
		selcteventJLabel=new JLabel();

		//setBounds seting  x,y,width,height;
		selcteventJLabel.setBounds(130,100,250,30);
		newJButton.setBounds(220,200,110,30);
		oldJButton.setBounds(220,250,110,30);
		LogoutButton.setBounds(220,50,120,30);
	
		selcteventJLabel.setText("SELECT THE EVENT FOR EACH CATAGORY ");
	
		this.add(selcteventJLabel);
		this.add(newJButton);	
		this.add(oldJButton);
		this.add(LogoutButton);
	
		//Actionlistener 
		newJButton.addActionListener(this);
		oldJButton.addActionListener(this);
		
		//window set width height,visibility making
		this.getContentPane().setBackground(Color.orange);
		this.setTitle("Catagory Each Patient");
		this.setSize(500,500);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	    //actionperform method and action event class
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==newJButton){
			new Newpatient();
			this.setVisible(false);
			}
		else if(e.getSource()==oldJButton){
			new Patientinformation();
			this.setVisible(false);
			}
	}
	
	public static void main(String[] args){
		new Catagorypatient();
		}
	
}