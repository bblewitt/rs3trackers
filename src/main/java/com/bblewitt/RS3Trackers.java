package main.java.com.bblewitt;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import main.java.com.bblewitt.pages.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class RS3Trackers {
    private static final String VERSION = "1.7.0";
    private static CardLayout cardLayout;
    private static JPanel mainPanel;
    private static int messageCode = 1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RS3Trackers app = new RS3Trackers();
            app.run();
        });
    }

    public void run() {
        JFrame frame = new JFrame("RS3 Trackers - Version " + VERSION);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 360);
        frame.setLocationRelativeTo(null);

        ImageIcon windowIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/icon.png")));
        frame.setIconImage(windowIcon.getImage());

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        BackgroundPanel panel = new BackgroundPanel("/images/rs3.png");
        panel.setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/main_menu.png")));
        JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);
        imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.add(imageLabel, BorderLayout.CENTER);

        panel.add(headerPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel inputPanel = new JPanel();
        inputPanel.setOpaque(false);
        JLabel usernameLabel = new JLabel("Enter Runescape Username:");
        usernameLabel.setForeground(Color.WHITE);
        JTextField usernameField = new JTextField(10);
        JButton fetchButton = new JButton("Update Hiscores");

        inputPanel.add(usernameLabel);
        inputPanel.add(usernameField);
        inputPanel.add(fetchButton);
        centerPanel.add(inputPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        int[][] buttonSizes = {
                {40, 85},
                {40, 85},
                {40, 85},
                {40, 85},
                {40, 85},
                {40, 85},
                {48, 85}
        };

        for (int i = 1; i <= 7; i++) {
            JButton navButton = new JButton();

            ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button" + i + ".png")));
            Image originalImage = originalIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(buttonSizes[i - 1][0], buttonSizes[i - 1][1], Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);

            navButton.setIcon(scaledIcon);
            navButton.setText("");
            navButton.setContentAreaFilled(false);
            navButton.setBorder(null);
            navButton.setFocusPainted(false);
            navButton.setPreferredSize(new Dimension(buttonSizes[i - 1][0], buttonSizes[i - 1][1]));

            navButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    navButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    navButton.setBorder(null);
                }
            });

            switch (i) {
                case 1 -> navButton.setToolTipText("Quest Cape Tracker");
                case 2 -> navButton.setToolTipText("Area Tasks Tracker");
                case 3 -> navButton.setToolTipText("Master Quest Cape Tracker");
                case 4 -> navButton.setToolTipText("Max Cape Tracker");
                case 5 -> navButton.setToolTipText("Completionist Cape Tracker");
                case 6 -> navButton.setToolTipText("Trimmed Completionist Cape Tracker");
                case 7 -> navButton.setToolTipText("Master Max Cape Tracker");
            }

            if (i == 1) {
                navButton.addActionListener(e -> {
                    frame.setSize(640, 720);
                    cardLayout.show(mainPanel, "questCapeTracker");
                });
            } else if (i == 2) {
                navButton.addActionListener(e -> {
                    frame.setSize(640, 720);
                    cardLayout.show(mainPanel, "areaTasksTracker");
                });
            } else if (i == 3) {
                navButton.addActionListener(e -> {
                    frame.setSize(640, 720);
                    cardLayout.show(mainPanel, "masterQuestCapeTracker");
                });
            } else if (i == 4) {
                navButton.addActionListener(e -> {
                    frame.setSize(640, 720);
                    cardLayout.show(mainPanel, "maxCapeTracker");
                });
            } else if (i == 5) {
                navButton.addActionListener(e -> {
                    frame.setSize(640, 720);
                    cardLayout.show(mainPanel, "compCapeTracker");
                });
            } else if (i == 6) {
                navButton.addActionListener(e -> {
                    frame.setSize(640, 720);
                    cardLayout.show(mainPanel, "trimCompCapeTracker");
                });
            } else {
                navButton.addActionListener(e -> {
                    frame.setSize(640, 720);
                    cardLayout.show(mainPanel, "masterMaxCapeTracker");
                });
            }
            buttonPanel.add(navButton);
        }

        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(buttonPanel);
        panel.add(centerPanel, BorderLayout.CENTER);

        fetchButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            if (!username.isEmpty()) {
                fetchHiscoresData(username);
            } else {
                showErrorMessage("Please enter a username.");
            }
        });

        JPanel questCapeTrackerPanel = new QuestCapeTrackerPanel(e -> {
            frame.setSize(640, 360);
            cardLayout.show(mainPanel, "mainMenu");
        });

        JPanel areaTasksTrackerPanel = new AreaTasksTrackerPanel(e -> {
            frame.setSize(640, 360);
            cardLayout.show(mainPanel, "mainMenu");
        });

        JPanel masterQuestCapeTrackerPanel = new MasterQuestCapeTrackerPanel(e -> {
            frame.setSize(640, 360);
            cardLayout.show(mainPanel, "mainMenu");
        });

        JPanel maxCapeTrackerPanel = new MaxCapeTrackerPanel(e -> {
            frame.setSize(640, 360);
            cardLayout.show(mainPanel, "mainMenu");
        });

        JPanel compCapeTrackerPanel = new CompCapeTrackerPanel(e -> {
            frame.setSize(640, 360);
            cardLayout.show(mainPanel, "mainMenu");
        });

        JPanel trimCompCapeTrackerPanel = new TrimCompCapeTrackerPanel(e -> {
            frame.setSize(640, 360);
            cardLayout.show(mainPanel, "mainMenu");
        });

        JPanel masterMaxCapeTrackerPanel = new MasterMaxCapeTrackerPanel(e -> {
            frame.setSize(640, 360);
            cardLayout.show(mainPanel, "mainMenu");
        });

        mainPanel.add(panel, "mainMenu");
        mainPanel.add(questCapeTrackerPanel, "questCapeTracker");
        mainPanel.add(areaTasksTrackerPanel, "areaTasksTracker");
        mainPanel.add(masterQuestCapeTrackerPanel, "masterQuestCapeTracker");
        mainPanel.add(maxCapeTrackerPanel, "maxCapeTracker");
        mainPanel.add(compCapeTrackerPanel, "compCapeTracker");
        mainPanel.add(trimCompCapeTrackerPanel, "trimCompCapeTracker");
        mainPanel.add(masterMaxCapeTrackerPanel, "masterMaxCapeTracker");

        cardLayout.show(mainPanel, "mainMenu");

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(String imagePath) {
            try {
                this.backgroundImage = new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath))).getImage();
            } catch (Exception e) {
                showErrorMessage("Error loading background image: " + e.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    private static void fetchHiscoresData(String username) {
        try {
            String url = "https://secure.runescape.com/m=hiscore/index_lite.ws?player=" + username;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine).append("\n");
            }
            in.close();
            connection.disconnect();

            final String outputFileName = saveHiscoresData(username, content);

            System.out.println("Data saved successfully to " + outputFileName);
        } catch (Exception e) {
            showErrorMessage("Error fetching or saving data: " + e.getMessage());
        }
    }

    private static String saveHiscoresData(String username, StringBuilder content) throws IOException {
        String userHome = System.getProperty("user.home");
        String outputDir = userHome + "/RS3Trackers/hiscores/";
        File hiscoresDir = new File(outputDir);

        if (!hiscoresDir.exists()) {
            if (!hiscoresDir.mkdirs()) {
                showErrorMessage("Failed to create directory: " + outputDir);
            }
        }

        String[] lines = content.toString().split("\n");
        final JsonObject hiscoreData = getJsonObject(lines);

        String outputFileName = outputDir + username + ".json";
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(outputFileName)) {
            gson.toJson(hiscoreData, writer);
        }
        return outputFileName;
    }

    private static JsonObject getJsonObject(String[] lines) {
        JsonObject hiscoreData = new JsonObject();
        String[] skills = {
                "Overall", "Attack", "Defence", "Strength", "Constitution", "Ranged", "Prayer",
                "Magic", "Cooking", "Woodcutting", "Fletching", "Fishing", "Firemaking",
                "Crafting", "Smithing", "Mining", "Herblore", "Agility", "Thieving", "Slayer",
                "Farming", "Runecrafting", "Hunter", "Construction", "Summoning", "Dungeoneering",
                "Divination", "Invention", "Archaeology", "Necromancy"
        };
        for (int i = 0; i < lines.length && i < skills.length; i++) {
            String[] values = lines[i].split(",");
            JsonObject skillData = new JsonObject();
            skillData.addProperty("rank", values[0]);
            skillData.addProperty("level", values[1]);
            skillData.addProperty("xp", values[2]);
            hiscoreData.add(skills[i], skillData);
        }
        return hiscoreData;
    }

    private static void showErrorMessage(String message) {
        String uniqueCode = "ERR-" + messageCode++;
        String fullMessage = "Error Code: " + uniqueCode + "\n" + message;
        JOptionPane.showMessageDialog(null, fullMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
