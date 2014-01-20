package solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import common.CommonConstants;

public class SolrModule {

  private HttpSolrServer solr = null;
  
  public SolrModule() {
    if(solr == null) {
      solr = new HttpSolrServer(CommonConstants.SOLR_BASE_URL);
    }
  }
}
