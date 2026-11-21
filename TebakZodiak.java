import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TebakZodiak {
    public static void main(String[] args) {
        Color midnightBlue = new Color(26, 28, 51);
        Color dustyPlum = new Color(56, 46, 82);
        Color deepIndigo = new Color(36, 42, 74);
        Color mutedTeal = new Color(75, 128, 138);
        Color softLavender = new Color(224, 218, 240);
        Color warmSand = new Color(235, 208, 175);

        JFrame frame = new JFrame("Astro-Finder | Penebak Zodiak");
        frame.setSize(420, 290);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout(0, 0));
        frame.getContentPane().setBackground(midnightBlue);

        JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        panelHeader.setBackground(deepIndigo);

        JPanel panelInput = new JPanel(new GridLayout(2, 2, 12, 12));
        panelInput.setBackground(dustyPlum);
        panelInput.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JPanel panelHasil = new JPanel(new GridLayout(2, 1, 5, 8));
        panelHasil.setBackground(deepIndigo);
        panelHasil.setBorder(BorderFactory.createEmptyBorder(15, 30, 18, 30));

        JLabel labelJudul = new JLabel("CEK ZODIAK KAMU");
        labelJudul.setFont(new Font("SansSerif", Font.BOLD, 16));
        labelJudul.setForeground(softLavender);

        JLabel labelTanggal = new JLabel("Tanggal Lahir:");
        labelTanggal.setForeground(softLavender);
        labelTanggal.setFont(new Font("SansSerif", Font.PLAIN, 13));

        Integer[] daftarTanggal = new Integer[31];
        for (int i = 0; i < 31; i++) {
            daftarTanggal[i] = i + 1;
        }
        JComboBox<Integer> comboTanggal = new JComboBox<>(daftarTanggal);
        comboTanggal.setBackground(softLavender);
        comboTanggal.setForeground(midnightBlue);

        JLabel labelBulan = new JLabel("Bulan Lahir:");
        labelBulan.setForeground(softLavender);
        labelBulan.setFont(new Font("SansSerif", Font.PLAIN, 13));

        String[] daftarBulan = {
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };
        JComboBox<String> comboBulan = new JComboBox<>(daftarBulan);
        comboBulan.setBackground(softLavender);
        comboBulan.setForeground(midnightBlue);

        JButton tombolCek = new JButton("Lihat Zodiak");
        tombolCek.setBackground(mutedTeal);
        tombolCek.setForeground(Color.WHITE);
        tombolCek.setFont(new Font("SansSerif", Font.BOLD, 13));
        tombolCek.setFocusPainted(false);

        JLabel labelOutput = new JLabel("Pilih tanggal & bulan lahir di atas", SwingConstants.CENTER);
        labelOutput.setForeground(warmSand);
        labelOutput.setFont(new Font("SansSerif", Font.BOLD, 14));

        tombolCek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tgl = (int) comboTanggal.getSelectedItem();
                int bln = comboBulan.getSelectedIndex() + 1; // 1 = Januari, 12 = Desember

                String zodiak = tentukanZodiak(tgl, bln);
                labelOutput.setText("Zodiak Kamu: " + zodiak);
            }
        });

        panelHeader.add(labelJudul);

        panelInput.add(labelTanggal);
        panelInput.add(comboTanggal);
        panelInput.add(labelBulan);
        panelInput.add(comboBulan);

        panelHasil.add(tombolCek);
        panelHasil.add(labelOutput);

        frame.add(panelHeader, BorderLayout.NORTH);
        frame.add(panelInput, BorderLayout.CENTER);
        frame.add(panelHasil, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static String tentukanZodiak(int tgl, int bln) {
        if ((bln == 2 && tgl > 29) ||
                ((bln == 4 || bln == 6 || bln == 9 || bln == 11) && tgl > 30)) {
            return "Tanggal tidak valid di bulan ini!";
        }

        if ((bln == 3 && tgl >= 21) || (bln == 4 && tgl <= 19))
            return "Aries (Domba Jantan)";
        if ((bln == 4 && tgl >= 20) || (bln == 5 && tgl <= 20))
            return "Taurus (Banteng)";
        if ((bln == 5 && tgl >= 21) || (bln == 6 && tgl <= 20))
            return "Gemini (Si Kembar)";
        if ((bln == 6 && tgl >= 21) || (bln == 7 && tgl <= 22))
            return "Cancer (Kepiting)";
        if ((bln == 7 && tgl >= 23) || (bln == 8 && tgl <= 22))
            return "Leo (Singa)";
        if ((bln == 8 && tgl >= 23) || (bln == 9 && tgl <= 22))
            return "Virgo (Sang Gadis)";
        if ((bln == 9 && tgl >= 23) || (bln == 10 && tgl <= 22))
            return "Libra (Timbangan)";
        if ((bln == 10 && tgl >= 23) || (bln == 11 && tgl <= 21))
            return "Scorpio (Kalajengking)";
        if ((bln == 11 && tgl >= 22) || (bln == 12 && tgl <= 21))
            return "Sagitarius (Pemanah)";
        if ((bln == 12 && tgl >= 22) || (bln == 1 && tgl <= 19))
            return "Capricorn (Kambing Laut)";
        if ((bln == 1 && tgl >= 20) || (bln == 2 && tgl <= 18))
            return "Aquarius (Pembawa Air)";
        return "Pisces (Ikan)";
    }
}
