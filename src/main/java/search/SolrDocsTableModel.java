package search;

import java.util.HashMap;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import org.apache.solr.common.SolrDocumentList;

import common.ads.AdsConstants;

public class SolrDocsTableModel extends AbstractTableModel{
  
  /**
   * 
   */
  private static final long serialVersionUID = -5674418238890628556L;

  private SolrDocumentList data = new SolrDocumentList();
  
  private String[] columnNames = 
    {
//      "Transakcja",
//      "Rodzaj",
      "ID",
      "Miejscowość",
//      "Dzielnica",
//      "Ulica",
      "Cena",
      "Cena/m2",
      "Liczba pokoi",
      "Metraż",
      "Piętro",
      "Portal"
//      "Ogłoszeniodawca"
      };
  
  private String[] fieldNames = 
    {
//      "transactionType",
//      "estateType",
      AdsConstants.ID,
      AdsConstants.CITY,
//      AdsConstants.DISTRICT,
//      AdsConstants.STREET,
      AdsConstants.PRICE,
      AdsConstants.PRICE_PER_METER,
      AdsConstants.NUM_BEDROOMS,
      AdsConstants.AREA,
      AdsConstants.FLOOR,
      AdsConstants.WEBSITE
      };
  
  private Map<String,Integer> mapping = new HashMap<String,Integer>();
  
  private Map<String,Integer> createMapping() {
    Map<String,Integer> map = new HashMap<>();
    for(int i = 0; i<columnNames.length; i++) {
      map.put(columnNames[i], i);
    }
    return map;
  }
  
  public SolrDocsTableModel() {
    data = new SolrDocumentList();
    mapping = createMapping();
  }
  
  public SolrDocsTableModel(SolrDocumentList list) {
    super();
    this.data = list;
  }

  @Override
  public int getRowCount() {
    if(data == null) {
      return 0;
    }
    return data.size();
  }

  @Override
  public int getColumnCount() {
//    if(data.size() == 0) {
//      return 0;
//    }
//    return data.get(0).size();
    return columnNames.length;
  }

  @Override
  public String getColumnName(int columnIndex) {
    return columnNames[columnIndex];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    return columnNames[columnIndex].getClass();
  }

  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return false;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    if(data.size() == 0 ) {
      return null;
    } 
    String value = String.valueOf(data.get(rowIndex).getFieldValue(fieldNames[columnIndex]));
    if(value == null) {
      return "";
    }
    return value;
  }

  /**
   * @return the data
   */
  public SolrDocumentList getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(SolrDocumentList data) {
    this.data = data;
    fireTableDataChanged();
  }

  /**
   * @return the columnNames
   */
  public String[] getColumnNames() {
    return columnNames;
  }

  /**
   * @param columnNames the columnNames to set
   */
  public void setColumnNames(String[] columnNames) {
    this.columnNames = columnNames;
  }

  /**
   * @return the fieldNames
   */
  public String[] getFieldNames() {
    return fieldNames;
  }

  /**
   * @param fieldNames the fieldNames to set
   */
  public void setFieldNames(String[] fieldNames) {
    this.fieldNames = fieldNames;
  }

  /**
   * @return the mapping
   */
  public Map<String,Integer> getMapping() {
    return mapping;
  }

  /**
   * @param mapping the mapping to set
   */
  public void setMapping(Map<String,Integer> mapping) {
    this.mapping = mapping;
  }

}
