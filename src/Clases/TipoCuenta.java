package Clases;

public class TipoCuenta {
	
	private int id;
	private String desc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public TipoCuenta(int id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}
	
	
}
