import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame{
	// creating 3 tab panels
	JPanel tabpanel1 =new JPanel();
	JPanel tabpanel2 =new JPanel();
	JPanel tabpanel3 =new JPanel();
	JPanel tabpanel1_s =new JPanel();
	JPanel tabpanel1_s1 =new JPanel();
	JTextField textfd=new JTextField(30);
	JTextField textfd1=new JTextField(35);
	JTextField textfd2=new JTextField(35);
	JTextArea textf2=new JTextArea("",6,35);
	JTextArea textf3=new JTextArea("",6,35);
	JTextArea textf4=new JTextArea("",6,35);
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JLabel label1=new JLabel();
	JLabel label2=new JLabel();
	JLabel label3=new JLabel();
	JLabel label4=new JLabel();
	JLabel label5=new JLabel();
	JTabbedPane tabbedPane = new JTabbedPane();
	
        
	public GUI(){
		//constractor
		super("Dictionay");
		setSize(410,420);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setDefaultLookAndFeelDecorated(true);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		//adding tabs
		//serach tab-----------------------------------
		tabbedPane.add("Search",tabpanel1);
		button1=new JButton("Search");
		button2=new JButton("Similiar");
		label1.setText("meannig:");
		label2.setText("similar:");
		tabpanel1.add(textfd);
		textf2.setEditable(false);
		textf3.setEditable(false);
		tabpanel1.add(button1);
		tabpanel1.add(button2);
		//label1.setHorizontalAlignment(JLabel.LEFT);
		tabpanel1_s.setLayout(new BorderLayout());
		tabpanel1_s1.setLayout(new BorderLayout());
		//label1.setHorizontalAlignment(SwingConstants.LEFT);
		//label2.setHorizontalAlignment(SwingConstants.LEFT);
		tabpanel1_s1.add(label1,BorderLayout.LINE_START);
		tabpanel1_s1.add(textf2,BorderLayout.PAGE_END);
		
		tabpanel1_s.add(label2,BorderLayout.NORTH);
		tabpanel1_s.add(textf3,BorderLayout.SOUTH);
		//tabpanel1_s.setLayout(new BoxLayout(tabpanel1_s,BoxLayout.PAGE_AXIS));
		//tabpanel1_s.setAlignmentX(Component.CENTER_ALIGNMENT);
		tabpanel1.add(tabpanel1_s1);
		tabpanel1.add(tabpanel1_s);
		//-------------------------------
		
		//----------add tab----------------
		//add tab
		tabbedPane.add("Add",tabpanel2);
		label3.setText("meanning:");
		label4.setText("word:");
		button3=new JButton("Add");
		//tabpanel2.setLayout(new BoxLayout(tabpanel2,BoxLayout.Y_AXIS));
		tabpanel2.add(label4);
		tabpanel2.add(textfd1);
		tabpanel2.add(label3);
		tabpanel2.add(textf4);
		tabpanel2.add(button3);
		//---------------------------------------
		
		//----------delete tab---
		tabbedPane.add("Delete",tabpanel3);
		label5.setText("word:");
		button4=new JButton("delete");
		tabpanel3.add(label5);
		tabpanel3.add(textfd2);
		tabpanel3.add(button4);
		//add all tabs to frame
		
		//-------------------------------
		add(tabbedPane);
		
	}
	public static void main(String[] args){
		//creating object of gui
		new GUI();
	}
}