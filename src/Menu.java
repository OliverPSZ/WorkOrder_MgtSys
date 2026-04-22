import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
public class Menu extends JFrame{
	public static MainDataBase mdb;
	private static final int HEIGHT=1000;
	private static final int WIDTH= 2500;
	// JLabels/JButtons/JPanels declaration
	JLabel logo,ndt,imt,ins,cal,clients,exit;
	JButton ndt2,imt2,ins2,cal2,clients2,exit2;
	JPanel p1= new JPanel(new GridLayout(4,1));
	JPanel p2= new JPanel(new GridLayout(4,1));
	JPanel p3= new JPanel(new GridLayout(4,1));
	JPanel f1= new JPanel(new FlowLayout());
	JPanel f2= new JPanel(new FlowLayout());
	JPanel f3= new JPanel(new FlowLayout());
	JPanel f4= new JPanel(new FlowLayout());
	JPanel f5= new JPanel(new FlowLayout());
	JPanel f6= new JPanel(new FlowLayout());
	public Menu(MainDataBase mdb1) throws IOException {
		mdb=mdb1;
		setSize(WIDTH,HEIGHT);
		setLayout(new BorderLayout());
		setTitle("Menu");
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
		try{
		create2();// create contents
		setVisible(true);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error"+e.getMessage(),"Atention",JOptionPane.WARNING_MESSAGE);
		}
	}
	public void setMDB(MainDataBase mdb){
		this.mdb=mdb;
	}
	public void create2() throws IOException{
		getContentPane().setBackground(new Color(0,128,192));// set Background of menu
		ImageIcon non = new ImageIcon(Menu.class.getClassLoader().getResource("ndt.JPG"));// NDT image
		ndt= new JLabel (non);
		ImageIcon wgt = new ImageIcon(Menu.class.getClassLoader().getResource("imt.jpg"));// IMT image
		imt= new JLabel (wgt);
		ImageIcon inst = new ImageIcon(Menu.class.getClassLoader().getResource("ins.jpg"));// Instruments image
		ins= new JLabel (inst);
		ImageIcon calib = new ImageIcon(Menu.class.getClassLoader().getResource("cal.jpg"));// Calibration image
		cal= new JLabel (calib);
		ImageIcon cli = new ImageIcon(Menu.class.getClassLoader().getResource("clients.jpg"));// Clients image
		clients= new JLabel (cli);
		ImageIcon ex = new ImageIcon(Menu.class.getClassLoader().getResource("exit.png"));// Exit image
		exit= new JLabel (ex);
		ImageIcon nl = new ImageIcon(Menu.class.getClassLoader().getResource("NAPSAlogo.png"));// Exit image
		logo= new JLabel (nl);
		// declare, setFonts and add buttons to panels
		ndt2= new JButton("Non-Destructive Testing");
		ndt2.setFont(new java.awt.Font("Console",0,30));
		imt2= new JButton("Weight & Balance");
		imt2.setFont(new java.awt.Font("Console",0,30));
		ins2= new JButton("Instruments & Radio");
		ins2.setFont(new java.awt.Font("Console",0,30));
		cal2= new JButton("Calibration");
		cal2.setFont(new java.awt.Font("Console",0,30));
		clients2= new JButton("Clients");
		clients2.setFont(new java.awt.Font("Console",0,30));
		exit2= new JButton("Return");
		exit2.setFont(new java.awt.Font("Console",0,30));
		// panels for buttons
		f1.add(ndt2);
		f2.add(imt2);
		f3.add(ins2);
		f4.add(cal2);
		f5.add(clients2);
		f6.add(exit2);
		// setBackground of panels
		f1.setBackground(new Color(0,128,192));
		f2.setBackground(new Color(0,128,192));
		f3.setBackground(new Color(0,128,192));
		f4.setBackground(new Color(0,128,192));
		f5.setBackground(new Color(0,128,192));
		f6.setBackground(new Color(0,128,192));
		// add images and button panels to p1, p2 and p3 panels
		p1.add(ndt);
		p1.add(f1);
		p1.add(cal);
		p1.add(f4);
		p2.add(imt);
		p2.add(f2);
		p2.add(clients);
		p2.add(f5);
		p3.add(ins);
		p3.add(f3);
		p3.add(exit);
		p3.add(f6);
		//setBackground of p1,p2 and p3 panels
		p1.setBackground(new Color(0,128,192));
		p2.setBackground(new Color(0,128,192));
		p3.setBackground(new Color(0,128,192));
		//add panels to frame
		add(logo, BorderLayout.NORTH);
		add(p1, BorderLayout.WEST);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.EAST);
		// Buttons´ ActionListeners
		ndt2.addActionListener(new Listener());
		imt2.addActionListener(new Listener());
		ins2.addActionListener(new Listener());
		cal2.addActionListener(new Listener());
		clients2.addActionListener(new Listener());
		exit2.addActionListener(new Listener());
		}
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			String res;// Title variable string
			// Source if
			if(e.getSource()==ndt2){
				res= new String("Non-Destructive Testing");
				try {
					IntraMenu i= new IntraMenu(res, mdb);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if(e.getSource()==imt2){
				res= new String("Weight & Balance");
				try {
					IntraMenu i= new IntraMenu(res,mdb);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if(e.getSource()==ins2){
				res= new String("Instruments & Radio");
				try {
					IntraMenu i= new IntraMenu(res,mdb);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if(e.getSource()==cal2){
				res= new String("Calibration");
				try {
					IntraMenu i= new IntraMenu(res,mdb);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if(e.getSource()==clients2){
				res= new String("Clients");
				try {
					IntraMenu i= new IntraMenu(res,mdb);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if(e.getSource()==exit2){
				// return try catch
				try {
					MainMenu m= new MainMenu(mdb);// return to user/password window
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			dispose();// close actual window
		}
	}
}
