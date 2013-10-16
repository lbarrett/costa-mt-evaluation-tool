package costamt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Results extends javax.swing.JFrame {

    int gram1 = 0;
    int gram2 = 0;
    int gram3 = 0;
    int gram4 = 0;
    int gram5 = 0;
    int gram6 = 0;
    int gram7 = 0;
    int word1 = 0;
    int word2 = 0;
    int word3 = 0;
    int word4 = 0;
    int word5 = 0;
    int word6 = 0;
    int word7 = 0;
    int style1 = 0;
    int style2 = 0;
    int style3 = 0;
    int style4 = 0;
    int style5 = 0;
    int style6 = 0;
    int style7 = 0;
    int numoffluen1 = 0;
    int numoffluen2 = 0;
    int numoffluen3 = 0;
    int numoffluen4 = 0;
    int numoffluen5 = 0;
    int numofadeq1 = 0;
    int numofadeq2 = 0;
    int numofadeq3 = 0;
    int numofadeq4 = 0;
    int numofadeq5 = 0;
    int fluenfromfile;
    int adeqfromfile;
    static float fluent = 0, adeqt = 0;
    public static ArrayList<String> results = new ArrayList();
    static String resfile;
    String username = "";
    String systemname = "";
    String l1 = "";
    String l2 = "";
    String Segm = "";
    int segments = 0;
    int fluentimeest = 0;
    int adeqtimeest = 0;
   
    
    public Results(String resfiletemp, String sysfiletemp, String dbtemp) {

        resfile = resfiletemp;

        initComponents();
        this.setLocationRelativeTo(null);
        try {
            ReadTxt.ReadTxt(results, resfile);

        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        int k = 0;
        String line;
        while (k < results.size()) {
            line = results.get(k);
            StringTokenizer st = new StringTokenizer(line);
            st.nextToken();
            fluenfromfile = Integer.parseInt(st.nextToken());
            adeqfromfile = Integer.parseInt(st.nextToken());
            switch (fluenfromfile) {
                case 1:
                    numoffluen1++;
                    break;
                case 2:
                    numoffluen2++;
                    break;
                case 3:
                    numoffluen3++;
                    break;
                case 4:
                    numoffluen4++;
                    break;
                case 5:
                    numoffluen5++;
                    break;
            }
            switch (adeqfromfile) {
                case 1:
                    numofadeq1++;
                    break;
                case 2:
                    numofadeq2++;
                    break;
                case 3:
                    numofadeq3++;
                    break;
                case 4:
                    numofadeq4++;
                    break;
                case 5:
                    numofadeq5++;
                    break;
            }
            fluent = fluent + fluenfromfile;

            adeqt = adeqt + adeqfromfile;

            gram1 = gram1 + Integer.parseInt(st.nextToken());
            gram2 = gram2 + Integer.parseInt(st.nextToken());
            gram3 = gram3 + Integer.parseInt(st.nextToken());
            gram4 = gram4 + Integer.parseInt(st.nextToken());
            gram5 = gram5 + Integer.parseInt(st.nextToken());
            gram6 = gram6 + Integer.parseInt(st.nextToken());
            gram7 = gram7 + Integer.parseInt(st.nextToken());
            word1 = word1 + Integer.parseInt(st.nextToken());
            word2 = word2 + Integer.parseInt(st.nextToken());
            word3 = word3 + Integer.parseInt(st.nextToken());
            word4 = word4 + Integer.parseInt(st.nextToken());
            word5 = word5 + Integer.parseInt(st.nextToken());
            word6 = word6 + Integer.parseInt(st.nextToken());
            word7 = word7 + Integer.parseInt(st.nextToken());
            style1 = style1 + Integer.parseInt(st.nextToken());
            style2 = style2 + Integer.parseInt(st.nextToken());
            style3 = style3 + Integer.parseInt(st.nextToken());
            style4 = style4 + Integer.parseInt(st.nextToken());
            style5 = style5 + Integer.parseInt(st.nextToken());
            style6 = style6 + Integer.parseInt(st.nextToken());
            style7 = style7 + Integer.parseInt(st.nextToken());
            fluentimeest = fluentimeest + Integer.parseInt(st.nextToken());
            adeqtimeest = adeqtimeest + Integer.parseInt(st.nextToken());

            k++;

        }
        adeqt = adeqt / (k * 5);
        fluent = fluent / (k * 5);
        fluentimeest = fluentimeest /k;
        adeqtimeest = adeqtimeest/k;
        jLabel2.setText(Float.toString(fluent) + " / 1" +"      "+fluentimeest+" sec average time per sentence");
        jLabel4.setText(Float.toString(adeqt) + " / 1"+"      "+adeqtimeest+" sec average time per sentence");
        jLabelAdeq1.setText(Integer.toString(numofadeq1));
        jLabelAdeq2.setText(Integer.toString(numofadeq2));
        jLabelAdeq3.setText(Integer.toString(numofadeq3));
        jLabelAdeq4.setText(Integer.toString(numofadeq4));
        jLabelAdeq5.setText(Integer.toString(numofadeq5));
        jLabelFluen1.setText(Integer.toString(numoffluen1));
        jLabelFluen2.setText(Integer.toString(numoffluen2));
        jLabelFluen3.setText(Integer.toString(numoffluen3));
        jLabelFluen4.setText(Integer.toString(numoffluen4));
        jLabelFluen5.setText(Integer.toString(numoffluen5));
        jLabelGram1.setText(Integer.toString(gram1));
        jLabelGram2.setText(Integer.toString(gram2));
        jLabelGram3.setText(Integer.toString(gram3));
        jLabelGram4.setText(Integer.toString(gram4));
        jLabelGram5.setText(Integer.toString(gram5));
        jLabelGram6.setText(Integer.toString(gram6));
        jLabelGram7.setText(Integer.toString(gram7));
        jLabelWord1.setText(Integer.toString(word1));
        jLabelWord2.setText(Integer.toString(word2));
        jLabelWord3.setText(Integer.toString(word3));
        jLabelWord4.setText(Integer.toString(word4));
        jLabelWord5.setText(Integer.toString(word5));
        jLabelWord6.setText(Integer.toString(word6));
        jLabelWord7.setText(Integer.toString(word7));
        jLabelStyle1.setText(Integer.toString(style1));
        jLabelStyle2.setText(Integer.toString(style2));
        jLabelStyle3.setText(Integer.toString(style3));
        jLabelStyle4.setText(Integer.toString(style4));
        jLabelStyle5.setText(Integer.toString(style5));
        jLabelStyle6.setText(Integer.toString(style6));
        jLabelStyle7.setText(Integer.toString(style7));


        File f = new File(sysfiletemp);
        if (f.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                try {
                    systemname = reader.readLine();
                    username = reader.readLine();
                    l1 = reader.readLine();
                    l2 = reader.readLine();
                    Segm = reader.readLine();

                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException e) {
            }
        }

        File fres = new File(systemname + "_" + username.substring(0, 4) + "_" + l1.substring(0, 2) + "_" + l2.substring(0, 2) + "_results.txt");

        BufferedWriter b;
        try {
            b = new BufferedWriter(new FileWriter(fres, true));

            b.append("COSTA MT Evaluation Tooll\t" + "Beta version");
            b.newLine();
            b.append("Software written by:\t" + "Konstantinos CHATZITHEODOROU,\t" + "Stamatis CHATZISTAMATIS");
            b.newLine();
            b.newLine();
            b.append("MT System's Name:\t" + systemname);
            b.newLine();
            b.append("Annotator's name:\t" + username);
            b.newLine();
            b.append("Source Language:\t" + l1);
            b.newLine();
            b.append("Target Language:\t" + l2);
            b.newLine();
            b.append("Segments Evaluated:\t" + Segm);
            b.newLine();
            b.newLine();
            b.append("Statistics");
            b.newLine();
            b.append("Fluency:\t" + fluent + "\t" +fluentimeest+" sec average time per sentence");
            b.newLine();
            b.append("Adequacy:\t" + adeqt + "\t" +adeqtimeest+" sec average time per sentence");
            b.newLine();
            b.newLine();
            b.append("Fluency\t" + "Count\t" + "Adequacy\t" + "Count");
            b.newLine();
            b.append("Incomprehensible:\t" + numofadeq1 + "\t" + "None\t" + numoffluen1);
            b.newLine();
            b.append("Disfluent language:\t" + numofadeq2 + "\t" + "Little meaning\t" + numoffluen2);
            b.newLine();
            b.append("Non-native language:\t" + numofadeq3 + "\t" + "Much meaning\t" + numoffluen3);
            b.newLine();
            b.append("Good language:\t" + numofadeq4 + "\t" + "Most meaning\t" + numoffluen4);
            b.newLine();
            b.append("Flawless language:\t" + numofadeq5 + "\t" + "All meaning\t" + numoffluen5);
            b.newLine();
            b.newLine();

            b.append("Translation error classification");
            b.newLine();
            b.append("Grammar\t" + "Errors\t" + "Words\t" + "Errors\t" + "Style\t" + "Errors\t");
            b.newLine();
            b.append("Verb inflection:\t" + gram1 + "\t" + "Single words:\t" + word1 + "\t" + "Acronyms - Abbreviations:\t" + style1);
            b.newLine();
            b.append("Noun inflection:\t" + gram2 + "\t" + "Multi-word units:\t" + word2 + "\t" + "Extra words:\t" + style2);
            b.newLine();
            b.append("Other inflection:\t" + gram3 + "\t" + "Terminology:\t" + word3 + "\t" + "Country standards:\t" + style3);
            b.newLine();
            b.append("Wrong category:\t" + gram4 + "\t" + "Untranslated words:\t" + word4 + "\t" + "Spelling errors:\t" + style4);
            b.newLine();
            b.append("Article:\t" + gram5 + "\t" + "Ambiguous translation:\t" + word5 + "\t" + "Accent:\t" + style5);
            b.newLine();
            b.append("Preposition:\t" + gram6 + "\t" + "Literal translation:\t" + word6 + "\t" + "Capitalization:\t" + style6);
            b.newLine();
            b.append("Agreement:\t" + gram7 + "\t" + "Conjunctions:\t" + word7 + "\t" + "Punctuation:\t" + style7);
            b.newLine();
            b.newLine();
            b.append("Evaluation Judgements");
            b.newLine();

            b.append("Sentence Id\t" + "Fluency\t" + "Adequacy\t"
                    + "Verb inflection\t" + "Noun inflection\t" + "Other inflection\t" + "Wrong category\t" + "Article\t" + "Preposition\t" + "Agreement\t"
                    + "Single words\t" + "Multi-word units\t" + "Terminology\t" + "Untranslated words\t" + "Ambiguous translation\t" + "Literal translation\t" + "Conjunctions\t"
                    + "Acronyms - Abbreviations\t" + "Extra words\t" + "Country standards\t" + "Spelling errors\t" + "Accent\t" + "Capitalization\t" + "Punctuation\t" + "Time for Fluency in sec\t" 
                    + "Time for Adequacy in sec\t" + "Comments for Grammar\t" + "Comments for Words\t" + "Comments for Style");
            b.newLine();

            BufferedReader reader = new BufferedReader(new FileReader(resfile));

            String line1 = reader.readLine();

            while (line1 != null) {

                b.append(line1);
                b.newLine();
                line1 = reader.readLine();
            }
            reader.close();

            b.flush();
            b.close();

        } catch (IOException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }

        File fd = new File(dbtemp);
        fd.delete();

        File fs = new File(sysfiletemp);

        fs.delete();

        File fr = new File(resfile);
        fr.delete();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelAdeq2 = new javax.swing.JLabel();
        jLabelAdeq5 = new javax.swing.JLabel();
        jLabelAdeq1 = new javax.swing.JLabel();
        jLabelAdeq3 = new javax.swing.JLabel();
        jLabelAdeq4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabelFluen1 = new javax.swing.JLabel();
        jLabelFluen4 = new javax.swing.JLabel();
        jLabelFluen3 = new javax.swing.JLabel();
        jLabelFluen5 = new javax.swing.JLabel();
        jLabelFluen2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabelWord1 = new javax.swing.JLabel();
        jLabelWord4 = new javax.swing.JLabel();
        jLabelWord3 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabelWord2 = new javax.swing.JLabel();
        jLabelWord5 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabelWord6 = new javax.swing.JLabel();
        jLabelWord7 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabelStyle2 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabelStyle3 = new javax.swing.JLabel();
        jLabelStyle4 = new javax.swing.JLabel();
        jLabelStyle1 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabelStyle5 = new javax.swing.JLabel();
        jLabelStyle6 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabelStyle7 = new javax.swing.JLabel();
        jLabelGram5 = new javax.swing.JLabel();
        jLabelGram4 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabelGram1 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabelGram2 = new javax.swing.JLabel();
        jLabelGram7 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabelGram3 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabelGram6 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COSTA MT Evaluation Tool");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Fluency:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Adequacy:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo64.png"))); // NOI18N
        jLabel7.setText("COSTA MT Evaluation Tool ");

        jLabel6.setText("None");

        jLabel8.setText("All meaning");

        jLabel9.setText("Most meaning");

        jLabel10.setText("Much meaning");

        jLabel11.setText("Little meaning");

        jLabelAdeq2.setText("jLabel6");

        jLabelAdeq5.setText("jLabel6");

        jLabelAdeq1.setText("jLabel6");

        jLabelAdeq3.setText("jLabel6");

        jLabelAdeq4.setText("jLabel6");

        jLabel17.setText("Non-native language");

        jLabel18.setText("Good language");

        jLabel19.setText("Incomprehensible");

        jLabel20.setText("Flawless language");

        jLabel21.setText("Disfluent language");

        jLabelFluen1.setText("jLabel6");

        jLabelFluen4.setText("jLabel6");

        jLabelFluen3.setText("jLabel6");

        jLabelFluen5.setText("jLabel6");

        jLabelFluen2.setText("jLabel6");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Fluency");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel27.setText("Adequacy:");

        jLabel28.setText("Terminology");

        jLabel29.setText("Single words");

        jLabel30.setText("Incomprehensible");

        jLabel31.setText("Multi-word units - Idioms");

        jLabel32.setText("Untranslated words");

        jLabelWord1.setText("jLabel6");

        jLabelWord4.setText("jLabel6");

        jLabelWord3.setText("jLabel6");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel36.setText("Words");

        jLabelWord2.setText("jLabel6");

        jLabelWord5.setText("jLabel6");

        jLabel39.setText("Literal translation");

        jLabel40.setText("Conjunctions");

        jLabelWord6.setText("jLabel6");

        jLabelWord7.setText("jLabel6");

        jLabel43.setText("Extra words");

        jLabel44.setText("Spelling errors");

        jLabel45.setText("Acronyms - Abbreviations");

        jLabel46.setText("Accent");

        jLabel47.setText("Country standards ");

        jLabelStyle2.setText("jLabel6");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel49.setText("Style");

        jLabelStyle3.setText("jLabel6");

        jLabelStyle4.setText("jLabel6");

        jLabelStyle1.setText("jLabel6");

        jLabel53.setText("Capitalization");

        jLabelStyle5.setText("jLabel6");

        jLabelStyle6.setText("jLabel6");

        jLabel56.setText("Punctuation");

        jLabelStyle7.setText("jLabel6");

        jLabelGram5.setText("jLabel6");

        jLabelGram4.setText("jLabel6");

        jLabel60.setText("Agreement");

        jLabelGram1.setText("jLabel6");

        jLabel62.setText("Wrong category");

        jLabelGram2.setText("jLabel6");

        jLabelGram7.setText("jLabel6");

        jLabel65.setText("Other inflection");

        jLabel66.setText("Noun inflection");

        jLabel67.setText("Preposition");

        jLabel68.setText("Article");

        jLabelGram3.setText("jLabel6");

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel70.setText("Grammar ");

        jLabelGram6.setText("jLabel6");

        jLabel72.setText("Verb inflection");

        jButton1.setText("Download results");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60)
                            .addComponent(jLabel62)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66)
                            .addComponent(jLabel67)
                            .addComponent(jLabel68)
                            .addComponent(jLabel70)
                            .addComponent(jLabel72))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelGram5)
                            .addComponent(jLabelGram4)
                            .addComponent(jLabelGram1)
                            .addComponent(jLabelGram2)
                            .addComponent(jLabelGram7)
                            .addComponent(jLabelGram3)
                            .addComponent(jLabelGram6))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel36)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelWord1)
                            .addComponent(jLabelWord4)
                            .addComponent(jLabelWord3)
                            .addComponent(jLabelWord2)
                            .addComponent(jLabelWord5)
                            .addComponent(jLabelWord6)
                            .addComponent(jLabelWord7))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel49)
                            .addComponent(jLabel53)
                            .addComponent(jLabel56))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelStyle2)
                            .addComponent(jLabelStyle3)
                            .addComponent(jLabelStyle4)
                            .addComponent(jLabelStyle1)
                            .addComponent(jLabelStyle5)
                            .addComponent(jLabelStyle6)
                            .addComponent(jLabelStyle7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20)
                            .addComponent(jLabel5)
                            .addComponent(jLabel19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel21)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFluen1)
                            .addComponent(jLabelFluen4)
                            .addComponent(jLabelFluen3)
                            .addComponent(jLabelFluen5)
                            .addComponent(jLabelFluen2))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAdeq5)
                                    .addComponent(jLabelAdeq1)
                                    .addComponent(jLabelAdeq3)
                                    .addComponent(jLabelAdeq4)
                                    .addComponent(jLabelAdeq2)))
                            .addComponent(jLabel27))))
                .addContainerGap(144, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jButton1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel11)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel10)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel9)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelAdeq1)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelAdeq2)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelAdeq3)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelAdeq4)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelAdeq5))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFluen1)
                            .addComponent(jLabel19))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFluen2)
                            .addComponent(jLabel18))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFluen3)
                            .addComponent(jLabel17))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFluen4)
                            .addComponent(jLabel21))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFluen5)
                            .addComponent(jLabel20))))
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel66)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel65)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel62)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel68)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel67)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel60))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelGram1)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelGram2)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelGram3)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelGram4)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelGram5)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelGram6)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelGram7))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel31)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel28)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel32)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel30)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel39)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel40))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelWord1)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelWord2)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelWord3)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelWord4)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelWord5)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelWord6)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelWord7))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel43)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel47)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel44)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel46)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel53)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel56))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelStyle1)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelStyle2)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelStyle3)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelStyle4)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelStyle5)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelStyle6)
                                .addGap(11, 11, 11)
                                .addComponent(jLabelStyle7)))))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        File fres = new File(systemname + "_" + username.substring(0, 4) + "_" + l1.substring(0, 2) + "_" + l2.substring(0, 2) + "_results.txt");

        String message =
                "Results are saved in: \n \n"
                + fres.getAbsolutePath()
                + "\n \nThis file can easily be imported into Excel, SPSS, MATLAB, and most other \n"
                + "statistical software suites for further analysis and significance testing";
        JOptionPane.showMessageDialog(this, message);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
           
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAdeq1;
    private javax.swing.JLabel jLabelAdeq2;
    private javax.swing.JLabel jLabelAdeq3;
    private javax.swing.JLabel jLabelAdeq4;
    private javax.swing.JLabel jLabelAdeq5;
    private javax.swing.JLabel jLabelFluen1;
    private javax.swing.JLabel jLabelFluen2;
    private javax.swing.JLabel jLabelFluen3;
    private javax.swing.JLabel jLabelFluen4;
    private javax.swing.JLabel jLabelFluen5;
    private javax.swing.JLabel jLabelGram1;
    private javax.swing.JLabel jLabelGram2;
    private javax.swing.JLabel jLabelGram3;
    private javax.swing.JLabel jLabelGram4;
    private javax.swing.JLabel jLabelGram5;
    private javax.swing.JLabel jLabelGram6;
    private javax.swing.JLabel jLabelGram7;
    private javax.swing.JLabel jLabelStyle1;
    private javax.swing.JLabel jLabelStyle2;
    private javax.swing.JLabel jLabelStyle3;
    private javax.swing.JLabel jLabelStyle4;
    private javax.swing.JLabel jLabelStyle5;
    private javax.swing.JLabel jLabelStyle6;
    private javax.swing.JLabel jLabelStyle7;
    private javax.swing.JLabel jLabelWord1;
    private javax.swing.JLabel jLabelWord2;
    private javax.swing.JLabel jLabelWord3;
    private javax.swing.JLabel jLabelWord4;
    private javax.swing.JLabel jLabelWord5;
    private javax.swing.JLabel jLabelWord6;
    private javax.swing.JLabel jLabelWord7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
