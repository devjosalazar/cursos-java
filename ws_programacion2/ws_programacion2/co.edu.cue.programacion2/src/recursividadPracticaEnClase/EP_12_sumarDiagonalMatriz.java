package recursividadPracticaEnClase;

public class EP_12_sumarDiagonalMatriz {

	/**
	7.	Programar un algoritmo recursivo que permita sumar la diagonal principal de una matriz
	**/
	
	public static void main(String[] args) 
	{
		int n = 3;
		int m = 3;
		
		int matriz [][] = {{10,2,3},{4,10,6},{7,8,10}};
		
		
		System.out.println(sumaDiagonal(matriz,n,m));
//		System.out.println(sumaDiagonalV2(matriz,n,m));
		
//		System.out.println(sumarDiagonal(matriz,n,m));
		
//		System.out.println(sumarDiagonalPrincipalMatriz2(matriz,3,0));
		
		
		System.out.println(array(matriz,3,3));
		

	}

	private static int sumaDiagonal(int[][] matriz, int n, int m) 
	{
	    if (n > 0) { 
	        if (m > 0) 
	        {
	        	if((n-1) == (m-1))
	        		return matriz[n - 1][m - 1] + sumaDiagonal(matriz, n, --m);
	        	else
	        		return sumaDiagonal(matriz, n, --m);
	        }
	        else 
	        { 
	            return sumaDiagonal(matriz, --n, m + matriz[n].length); 
	        } 
	    } 
	    else { 
	        return 0; 
	    }
	}
	
	
	private static int sumaDiagonalV2(int[][] matriz, int n, int m) 
	{
		if(n < 0){
			return 0;
		}else{
			
			if(m < 0){
				return sumaDiagonalV2(matriz, --n, matriz[n].length);
			}else{
	        	if((n-1) == (m-1))
	        		return matriz[n - 1][m - 1] + sumaDiagonalV2(matriz, n, --m);
	        	else
	        		return sumaDiagonalV2(matriz, n, --m);
			}
		}
		
	}
	
	static int sumarDiagonal(int[][] matriz,int n, int m)
    {
        if((n-1) < 0 && (m-1) <0)
        {
            return 0;
        }
        else{
                if(m> 0)
                {
                    if((n-1) == (m-1))
                    {
                        return matriz[n-1][m-1] + sumarDiagonal(matriz, n, --m);
                    }
                    else
                    {
                        return sumarDiagonal(matriz, n, --m);
                    }
                }
                else
                {
                    return  sumarDiagonal(matriz, --n, m + matriz[n].length);
                }
            
        }
        
    }
	
	
	public static int recorrerMatrizForma3(int matriz[][], int n, int m){
        if(n > 0) {
            if(m<matriz[0].length) {
                
                if(n-1 == m) {
                    return recorrerMatrizForma3(matriz, --n, m);
                }else {
                    return recorrerMatrizForma3(matriz, --n, m);
                }
            }else {
                return recorrerMatrizForma3(matriz, n, ++m);
            }
        }else {
            return 0;
        }            
    }
	
	private static int sumarDiagonalMatriz(int[][] matrizNumeros, int i,int j) {
        if(i < 0) {
            return 0;
        }else {
            if(j >= matrizNumeros[0].length) {
                return sumarDiagonalMatriz(matrizNumeros, --i,j=0) ;
            }else {
                if(i == j) {
                    return sumarDiagonalMatriz(matrizNumeros, i,j+1) + matrizNumeros[i][j];
                }else {
                    return sumarDiagonalMatriz(matrizNumeros, i,j+1) ;
                }
            }
        }
    } 
	
	
	private static int sumarDiagonalPrincipalMatriz2(int[][] matriz, int n, int m) {

		if(n <= 0) {
			return 0;
		}
		else {
			if(m-1 > matriz[0].length-1) {
				return sumarDiagonalPrincipalMatriz2(matriz, n-1, 0);
			}
			else {
				if(n-1 == m-1) {
					return matriz[n-1][m-1]+sumarDiagonalPrincipalMatriz2(matriz, n, m+1);
				}
				else {
					return sumarDiagonalPrincipalMatriz2(matriz, n, m+1);
				}
			}
		}

	}
	
	public static int array(int[][] matriz, int n, int m) {

		if(n > 0) {
			if(m > matriz[0].length-1) {

				if((n-1) == (m-1)) {
					return matriz[n-1][m-1]+array(matriz, --n, m);
				}else {
					return array(matriz, --n, m);
				}
			}else {
				return array(matriz, n, m + matriz[n].length);
			}
		}else {
			return 0;
		}            
	}
	
	
	
}
