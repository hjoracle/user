package BookStore;

public class ProductDTO {
	String pcode;
	String pname;
	String pcontent;
	String bstock;
	
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public String getBstock() {
		return bstock;
	}
	public void setBstock(String bstock) {
		this.bstock = bstock;
	}
	
	@Override
	public String toString() {
		return String.format("%5s\t %8s\t %8s\t %10s\t", pcode, pname, pcontent, bstock);
	}
	
}
