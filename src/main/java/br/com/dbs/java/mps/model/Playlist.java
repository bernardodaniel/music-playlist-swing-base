package br.com.dbs.java.mps.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Playlist implements Serializable {

    private static final long serialVersionUID = -4945996795610093848L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 255, nullable = false)
    private String nome;
    
    private Integer quantidadeDeExecucoes;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDaUltimaExecucao;
    
    @Temporal(TemporalType.DATE)
    private Date dataDaCriacao;
    
    private Integer duracaoTotal;
    
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "playlist_musica")
    private final List<Musica> musicas = new ArrayList<>();

    public void adicionaMusica(Musica musica) {
        musicas.add(musica);
    }

    public Long getId() {
        return id;
    }
    
    /**
     * @return the musicas
     */
    public List<Musica> getMusicas() {
        return musicas;
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
     * @return the quantidadeDeExecucoes
     */
    public Integer getQuantidadeDeExecucoes() {
        return quantidadeDeExecucoes;
    }

    /**
     * @return the dataDaUltimaExecucao
     */
    public Date getDataDaUltimaExecucao() {
        return dataDaUltimaExecucao;
    }

    /**
     * @return the dataDaCriacao
     */
    public Date getDataDaCriacao() {
        return dataDaCriacao;
    }

    /**
     * @return the duracaoTotal
     */
    public Integer getDuracaoTotal() {
        return duracaoTotal;
//        int segundos = 14400; 
//        int segundo = segundos % 60; 
//        int minutos = segundos / 60; 
//        int minuto = minutos % 60; 
//        int hora = minutos / 60; 
//        String hms = String.format ("%02d:%02d:%02d", hora, minuto, segundo); 
//        System.out.println (hms); // deve mostrar "04:00:00"
    }

}
