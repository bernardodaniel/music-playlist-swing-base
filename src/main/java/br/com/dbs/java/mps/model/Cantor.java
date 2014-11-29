package br.com.dbs.java.mps.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Cantor implements Serializable {

    private static final long serialVersionUID = -7858279235379390783L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255, nullable = false)
    private String nome;
    @Column(length = 255)
    private String sobrenome;
    @Lob
    private byte[] foto;
    @OneToMany(mappedBy = "cantor")
    private List<Musica> musicas;

    @Override
    public String toString() {
        return getNomeCompleto();
    }

    
    
    public Long getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the foto
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public String getNomeCompleto() {
        return getNome() + " " + getSobrenome();
    }

}
