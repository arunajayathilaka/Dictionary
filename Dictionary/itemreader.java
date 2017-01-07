import java.awt.*;
import java.io.*;
import java.util.*; 

class itemreader{
	public static void getitems(String filename,Binarytree t,hashtable ht){
		String [] ar=new String[2]; 
		 try{
        	//gtting two files to read and write
            FileReader reader = new FileReader("input.txt");
			
            BufferedReader bufferedReader = new BufferedReader(reader);
			// Create String variable 
			String str1 = null;
			int iterator=0;
			// read all the elements in the File
            while( (str1=bufferedReader.readLine()) != null ){
				iterator=0;
				for(String retval:str1.split("-")){
					ar[iterator]=retval;
					if(iterator==1){
						t.addnode(ar[0],ar[1]);
						ht.addTohash(ar[1],ar[0]);
					}
					
					iterator++;
				}
            }
			System.out.println("successfully add textfile words");
            bufferedReader.close();//close the bufferedReader
            reader.close();//close the reader
        }
		
        catch(IOException e)
        {
            e.printStackTrace();
        }

	}
}