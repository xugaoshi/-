package me.gacl.gjp.view;

import java.util.List;
import java.util.Scanner;

import me.gacl.gjp.domain.gjp;
import me.gacl.gjp.service.zhangwuservice;

/*
 * 视图层 用户看到的操作的界面
 * 数据传递给controller层实现
 * 成员位置  创建controller对象
 * 
 */
public class MainView {
     private zhangwuservice service =new zhangwuservice();
     
     @SuppressWarnings("resource")
	public void run(){
     
    	 //创建一个Scanner类对象 反复键盘输入
    	 boolean flag = true;
    	 Scanner sc=new Scanner(System.in);
    	 while(flag){
    		 System.out.println("-----------------管家婆家庭记账软件-----------------");
    		 System.out.println("1.添加账务  2.编辑账务   3.删除账务  4.查询账务  5.退出账务");
    		 System.out.println("请输入要操作的功能序号【1——5】：");
    		 //接收用户的菜单选择
    		 int choose=sc.nextInt();
    		 //对选择的菜单判断  调用不同的功能
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
            	 System.out.println("再见！");
       			 flag = false;
	             break;

			 default:
			      System.out.println("输入错误！");
			}
    	 }
     }
     public void selectZhangWu() {
    		System.out.println("1.查询所有　2.按条件查询");
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
    			System.out.println("输入错误！");
    		}
    	}
     
     
     public void selectAll() {
    	 
    		List<gjp> zhangWuList = service.selectAll();
    		print(zhangWuList);
    	}
     
     private void print(List<gjp> zhangWuList) {
    	 
    		System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
    		
    		for (gjp zw : zhangWuList) {
    			
    			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t\t"
    					+ zw.getZhanghu()  + "\t\t" + zw.getMoney() + "\t\t"
    					+ zw.getCreatetime() + "\t" + zw.getDescription());
    		}
    	}

    
     
    
     public void select() {
    		/*
    		 * 1. 获取用户输入查询日期范围。 
    		 * 2. 调用service的select()方法完成条件查询功能
    		 */
    		@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
    		System.out.print("请输入查询起始时间：");
    		String start = in.next();
    		System.out.print("请输入查询结束时间：");
    		String end = in.next();
    		List<gjp> zhangWuList = service.select(start, end);
    		print(zhangWuList);
    	}
    

    
     public void addZhangWu() {
    		/*
    		 * 1. 获取用户输入，封装到bean中。 
    		 * 2. 调用service的addZhangWu()方法完成添加功能
    		 */
    		@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
    		gjp zw = new gjp();
    		System.out.print("请输入类别：");
    		zw.setFlname(in.next());
    		System.out.print("请输入账户：");
    		zw.setZhanghu(in.next());
    		System.out.print("请输入金额：");
    		zw.setMoney(in.nextDouble());
    		System.out.print("请输入时间：");
    		zw.setCreatetime(in.next());
    		System.out.print("请输入说明：");
    		zw.setDescription(in.next());
    		
    		service.addZhangWu(zw);
    		System.out.println("添加账务成功！");
    	}

     
    
     public void editZhangWu() {
    		/*
    		 * 1. 获取用户输入，封装到bean中。 
    		 * 2. 调用service的editZhangWu()方法完成添加功能
    		 */
    		@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
    		gjp zw = new gjp();
    		System.out.print("请输入ID：");
    		zw.setZwid(in.nextInt());
    		System.out.print("请输入新类别：");
    		zw.setFlname(in.next());
    		System.out.print("请输入新账户：");
    		zw.setZhanghu(in.next());
    	    System.out.print("请输入新金额：");
    		zw.setMoney(in.nextDouble());
    		System.out.print("请输入新时间：");
    		zw.setCreatetime(in.next());
    		System.out.print("请输入新说明：");
    		zw.setDescription(in.next());
    		service.editZhangWu(zw);
    		System.out.println("编辑账务成功！");
    	}

   
    
     public void deleteZhangWu() {
    		/*
    		 * 1. 获取用户输入，封装到bean中。 
    		 * 2. 调用service的deleteZhangWu()方法完成添加功能
    		 */
    		@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
    		System.out.print("请输入ID：");
    		
    		service.deleteZhangWu(in.nextInt());
    		System.out.println("删除账务成功！");
    	}
     
    
}
