import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
class Dictionary{
	
		public Binarytree t=new Binarytree();
		public hashtable ht=new hashtable();
		public itemreader ir=new itemreader();
		JFrame parent=new JFrame();
	//add item
	public void addw(String word,String meanning){
		t.addnode(word,meanning);
		ht.addTohash(meanning,word);
	}
	//delete item
	public void delete(String word){
		t.removenode(word);
		ht.removeitem(word);
	}
	//simillar items
	public String similiar(String word){
		String similiarMean=t.getmeanning(word);
		if(similiarMean==null){
			JOptionPane.showMessageDialog(parent, "Not in dictionary");
			return "";
		}
		else{
			
			return ht.pullwords(similiarMean,word);
		}
		
	}
	//search item
	public String searchm(String word){
		String we=t.getmeanning(word);
		if(we==null){
			JOptionPane.showMessageDialog(parent, "Not in dictionary");
			return null;
		}
		else{
			return we;
		}
	}
	//find and return true or false
	public boolean find(String word){
		String yu=t.search(word);
		if(yu==null){
			return false;
		}
		return true;
	}
	public void DictionaryInput(){
		
		//getting words from file to binary tree and hashmap
		ir.getitems("input.txt",t,ht);
	}
	public void operation(GUI dic,String sd){
		//search function
		if(sd.equals("Search")){
			String sword=dic.textfd.getText();
			dic.textf2.setText(" ");
			dic.textf3.setText(" ");
			String er=searchm(sword);
			dic.textf2.setText(er);
			dic.textf3.setText(" ");
		}
		//similliar function
		else if(sd.equals("Similiar")){
			String sword1=dic.textfd.getText();
			String er1=similiar(sword1);
			dic.textf3.setText(er1);
		}
		//add  function
		else if(sd.equals("Add")){
			String aword=dic.textfd1.getText();
			String ameaning=dic.textf4.getText();
			if(!find(aword)){
				//System.out.println(aword);
				addw(aword,ameaning);
				dic.textfd1.setText("");
				dic.textf4.setText("");
				JOptionPane.showMessageDialog(parent, "Successfully added");
			}
			else{
				JOptionPane.showMessageDialog(parent, "already in dictionary");
			}
		}
		//delete function
		else if(sd.equals("delete")){
			String dword=dic.textfd2.getText();
			//System.out.println(dword);
			if(!find(dword)){
				JOptionPane.showMessageDialog(parent, "not in dictionary");
				
			}
			else{
				JOptionPane.showMessageDialog(parent, "successfully deleted");
				delete(dword);
			}
			 
		}
	}
	public void run(){
		//gui object
		final GUI dic=new GUI();
		//commads for each button
		dic.button1.setActionCommand("Search");
        dic.button2.setActionCommand("Similiar");
        dic.button3.setActionCommand("Add");
		dic.button4.setActionCommand("delete");
		//declaring actions for each buttonn
        dic.button1.addActionListener(new ActionListener()
                {
					
                    public void actionPerformed(ActionEvent ae)
                    {
                        operation(dic,ae.getActionCommand());                   
                    }
                }); 
        dic.button2.addActionListener(new ActionListener()
                {
					
                    public void actionPerformed(ActionEvent ae)
                    {
                        operation(dic,ae.getActionCommand());                   
                    }
                });  
        dic.button3.addActionListener(new ActionListener()
                {
					
                    public void actionPerformed(ActionEvent ae)
                    {
                        operation(dic,ae.getActionCommand());                   
                    }
                });  
        dic.button4.addActionListener(new ActionListener()
                {
					
                    public void actionPerformed(ActionEvent ae)
                    {
                        operation(dic,ae.getActionCommand());                   
                    }
                });  
	}
	public static void main(String[] args){
		
		Dictionary d=new Dictionary();
		d.DictionaryInput();
		d.run();
	}
	
}

