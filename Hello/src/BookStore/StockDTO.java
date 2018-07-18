package BookStore;

public class StockDTO {
		String pcode;
		String storagecode;
		String cstock;
		
		public String getPcode() {
			return pcode;
		}
		public void setPcode(String pcode) {
			this.pcode = pcode;
		}
		public String getStoragecode() {
			return storagecode;
		}
		public void setStoragecode(String storagecode) {
			this.storagecode = storagecode;
		}
		public String getCstock() {
			return cstock;
		}
		public void setCstock(String cstock) {
			this.cstock = cstock;
		}
		
		@Override
		public String toString() {
			return "StockDTO [pcode=" + pcode + ", storagecode=" + storagecode + ", cstock=" + cstock + "]";
		}
}
