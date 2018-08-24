package me.gacl.gjp.view;

import java.util.List;
import java.util.Scanner;

import me.gacl.gjp.domain.gjp;
import me.gacl.gjp.service.zhangwuservice;

/*
 * ��ͼ�� �û������Ĳ����Ľ���
 * ���ݴ��ݸ�controller��ʵ��
 * ��Աλ��  ����controller����
 * 
 */
public class MainView {
     private zhangwuservice service =new zhangwuservice();
     
     @SuppressWarnings("resource")
	public void run(){
     
    	 //����һ��Scanner����� ������������
    	 boolean flag = true;
    	 Scanner sc=new Scanner(System.in);
    	 while(flag){
    		 System.out.println("-----------------�ܼ��ż�ͥ�������-----------------");
    		 System.out.println("1.�������  2.�༭����   3.ɾ������  4.��ѯ����  5.�˳�����");
    		 System.out.println("������Ҫ�����Ĺ�����š�1����5����");
    		 //�����û��Ĳ˵�ѡ��
    		 int choose=sc.nextInt();
    		 //��ѡ��Ĳ˵��ж�  ���ò�ͬ�Ĺ���
    		switch (choose) {
			case 1:
				addZhangWu();
				break;
            case 2:
            	editZhangWu();
				break;
            case 3:
            	deleteZhangWu();
	            break;
            case 4:
            	 selectZhangWu();
	             break;
            case 5:
            	 System.out.println("�ټ���");
       			 flag = false;
	             break;

			 default:
			      System.out.println("�������");
			}
    	 }
     }
     public void selectZhangWu() {
    		System.out.println("1.��ѯ���С�2.��������ѯ");
    		@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
    		int op = in.nextInt();
    		switch (op) {
    		case 1:
    			selectAll();
    			break;
    		case 2:
    			select();
    			break;
    		default:
    			System.out.println("�������");
    		}
    	}
     
     
     public void selectAll() {
    	 
    		List<gjp> zhangWuList = service.selectAll();
    		print(zhangWuList);
    	}
     
     private void print(List<gjp> zhangWuList) {
    	 
    		System.out.println("ID\t���\t\t�˻�\t\t���\t\tʱ��\t\t˵��");
    		
    		for (gjp zw : zhangWuList) {
    			
    			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t"
    					+ zw.getZhanghu()  + "\t\t" + zw.getMoney() + "\t\t"
    					+ zw.getCreatetime() + "\t" + zw.getDescription());
    		}
    	}

    
     
    
     public void select() {
    		/*
    		 * 1. ��ȡ�û������ѯ���ڷ�Χ�� 
    		 * 2. ����service��select()�������������ѯ����
    		 */
    		@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
    		System.out.print("�������ѯ��ʼʱ�䣺");
    		String start = in.next();
    		System.out.print("�������ѯ����ʱ�䣺");
    		String end = in.next();
    		List<gjp> zhangWuList = service.select(start, end);
    		print(zhangWuList);
    	}
    

    
     public void addZhangWu() {
    		/*
    		 * 1. ��ȡ�û����룬��װ��bean�С� 
    		 * 2. ����service��addZhangWu()���������ӹ���
    		 */
    		@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
    		gjp zw = new gjp();
    		System.out.print("���������");
    		zw.setFlname(in.next());
    		System.out.print("�������˻���");
    		zw.setZhanghu(in.next());
    		System.out.print("�������");
    		zw.setMoney(in.nextDouble());
    		System.out.print("������ʱ�䣺");
    		zw.setCreatetime(in.next());
    		System.out.print("������˵����");
    		zw.setDescription(in.next());
    		
    		service.addZhangWu(zw);
    		System.out.println("�������ɹ���");
    	}

     
    
     public void editZhangWu() {
    		/*
    		 * 1. ��ȡ�û����룬��װ��bean�С� 
    		 * 2. ����service��editZhangWu()���������ӹ���
    		 */
    		@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
    		gjp zw = new gjp();
    		System.out.print("������ID��");
    		zw.setZwid(in.nextInt());
    		System.out.print("�����������");
    		zw.setFlname(in.next());
    		System.out.print("���������˻���");
    		zw.setZhanghu(in.next());
    	    System.out.print("�������½�");
    		zw.setMoney(in.nextDouble());
    		System.out.print("��������ʱ�䣺");
    		zw.setCreatetime(in.next());
    		System.out.print("��������˵����");
    		zw.setDescription(in.next());
    		service.editZhangWu(zw);
    		System.out.println("�༭����ɹ���");
    	}

   
    
     public void deleteZhangWu() {
    		/*
    		 * 1. ��ȡ�û����룬��װ��bean�С� 
    		 * 2. ����service��deleteZhangWu()���������ӹ���
    		 */
    		@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
    		System.out.print("������ID��");
    		
    		service.deleteZhangWu(in.nextInt());
    		System.out.println("ɾ������ɹ���");
    	}
     
    
}
