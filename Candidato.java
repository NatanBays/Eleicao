public class Candidato {
    private int idCandidato;
    private String nome;
    private String nomePartido;
    private int numeroPartido;

    public int getIdCandidato() {
        return idCandidato;
    }
    
    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNomePartido() {
        return nomePartido;
    }
    
    public void setNomePartido(String nomePartido) {
        this.nomePartido = nomePartido;
    }
    
    public int getNumeroPartido() {
        return numeroPartido;
    }
    
    public void setNumeroPartido(int numeroPartido) {
        this.numeroPartido = numeroPartido;
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

        Candidato outroCandidato = (Candidato) obj;
        return idCandidato == outroCandidato.getIdCandidato();
    }
    
}