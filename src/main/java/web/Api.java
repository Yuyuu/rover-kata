package web;

import net.codestory.http.Configuration;
import net.codestory.http.WebServer;
import net.codestory.http.payload.Payload;

public class Api {

  public Api() {
    webServer = new WebServer().configure(routes());
  }

  public void start(int port) throws Exception {
    webServer.start(port);
  }

  private Configuration routes() {
    return routes -> routes
        .get("/", Payload.ok());
  }

  private final WebServer webServer;
}
