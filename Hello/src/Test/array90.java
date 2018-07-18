package Test;

public class array90 {

	public static void main(String[] args) {
		int arr[][] = new int[5][5];
		int n=0;

		for(int i=0 ; i<5; i++) {
			for(int j=0; j<5; j++) {
				arr[i][j] = n++;
			}
		}

		for(int i=0 ; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(arr[i][j] + "\t");
				if(j == 4)
					System.out.println();
			}
		}
		System.out.println();
		n=0;
		for(int j=0; j<5; j++) {
			for(int i = 4; i>=0; i--) {
				arr[i][j] = n++;
			}
		}
		for(int i=0 ; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(arr[i][j] + "\t");
				if(j == 4)
					System.out.println();
			}
		}
		System.out.println();
		n=0;
		for(int i=0 ; i<5; i++) {
			for(int j=0; j<5; j++) {
				arr[4-j][i] = n++;
			}
		}
		for(int i=0 ; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(arr[i][j] + "\t");
				if(j == 4)
					System.out.println();
			}
		}

	}
}

