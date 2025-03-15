package Kuis123230109IFG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KuisHotelG {
    public static void main(String[] args) {
    LoginForm();
    } 

private static void LoginForm(){
        JFrame frame = new JFrame("Login Page");
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2, 5, 5));
        JLabel userLabel = new JLabel("USERNAME");
        JTextField userField = new JTextField();
        JLabel passwordLabel = new JLabel("PASSWORD");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("LOGIN");
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(new JLabel());
        frame.add(loginButton);

        loginButton.addActionListener(e -> {
           String username = userField.getText();
           String password = new String(passwordField.getPassword());
           if(username.equals("123230109") && password.equals("ifkelasg")){
               JOptionPane.showMessageDialog(frame, "Login berhasil!");
               frame.dispose();
               LandingPage();
           }else {
               JOptionPane.showMessageDialog(frame, "Username dan Password salah!", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
        });
        frame.setVisible(true);
    }

        private static void LandingPage(){
            JFrame frame = new JFrame("Reservasi Hotel");
            frame.setLocationRelativeTo(null);
            frame.setAlwaysOnTop(true);
            frame.setSize(500, 500);
            frame.setLayout(new GridLayout(8, 2, 5, 5));
            
            JLabel nameLabel = new JLabel("Nama: ");
            JTextField nameField = new JTextField();
            JLabel identityLabel = new JLabel("Identitas: "); // NIM atau NIK
            JTextField identityField = new JTextField();
            JLabel nightLabel = new JLabel("Malam: ");
            JTextField nightField = new JTextField();
            String[] rooms = {"Standard", "Deluxe", "Suite"};
            JComboBox cbrooms = new JComboBox(rooms);
            
            JCheckBox sarapanB = new JCheckBox("Sarapan");
            JCheckBox kolamB = new JCheckBox("Kolam Renang");
            JCheckBox spaB = new JCheckBox("Spa");
            ButtonGroup facility = new ButtonGroup();
            JButton submitButton = new JButton("SUBMIT");
            JButton logoutButton = new JButton("LOGOUT");
            
            frame.add(nameLabel);
            frame.add(nameField);
            frame.add(identityLabel);
            frame.add(identityField);
            frame.add(nightLabel);
            frame.add(nightField);
            frame.add(new JLabel("Fasilitas: "));
            frame.add(sarapanB);
            frame.add(new JLabel());
            frame.add(kolamB);
            frame.add(new JLabel());
            frame.add(spaB);
            frame.add(new JLabel("Kamar: "));
            frame.add(cbrooms);
            frame.add(submitButton);
            frame.add(logoutButton);

            submitButton.addActionListener(e -> {
               try{
                   long harga = 0, hargakamar = 0, hargafasilitas = 0, totalharga = 0;
                   String nama = nameField.getText();
                   String identitas = identityField.getText();
                   long malam = Long.parseLong(nightField.getText());
                   String kamar = (String) cbrooms.getSelectedItem();
                   
                    if (kamar.equals("Standard")) {
                        harga = 300000;
                        hargakamar = harga * malam;
                    } else if (kamar.equals("Deluxe")) {
                        harga = 500000;
                        hargakamar = harga * malam;
                    } else if (kamar.equals("Suite")) {
                        harga = 1500000;
                        hargakamar = harga * malam;
                    }
                    
                   
                   if (sarapanB.isSelected()){
                       long sarapan = 50000;
                       hargafasilitas += sarapan;
                   }
                   if (kolamB.isSelected()){
                       long kolam = 100000;
                       hargafasilitas += kolam;
                   }
                   if (spaB.isSelected()){
                       long spa = 200000;
                       hargafasilitas += spa;
                   }
                   
                   totalharga = hargakamar + hargafasilitas;
                   
                     String message = String.format(
                        "Reservasi Berhasil!"
                        + "\n\nNama: %s"
                        + "\nIdentitas: %s"
                        + "\nLama Menginap: %d malam"
                        + "\nJenis Kamar: %s"
                        + "\n\nHarga Kamar: Rp%,d"
                        + "\nFasilitas Tambahan: Rp%,d"
                        + "\n\nTotal Harga: Rp%,d",
                        nama, identitas, malam, kamar, hargakamar, hargafasilitas, totalharga
                );

                JOptionPane.showMessageDialog(frame, message);
                    
               }catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(frame, "Harap masukan data yang valid!", "ERROR", JOptionPane.ERROR_MESSAGE);
               } 
            });
            
        logoutButton.addActionListener(e -> {
           int confirm = JOptionPane.showConfirmDialog(frame, "Logout?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION){
                    frame.dispose();
                }
        });
        frame.setVisible(true);
        }
}
