package common;

import common.ads.Filter;

public class RequestMessage {
  private String SolrUrl;
  private Filter filter;
  
  public RequestMessage() {
    
  }
  
  public RequestMessage(String url, Filter filter) {
    this.SolrUrl = url;
    this.filter = filter;
  }

  /**
   * @return the solrUrl
   */
  public String getSolrUrl() {
    return SolrUrl;
  }

  /**
   * @param solrUrl the solrUrl to set
   */
  public void setSolrUrl(String solrUrl) {
    SolrUrl = solrUrl;
  }

  /**
   * @return the filter
   */
  public Filter getFilter() {
    return filter;
  }

  /**
   * @param filter the filter to set
   */
  public void setFilter(Filter filter) {
    this.filter = filter;
  }
  
  
}
