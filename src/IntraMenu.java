import javax.imageio.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
public class IntraMenu extends JFrame{
	private static final int HEIGHT= 1000;
	private static final int WIDTH= 2500;
	// declaration of instance variables
	String title;
	JLabel log,ret,n,l;
	JButton n2,l2,ret2;
	public static MainDataBase mdb;
	JPanel p1= new JPanel(new GridLayout(2,3));
	JPanel f1= new JPanel(new FlowLayout());
	JPanel f2= new JPanel(new FlowLayout());
	JPanel f3= new JPanel(new FlowLayout());
	public IntraMenu(String res,MainDataBase mdb1) throws IOException{
		mdb=mdb1;
		setName(res);
		setTitle(title);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent evt) {
				try {
					mdb.SaveAllData();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,"Data wasn´t saved due to issues in the database","Atention",JOptionPane.WARNING_MESSAGE);
				}
				System.exit(0); 
			}
		});
		setLayout(new BorderLayout());
		create3();
		setVisible(true);
	}
	public void setName(String res){// title setter
		this.title=res;
	}
	public void setMDB(MainDataBase mdb){
		this.mdb=mdb;
	}
	public void create3() throws IOException{
		getContentPane().setBackground(new Color(0,128,192));// set Background of intramenu
		ImageIcon logo= new ImageIcon(IntraMenu.class.getClassLoader().getResource("NAPSAlogo.png"));// logo
		log= new JLabel (logo);
		ImageIcon exit = new ImageIcon(IntraMenu.class.getClassLoader().getResource("exit.png"));// return symbol
		ret= new JLabel (exit);
		ImageIcon  newsymbol= new ImageIcon(IntraMenu.class.getClassLoader().getResource("newsymbol.jpg"));// new workorder image
		n= new JLabel (newsymbol);
		ImageIcon listsymbol = new ImageIcon(IntraMenu.class.getClassLoader().getResource("listsymbol.jpg"));// list image
		l= new JLabel (listsymbol);
		// if-else button names
		if(!title.equals("Clients")){
			n2= new JButton("New "+title+" WorkOrder");
			l2= new JButton(title+" Work Order List");
		}else if(title.equals("Clients")){
			n2= new JButton("Add New Client");
			l2= new JButton("Open Clients´ List");
		}
		// setFont of Buttons
		ret2= new JButton("Return");
		n2.setFont(new java.awt.Font("Console",0,30));
		l2.setFont(new java.awt.Font("Console",0,30));
		ret2.setFont(new java.awt.Font("Console",0,30));
		f1.add(n2);
		f2.add(l2);
		f3.add(ret2);
		// setBackground of Panels
		f1.setBackground(new Color(0,128,192));
		f2.setBackground(new Color(0,128,192));
		f3.setBackground(new Color(0,128,192));
		p1.add(n);
		p1.add(l);
		p1.add(ret);
		p1.add(f1);
		p1.add(f2);
		p1.add(f3);
		p1.setBackground(new Color(0,128,192));
		add(log, BorderLayout.NORTH);
		add(p1, BorderLayout.CENTER);
		// ActionListeners
		n2.addActionListener(new Listener());
		l2.addActionListener(new Listener());
		ret2.addActionListener(new Listener());
	}
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String sec;
			//Source if
			if(e.getSource()==n2){
				sec="New Work Order";
				try {
					NewWO n= new NewWO(title,sec,mdb);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if(e.getSource()==l2){
				sec="Work Order List";
				try {
					List li= new List(title, sec, mdb);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if (e.getSource()==ret2){
				try {
					Menu m= new Menu(mdb);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			dispose();
		}
	}
}
