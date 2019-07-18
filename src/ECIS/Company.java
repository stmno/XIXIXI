package ECIS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Company {
	static ArrayList<Emp> lisEmp= new ArrayList<Emp>();//泛型
	static ArrayList<DakaInfo> lisInfo = new ArrayList<DakaInfo>();
	static ArrayList<Adm> lisAdm = new ArrayList<Adm>();
	
	Company(){
		lisEmp.add(new Emp(101,"Ming"));
		lisEmp.add(new Emp(102,"LI"));
		lisEmp.add(new Emp(103,"Hong"));
		lisEmp.add(new Emp(104,"Huang"));
		lisEmp.add(new Emp(105,"Lan"));
		loading();
		lisAdm.add(new Adm(101,"GaoGuan","000000"));
		System.out.println("添加信息成功");
	}
	
	public void AddEmp()
	{
		System.out.println("请输入要加入的员工的信息：");
		System.out.println("ID：");
		int id = new Scanner(System.in).nextInt();
		int m=0;
		for(int i=0 ;i<lisEmp.size();i++) {
			if(lisEmp.get(i).getID()!=id) {
				m++;
			}else {
				System.out.println("已有ID："+id+"的员工");
				break;
			}
		}
		if(m==lisEmp.size()) {
			System.out.println("姓名：");
			String name = new Scanner(System.in).next();
			Emp e = new Emp(id,name);
			lisEmp.add(e);
			System.out.println(e.toString()+"员工已添加");
			System.out.println("添加信息成功");
		}
		
	}
	
	public void DeleteEmp()
	{
		System.out.println("请输入要删除的员工的ID：");
		int id = new Scanner(System.in).nextInt();
		int m=0;
		for(int i=0;i<lisEmp.size();i++) {
			if(((Emp)lisEmp.get(i)).getID()==id) {
				lisEmp.remove(i);
				System.out.println(id+"员工已被删除！");
				break;
			}else {
				m++;
			}
		}
		if(m==lisEmp.size()) {
			System.out.println("没有ID："+id+"的员工");
		}
		
	}
	
	public void FindEmp()
	{
		System.out.println("请输入要查找的员工的ID：");
		int id = new Scanner(System.in).nextInt();
		int m=0;
		for(int i=0;i<lisEmp.size();i++) {
			if(((Emp)lisEmp.get(i)).getID()==id) {
				System.out.println(id+"员工已找到");
				System.out.println(((Emp)lisEmp.get(i)).toString());
				break;
			}else {
				m++;
			}
		}
		if(m==lisEmp.size()) {
			System.out.println("没有ID："+id+"的员工");
		}
	}
	
	public void ShowEmp()
	{
		for(int i=0;i<lisEmp.size();i++) {
			System.out.println(((Emp)lisEmp.get(i)).toString());
		}
	}
	
	public void loading() {  //读取文件中储存的打卡信息
		File f =new File("d:/io/info.txt");
		try{
			FileReader fr = new FileReader(f);
			BufferedReader bfr = new BufferedReader(fr);
			String line ="";
			while((line=bfr.readLine())!=null) {
				String[] str=line.split(" ");
				int id = Integer.parseInt(str[1]); 
				DakaInfo finfo=new DakaInfo(id);
				String time = str[2]+" "+str[3];
				if(str[0].equals("签到：")) {				
					for(int i=0;i<Company.lisEmp.size();i++) {
						Emp e = Company.lisEmp.get(i);
						if(e.getID()==id) {
							e.setDstate(true);
						}		
					}
					finfo.setDtime(time);
					lisInfo.add(finfo);
				}else {
					for(int i=0;i<Company.lisEmp.size();i++) {
						Emp e = Company.lisEmp.get(i);
						if(e.getID()==id) {
							e.setTstate(true);
						}		
					}
					finfo.setTtime(time);
					lisInfo.add(finfo);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
