package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.channels.Pipe.SourceChannel;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Socket mioSocket = new Socket("172.16.125.150", 3001);

        BufferedReader in = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
        PrintWriter out = new PrintWriter(mioSocket.getOutputStream(), true);
        System.out.println("Collegato");
        System.out.println(in.readLine());

        Scanner scanner = new Scanner(System.in);

        System.out.println("CLIENT CALCOLATRICE");

        System.out.print("Inserisci il primo numero: ");
        String primoNumero = scanner.nextLine();

        System.out.print("Inserisci l'operatore (+, -, *, /): ");
        String operatore = scanner.nextLine();

        System.out.print("Inserisci il secondo numero: ");
        String secondoNumero = scanner.nextLine();

        scanner.close();



        String ris = "";

        if (operatore.equals("+")) {
            ris = ris + "s1";
        } else if (operatore.equals("-")) {
            ris = ris + "s2";
        } else if (operatore.equals("*")) {
            ris = ris + "m";
        } else if (operatore.equals("/")) {
            ris = ris + "d";
        }

        ris = ris + "," + primoNumero + "," + secondoNumero;

        System.out.println(ris);

        out.println(ris);

        String risposta = in.readLine();
        System.out.println("Risposta ricevuta dal server: " + risposta);

        mioSocket.close();
        scanner.close();



    }
}