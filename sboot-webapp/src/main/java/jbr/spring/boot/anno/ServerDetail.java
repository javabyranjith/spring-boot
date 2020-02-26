package jbr.spring.boot.anno;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("env")
public class ServerDetail {

  private String server;
  private String name;
  private String port;

  public String getServer() {
    return server;
  }

  public void setServer(String server) {
    this.server = server;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  @Override
  public String toString() {
    return "Server: " + this.server + " | Name: " + this.name + " | Port: " + this.port;
  }
}
