import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.*;
public class MainDataBase{
	//Array Lists of NDT------->
	public static ArrayList <String> brand1;
	public static ArrayList <String> time1;
	public static ArrayList <String> date1;
	public static ArrayList <String> place1;
	public static ArrayList <String> model1;
	public static ArrayList <String> wdb1;
	public static ArrayList <String> work1;
	public static ArrayList <String> id1;
	public static ArrayList <String> sn1;
	public static ArrayList <String> cerby1;
	public static ArrayList <String> matused1;
	public static ArrayList <String> results1;
	public static ArrayList <String> number1;
	public static ArrayList <String> client1;
	//Array Lists of W&B------->
	public static ArrayList <String> brand2;
	public static ArrayList <String> time2;
	public static ArrayList <String> date2;
	public static ArrayList <String> place2;
	public static ArrayList <String> model2;
	public static ArrayList <String> wdb2;
	public static ArrayList <String> work2;
	public static ArrayList <String> id2;
	public static ArrayList <String> sn2;
	public static ArrayList <String> cerby2;
	public static ArrayList <String> matused2;
	public static ArrayList <String> results2;
	public static ArrayList <String> number2;
	public static ArrayList <String> client2;
	//Array Lists of Ins & Radio------->
	public static ArrayList <String> brand3;
	public static ArrayList <String> time3;
	public static ArrayList <String> date3;
	public static ArrayList <String> place3;
	public static ArrayList <String> model3;
	public static ArrayList <String> wdb3;
	public static ArrayList <String> work3;
	public static ArrayList <String> id3;
	public static ArrayList <String> sn3;
	public static ArrayList <String> cerby3;
	public static ArrayList <String> matused3;
	public static ArrayList <String> results3;
	public static ArrayList <String> number3;
	public static ArrayList <String> client3;
	//Array Lists of Calibration------->
	public static ArrayList <String> brand4;
	public static ArrayList <String> time4;
	public static ArrayList <String> date4;
	public static ArrayList <String> place4;
	public static ArrayList <String> model4;
	public static ArrayList <String> wdb4;
	public static ArrayList <String> work4;
	public static ArrayList <String> id4;
	public static ArrayList <String> sn4;
	public static ArrayList <String> cerby4;
	public static ArrayList <String> matused4;
	public static ArrayList <String> results4;
	public static ArrayList <String> number4;
	public static ArrayList <String> client4;
	//Array Lists of Clients------->
	public static ArrayList <String> nameclient;
	public static ArrayList <String> direction;
	public static ArrayList <String> phonenumber;
	public static ArrayList <String> email;
	//Array of Each main Database
	public static ArrayList[] NonDestructiveTesting= {brand1, time1, date1, place1, model1, wdb1, work1,id1, sn1, cerby1, matused1, results1,number1,client1};
	public static ArrayList[] WeightAndBalance= {brand2, time2, date2, place2, model2, wdb2, work2,id2, sn2, cerby2, matused2, results2,number2,client2};
	public static ArrayList[] InstrumentsAndRadio= {brand3, time3, date3, place3, model3, wdb3, work3,id3, sn3, cerby3, matused3, results3,number3,client3};
	public static ArrayList[] Calibration= {brand4, time4, date4, place4, model4, wdb4, work4,id4, sn4, cerby4, matused4, results4,number4,client4};
	public static ArrayList[] Clients={nameclient,direction,phonenumber,email};
	/*Add Methods
	 * 	- Add Non Destructive Testing Data
	 * 	- Add Weight and Balance Data
	 * 	- Add Instruments and Radio Data	
	 * 	- Add Calibration Data
	 * 	- Add Clients Data
	 */
	public String user=System.getProperty("user.home");
	public String separator= System.getProperty("file.separator");
	public MainDataBase(){
		for(int i=0;i<NonDestructiveTesting.length;i++){
			NonDestructiveTesting[i]= new ArrayList<String>();
		}
		for(int i=0;i<WeightAndBalance.length;i++){
			WeightAndBalance[i]= new ArrayList<>();
		}
		for(int i=0;i<InstrumentsAndRadio.length;i++){
			InstrumentsAndRadio[i]= new ArrayList<>();
		}
		for(int i=0;i<Calibration.length;i++){
			Calibration[i]= new ArrayList<>();
		}
		for(int i=0;i<Clients.length;i++){
			Clients[i]= new ArrayList<>();
		}
	}
	public void RecieveBackup() throws IOException{
		// Creation of Folders used to to keep the archives that the program will create
		//Creation of the csv documents that will save the data
		File PrincipalFolder=new File(user+separator+"Desktop"+separator+"Work Orders");
		if(!PrincipalFolder.exists()){
			PrincipalFolder.mkdir();
			File NDTFolder=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"NDT");
			if(!NDTFolder.exists()){
				NDTFolder.mkdir();
			}
			File IMTFolder=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"IMT");
			if(!IMTFolder.exists()){
				IMTFolder.mkdir();
			}
			File CALFolder=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"CAL");
			if(!CALFolder.exists()){
				CALFolder.mkdir();
			}
			File INSFolder=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"INS");
			if(!INSFolder.exists()){
				INSFolder.mkdir();
			}
			File SourceFolder=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source");
			if(!SourceFolder.exists()){
				SourceFolder.mkdir();
				File Database=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database");
				if(!Database.exists()){
					Database.mkdir();
					File Databaseexcel1=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseNDT.csv");
					if(!Databaseexcel1.exists()){
						Databaseexcel1.createNewFile();
					}
					File Databaseexcel2=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseIMT.csv");
					if(!Databaseexcel2.exists()){
						Databaseexcel2.createNewFile();
					}
					File Databaseexcel3=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseINS.csv");
					if(!Databaseexcel3.exists()){
						Databaseexcel3.createNewFile();
					}
					File Databaseexcel4=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseCAL.csv");
					if(!Databaseexcel4.exists()){
						Databaseexcel4.createNewFile();
					}
					File Databaseexcel5=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseCLIENTS.csv");
					if(!Databaseexcel5.exists()){
						Databaseexcel5.createNewFile();
					}
				}
				File Format=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Format");
				if(!Format.exists()){
					Format.mkdir();
					String form="<HTML><HEAD><TITLE>Formato de Orden de Trabajo</TITLE> </HEAD>"+
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
							"<td colspan='2' align='left'><font size='2' face='Calibri'></font></td>"+
							"</TR><TR> </TR><TR>    <td></td> <td></td> <td></td> <td></td> <td></td> "+
							"<td colspan='3' style='border:1pt solid black;' align='center'><font size='2' face='Calibri'>Fecha de 			Apertura</font></td>"+
							"</TR>   <TR>    <td></td> <td></td> <td></td> <td></td> <td></td>"+ 
							"<td align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>Dia</font></td>"+
							"<td align='left' width='140' style='border:1pt solid black;'><font size='2' face='Calibri'>Mes</font></td>"+
							"<td align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>Año</font></td>"+
							"</TR>   <TR>    <td></td> <td></td> <td></td> <td></td> <td></td> "+
							"<td align='left' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"<td align='left' width='140' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"<td align='left' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"</TR><TR> </TR><TR> 	<td></td> <td></td> <td></td> <td></td> <td></td> "+
							"<td colspan= '3' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>No. de Informe 	Emitido</font></td>"+
							"</TR>	<TR>	<td></td> <td></td> <td></td> <td></td> <td></td> "+
							"<td colspan='3' style='border:1pt solid black;'></td>"+
							"</TR> <TR></TR><TR> 	<td colspan='4' style='border:1pt solid black;' align='left'><font size='2' face='Calibri'>Compañia 		contratante</font></td>"+
							"<td colspan='4' align='left'  style='border:1pt solid black;'><font size='2' face='Calibri'>Lugar donde se efectuó 	el trabajo</font></td>"+
							"</TR><TR> 	<td colspan='4' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"<td colspan='4' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"</TR><TR> 	</TR><TR> 	<td colspan='2' align='center'  style='border:1pt solid black;'><font size='2' 	face='Calibri'>Fabricante</font></td>"+
							"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'>Modelo</font></td>"+
							"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'>N/S</font></td>"+
							"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'>Matricula</font></td>"+
							"<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Tiempo 	Total</font></td>"+
							"<td align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Ciclos Totales</font></td>"+
							"</TR><TR> 	<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"<td align='center'width='200' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"<td align='center' width='200' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"<td align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"</TR><TR> 	</TR><TR> 	<td colspan='8' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>Trabajo a 			efectuarse</font></td>	"+
							"</TR><TR> 	<td colspan='8' rowspan='2' align='left' style='border:1pt solid black;'><font size='2' 			face='Calibri'></font></td>	"+
							"</TR><TR> 	</TR><TR> 	</TR>	<TR>	<td colspan='2' rowspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Trabajo 		efectuado por:</font></td>"+
							"<td colspan='2' rowspan='2' align='center' style='border:1pt solid black;'><font size='2' 		face='Calibri'>Certificado por:</font></td>"+
							"<td rowspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Fecha de 		efectuado</font></td>"+
							"<td colspan='2' rowspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Horas 		hombre utilizadas</font></td>"+
							"<td rowspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'>Tiempo 		extra</font></td>"+
							"<TR> 	</TR></TR> 	<TR>	<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"<td align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"<td colspan='2' align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"<td align='center' style='border:1pt solid black;'><font size='2' face='Calibri'></font></td>"+
							"</TR> <TR> 	</TR><TR> 	<td colspan='8' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>Resultado de la 	inspección o trabajo 		efectuado</font></td>	"+
							"</TR><TR> 	<td colspan='8' rowspan='3' align='left' style='border:1pt solid black;'><font size='2' 	face='Calibri'></font></td>	"+
							"</TR><TR> 	</TR><TR> 	</TR><TR> 	</TR><TR> 	<td colspan='8' align='left' style='border:1pt solid black;'><font size='2' face='Calibri'>Material 	utilizado</font></td>	"+
							"</TR><TR> 	<td colspan='8' rowspan='2' align='left' style='border:1pt solid black;'><font size='2' 	face='Calibri'></font></td>	"+
							"</TR></table></BODY> </HTML>";
					File WorkOrderFormat=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Format"+separator+"Work Order Format.xls");
					if(!WorkOrderFormat.exists()){
						WorkOrderFormat.createNewFile();
					}
					FileWriter fw=new FileWriter(WorkOrderFormat);
					BufferedWriter bw= new BufferedWriter(fw);
					bw.write(form);
					bw.close();
				}
			}
		}else{
			File getNDT= new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseNDT.csv");
			File getIMT= new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseIMT.csv");
			File getINS= new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseINS.csv");
			File getCAL= new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseCAL.csv");
			File getCLIENTS= new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseCLIENTS.csv");
			if(!getNDT.exists()||!getIMT.exists()||!getINS.exists()||!getCAL.exists()||!getCLIENTS.exists()){
				getNDT= new File(user+separator+"DatabaseBackupNDT.csv");
				getIMT= new File(user+separator+"DatabaseBackupIMT.csv");
				getINS= new File(user+separator+"DatabaseBackupINS.csv");
				getCAL= new File(user+separator+"DatabaseBackupCAL.csv");
				getCLIENTS= new File(user+separator+"DatabaseBackupCLIENTS.csv");
				getNDT.renameTo(new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseNDT.csv"));
				getIMT.renameTo(new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseIMT.csv"));
				getINS.renameTo(new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseINS.csv"));
				getCAL.renameTo(new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseCAL.csv"));
				getCLIENTS.renameTo(new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseCLIENTS.csv"));
				getNDT= new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseNDT.csv");
				getIMT= new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseIMT.csv");
				getINS= new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseINS.csv");
				getCAL= new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseCAL.csv");
				getCLIENTS= new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseCLIENTS.csv");
			}
			FileInputStream fNDT= new FileInputStream(getNDT);
			DataInputStream iNDT= new DataInputStream(fNDT);
			String NDTData;
			BufferedReader scanNDT= new BufferedReader(new InputStreamReader(iNDT));
			FileInputStream fIMT= new FileInputStream(getIMT);
			DataInputStream iIMT= new DataInputStream(fIMT);
			String IMTData;
			BufferedReader scanIMT= new BufferedReader(new InputStreamReader(iIMT));
			FileInputStream fINS= new FileInputStream(getINS);
			DataInputStream iINS= new DataInputStream(fINS);
			String INSData;
			BufferedReader scanINS= new BufferedReader(new InputStreamReader(iINS));
			FileInputStream fCAL= new FileInputStream(getCAL);
			DataInputStream iCAL= new DataInputStream(fCAL);
			String CALData;
			BufferedReader scanCAL= new BufferedReader(new InputStreamReader(iCAL));
			FileInputStream fCLIENTS= new FileInputStream(getCLIENTS);
			DataInputStream iCLIENTS= new DataInputStream(fCLIENTS);
			String CLIENTSData;
			BufferedReader scanCLIENTS= new BufferedReader(new InputStreamReader(iCLIENTS));
			while((NDTData=scanNDT.readLine())!=null){
				String a[]=NDTData.split(",");
				NonDestructiveTesting[0].add(a[1]);
				NonDestructiveTesting[1].add(a[2]);
				NonDestructiveTesting[2].add(a[3]);
				NonDestructiveTesting[3].add(a[4]);
				NonDestructiveTesting[4].add(a[5]);
				NonDestructiveTesting[5].add(a[6]);
				NonDestructiveTesting[6].add(a[7]);
				NonDestructiveTesting[7].add(a[8]);
				NonDestructiveTesting[8].add(a[9]);
				NonDestructiveTesting[9].add(a[10]);
				NonDestructiveTesting[10].add(a[11]);
				NonDestructiveTesting[11].add(a[12]);
				NonDestructiveTesting[12].add(a[0]);
				NonDestructiveTesting[13].add(a[13]);
			}
			scanNDT.close();
			while((IMTData=scanIMT.readLine())!=null){
				String a[]=IMTData.split(",");
				WeightAndBalance[0].add(a[1]);
				WeightAndBalance[1].add(a[2]);
				WeightAndBalance[2].add(a[3]);
				WeightAndBalance[3].add(a[4]);
				WeightAndBalance[4].add(a[5]);
				WeightAndBalance[5].add(a[6]);
				WeightAndBalance[6].add(a[7]);
				WeightAndBalance[7].add(a[8]);
				WeightAndBalance[8].add(a[9]);
				WeightAndBalance[9].add(a[10]);
				WeightAndBalance[10].add(a[11]);
				WeightAndBalance[11].add(a[12]);
				WeightAndBalance[12].add(a[0]);
				WeightAndBalance[13].add(a[13]);
			}
			scanIMT.close();
			while((INSData=scanINS.readLine())!=null){
				String a[]=INSData.split(",");
				InstrumentsAndRadio[0].add(a[1]);
				InstrumentsAndRadio[1].add(a[2]);
				InstrumentsAndRadio[2].add(a[3]);
				InstrumentsAndRadio[3].add(a[4]);
				InstrumentsAndRadio[4].add(a[5]);
				InstrumentsAndRadio[5].add(a[6]);
				InstrumentsAndRadio[6].add(a[7]);
				InstrumentsAndRadio[7].add(a[8]);
				InstrumentsAndRadio[8].add(a[9]);
				InstrumentsAndRadio[9].add(a[10]);
				InstrumentsAndRadio[10].add(a[11]);
				InstrumentsAndRadio[11].add(a[12]);
				InstrumentsAndRadio[12].add(a[0]);
				InstrumentsAndRadio[13].add(a[13]);
			}
			scanINS.close();
			while((CALData=scanCAL.readLine())!=null){
				String a[]=CALData.split(",");
				Calibration[0].add(a[1]);
				Calibration[1].add(a[2]);
				Calibration[2].add(a[3]);
				Calibration[3].add(a[4]);
				Calibration[4].add(a[5]);
				Calibration[5].add(a[6]);
				Calibration[6].add(a[7]);
				Calibration[7].add(a[8]);
				Calibration[8].add(a[9]);
				Calibration[9].add(a[10]);
				Calibration[10].add(a[11]);
				Calibration[11].add(a[12]);
				Calibration[12].add(a[0]);
				Calibration[13].add(a[13]);
			}
			scanCAL.close();
			while((CLIENTSData=scanCLIENTS.readLine())!=null){
				String a[]=CLIENTSData.split(",");
				Clients[0].add(a[0]);
				Clients[1].add(a[1]);
				Clients[2].add(a[2]);
				Clients[3].add(a[3]);
			}
			scanCLIENTS.close();
		}
	}
	// Method to add data
	public void AddToDataBase(String brand, String time, String date, String place, String model, String wdb, String work, String id, String sn, String cerby, String matused, String results, String number, String client, String section) throws IOException{
		switch(section){
		case "Non-Destructive Testing":
			NonDestructiveTesting[0].add(brand);
			NonDestructiveTesting[1].add(time);
			NonDestructiveTesting[2].add(date);
			NonDestructiveTesting[3].add(place);
			NonDestructiveTesting[4].add(model);
			NonDestructiveTesting[5].add(wdb);
			NonDestructiveTesting[6].add(work);
			NonDestructiveTesting[7].add(id);
			NonDestructiveTesting[8].add(sn);
			NonDestructiveTesting[9].add(cerby);
			NonDestructiveTesting[10].add(matused);
			NonDestructiveTesting[11].add(results);
			NonDestructiveTesting[12].add(number);
			NonDestructiveTesting[13].add(client);
			break;
		case "Weight & Balance":
			WeightAndBalance[0].add(brand);
			WeightAndBalance[1].add(time);
			WeightAndBalance[2].add(date);
			WeightAndBalance[3].add(place);
			WeightAndBalance[4].add(model);
			WeightAndBalance[5].add(wdb);
			WeightAndBalance[6].add(work);
			WeightAndBalance[7].add(id);
			WeightAndBalance[8].add(sn);
			WeightAndBalance[9].add(cerby);
			WeightAndBalance[10].add(matused);
			WeightAndBalance[11].add(results);
			WeightAndBalance[12].add(number);
			WeightAndBalance[13].add(client);
			break;
		case "Instruments & Radio":
			InstrumentsAndRadio[0].add(brand);
			InstrumentsAndRadio[1].add(time);
			InstrumentsAndRadio[2].add(date);
			InstrumentsAndRadio[3].add(place);
			InstrumentsAndRadio[4].add(model);
			InstrumentsAndRadio[5].add(wdb);
			InstrumentsAndRadio[6].add(work);
			InstrumentsAndRadio[7].add(id);
			InstrumentsAndRadio[8].add(sn);
			InstrumentsAndRadio[9].add(cerby);
			InstrumentsAndRadio[10].add(matused);
			InstrumentsAndRadio[11].add(results);
			InstrumentsAndRadio[12].add(number);
			InstrumentsAndRadio[13].add(client);
			break;
		case "Calibration":
			Calibration[0].add(brand);
			Calibration[1].add(time);
			Calibration[2].add(date);
			Calibration[3].add(place);
			Calibration[4].add(model);
			Calibration[5].add(wdb);
			Calibration[6].add(work);
			Calibration[7].add(id);
			Calibration[8].add(sn);
			Calibration[9].add(cerby);
			Calibration[10].add(matused);
			Calibration[11].add(results);
			Calibration[12].add(number);
			Calibration[13].add(client);
			break;
		}
	}
	//method to add client data
	public void AddToClientsDataBase(String nam, String direc, String phonenum, String eml){
			Clients[0].add(nam);
			Clients[1].add(direc);
			Clients[2].add(phonenum);
			Clients[3].add(eml);
	}
	//method to get data to be used in the list
	public String getBrand(String section, int index){
		String gbrand = null;
		switch(section){
		case "Non-Destructive Testing":
			gbrand=(String) NonDestructiveTesting[0].get(index);
			break;
		case "Weight & Balance":
			gbrand=(String) WeightAndBalance[0].get(index);
			break;
		case "Instruments & Radio":
			gbrand=(String) InstrumentsAndRadio[0].get(index);
			break;
		case "Calibration":
			gbrand=(String) Calibration[0].get(index);
			break;
		}
		return gbrand;
	}
	public String getTime(String section, int index){
		String timeused = null;
		switch(section){
		case "Non-Destructive Testing":
			timeused=(String) NonDestructiveTesting[1].get(index);
			break;
		case "Weight & Balance":
			timeused=(String) WeightAndBalance[1].get(index);
			break;
		case "Instruments & Radio":
			timeused=(String) InstrumentsAndRadio[1].get(index);
			break;
		case "Calibration":
			timeused=(String) Calibration[1].get(index);
			break;
		}
		return timeused;
	}
	public String getDates(String section, int index){
		String dates = null;
		switch(section){
		case "Non-Destructive Testing":
			dates=(String) NonDestructiveTesting[2].get(index);
			break;
		case "Weight & Balance":
			dates=(String) WeightAndBalance[2].get(index);
			break;
		case "Instruments & Radio":
			dates=(String) InstrumentsAndRadio[2].get(index);
			break;
		case "Calibration":
			dates=(String) Calibration[2].get(index);
			break;
		}
		return dates;
	}
	public String getPlaces(String section, int index){
		String places = null;
		switch(section){
		case "Non-Destructive Testing":
			places=(String) NonDestructiveTesting[3].get(index);
			break;
		case "Weight & Balance":
			places=(String) WeightAndBalance[3].get(index);
			break;
		case "Instruments & Radio":
			places=(String) InstrumentsAndRadio[3].get(index);
			break;
		case "Calibration":
			places=(String) Calibration[3].get(index);
			break;
		}
		return places;
	}
	public String getModel(String section, int index){
		String model = null;
		switch(section){
		case "Non-Destructive Testing":
			model=(String) NonDestructiveTesting[4].get(index);
			break;
		case "Weight & Balance":
			model=(String) WeightAndBalance[4].get(index);
			break;
		case "Instruments & Radio":
			model=(String) InstrumentsAndRadio[4].get(index);
			break;
		case "Calibration":
			model=(String) Calibration[4].get(index);
			break;
		}
		return model;
	}
	public String getWDB(String section, int index){
		String workdoneby = null;
		switch(section){
		case "Non-Destructive Testing":
			workdoneby=(String) NonDestructiveTesting[5].get(index);
			break;
		case "Weight & Balance":
			workdoneby=(String) WeightAndBalance[5].get(index);
			break;
		case "Instruments & Radio":
			workdoneby=(String) InstrumentsAndRadio[5].get(index);
			break;
		case "Calibration":
			workdoneby=(String) Calibration[5].get(index);
			break;
		}
		return workdoneby;
	}
	public String getWork(String section,int index){
		String work = null;
		switch(section){
		case "Non-Destructive Testing":
			work=(String) NonDestructiveTesting[6].get(index);
			break;
		case "Weight & Balance":
			work=(String) WeightAndBalance[6].get(index);
			break;
		case "Instruments & Radio":
			work=(String) InstrumentsAndRadio[6].get(index);
			break;
		case "Calibration":
			work=(String) Calibration[6].get(index);
			break;
		}
		return work;
	}
	public String getID(String section, int index){
		String ID = null;
		switch(section){
		case "Non-Destructive Testing":
			ID=(String) NonDestructiveTesting[7].get(index);
			break;
		case "Weight & Balance":
			ID=(String) WeightAndBalance[7].get(index);
			break;
		case "Instruments & Radio":
			ID=(String) InstrumentsAndRadio[7].get(index);
			break;
		case "Calibration":
			ID=(String) Calibration[7].get(index);
			break;
		}
		return ID;
	}
	public String getSerialN(String section, int index){
		String sns = null;
		switch(section){
		case "Non-Destructive Testing":
			sns=(String) NonDestructiveTesting[8].get(index);
			break;
		case "Weight & Balance":
			sns=(String) WeightAndBalance[8].get(index);
			break;
		case "Instruments & Radio":
			sns=(String) InstrumentsAndRadio[8].get(index);
			break;
		case "Calibration":
			sns=(String) Calibration[8].get(index);
			break;
		}
		return sns;
	}
	public String getCertby(String section, int index){
		String certby = null;
		switch(section){
		case "Non-Destructive Testing":
			certby=(String) NonDestructiveTesting[9].get(index);
			break;
		case "Weight & Balance":
			certby=(String) WeightAndBalance[9].get(index);
			break;
		case "Instruments & Radio":
			certby=(String) InstrumentsAndRadio[9].get(index);
			break;
		case "Calibration":
			certby=(String) Calibration[9].get(index);
			break;
		}
		return certby;
	}
	public String getMaterial(String section, int index){
		String material = null;
		switch(section){
		case "Non-Destructive Testing":
			material=(String) NonDestructiveTesting[10].get(index);
			break;
		case "Weight & Balance":
			material=(String) WeightAndBalance[10].get(index);
			break;
		case "Instruments & Radio":
			material=(String) InstrumentsAndRadio[10].get(index);
			break;
		case "Calibration":
			material=(String) Calibration[10].get(index);
			break;
		}
		return material;
	}
	public String getResult(String section, int index){
		String results = null;
		switch(section){
		case "Non-Destructive Testing":
			results=(String) NonDestructiveTesting[11].get(index);
			break;
		case "Weight & Balance":
			results=(String) WeightAndBalance[11].get(index);
			break;
		case "Instruments & Radio":
			results=(String) InstrumentsAndRadio[11].get(index);
			break;
		case "Calibration":
			results=(String) Calibration[11].get(index);
			break;
		}
		return results;
	}
	public String getNumber(String section, int index){
		String number = null;
		switch(section){
		case "Non-Destructive Testing":
			number=(String) NonDestructiveTesting[12].get(index);
			break;
		case "Weight & Balance":
			number=(String) WeightAndBalance[12].get(index);
			break;
		case "Instruments & Radio":
			number=(String) InstrumentsAndRadio[12].get(index);
			break;
		case "Calibration":
			number=(String) Calibration[12].get(index);
			break;
		}
		return number;
	}
	public String getClient(String section, int index){
		String clients = null;
		switch(section){
		case "Non-Destructive Testing":
			clients=(String) NonDestructiveTesting[13].get(index);
			break;
		case "Weight & Balance":
			clients=(String) WeightAndBalance[13].get(index);
			break;
		case "Instruments & Radio":
			clients=(String) InstrumentsAndRadio[13].get(index);
			break;
		case "Calibration":
			clients=(String) Calibration[13].get(index);
			break;
		}
		return clients;
	}
	public String getName(String section, int index){
		String clname = null;
		clname=(String) Clients[0].get(index);
		return clname;
	}
	public String getPhone(String section, int index){
		String ph = null;
		ph=(String) Clients[2].get(index);
		return ph;
	}
	public String getDirection(String section, int index){
		String dir = null;
		dir= (String) Clients[1].get(index);
		return dir;
	}
	public String getEmail(String section, int index){
		String em = null;
		em=(String) Clients[3].get(index);
		return em;
	}
	// Method used to get the size of the lists 
	public int getListSize(String section){
		int s=0;
		switch(section){
		case "Non-Destructive Testing":
			s=NonDestructiveTesting[1].size();
			break;
		case "Weight & Balance":
			s=WeightAndBalance[1].size();
			break;
		case "Instruments & Radio":
			s=InstrumentsAndRadio[1].size();
			break;
		case "Calibration":
			s=Calibration[1].size();
			break;
		case "Clients":
			s=Clients[1].size();
		}
		return s;
	}
	public void SaveAllData() throws IOException{
		//NDT
		File DatabaseNDT=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseNDT.csv");
		FileWriter fwNDT=new FileWriter(DatabaseNDT);
		for(int i=0;i<NonDestructiveTesting[1].size();i++){
			fwNDT.append((CharSequence) ((String) NonDestructiveTesting[12].get(i)).replaceAll(" ","+"));
			fwNDT.append(',');
			fwNDT.append((CharSequence) NonDestructiveTesting[0].get(i));
			fwNDT.append(',');
			fwNDT.append((CharSequence) NonDestructiveTesting[1].get(i));
			fwNDT.append(',');
			fwNDT.append((CharSequence) NonDestructiveTesting[2].get(i));
			fwNDT.append(',');
			fwNDT.append((CharSequence) NonDestructiveTesting[3].get(i));
			fwNDT.append(',');
			fwNDT.append((CharSequence) NonDestructiveTesting[4].get(i));
			fwNDT.append(',');
			fwNDT.append((CharSequence) NonDestructiveTesting[5].get(i));
			fwNDT.append(',');
			fwNDT.append((CharSequence) NonDestructiveTesting[6].get(i));
			fwNDT.append(',');
			fwNDT.append((CharSequence) NonDestructiveTesting[7].get(i));
			fwNDT.append(',');
			fwNDT.append((CharSequence) NonDestructiveTesting[8].get(i));
			fwNDT.append(',');
			fwNDT.append((CharSequence) NonDestructiveTesting[9].get(i));
			fwNDT.append(',');
			fwNDT.append((CharSequence) NonDestructiveTesting[10].get(i));
			fwNDT.append(',');
			fwNDT.append((CharSequence) NonDestructiveTesting[11].get(i));
			fwNDT.append(',');
			fwNDT.append((CharSequence) NonDestructiveTesting[13].get(i));
			fwNDT.append("\n");
		}
		fwNDT.flush();
		fwNDT.close();
		String sourceString= new String(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseNDT.csv");
		String destString= new String(user+separator+"DatabaseBackupNDT.csv");
		Path source= Paths.get(sourceString);
		Path destination = Paths.get(destString);
		Copy(source,destination,sourceString,destString);
		//IMT
		File DatabaseIMT=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseIMT.csv");
		if(!DatabaseIMT.exists()){
			DatabaseIMT.createNewFile();
		}
		FileWriter fwIMT=new FileWriter(DatabaseIMT);
		for(int i=0;i<WeightAndBalance[1].size();i++){
			fwIMT.append((CharSequence) WeightAndBalance[12].get(i));
			fwIMT.append(',');
			fwIMT.append((CharSequence) WeightAndBalance[0].get(i));
			fwIMT.append(',');
			fwIMT.append((CharSequence) WeightAndBalance[1].get(i));
			fwIMT.append(',');
			fwIMT.append((CharSequence) WeightAndBalance[2].get(i));
			fwIMT.append(',');
			fwIMT.append((CharSequence) WeightAndBalance[3].get(i));
			fwIMT.append(',');
			fwIMT.append((CharSequence) WeightAndBalance[4].get(i));
			fwIMT.append(',');
			fwIMT.append((CharSequence) WeightAndBalance[5].get(i));
			fwIMT.append(',');
			fwIMT.append((CharSequence) WeightAndBalance[6].get(i));
			fwIMT.append(',');
			fwIMT.append((CharSequence) WeightAndBalance[7].get(i));
			fwIMT.append(',');
			fwIMT.append((CharSequence) WeightAndBalance[8].get(i));
			fwIMT.append(',');
			fwIMT.append((CharSequence) WeightAndBalance[9].get(i));
			fwIMT.append(',');
			fwIMT.append((CharSequence) WeightAndBalance[10].get(i));
			fwIMT.append(',');
			fwIMT.append((CharSequence) WeightAndBalance[11].get(i));
			fwIMT.append(',');
			fwIMT.append((CharSequence) WeightAndBalance[13].get(i));
			fwIMT.append("\n");
		}
		fwIMT.flush();
		fwIMT.close();
		String sourceString2= new String(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseIMT.csv");
		String destString2= new String(user+separator+"DatabaseBackupIMT.csv");
		Path source2= Paths.get(sourceString2);
		Path destination2 = Paths.get(destString2);
		Copy(source2, destination2,sourceString2,destString2);
		//INS
		File DatabaseINS=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseINS.csv");
		if(!DatabaseINS.exists()){
			DatabaseINS.createNewFile();
		}
		FileWriter fwINS=new FileWriter(DatabaseINS);
		for(int i=0;i<InstrumentsAndRadio[1].size();i++){
			fwINS.append((CharSequence) InstrumentsAndRadio[12].get(i));
			fwINS.append(',');
			fwINS.append((CharSequence) InstrumentsAndRadio[0].get(i));
			fwINS.append(',');
			fwINS.append((CharSequence) InstrumentsAndRadio[1].get(i));
			fwINS.append(',');
			fwINS.append((CharSequence) InstrumentsAndRadio[2].get(i));
			fwINS.append(',');
			fwINS.append((CharSequence) InstrumentsAndRadio[3].get(i));
			fwINS.append(',');
			fwINS.append((CharSequence) InstrumentsAndRadio[4].get(i));
			fwINS.append(',');
			fwINS.append((CharSequence) InstrumentsAndRadio[5].get(i));
			fwINS.append(',');
			fwINS.append((CharSequence) InstrumentsAndRadio[6].get(i));
			fwINS.append(',');
			fwINS.append((CharSequence) InstrumentsAndRadio[7].get(i));
			fwINS.append(',');
			fwINS.append((CharSequence) InstrumentsAndRadio[8].get(i));
			fwINS.append(',');
			fwINS.append((CharSequence) InstrumentsAndRadio[9].get(i));
			fwINS.append(',');
			fwINS.append((CharSequence) InstrumentsAndRadio[10].get(i));
			fwINS.append(',');
			fwINS.append((CharSequence) InstrumentsAndRadio[11].get(i));
			fwINS.append(',');
			fwINS.append((CharSequence) InstrumentsAndRadio[13].get(i));
			fwINS.append("\n");
		}
		fwINS.flush();
		fwINS.close();
		String sourceString3= new String(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseINS.csv");
		String destString3= new String(user+separator+"DatabaseBackupINS.csv");
		Path source3= Paths.get(sourceString3);
		Path destination3 = Paths.get(destString3);
		Copy(source3, destination3,sourceString3,destString3);
		//CAL
		File DatabaseCAL=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseCAL.csv");
		if(!DatabaseCAL.exists()){
			DatabaseCAL.createNewFile();
		}
		FileWriter fwCAL=new FileWriter(DatabaseCAL);
		for(int i=0;i<Calibration[1].size();i++){
			fwCAL.append((CharSequence) Calibration[12].get(i));
			fwCAL.append(',');
			fwCAL.append((CharSequence) Calibration[0].get(i));
			fwCAL.append(',');
			fwCAL.append((CharSequence) Calibration[1].get(i));
			fwCAL.append(',');
			fwCAL.append((CharSequence) Calibration[2].get(i));
			fwCAL.append(',');
			fwCAL.append((CharSequence) Calibration[3].get(i));
			fwCAL.append(',');
			fwCAL.append((CharSequence) Calibration[4].get(i));
			fwCAL.append(',');
			fwCAL.append((CharSequence) Calibration[5].get(i));
			fwCAL.append(',');
			fwCAL.append((CharSequence) Calibration[6].get(i));
			fwCAL.append(',');
			fwCAL.append((CharSequence) Calibration[7].get(i));
			fwCAL.append(',');
			fwCAL.append((CharSequence) Calibration[8].get(i));
			fwCAL.append(',');
			fwCAL.append((CharSequence) Calibration[9].get(i));
			fwCAL.append(',');
			fwCAL.append((CharSequence) Calibration[10].get(i));
			fwCAL.append(',');
			fwCAL.append((CharSequence) Calibration[11].get(i));
			fwCAL.append(',');
			fwCAL.append((CharSequence) Calibration[13].get(i));
			fwCAL.append("\n");
		}
		fwCAL.flush();
		fwCAL.close();
		String sourceString4= new String(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseCAL.csv");
		String destString4= new String(user+separator+"DatabaseBackupCAL.csv");
		Path source4= Paths.get(sourceString4);
		Path destination4 = Paths.get(destString4);
		Copy(source4, destination4,sourceString4,destString4);
		//CLIENTS
		File DatabaseCLIENTS=new File(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseCLIENTS.csv");
		if(!DatabaseCLIENTS.exists()){
			DatabaseCLIENTS.createNewFile();
		}
		FileWriter fwCLIENTS=new FileWriter(DatabaseCLIENTS);
		for(int i=0;i<Clients[1].size();i++){
			fwCLIENTS.append((CharSequence) Clients[0].get(i));
			fwCLIENTS.append(',');
			fwCLIENTS.append((CharSequence) Clients[1].get(i));
			fwCLIENTS.append(',');
			fwCLIENTS.append((CharSequence) Clients[2].get(i));
			fwCLIENTS.append(',');
			fwCLIENTS.append((CharSequence) Clients[3].get(i));
			fwCLIENTS.append("\n");
		}
		fwCLIENTS.flush();
		fwCLIENTS.close();
		String sourceString5= new String(user+separator+"Desktop"+separator+"Work Orders"+separator+"Source"+separator+"Database"+separator+"DatabaseCLIENTS.csv");
		String destString5= new String(user+separator+"DatabaseBackupCLIENTS.csv");
		Path source5= Paths.get(sourceString5);
		Path destination5 = Paths.get(destString5);
		Copy(source5, destination5,sourceString5,destString5);
	}
	public void Copy(Path source, Path dest,String sourceString, String destString) throws IOException{
		File aux= new File(destString);
		if(!aux.exists()){
			Files.copy(source, dest);
		}else{
			try{ 
				aux.delete();
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
			Files.copy(source, dest);
		}
	}
}
