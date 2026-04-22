import java.io.*;
public class NAPSA {
	public static void main (String[]args) throws IOException{
		MainDataBase mdb= new MainDataBase();
		mdb.RecieveBackup();
		MainMenu m= new MainMenu(mdb);// User/password menu object
	}
}
