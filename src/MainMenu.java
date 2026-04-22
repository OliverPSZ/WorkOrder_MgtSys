import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
public class MainMenu extends JFrame{
	//declaration of instance variables
	private static final int HEIGHT= 1000;
	private static final int WIDTH= 2500;
	public static MainDataBase mdb;
	JLabel image,user,pass;
	JTextField user2,pass2;
	JButton ok;
	JPanel p1= new JPanel();
	JPanel p= new JPanel(new GridLayout(3,1));
	JPanel f1= new JPanel(new FlowLayout());
	JPanel f2= new JPanel(new FlowLayout());
	JPanel f3= new JPanel(new FlowLayout());
	public MainMenu(MainDataBase mdb1) throws IOException{
		mdb=mdb1;
		setSize(WIDTH,HEIGHT);
		setLayout(new BorderLayout());
		setTitle("NAPSA Aeronautics");
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
		create();
		setVisible(true);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error" +e.getMessage());
		}
	}
	public void setMDB(MainDataBase mdb){
		this.mdb=mdb;
	}
	public void create() throws IOException{
		getContentPane().setBackground(new Color(0,128,192)); // setBackground to window
		ImageIcon napsa = new ImageIcon(getClass().getResource("NAPSAlogo.png"));
		image= new JLabel(napsa);// label of image
		/* declare labels and text fields
		 * setFonts, setBackground, setForeground
		 */
		user= new JLabel ("User: ");					
		user.setFont(new java.awt.Font("Console",0,30));
		user.setForeground(Color.WHITE);
		user2= new JTextField("",10);
		user2.setFont(new java.awt.Font("Console",0,30));
		pass= new JLabel ("Password: ");
		pass.setFont(new java.awt.Font("Console",0,30));
		pass.setForeground(Color.WHITE);
		pass2= new JPasswordField("",10);
		pass2.setFont(new java.awt.Font("Console",0,30));
		ok= new JButton("OK");
		ok.setFont(new java.awt.Font("Console",0,30));
		// add labels and textfields to panels
		f1.add(user);
		f1.add(user2);
		f2.add(pass);
		f2.add(pass2);
		f3.add(ok);
		// setBackground to the panels
		f1.setBackground(new Color(0,128,192));
		f2.setBackground(new Color(0,128,192));
		f3.setBackground(new Color(0,128,192));
		p1.setBackground(new Color(0,128,192));
		p.add(p1);
		p.add(f1);
		p.add(f2);
		add(image, BorderLayout.NORTH);// add NAPSA logo to frame
		add(p, BorderLayout.CENTER);// add panel with labels and textfields to frame
		add(f3, BorderLayout.SOUTH);// add "ok" button to frame
		// ActionListener of the textfields and button
		user2.addActionListener(new Listener());	
		pass2.addActionListener(new Listener());
		ok.addActionListener(new Listener());
	}
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//String Data Base for Users and Passwords
			String e1="";
			String e2="";			
			e1=user2.getText();
			e2=pass2.getText();
			//Comparation
			if(e1.equals("Oliver")&&e2.equals("Pineda")){
				dispose();// close User/Password window
				try {
					Menu men= new Menu(mdb);
				} catch (IOException e3) {
					e3.printStackTrace();
				}// new Frame
			}else{
				JOptionPane.showMessageDialog(null,"Invalid user or password.","Atention",JOptionPane.WARNING_MESSAGE);// Error message
			}
		}
	}
}
