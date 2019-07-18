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
				System.out.println("----Ա����ϵͳ----");
				System.out.println("����0--------�˳�");
				System.out.println("����1--------ǩ��");
				System.out.println("����2--------ǩ��");
				System.out.println("����3--------�鿴ǩ��ǩ����Ϣ");
				System.out.println("����4--------�鿴���д���Ϣ");
				System.out.println("����5--------����Ա��½");
				int ii = new Scanner(System.in).nextInt();
				switch(ii) {
				case 0:System.out.println("�˳�");break Out;
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
				System.out.println("----Ա����ϵͳ(����Ա)----");
				System.out.println("����1--------���Ա��");
				System.out.println("����2--------ɾ��Ա��");
				System.out.println("����3--------����Ա��");
				System.out.println("����4--------�鿴����Ա����Ϣ");
				System.out.println("����0--------�˳�");
				int ii = new Scanner(System.in).nextInt();
				switch(ii) {
				case 0:System.out.println("���˳�Ա����ϵͳ(����Ա)");break Out;
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
				System.out.println("������Ҫǩ����Ա����ID��");
				System.out.println("�˳�--------������0");
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
								System.out.println("���ţ�"+id+"ǩ���ɹ�");
								e.setDstate(true);
								Company.lisInfo.add(info);
								saveinfo(info.toString());
								break Out;
							}else {
								System.out.println("����: "+id+" �����Ѿ�ǩ������");break Out;
							}
						}		
					}
					System.out.println("δ�ҵ� "+id+" Ա��������������");
				}
			}
		}
		
		void qt() {
			Out:
			while(true) {
				System.out.println("������Ҫǩ�˵�Ա����ID��");
				System.out.println("�˳�--------������0");
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
									System.out.println("���ţ�"+id+" ǩ�˳ɹ�");
									e.setTstate(true);		
									Company.lisInfo.add(info);
									saveinfo(info.toString());
									break Out;
								}else {
									System.out.println("���ţ�"+id+" ���컹û��ǩ������ǩ��");break Out;
								}
							}else {
								System.out.println("���ţ�"+id+" �����Ѿ�ǩ������");break Out;
							}
						}
					}
					System.out.println("δ�ҵ� "+id+" Ա��������������");
				}
			}
		}
		
		void show() {
			Out:
			while(true) {
				System.out.println("������Ҫ��ѯ��Ա����ID��");
				System.out.println("�˳�--------������0");
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
								System.out.println(id+" Ա�������޴���Ϣ");
							}
							break Out;
						}
					}
					System.out.println("δ�ҵ� "+id+" Ա��������������");
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
		
		
		void enter()//����Ա��½�˺�
		{
			Out:
			while(true)
			{
				int empnum=Company.lisAdm.size();
				System.out.println("����������ID�� ");
				System.out.println("�˳�\t����0");
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
							System.out.println("�������������룺 ");
							String newpassword = new Scanner(System.in).next();
							if(newpassword.contentEquals(a.getPassword()))
							{
								System.out.println(newID+"����Ա����½�ɹ� ");
								Admmean();
								break;
							}
							else
							{		
								if(i>=1)
								{
									System.out.println("��������㻹��"+(i)+"�λ��ᣡ");
								}
								else
								{
									System.out.println("�������!");
								}
							}
						}
						break Out;
					}
				}
			    System.out.println("�������ID����!");
			}
		}
		
		
	
}
