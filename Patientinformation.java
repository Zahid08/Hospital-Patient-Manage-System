import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;


public class Patientinformation extends JFrame implements ActionListener{
	 JLabel[] patientJLabel;
	 JTextField searchJTextField,updateJTextField;
	 JButton releasebutton;
	 JButton searchButton,editButton,ComboBox;
	JButton	show;
	JComboBox duplicateJComboBox;
	JTextField  nameJTextField,patientidJTextField,admitdateJTextField,releasedateJTextField,	isreleaseJTextField,ageJTextField,genderJTextField;
	
	public Patientinformation() {
 	        //lebel header searching patient
		JLabel header=new JLabel("Searching Each Patient :>>Name>> ");
		header.setBounds(50,20,200,30);
		header.setForeground(Color.blue);	
		this.add(header);

		JLabel fullinformationpatient=new JLabel("##*:(Full information show Each Patient :>>> )");
		fullinformationpatient.setForeground(Color.black);	
		fullinformationpatient.setBounds(300,120,250,30);
		this.add(fullinformationpatient);
		
		show=new JButton("DETAILS");
		show.addActionListener(this);
		show.setBounds(310,160,90,25);
		this.add(show);

		JLabel release=new JLabel("## : (If patient is not release give release : ) ");
		release.setBounds(300,220,250,30);
		release.setForeground(Color.black);	
		this.add(release);
		
		
		JLabel editable=new JLabel("## : (If need to Editavle then select EditButton   : ) ");
		editable.setBounds(300,310,290,30);
		editable.setForeground(Color.black);	
		this.add(editable);
		
	        releasebutton=new JButton("RELEASE");
		releasebutton.setBounds(310,260,90,25);
		releasebutton.addActionListener(this);
		this.add(releasebutton);
		
		
		editButton=new JButton("EDIT");
		editButton.setBounds(310,350,90,25);
		editButton.addActionListener(this);
		this.add(editButton);
		
		
		updateJTextField=new JTextField();
		updateJTextField.setForeground(Color.gray);
		updateJTextField.setBounds(310,400,150,30);;
		this.add(updateJTextField);	 
		
		
		searchJTextField=new JTextField();
		searchJTextField.setForeground(Color.gray);
		searchJTextField.setBounds(50,60,250,30);;
		this.add(searchJTextField);	 
		
		searchButton=new JButton("Search");	
		searchButton.setBounds(310,60,90,25);
		searchButton.addActionListener(this);
		this.add(searchButton);	 
  
                duplicateJComboBox=new JComboBox();	
		duplicateJComboBox.setBounds(430,60,90,25);
		duplicateJComboBox.addActionListener(this);
		this.add(duplicateJComboBox);	
                
                 ComboBox=new JButton("Show");	
		ComboBox.setBounds(430,10,90,25);
		ComboBox.addActionListener(this);
		this.add(ComboBox);	 
  


	patientJLabel=new JLabel[10];
		
		//textfild of patient information
		nameJTextField=new JTextField();
		 patientidJTextField=new JTextField();
		 admitdateJTextField=new JTextField();
		 releasedateJTextField=new JTextField();
		 isreleaseJTextField=new JTextField();
		 ageJTextField=new JTextField();
		 genderJTextField=new JTextField();
	
		nameJTextField.setBounds(100,120,150,25);
		patientidJTextField.setBounds(100,170,150,25);
		admitdateJTextField.setBounds(100,220,150,25);
		releasedateJTextField.setBounds(100,270,150,25);
		isreleaseJTextField.setBounds(100,320,150,25);
		ageJTextField.setBounds(100,370,150,25);
		genderJTextField.setBounds(100,420,150,25);
		
		this.add( nameJTextField);
		this.add( patientidJTextField);
		this.add( admitdateJTextField);
		this.add( releasedateJTextField);
		this.add( isreleaseJTextField);
		this.add( ageJTextField);
		this.add( genderJTextField);
		
		patientJLabel[0]=new JLabel("Information of Patient");
		patientJLabel[1]=new JLabel("Name :");
		patientJLabel[2]=new JLabel("Patient_no :");
		patientJLabel[3]=new JLabel("Admit_Date:");                                          
		patientJLabel[4]=new JLabel("Release_Date:");
		patientJLabel[5]=new JLabel("Is_Release :");
		patientJLabel[6]=new JLabel("Age :");
		patientJLabel[7]=new JLabel("Gender :");
		patientJLabel[1].setBounds(50,120,70,20);
		patientJLabel[2].setBounds(30,170,100,20);
		patientJLabel[3].setBounds(20,220,100,20);
		patientJLabel[4].setBounds(20,270,100,20);
		patientJLabel[5].setBounds(25,320,100,20);
		patientJLabel[6].setBounds(45,370,100,20);
		patientJLabel[7].setBounds(45,420,100,20);
		
		this.add(patientJLabel[0]);
		this.add(patientJLabel[1]);
		this.add(patientJLabel[2]);
		this.add(patientJLabel[3]);
		this.add(patientJLabel[4]);
		this.add(patientJLabel[5]);
		this.add(patientJLabel[6]);
		this.add(patientJLabel[7]);
		
	this.getContentPane().setBackground(Color.pink);	
        this.setLayout(null);
        this.setSize(600, 550);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
	String patientName = searchJTextField.getText();	
		if(e.getSource()==searchButton){                           //selected and searching event
			System.out.println("Hit on Search Button ");
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectfinal", "root", "");
				Statement stmt = con.createStatement();
                                    
				//  String query ="SELECT Name,patient_no,Word_no,Admitdate,Release_Date,Is_Release,Age,gender FROM patient_word where Name='"+bookName+"
				ResultSet rs =  stmt.executeQuery("SELECT * FROM patient_word WHERE  Name= '"+patientName+"'");    
					while(rs.next()){
				
					String pName = rs.getString("Name");   //databse String Name 
					String pNo = rs.getString("patient_no");
					String admitdat = rs.getString("Admitdate");
					String page = rs.getString("Release_Date");
					String bEdition = rs.getString("Is_Release");
					String bSub = rs.getString("Age");
					String bTotalCopy = rs.getString("gender");
				
					nameJTextField.setText(pName);
					patientidJTextField.setText(pNo);
					admitdateJTextField.setText(admitdat);
					releasedateJTextField.setText(page);
					isreleaseJTextField.setText(bEdition);
					ageJTextField.setText(bSub);
					genderJTextField.setText(bTotalCopy);
					
				}
						con.close();
				
			}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(this, "ShowAll_Information");}	
				}					
	  
		else if(e.getSource()==releasebutton){
				System.out.println("Hit on Release Button ");
				new Release();   //new release class
			}
			else if(e.getSource()==show){
				System.out.println("Hit on Details Button ");
				new Fullinformationtable();
				}
				
				
			else if(e.getSource()==editButton){
			
			String query1="";
			String update=updateJTextField.getText();
			try {
			 
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectfinal", "root", "");
				Statement stmt = con.createStatement();
				// String query ="SELECT Name,patient_no,Word_no,Admitdate,Release_Date,Is_Release,Age,gender FROM patient_word where Name='"+bookName+"
				 query1="UPDATE patient_word  SET Name='"+nameJTextField.getText()+"',patient_no='"+patientidJTextField.getText()+"' ,Admitdate='"+ admitdateJTextField.getText()+"' ,Release_Datse='"+releasedateJTextField.getText()+"',Is_Release='"+isreleaseJTextField.getText()+"',Age='"+ageJTextField.getText()+"',gender='"+genderJTextField.getText()+"'  WHERE Name= '"+update+"' " ;
				stmt.execute(query1);
			        //	stmt.executeUpdate("INSERT INTO patient_word (Name,patient_no,Admitdate,Release_Date,Is_Release,Age,Address) VALUES ('"+n1+"','"+n2+"', '"+n3+"' , '"+n4+"','"+n5+"','"+n6+"','"+n7+"')  ");
				
				ResultSet    rs =  stmt.executeQuery("SELECT * FROM patient_word WHERE  Name= '"+nameJTextField.getText()+"'");  
			        while(rs.next()){
                                
				 JOptionPane.showMessageDialog(this,"Successfully Updated !");}
					
			con.close();
		}
			
			catch (Exception ex) {

			JOptionPane.showMessageDialog(this, "Error");}
				
				}
                       
				else if(e.getSource()==(JButton)ComboBox){ 
                      //    boolean s=1;
					  System.out.println("skjff");
				//String query1="";
				
				
                      try{
			   
                                	 
				Class.forName("com.mysql.jdbc.Driver");   
				Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectfinal", "root", "");
				Statement stmt = con.createStatement();
                             ResultSet rs =  stmt.executeQuery("SELECT count(*) AS za  FROM patient_word WHERE  Name= ' hasan' ");System.out.println("ddd");
				 //  rs=stmt.executeQuery("SELECT * FROM patient_word WHERE  Name='"+patientName+"'");
				    rs.next();
			      String co=rs.getString("za");
			      System.out.println("d");
			      System.out.println(co);
				 
			      //if(count>1){ 
                              
                              	      rs =  stmt.executeQuery("SELECT * FROM patient_word WHERE  Name= '"+patientName+"'");
				     while(rs.next()){
                                     String cm=rs.getString("Name");
					 //  if(cm.equals("Name")){
					     System.out.println("cm");
                                      duplicateJComboBox.addItem(cm);
				    }
				  	JOptionPane.showMessageDialog(this, "Duplicate name");
                                      
                                  //} 
                                
					//	else 
					  //JOptionPane.showMessageDialog(this, " not Duplicate name");
                                  
                                  }
				       
				    
                            	//JOptionPane.showMessageDialog(this, "Duplicate name");
                                       
				
                              
			       catch (Exception exp){
                            	JOptionPane.showMessageDialog(this, "Show");}
                            }
                           
                        
                        
			
		}
 

    public static void main(String args[]) {
        new Patientinformation();
    }
}
