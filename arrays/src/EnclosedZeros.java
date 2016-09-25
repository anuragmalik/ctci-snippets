
public class EnclosedZeros {
	
	
	public static char[][] findEnclosedZeros(char[][] matrix) {
		int M = matrix.length;
		int N = matrix[0].length;
		
		// replace all zeros with -
		for(int i = 0; i < M; i++) {
			for (int j=0;j < N; j++) {
				if(matrix[i][j] == '0'){
					matrix[i][j] = '-';
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			if (matrix[i][0] == '-')
				floodFill(matrix, i , 0);
		}
		
		for(int i = 0; i < M; i++) {
			if (matrix[i][3] == '-')
				floodFill(matrix, i , 0);
		}
		
		for(int j = 0; j < N; j++) {
			if(matrix[0][j] == '-') {
				floodFill(matrix, 0, j);
			}
		}
		
		for(int j = 0; j < N; j++) {
			if(matrix[2][j] == '-') {
				floodFill(matrix, 2, j);
			}
		}
		
		for(int i = 0; i < M; i++) {
			for (int j=0;j < N; j++) {
				if(matrix[i][j] == '-'){
					matrix[i][j] = 'X';
				}
			}
		}
	
		return matrix;
	}
	
	public static void floodFill (char[][] matrix, int i, int j) {
		
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] != '-') {
			return;
		}
		
		if ( matrix[i][j] == '-' ) {
			matrix[i][j] = '0';
		}
		
		floodFill(matrix, i - 1, j);
		floodFill(matrix, i + 1, j);
		floodFill(matrix, i, j - 1);
		floodFill(matrix, i, j + 1);
	}

	public static void main(String[] args) {

		char[][] matrix = new char[][] {
			{'X','X','X','X'},
			{'X','0','0','X'},
			{'0','X','X','X'},
		};
		
		char[][] enclosed = findEnclosedZeros(matrix);
		
		for(int i = 0; i <3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(enclosed[i][j]);
			}
		System.out.println();
 		}
	}

}
