
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @authors Derouich Elyes && ElMay Zied && Najar Atef
 */
public class Client extends javax.swing.JFrame {

    /**
     * Creates new form Client
     */
    Vector<JLabel> empty = new Vector<>();
    Vector<JLabel> carrs = new Vector<>();
    int curr_pos = 0;
    int timer = 00;
    Timer tempVar;
    ArrayList<Integer> lignes = new ArrayList<>();
    String[] comb = new String[4];
    int combPos = 0;
    int ligne = 0;
    static int nbBlanc = 0;
    static int nbNoir = 0;
    static ArrayList<String> but = new ArrayList<>();
    int[] carrStart = {1, 5, 9, 13, 17, 21, 25, 29, 33, 37};
    boolean winner = false;
    PrintStream output = null;
    static Socket client_so = null;
    static BufferedReader FromServer = null;
    int t = 0;
    int coup = 0;

    public Client() {
        initComponents();
        initParams();
        try {
            client_so = new Socket("localhost", 5555);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FromServer = new BufferedReader(new InputStreamReader(client_so.getInputStream())); //convertir flux à memoir tempon(TCP)
            String c;
            int nbr = 0;
            while (nbr < 4) {
                c = FromServer.readLine();
                but.add(c);
                /*Le But*/
                System.out.println(c);
                nbr++;
            }
        } catch (IOException e) {
            System.err.println(e);
        }

}

    public void initParams() {
        empty.add(empty_1_1);
        empty.add(empty_1_2);
        empty.add(empty_1_3);
        empty.add(empty_1_4);
        empty.add(empty_1_5);
        empty.add(empty_1_6);
        empty.add(empty_1_7);
        empty.add(empty_1_8);
        empty.add(empty_1_9);
        empty.add(empty_1_10);
        empty.add(empty_1_11);
        empty.add(empty_1_12);
        empty.add(empty_1_13);
        empty.add(empty_1_14);
        empty.add(empty_1_15);
        empty.add(empty_1_16);
        empty.add(empty_1_17);
        empty.add(empty_1_18);
        empty.add(empty_1_19);
        empty.add(empty_1_20);
        empty.add(empty_1_21);
        empty.add(empty_1_22);
        empty.add(empty_1_23);
        empty.add(empty_1_24);
        empty.add(empty_1_25);
        empty.add(empty_1_26);
        empty.add(empty_1_27);
        empty.add(empty_1_28);
        empty.add(empty_1_29);
        empty.add(empty_1_30);
        empty.add(empty_1_31);
        empty.add(empty_1_32);
        empty.add(empty_1_33);
        empty.add(empty_1_34);
        empty.add(empty_1_35);
        empty.add(empty_1_36);
        empty.add(empty_1_37);
        empty.add(empty_1_38);
        empty.add(empty_1_39);
        empty.add(empty_1_40);
        carrs.add(carr_1);
        carrs.add(carr_2);
        carrs.add(carr_3);
        carrs.add(carr_4);
        carrs.add(carr_5);
        carrs.add(carr_6);
        carrs.add(carr_7);
        carrs.add(carr_8);
        carrs.add(carr_9);
        carrs.add(carr_10);
        carrs.add(carr_11);
        carrs.add(carr_12);
        carrs.add(carr_13);
        carrs.add(carr_14);
        carrs.add(carr_15);
        carrs.add(carr_16);
        carrs.add(carr_17);
        carrs.add(carr_18);
        carrs.add(carr_19);
        carrs.add(carr_20);
        carrs.add(carr_21);
        carrs.add(carr_22);
        carrs.add(carr_23);
        carrs.add(carr_24);
        carrs.add(carr_25);
        carrs.add(carr_26);
        carrs.add(carr_27);
        carrs.add(carr_28);
        carrs.add(carr_29);
        carrs.add(carr_30);
        carrs.add(carr_31);
        carrs.add(carr_32);
        carrs.add(carr_33);
        carrs.add(carr_34);
        carrs.add(carr_35);
        carrs.add(carr_36);
        carrs.add(carr_37);
        carrs.add(carr_38);
        carrs.add(carr_39);
        carrs.add(carr_40);
        lignes.add(3);
        lignes.add(7);
        lignes.add(11);
        lignes.add(15);
        lignes.add(19);
        lignes.add(23);
        lignes.add(27);
        lignes.add(31);
        lignes.add(35);
        lignes.add(39);
        blue.setCursor(new Cursor(Cursor.HAND_CURSOR));
        vert.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jaune.setCursor(new Cursor(Cursor.HAND_CURSOR));
        turquoise.setCursor(new Cursor(Cursor.HAND_CURSOR));
        violet.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rouge.setCursor(new Cursor(Cursor.HAND_CURSOR));
        orange.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        blue.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (t % 2 == 0) {
                    colorier("Blue");
                }
            }
        });
        vert.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (t % 2 == 0) {
                    colorier("Vert");
                }
            }
        });
        jaune.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (t % 2 == 0) {
                    colorier("Jaune");
                }
            }
        });
        turquoise.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (t % 2 == 0) {
                    colorier("Turquoise");
                }
            }
        });
        violet.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (t % 2 == 0) {
                    colorier("Violet");
                }
            }
        });
        rouge.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (t % 2 == 0) {
                    colorier("Rouge");
                }
            }
        });
        orange.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (t % 2 == 0) {
                    colorier("Orange");
                }
            }
        });
        rose.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (t % 2 == 0) {
                    colorier("Rose");
                }
            }
        });
        rejouer.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (t % 2 == 0) {
                    tempVar.stop();
                    rejouer.setText("");
                    t++;
                } else {
                    tempVar.start();
                    rejouer.setText("");
                    t++;
                }
            }
        });
        quitter.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                MenuView mv = new MenuView();
                mv.setVisible(true);
                mv.setLocationRelativeTo(null);
            }
        });
        ActionListener timerListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (timer >= 99) {
                    tempVar.stop();
                    winner = false;
                } else {
                    if (timer < 10) {
                        temp.setText("0" + String.valueOf(timer));
                    } else {
                        temp.setText(String.valueOf(timer));
                    }
                    timer++;
                }
            }
        };
        tempVar = new Timer(1000, timerListener);
        tempVar.setInitialDelay(0);
        tempVar.start();
    }

    public void colorier(String couleur) {
        if (curr_pos < 40) {
            URL lien = getClass().getResource("images/" + couleur + ".png");
            empty.get(curr_pos).setIcon(new ImageIcon(lien));
            comb[combPos] = couleur;
            combPos++;
            curr_pos++;
        }
        if (lignes.contains(curr_pos - 1)) {
            combPos = 0;
            verifier();
            ligne++;
        }
    }

    public void changer(int pos, String couleur) {
        URL lien = getClass().getResource("images/" + couleur + ".png");
        carrs.get(pos).setIcon(new ImageIcon(lien));
    }

    public void verifier() {
        try {
            output = new PrintStream(client_so.getOutputStream(), true);
            output.println(comb[0]);
            output.println(comb[1]);
            output.println(comb[2]);
            output.println(comb[3]);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String nbNoir1 = FromServer.readLine();
            String nbBlanc1 = FromServer.readLine();
            
            //Recuperation du serveur du nombre de coup
            //int coup=Integer.parseInt(FromServer.readLine());
            
            nbBlanc = Integer.parseInt(nbBlanc1);
            nbNoir = Integer.parseInt(nbNoir1);
            
            System.out.println("b = " + nbBlanc + " n = " + nbNoir);
                      
            
            //Initialisation du label
            
            coup = coup + 10 +nbBlanc+nbNoir*3;
            this.score.setText("Score :" +Integer.toString(coup));
            int i;  
            for (i = 0; i < nbBlanc; i++) {
                changer(i - 1 + carrStart[ligne], "Blanc");
            }
            for (int j = nbBlanc; j < nbNoir + nbBlanc; j++) {
                changer(j - 1 + carrStart[ligne], "Noir");
            }

            if (nbNoir == 4) {
                this.setVisible(false);
                Resultat r = new Resultat(coup, but);
                r.setVisible(true);
                r.setLocationRelativeTo(null);
                FromServer.close();
                output.close();
                client_so.close();
            } else if (curr_pos > 38) {
                this.setVisible(false);
                Resultat1 r1 = new Resultat1(coup, but);
                r1.setVisible(true);
                r1.setLocationRelativeTo(null);
            }
            //test sur les coups 
            else if(coup==0){
                this.setVisible(false);
                Resultat1 r1 = new Resultat1(coup, but);
                r1.setVisible(true);
                r1.setLocationRelativeTo(null);
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rose = new javax.swing.JLabel();
        orange = new javax.swing.JLabel();
        rouge = new javax.swing.JLabel();
        violet = new javax.swing.JLabel();
        turquoise = new javax.swing.JLabel();
        jaune = new javax.swing.JLabel();
        vert = new javax.swing.JLabel();
        blue = new javax.swing.JLabel();
        empty_1_3 = new javax.swing.JLabel();
        empty_1_4 = new javax.swing.JLabel();
        empty_1_2 = new javax.swing.JLabel();
        empty_1_1 = new javax.swing.JLabel();
        empty_1_8 = new javax.swing.JLabel();
        empty_1_7 = new javax.swing.JLabel();
        empty_1_6 = new javax.swing.JLabel();
        empty_1_5 = new javax.swing.JLabel();
        empty_1_12 = new javax.swing.JLabel();
        empty_1_11 = new javax.swing.JLabel();
        empty_1_10 = new javax.swing.JLabel();
        empty_1_9 = new javax.swing.JLabel();
        empty_1_16 = new javax.swing.JLabel();
        empty_1_15 = new javax.swing.JLabel();
        empty_1_14 = new javax.swing.JLabel();
        empty_1_13 = new javax.swing.JLabel();
        empty_1_20 = new javax.swing.JLabel();
        empty_1_19 = new javax.swing.JLabel();
        empty_1_18 = new javax.swing.JLabel();
        empty_1_17 = new javax.swing.JLabel();
        empty_1_24 = new javax.swing.JLabel();
        empty_1_23 = new javax.swing.JLabel();
        empty_1_22 = new javax.swing.JLabel();
        empty_1_21 = new javax.swing.JLabel();
        empty_1_28 = new javax.swing.JLabel();
        empty_1_27 = new javax.swing.JLabel();
        empty_1_26 = new javax.swing.JLabel();
        empty_1_25 = new javax.swing.JLabel();
        empty_1_32 = new javax.swing.JLabel();
        empty_1_31 = new javax.swing.JLabel();
        empty_1_30 = new javax.swing.JLabel();
        empty_1_29 = new javax.swing.JLabel();
        empty_1_37 = new javax.swing.JLabel();
        empty_1_38 = new javax.swing.JLabel();
        empty_1_39 = new javax.swing.JLabel();
        empty_1_40 = new javax.swing.JLabel();
        empty_1_36 = new javax.swing.JLabel();
        empty_1_35 = new javax.swing.JLabel();
        empty_1_34 = new javax.swing.JLabel();
        empty_1_33 = new javax.swing.JLabel();
        carr_12 = new javax.swing.JLabel();
        carr_11 = new javax.swing.JLabel();
        carr_10 = new javax.swing.JLabel();
        carr_9 = new javax.swing.JLabel();
        carr_8 = new javax.swing.JLabel();
        carr_7 = new javax.swing.JLabel();
        carr_6 = new javax.swing.JLabel();
        carr_5 = new javax.swing.JLabel();
        carr_4 = new javax.swing.JLabel();
        carr_3 = new javax.swing.JLabel();
        carr_2 = new javax.swing.JLabel();
        carr_1 = new javax.swing.JLabel();
        carr_13 = new javax.swing.JLabel();
        carr_14 = new javax.swing.JLabel();
        carr_15 = new javax.swing.JLabel();
        carr_16 = new javax.swing.JLabel();
        carr_17 = new javax.swing.JLabel();
        carr_18 = new javax.swing.JLabel();
        carr_19 = new javax.swing.JLabel();
        carr_20 = new javax.swing.JLabel();
        carr_21 = new javax.swing.JLabel();
        carr_22 = new javax.swing.JLabel();
        carr_23 = new javax.swing.JLabel();
        carr_24 = new javax.swing.JLabel();
        carr_25 = new javax.swing.JLabel();
        carr_26 = new javax.swing.JLabel();
        carr_27 = new javax.swing.JLabel();
        carr_28 = new javax.swing.JLabel();
        carr_29 = new javax.swing.JLabel();
        carr_30 = new javax.swing.JLabel();
        carr_31 = new javax.swing.JLabel();
        carr_32 = new javax.swing.JLabel();
        carr_33 = new javax.swing.JLabel();
        carr_34 = new javax.swing.JLabel();
        carr_35 = new javax.swing.JLabel();
        carr_36 = new javax.swing.JLabel();
        carr_37 = new javax.swing.JLabel();
        carr_38 = new javax.swing.JLabel();
        carr_39 = new javax.swing.JLabel();
        carr_40 = new javax.swing.JLabel();
        quitter = new javax.swing.JLabel();
        temp = new javax.swing.JLabel();
        rejouer = new javax.swing.JLabel();
        score = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MasterMind");
        setMaximumSize(new java.awt.Dimension(460, 740));
        setMinimumSize(new java.awt.Dimension(460, 740));
        setResizable(false);
        getContentPane().setLayout(null);

        rose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rose.png"))); // NOI18N
        getContentPane().add(rose);
        rose.setBounds(10, 120, 70, 50);

        orange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Orange.png"))); // NOI18N
        getContentPane().add(orange);
        orange.setBounds(10, 330, 80, 50);

        rouge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rouge.png"))); // NOI18N
        getContentPane().add(rouge);
        rouge.setBounds(10, 540, 70, 50);

        violet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Violet.png"))); // NOI18N
        getContentPane().add(violet);
        violet.setBounds(10, 190, 80, 50);

        turquoise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Turquoise.png"))); // NOI18N
        getContentPane().add(turquoise);
        turquoise.setBounds(10, 400, 70, 50);

        jaune.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Jaune.png"))); // NOI18N
        getContentPane().add(jaune);
        jaune.setBounds(10, 260, 70, 50);

        vert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vert.png"))); // NOI18N
        getContentPane().add(vert);
        vert.setBounds(10, 470, 60, 50);

        blue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Blue.png"))); // NOI18N
        getContentPane().add(blue);
        blue.setBounds(10, 50, 70, 50);

        empty_1_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_3);
        empty_1_3.setBounds(240, 550, 62, 62);

        empty_1_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_4);
        empty_1_4.setBounds(310, 550, 62, 62);

        empty_1_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_2);
        empty_1_2.setBounds(170, 550, 62, 62);

        empty_1_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_1);
        empty_1_1.setBounds(100, 550, 62, 62);

        empty_1_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_8);
        empty_1_8.setBounds(310, 490, 62, 62);

        empty_1_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_7);
        empty_1_7.setBounds(240, 490, 62, 62);

        empty_1_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_6);
        empty_1_6.setBounds(170, 490, 62, 62);

        empty_1_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_5);
        empty_1_5.setBounds(100, 490, 62, 62);

        empty_1_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_12);
        empty_1_12.setBounds(310, 430, 62, 62);

        empty_1_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_11);
        empty_1_11.setBounds(240, 430, 62, 62);

        empty_1_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_10);
        empty_1_10.setBounds(170, 430, 62, 62);

        empty_1_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_9);
        empty_1_9.setBounds(100, 430, 62, 62);

        empty_1_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_16);
        empty_1_16.setBounds(310, 370, 62, 62);

        empty_1_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_15);
        empty_1_15.setBounds(240, 370, 62, 62);

        empty_1_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_14);
        empty_1_14.setBounds(170, 370, 62, 62);

        empty_1_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_13);
        empty_1_13.setBounds(100, 370, 62, 62);

        empty_1_20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_20);
        empty_1_20.setBounds(310, 310, 62, 62);

        empty_1_19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_19);
        empty_1_19.setBounds(240, 310, 62, 62);

        empty_1_18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_18);
        empty_1_18.setBounds(170, 310, 62, 62);

        empty_1_17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_17);
        empty_1_17.setBounds(100, 310, 62, 62);

        empty_1_24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_24);
        empty_1_24.setBounds(310, 250, 62, 62);

        empty_1_23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_23);
        empty_1_23.setBounds(240, 250, 62, 62);

        empty_1_22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_22);
        empty_1_22.setBounds(170, 250, 62, 62);

        empty_1_21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_21);
        empty_1_21.setBounds(100, 250, 62, 62);

        empty_1_28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_28);
        empty_1_28.setBounds(310, 190, 62, 62);

        empty_1_27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_27);
        empty_1_27.setBounds(240, 190, 62, 62);

        empty_1_26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_26);
        empty_1_26.setBounds(170, 190, 62, 62);

        empty_1_25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_25);
        empty_1_25.setBounds(100, 190, 62, 62);

        empty_1_32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_32);
        empty_1_32.setBounds(310, 130, 62, 62);

        empty_1_31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_31);
        empty_1_31.setBounds(240, 130, 62, 62);

        empty_1_30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_30);
        empty_1_30.setBounds(170, 130, 62, 62);

        empty_1_29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_29);
        empty_1_29.setBounds(100, 130, 62, 62);

        empty_1_37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_37);
        empty_1_37.setBounds(100, 10, 62, 62);

        empty_1_38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_38);
        empty_1_38.setBounds(170, 10, 62, 62);

        empty_1_39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_39);
        empty_1_39.setBounds(240, 10, 62, 62);

        empty_1_40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_40);
        empty_1_40.setBounds(310, 10, 62, 62);

        empty_1_36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_36);
        empty_1_36.setBounds(310, 70, 62, 62);

        empty_1_35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_35);
        empty_1_35.setBounds(240, 70, 62, 62);

        empty_1_34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_34);
        empty_1_34.setBounds(170, 70, 62, 62);

        empty_1_33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty.png"))); // NOI18N
        getContentPane().add(empty_1_33);
        empty_1_33.setBounds(100, 70, 62, 62);

        carr_12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_12);
        carr_12.setBounds(400, 460, 40, 30);

        carr_11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_11);
        carr_11.setBounds(380, 460, 40, 30);

        carr_10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_10);
        carr_10.setBounds(400, 440, 40, 30);

        carr_9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_9);
        carr_9.setBounds(380, 440, 40, 30);

        carr_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_8);
        carr_8.setBounds(400, 520, 40, 30);

        carr_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_7);
        carr_7.setBounds(380, 520, 40, 30);

        carr_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_6);
        carr_6.setBounds(400, 500, 40, 30);

        carr_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_5);
        carr_5.setBounds(380, 500, 40, 30);

        carr_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_4);
        carr_4.setBounds(400, 580, 40, 30);

        carr_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        carr_3.setText("jLabel1");
        getContentPane().add(carr_3);
        carr_3.setBounds(380, 580, 40, 30);

        carr_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_2);
        carr_2.setBounds(400, 560, 40, 30);

        carr_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        carr_1.setText("jLabel1");
        getContentPane().add(carr_1);
        carr_1.setBounds(380, 560, 40, 30);

        carr_13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_13);
        carr_13.setBounds(380, 380, 40, 30);

        carr_14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_14);
        carr_14.setBounds(400, 380, 40, 30);

        carr_15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_15);
        carr_15.setBounds(380, 400, 40, 30);

        carr_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_16);
        carr_16.setBounds(400, 400, 40, 30);

        carr_17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_17);
        carr_17.setBounds(380, 320, 40, 30);

        carr_18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_18);
        carr_18.setBounds(400, 320, 40, 30);

        carr_19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_19);
        carr_19.setBounds(380, 340, 40, 30);

        carr_20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_20);
        carr_20.setBounds(400, 340, 40, 30);

        carr_21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_21);
        carr_21.setBounds(380, 260, 40, 30);

        carr_22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_22);
        carr_22.setBounds(400, 260, 40, 30);

        carr_23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_23);
        carr_23.setBounds(380, 280, 40, 30);

        carr_24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_24);
        carr_24.setBounds(400, 280, 40, 30);

        carr_25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_25);
        carr_25.setBounds(380, 200, 40, 30);

        carr_26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_26);
        carr_26.setBounds(400, 200, 40, 30);

        carr_27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_27);
        carr_27.setBounds(380, 220, 40, 30);

        carr_28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_28);
        carr_28.setBounds(400, 220, 40, 30);

        carr_29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_29);
        carr_29.setBounds(380, 140, 40, 30);

        carr_30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_30);
        carr_30.setBounds(400, 140, 40, 30);

        carr_31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_31);
        carr_31.setBounds(380, 160, 40, 30);

        carr_32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_32);
        carr_32.setBounds(400, 160, 40, 30);

        carr_33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_33);
        carr_33.setBounds(380, 80, 40, 30);

        carr_34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_34);
        carr_34.setBounds(400, 80, 40, 30);

        carr_35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_35);
        carr_35.setBounds(380, 100, 40, 30);

        carr_36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_36);
        carr_36.setBounds(400, 100, 40, 30);

        carr_37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_37);
        carr_37.setBounds(380, 20, 40, 30);

        carr_38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_38);
        carr_38.setBounds(400, 20, 40, 30);

        carr_39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_39);
        carr_39.setBounds(380, 40, 40, 30);

        carr_40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Empty_Small.png"))); // NOI18N
        getContentPane().add(carr_40);
        carr_40.setBounds(400, 40, 40, 30);

        quitter.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        quitter.setForeground(new java.awt.Color(255, 255, 255));
        quitter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quitter.setText("Quitter");
        quitter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(quitter);
        quitter.setBounds(200, 670, 80, 17);

        temp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        temp.setForeground(new java.awt.Color(255, 255, 255));
        temp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        temp.setText("00");
        getContentPane().add(temp);
        temp.setBounds(380, 640, 50, 14);

        rejouer.setFont(new java.awt.Font("FontAwesome", 1, 18)); // NOI18N
        rejouer.setForeground(new java.awt.Color(255, 255, 255));
        rejouer.setText("");
        rejouer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(rejouer);
        rejouer.setBounds(230, 630, 30, 30);

        score.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        score.setForeground(new java.awt.Color(255, 255, 255));
        score.setText("Score: 0");
        getContentPane().add(score);
        score.setBounds(20, 640, 100, 14);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.png"))); // NOI18N
        bg.setMaximumSize(new java.awt.Dimension(1087, 750));
        bg.setMinimumSize(new java.awt.Dimension(1087, 750));
        bg.setPreferredSize(new java.awt.Dimension(1087, 750));
        getContentPane().add(bg);
        bg.setBounds(0, -40, 460, 780);

        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 630, 34, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create sand display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel blue;
    private javax.swing.JLabel carr_1;
    private javax.swing.JLabel carr_10;
    private javax.swing.JLabel carr_11;
    private javax.swing.JLabel carr_12;
    private javax.swing.JLabel carr_13;
    private javax.swing.JLabel carr_14;
    private javax.swing.JLabel carr_15;
    private javax.swing.JLabel carr_16;
    private javax.swing.JLabel carr_17;
    private javax.swing.JLabel carr_18;
    private javax.swing.JLabel carr_19;
    private javax.swing.JLabel carr_2;
    private javax.swing.JLabel carr_20;
    private javax.swing.JLabel carr_21;
    private javax.swing.JLabel carr_22;
    private javax.swing.JLabel carr_23;
    private javax.swing.JLabel carr_24;
    private javax.swing.JLabel carr_25;
    private javax.swing.JLabel carr_26;
    private javax.swing.JLabel carr_27;
    private javax.swing.JLabel carr_28;
    private javax.swing.JLabel carr_29;
    private javax.swing.JLabel carr_3;
    private javax.swing.JLabel carr_30;
    private javax.swing.JLabel carr_31;
    private javax.swing.JLabel carr_32;
    private javax.swing.JLabel carr_33;
    private javax.swing.JLabel carr_34;
    private javax.swing.JLabel carr_35;
    private javax.swing.JLabel carr_36;
    private javax.swing.JLabel carr_37;
    private javax.swing.JLabel carr_38;
    private javax.swing.JLabel carr_39;
    private javax.swing.JLabel carr_4;
    private javax.swing.JLabel carr_40;
    private javax.swing.JLabel carr_5;
    private javax.swing.JLabel carr_6;
    private javax.swing.JLabel carr_7;
    private javax.swing.JLabel carr_8;
    private javax.swing.JLabel carr_9;
    private javax.swing.JLabel empty_1_1;
    private javax.swing.JLabel empty_1_10;
    private javax.swing.JLabel empty_1_11;
    private javax.swing.JLabel empty_1_12;
    private javax.swing.JLabel empty_1_13;
    private javax.swing.JLabel empty_1_14;
    private javax.swing.JLabel empty_1_15;
    private javax.swing.JLabel empty_1_16;
    private javax.swing.JLabel empty_1_17;
    private javax.swing.JLabel empty_1_18;
    private javax.swing.JLabel empty_1_19;
    private javax.swing.JLabel empty_1_2;
    private javax.swing.JLabel empty_1_20;
    private javax.swing.JLabel empty_1_21;
    private javax.swing.JLabel empty_1_22;
    private javax.swing.JLabel empty_1_23;
    private javax.swing.JLabel empty_1_24;
    private javax.swing.JLabel empty_1_25;
    private javax.swing.JLabel empty_1_26;
    private javax.swing.JLabel empty_1_27;
    private javax.swing.JLabel empty_1_28;
    private javax.swing.JLabel empty_1_29;
    private javax.swing.JLabel empty_1_3;
    private javax.swing.JLabel empty_1_30;
    private javax.swing.JLabel empty_1_31;
    private javax.swing.JLabel empty_1_32;
    private javax.swing.JLabel empty_1_33;
    private javax.swing.JLabel empty_1_34;
    private javax.swing.JLabel empty_1_35;
    private javax.swing.JLabel empty_1_36;
    private javax.swing.JLabel empty_1_37;
    private javax.swing.JLabel empty_1_38;
    private javax.swing.JLabel empty_1_39;
    private javax.swing.JLabel empty_1_4;
    private javax.swing.JLabel empty_1_40;
    private javax.swing.JLabel empty_1_5;
    private javax.swing.JLabel empty_1_6;
    private javax.swing.JLabel empty_1_7;
    private javax.swing.JLabel empty_1_8;
    private javax.swing.JLabel empty_1_9;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jaune;
    private javax.swing.JLabel orange;
    private javax.swing.JLabel quitter;
    private javax.swing.JLabel rejouer;
    private javax.swing.JLabel rose;
    private javax.swing.JLabel rouge;
    private javax.swing.JLabel score;
    private javax.swing.JLabel temp;
    private javax.swing.JLabel turquoise;
    private javax.swing.JLabel vert;
    private javax.swing.JLabel violet;
    // End of variables declaration//GEN-END:variables
}
