import java.io.*;
import java.util.*;
class hashtable{
	//making hash table for searching simillar words
		public HashMap<String,ArrayList<String>> hashmtable=new HashMap<String,ArrayList<String>>();
	
	public void addTohash(String s1,String s2){
		//duplicate key hadeling
			
			//if same key has many value,then put it in arraylist
		if(hashmtable.get(s1)==null){
			ArrayList<String> tmp=new ArrayList<String>();
			tmp.add(s2);
			
			hashmtable.put(s1,tmp);
				//tmp.clear();
		}
		else{
			ArrayList<String> tmp1=hashmtable.get(s1);
			tmp1.add(s2);
			hashmtable.put(s1,tmp1);
				//tmp1.clear();
		}
			
	}
	//remove element from hashmap
	public void removeitem(String v){
		hashmtable.remove(v);
	}
	public String pullwords(String c,String j1){
		String tr="";
		
		ArrayList<String> temp=hashmtable.get(c);
		
		for(int i=0;i<temp.size();i++){
			String t=temp.get(i);
			if(!t.equals(j1)){
				tr=tr+t+" / ";
			}
			
			else if(temp.size()==1){
				return "there is no simillar words";
			}
			
		}
		return tr;
	}
	/*
	public static void main(String[] args){
		hashtable ht=new hashtable();
		ht.addTohash("jan","hfh");
		ht.addTohash("feb","hfhfgf");
		ht.addTohash("jan","hfwewrwerh");
		ht.addTohash("mar","hfuyoyuoh");
		System.out.println(ht.pullwords("jan"));
	}*/
}