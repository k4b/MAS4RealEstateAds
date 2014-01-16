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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;

import common.ads.Filter;

public class SearchWindow extends JFrame {
  
  private JPanel contentPane;
  private JTextField txtCity;
  private JTextField txtDistrict;
  private JTextField txtStreet;
  private JTextField txtPriceMin;
  private JTextField txtPriceMax;
  private JTextField txtPricePerMeterMin;
  private JTextField txtPricePerMeterMax;
  private JTextField txtAreaMin;
  private JTextField txtAreaMax;
  private JTable table;
  private ButtonGroup transactionGroup, typeGroup, adGroup, advertiserGroup;
  private JTextField txtRoomsNumMin;
  private JTextField txtRoomsNumMax;
  
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
    gbl_contentPane.columnWidths = new int[]{0, 0, 38, 0, 0, 0, 0, 0, 0};
    gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0};
    gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    contentPane.setLayout(gbl_contentPane);
    
    JLabel lblParametryWyszukiwania = new JLabel("Parametry wyszukiwania");
    GridBagConstraints gbc_lblParametryWyszukiwania = new GridBagConstraints();
    gbc_lblParametryWyszukiwania.gridwidth = 8;
    gbc_lblParametryWyszukiwania.insets = new Insets(0, 0, 5, 5);
    gbc_lblParametryWyszukiwania.gridx = 0;
    gbc_lblParametryWyszukiwania.gridy = 0;
    contentPane.add(lblParametryWyszukiwania, gbc_lblParametryWyszukiwania);
    
    JLabel lblKategoria = new JLabel("Transakcja");
    GridBagConstraints gbc_lblKategoria = new GridBagConstraints();
    gbc_lblKategoria.gridwidth = 6;
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
    gbc_table.gridx = 8;
    gbc_table.gridy = 0;
    contentPane.add(table, gbc_table);
    
    JRadioButton radioSell = new JRadioButton("Kupno/Sprzedaż");
    GridBagConstraints gbc_radioSell = new GridBagConstraints();
    gbc_radioSell.gridwidth = 3;
    gbc_radioSell.insets = new Insets(0, 0, 5, 5);
    gbc_radioSell.gridx = 1;
    gbc_radioSell.gridy = 2;
    contentPane.add(radioSell, gbc_radioSell);
    
    JRadioButton radioRent = new JRadioButton("Wynajem");
    GridBagConstraints gbc_radioRent = new GridBagConstraints();
    gbc_radioRent.gridwidth = 3;
    gbc_radioRent.insets = new Insets(0, 0, 5, 5);
    gbc_radioRent.gridx = 4;
    gbc_radioRent.gridy = 2;
    contentPane.add(radioRent, gbc_radioRent);
    
    transactionGroup = new ButtonGroup();
    transactionGroup.add(radioSell);
    transactionGroup.add(radioRent);
    
    JLabel lblRodzaj = new JLabel("Rodzaj");
    GridBagConstraints gbc_lblRodzaj = new GridBagConstraints();
    gbc_lblRodzaj.gridwidth = 6;
    gbc_lblRodzaj.anchor = GridBagConstraints.WEST;
    gbc_lblRodzaj.insets = new Insets(0, 0, 5, 5);
    gbc_lblRodzaj.gridx = 1;
    gbc_lblRodzaj.gridy = 3;
    contentPane.add(lblRodzaj, gbc_lblRodzaj);
    
    JRadioButton radioTypeFlat = new JRadioButton("Mieszkanie");
    GridBagConstraints gbc_radioTypeFlat = new GridBagConstraints();
    gbc_radioTypeFlat.gridwidth = 2;
    gbc_radioTypeFlat.insets = new Insets(0, 0, 5, 5);
    gbc_radioTypeFlat.gridx = 1;
    gbc_radioTypeFlat.gridy = 4;
    contentPane.add(radioTypeFlat, gbc_radioTypeFlat);
    
    JRadioButton radioTypeHouse = new JRadioButton("Dom");
    GridBagConstraints gbc_radioTypeHouse = new GridBagConstraints();
    gbc_radioTypeHouse.gridwidth = 2;
    gbc_radioTypeHouse.insets = new Insets(0, 0, 5, 5);
    gbc_radioTypeHouse.gridx = 3;
    gbc_radioTypeHouse.gridy = 4;
    contentPane.add(radioTypeHouse, gbc_radioTypeHouse);
    
    JRadioButton radioTypeOther = new JRadioButton("Inne");
    GridBagConstraints gbc_radioTypeOther = new GridBagConstraints();
    gbc_radioTypeOther.gridwidth = 2;
    gbc_radioTypeOther.insets = new Insets(0, 0, 5, 5);
    gbc_radioTypeOther.gridx = 5;
    gbc_radioTypeOther.gridy = 4;
    contentPane.add(radioTypeOther, gbc_radioTypeOther);
    
    typeGroup = new ButtonGroup();
    typeGroup.add(radioTypeFlat);
    typeGroup.add(radioTypeHouse);
    typeGroup.add(radioTypeOther);
    
    JLabel lblMiejscowo = new JLabel("Miejscowość");
    GridBagConstraints gbc_lblMiejscowo = new GridBagConstraints();
    gbc_lblMiejscowo.gridwidth = 6;
    gbc_lblMiejscowo.insets = new Insets(0, 0, 5, 5);
    gbc_lblMiejscowo.anchor = GridBagConstraints.WEST;
    gbc_lblMiejscowo.gridx = 1;
    gbc_lblMiejscowo.gridy = 5;
    contentPane.add(lblMiejscowo, gbc_lblMiejscowo);
    
    txtCity = new JTextField();
    txtCity.setText("Warszawa");
    GridBagConstraints gbc_txtCity = new GridBagConstraints();
    gbc_txtCity.gridwidth = 6;
    gbc_txtCity.insets = new Insets(0, 0, 5, 5);
    gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtCity.gridx = 1;
    gbc_txtCity.gridy = 6;
    contentPane.add(txtCity, gbc_txtCity);
    txtCity.setColumns(10);
    
    JLabel lblDzielnica = new JLabel("Dzielnica");
    GridBagConstraints gbc_lblDzielnica = new GridBagConstraints();
    gbc_lblDzielnica.gridwidth = 6;
    gbc_lblDzielnica.anchor = GridBagConstraints.WEST;
    gbc_lblDzielnica.insets = new Insets(0, 0, 5, 5);
    gbc_lblDzielnica.gridx = 1;
    gbc_lblDzielnica.gridy = 7;
    contentPane.add(lblDzielnica, gbc_lblDzielnica);
    
    txtDistrict = new JTextField();
    txtDistrict.setText("Bielany");
    GridBagConstraints gbc_txtDistrict = new GridBagConstraints();
    gbc_txtDistrict.gridwidth = 6;
    gbc_txtDistrict.insets = new Insets(0, 0, 5, 5);
    gbc_txtDistrict.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtDistrict.gridx = 1;
    gbc_txtDistrict.gridy = 8;
    contentPane.add(txtDistrict, gbc_txtDistrict);
    txtDistrict.setColumns(10);
    
    JLabel lblUlica = new JLabel("Ulica");
    GridBagConstraints gbc_lblUlica = new GridBagConstraints();
    gbc_lblUlica.gridwidth = 6;
    gbc_lblUlica.anchor = GridBagConstraints.WEST;
    gbc_lblUlica.insets = new Insets(0, 0, 5, 5);
    gbc_lblUlica.gridx = 1;
    gbc_lblUlica.gridy = 9;
    contentPane.add(lblUlica, gbc_lblUlica);
    
    txtStreet = new JTextField();
    txtStreet.setText("Szegedyńska");
    GridBagConstraints gbc_txtStreet = new GridBagConstraints();
    gbc_txtStreet.gridwidth = 6;
    gbc_txtStreet.insets = new Insets(0, 0, 5, 5);
    gbc_txtStreet.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtStreet.gridx = 1;
    gbc_txtStreet.gridy = 10;
    contentPane.add(txtStreet, gbc_txtStreet);
    txtStreet.setColumns(10);
    
    JLabel lblCena = new JLabel("Cena");
    GridBagConstraints gbc_lblCena = new GridBagConstraints();
    gbc_lblCena.anchor = GridBagConstraints.WEST;
    gbc_lblCena.gridwidth = 6;
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
    
    txtPriceMin = new JTextField();
    txtPriceMin.setHorizontalAlignment(SwingConstants.RIGHT);
    txtPriceMin.setText("100000");
    GridBagConstraints gbc_txtPriceMin = new GridBagConstraints();
    gbc_txtPriceMin.gridwidth = 2;
    gbc_txtPriceMin.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtPriceMin.insets = new Insets(0, 0, 5, 5);
    gbc_txtPriceMin.gridx = 2;
    gbc_txtPriceMin.gridy = 12;
    contentPane.add(txtPriceMin, gbc_txtPriceMin);
    txtPriceMin.setColumns(10);
    
    JLabel lblDo = new JLabel("Do");
    GridBagConstraints gbc_lblDo = new GridBagConstraints();
    gbc_lblDo.anchor = GridBagConstraints.EAST;
    gbc_lblDo.insets = new Insets(0, 0, 5, 5);
    gbc_lblDo.gridx = 4;
    gbc_lblDo.gridy = 12;
    contentPane.add(lblDo, gbc_lblDo);
    
    txtPriceMax = new JTextField();
    txtPriceMax.setHorizontalAlignment(SwingConstants.RIGHT);
    txtPriceMax.setText("320000");
    GridBagConstraints gbc_txtPriceMax = new GridBagConstraints();
    gbc_txtPriceMax.gridwidth = 2;
    gbc_txtPriceMax.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtPriceMax.insets = new Insets(0, 0, 5, 5);
    gbc_txtPriceMax.gridx = 5;
    gbc_txtPriceMax.gridy = 12;
    contentPane.add(txtPriceMax, gbc_txtPriceMax);
    txtPriceMax.setColumns(10);
    
    JLabel lblCenaZaM = new JLabel("Cena za m2");
    GridBagConstraints gbc_lblCenaZaM = new GridBagConstraints();
    gbc_lblCenaZaM.gridwidth = 6;
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
    
    txtPricePerMeterMin = new JTextField();
    txtPricePerMeterMin.setHorizontalAlignment(SwingConstants.RIGHT);
    txtPricePerMeterMin.setText("2000");
    GridBagConstraints gbc_txtPricePerMeterMin = new GridBagConstraints();
    gbc_txtPricePerMeterMin.gridwidth = 2;
    gbc_txtPricePerMeterMin.insets = new Insets(0, 0, 5, 5);
    gbc_txtPricePerMeterMin.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtPricePerMeterMin.gridx = 2;
    gbc_txtPricePerMeterMin.gridy = 14;
    contentPane.add(txtPricePerMeterMin, gbc_txtPricePerMeterMin);
    txtPricePerMeterMin.setColumns(10);
    
    JLabel lblDo_1 = new JLabel("Do");
    GridBagConstraints gbc_lblDo_1 = new GridBagConstraints();
    gbc_lblDo_1.anchor = GridBagConstraints.EAST;
    gbc_lblDo_1.insets = new Insets(0, 0, 5, 5);
    gbc_lblDo_1.gridx = 4;
    gbc_lblDo_1.gridy = 14;
    contentPane.add(lblDo_1, gbc_lblDo_1);
    
    txtPricePerMeterMax = new JTextField();
    txtPricePerMeterMax.setHorizontalAlignment(SwingConstants.RIGHT);
    txtPricePerMeterMax.setText("6500");
    GridBagConstraints gbc_txtPricePerMeterMax = new GridBagConstraints();
    gbc_txtPricePerMeterMax.gridwidth = 2;
    gbc_txtPricePerMeterMax.insets = new Insets(0, 0, 5, 5);
    gbc_txtPricePerMeterMax.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtPricePerMeterMax.gridx = 5;
    gbc_txtPricePerMeterMax.gridy = 14;
    contentPane.add(txtPricePerMeterMax, gbc_txtPricePerMeterMax);
    txtPricePerMeterMax.setColumns(10);
    
    JLabel lblPokoje = new JLabel("Liczba pokoi");
    GridBagConstraints gbc_lblPokoje = new GridBagConstraints();
    gbc_lblPokoje.gridwidth = 6;
    gbc_lblPokoje.anchor = GridBagConstraints.WEST;
    gbc_lblPokoje.insets = new Insets(0, 0, 5, 5);
    gbc_lblPokoje.gridx = 1;
    gbc_lblPokoje.gridy = 15;
    contentPane.add(lblPokoje, gbc_lblPokoje);
    
    JLabel lblRoomsNumMin = new JLabel("Od");
    GridBagConstraints gbc_lblRoomsNumMin = new GridBagConstraints();
    gbc_lblRoomsNumMin.anchor = GridBagConstraints.EAST;
    gbc_lblRoomsNumMin.insets = new Insets(0, 0, 5, 5);
    gbc_lblRoomsNumMin.gridx = 1;
    gbc_lblRoomsNumMin.gridy = 16;
    contentPane.add(lblRoomsNumMin, gbc_lblRoomsNumMin);
    
    txtRoomsNumMin = new JTextField();
    txtRoomsNumMin.setHorizontalAlignment(SwingConstants.RIGHT);
    txtRoomsNumMin.setText("1");
    GridBagConstraints gbc_txtRoomsNumMin = new GridBagConstraints();
    gbc_txtRoomsNumMin.gridwidth = 2;
    gbc_txtRoomsNumMin.insets = new Insets(0, 0, 5, 5);
    gbc_txtRoomsNumMin.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtRoomsNumMin.gridx = 2;
    gbc_txtRoomsNumMin.gridy = 16;
    contentPane.add(txtRoomsNumMin, gbc_txtRoomsNumMin);
    txtRoomsNumMin.setColumns(10);
    
    JLabel lblRoomsNumMax = new JLabel("Do");
    GridBagConstraints gbc_lblRoomsNumMax = new GridBagConstraints();
    gbc_lblRoomsNumMax.anchor = GridBagConstraints.EAST;
    gbc_lblRoomsNumMax.insets = new Insets(0, 0, 5, 5);
    gbc_lblRoomsNumMax.gridx = 4;
    gbc_lblRoomsNumMax.gridy = 16;
    contentPane.add(lblRoomsNumMax, gbc_lblRoomsNumMax);
    
    txtRoomsNumMax = new JTextField();
    txtRoomsNumMax.setHorizontalAlignment(SwingConstants.RIGHT);
    txtRoomsNumMax.setText("3");
    GridBagConstraints gbc_txtRoomsNumMax = new GridBagConstraints();
    gbc_txtRoomsNumMax.gridwidth = 2;
    gbc_txtRoomsNumMax.insets = new Insets(0, 0, 5, 5);
    gbc_txtRoomsNumMax.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtRoomsNumMax.gridx = 5;
    gbc_txtRoomsNumMax.gridy = 16;
    contentPane.add(txtRoomsNumMax, gbc_txtRoomsNumMax);
    txtRoomsNumMax.setColumns(10);
    
    JLabel lblPowierzchnia = new JLabel("Metraż");
    GridBagConstraints gbc_lblPowierzchnia = new GridBagConstraints();
    gbc_lblPowierzchnia.gridwidth = 6;
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
    
    txtAreaMin = new JTextField();
    txtAreaMin.setHorizontalAlignment(SwingConstants.RIGHT);
    txtAreaMin.setText("30");
    GridBagConstraints gbc_txtAreaMin = new GridBagConstraints();
    gbc_txtAreaMin.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtAreaMin.gridwidth = 2;
    gbc_txtAreaMin.insets = new Insets(0, 0, 5, 5);
    gbc_txtAreaMin.gridx = 2;
    gbc_txtAreaMin.gridy = 18;
    contentPane.add(txtAreaMin, gbc_txtAreaMin);
    txtAreaMin.setColumns(10);
    
    JLabel lblDo_2 = new JLabel("Do");
    GridBagConstraints gbc_lblDo_2 = new GridBagConstraints();
    gbc_lblDo_2.anchor = GridBagConstraints.EAST;
    gbc_lblDo_2.insets = new Insets(0, 0, 5, 5);
    gbc_lblDo_2.gridx = 4;
    gbc_lblDo_2.gridy = 18;
    contentPane.add(lblDo_2, gbc_lblDo_2);
    
    txtAreaMax = new JTextField();
    txtAreaMax.setHorizontalAlignment(SwingConstants.RIGHT);
    txtAreaMax.setText("50");
    GridBagConstraints gbc_txtAreaMax = new GridBagConstraints();
    gbc_txtAreaMax.fill = GridBagConstraints.HORIZONTAL;
    gbc_txtAreaMax.gridwidth = 2;
    gbc_txtAreaMax.insets = new Insets(0, 0, 5, 5);
    gbc_txtAreaMax.gridx = 5;
    gbc_txtAreaMax.gridy = 18;
    contentPane.add(txtAreaMax, gbc_txtAreaMax);
    txtAreaMax.setColumns(10);
    
    JLabel lblOgoszenie = new JLabel("Ogłoszenie");
    GridBagConstraints gbc_lblOgoszenie = new GridBagConstraints();
    gbc_lblOgoszenie.gridwidth = 6;
    gbc_lblOgoszenie.anchor = GridBagConstraints.WEST;
    gbc_lblOgoszenie.insets = new Insets(0, 0, 5, 5);
    gbc_lblOgoszenie.gridx = 1;
    gbc_lblOgoszenie.gridy = 19;
    contentPane.add(lblOgoszenie, gbc_lblOgoszenie);
    
    JRadioButton radioAdOffered = new JRadioButton("Oferowane");
    GridBagConstraints gbc_radioAdSell = new GridBagConstraints();
    gbc_radioAdSell.gridwidth = 3;
    gbc_radioAdSell.insets = new Insets(0, 0, 5, 5);
    gbc_radioAdSell.gridx = 1;
    gbc_radioAdSell.gridy = 20;
    contentPane.add(radioAdOffered, gbc_radioAdSell);
    
    JRadioButton radioAdSearched = new JRadioButton("Poszukiwane");
    GridBagConstraints gbc_radioAdBuy = new GridBagConstraints();
    gbc_radioAdBuy.gridwidth = 3;
    gbc_radioAdBuy.insets = new Insets(0, 0, 5, 5);
    gbc_radioAdBuy.gridx = 4;
    gbc_radioAdBuy.gridy = 20;
    contentPane.add(radioAdSearched, gbc_radioAdBuy);
    
    adGroup = new ButtonGroup();
    adGroup.add(radioAdOffered);
    adGroup.add(radioAdSearched);
    
    JLabel lblOgoszeniodawca = new JLabel("Ogłoszeniodawca");
    GridBagConstraints gbc_lblOgoszeniodawca = new GridBagConstraints();
    gbc_lblOgoszeniodawca.anchor = GridBagConstraints.WEST;
    gbc_lblOgoszeniodawca.gridwidth = 6;
    gbc_lblOgoszeniodawca.insets = new Insets(0, 0, 5, 5);
    gbc_lblOgoszeniodawca.gridx = 1;
    gbc_lblOgoszeniodawca.gridy = 21;
    contentPane.add(lblOgoszeniodawca, gbc_lblOgoszeniodawca);
    
    JRadioButton radioAdvertiserOwner = new JRadioButton("Właściciel");
    GridBagConstraints gbc_radioAdvertiserOwner = new GridBagConstraints();
    gbc_radioAdvertiserOwner.gridwidth = 3;
    gbc_radioAdvertiserOwner.insets = new Insets(0, 0, 5, 5);
    gbc_radioAdvertiserOwner.gridx = 1;
    gbc_radioAdvertiserOwner.gridy = 22;
    contentPane.add(radioAdvertiserOwner, gbc_radioAdvertiserOwner);
    
    JRadioButton radioAdvertiserAgency = new JRadioButton("Agencja");
    GridBagConstraints gbc_radioAdvertiserAgency = new GridBagConstraints();
    gbc_radioAdvertiserAgency.gridwidth = 3;
    gbc_radioAdvertiserAgency.insets = new Insets(0, 0, 5, 5);
    gbc_radioAdvertiserAgency.gridx = 4;
    gbc_radioAdvertiserAgency.gridy = 22;
    contentPane.add(radioAdvertiserAgency, gbc_radioAdvertiserAgency);
    
    advertiserGroup = new ButtonGroup();
    advertiserGroup.add(radioAdvertiserOwner);
    advertiserGroup.add(radioAdvertiserAgency);
    
    JButton searchButton = new JButton("Wyszukaj");
    GridBagConstraints gbc_searchButton = new GridBagConstraints();
    gbc_searchButton.fill = GridBagConstraints.HORIZONTAL;
    gbc_searchButton.anchor = GridBagConstraints.SOUTH;
    gbc_searchButton.gridwidth = 6;
    gbc_searchButton.insets = new Insets(0, 0, 0, 5);
    gbc_searchButton.gridx = 1;
    gbc_searchButton.gridy = 23;
    contentPane.add(searchButton, gbc_searchButton);
    
    searchButton.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        search();
      }
    });
  }  
  
  public void search() {
    Filter filter = new Filter();
    filter.setCity(txtCity.getText());
    filter.setDistrict(txtDistrict.getText());
    filter.setStreet(txtStreet.getText());
    filter.setEstateType(getSelectedButtonText(typeGroup));
    filter.setTransactionType(getSelectedButtonText(transactionGroup));
    filter.setPriceMin(txtPriceMin.getText());
    filter.setPriceMax(txtPriceMax.getText());
    filter.setPricePerMeterMin(txtPricePerMeterMin.getText());
    filter.setPricePerMeterMax(txtPricePerMeterMax.getText());
    filter.setRoomsNumMin(txtRoomsNumMin.getText());
    filter.setRoomsNumMax(txtRoomsNumMax.getText());
    filter.setAreaMin(txtAreaMin.getText());
    filter.setAreaMax(txtAreaMax.getText());
    filter.setAdType(getSelectedButtonText(adGroup));
    filter.setAdvertiser(getSelectedButtonText(advertiserGroup));
  }
  
  public String getSelectedButtonText(ButtonGroup buttonGroup) {
    for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
        AbstractButton button = buttons.nextElement();

        if (button.isSelected()) {
            return button.getText();
        }
    }
    return null;
  }
}
