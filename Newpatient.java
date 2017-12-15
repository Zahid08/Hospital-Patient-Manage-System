import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Newpatient extends JFrame implements ActionListener{
	//Button name
	JLabel[] newJLable;
	JButton  saveButton,closeButton,resetbutton,newsearchButton,B;
	JTextField  nametxt,agetext,addressText,wordnoText,deleteTexfiled;
	JRadioButton newJRadioButton1,newJRadioButton2;
	JCheckBox newJCheckBox1,newJCheckBox2;
	ButtonGroup bg1,bg2;
	JButton   updateButton;
	JButton   deleteButton;
	JLabel header1,header2,header3,header4;
	JLabel updatedname,updateddage,updatedgender,updatedaddress,updatedrelease,updatedwordno;
	JTextField updateTexfiled;
	
 	public Newpatient(){
		//lebel1 for information patient
		header1=new JLabel("New Patient  :>>Information>> ");
		header1.setBounds(50,5,200,30);
		header1.setForeground(Color.blue);	
		this.add(header1);
       
	   //Update information
		header2=new JLabel("**Update :>>Information>> ");
		header2.setBounds(300,5,200,30);
		header2.setForeground(Color.blue);	
		this.add(header2);
		
		//update lebel
		updatedname=new JLabel();
		updateddage=new JLabel();
		updatedgender=new JLabel();
		updatedaddress=new JLabel();
		updatedrelease=new JLabel();
		updatedwordno=new JLabel();
		
		updatedname.setBounds(350,35,150,25);
		updateddage.setBounds(350,75,150,25);
		updatedgender.setBounds(350,125,150,25);
		updatedaddress.setBounds(350,170,150,30);
		updatedrelease.setBounds(350,250,150,30);
		updatedwordno.setBounds(350,350,150,30);
		updatedname.setBorder(new LineBorder(new Color(0,0,0),1));
		updateddage.setBorder(new LineBorder(new Color(0,0,0),1));
		updatedgender.setBorder(new LineBorder(new Color(0,0,0),1));
		updatedaddress.setBorder(new LineBorder(new Color(0,0,0),1));
		updatedrelease.setBorder(new LineBorder(new Color(0,0,0),1));
		updatedwordno.setBorder(new LineBorder(new Color(0,0,0),1));
		this.add(updatedname);
		this.add(updateddage);
		this.add(updatedgender);
		this.add(updatedaddress);
		this.add(updatedrelease);
		this.add(updatedwordno);
		
		
		//searchupdateinformation
		header3=new JLabel("**Updating:<<Name Input >> ** ");
		header3.setBounds(520,10,200,30);
		header3.setForeground(Color.blue);	
		this.add(header3);
	    
		//searching text which save or update r8 side
		updateTexfiled=new JTextField();
		updateTexfiled.setBounds(520,40,100,30);
		this.add(updateTexfiled);
		
		//<<deleting serch>>
		deleteTexfiled=new JTextField();
		deleteTexfiled.setBounds(520,120,100,30);
		this.add(deleteTexfiled);
		
		//Deleteinformation
		header4=new JLabel("**Deletin:<<Input: Patient_Id` >> ** ");
		header4.setBounds(520,80,200,30);
		header4.setForeground(Color.blue);	
		this.add(header4);
		
		//lebel for Newpatient>>
		newJLable=new JLabel[15];
		newJLable[0]=new JLabel("Name");
		newJLable[1]=new JLabel("Age");
		newJLable[2]=new JLabel();
		newJLable[3]=new JLabel();
		newJLable[4]=new JLabel();
		newJLable[5]=new JLabel();
		newJLable[6]=new JLabel();
		newJLable[7]=new JLabel();
		
		newJLable[0].setBounds(40,30,50,30);
		this.add(newJLable[0]);
		newJLable[1].setBounds(40,70,50,30);
		this.add(newJLable[1]);
		
		//Textfiled for new patient
		nametxt=new JTextField();
		agetext=new JTextField();
		newJRadioButton1=new JRadioButton();
		newJRadioButton2=new JRadioButton();
		bg1=new ButtonGroup();
		addressText=new JTextField();
		wordnoText=new JTextField();
		
		nametxt.setBounds(90,35,150,30);
		this.add(nametxt);
		
		newJCheckBox1=new JCheckBox();
		newJCheckBox2=new JCheckBox();
		bg2=new ButtonGroup();
		newJLable[7].setText("Release : ");
		agetext.setBounds(90,75,150,30);
		this.add(agetext);
		
		newJLable[2].setText("Gender:");
		newJLable[2].setBounds(40,120,50,30);
		this.add(newJLable[2]);
		
		newJRadioButton1.setText("Male");
		newJRadioButton1.setBounds(90,125,70,20);
		this.add(newJRadioButton1);
		
		newJRadioButton2.setText("FeMale");
		newJRadioButton2.setBounds(155,125,80,20);
		this.add(newJRadioButton2);
		
		bg1.add(newJRadioButton1);
		bg1.add(newJRadioButton2);
		
		newJLable[3].setText("Address :");
		newJLable[3].setBounds(30,170,80,30);
		this.add(newJLable[3]);
		
		addressText.setBounds(100,175,150,70);
		this.add(addressText);
		newJLable[6].setText("Word NO: ");
		newJLable[6].setBounds(20,350,90,30);
		this.add(newJLable[6]);
		
		wordnoText.setBounds(100,350,150,30);
		this.add(wordnoText);
		
		newJLable[7].setBounds(20,250,90,30);
		this.add(newJLable[7]);
		
		newJCheckBox1.setBounds(100,255,70,30);
		newJCheckBox1.setText("Yes");
		
		this.add(newJCheckBox1);
		newJCheckBox2.setBounds(100,290,70,30);
		newJCheckBox2.setText("No");
		this.add(newJCheckBox2);
		
		bg2.add(newJCheckBox1);
		bg2.add(newJCheckBox2);
		
		saveButton=new JButton("SAVE");
		saveButton.setBounds(170,430,80,30);
		saveButton.addActionListener(this);
		this.add(saveButton);
		
		
		updateButton=new JButton("UPDATE");
		updateButton.setBounds(260,430,80,30);
		updateButton.addActionListener(this);
		this.add(updateButton);
		
			
		deleteButton=new JButton("DELETE");
		deleteButton.setBounds(350,430,80,30);
		deleteButton.addActionListener(this);
		this.add(deleteButton);
		
		closeButton=new JButton("SHOW");
		closeButton.setBounds(580,470,80,30);
		this.add(closeButton);
		
		
		resetbutton=new JButton("Reseat");
		resetbutton.addActionListener(this);
		resetbutton.setBounds(450,430,80,30);
		this.add(resetbutton);
		
		closeButton.addActionListener(this);
		this.setTitle("New Patient_window");
		this.add(saveButton);
		this.add(closeButton);
		
		this.setLayout(null);
        this.setSize(700,550);
        this.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{	
		//Inserted query
		String Gender= null;
		String relese=null;
		if(e.getSource() ==saveButton)
		{
			if(newJRadioButton1.isSelected())
			{
				Gender = "Male";
			}
			else if(newJRadioButton2.isSelected())
			{
				Gender = "Female";
			}	
		String name = nametxt.getText(); //name
		int age = Integer.parseInt(agetext.getText());//age
		String address= addressText.getText();//address
		int wordno = Integer.parseInt(wordnoText.getText());//word		
			try{
				 if(newJCheckBox1.isSelected())
				{
				relese = "Yes";
				}
				else if(newJCheckBox2.isSelected())
				{
				relese = "No"; 
				}	
				System.out.println("actionPerformed successfully");
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectfinal","root","");
				Statement stmt = con.createStatement();
				stmt.executeUpdate("INSERT INTO patient_word (Name,Word_no,Is_Release,Age,gender,Address) VALUES ('"+name+"','"+wordno+"', '"+relese+"' , '"+age+"','"+Gender+"','"+address+"')");
				//stmt.executeUpdate("INSERT INTO `patient` (`Name`, `Age`, `Sex`, `Address`, `Patient_Id`, `Admit_date`, `Word_number`, `Rele`) VALUES ('hasan', '31', 'asdj', '12', '1', '2016-08-02', '3', 'No')");
				JOptionPane.showMessageDialog(this,"Successfully inserted !");
				con.close();
			}
			catch(Exception exp){
				exp.printStackTrace();
		        }
	        }
		
		else if(e.getSource()==closeButton){
				
			//System.exit(0);
			 // JOptionPane.showMessageDialog(this,"Successfully Updated !");
				new Fullinformationtable();
		}
	
		else if(e.getSource()==resetbutton){
		
				System.out.println("Hit on reseat  Button ");
				nametxt.setText(null);
				agetext.setText(null);
				addressText.setText(null);
				wordnoText.setText(null);
		
		}
		
	


		//Updated Information
		else if(e.getSource()==updateButton){
			
			String uprelese=null;
			String upSex= null;
			String query1="";
			String patientName=updateTexfiled.getText();
			if(newJCheckBox1.isSelected())
			{
				uprelese = "Yes";
			}
			else if(newJCheckBox2.isSelected())
			{
				uprelese = "No";
			}	
		  
			try {
			 
				if(newJRadioButton1.isSelected())
				{
				upSex = "Male";
				}
				else if(newJRadioButton2.isSelected())
				{
				upSex = "Female";
				}
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectfinal", "root", "");
				Statement stmt = con.createStatement();
				// String query ="SELECT Name,patient_no,Word_no,Admitdate,Release_Date,Is_Release,Age,gender FROM patient_word where Name='"+bookName+"
				query1= "UPDATE patient_word  SET Name='"+nametxt.getText()+"',Word_no='"+wordnoText.getText()+"' ,Is_Release='"+uprelese+"', Age='"+agetext.getText()+"',gender='"+upSex+"',Address='"+addressText.getText()+"' WHERE Name= '"+patientName+"' " ;
				stmt.execute(query1);
				ResultSet    rs =  stmt.executeQuery("SELECT * FROM patient_word WHERE  Name= '"+nametxt.getText()+"'");  
			        while(rs.next()){
                                //JOptionPane.showMessageDialog(this,"Successfully Updated !");
					//new Fullinformationtable();
                                String  name= rs.getString("Name");
				updatedname.setText(name);
				    
                                String  age= rs.getString("Age");
				updateddage.setText(age);
				    
                                String  gendr= rs.getString("gender");
				updatedgender.setText(gendr);
				    
                                String  addrs= rs.getString("Address");
				updatedaddress.setText(addrs);
				    
                                String  rels= rs.getString("Is_Release");
				updatedrelease.setText(rels);
				
				String  wrdno= rs.getString("Word_no");
				updatedwordno.setText(wrdno);
			}
			
				con.close();
			}
			catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "ShowAll_Information");}
		}
		
		
		else if (e.getSource()==deleteButton){
			String deleteName=deleteTexfiled.getText();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectfinal", "root", "");
				Statement stmt = con.createStatement();
				String sql = "DELETE FROM  patient_word  WHERE  patient_no='"+deleteName+"'";
				stmt.executeUpdate(sql);
			
				JOptionPane.showMessageDialog(this,"Deleted 1 Row Succesfully !");
				}
			
				catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "ShowAll_Information");}
		}
		
			
			
			
		
	}
	public static void main(String [] args){
		new Newpatient();
	}
} 