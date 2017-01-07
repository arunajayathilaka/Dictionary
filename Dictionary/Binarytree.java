class Binarytree{
	Node root;
	public void inorder(Node f){
		if(f!=null){
			inorder(f.left);
			System.out.println(f.data1);
			inorder(f.right);
		}
	}
	public boolean removenode(String rdata){
		Node focusnode=root;
		Node parent=root;
		boolean isItALeftChild=true;
		if(focusnode==null){
			return false;
			
		}
	
		else{
			while(focusnode.data1.equals(rdata)==false){
				parent=focusnode;
				
				if(rdata.compareTo(focusnode.data1)<0){
					isItALeftChild=true;
					focusnode=focusnode.left;
					if(focusnode==null){
					return false;
				}
					}
				else if(rdata.compareTo(focusnode.data1)>0){
					isItALeftChild=false;
					focusnode=focusnode.right;
					if(focusnode==null){
					return false;
				}
				}		
			}
		    if(focusnode.left==null && focusnode.right==null){
				if(focusnode==root){
					root=null;
				}
				else if(isItALeftChild){
					parent.left=null;
				}
				else{
					parent.right=null;
				}
			}
			else if(focusnode.left==null){
				if(focusnode==root){
					root=focusnode.right;
				}
				else if(isItALeftChild){
					parent.left=focusnode.right;
				}
				else{
					parent.right=focusnode.right;
				}
			}
			else if(focusnode.right==null){
				if(focusnode==root){
					root=focusnode.left;
				}
				else if(isItALeftChild){
					parent.left=focusnode.left;
				}
				else{
					parent.right=focusnode.left;
				}
			}
			else{
				Node replacement1=Binarytree.getReplacement(focusnode);
				if(focusnode==root){
					root=replacement1;
				}
				else if(isItALeftChild){
					parent.left=replacement1;
				}
				else{
					parent.right=replacement1;
					
				}
				replacement1.left=focusnode.left;
			}
			return true;
			
		}
	}	
		
	public static Node getReplacement(Node replaceN){
		Node replacementParent=replaceN;
		Node replacement=replaceN;
		Node focusnode1=replaceN.right;
		
		while(focusnode1!=null){
			replacementParent=replacement;
			replacement=focusnode1;
			focusnode1=focusnode1.left;
		}
		if(replacement!=replaceN.right){
			replacementParent.left=replacement.right;
			replacement.right=replaceN.right;
		}
		return replacement;
	}
	public String search(String sdata){
		Node sfocusnode=root;
		Node sparent;
		while(true){
			sparent=sfocusnode;
			if(sfocusnode==null){
				return null;
			}
			if(sdata.compareTo(sfocusnode.data1)<=0){
				
				if(sdata.compareTo(sfocusnode.data1)==0){
					
					return sfocusnode.data1;
				}
				sfocusnode=sfocusnode.left;
			}
			else if(sdata.compareTo(sfocusnode.data1)>=0){
				
				 if(sdata.compareTo(sfocusnode.data1)==0){
					
					return sfocusnode.data1;
				}
				sfocusnode=sfocusnode.right;
			}
			
		}
		
	}
	public String getmeanning(String sdata){
		Node sfocusnode=root;
		Node sparent;
		while(true){
			sparent=sfocusnode;
			if(sfocusnode==null){
				return null;
			}
			if(sdata.compareTo(sfocusnode.data1)<=0){
				
				if(sdata.compareTo(sfocusnode.data1)==0){
					
					return sfocusnode.data2;
				}
				sfocusnode=sfocusnode.left;
			}
			else if(sdata.compareTo(sfocusnode.data1)>=0){
				
				 if(sdata.compareTo(sfocusnode.data1)==0){
					
					return sfocusnode.data2;
				}
				sfocusnode=sfocusnode.right;
			}
			
		}
		
	}
	public void addnode(String adata1,String adata2){
		Node newnode=new Node(adata1,adata2);
		if(root==null){
			root=newnode;
			
		}
		else{
			Node afocusnode=root;
			Node parent;
			while(true){
				parent=afocusnode;
				if(adata1.compareTo(afocusnode.data1)<0){
					afocusnode=afocusnode.left;
					if(afocusnode==null){
						parent.left=newnode;
						return;
					}
				}
				else if(adata1.compareTo(afocusnode.data1)>0){
					afocusnode=afocusnode.right;
					if(afocusnode==null){
						parent.right=newnode;
						return;
					}
				}
				else if(adata1.compareTo(afocusnode.data1)==0){
					System.out.println("already exist");
				}
			}
		}
	}
	/*
	public static void main(String[] args){
		Binarytree t=new Binarytree();
		t.addnode("jan","dgsf");
		t.addnode("feb","dhdf");
		t.addnode("mar","hdf");
		t.addnode("apri","dfhf");
		t.addnode("may","dtyh");
		t.addnode("june","fgdf");
		t.addnode("july","qrqwr");
		t.addnode("aug","yoyo");
		System.out.println(t.removenode("febe"));
		t.inorder(t.root);
		System.out.println(t.search("jane"));
		
	}*/
}
class Node{
	public String data1;
	public String data2;
	public Node left;
	public Node right;
	
	public Node(String data1,String data2){
		this.data1=data1;
		this.data2=data2;
		left=null;
		right=null;
		
	}
}