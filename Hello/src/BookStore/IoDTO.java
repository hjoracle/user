package BookStore;

import java.util.Formatter;

public class IoDTO {
	String iocode;
	String pcode;
	String io_amount;
	String storagecode;
	
	public String getIocode() {
		return iocode;
	}
	public void setIocode(String iocode) {
		this.iocode = iocode;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getIo_amount() {
		return io_amount;
	}
	public void setIo_amount(String io_amount) {
		this.io_amount = io_amount;
	}
	public String getStoragecode() {
		return storagecode;
	}
	public void setStoragecode(String storagecode) {
		this.storagecode = storagecode;
	}
				
	@Override
	public String toString() {
		return String.format("%5s\t %8s\t %8s\t %10s\t", iocode, pcode, io_amount, storagecode);
	}
	
}
