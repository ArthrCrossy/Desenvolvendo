import java.io.RandomAccessFile;
import java.util.Random;

public class arquivo {

    public static boolean eh_igual(double number){

        if((number - (int) number == 0 )){
            return true;
        }else{
            return false;
        }
    }

    public static void ler_Arquivo(int x, int i){        

        try{

            // cria objeto
            RandomAccessFile read = new RandomAccessFile("arquivo.txt", "r");

            // lê de baixo para cima
            for(i = x - 1; i>= 0 ; i = i - 1){

                // encontra em binario
                read.seek(i*8);

                // converte para float
                double number = read.readDouble();

                // printa depois do ,
                if(eh_igual(number)){
                    MyIO.println((int)number);
                }else{
                    MyIO.println(number);
                }

                
            }

            read.close();


        }catch(Exception exception){
           // MyIO.println("ERRO");
        }

    }

    public static void arquivo(int x, int i){

        try{

            // cria objeto que lê e escreve
            RandomAccessFile arquivo = new RandomAccessFile("arquivo.txt", "rw");
            
            // lê até o final
            for(i = 0; i < x ; i = i + 1){
                
                // escreve no arquivo
                arquivo.writeDouble(MyIO.readDouble()); 
            }
    
            arquivo.close();
            
            // erro
        }catch(Exception exception){
                 // MyIO.println("ERRO");
    
            }

    }

    public static void main(String[] args) {
        
        int x = MyIO.readInt();
        

        
        arquivo(x, 0);
        ler_Arquivo(x, 0);

    }

}