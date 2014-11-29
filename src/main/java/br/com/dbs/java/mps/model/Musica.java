package br.com.dbs.java.mps.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Musica implements Serializable {

    private static final long serialVersionUID = 7662218935243422233L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private Integer duracao;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cantor_id")
    private Cantor cantor;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        if (duracao != null) {
            int minutos = getMinutosDuracao();
            int segundos = getSegundosDuracao();
                    
            return String.format("%d:%02d", minutos, segundos);
        }
        return null;
    }

    private int getSegundosDuracao() {
        int segundos = duracao % 60;
        return segundos;
    }

    private int getMinutosDuracao() {
        int minutos = duracao / 60;
        return minutos;
    }
    
    public Date getDuracaoDate() {
        if (duracao == null)
            return null;
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MINUTE, getMinutosDuracao());
        cal.set(Calendar.SECOND, getSegundosDuracao());
        
        return cal.getTime();
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
    
    public void setDuracao(Date duracao) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(duracao);
        final int minutos = cal.get(Calendar.MINUTE);
        final int segundos = cal.get(Calendar.SECOND);
        this.duracao = (minutos * 60) + segundos;
    }

    public Cantor getCantor() {
        return cantor;
    }

    public void setCantor(Cantor cantor) {
        this.cantor = cantor;
    }
    
}
