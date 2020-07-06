package com.ingsw.consigliaviaggi.model;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Date;
@Entity
public class Recensione {

    private long id;
    private int voto;
    private String descrizione;
    private int likes;
    private int dislikes;
    private Date dataDiAggiunta;
    private Utente autore;
    private Struttura struttura;

    public Recensione() {
    }

    public Recensione(int voto, String descrizione) {
        this.voto = voto;
        this.descrizione = descrizione;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int like) {
        this.likes = like;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislike) {
        this.dislikes = dislike;
    }

    public Date getDataDiAggiunta() {
        return dataDiAggiunta;
    }

    public void setDataDiAggiunta(Date dataDiAggiunta) {
        this.dataDiAggiunta = dataDiAggiunta;
    }

    @ManyToOne
    @JoinColumn
    public Utente getAutore() {
        return autore;
    }

    public void setAutore(Utente autore) {
        this.autore = autore;
    }

    @ManyToOne
    @JoinColumn
    public Struttura getStruttura() {
        return struttura;
    }

    public void setStruttura(Struttura struttura) {
        this.struttura = struttura;
    }

    public static class DataComparator implements Comparator<Recensione> {


        @Override
        public int compare(Recensione o1, Recensione o2) {

            if(o1.getDataDiAggiunta().before(o2.getDataDiAggiunta())){
                return -1;
            }
            else if(o1.getDataDiAggiunta().after(o2.getDataDiAggiunta())){
                return 1;
            }
            else{ return 0;}
        }
    }

    public static class VoteComparator implements Comparator<Recensione> {


        @Override
        public int compare(Recensione o1, Recensione o2) {

            if(o1.getVoto() <o2.getVoto()){
                return -1;
            }
            else if(o1.getVoto() >o2.getVoto()){
                return 1;
            }
            else{ return 0;}
        }
    }
}
