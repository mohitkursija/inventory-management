//package inventory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
class Login implements ActionListener{
	JFrame frame;
	JLabel banner,ad;
	JTextField tp;
	JButton submit;
	String chc,check;
	String ch="";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login lo=new Login(); 
		lo.log();
	}
	
	public void log(){
		frame= new JFrame("LOGIN");
		frame.setLayout(null);
		
		banner = new JLabel("WELCOME TO INVENTORY MANAGEMENT");
		banner.setFont(new Font("Courier", Font.BOLD,30));
		banner.setBounds(600,100,600,60);	
		
		
		tp=new JPasswordField();
		tp.setBounds(700, 500, 400, 30);
		
		ad=new JLabel("Enter Admin Password : ");
		ad.setBounds(700,450,400,30);
		ad.setFont(new Font("Courier",Font.BOLD,20));
		
		submit=new JButton("SUBMIT");  
	    submit.setBounds(750,550,100,50);  
	    submit.addActionListener(this); 
		
	    frame.add(submit);
		frame.add(ad);
		frame.add(banner);
		frame.add(tp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1700,1000);
		frame.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e){
		try {
			File obj = new File("password.txt");
			Scanner sc=new Scanner(obj);
			if(sc.hasNext())
				check=sc.next();
			sc.close();
		}
		catch(FileNotFoundException ee){
			System.out.println("An error occurred.");
			ee.printStackTrace();
		}
		ch=tp.getText();
		if(ch.equals(check)) {
			System.out.println("SUCCESS");
			mainpage mp= new mainpage();
			mp.action();
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(frame, "WRONG PASSWORD");
			tp.setText("");
			tp.requestFocus();
		}
	}

}

class mainpage implements ActionListener{
	JFrame mainpagee;
	JButton adde,sell,view,edit,sett;
	JLabel label= new JLabel("HELLO ADMIN !!!");
	
	public void action(){
		mainpagee=new JFrame("ADMIN");
		mainpagee.setLayout(null);
		
		label.setBounds(700,450,400,30);
		label.setFont(new Font("Courier",Font.BOLD,20));
		
		adde=new JButton("ADD ITEM");
		adde.setBounds(200,400,500,40);
		adde.addActionListener(this);
		
		sell=new JButton("SELL ITEM");
		sell.setBounds(900,400,500,40);
		sell.addActionListener(this);
		
		view=new JButton("VIEW STOCK");
		view.setBounds(200,500,500,40);
		view.addActionListener(this);
		
		edit=new JButton("CHANGE SETTINGS");
		edit.setBounds(900,500,500,40);
		edit.addActionListener(this);
		
		sett=new JButton("CHANGE SETTINGS");
		sett.setBounds(550,600,500,40);
		sett.addActionListener(this);
		
		mainpagee.add(adde);
		mainpagee.add(sell);
		mainpagee.add(view);
		//mainpagee.add(sett);
		mainpagee.add(edit);
		mainpagee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainpagee.setSize(1700,1000);
		mainpagee.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent p) {
		eventss call = new eventss();
		if(p.getSource()==adde) {
			System.out.println("add");
			mainpagee.dispose();
			call.e_add();
		}
		else if(p.getSource()==sell) {
			System.out.println("sell");
			mainpagee.dispose();
			call.e_sell();
		}
		else if(p.getSource()==view) {
			System.out.println("view");
			mainpagee.dispose();
			call.e_view();
		}
		else if(p.getSource()==edit) {
			System.out.println("edit");
			mainpagee.dispose();
			call.e_sett();
		}
		else if(p.getSource()==sett) {
			System.out.println("settings");
			mainpagee.dispose();
			call.e_edit();
		}
		
	}
}
class eventss implements ActionListener{
	JButton back=new JButton("BACK HOME");
	JFrame add_item =new JFrame("ADD ITEM");
	JFrame sell_item =new JFrame("SELL ITEM");
	JFrame view_item =new JFrame("VIEW ITEM");
	JFrame edit_item =new JFrame("EDIT ITEM");
	JFrame settings =new JFrame("SETTINGS");
	JButton item_add= new JButton("ADD");
	JButton item_sell;
	String list[]={"IPHONE X","IPHONE 8 ","IPAD","AIRPODS"};
	JComboBox c1= new JComboBox(list);
	JTextField item_quant = new JTextField();
	JTextField item_price= new JTextField();
	JTextField sell_price = new JTextField();
	JLabel qq=new JLabel("Quantity");
	JTextField qu=new JTextField();
	JComboBox c2=new JComboBox(list);
	JButton cv=new JButton("Change");
	JLabel chan=new JLabel("Enter new Password");
	JPasswordField bo=new JPasswordField();					

	public void e_add() {
		JLabel a1=new JLabel("Enter Item details ");
		a1.setBounds(20,40,200,40);
		back.setBounds(200,500,200,40);
		//int i=1;
		//String ccc=Integer.toString(i);
		//JLabel count =new JLabel(ccc);
		//JLabel id =new JLabel("id");
		JLabel namee=new JLabel("Item Name");
		//JTextField item_name= new JTextField();
		JLabel quantt=new JLabel("Quantity");
		JLabel pricee=new JLabel("Cost Price");
		JLabel selll =new JLabel("Sell Price");
		//count.setBounds(30,200,50,50);
		//id.setBounds(30,130,50,50);
		selll.setBounds(600,130,100,50);
		sell_price.setBounds(600,200,100,50);
		c1.setBounds(100,200,300,50);
		namee.setBounds(100,130,300,50);
		item_quant.setBounds(400,200,100,50);
		quantt.setBounds(400,130,100,50);
		item_price.setBounds(500,200,100,50);
		pricee.setBounds(500,130,100,50);
		item_add.setBounds(300,300,100,50);
		
		item_add.addActionListener(this);
		back.addActionListener(this);
		add_item.setLayout(null);
		add_item.add(a1);
		add_item.add(back);
		add_item.add(item_add);
		add_item.add(c1);
		add_item.add(item_quant);
		add_item.add(item_price);
		//add_item.add(count);
		//add_item.add(id);
		add_item.add(selll);
		add_item.add(sell_price);
		add_item.add(namee);
		add_item.add(quantt);
		add_item.add(pricee);
		
		add_item.setSize(800,700);
		add_item.setVisible(true);
	}
	public void e_sell() {
		JLabel i=new JLabel("ITEM");
		i.setBounds(100,130,300,50);
		c2.setBounds(100,200,300,50);
		

		//JLabel selll=new JLabel("SELL PRICE");
		//selll.setBounds(500,130,100,50);
		//JTextField sell_price=new JTextField();
		//sell_price.setBounds(500,200,100,50);
		qq.setBounds(400,130,100,50);
		qu.setBounds(400,200,100,50);
		item_sell =new JButton("SELL");
		item_sell.setBounds(200,400,200,40);
		
		back.setBounds(200,500,200,40);
		sell_item.add(item_sell);
		sell_item.add(i);
		sell_item.add(c2);
		//sell_item.add(selll);
		//sell_item.add(sell_price);
		sell_item.add(qq);
		sell_item.add(qu);
		
		sell_item.setLayout(null);
		sell_item.add(back);
		item_sell.addActionListener(this);
		back.addActionListener(this);
		sell_item.setSize(800,700);
		sell_item.setVisible(true);
		
	}
	public void e_view() {
		back.setBounds(200,600,200,40);
		view_item.setLayout(null);
		view_item.add(back);
		TextArea area=new TextArea();
		area.setBounds(100,100,500,400);
		String tempp="id item name      quantity buyprice sell price \n";
		try{
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				System.out.println("view pressed");
				Statement f=con.createStatement();
				String ff="select * from items";
				ResultSet dd=f.executeQuery(ff);
				while(dd.next()){
					int c1=dd.getInt(1);
					String c2=dd.getString(2);
					int c3=dd.getInt(3);
					int c4=dd.getInt(4);
					int c5=dd.getInt(5);
					tempp+=c1+" "+c2+"            "+c3+"          "+c4+"        "+c5+"          "+"\n";
				}
				area.setText(tempp);
					

			}
		catch(Exception op){
			System.out.println(op);
		}
		view_item.add(area);
		back.addActionListener(this);
		view_item.setSize(800,700);
		view_item.setVisible(true);
		
	}
	public void e_edit() {
		back.setBounds(200,350,200,40);
		edit_item.setLayout(null);
		edit_item.add(back);
		back.addActionListener(this);
		edit_item.setSize(800,700);
		edit_item.setVisible(true);
		
	}
	public void e_sett() {
		back.setBounds(200,500,200,40);
		settings.setLayout(null);
		settings.add(back);
		back.addActionListener(this);
		settings.setSize(800,700);
		settings.setVisible(true);
		cv.addActionListener(this);
		cv.setBounds(200,300,200,40);
		chan.setBounds(100,200,250,40);
		bo.setBounds(280,200,250,40);
		settings.add(cv);
		settings.add(chan);
		settings.add(bo);
	}
	
	public void actionPerformed(ActionEvent p2) {
		try {
			//for connection
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			System.out.println("Established");
			con.close();
		}
		catch(Exception ec) {
			System.out.println(ec);
		}
		if(p2.getSource()==back) {
			mainpage mp =new mainpage();
			mp.action();
			add_item.dispose();
			sell_item.dispose();
			view_item.dispose();
			edit_item.dispose();
			settings.dispose();
		}
		else if(p2.getSource()==item_add) {
			try{
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				System.out.println("add pressed");
				//Statement s1=con.createStatement();
				//String temp="create table items(iid integer primary key,itemname varchar2(50),quantity integer not null,buyprice integer,sellprice integer)";
	/*			String namew=(String)c1.getSelectedItem();
				int n=Integer.parseInt(item_quant.getText());
				int n2=Integer.parseInt(item_price.getText());
				int n3=Integer.parseInt(sell_price.getText());
				//Statement s1 =con.createStatement();
				String ss1="insert into items(itemname,quantity,buyprice,sellprice) values(?,?,?,?)";
				PreparedStatement p1=con.prepareStatement(ss1);
				p1.setString(1,namew);
				p1.setInt(2,n);
				p1.setInt(3,n2);
				p1.setInt(4,n3);
				//String temp="insert into items values(1,namew,1,5000,10000)";
				int r1=p1.executeUpdate();
				//s1.executeUpdate(temp);
				//s1.close();
				//ii++;
				
	*/			String namew=(String)c1.getSelectedItem();
				int n=Integer.parseInt(item_quant.getText());
				int n2=Integer.parseInt(item_price.getText());
				int n3=Integer.parseInt(sell_price.getText());
				
				Statement fin1= con.createStatement();
				String sfin1 ="Select quantity from items where itemname ='"+namew+"'";
				int rfin1=fin1.executeUpdate(sfin1);
				if(rfin1>0){
					System.out.println("1check");
					Statement fin2=con.createStatement();
					int tc=0;
					Statement fin3=con.createStatement();
					ResultSet r=fin3.executeQuery("select quantity from items where itemname = '"+namew+"'");
					while(r.next()){
						int y=r.getInt(1);
						tc=y+n;
					}
					String sfin2="update items set quantity ='"+tc+"'"+"where itemname='"+namew+"'";
					fin2.executeUpdate(sfin2);
					
				}
				else{
					Statement s1 =con.createStatement();
					String ss1="insert into items(itemname,quantity,buyprice,sellprice) values(?,?,?,?)";
					PreparedStatement p1=con.prepareStatement(ss1);
					p1.setString(1,namew);
					p1.setInt(2,n);
					p1.setInt(3,n2);
					p1.setInt(4,n3);
					//String temp="insert into items values(1,namew,1,5000,10000)";
					int r1=p1.executeUpdate();
					System.out.println("check");
					
				}
				JOptionPane.showMessageDialog(null, "ADDED SUCCESSFULLY");
				item_quant.setText("");
				item_price.setText("");
				sell_price.setText("");
				item_quant.requestFocus();
				con.close();
			}
			catch(Exception d){
				System.out.println(d);
			}
		}
		else if(p2.getSource()==item_sell){
			String rr=(String)c2.getSelectedItem();
			int w=Integer.parseInt(qu.getText());
			System.out.println("HELLO1");
				
			try{
				Class.forName("oracle.jdbc.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				System.out.println("HELLO");
				
				Statement state=con.createStatement();
				String d2="Select quantity from items where itemname ='" +rr+"'";

				//PreparedStatement state2 =con.prepareStatement(d2);
				//state.setString(1,rr);
				ResultSet rs=state.executeQuery(d2);
				int eed=0;
				while(rs.next()){
					 eed+=rs.getInt(1);
				}
				System.out.println(eed);
				if(w<eed){
					eed=eed-w;
					Statement we=con.createStatement();
					String d3="update items set quantity ='"+eed+"' where itemname='"+rr+"'";
					we.executeUpdate(d3);
					JOptionPane.showMessageDialog(null,"Sold SUCCESSFULLY you have " +eed+"items");
				}
				else{
					JOptionPane.showMessageDialog(null,"INVALID Quantity you have " +eed+"items");
				}
				rs.close();
				con.close();
			}
			catch(Exception pa){
				System.out.println(pa);
			}

		}
		else if(p2.getSource()==cv){
			System.out.println("Hey");
			String str=bo.getText();
			
					
			try{
					new FileOutputStream("password.txt").close();
    				//	 String str = "Hello";
    				BufferedWriter writer = new BufferedWriter(new FileWriter("password.txt"));
   					 writer.write(str);
    
   					 writer.close();
					
					JOptionPane.showMessageDialog(null,"CHANGED SUCCESSFULLY");
					bo.setText("");
			}
			catch(IOException g){
				System.out.println(g);
			}
			//catch(FileNotFoundException h){
			//	System.out.println(h);	
			//}
		}
		else{
			System.out.println("SINGLE");
		}
	}

}