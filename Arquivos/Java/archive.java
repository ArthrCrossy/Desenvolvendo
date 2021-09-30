import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class archive {


    public static boolean eh_igual(float k){

        if((int)k==k){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args)throws Exception{

        // abre arquivo
        File arquivo = new File("arquivo.txt");

        // cria um objeto para navegar sobre um arquivo, rw no modo ler e escrever
        RandomAccessFile arq = new RandomAccessFile(arquivo, "rw");

    
        int cont = MyIO.readInt();

        // declrando variaveis
        int i = 0;
        float x;
        long y = 4;

        // conta até o 80
        while(i<cont){

            x = MyIO.readFloat();
            // converte em float
            arq.writeFloat(x);
            i = i + 1;
        }

        // retorna o deslocamento em bites do começo do arquivo
        y = arq.getFilePointer();
        y = y - 8;

        i = 0;

        try{

            do{
                // acha onde tá a proxima variavel
                arq.seek(y);
                // converte para float
                x = arq.readFloat();
                // acha onde tá a proxima variavel
                arq.seek(y);
                // verifica se é igual
                if(eh_igual(x)){
                    // até o proximo
                    y = y - 8;
                    MyIO.println((int)y);
                }else{
                    // até o proximo
                    y = y - 8;
                    MyIO.println(y);
                }
                

            i = i + 1;
            }while(i < cont);

        }catch(FileNotFoundException erro){
            MyIO.println("ERRO");
        }catch(IOException erro){
            MyIO.println("ERRO");
        }

        arq.close();
    }
    
}
