public class Pesquisa {
    private int idPesquisa;
    private int dataPesquisa;

    public int getIdPesquisa() {
        return idPesquisa;
    }
    
    public void setIdPesquisa(int idPesquisa) {
        this.idPesquisa = idPesquisa;
    }
    
    public int getDataPesquisa() {
        return dataPesquisa;
    }
    
    public void setDataPesquisa(int dataPesquisa) {
        this.dataPesquisa = dataPesquisa;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Pesquisa outraPesquisa = (Pesquisa) obj;
        return idPesquisa == outraPesquisa.getIdPesquisa();
    }
    
}