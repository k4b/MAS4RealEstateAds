package search;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class SearchWindow extends JFrame {
  
  private JPanel contentPane;
  private JTextField txtWarszawa;
  private JTextField txtBielany;
  private JTextField txtSzegedyska;
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  private JTextField textField_3;
  private JTextField textField_4;
  private JTextField textField_5;
  private JTable table;
  
  /**
   * Launch the application.
   */
//  public static void main(String[] args) {
//    EventQueue.invokeLater(new Runnable() {
//      public void run() {
//        try {
//          SearchWindow frame = new SearchWindow();
//          frame.setVisible(true);
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//      }
//    });
//  }
  
  /**
   * Create the frame.
   */
  public SearchWindow() {
    setTitle("Agregator ofert nieruchomości");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 600, 600);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    GridBagLayout gbl_contentPane = new GridBagLayout();
    gbl_contentPane.columnWidths = new int[]{0, 0, 38, 0, 20, 0, 0, 0, 0, 0};
    gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
    gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    contentPane.setLayout(gbl_contentPane);
    
    JLabel lblParametryWyszukiwania = new JLabel("Parametry wyszukiwania");
    GridBagConstraints gbc_lblParametryWyszukiwania = new GridBagConstraints();
    gbc_lblParametryWyszukiwania.gridwidth = 9;
    gbc_lblParametryWyszukiwania.insets = new Insets(0, 0, 5, 5);
    gbc_lblParametryWyszukiwania.gridx = 0;
    gbc_lblParametryWyszukiwania.gridy = 0;
    contentPane.add(lblParametryWyszukiwania, gbc_lblParametryWyszukiwania);
    
    JLabel lblKategoria = new JLabel("Transakcja");
    GridBagConstraints gbc_lblKategoria = new GridBagConstraints();
    gbc_lblKategoria.gridwidth = 7;
    gbc_lblKategoria.anchor = GridBagConstraints.WEST;
    gbc_lblKategoria.insets = new Insets(0, 0, 5, 5);
    gbc_lblKategoria.gridx = 1;
    gbc_lblKategoria.gridy = 1;
    contentPane.add(lblKategoria, gbc_lblKategoria);
    
    table = new JTable();
    GridBagConstraints gbc_table = new GridBagConstraints();
    gbc_table.gridwidth = 3;
    gbc_table.gridheight = 23;
    gbc_table.insets = new Insets(0, 0, 5, 0);
    gbc_table.fill = GridBagConstraints.BOTH;
    gbc_table.gridx = 9;
    gbc_table.gridy = 0;
    contentPane.add(table, gbc_table);
    
    JRadioButton rdbtnSprzeda = new JRadioButton("Sprzedaż");
    GridBagConstraints gbc_rdbtnSprzeda = new GridBagConstraints();
    gbc_rdbtnSprzeda.gridwidth = 4;
    gbc_rdbtnSprzeda.insets = new Insets(0, 0, 5, 5);
    gbc_rdbtnSprzeda.gridx = 1;
    gbc_rdbtnSprzeda.gridy = 2;
    contentPane.add(rdbtnSprzeda, gbc_rdbtnSprzeda);
    
    JRadioButton rdbtnWynajem = new JRadioButton("Wynajem");
    GridBagConstraints gbc_rdbtnWynajem = new GridBagConstraints();
    gbc_rdbtnWynajem.gridwidth = 3;
    gbc_rdbtnWynajem.insets = new Insets(0, 0, 5, 5);
    gbc_rdbtnWynajem.gridx = 5;
    gbc_rdbtnWynajem.gridy = 2;
    contentPane.add(rdbtnWynajem, gbc_rdbtnWynajem);
    
    JLabel lblRodzaj = new JLabel("Rodzaj");
    GridBagConstraints gbc_lblRodzaj = new GridBagConstraints();
    gbc_lblRodzaj.gridwidth = 7;
    gbc_lblRodzaj.anchor = GridBagConstraints.WEST;
    gbc_lblRodzaj.insets = new Insets(0, 0, 5, 5);
    gbc_lblRodzaj.gridx = 1;
    gbc_lblRodzaj.gridy = 3;
    contentPane.add(lblRodzaj, gbc_lblRodzaj);
    
    JLabel lblMiejscowo = new JLabel("Miejscowość");
    GridBagConstraints gbc_lblMiejscowo = new GridBagConstraints();
    gbc_lblMiejscowo.gridwidth = 7;
    gbc_lblMiejscowo.insets = new Insets(0, 0, 5, 5);
    gbc_lblMiejscowo.anchor = GridBagConstraints.WEST;
    gbc_lblMiejscowo.gridx = 1;
    gbc_lblMiejscowo.gridy = 5;
    contentPane.add(lblMiejscowo, gbc_lblMiejscowo);
    
    txtWarszawa = new JTextField();
    txtWarszawa.setText("Warszawa");
    GridBagConstraints gbc_txtWarszawa = new GridBagConstraints();
    gbc_txtWarszawa.gridwidth = 7;
    gbc_txtWarszawa.insets = new Insets(0, 0, 5, 5);
    gbc_txtWarszawa.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtWarszawa.gridx = 1;
    gbc_txtWarszawa.gridy = 6;
    contentPane.add(txtWarszawa, gbc_txtWarszawa);
    txtWarszawa.setColumns(10);
    
    JLabel lblDzielnica = new JLabel("Dzielnica");
    GridBagConstraints gbc_lblDzielnica = new GridBagConstraints();
    gbc_lblDzielnica.gridwidth = 7;
    gbc_lblDzielnica.anchor = GridBagConstraints.WEST;
    gbc_lblDzielnica.insets = new Insets(0, 0, 5, 5);
    gbc_lblDzielnica.gridx = 1;
    gbc_lblDzielnica.gridy = 7;
    contentPane.add(lblDzielnica, gbc_lblDzielnica);
    
    txtBielany = new JTextField();
    txtBielany.setText("Bielany");
    GridBagConstraints gbc_txtBielany = new GridBagConstraints();
    gbc_txtBielany.gridwidth = 7;
    gbc_txtBielany.insets = new Insets(0, 0, 5, 5);
    gbc_txtBielany.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtBielany.gridx = 1;
    gbc_txtBielany.gridy = 8;
    contentPane.add(txtBielany, gbc_txtBielany);
    txtBielany.setColumns(10);
    
    JLabel lblUlica = new JLabel("Ulica");
    GridBagConstraints gbc_lblUlica = new GridBagConstraints();
    gbc_lblUlica.gridwidth = 7;
    gbc_lblUlica.anchor = GridBagConstraints.WEST;
    gbc_lblUlica.insets = new Insets(0, 0, 5, 5);
    gbc_lblUlica.gridx = 1;
    gbc_lblUlica.gridy = 9;
    contentPane.add(lblUlica, gbc_lblUlica);
    
    txtSzegedyska = new JTextField();
    txtSzegedyska.setText("Szegedyńska");
    GridBagConstraints gbc_txtSzegedyska = new GridBagConstraints();
    gbc_txtSzegedyska.gridwidth = 7;
    gbc_txtSzegedyska.insets = new Insets(0, 0, 5, 5);
    gbc_txtSzegedyska.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtSzegedyska.gridx = 1;
    gbc_txtSzegedyska.gridy = 10;
    contentPane.add(txtSzegedyska, gbc_txtSzegedyska);
    txtSzegedyska.setColumns(10);
    
    JLabel lblCena = new JLabel("Cena");
    GridBagConstraints gbc_lblCena = new GridBagConstraints();
    gbc_lblCena.anchor = GridBagConstraints.WEST;
    gbc_lblCena.gridwidth = 7;
    gbc_lblCena.insets = new Insets(0, 0, 5, 5);
    gbc_lblCena.gridx = 1;
    gbc_lblCena.gridy = 11;
    contentPane.add(lblCena, gbc_lblCena);
    
    JLabel lblOd = new JLabel("Od");
    GridBagConstraints gbc_lblOd = new GridBagConstraints();
    gbc_lblOd.anchor = GridBagConstraints.EAST;
    gbc_lblOd.insets = new Insets(0, 0, 5, 5);
    gbc_lblOd.gridx = 1;
    gbc_lblOd.gridy = 12;
    contentPane.add(lblOd, gbc_lblOd);
    
    textField = new JTextField();
    textField.setHorizontalAlignment(SwingConstants.RIGHT);
    textField.setText("100000");
    GridBagConstraints gbc_textField = new GridBagConstraints();
    gbc_textField.gridwidth = 3;
    gbc_textField.fill = GridBagConstraints.HORIZONTAL;
    gbc_textField.insets = new Insets(0, 0, 5, 5);
    gbc_textField.gridx = 2;
    gbc_textField.gridy = 12;
    contentPane.add(textField, gbc_textField);
    textField.setColumns(10);
    
    JLabel lblDo = new JLabel("Do");
    GridBagConstraints gbc_lblDo = new GridBagConstraints();
    gbc_lblDo.anchor = GridBagConstraints.EAST;
    gbc_lblDo.insets = new Insets(0, 0, 5, 5);
    gbc_lblDo.gridx = 5;
    gbc_lblDo.gridy = 12;
    contentPane.add(lblDo, gbc_lblDo);
    
    textField_1 = new JTextField();
    textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_1.setText("320000");
    GridBagConstraints gbc_textField_1 = new GridBagConstraints();
    gbc_textField_1.gridwidth = 2;
    gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
    gbc_textField_1.insets = new Insets(0, 0, 5, 5);
    gbc_textField_1.gridx = 6;
    gbc_textField_1.gridy = 12;
    contentPane.add(textField_1, gbc_textField_1);
    textField_1.setColumns(10);
    
    JLabel lblCenaZaM = new JLabel("Cena za m2");
    GridBagConstraints gbc_lblCenaZaM = new GridBagConstraints();
    gbc_lblCenaZaM.gridwidth = 7;
    gbc_lblCenaZaM.anchor = GridBagConstraints.WEST;
    gbc_lblCenaZaM.insets = new Insets(0, 0, 5, 5);
    gbc_lblCenaZaM.gridx = 1;
    gbc_lblCenaZaM.gridy = 13;
    contentPane.add(lblCenaZaM, gbc_lblCenaZaM);
    
    JLabel lblOd_1 = new JLabel("Od");
    GridBagConstraints gbc_lblOd_1 = new GridBagConstraints();
    gbc_lblOd_1.anchor = GridBagConstraints.EAST;
    gbc_lblOd_1.insets = new Insets(0, 0, 5, 5);
    gbc_lblOd_1.gridx = 1;
    gbc_lblOd_1.gridy = 14;
    contentPane.add(lblOd_1, gbc_lblOd_1);
    
    textField_2 = new JTextField();
    textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_2.setText("2000");
    GridBagConstraints gbc_textField_2 = new GridBagConstraints();
    gbc_textField_2.gridwidth = 3;
    gbc_textField_2.insets = new Insets(0, 0, 5, 5);
    gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
    gbc_textField_2.gridx = 2;
    gbc_textField_2.gridy = 14;
    contentPane.add(textField_2, gbc_textField_2);
    textField_2.setColumns(10);
    
    JLabel lblDo_1 = new JLabel("Do");
    GridBagConstraints gbc_lblDo_1 = new GridBagConstraints();
    gbc_lblDo_1.anchor = GridBagConstraints.EAST;
    gbc_lblDo_1.insets = new Insets(0, 0, 5, 5);
    gbc_lblDo_1.gridx = 5;
    gbc_lblDo_1.gridy = 14;
    contentPane.add(lblDo_1, gbc_lblDo_1);
    
    textField_3 = new JTextField();
    textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_3.setText("6500");
    GridBagConstraints gbc_textField_3 = new GridBagConstraints();
    gbc_textField_3.gridwidth = 2;
    gbc_textField_3.insets = new Insets(0, 0, 5, 5);
    gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
    gbc_textField_3.gridx = 6;
    gbc_textField_3.gridy = 14;
    contentPane.add(textField_3, gbc_textField_3);
    textField_3.setColumns(10);
    
    JLabel lblPokoje = new JLabel("Pokoje");
    GridBagConstraints gbc_lblPokoje = new GridBagConstraints();
    gbc_lblPokoje.gridwidth = 7;
    gbc_lblPokoje.anchor = GridBagConstraints.WEST;
    gbc_lblPokoje.insets = new Insets(0, 0, 5, 5);
    gbc_lblPokoje.gridx = 1;
    gbc_lblPokoje.gridy = 15;
    contentPane.add(lblPokoje, gbc_lblPokoje);
    
    JCheckBox checkBox = new JCheckBox("1");
    GridBagConstraints gbc_checkBox = new GridBagConstraints();
    gbc_checkBox.anchor = GridBagConstraints.WEST;
    gbc_checkBox.insets = new Insets(0, 0, 5, 5);
    gbc_checkBox.gridx = 1;
    gbc_checkBox.gridy = 16;
    contentPane.add(checkBox, gbc_checkBox);
    
    JCheckBox checkBox_1 = new JCheckBox("2");
    GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
    gbc_checkBox_1.anchor = GridBagConstraints.WEST;
    gbc_checkBox_1.insets = new Insets(0, 0, 5, 5);
    gbc_checkBox_1.gridx = 2;
    gbc_checkBox_1.gridy = 16;
    contentPane.add(checkBox_1, gbc_checkBox_1);
    
    JCheckBox checkBox_2 = new JCheckBox("3");
    GridBagConstraints gbc_checkBox_2 = new GridBagConstraints();
    gbc_checkBox_2.anchor = GridBagConstraints.WEST;
    gbc_checkBox_2.insets = new Insets(0, 0, 5, 5);
    gbc_checkBox_2.gridx = 3;
    gbc_checkBox_2.gridy = 16;
    contentPane.add(checkBox_2, gbc_checkBox_2);
    
    JCheckBox checkBox_3 = new JCheckBox("4");
    GridBagConstraints gbc_checkBox_3 = new GridBagConstraints();
    gbc_checkBox_3.anchor = GridBagConstraints.WEST;
    gbc_checkBox_3.insets = new Insets(0, 0, 5, 5);
    gbc_checkBox_3.gridx = 4;
    gbc_checkBox_3.gridy = 16;
    contentPane.add(checkBox_3, gbc_checkBox_3);
    
    JCheckBox checkBox_4 = new JCheckBox("5+");
    GridBagConstraints gbc_checkBox_4 = new GridBagConstraints();
    gbc_checkBox_4.anchor = GridBagConstraints.WEST;
    gbc_checkBox_4.insets = new Insets(0, 0, 5, 5);
    gbc_checkBox_4.gridx = 5;
    gbc_checkBox_4.gridy = 16;
    contentPane.add(checkBox_4, gbc_checkBox_4);
    
    JLabel lblPowierzchnia = new JLabel("Metraż");
    GridBagConstraints gbc_lblPowierzchnia = new GridBagConstraints();
    gbc_lblPowierzchnia.gridwidth = 7;
    gbc_lblPowierzchnia.anchor = GridBagConstraints.WEST;
    gbc_lblPowierzchnia.insets = new Insets(0, 0, 5, 5);
    gbc_lblPowierzchnia.gridx = 1;
    gbc_lblPowierzchnia.gridy = 17;
    contentPane.add(lblPowierzchnia, gbc_lblPowierzchnia);
    
    JLabel lblOd_2 = new JLabel("Od");
    GridBagConstraints gbc_lblOd_2 = new GridBagConstraints();
    gbc_lblOd_2.anchor = GridBagConstraints.EAST;
    gbc_lblOd_2.insets = new Insets(0, 0, 5, 5);
    gbc_lblOd_2.gridx = 1;
    gbc_lblOd_2.gridy = 18;
    contentPane.add(lblOd_2, gbc_lblOd_2);
    
    textField_4 = new JTextField();
    textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_4.setText("30");
    GridBagConstraints gbc_textField_4 = new GridBagConstraints();
    gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
    gbc_textField_4.gridwidth = 3;
    gbc_textField_4.insets = new Insets(0, 0, 5, 5);
    gbc_textField_4.gridx = 2;
    gbc_textField_4.gridy = 18;
    contentPane.add(textField_4, gbc_textField_4);
    textField_4.setColumns(10);
    
    JLabel lblDo_2 = new JLabel("Do");
    GridBagConstraints gbc_lblDo_2 = new GridBagConstraints();
    gbc_lblDo_2.anchor = GridBagConstraints.EAST;
    gbc_lblDo_2.insets = new Insets(0, 0, 5, 5);
    gbc_lblDo_2.gridx = 5;
    gbc_lblDo_2.gridy = 18;
    contentPane.add(lblDo_2, gbc_lblDo_2);
    
    textField_5 = new JTextField();
    textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
    textField_5.setText("50");
    GridBagConstraints gbc_textField_5 = new GridBagConstraints();
    gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
    gbc_textField_5.gridwidth = 2;
    gbc_textField_5.insets = new Insets(0, 0, 5, 5);
    gbc_textField_5.gridx = 6;
    gbc_textField_5.gridy = 18;
    contentPane.add(textField_5, gbc_textField_5);
    textField_5.setColumns(10);
    
    JLabel lblOgoszenie = new JLabel("Ogłoszenie");
    GridBagConstraints gbc_lblOgoszenie = new GridBagConstraints();
    gbc_lblOgoszenie.gridwidth = 7;
    gbc_lblOgoszenie.anchor = GridBagConstraints.WEST;
    gbc_lblOgoszenie.insets = new Insets(0, 0, 5, 5);
    gbc_lblOgoszenie.gridx = 1;
    gbc_lblOgoszenie.gridy = 19;
    contentPane.add(lblOgoszenie, gbc_lblOgoszenie);
    
    JCheckBox chckbxOferuj = new JCheckBox("Oferowane");
    chckbxOferuj.setHorizontalAlignment(SwingConstants.LEFT);
    GridBagConstraints gbc_chckbxOferuj = new GridBagConstraints();
    gbc_chckbxOferuj.anchor = GridBagConstraints.WEST;
    gbc_chckbxOferuj.gridwidth = 4;
    gbc_chckbxOferuj.insets = new Insets(0, 0, 5, 5);
    gbc_chckbxOferuj.gridx = 1;
    gbc_chckbxOferuj.gridy = 20;
    contentPane.add(chckbxOferuj, gbc_chckbxOferuj);
    
    JCheckBox chckbxPoszukiwane = new JCheckBox("Poszukiwane");
    GridBagConstraints gbc_chckbxPoszukiwane = new GridBagConstraints();
    gbc_chckbxPoszukiwane.anchor = GridBagConstraints.WEST;
    gbc_chckbxPoszukiwane.gridwidth = 3;
    gbc_chckbxPoszukiwane.insets = new Insets(0, 0, 5, 5);
    gbc_chckbxPoszukiwane.gridx = 5;
    gbc_chckbxPoszukiwane.gridy = 20;
    contentPane.add(chckbxPoszukiwane, gbc_chckbxPoszukiwane);
    
    JLabel lblOgoszeniodawca = new JLabel("Ogłoszeniodawca");
    GridBagConstraints gbc_lblOgoszeniodawca = new GridBagConstraints();
    gbc_lblOgoszeniodawca.anchor = GridBagConstraints.WEST;
    gbc_lblOgoszeniodawca.gridwidth = 7;
    gbc_lblOgoszeniodawca.insets = new Insets(0, 0, 5, 5);
    gbc_lblOgoszeniodawca.gridx = 1;
    gbc_lblOgoszeniodawca.gridy = 21;
    contentPane.add(lblOgoszeniodawca, gbc_lblOgoszeniodawca);
    
    JCheckBox chckbxWaciciel = new JCheckBox("Właściciel");
    GridBagConstraints gbc_chckbxWaciciel = new GridBagConstraints();
    gbc_chckbxWaciciel.anchor = GridBagConstraints.WEST;
    gbc_chckbxWaciciel.gridwidth = 4;
    gbc_chckbxWaciciel.insets = new Insets(0, 0, 5, 5);
    gbc_chckbxWaciciel.gridx = 1;
    gbc_chckbxWaciciel.gridy = 22;
    contentPane.add(chckbxWaciciel, gbc_chckbxWaciciel);
    
    JCheckBox chckbxAgencja = new JCheckBox("Agencja");
    GridBagConstraints gbc_chckbxAgencja = new GridBagConstraints();
    gbc_chckbxAgencja.anchor = GridBagConstraints.WEST;
    gbc_chckbxAgencja.gridwidth = 3;
    gbc_chckbxAgencja.insets = new Insets(0, 0, 5, 5);
    gbc_chckbxAgencja.gridx = 5;
    gbc_chckbxAgencja.gridy = 22;
    contentPane.add(chckbxAgencja, gbc_chckbxAgencja);
    
    JCheckBox chckbxMieszkanie = new JCheckBox("Mieszkanie");
    GridBagConstraints gbc_chckbxMieszkanie = new GridBagConstraints();
    gbc_chckbxMieszkanie.gridwidth = 4;
    gbc_chckbxMieszkanie.anchor = GridBagConstraints.WEST;
    gbc_chckbxMieszkanie.insets = new Insets(0, 0, 5, 5);
    gbc_chckbxMieszkanie.gridx = 1;
    gbc_chckbxMieszkanie.gridy = 4;
    contentPane.add(chckbxMieszkanie, gbc_chckbxMieszkanie);
    
    JCheckBox chckbxDom = new JCheckBox("Dom");
    GridBagConstraints gbc_chckbxDom = new GridBagConstraints();
    gbc_chckbxDom.gridwidth = 2;
    gbc_chckbxDom.anchor = GridBagConstraints.WEST;
    gbc_chckbxDom.insets = new Insets(0, 0, 5, 5);
    gbc_chckbxDom.gridx = 5;
    gbc_chckbxDom.gridy = 4;
    contentPane.add(chckbxDom, gbc_chckbxDom);
    
    JCheckBox chckbxInne = new JCheckBox("Inne");
    GridBagConstraints gbc_chckbxInne = new GridBagConstraints();
    gbc_chckbxInne.insets = new Insets(0, 0, 5, 5);
    gbc_chckbxInne.fill = GridBagConstraints.HORIZONTAL;
    gbc_chckbxInne.gridwidth = 2;
    gbc_chckbxInne.gridx = 7;
    gbc_chckbxInne.gridy = 4;
    contentPane.add(chckbxInne, gbc_chckbxInne);
    
    JButton btnNewButton = new JButton("Wyszukaj");
    GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
    gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
    gbc_btnNewButton.anchor = GridBagConstraints.SOUTH;
    gbc_btnNewButton.gridwidth = 7;
    gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
    gbc_btnNewButton.gridx = 1;
    gbc_btnNewButton.gridy = 23;
    contentPane.add(btnNewButton, gbc_btnNewButton);
  }  
}
