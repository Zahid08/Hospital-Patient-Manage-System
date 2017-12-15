import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Fullinformationtable extends JFrame implements  ActionListener{   
	JTable detailsTable;
	JButton delete;
	JTextField deltsearch;
	//DefaultTableModel model;
	
    
    Fullinformationtable(){
delete=new JButton("Delete");
  delete.addActionListener(this);
deltsearch=new JTextField();
		Object rowData[][] =new Object[40][9];
		Object columnNames [] = { "Name", "patient_no","Word_no","AdmitDate","Release_Date","Is_Release","Age","gender"};
	//	 model=new DefaultTableModel(rowData,columnNames);
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectfinal", "root", "");
            Statement stmt = con.createStatement();
                                    
            String query = "SELECT Name,patient_no,Word_no,Admitdate,Release_Date,Is_Release,Age,gender FROM patient_word ";           
            ResultSet rs = stmt.executeQuery(query);             
            
            for(int i=0;rs.next();++i){
         
		 rowData[i][0] = rs.getString("Name");
         rowData[i][1] = rs.getString("patient_no");
        rowData[i][2] = rs.getString("Word_no");
		rowData[i][3] = rs.getString("Admitdate");
		rowData[i][4] = rs.getString("Release_Date");
		rowData[i][5] = rs.getString("Is_Release");
		rowData[i][6] = rs.getString("Age");
		rowData[i][7] = rs.getString("gender");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ShowAll_Information");
        }
        
        detailsTable = new JTable(rowData, columnNames);
        JScrollPane pnl = new JScrollPane(detailsTable);
        this.getContentPane().setBackground(Color.gray);
	this.getContentPane().add(pnl);
	
	this.getContentPane().add(deltsearch);
	this.getContentPane().add(delete);
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(600, 400);
        this.setVisible(true);
    }
	public void actionPerformed(ActionEvent e)
	{	
	 if (e.getSource()==delete){
			String deleteName=deltsearch.getText();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectfinal", "root", "");
				Statement stmt = con.createStatement();
				
				 if(detailsTable.getSelectedRowCount()==1){ //Only for single selection
                   String sql = "DELETE FROM  patient_word where  Name= '"+deleteName+"' " ;
				stmt.executeUpdate(sql);

					 int selectedRow = detailsTable.getSelectedRow();
                    int selectedColumn = detailsTable.getSelectedColumn();                    
                    String selectedValue = detailsTable.getValueAt(selectedRow, selectedColumn).toString();
                    //JOptionPane.showMessageDialog(null, selectedValue);
					 //model.removeRow(detailsTable.getSelectedRow());
				 }
            JOptionPane.showMessageDialog(this,"Deleted 1 Row Succesfully !");
			}
				
			
				catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "ShowAll_Information");}
		}
	}
	

public static void main(String[] args){
		new Fullinformationtable();
	}


}
