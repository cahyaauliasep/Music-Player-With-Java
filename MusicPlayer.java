package com.company;

import java.util.Comparator;

public class MusicPlayer {
    private int idLagu, totalWaktu, played;
    private String judul, penyanyi;

    public MusicPlayer(int idLagu, String judul, String penyanyi, int jam, int menit, int detik) {
        this.idLagu = idLagu;
        this.judul = judul;
        this.penyanyi = penyanyi;
        this.totalWaktu = (jam * 3600) + (menit *60) * detik;
    }

    static class compareMostPlayed implements Comparator<MusicPlayer> {
        @Override
        public int compare(MusicPlayer lagu1, MusicPlayer lagu2) {
             if (lagu1.getPlayed() <= lagu2.getPlayed())
                 return 1;
             else
                 return -1;
        }
    }

    static class compareJudul implements Comparator<MusicPlayer> {
        @Override
        public int compare(MusicPlayer lagu1, MusicPlayer lagu2) {
            return lagu1.getJudul().compareTo(lagu2.getJudul());
        }
    }

    public void tampilan() {

    }

    public int getIdLagu() {
        return idLagu;
    }

    public int getTotalWaktu() {
        return totalWaktu;
    }

    public int getPlayed() {
        return played;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenyanyi() {
        return penyanyi;
    }

    public void setPlayed() {
        this.played += 1;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenyanyi(String penyanyi) {
        this.penyanyi = penyanyi;
    }

    public void addPlayed() {
        setPlayed();
    }
}
