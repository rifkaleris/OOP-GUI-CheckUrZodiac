# Astro-Finder | Zodiac Guesser (`TebakZodiak.java`)

A Java Swing desktop application designed with a muted galaxy theme that determines a user's zodiac sign based on their selected birth date and month. This program demonstrates the **5 core GUI components/parts** in Java Swing.

---

## 1. Top-Level Container (`JFrame`)
* **Code:** `JFrame frame = new JFrame("Astro-Finder | Penebak Zodiak");`
* **Explanation:** Serves as the main outer window (`420x290` pixels) containing the title bar, window control buttons, and all inner panels.

## 2. Intermediate Containers (`JPanel`)
* **Code:** `panelHeader`, `panelInput`, and `panelHasil`
* **Explanation:** Acts as grouping panels inside the `JFrame` to separate the title header, the date/month input form, and the action/result area.

## 3. Atomic Components (`JLabel`, `JComboBox`, `JButton`)
* **Code:**
  * `JLabel`: `labelJudul`, `labelTanggal`, `labelBulan`, `labelOutput`
  * `JComboBox`: `comboTanggal` (1–31), `comboBulan` (Januari–Desember)
  * `JButton`: `tombolCek` (`"Lihat Zodiak"`)
* **Explanation:** The basic interactive and display elements that users directly see and interact with.

## 4. Layout Managers (`BorderLayout`, `FlowLayout`, `GridLayout`)
* **Code:**
  * `frame.setLayout(new BorderLayout(0, 0));` — Arranges the three panels into `NORTH`, `CENTER`, and `SOUTH`.
  * `new FlowLayout(FlowLayout.CENTER, 10, 15)` — Centers the title label inside `panelHeader`.
  * `new GridLayout(2, 2, 12, 12)` — Aligns the labels and dropdowns into a 2x2 grid inside `panelInput`.
  * `new GridLayout(2, 1, 5, 8)` — Stacks the button and output label vertically inside `panelHasil`.

## 5. Event Listener (`ActionListener`)
* **Code:** `tombolCek.addActionListener(new ActionListener() { ... })`
* **Explanation:** Overrides `actionPerformed(ActionEvent e)` to capture button clicks, retrieve the selected day and month from the dropdowns, validate the date via `tentukanZodiak(tgl, bln)`, and update `labelOutput` with the matching zodiac sign.

---

## Screenshots

### 1. Selecting Birth Date (`comboTanggal` Dropdown)
![Selecting Date](image_acf6dc.png)

### 2. Selecting Birth Month (`comboBulan` Dropdown)
![Selecting Month](image_acf6fa.png)

### 3. Zodiac Result Output (`17 Juni` -> `Gemini`)
![Zodiac Result](image_acf9c1.png)

---

## How to Run
1. Save the source file as **`TebakZodiak.java`** (make sure the screenshot images are in the same folder if uploading to GitHub).
2. Compile and run via terminal:
   ```bash
   javac TebakZodiak.java
   java TebakZodiak
