public class Aluno {

    String rgm;                     // RGM DO ALUNO
    LSEncadeada disciplinas;        // Disciplinas do aluno do "tipo"  -> LSEncadeada

    // MÉTODOS GETTERS E SETTERS
    // (GET -> retorna seu valor | SET -> define ou atualiza), métodos de acesso e modificação
    public String getRgm() {
        return rgm;
    }
    public void setRgm(String rgm) {
        this.rgm = rgm;
    }
    
    public LSEncadeada getDisciplinas() {
        return disciplinas;
    }
    public void setDisciplinas(LSEncadeada disciplinas) {
        this.disciplinas = disciplinas;
    }   
}
