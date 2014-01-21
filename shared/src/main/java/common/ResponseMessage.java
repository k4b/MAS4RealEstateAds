package common;

public class ResponseMessage {
  
  private String response;
  
  public ResponseMessage() {
    
  }
  
  public ResponseMessage(String response) {
    this.response = response;
  }

  /**
   * @return the response
   */
  public String getResponse() {
    return response;
  }

  /**
   * @param response the response to set
   */
  public void setResponse(String response) {
    this.response = response;
  }
}
