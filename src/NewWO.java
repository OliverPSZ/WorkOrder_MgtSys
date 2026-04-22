import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class NewWO extends JFrame{
	private static final int HEIGHT=1000; 
	private static final int WIDTH=2500;
	public static MainDataBase mdb;
	String area, section, q, work,material,results;// String declaration
	JLabel im,cl, br, tim,dat,place, mod, wdb,w,id,sn,cb,mat,res,noc,dir,phone,email;// JLabel declarations
	JTextField br2,tim2,dat2,place2,mod2,wdb2,id2,s2,cb2,noc2,dir2,phone2,email2,w2,res2,mat2,cl2;// JTextField declarations
	JButton print,ret,save,save2;
	JPanel f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16;
	JPanel p1= new JPanel(new GridLayout(7,1));
	JPanel p2= new JPanel(new GridLayout(6,1));
	JPanel p3= new JPanel(new GridLayout(1,2));
	JPanel pc= new JPanel(new GridLayout(4,1));
	JPanel pc2= new JPanel(new GridLayout(1,2));
	public NewWO(String title, String sec, MainDataBase mdb1) throws IOException {
		mdb=mdb1;
		setArea(title);
		setSection(sec);
		setSize(WIDTH,HEIGHT);
		setTitle(section+" "+area);
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
		create4();
		setVisible(true);
	}
	public void setMDB(MainDataBase mdb){
		this.mdb=mdb;
	}
	public void setArea(String title){
		this.area=title;
	}
	public void setSection(String sec){
		this.section=sec;
	}
	public void create4() throws IOException{
		getContentPane().setBackground(new Color(0,128,192));
		// setFonts and image label
		ImageIcon logo= new ImageIcon(NewWO.class.getClassLoader().getResource("NAPSAlogo.png"));// logo
		im= new JLabel (logo);
		cl= new JLabel("Client:");
		cl.setFont(new java.awt.Font("Console",0,30));
		br= new JLabel("Brand:");
		br.setFont(new java.awt.Font("Console",0,30));
		tim= new JLabel("Time:");
		tim.setFont(new java.awt.Font("Console",0,30));
		dat= new JLabel("Date (Day/Month/Year):");
		dat.setFont(new java.awt.Font("Console",0,30));
		place= new JLabel("Place:");
		place.setFont(new java.awt.Font("Console",0,30));
		mod= new JLabel("Model:");
		mod.setFont(new java.awt.Font("Console",0,30));
		wdb= new JLabel("Work Done By:");
		wdb.setFont(new java.awt.Font("Console",0,30));
		w= new JLabel("Work:");
		w.setFont(new java.awt.Font("Console",0,30));
		id= new JLabel("ID:");
		id.setFont(new java.awt.Font("Console",0,30));
		sn= new JLabel("Serial Number:");
		sn.setFont(new java.awt.Font("Console",0,30));
		cb= new JLabel("Certified By:");
		cb.setFont(new java.awt.Font("Console",0,30));
		mat= new JLabel("Material Used:");
		mat.setFont(new java.awt.Font("Console",0,30));
		res= new JLabel("Results:");
		res.setFont(new java.awt.Font("Console",0,30));
		noc= new JLabel("Name of the Client:");
		noc.setFont(new java.awt.Font("Console",0,30));
		dir= new JLabel("Direction:");
		dir.setFont(new java.awt.Font("Console",0,30));
		phone= new JLabel("Phone Number:");
		phone.setFont(new java.awt.Font("Console",0,30));
		email= new JLabel("E-mail:");
		email.setFont(new java.awt.Font("Console",0,30));
		cl2= new JTextField("",15);
		cl2.setFont(new java.awt.Font("Console",0,30));
		br2= new JTextField("",15);
		br2.setFont(new java.awt.Font("Console",0,30));
		tim2= new JTextField("",15);
		tim2.setFont(new java.awt.Font("Console",0,30));
		dat2= new JTextField("",7);
		dat2.setFont(new java.awt.Font("Console",0,30));
		place2= new JTextField("",15);
		place2.setFont(new java.awt.Font("Console",0,30));
		mod2= new JTextField("",15);
		mod2.setFont(new java.awt.Font("Console",0,30));
		wdb2= new JTextField("",15);
		wdb2.setFont(new java.awt.Font("Console",0,30));
		id2= new JTextField("",25);
		id2.setFont(new java.awt.Font("Console",0,30));
		cb2= new JTextField("",25);
		cb2.setFont(new java.awt.Font("Console",0,30));
		noc2= new JTextField("",25);
		noc2.setFont(new java.awt.Font("Console",0,30));
		s2= new JTextField("",25);
		s2.setFont(new java.awt.Font("Console",0,30));
		dir2= new JTextField("",15);
		dir2.setFont(new java.awt.Font("Console",0,30));
		phone2= new JTextField("",15);
		phone2.setFont(new java.awt.Font("Console",0,30));
		email2= new JTextField("",15);
		email2.setFont(new java.awt.Font("Console",0,30));
		w2= new JTextField("",25);
		w2.setFont(new java.awt.Font("Console",0,30));
		mat2= new JTextField("",25);
		mat2.setFont(new java.awt.Font("Console",0,30));
		res2= new JTextField("",25);
		res2.setFont(new java.awt.Font("Console",0,30));
		ret= new JButton ("Return");
		ret.setFont(new java.awt.Font("Console",0,30));
		save= new JButton("Save");
		save.setFont(new java.awt.Font("Console",0,30));
		save2= new JButton("Save");
		save2.setFont(new java.awt.Font("Console",0,30));
		// Panels' declaration and setBackgrounds
		f1= new JPanel(new FlowLayout());
		f1.setBackground(new Color(0,128,192));
		f2= new JPanel(new FlowLayout());
		f2.setBackground(new Color(0,128,192));
		f3= new JPanel(new FlowLayout());
		f3.setBackground(new Color(0,128,192));
		f4= new JPanel(new FlowLayout());
		f4.setBackground(new Color(0,128,192));
		f5= new JPanel(new FlowLayout());
		f5.setBackground(new Color(0,128,192));
		f6= new JPanel(new FlowLayout());
		f6.setBackground(new Color(0,128,192));
		f7= new JPanel(new FlowLayout());
		f7.setBackground(new Color(0,128,192));
		f8= new JPanel(new FlowLayout());
		f8.setBackground(new Color(0,128,192));
		f9= new JPanel(new FlowLayout());
		f9.setBackground(new Color(0,128,192));
		f10= new JPanel(new FlowLayout());
		f10.setBackground(new Color(0,128,192));
		f11= new JPanel(new FlowLayout());
		f11.setBackground(new Color(0,128,192));
		f12= new JPanel(new FlowLayout());
		f12.setBackground(new Color(0,128,192));
		f13= new JPanel(new FlowLayout());
		f13.setBackground(new Color(0,128,192));
		f14= new JPanel(new FlowLayout());
		f15= new JPanel(new FlowLayout());
		f15.setBackground(new Color(0,128,192));
		f16= new JPanel(new FlowLayout());
		f16.setBackground(new Color(0,128,192));
		add(im, BorderLayout.NORTH);
		// Area if
		if(area.equals("Clients")){
			f1.add(noc);
			f1.add(noc2);
			f2.add(dir);
			f2.add(dir2);
			f3.add(phone);
			f3.add(phone2);
			f4.add(email);
			f4.add(email2);
			f5.add(ret);
			f6.add(save2);
			pc.add(f1);
			pc.add(f2);
			pc.add(f3);
			pc.add(f4);
			pc2.add(f5);
			pc2.add(f6);
			add(pc, BorderLayout.CENTER);
			add(pc2,BorderLayout.SOUTH);
		}else if(area.equals("Non-Destructive Testing")||area.equals("Weight & Balance")||area.equals("Calibration")||area.equals("Instruments & Radio")){
			f1.add(cl);
			f1.add(cl2);
			f2.add(br);
			f2.add(br2);
			f3.add(tim);
			f3.add(tim2);
			f4.add(dat);
			f4.add(dat2);
			f5.add(place);
			f5.add(place2);
			f6.add(mod);
			f6.add(mod2);
			f7.add(wdb);
			f7.add(wdb2);
			f8.add(w);
			f8.add(w2);
			f9.add(id);
			f9.add(id2);
			f10.add(sn);
			f10.add(s2);
			f11.add(cb);
			f11.add(cb2);
			f12.add(mat);
			f12.add(mat2);
			f13.add(res);
			f13.add(res2);
			f15.add(ret);
			f16.add(save);
			p1.add(f1);
			p1.add(f2);
			p1.add(f3);
			p1.add(f4);
			p1.add(f5);
			p1.add(f6);
			p1.add(f7);
			p2.add(f8);
			p2.add(f9);
			p2.add(f10);
			p2.add(f11);
			p2.add(f12);
			p2.add(f13);
			p3.add(f15);
			p3.add(f16);
			add(p1,BorderLayout.WEST);
			add(p2,BorderLayout.CENTER);
			add(p3,BorderLayout.SOUTH);
		}
		// JButtons' Listeners
		w2.addActionListener(new Listener());
		res2.addActionListener(new Listener());
		mat2.addActionListener(new Listener());
		ret.addActionListener(new Listener());
		save.addActionListener(new Listener());
		save2.addActionListener(new Listener());
	}
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String add;
			String format = null;
			// Source if
			if(e.getSource()==ret){
				try{
					IntraMenu im= new IntraMenu(area,mdb);// return to IntraMenu
				}catch(IOException e1){
					e1.printStackTrace();
				}
				dispose();// close actual window
			}else if(e.getSource()==save){// Save Work Order
				// for to obtain the number of "/" characters in the date TextField
				int datecount = 0;
				for(int i=0;i<dat2.getText().length();i++) {
					   if(dat2.getText().charAt(i)==('/')) {
					      datecount++;
					   } 
					}
				// general if to compare if any of the TextFields are empty or if the date is not on the right format
				if(br2.getText().trim().equals("")||tim2.getText().trim().equals("")||dat2.getText().trim().equals("")||place2.getText().trim().equals("")||mod2.getText().trim().equals("")||wdb2.getText().trim().equals("")||w2.getText().trim().equals("")||id2.getText().trim().equals("")||s2.getText().trim().equals("")||cb2.getText().trim().equals("")||mat2.getText().trim().equals("")||res2.getText().trim().equals("")||datecount!=2){
					JOptionPane.showMessageDialog(null,"Some spaces were not filled, please fill them","Data",JOptionPane.WARNING_MESSAGE);
				}else{// else used to save data when it is on the right format
					int numOrd=mdb.getListSize(area);
					String ar=null;
					switch(area){
					case "Non-Destructive Testing":
						ar="NDT";
						break;
					case "Weight & Balance":
						ar="IMT";
						break;
					case "Instruments & Radio":
						ar="INS";
						break;
					case "Calibration":
						ar="CAL";
						break;
					}
					String num=ar+(numOrd+1);
					try{
						// call to the method used to save data in the temporal array lists from the MainDataBase
						mdb.AddToDataBase(br2.getText(), tim2.getText(), dat2.getText(), place2.getText(), mod2.getText(), wdb2.getText(), w2.getText(), id2.getText(), s2.getText(), cb2.getText(), mat2.getText(), res2.getText(),num,cl2.getText(),area);
						numOrd=mdb.getListSize(area);
						JOptionPane.showMessageDialog(null,"Data saved","Data",JOptionPane.INFORMATION_MESSAGE);
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Error: Data wasn´t saved","Atention",JOptionPane.WARNING_MESSAGE);
					}
					try{
						// creation of the Work Order File that will be archived in the specific folder of each Work Order Type
						String splitdate="/";
						String splittedDate[]=(dat2.getText()).split(splitdate);
						String user=System.getProperty("user.home");
						String separator= System.getProperty("file.separator");
						format="<HTML><HEAD><TITLE>Formato de Orden de Trabajo</TITLE> </HEAD>"+
								"<BODY topmargin='0' leftmargin='0' align='left' valign='top' marginheight='0' marginwidth='0'>"+
								"<DIV id='TipLayer' style='visibility:hidden;position:absolute;z-index:1000;top:-100'></DIV>"+
								"<TABLE  cellPadding=0  cellSpacing=1>"+ 
								"<TR>    <td></td>"+
								"<td></td> "+
								"<td height='200' colspan='3' align='center'></td>"+
								"</TR><TR>    <td></td> <td></td> "+
								"<td height='200' width='420' colspan='3' align='center'><font size='2' face='Calibri'>ORDEN DE TRABAJO 	PRUEBAS NO 	DESTRUCTIVAS PESO Y BALANCE DE AERONAVES (NAPSA-MPT-01)</font></td>"+
								"</TR><TR>    <td></td> <td></td> <td></td> <td></td> <td></td>"+ 
								"<td align='left'><font size='2' face='Calibri'>Num O.T.</font></td>"+
								"<td colspan='2' align='left'><font size='2' face='Calibri'>"+num+"</font></td>"+
								"</TR><TR> </TR><TR>    <td></td> <td></td> <td></td> <td></td> <td></td> "+
								"<td colspan='3' style='border:1pt solid black;' align='center'><font size='2' face='Calibri'>Fecha de 			Apertura</font></td>"+
								"</TR>   <TR>    <td></td> <td></td> <td></td> <td></td> <td></td>"+ 
								"<td align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>Dia</font></td>"+
								"<td align='left' width='140' style='border:1pt solid black;'><font size='2' face='Calibri'>Mes</font></td>"+
								"<td align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>Año</font></td>"+
								"</TR>   <TR>    <td></td> <td></td> <td></td> <td></td> <td></td> "+
								"<td align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>"+splittedDate[0]+"</font></td>"+
								"<td align='left' width='140' style='border:1pt solid black;'><font size='2' face='Calibri'>"+splittedDate[1]+"</font></td>"+
								"<td align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>"+splittedDate[2]+"</font></td>"+
								"</TR><TR> </TR><TR> 	<td></td> <td></td> <td></td> <td></td> <td></td> "+
								"<td colspan= '3' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>No. de Informe 	Emitido</font></td>"+
								"</TR>	<TR>	<td></td> <td></td> <td></td> <td></td> <td></td> "+
								"<td colspan='3' style='border:1pt solid black;'></td>"+
								"</TR> <TR></TR><TR> 	<td colspan='4' style='border:1pt solid black;' align='left'><font size='2' face='Calibri'>Compañia 		contratante</font></td>"+
								"<td colspan='4' align='left'  style='border:1pt solid black;'><font size='2' face='Calibri'>Lugar donde se efectuó 	el trabajo</font></td>"+
								"</TR><TR> 	<td colspan='4' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>"+cl2.getText()+"</font></td>"+
								"<td colspan='4' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>"+place2.getText()+"</font></td>"+
								"</TR><TR> 	</TR><TR> 	<td colspan='2' align='center'  style='border:1pt solid black;'><font size='2' 	face='Calibri'>Fabricante</font></td>"+
								"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'>Modelo</font></td>"+
								"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'>N/S</font></td>"+
								"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'>Matricula</font></td>"+
								"<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Tiempo 	Total</font></td>"+
								"<td align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Ciclos Totales</font></td>"+
								"</TR><TR> 	<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>"+br2.getText()+"</font></td>"+
								"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'>"+mod2.getText()+"</font></td>"+
								"<td align='center'width='200' style='border:1pt solid black;'><font size='2' face='Calibri'>"+s2.getText()+"</font></td>"+
								"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'>"+id2.getText()+"</font></td>"+
								"<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>"+tim2.getText()+"</font></td>"+
								"<td align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
								"</TR><TR> 	</TR><TR> 	<td colspan='8' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>Trabajo a 			efectuarse</font></td>	"+
								"</TR><TR> 	<td colspan='8' rowspan='2' align='left' style='border:1pt solid black;'><font size='2' 			face='Calibri'>"+w2.getText()+"</font></td>	"+
								"</TR><TR> 	</TR><TR> 	</TR>	<TR>	<td colspan='2' rowspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Trabajo 		efectuado por:</font></td>"+
								"<td colspan='2' rowspan='2' align='center' style='border:1pt solid black;'><font size='2' 		face='Calibri'>Certificado por:</font></td>"+
								"<td rowspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Fecha de 		efectuado</font></td>"+
								"<td colspan='2' rowspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Horas 		hombre utilizadas</font></td>"+
								"<td rowspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Tiempo 		extra</font></td>"+
								"<TR> 	</TR></TR> 	<TR>	<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>"+wdb2.getText()+"</font></td>"+
								"<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>"+cb2.getText()+"</font></td>"+
								"<td align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
								"<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
								"<td align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
								"</TR> <TR> 	</TR><TR> 	<td colspan='8' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>Resultado de la 	inspección o trabajo 		efectuado</font></td>	"+
								"</TR><TR> 	<td colspan='8' rowspan='3' align='left' style='border:1pt solid black;'><font size='2' 	face='Calibri'>"+res2.getText()+"</font></td>	"+
								"</TR><TR> 	</TR><TR> 	</TR><TR> 	</TR><TR> 	<td colspan='8' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>Material 	utilizado</font></td>	"+
								"</TR><TR> 	<td colspan='8' rowspan='2' align='left' style='border:1pt solid black;'><font size='2' 	face='Calibri'>"+mat2.getText()+"</font></td>	"+
								"</TR></table></BODY> </HTML>";
						File WorkOrderFile=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+ar+separator+(ar+numOrd)+".xls");
						if(!WorkOrderFile.exists()){
							WorkOrderFile.createNewFile();
						}
						FileWriter fwWO=new FileWriter(WorkOrderFile);
						BufferedWriter bw= new BufferedWriter(fwWO);
						bw.write(format);
						bw.close();
						JOptionPane.showMessageDialog(null,"Document successfully saved","Data",JOptionPane.INFORMATION_MESSAGE);
					}catch(Exception fileex){
						fileex.printStackTrace();
						JOptionPane.showMessageDialog(null,"Document wasn't saved","Data",JOptionPane.WARNING_MESSAGE);
					}
				}
			}else if(e.getSource()==save2){// Save Client
				try{
					// call to the method to save the data from a new client into the temporal arraylists from the MainDataBase
					mdb.AddToClientsDataBase(noc2.getText(), dir2.getText(), phone2.getText(), email2.getText());
					JOptionPane.showMessageDialog(null,"Client saved","Data",JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,"Error: Client wasn´t saved","Atention",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		
	}
}
