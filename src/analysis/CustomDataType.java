package analysis;

public class CustomDataType {
    private String palavra;
    private int ocorrencias;

    public CustomDataType(String palavra, int ocorrencias){

        this.palavra = palavra;
        this.ocorrencias = ocorrencias;

    }
    public CustomDataType(){

    }

    public String getPalavra(){
        return palavra;
    }

    public int getOcorrencias(){
        return ocorrencias;
    }

    public void setPalavra(){
        //
    }

    public void setOcorrencias(int o){
        ocorrencias = 0;
    }
}
