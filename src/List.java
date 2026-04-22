import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class List extends JFrame{
	JFrame lf= new JFrame();
	private static final int HEIGHT=1000;
	private static final int WIDTH=2500;
	public static MainDataBase mdb;
	String section,area;
	JButton ret= new JButton("Return");
	JLabel im;
	JPanel aux= new JPanel(new FlowLayout());
	String data[][];
	String[] workOrderColumnNames= new String[5];
	JScrollPane sp;
	public List(String title, String sec, MainDataBase mdb1) throws IOException {
		mdb=mdb1;
		setArea(title);
		setSection(sec);
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
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
		setTitle(section+" "+area);
		create6();
		setVisible(true);
	}
	public void setMDB(MainDataBase mdb){
		this.mdb=mdb;
	}
	public void setArea(String title){
		this.area=title;// set area
	}
	public void setSection(String sec){
		this.section=sec;// set section
	}
	public void create6() throws IOException{
		getContentPane().setBackground(new Color(0,128,192));// setFonts and image label
		ImageIcon logo= new ImageIcon(List.class.getClassLoader().getResource("NAPSAlogo.png"));// logo image
		im= new JLabel (logo);
		add(im, BorderLayout.NORTH);// add logo image in North
		data= new String[mdb.getListSize(area)][5];
		if(area.equals("Clients")){
			workOrderColumnNames[0]="Number";
			workOrderColumnNames[1]="Name of the Client";
			workOrderColumnNames[2]="Direction";
			workOrderColumnNames[3]="Phone Number";
			workOrderColumnNames[4]="E-mail";
			for(int i=0;i<5;i++){
				if(i==0){
					for(int j=0;j<mdb.getListSize(area);j++){
							data[j][i]="CLIENT-"+(j+1);
					}
				}else if(i==1){
					for(int j=0;j<mdb.getListSize(area);j++){
						data[j][i]=mdb.getName(area,j);
					}
				}else if(i==2){
					for(int j=0;j<mdb.getListSize(area);j++){
						data[j][i]=mdb.getDirection(area,j);
					}
				}else if(i==3){
					for(int j=0;j<mdb.getListSize(area);j++){
						data[j][i]=mdb.getPhone(area,j);
					}
				}else if(i==4){
					for(int j=0;j<mdb.getListSize(area);j++){
						data[j][i]=mdb.getEmail(area,j);
					}
				}
			}
		}else{
			workOrderColumnNames[0]="Number";
			workOrderColumnNames[1]="Date";
			workOrderColumnNames[2]="Model";
			workOrderColumnNames[3]="Work";
			workOrderColumnNames[4]="ID";
			for(int i=0;i<5;i++){
				if(i==0){
					for(int j=0;j<mdb.getListSize(area);j++){
						data[j][i]=mdb.getNumber(area,j);
					}
				}else if(i==1){
					for(int j=0;j<mdb.getListSize(area);j++){
						data[j][i]=mdb.getDates(area,j);
					}
				}else if(i==2){
					for(int j=0;j<mdb.getListSize(area);j++){
						data[j][i]=mdb.getModel(area,j);
					}
				}else if(i==3){
					for(int j=0;j<mdb.getListSize(area);j++){
						data[j][i]=mdb.getWork(area,j);
					}
				}else if(i==4){
					for(int j=0;j<mdb.getListSize(area);j++){
						data[j][i]=mdb.getID(area,j);
					}
				}
			}
		}
		final JTable generictable= new JTable(data, workOrderColumnNames);
		generictable.setFont(new java.awt.Font("Console",0,30));
		generictable.setFillsViewportHeight(true);
		generictable.setEnabled(false);
		generictable.setRowHeight(60);
		generictable.getTableHeader().setPreferredSize(new Dimension(10,60));
		generictable.getTableHeader().setFont(new java.awt.Font("Console",0,30));
		generictable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==1){
					String ar = null;
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
					int row = generictable.rowAtPoint(e.getPoint());
					if(row==(-1)){
						JOptionPane.showMessageDialog(null,"Please, select a valid File from the table","Data",JOptionPane.WARNING_MESSAGE);
					}
					String numOrd=(String) generictable.getValueAt(row, 0);
					String user=System.getProperty("user.home");
					String separator= System.getProperty("file.separator");
					try{
						String splitdate="/";
						String splittedDate[]=(mdb.getDates(area, row)).split(splitdate);
						String format="<HTML><HEAD><TITLE>Formato de Orden de Trabajo</TITLE> </HEAD>"+
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
								"<td colspan='2' align='left'><font size='2' face='Calibri'>"+numOrd+"</font></td>"+
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
								"</TR><TR> 	<td colspan='4' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>"+mdb.getClient(area,row)+"</font></td>"+
								"<td colspan='4' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>"+mdb.getPlaces(area, row)+"</font></td>"+
								"</TR><TR> 	</TR><TR> 	<td colspan='2' align='center'  style='border:1pt solid black;'><font size='2' 	face='Calibri'>Fabricante</font></td>"+
								"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'>Modelo</font></td>"+
								"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'>N/S</font></td>"+
								"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'>Matricula</font></td>"+
								"<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Tiempo 	Total</font></td>"+
								"<td align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Ciclos Totales</font></td>"+
								"</TR><TR> 	<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>"+mdb.getBrand(area, row)+"</font></td>"+
								"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'>"+mdb.getModel(area, row)+"</font></td>"+
								"<td align='center'width='200' style='border:1pt solid black;'><font size='2' face='Calibri'></font>"+mdb.getSerialN(area, row)+"</td>"+
								"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'></font>"+mdb.getID(area, row)+"</td>"+
								"<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font>"+mdb.getTime(area, row)+"</td>"+
								"<td align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
								"</TR><TR> 	</TR><TR> 	<td colspan='8' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>Trabajo a 			efectuarse</font></td>	"+
								"</TR><TR> 	<td colspan='8' rowspan='2' align='left' style='border:1pt solid black;'><font size='2' 			face='Calibri'>"+mdb.getWork(area, row)+"</font></td>	"+
								"</TR><TR> 	</TR><TR> 	</TR>	<TR>	<td colspan='2' rowspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Trabajo 		efectuado por:</font></td>"+
								"<td colspan='2' rowspan='2' align='center' style='border:1pt solid black;'><font size='2' 		face='Calibri'>Certificado por:</font></td>"+
								"<td rowspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Fecha de 		efectuado</font></td>"+
								"<td colspan='2' rowspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Horas 		hombre utilizadas</font></td>"+
								"<td rowspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Tiempo 		extra</font></td>"+
								"<TR> 	</TR></TR> 	<TR>	<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>"+mdb.getWDB(area, row)+"</font></td>"+
								"<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>"+mdb.getCertby(area, row)+"</font></td>"+
								"<td align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
								"<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
								"<td align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
								"</TR> <TR> 	</TR><TR> 	<td colspan='8' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>Resultado de la 	inspección o trabajo 		efectuado</font></td>	"+
								"</TR><TR> 	<td colspan='8' rowspan='3' align='left' style='border:1pt solid black;'><font size='2' 	face='Calibri'>"+mdb.getResult(area, row)+"</font></td>	"+
								"</TR><TR> 	</TR><TR> 	</TR><TR> 	</TR><TR> 	<td colspan='8' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>Material 	utilizado</font></td>	"+
								"</TR><TR> 	<td colspan='8' rowspan='2' align='left' style='border:1pt solid black;'><font size='2' 	face='Calibri'>"+mdb.getMaterial(area, row)+"</font></td>	"+
								"</TR></table></BODY> </HTML>";
						File WorkOrderFile=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+ar+separator+(numOrd)+".xls");
						if(!WorkOrderFile.exists()){
							WorkOrderFile.createNewFile();
							FileWriter fwWO=new FileWriter(WorkOrderFile);
							BufferedWriter bw= new BufferedWriter(fwWO);
							bw.write(format);
							bw.close();
							JOptionPane.showMessageDialog(null,"Document successfully saved","Data",JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null,"Document already exists","Data",JOptionPane.WARNING_MESSAGE);
						}
					}catch(Exception exception){
						exception.printStackTrace();
						JOptionPane.showMessageDialog(null,"Error while creating the document","Data",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		sp= new JScrollPane(generictable);
		aux.add(ret);
		aux.setBackground(new Color(0,128,192));
		ret.setFont(new java.awt.Font("Console",0,30));
		add(sp, BorderLayout.CENTER);
		add(aux, BorderLayout.SOUTH);
		ret.addActionListener(new Listener());
	}
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				IntraMenu im= new IntraMenu(area,mdb);// return to IntraMenu
				dispose();
			}catch(IOException e1){
				e1.printStackTrace();
			}
		}
	}
}
