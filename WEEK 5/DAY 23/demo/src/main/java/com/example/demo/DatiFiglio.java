package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatiFiglio {
    private String nome;
    private int eta;

    @Override
    public String toString() {
        return "DatiFiglio [nome=" + nome + ", eta=" + eta + "]";
    }

    
    public DatiFiglio(@Value("${figlio.nome}") String nome,
                        @Value("${figlio.eta}") int eta) {
                            this.nome = nome;
                            this.eta = eta;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getEta() {
        return eta;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }

    

}
