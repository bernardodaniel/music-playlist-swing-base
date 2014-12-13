package br.com.dbs.java.mps.model;

import com.sun.javafx.binding.StringFormatter;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @ManyToOne
    @JoinColumn(name = "cantor_id")
    private Cantor cantor;

    public Long getId() {
        return id;
    }
    
    public Integer getDuracao() {
        if (duracao == null) {
            return 0;
        }
        return duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracaoTexto() {
        if (duracao == null) {
            return null;
        }
        
        int minutos = getDuracaoMinutos();
        int segundos = getDuracaoSegundos();
        String minutosESegundos = 
                String.format("%02d:%02d", minutos, segundos);
        return minutosESegundos;
    }

    private int getDuracaoSegundos() {
        int segundos = duracao % 60;
        return segundos;
    }

    private int getDuracaoMinutos() {
        int minutos = duracao / 60;
        return minutos;
    }
    
    public Date getDuracaoDate() {
        if (duracao == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, getDuracaoMinutos());
        calendar.set(Calendar.SECOND, getDuracaoSegundos());
        return calendar.getTime();
    }

    public void setDuracao(Date duracao) {
        if (duracao == null) {
            this.duracao = null;
            return;
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(duracao);
        int minuto = calendar.get(Calendar.MINUTE);
        int segundos = calendar.get(Calendar.SECOND);
        
        this.duracao = minuto * 60 + segundos;
    }

    public Cantor getCantor() {
        return cantor;
    }

    public void setCantor(Cantor cantor) {
        this.cantor = cantor;
    }
    
}
