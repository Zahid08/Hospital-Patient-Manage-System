import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.LineBorder;

public class Release extends JFrame implements ActionListener {//inherit Jframe actionlstener which is interface and action event class
		JLabel[] releaseJLabel;
		JButton releaseButton,serchidButton;   //insatnce veriable
		JComboBox releasedateJComboBox;
		JCheckBox newJCheckBox1,newJCheckBox2;
		ButtonGroup bg1;
		JLabel ageJLabel;
		JLabel wordnoJLabel,nameJLabel,patientnoJLabel;
		 JTextField srchidJTextfield;
	//constrocture default use same packg or class (access),extra method without overwride
	public Release() {
                //header lebel
		JLabel header=new JLabel("**Releasing Information::Input Patient_id  >>>");
		header.setForeground(Color.blue);	
		header.setBounds(90,5,250,20);
		this.add(header);
		
		//seach textbox
		srchidJTextfield=new JTextField();
		srchidJTextfield.setBounds(50,30,200,30);
		this.add(srchidJTextfield);
		
		serchidButton=new JButton("SearchNo");
		serchidButton.setBounds(260,30,90,30);
		serchidButton.addActionListener(this);
		this.add(serchidButton);
		
		//checking relese or not 
		JLabel isreleasechk=new JLabel("Releasing : ");
		isreleasechk.setBounds(35,390,90,30);
		this.add(isreleasechk);
		ageJLabel=new JLabel();
	  	ageJLabel.setBorder(new LineBorder(new Color(0,0,0),1)); //colouring line border thickness 1 and colour code
		ageJLabel.setBounds(120,220,150,25);
		this.add(ageJLabel);
		
		JLabel relsdate=new JLabel("Age: ");
		relsdate.setBounds(55,220,100,20);
		this.add(relsdate);
		
		newJCheckBox1=new JCheckBox();
		newJCheckBox1.setBounds(110,390,70,30);
		newJCheckBox1.setText("Yes");
		this.add(newJCheckBox1);
		
		newJCheckBox2=new JCheckBox();
		newJCheckBox2.setBounds(180,390,90,30);
		newJCheckBox2.setText("No");
		this.add(newJCheckBox2);
		
		//grouping
		bg1=new ButtonGroup();
		bg1.add(newJCheckBox1);
		bg1.add(newJCheckBox2);
		
		//label on patient information
		releaseJLabel=new JLabel[10];
		 releaseJLabel[1]=new JLabel("Name :");
		 releaseJLabel[2]=new JLabel("Patient_no :");
		 releaseJLabel[3]=new JLabel("Admit_Date:");
		 releaseJLabel[4]=new JLabel("Release_Date:");
		 releaseJLabel[5]=new JLabel("Release_date:");
		 releaseJLabel[5].setBounds(20,270,90,30);
		 this.add(releaseJLabel[5]);
		 
		 releaseJLabel[6]=new JLabel();
		 releaseJLabel[6].setBounds(120,270,100,20);
		 releaseJLabel[6].setBorder(new LineBorder(new Color(0,0,0),1)); //colouring line border thickness 1 and colour code
		 this.add(releaseJLabel[6]);
		
		//auto date generate
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy/MM/dd");
		releasedateJComboBox=new JComboBox();
		releasedateJComboBox.addItem(sd.format(date));
		releasedateJComboBox.setBounds(150,340,100,20);
		this.add(releasedateJComboBox);
		 releaseJLabel[1].setBounds(55,70,70,20);
		 releaseJLabel[2].setBounds(35,120,100,20);
		 releaseJLabel[3].setBounds(25,180,100,20);
		 releaseJLabel[4].setBounds(25,340,100,20);
		 this.add(releaseJLabel[1]);
		 this.add(releaseJLabel[2]);
		 this.add(releaseJLabel[3]);
		 this.add(releaseJLabel[4]);
		
		nameJLabel=new JLabel();
		nameJLabel.setBorder(new LineBorder(new Color(0,0,0),1));
		patientnoJLabel=new JLabel(); 
		patientnoJLabel.setBorder(new LineBorder(new Color(0,0,0),1)); 
		wordnoJLabel=new JLabel(); 
		wordnoJLabel.setBorder(new LineBorder(new Color(0,0,0),1));
		nameJLabel.setBounds(120,70,150,25);
		patientnoJLabel.setBounds(120,120,150,25);
		wordnoJLabel.setBounds(120,170,150,25);
		this.add( nameJLabel);
		this.add( patientnoJLabel);
		this.add( wordnoJLabel);
		
		releaseButton=new JButton("Release");
		releaseButton.setBounds(300,470,80,25);
		releaseButton.addActionListener(this);
		this.add(releaseButton);
	
	//window size & title     
       this.setTitle("Releasing_Window");
        this.setLayout(null);
        this.setSize(450, 550);//width and height 
        this.setVisible(true);
    }

   public void actionPerformed(ActionEvent e)
	{
		String  chkrelease= null;
		String patientNo= srchidJTextfield.getText(); //geting serch textbox value and store in patient no
		if(e.getSource() ==serchidButton)
		{
			 try {
				Class.forName("com.mysql.jdbc.Driver");  //Driver setup
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectfinal", "root", ""); //Driver conection
				Statement stmt = con.createStatement();  
				ResultSet    rs =  stmt.executeQuery("SELECT * FROM patient_word WHERE  patient_no= '"+patientNo+"'");    
				while(rs.next())
				{
					String pName = rs.getString("Name");
					String pNo = rs.getString(2);
					String admitdate = rs.getString("Admitdate");
					String page = rs.getString("Age");
					String prelease = rs.getString("Release_Date");
					
					
					nameJLabel.setText(pName);
					patientnoJLabel.setText(pNo);
					wordnoJLabel.setText(admitdate);
					ageJLabel.setText(page);
					releaseJLabel[6].setText(prelease);
					
				}
				con.close();
            
            
        }		 catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "Error ocure");
				}
			

		}
		
		else if(e.getSource() ==releaseButton){   //Update date In release or not 
			
			String relese=null;
			 String query1="";
			
			if(newJCheckBox1.isSelected())  //checking    selected checkbox
			{
				relese = "Yes";
			}
			else if(newJCheckBox2.isSelected())
			{
				relese = "No";
			}	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectfinal", "root", "");
				Statement stmt = con.createStatement();
				query1= "UPDATE patient_word  SET Release_Date='"+releasedateJComboBox.getSelectedItem().toString()+"', Is_Release='"+relese+"'  WHERE patient_no= '"+patientNo+"' " ;
				stmt.execute(query1);
				ResultSet    rs =  stmt.executeQuery("SELECT * FROM patient_word WHERE  patient_no= '"+srchidJTextfield.getText()+"'");     
			    while(rs.next()){
				String  prelease= rs.getString("Release_Date");
				releaseJLabel[6].setText(prelease);}
				JOptionPane.showMessageDialog(this, "Succesfully updated release date and Is_release");
				con.close();
			}
			catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "ShowAll_Information");
        }
			
	}
}
    
    public static void main(String args[]) {
        new Release();
    }
}
