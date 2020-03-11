package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int songID, jam, menit, detik, select, cek;
        String judul, penyanyi;

        ArrayList<MusicPlayer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("1. Tambah lagu\n2. Putar lagu\n3. Statistik\n4. Detail lagu\n5. Edit playlist\n6. Exit program");
            select = scanner.nextInt();

            switch (select) {
                case 1: // Tambah lagu
                    System.out.println("Tambah lagu dengan ID, judul, penyanyi, dan durasi : ");
                    songID = scanner.nextInt();
                    judul = br.readLine();
                    penyanyi = br.readLine();
                    jam = scanner.nextInt();
                    menit = scanner.nextInt();
                    detik = scanner.nextInt();
                    list.add(new MusicPlayer(songID, judul, penyanyi, jam, menit, detik));
                    System.out.println("Lagu " + judul + " oleh " + penyanyi + " sudah di playlist Anda :)");
                    break;

                case 2: // Play lagu
                    System.out.print("Putar lagu dengan index : ");
                    int indexLagu = scanner.nextInt();
                    for (int i = 0; i < list.size(); i++) {
                        if (i == indexLagu) {
                            System.out.println("Memutar Lagu");
                            System.out.println(list.get(i).getJudul() + " sekarang");
                            list.get(i).addPlayed();
                            System.out.println();
                        }
                    }

                case 3:
                    do {
                        System.out.println("1.Berapa Banyak Lagu yang Di Playlist?\n2.Diurutkan berdasarkan judul\n3.Diurutkan berdasarkan yng sering diputar\n4.Batal");
                        cek = scanner.nextInt();

                        switch (cek) {
                            case 1:
                                System.out.println("You Have : " + list.size() + " lagu ada di playlistmu");
                                break;
                            case 2:
                                System.out.println("Playslist diurutan berdasarkan judul");
                                for (int i = 0; i < list.size(); i++)
                                    list.sort(new MusicPlayer.compareJudul());
                                for (MusicPlayer lagu : list)
                                    System.out.println(lagu.getJudul());
                                break;

                            case 3:
                                System.out.println("Playslist diurutkan berdasarkan lagu yang sering diputar");
                                for (int i = 0; i < list.size(); i++)
                                    list.sort(new MusicPlayer.compareMostPlayed());
                                for (MusicPlayer lagu : list)
                                    System.out.println(lagu.getJudul());
                                break;
                        }
                    }
                    while (cek <= 3);
                    break;

                case 4:
                    do {
                        System.out.println("1. Tampilkan isi playlist\n2. Cari lagu dalam playlist\n3. Cancel");
                        cek = scanner.nextInt();

                        switch (cek) {
                            case 1:
                                if (list.isEmpty())
                                    System.out.println("Playlist kamu kosong");
                                else
                                    for (MusicPlayer lagu : list) {
                                        lagu.tampilan();
                                        System.out.println();
                                    }
                                break;
                            case 2:
                                System.out.println("Cari lagumu berdasarkan penyanyi atau judul : ");
                                String cariLagu = scanner.next();
                                for (MusicPlayer lagu : list) {
                                    if (lagu.getJudul().contains(cariLagu)) {
                                        lagu.tampilan();
                                        System.out.println();
                                    } else if (lagu.getPenyanyi().contains(cariLagu)) {
                                        lagu.tampilan();
                                        System.out.println();
                                    }
                                }
                                break;
                        }
                    }
                    while (cek <= 2);

                case 5:
                    System.out.print("Cari judul lagu yang ingin kamu ubah : ");
                    String cariJudul = scanner.next();
                    for (MusicPlayer lagu: list) {
                        if (lagu.getJudul().contains(cariJudul)) {
                            System.out.print("Judul yang baru : ");
                            judul = br.readLine();
                            lagu.setJudul(judul);
                            System.out.print("Penyanyi yang baru : ");
                            penyanyi = br.readLine();
                            lagu.setPenyanyi(penyanyi);
                            System.out.println("Berhasil Ubah Data");
                        }
                    }
                    break;
            }
        }
        while (select <= 5);
    }
}