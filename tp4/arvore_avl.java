import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

class Filmes implements Cloneable {

    // declarando variaveis
    private String nome;
    private String Formato;
    private String Duracao;
    private String pais;
    private String idioma;
    private String Emissora;
    private String transmissao;
    private int numberTemp;
    private int numberEp;
    
    // declarando construtor
    public Filmes(){
        
    }

    // print
    public String toString(){

        return this.nome + " " + this.Formato + " " + this.Duracao + " " + this.pais + " " + this.idioma + " " + this.Emissora + " " + this.transmissao + " " + this.numberTemp + " " + this.numberEp;
    }

    // construtura jova
    public Filmes(String nome, String Formato, String Duracao, String pais, String idioma, String Emissora, String transmissao, int numberTemp, int numberEp){
        this.Formato = Formato;
        this.Duracao = Duracao;
        this.pais = pais;
        this.idioma = idioma;
        this.Emissora = Emissora;
        this.transmissao = transmissao;
        this.numberTemp = numberTemp;
        this.numberEp = numberEp;
        
    }

    // Gets e Sets
    public String getNome(){
        return this.nome;
    }

    public String getFormato(){
        return this.Formato;
    }

    public String getDuracao(){
        return this.Duracao;
    }

    public String getPais(){
        return this.pais;
    }

    public String getIdioma(){
        return this.idioma;
    }

    public String getEmissora(){
        return this.Emissora;
    }

    public String getTransmissao(){
        return this.transmissao;
    }

    public int getNumberTemp(){
        return this.numberTemp;
    }

    public int getNumberEp(){
        return this.numberEp;
    }

    public void SetNome(String nome){
        this.nome = nome;
    }

    public void setFormato(String Formato){
        this.Formato = Formato;
    }

    public void setDuracao(String Duracao){
        this.Duracao = Duracao;
    }

    public void setPais(String pais){
        this.pais = pais;
    }

    public void setIdioma(String idioma){
        this.idioma = idioma;
    }

    public void setEmissora(String Emissora){
        this.Emissora = Emissora;
    }

    public void setTransmissao(String transmissao){
        this.transmissao = transmissao;
    }

    public void setNumbertemp(int numberTemp){
        this.numberTemp = numberTemp;
    }

    public void setNumberEp(int numberEp){
        this.numberEp = numberEp;
    }

    // Clone
    Filmes getClone(){
        try {
            return (Filmes) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("ERRO CLONE");
            return this;
        }
    }

    public void leFilme(String nomeArquivo){

        String linhaFormato = "";
        String linhaTemporada = "";
        String novaTemporada = "";
        String linhaOrigem = "";
        String novoOrigem = "";
        String novoFormato = "";
        String linhaEmissora = "";
        String linhaIdioma = "";
        String novoIdioma = "";
        String novaEmissora = "";
        String linhaEpisodio = "";
        String novoEpisodio = "";
        String linhaTransmissao = "";
        String novaTransmissao = "";
        String linhaDuracao = "";
        String novaDuracao = "";
        String linhaTitulo = "";
        String novoTitulo = "";
        
        int i =0;

        // concatena o string
              String x = "/tmp/series/";
              x += nomeArquivo;
        //    Arq.openRead(nomeArquivo, "UTF-8");      
              Arq.openRead(x, "UTF-8");

        //Descobre a posi????o no site
        for(i = 0; i <5; i = i + 1){
            linhaTitulo = Arq.readLine();
        }
        
        linhaTitulo = limpaDados(linhaTitulo);
        novoTitulo = limpaTitulo(linhaTitulo);
        SetNome(novoTitulo);

        //Descobre a posi????o no site
        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaFormato.contains("Formato")){
               
               break;
            }
            linhaFormato = Arq.readLine();
        }

        
        for(i = 0; i <1; i = i + 1){
            linhaFormato = Arq.readLine();
            novoFormato = limpaDados(linhaFormato);

        }

        setFormato(novoFormato);

        
        //Descobre a posi????o no site
        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaDuracao.contains("Dura????o")){
                break;
            }
            linhaDuracao = Arq.readLine();
        }

        for(i = 0; i <1; i = i + 1){
            linhaDuracao = Arq.readLine();
            novaDuracao = limpaDados(linhaDuracao);

        }

        setDuracao(novaDuracao);

        //Descobre a posi????o no site
        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaOrigem.contains("Pa??s de origem")){
                break;
            }
            linhaOrigem = Arq.readLine();
        }

        //Descobre a posi????o no site
        for(i = 0; i <1; i = i + 1){
            linhaOrigem = Arq.readLine();
            novoOrigem = limpaDados(linhaOrigem);

        }

        setPais(novoOrigem);

        //Descobre a posi????o no site
        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaIdioma.contains("Idioma original")){
                break;
            }
            linhaIdioma = Arq.readLine();
        }

        for(i = 0; i <1; i = i + 1){
            linhaIdioma = Arq.readLine();
            novoIdioma = limpaDados(linhaIdioma);

        }
        
        setIdioma(novoIdioma);

        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaEmissora.contains("Emissora")){
                break;
            }
            linhaEmissora = Arq.readLine();
        }

        for(i = 0; i <1; i = i + 1){
            linhaEmissora = Arq.readLine();
            novaEmissora = limpaDados(linhaEmissora);
        }

        setEmissora(novaEmissora);

        //Descobre a posi????o no site
        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaTransmissao.contains("Transmiss??o original")){
                break;
            }
            linhaTransmissao = Arq.readLine();
        }

        for(i = 0; i <1; i = i + 1){
            linhaTransmissao = Arq.readLine();
            linhaTransmissao = firstDataTreat(linhaTransmissao);
            novaTransmissao = limpaDadosData(linhaTransmissao);
        }

        setTransmissao(novaTransmissao);
        
        //Descobre a posi????o no site
        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaTemporada.contains("N.?? de temporadas")){
                break;
            }
            linhaTemporada = Arq.readLine();
        }

        for(i = 0; i <1; i = i + 1){
            linhaTemporada = Arq.readLine();
            novaTemporada = limpaDados(linhaTemporada);
            novaTemporada = limpastringTemp(novaTemporada);
            
        }

        //Descobre a posi????o no site
        setNumbertemp(Integer.parseInt(novaTemporada));

        for(i =0; Arq.hasNext() == true; i = i + 1){
            
            if(linhaEpisodio.contains("N.?? de epis??dios")){
                break;
            }
            linhaEpisodio = Arq.readLine();
        }

        for(i = 0; i <1; i = i + 1){
            
            linhaEpisodio = Arq.readLine();
            novoEpisodio = limpaDados(linhaEpisodio);
            novoEpisodio = limpaListaEpisodios(novoEpisodio);
            novoEpisodio = limpastringEp(novoEpisodio);
           
        }

        setNumberEp(Integer.parseInt(novoEpisodio));

//        MyIO.println(toString());
        Arq.close();

    }

    // numeros
    public String limpastringEp(String s){

        String novoS = "";
        int tam = s.length();
        
        for(int i  = 0; i < tam; i = i +1){
        novoS =  novoS + s.charAt(i);
        }

        novoS = novoS.trim();

        return novoS;
    }

        // limpa as temporadas
    public String limpaListaEpisodios(String ep){

        int tam = ep.length();
        String newEp = "";
        boolean continuar = true;

        for(int i = 0; i < tam && continuar == true; i = i + 1){
            
            // apenas numneros
            if(ep.charAt(i) >= 48 && ep.charAt(i)<= 57){
                newEp = newEp + ep.charAt(i);
            }
            // quebra c tiver string
            if(ep.charAt(i) == '+' || ep.charAt(i) == '-'  || ep.charAt(i) == ' '){
                continuar = false;
                
            }

        }

        return newEp;
    }

    // limpa as temporadas
    public String limpastringTemp(String ep){

        int tam = ep.length();
        String newEp = "";
        boolean continuar = true;

        for(int i = 0; i < tam && continuar == true; i = i + 1){

            // Apenas numeros
            if(ep.charAt(i) >= 48 && ep.charAt(i)<= 57){
                newEp = newEp + ep.charAt(i);
            }
            // quebra c tiver string
            if(ep.charAt(i) == '+' || ep.charAt(i) == '-'  || ep.charAt(i) == ' '){
                continuar = false;
                
            }

        }

        //newEp = newEp.trim();

        return newEp;
    }

    // limpa o titulo 
    public String limpaTitulo(String palavra){

        String novaPalavra = "";
        int tam = palavra.length();
        boolean ehTrue = true;


        for(int i = 0; i < tam && ehTrue; i = i + 1){

            if(palavra.charAt(i) == '???' || palavra.charAt(i) == '('){

                ehTrue = false;
            }else{
                novaPalavra = novaPalavra + palavra.charAt(i);
            }


        }

        novaPalavra = novaPalavra.trim();


        return novaPalavra;
    }


    // consegue limpar conte??do entre < e > e &
    // e adicionar em novaPalavra
    public String limpaDados(String palavra){

        String novaPalavra = "";
        int tam = palavra.length();

        for(int i = 0; i < tam; i = i + 1){
            if(palavra.charAt(i) == '<' || palavra.charAt(i) == '&'){
                for(int y = i; y < tam; y = y + 1){
                    if(palavra.charAt(y) == '>'){
                        
                        i = y;
                        y = tam;
                    }
                }
            }else{

                novaPalavra = novaPalavra + palavra.charAt(i);
            }
        }

        novaPalavra = novaPalavra.trim();


        return novaPalavra;
    }

    // retira &#160;
    public String firstDataTreat(String palavra){
        /*&#160;*/
        
        String novaPalavra = palavra.replace("&#160;", "");

        return novaPalavra;
    }

    // consegue limpar conte??do entre < e > e &
    // e adicionar em novaPalavra
    public String limpaDadosData(String palavra){

        String novaPalavra = "";
        int tam = palavra.length();

        for(int i = 0; i < tam; i = i + 1){
            if(palavra.charAt(i) == '<' || palavra.charAt(i) == '&'){
                for(int y = i; y < tam; y = y + 1){
                    if(palavra.charAt(y) == '>'){
                        i = y;
                        y = tam;
                    }
                }
            }else{

                novaPalavra = novaPalavra + palavra.charAt(i);
            }
        }

        novaPalavra = novaPalavra.trim();

        return novaPalavra;
    }

}

// classe Pilha

class No{

    public Filmes elemento;
    public No esq, dir;
    public int nivel;
    public int somp_comparacoes = 0;
    
    public No(Filmes elemento){
        this(elemento, null, null, 1);
    }

    public No(Filmes elemento, No esq, No dir, int nivel){

        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.nivel = nivel;
    }

    public void setNivel(){
        this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
    }

    public static int getNivel(No n) {
        return (n == null) ? 0 : n.nivel;
    }
}

class arvoreAvl {

	private No raiz;

    public arvoreAvl(){
        raiz = null;
    }

    public boolean pesquisar(String x) {
        MyIO.print("raiz ");
		return pesquisar(x, raiz, 0);
	}

	private boolean pesquisar(String x, No i, int somp_comparacoes) {
        boolean resp;
        int comp = 0;


        long comeco = new Date().getTime();

        if (i == null) {
            resp = false;
            comp = comp + 1;
            somp_comparacoes = somp_comparacoes + 1;
        } else if (x.compareTo(i.elemento.getNome()) > 0) {
            MyIO.print("dir ");
            comp = comp + 1;
            somp_comparacoes = somp_comparacoes + 1;
            resp = pesquisar(x, i.dir, somp_comparacoes);

        } else if (x.compareTo(i.elemento.getNome()) < 0) {
            MyIO.print("esq ");
            comp = comp + 1;
            somp_comparacoes = somp_comparacoes + 1;
            resp = pesquisar(x, i.esq, somp_comparacoes);

        } else {
            resp = true;
        }


        long fim = new Date().getTime();

        try{

            File arquivo = new File("713229_insercao.txt");

            if(!arquivo.exists()){
                arquivo.createNewFile();
            }

            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Tempo: " + ( fim - comeco ) + " milisegundos ...\n");
            bw.write("comparacoes: " + somp_comparacoes);
            bw.close();
            fw.close();

        } catch(Exception e){
            System.out.println(e);
        }

        return resp;
    }

    public boolean pesquisarSemPrint(String x) throws Exception{
        return pesquisarSem(x, raiz);
    }

    private boolean pesquisarSem(String x, No i) throws Exception{

        boolean resp;

        if(i == null){
            resp = false;
        }else if(x.compareTo(i.elemento.getNome()) > 0){
            resp = pesquisarSem(x, i.dir);

        }else if(x.compareTo(i.elemento.getNome()) < 0){
            resp = pesquisarSem(x, i.esq);
        }else{
            resp = true;
            remover(i);
        }



        return resp;
    }

    public void caminhoPre(){
        caminharPre(raiz);
    }

    private void caminharPre(No i){

        if(i != null){

            MyIO.println(i.elemento.getNome());
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }

    public void inserir(Filmes x) throws Exception {
		raiz = inserir(x, raiz);
	}
	private No inserir(Filmes x, No i) throws Exception {
		if (i == null) {
         i = new No(x);

        } else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
            i.esq = inserir(x, i.esq);

        } else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
            i.dir = inserir(x, i.dir);

        } else {
            throw new Exception("Erro ao inserir!");
        }

        i = balancear(i);

		return i;
	}

    public Filmes getRaiz() throws Exception{

        return raiz.elemento;
    }

    public static boolean igual(No i_1, No i_2){

        boolean resp;

        if(i_1 != null && i_2 != null){
            resp = ((i_1.elemento == i_2.elemento) && igual(i_1.esq, i_2.esq) && igual(i_1.dir, i_2.dir));
        }else if((i_1 == null && i_2 == null)){
            resp = true;
        }else{
            resp = false;
        }

        return resp;
    }

    public void remover(No x) throws Exception {
		raiz = remover(x.elemento, raiz);
	}

	private No remover(Filmes x, No i) throws Exception {

		if (i == null) {
         throw new Exception("Erro ao remover!");

      } else if (x.getNome().compareTo(i.elemento.getNome()) < 0) {
         i.esq = remover(x, i.esq);

      } else if (x.getNome().compareTo(i.elemento.getNome()) > 0) {
         i.dir = remover(x, i.dir);

      } else if (i.dir == null) {
         i = i.esq;

      } else if (i.esq == null) {
         i = i.dir;

      } else {
         i.esq = maiorEsq(i, i.esq);
		}

		return i;
	}


	private No maiorEsq(No i, No j) {

		if (j.dir == null) {
			i.elemento = j.elemento; 
            j = j.esq;
		} else {
			j.dir = maiorEsq(i, j.dir);
		}
		return j;
	}

    public void caminharPos(){
        caminharPos(raiz);
    }

    public void caminharCentral(){
        caminharCentral(raiz);
    }

    private void caminharCentral(No i){
        if(i != null){
            caminharCentral(i.esq);
            MyIO.print(i.elemento.getNome() + " ");
            caminharCentral(i.dir);
        }
    
    }

    private void caminharPos(No i){
        if(i != null){
            caminharPos(i.esq);
            caminharPos(i.dir);
            MyIO.print(i.elemento.getNome() + " ");
        }
    }

    private No balancear(No no) throws Exception {

        if(no != null){
           int fator = (No.getNivel(no.dir) - no.getNivel(no.esq));
  
           if (Math.abs(fator) <= 1){
              no.setNivel();
  
           }else if (fator == 2){
  
              int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);
  
              if (fatorFilhoDir == -1) {
                 no.dir = rotacionarDireita(no.dir);
              }
              no = rotacionarEsquerda(no);
  
           }else if (fator == -2){
  
              int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);
  
              if (fatorFilhoEsq == 1) {
                 no.esq = rotacionarEsquerda(no.esq);
              }
              no = rotacionarDireita(no);
  
           }else{
              throw new Exception("Erro no No(" + no.elemento + ") com fator de balanceamento (" + fator + ") invalido!"); 
           }
        }
  
        return no;
     }

     private No rotacionarDireita(No no){

        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        no.setNivel();
        noEsq.setNivel();

        return noEsq;


     }

     private No rotacionarEsquerda(No no){

        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        no.setNivel();
        noDir.setNivel();

        return noDir;

     }
   
}
 
public class arvore_avl{

    public static boolean ehFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static char[] transformaChar(String s){

        char[] palavra = new char[s.length()];

        for(int i = 0; i < s.length(); i = i + 1){
            palavra[i] = s.charAt(i);
        }

        return palavra;
    }

    public static void main(String[] args) throws Exception {

        MyIO.setCharset("UTF-8");

        rodar();

    }

    // quebra String pegar s?? o html
    public static String transformaString(String s){

        String newPalavra = new String();

        for(int i = 2; i < s.length(); i = i + 1){

            newPalavra = newPalavra + s.charAt(i) ;

        }

        return newPalavra;
    }

    public static String transformarStringpespaco(String s){

        String newPalavra = new String();

        for(int i = 6; i < s.length(); i = i + 1){

            if(s.charAt(i) != ' ' || s.charAt(i) != 240){

                newPalavra = newPalavra + s.charAt(i);

            }

        }

        return newPalavra;
    }

    // Transforma numero em String
    public static String transformarNumero(String s){

        String palavra = new String();
        int cont = 0;
        boolean ok = true;

        for(int i = 0; i < s.length() && ok == true; i = i + 1){

            if(s.charAt(i) >= 48 && s.charAt(i) <= 57){

                palavra = palavra + s.charAt(i);
                cont = cont + 1;

                if(cont == 2){
                    ok = false;
                }
            }
        }

        return palavra;
    }

    // transforma o vetor de string para uma pilha de objeto
    public static arvoreAvl preencheArvore(String input[], int n, arvoreAvl x) throws Exception {

        Filmes[] vetor = new Filmes[100];
        for(int i = 0; i < n; i = i + 1){
            vetor[i] = new Filmes();

            vetor[i].leFilme(input[i]);
            x.inserir(vetor[i]);
        }

     //   x.caminharCentral();

        return x;
    }

    // insere ou remove
    public static void verifica(arvoreAvl x) throws Exception{

        int tam = MyIO.readInt();
        String palavra = new String();

        while(tam > 0){

            Filmes html = new Filmes();
            palavra = MyIO.readLine();

            if(palavra.charAt(0) == 'I'){

                palavra = transformaString(palavra);
                html.leFilme(palavra);
                x.inserir(html);
            }

            if(palavra.charAt(0) == 'R'){
                
                palavra = transformaString(palavra);
                x.pesquisarSemPrint(palavra);
            }

            tam = tam - 1;
        }


    }

    public static void rodar() throws Exception{

        int i = -1, j = - 1;

        String[] input = new String[100];
        String[] input_2 = new String[100];

        arvoreAvl x = new arvoreAvl();

        do{
             i = i + 1;
            input[i] = MyIO.readLine();

        }while(!ehFim(input[i]));
        x = preencheArvore(input, i, x);
        
        do{
            j = j + 1;
           input_2[j] = MyIO.readLine();

       }while(!ehFim(input_2[j]));
     
        for(int l = 0; l < j; l = l + 1){
            boolean resp = x.pesquisar(input_2[l]);
            if(resp == true){
                MyIO.println("SIM");
            }else{
                MyIO.println("NAO");
            }
        }
    }

}