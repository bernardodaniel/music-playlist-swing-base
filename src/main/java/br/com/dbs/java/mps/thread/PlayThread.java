package br.com.dbs.java.mps.thread;


public class PlayThread extends Thread {
    private String nome;

    public PlayThread(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void run() {
        
        while (!Thread.interrupted()) {
            System.out.println("Executando a playlist: " + nome);
        }
        
    }
    
}
