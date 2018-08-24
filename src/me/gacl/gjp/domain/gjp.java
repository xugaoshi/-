package me.gacl.gjp.domain;

public class gjp {
   private    int     zwid;
   private    String  flname;
   private    double   money;
   private    String    createtime;
   private    String    description;
	private    String   zhanghu;
	
	
  
	public gjp() {
		
	}
	public gjp(int zwid, String flname, double money, String createtime, String description, String zhanghu) {
		super();
		this.zwid = zwid;
		this.flname = flname;
		this.money = money;
		this.createtime = createtime;
		this.description = description;
		this.zhanghu = zhanghu;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
public     int getZwid() {
		return zwid;
	}
	public void setZwid(int zwid) {
		this.zwid = zwid;
	}
	public String getFlname() {
		return flname;
	}
	public void setFlname(String flname) {
		this.flname = flname;
	}
	public double getMoney() {
		return money;
	}
	@Override
	public String toString() {
		return "gjp [zwid=" + zwid + ", flname=" + flname + ", money=" + money + ", createtime=" + createtime
				+ ", description=" + description + ", zhanghu=" + zhanghu + "]";
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getZhanghu() {
		return zhanghu;
	}
	public void setZhanghu(String zhanghu) {
		this.zhanghu = zhanghu;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
