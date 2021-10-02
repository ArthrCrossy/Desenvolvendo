
public class teste2 {
    
	// Transforma string em vetor de Char
    public static char[] transformaChar(String palavra){

        char[] conv = new char[palavra.length()];

        for(int i = 0; i < palavra.length(); i = i + 1){
            conv[i] = palavra.charAt(i);
        }

        return conv;
    }

	public static char[] ehOr(char[] entrada, int j){

		int stop = 0;
		int answer = 0;
		boolean ehTrue = false;
		boolean continuar = true;
		int i = j;

		return or(entrada, j, stop, answer, ehTrue, continuar, i);
	}

	// limpa tudo que não for o valor chave "V ou F" // ANSWER VALOR CHAVE
	public static char[] limpaOr(char[] entrada, int i,int answer,int stop){

		if(i < stop){

			if( i != answer){

				entrada[i] = ' ';
			}

			i = i + 1;

			limpaOr(entrada, i, answer, stop);

		}

		return entrada;
	}

    public static char[] or(char[] entrada,int j, int stop, int answer, boolean ehtrue, boolean continuar, int i){

			if(entrada[i]==')'){

				entrada[i]=' ';
				// Se não achar o V
				if(!ehtrue){
                    entrada[i-1]='F';
                }
				// encontramos o final
				stop=i;

				// acha a posição do sinal booleano
				if(!ehtrue){
                    stop=i-1;
                }
				// posição do sinal booleano
				i=entrada.length-1;
				continuar =false;
			}
			
			// Achar o V do Or
			if((entrada[i]=='V') && (!ehtrue)){
				answer=i;
				ehtrue=true;
				
			}
		

		if(continuar == true){

			i = i + 1;

			or(entrada, j, stop, answer, ehtrue, continuar, i);


		}

		entrada = limpaOr(entrada, i = j - 2, answer, stop);

		return entrada;
	}

	public static char[] ehAnd(char[] entrada, int j){

		int i = 0;

		i = j;
		
		int answer = 0;
		int stop = 0;
		boolean ehAnd = true;
		boolean continuar = true;

		return and(entrada, i, j, answer, stop, ehAnd, continuar);
	}
	
	public static char[] limpaFuncaoAnd(char[] entrada, int i , int stop, int answer){
		
		if(i <= stop){
			
			if(i != answer){
				entrada[i] = ' ';
			}

			i = i + 1;

			limpaFuncaoAnd(entrada, i, stop, answer);
		}

		return entrada;

	}

    public static char[] and(char[] entrada, int i, int j, int answer, int stop, boolean ehAnd, boolean continuar){
		
		
			if(entrada[i]==')'){

				// aloca o V
				if(ehAnd){
					entrada[i-1]='V';
					
				}else{
					entrada[i-1] = 'F';
				}
				//  acha a posição correspondente
				if(ehAnd){
					answer=i-1;
					//MyIO.println("ANSWER 1" + answer);
				}else{
					answer = i - 1;
					//MyIO.println("ANSWER 2" + answer);
				}
				// acha o )
				stop=i;
				i=entrada.length-1;
				continuar = false;
			}

			// c não encontrar um F é Verdadeiro
			if((entrada[i]=='F') && (ehAnd)){
				answer=i;
				ehAnd=false;
			}
		
			if(continuar == true){

				i = i + 1;

				and( entrada,  i,  j,  answer,  stop,  ehAnd,  continuar);

			}

			// limpa função 
			entrada = limpaFuncaoAnd(entrada, i = j - 3, stop, answer);
	
		return entrada;
	}

	public static char[] ehNot(char[] entrada, int i){

		boolean encontrou = true;
		int stop = 0;
		int j = i;

		int cont = entrada.length;

		return not(entrada, i, encontrou, stop, j, cont);
	}

    public static char[] not(char[] entrada,int j, boolean encontrou, int stop, int i, int cont){
        
		
			// identifica o final da operação
			if(entrada[i]==')'){
				// termina o loop
				encontrou=false;
				// apaga o resto da string
				stop=i+1;
				i=entrada.length-1;
			}

			// Realiza a operação not

			if( encontrou && (entrada[i]=='F') || (entrada[i]=='V')){
				
				if(entrada[i]=='V'){
					entrada[i]='F';
				}
				else{
					entrada[i]='V';
				}
			}


			if(encontrou == true){

				not(entrada, j, encontrou, stop, i = i + 1, cont);
			}



			entrada = limpaFuncaoNot(entrada, i = j - 3, stop);

		
		return entrada;
	}

	// limpa os caracteres
	public static char[] limpaFuncaoNot(char entrada[], int i, int stop){

		// roda enquanto for o limite da operação e limpa
		if(i < stop){

			if((entrada[i] != 'F') && (entrada[i] != 'V')){
				entrada[i] = ' ';
			}

			i = i + 1;

			limpaFuncaoNot(entrada, i, stop);
		}

		return entrada;
	}

	// substitui o A, B, C por V ou F
    public static char[] trocaValor(char[] answer, int[] value){

        char a = 'F', b = 'F', c = 'F';

        if(value.length == 2){
            if(value[0] == 1){
                a = 'V';
            }

            if(value[1] == 1){
                b = 'V';
            }
        }

        if(value.length == 3){
            if(value[0] == 1){
                a = 'V';
            }

            if(value[1] == 1){
                b = 'V';
            }

            if(value[2] == 1){
                c = 'V';
            }
            
        }

        for(int i = 0; i < answer.length; i = i + 1){
            if(answer[i] == 'A'){
                answer[i] = a;
            }

            if(answer[i] == 'B'){
                answer[i] = b;
            }

            if(answer[i] == 'C'){
                answer[i] = c;
            }
        }

        return answer;
    }
    
    public static void main(String[] args){

		// recebe o numero de caracteres
        int numb = MyIO.readInt();

		
        int[] valores = new int[numb];

		// continua a sequência
        while( numb!= 0){

			// aloca os valores
            for(int i = 0; i < numb; i = i + 1){

                valores[i] = MyIO.readInt();

            }
			// recebe a string
            String ex = MyIO.readLine();
			// recebe o vetor de char
            char[] answer = transformaChar(ex);
			// troca o abc pelos valores
            answer = trocaValor(answer, valores);

			
            for(int i = answer.length - 1; i>=0 ; i = i - 1){

			
                if(answer[i] == '('){

                    char operacao = answer[i - 1];

					// descobre c vai ser o not, and, ou or através do caracter final
					if(answer[i - 1] == operacao){

						if(operacao == 't'){

							answer = ehNot(answer, i);
						}

						if( operacao == 'd'){

							answer = ehAnd(answer, i);
						}

						if( operacao == 'r'){

							answer = ehOr(answer, i);

						}
					}
					// continua o loop
                    i = answer.length - 1;
                }
            }

			

			// identifica a resposta
            for(int i=0;i<answer.length;i++){
				if(answer[i]=='V'){
					MyIO.println("1");
				}
				if(answer[i]=='F'){
					MyIO.println("0");
				}
			}


			// dá sequência ao loop
			numb=MyIO.readInt();
			valores =new int[numb];

        }

    }


}


	

		