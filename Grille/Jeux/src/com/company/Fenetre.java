package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Fenetre extends JFrame implements MouseListener {
        public Fenetre(){
            int LargeurFenetre = 800;
            int LongeurFenetre = 800;
            setVisible(true);
            //setResizable(false);
            setSize(LongeurFenetre, LargeurFenetre);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            addMouseListener(this);
        }
    int Joueur = 1;
    int Matrice[][] = new int[6][6];
    int score1 = 0;
    int score2 = 0;


    public void paint(Graphics g)
    {
        super.paint(g);
        int yOffset = 0;
        int y = 100;
        g.setColor(Color.BLUE);
        for (int i = 0; i<5; i++)
        {
            g.drawRect(100, y + yOffset, 100, 100);
            g.drawRect(200, y + yOffset, 100,100);
            g.drawRect(300, y + yOffset, 100,100);
            g.drawRect(400, y + yOffset, 100, 100);
            g.drawRect(500, y + yOffset, 100,100);
            yOffset = yOffset + 100;
        }
        for (int i = 1; i < 6; i++){
            for (int j = 1; j < 6; j++){
                if(Matrice[i][j] == 1){
                    g.drawOval(i*100, j*100, 100,100);
                }
                else if(Matrice[i][j] == 2){
                    g.drawLine(i*100, j*100, (i+1)*100, (j+1)*100);
                    g.drawLine((i+1)*100, j*100, i*100, (j+1)*100);
                }
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX()/100;
        int mouseY = e.getY()/100;

        if ((mouseX <= 5) && (mouseY <= 5))
        {
            if((Matrice[mouseX][mouseY]) != 0)
            {
                System.out.println("Erreur! ou Aie! Vous avez perdu un tour car cette case a déja était sélectionné :c");
            }
            else{
                Matrice[mouseX][mouseY] = Joueur;
                for (int i = 1; i < Matrice.length; i++) {
                    for (int j = 1; j < Matrice.length; j++) {
                        System.out.print(Matrice[j][i] + "\t");
                    }
                    System.out.println();
                }
            }

            //compteurX
            int compteur1 = 0;
            int compteur2 = 0;

            //compteurY
            int compteur3 = 0;
            int compteur4 = 0;

            //On parcourt on compte le nombre 1 et 2
            System.out.println("Mouse X: " +mouseX+ "Mouse Y: " +mouseY);
            for (int i = 1; i < 6; i++)
            {
                if(Matrice[i][mouseY] == 1)
                {
                    compteur1 = compteur1 + 1;
                    System.out.println("Compteur Rond: " + compteur1);
                    System.out.println();
                }else if(Matrice[i][mouseY] == 2)
                {
                    compteur2 = compteur2 + 1;
                    System.out.println("Compteur croix: " + compteur2);
                    System.out.println();
                }

                if(Matrice[mouseX][i] == 1)
                {
                    compteur3 = compteur3 + 1;
                    System.out.println("Compteur Rond: " + compteur3);
                    System.out.println();
                }else if(Matrice[mouseX][i] == 2)
                {
                    compteur4 = compteur4 + 1;
                    System.out.println("Compteur croix: " + compteur4);
                    System.out.println();
                }
                //horizontal
                if(Matrice[1][mouseY] != 0 && Matrice[2][mouseY] != 0 && Matrice[3][mouseY] != 0 && Matrice[4][mouseY] != 0 && Matrice[5][mouseY] != 0)
                {
                    if(compteur1 == 3)
                    {
                        for (int j = 1; j < 6; j++)
                        {
                            Matrice[j][mouseY] = 1;
                        }
                        score1 = score1 + 1;
                    }else if(compteur2 == 3)
                    {
                        for (int j = 1; j < 6; j++)
                        {
                            Matrice[j][mouseY] = 2;
                        }
                        score2 = score2 + 1;
                    }
                    System.out.println("Bravo");
                }
                //vertical
                if(Matrice[mouseX][1] != 0 && Matrice[mouseX][2] != 0 && Matrice[mouseX][3] != 0 && Matrice[mouseX][4] != 0 && Matrice[mouseX][5] != 0)
                {
                    if(compteur3 == 3)
                    {
                        for (int j = 1; j < 6; j++)
                        {
                            Matrice[mouseX][j] = 1;
                        }
                        score1 = score1 + 1;
                    }
                    else if(compteur4 == 3)
                    {
                        for (int j = 1; j < 6; j++)
                        {
                            Matrice[mouseX][j] = 2;
                        }
                        score2 = score2 + 1;
                    }

                }
            }
            System.out.println("Score Joueur1:" +score1);
            System.out.println("Score Joueur2:" +score2);
            repaint();
        }

        if(Joueur == 1)
        {
            System.out.println("Le joueur " + Joueur +"a joué");
            Joueur = 2;
            System.out.println("Maintenant a toi de jouer" + Joueur + "!");
        }
        else
        {
            System.out.println("Le joueur " + Joueur +"a joué");
            Joueur = 1;
            System.out.println("Maintenant a toi de jouer" + Joueur + "!");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
