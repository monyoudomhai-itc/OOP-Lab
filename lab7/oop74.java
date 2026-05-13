import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class oop74 {

    // Declare all 3 panels here so buttons can access them
    static JPanel settingPanel;
    static JPanel generalPanel;
    static JPanel aboutPanel;

    public static void main(String[] args) {

        // ── Create the Window ──────────────────────────────────────────
        JFrame frame = new JFrame("Settings");
        frame.setSize(800, 1400);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ── Create 3 Panels (Screens) ──────────────────────────────────
        settingPanel = new JPanel();
        generalPanel = new JPanel();
        aboutPanel   = new JPanel();

        // Each panel fills the whole window
        settingPanel.setLayout(null);
        settingPanel.setBounds(0, 0, 800, 1400);
        settingPanel.setBackground(new Color(220, 220, 220));

        generalPanel.setLayout(null);
        generalPanel.setBounds(0, 0, 800, 1400);
        generalPanel.setBackground(new Color(220, 220, 220));

        aboutPanel.setLayout(null);
        aboutPanel.setBounds(0, 0, 800, 1400);
        aboutPanel.setBackground(new Color(220, 220, 220));

        // ── Add all panels to the frame ────────────────────────────────
        frame.add(settingPanel);
        frame.add(generalPanel);
        frame.add(aboutPanel);

        // ==============================================================
        // SCREEN 1 : Setting
        // ==============================================================
        JLabel settingTitle = new JLabel("Setting");
        settingTitle.setBounds(50, 20, 300, 40);
        settingTitle.setFont(new Font("Arial", Font.BOLD, 22));
        settingPanel.add(settingTitle);

        JButton btnGeneral = new JButton("1. General");
        btnGeneral.setBounds(50, 100, 680, 55);
        settingPanel.add(btnGeneral);

        JButton btnWifi = new JButton("2. Wi-Fi");
        btnWifi.setBounds(50, 180, 680, 55);
        settingPanel.add(btnWifi);

        JButton btnBluetooth = new JButton("3. Bluetooth");
        btnBluetooth.setBounds(50, 260, 680, 55);
        settingPanel.add(btnBluetooth);

        JButton btnMobileData = new JButton("4. Mobile Data");
        btnMobileData.setBounds(50, 340, 680, 55);
        settingPanel.add(btnMobileData);

        JButton btnHotspot = new JButton("5. Hotspot");
        btnHotspot.setBounds(50, 420, 680, 55);
        settingPanel.add(btnHotspot);

        JButton btnNotification = new JButton("6. Notification");
        btnNotification.setBounds(50, 500, 680, 55);
        settingPanel.add(btnNotification);

        JButton btnQuit = new JButton("Quit");
        btnQuit.setBounds(50, 580, 680, 55);
        settingPanel.add(btnQuit);

        // ==============================================================
        // SCREEN 2 : Setting > General
        // ==============================================================
        JLabel generalTitle = new JLabel("Setting > General");
        generalTitle.setBounds(50, 20, 400, 40);
        generalTitle.setFont(new Font("Arial", Font.BOLD, 22));
        generalPanel.add(generalTitle);

        JButton btnAbout = new JButton("1. About");
        btnAbout.setBounds(50, 100, 680, 55);
        generalPanel.add(btnAbout);

        JButton btnSoftware = new JButton("2. Software Update");
        btnSoftware.setBounds(50, 180, 680, 55);
        generalPanel.add(btnSoftware);

        JButton btnStorage = new JButton("3. Storage");
        btnStorage.setBounds(50, 260, 680, 55);
        generalPanel.add(btnStorage);

        JButton btnBackFromGeneral = new JButton("Back");
        btnBackFromGeneral.setBounds(50, 340, 680, 55);
        generalPanel.add(btnBackFromGeneral);

        // ==============================================================
        // SCREEN 3 : Setting > General > About
        // ==============================================================
        JLabel aboutTitle = new JLabel("Setting > General > About");
        aboutTitle.setBounds(50, 20, 500, 40);
        aboutTitle.setFont(new Font("Arial", Font.BOLD, 22));
        aboutPanel.add(aboutTitle);

        // Name row
        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50, 100, 200, 40);
        labelName.setFont(new Font("Arial", Font.PLAIN, 18));
        aboutPanel.add(labelName);

        JLabel valueName = new JLabel("iPhone");
        valueName.setBounds(450, 100, 200, 40);
        valueName.setFont(new Font("Arial", Font.PLAIN, 18));
        aboutPanel.add(valueName);

        // Model row
        JLabel labelModel = new JLabel("Model");
        labelModel.setBounds(50, 170, 200, 40);
        labelModel.setFont(new Font("Arial", Font.PLAIN, 18));
        aboutPanel.add(labelModel);

        JLabel valueModel = new JLabel("IXs");
        valueModel.setBounds(450, 170, 200, 40);
        valueModel.setFont(new Font("Arial", Font.PLAIN, 18));
        aboutPanel.add(valueModel);

        // Version row
        JLabel labelVersion = new JLabel("Version");
        labelVersion.setBounds(50, 240, 200, 40);
        labelVersion.setFont(new Font("Arial", Font.PLAIN, 18));
        aboutPanel.add(labelVersion);

        JLabel valueVersion = new JLabel("18.5");
        valueVersion.setBounds(450, 240, 200, 40);
        valueVersion.setFont(new Font("Arial", Font.PLAIN, 18));
        aboutPanel.add(valueVersion);

        JButton btnBackFromAbout = new JButton("Back");
        btnBackFromAbout.setBounds(50, 320, 680, 55);
        aboutPanel.add(btnBackFromAbout);

        // ==============================================================
        // BUTTON ACTIONS (what happens when you click)
        // ==============================================================

        // Clicking General -> go to General screen
        btnGeneral.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settingPanel.setVisible(false);
                generalPanel.setVisible(true);
            }
        });

        // Clicking About -> go to About screen
        btnAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generalPanel.setVisible(false);
                aboutPanel.setVisible(true);
            }
        });

        // Back from General -> go back to Setting
        btnBackFromGeneral.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generalPanel.setVisible(false);
                settingPanel.setVisible(true);
            }
        });

        // Back from About -> go back to General
        btnBackFromAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aboutPanel.setVisible(false);
                generalPanel.setVisible(true);
            }
        });

        // Quit button -> close the app
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // ==============================================================
        // Show only Setting screen at the start
        // ==============================================================
        settingPanel.setVisible(true);
        generalPanel.setVisible(false);
        aboutPanel.setVisible(false);

        frame.setVisible(true);
    }
}