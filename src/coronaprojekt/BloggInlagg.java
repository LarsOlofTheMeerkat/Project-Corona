/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronaprojekt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Simon Sandberg
 */
public class BloggInlagg {

    private InfDB idb;
    private String vilkenBlogg;
    private String choosenFile;
    private int anvandareID;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public BloggInlagg(InfDB idb, int anvandareID, String vilkenBlogg) {
        this.idb = idb;
        this.anvandareID = anvandareID;
        this.vilkenBlogg = vilkenBlogg;
        choosenFile = "";
    }

    public void addPost(javax.swing.JComboBox<String> cboxValjKategori,
            javax.swing.JTextArea TxtAreaBloggText,
            javax.swing.JLabel lblChoosenFile) {
        String kategori = cboxValjKategori.getSelectedItem().toString();
        String bloggText = TxtAreaBloggText.getText();
        String informell;
        if (vilkenBlogg.equals("informell")) {
            informell = "J";
        } else {
            informell = "N";
        }
        try {
            int bloggpost_id = Integer.parseInt(idb.getAutoIncrement("blogg", "ID"));
            String kategori_id = idb.fetchSingle("SELECT id from kategori where namn = '" + kategori + "'");
            idb.insert("INSERT INTO BLOGG (ID, TEXT, ANVANDAREID, INFORMELL) VALUES ('" + bloggpost_id + "', '" + bloggText + "', '" + anvandareID + "', '" + informell + "')");
            idb.insert("INSERT INTO BLOGG_TILLHOR_KATEGORI (KATEGORIID, BLOGGID) VALUES ('" + kategori_id + "', '" + bloggpost_id + "')");
            if (!choosenFile.isEmpty()) {
                sparaInfoBifogadFil(bloggpost_id);
            }
            TxtAreaBloggText.setText("");
            lblChoosenFile.setText("");
        } catch (InfException e) {
            System.out.println("btn add post" + e);
        } catch (IOException ex) {
            Logger.getLogger(SkapaBlogginlagg.class.getName()).log(Level.SEVERE, null, ex);
        }
        //lblConfirmAddedPost.setText("Ditt inlägg har lagts upp!");
    }

    /*public void addFile(javax.swing.JLabel lblChoosenFile) {
        JFileChooser fc = new JFileChooser();
        int returnValue = fc.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                File f = fc.getSelectedFile();
                String filename = f.getAbsolutePath();
                lblChoosenFile.setText(filename);
                choosenFile = filename;
            } catch (Exception e) {
                System.out.println("Couldnt load file: " + e);
                lblChoosenFile.setText("Couldn't load file!");
            }
        } else {
            lblChoosenFile.setText("No file choosen!");
        }
    }*/
    private String getCurrentDateTime() {
        LocalDate localDate = LocalDate.now();
        return DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
    }

    private boolean fileExists(String pathToFile) {
        File file = new File(pathToFile);
        return file.exists();
    }

    public String findAvailableFileName(String fileName) {
        int i = 1;
        boolean availableNameFound = false;
        while (!availableNameFound) {
            String newFileName = "(" + i + ")" + fileName;
            String folder = System.getProperty("user.dir");
            String fileDest = folder + ("\\anvandarFiler\\" + newFileName);
            if (fileExists(fileDest)) {
                i++;
            } else {
                return fileDest;
            }
        }
        return null;
    }

    public void copyFileToDir(String pathToFile) {
        try {
            String separator = "\\";
            String[] arr = pathToFile.replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
            String fileName = arr[arr.length - 1];

            String folder = System.getProperty("user.dir");
            String fileDest = folder + ("\\anvandarFiler\\" + fileName);

            if (fileExists(fileDest)) {
                fileDest = findAvailableFileName(fileName);
            }

            Path src = Paths.get(pathToFile);
            Path dest = Paths.get(fileDest);
            Files.copy(src, dest);

        } catch (IOException ex) {
            System.out.println("Failed copyFileToDir: " + ex);
        }
    }

    public void sparaInfoBifogadFil(int bloggpost_id) throws IOException {
        String separator = "\\";
        String[] arr = choosenFile.replaceAll(Pattern.quote(separator), "\\\\").split("\\\\");
        String fileName = arr[arr.length - 1];

        String folder = System.getProperty("user.dir");
        String fileDest = folder + ("\\anvandarFiler\\" + fileName);

        copyFileToDir(choosenFile);

        try {
            int fil_id = Integer.parseInt(idb.getAutoIncrement("fil", "ID"));
            idb.insert("INSERT INTO FIL (ID, SOKVAG, INFORMATION, SKAPAD) VALUES ('" + fil_id + "', '" + fileDest + "', '" + fileName + "', '" + getCurrentDateTime() + "')");
            idb.insert("INSERT INTO FILER_TILL_BLOGG (FILID, BLOGGID) VALUES ('" + fil_id + "', '" + bloggpost_id + "')");
        } catch (InfException e) {
            System.out.println("sparaInfoBifogadFil " + e);
        }
    }

    public javax.swing.JComboBox<String> cboxSkrivUtKategorier(javax.swing.JComboBox<String> cboxValjKategori) {
        int i = 1;
        try {
            int antalKategoier = Integer.parseInt(idb.fetchSingle("SELECT COUNT(*) FROM kategori"));
            while (i <= (antalKategoier)) {
                String kategori = idb.fetchSingle("SELECT namn from kategori where id = '" + i + "'");
                cboxValjKategori.addItem(kategori);
                i++;
            }
        } catch (InfException ex) {
            System.out.println("Kunde inte skriva ut kategorierna till cbox: " + ex.getMessage());
        }
        return cboxValjKategori;
    }

    public void setLblEmpty(javax.swing.JLabel lblConfirmAddedPost) {
        lblConfirmAddedPost.setText("");
    }
}
