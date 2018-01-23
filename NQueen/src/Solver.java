import java.util.concurrent.Callable;

public class Solver implements Callable{
	
	private int N;
	private boolean [][] M;
	
	public Solver(final int _N){
		
		N = _N;
		M = new boolean[N][N];
		
		for(int i = 0; i < M.length; i++){
			
			for(int j = 0; j < M.length; j++){
				
				M[i][j] = false;
				
			}
			
		}
	}
	
	public void print(){
		
		for(int i = 0; i < M.length; i++){
			
			for(int j = 0; j < M.length; j++){
				
				
				System.out.print(M[i][j] + " ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
	public boolean isGood(int r, int c){
		
		for(int i = r; i < N ; i++){//controllo colonne
			
			if(M[i][c])
				return false;

		}
		
		for(int i = r; i < N && r+i >= 0 && c+i <= N; i++){//controllo diagonali
			
			if(M[r-i][c+i])
				return false;

		}
		
		for(int i = r; i < N && r+i <= N && c+i <= N; i++){
			
			if(M[r+i][c+i])
				return false;

		}
		
		for(int i = r; i < N && r+i <= N && c+i >= 0; i++){
			
			if(M[r+i][c-i])
				return false;

		}
		
		for(int i = r; i < N && r+i >= 0 && c+i >= 0; i++){
			
			if(M[r-i][c-i])
				return false;

		}
		
		return true;
		
	}
	
	public boolean solve(){
		return this.solve(0);
	}
	
	private boolean solve(int r){
		
		if(r >= N)//passo base
			return true;
		
		for(int c = 0; c < N; c++){
			
			if(isGood(r,c)){
				
				M[r][c] = true;
				
				if(solve(r+1))
					return true;
				
				M[r][c] = false;
				
			}
			
		}
		
		return false;
		
	}

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
}
