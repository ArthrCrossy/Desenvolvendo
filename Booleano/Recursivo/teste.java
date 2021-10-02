public class teste {
    
	// Transforma string em vetor de Char
    public static char[] transformaChar(String palavra){

        char[] conv = new char[palavra.length()];

        for(int i = 0; i < palavra.length(); i = i + 1){
            conv[i] = palavra.charAt(i);
        }

        return conv;
    }

    public static char[] or(char[] entrada,int j){

		int stop=0;
		int answer=0;
		boolean ehtrue=false;


		for(int i=j ;i< (entrada.length); i = i + 1 ){

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
			}
			
			// Achar o V do Or
			if((entrada[i]=='V') && (!ehtrue)){
				answer=i;
				ehtrue=true;
			}
		}

		// tudo que não for pula troca
		for(int i=j-2;i<stop;i++){

			if(i != answer){
				entrada[i] = ' ';
			}

		}
		return entrada;
	}

    public static char[] and(char[] entrada, int j){

		int stop=0;
		int answer=0;
		boolean ehAnd=true;

		for(int i=j; i < (entrada.length); i++){

			if(entrada[i]==')'){

				entrada[i]=' ';
				// aloca o V
				if(ehAnd){
					entrada[i-1]='V';
				}
				//  acha a posição correspondente
				if(ehAnd){
					answer=i-1;
				}
				// acha o )
				stop=i;
				i=entrada.length-1;
			}

			// c não encontrar um F é Verdadeiro
			if((entrada[i]=='F') && (ehAnd)){
				answer=i;
				ehAnd=false;
			}
		}

		for(int i=j-3;i<stop;i++){
			// se for diferente de resp pula 
			if(i!=answer){
				entrada[i] = ' ';
			}

		}
		return entrada;
	}

    public static char[] not(char[] entrada,int j){
        
		boolean encontrou=true;
		int stop=0;

		for(int i=j; i<= (entrada.length) && encontrou;i = i + 1){
			// identifica o final da operação
			if(entrada[i]==')'){
				// termina o loop
				encontrou=false;
				// apaga o resto da string
				entrada[i]=' ';
				stop=i;
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
		}

		// apaga tudo que não são os sinais V ou F
		for(int i=j-3;i<stop;i++){

			if( (entrada[i]!='F') && (entrada[i]!='V' )){
				entrada[i]=' ';
			}	
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

							answer = not(answer, i);
						}

						if( operacao == 'd'){

							answer = and(answer, i);
						}

						if( operacao == 'r'){

							answer = or(answer, i);

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
