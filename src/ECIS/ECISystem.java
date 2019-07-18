package ECIS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ECISystem {
		static Company c = new Company();
	
		public void mean() {
			Out:
			while(true) {
				System.out.println("----员工打卡系统----");
				System.out.println("输入0--------退出");
				System.out.println("输入1--------签到");
				System.out.println("输入2--------签退");
				System.out.println("输入3--------查看签到签退信息");
				System.out.println("输入4--------查看所有打卡信息");
				System.out.println("输入5--------管理员登陆");
				int ii = new Scanner(System.in).nextInt();
				switch(ii) {
				case 0:System.out.println("退出");break Out;
				case 1:qd();break ;
				case 2:qt();break ;
				case 3:show();break ;
				case 4:readinfo();break;
				case 5:enter();break;
				}
			}
		}
		
		void Admmean() {
			Out:
			while(true) {
				System.out.println("----员工打卡系统(管理员)----");
				System.out.println("输入1--------添加员工");
				System.out.println("输入2--------删除员工");
				System.out.println("输入3--------查找员工");
				System.out.println("输入4--------查看所有员工信息");
				System.out.println("输入0--------退出");
				int ii = new Scanner(System.in).nextInt();
				switch(ii) {
				case 0:System.out.println("已退出员工打卡系统(管理员)");break Out;
				case 1:c.AddEmp();break ;
				case 2:c.DeleteEmp();break ;
				case 3:c.FindEmp();break ;
				case 4:c.ShowEmp();break;		
				}
			}
		}
		
		public void qd() {
			Out:
			while(true) {
				System.out.println("请输入要签到的员工的ID：");
				System.out.println("退出--------请输入0");
				int id = new Scanner(System.in).nextInt();
				if(id==0) {
					break Out;
				}else {
					for(int i=0;i<Company.lisEmp.size();i++) {
						Emp e = Company.lisEmp.get(i);
						if(e.getID()==id) {
							if(!e.isDstate()) {
								DakaInfo info=new DakaInfo(id);
								Date date =new Date();
								SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								info.setDtime(sdf.format(date));
								System.out.println("卡号："+id+"签到成功");
								e.setDstate(true);
								Company.lisInfo.add(info);
								saveinfo(info.toString());
								break Out;
							}else {
								System.out.println("卡号: "+id+" 今天已经签过到了");break Out;
							}
						}		
					}
					System.out.println("未找到 "+id+" 员工，请重新输入");
				}
			}
		}
		
		void qt() {
			Out:
			while(true) {
				System.out.println("请输入要签退的员工的ID：");
				System.out.println("退出--------请输入0");
				int id = new Scanner(System.in).nextInt();
				if(id==0) {
					break Out;
				}else {
					for(int i=0;i<Company.lisEmp.size();i++) {
						Emp e = Company.lisEmp.get(i);
						if(e.getID()==id) {
							if(!e.isTstate()) {
								if(e.isDstate()) {
									DakaInfo info=new DakaInfo(id);
									Date date =new Date();
									SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									info.setTtime(sdf.format(date));
									System.out.println("卡号："+id+" 签退成功");
									e.setTstate(true);		
									Company.lisInfo.add(info);
									saveinfo(info.toString());
									break Out;
								}else {
									System.out.println("卡号："+id+" 今天还没有签到不能签退");break Out;
								}
							}else {
								System.out.println("卡号："+id+" 今天已经签过退了");break Out;
							}
						}
					}
					System.out.println("未找到 "+id+" 员工，请重新输入");
				}
			}
		}
		
		void show() {
			Out:
			while(true) {
				System.out.println("请输入要查询的员工的ID：");
				System.out.println("退出--------请输入0");
				int id = new Scanner(System.in).nextInt();
				if(id==0) {
					break Out;
				}else {
					for(int i=0;i<Company.lisEmp.size();i++) {
						Emp e = Company.lisEmp.get(i);
						if(e.getID()==id) {
							int temp = 0;
							for(int j=0;j<Company.lisInfo.size();j++) {
								DakaInfo info = Company.lisInfo.get(j);
								if(info.getID()==id) {
									System.out.println(info.toString());temp++;
								}
							}
							if(temp==0) {
								System.out.println(id+" 员工今天无打卡信息");
							}
							break Out;
						}
					}
					System.out.println("未找到 "+id+" 员工，请重新输入");
				}
			}
		}
		
		void saveinfo(String info) {
			File f =new File("d:/io/info.txt");
			try {
				FileWriter fw = new FileWriter(f,true);
				BufferedWriter bfw = new BufferedWriter(fw);
				bfw.write(info);
				bfw.newLine();
				bfw.close();
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		static void readinfo() {
			File f =new File("d:/io/info.txt");
			try{
				FileReader fr = new FileReader(f);
				BufferedReader bfr = new BufferedReader(fr);
				String line ="";
				while((line=bfr.readLine())!=null) {
					System.out.println(line);
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		void enter()//管理员登陆账号
		{
			Out:
			while(true)
			{
				int empnum=Company.lisAdm.size();
				System.out.println("请输入您的ID： ");
				System.out.println("退出\t输入0");
				int newID = new Scanner(System.in).nextInt();
				if(newID==0)
				{
					return;
				}
				
				for(int i=0;i<empnum;i++)
				{
					Adm a = Company.lisAdm.get(i);
					if(newID==a.getID())
					{
						for(int j=2;j>=0;j--)
						{
							System.out.println("请输入您的密码： ");
							String newpassword = new Scanner(System.in).next();
							if(newpassword.contentEquals(a.getPassword()))
							{
								System.out.println(newID+"管理员：登陆成功 ");
								Admmean();
								break;
							}
							else
							{		
								if(i>=1)
								{
									System.out.println("密码错误，你还有"+(i)+"次机会！");
								}
								else
								{
									System.out.println("密码错误!");
								}
							}
						}
						break Out;
					}
				}
			    System.out.println("你输入的ID错误!");
			}
		}
		
		
	
}
