package eleme.openapi.demo;

import com.sun.net.httpserver.*;

import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;

public class EleHttpsServer {

    public static com.sun.net.httpserver.HttpsServer createHttpsServer(int port) {
        try {
            // setup the socket address
            InetSocketAddress address = new InetSocketAddress(port);
            // initialise the HTTPS server
            com.sun.net.httpserver.HttpsServer server = com.sun.net.httpserver.HttpsServer.create(address, 0);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            // initialise the keystor
            char[] password = "123456".toCharArray();
            KeyStore ks = KeyStore.getInstance("JKS");
            String keystoreFilename = Thread.currentThread().getContextClassLoader().getResource("testkey.jks").getFile();
            FileInputStream fis = new FileInputStream(keystoreFilename);
            ks.load(fis, password);
            // setup the key manager factory
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, password);
            // setup the trust manager factory
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ks);
            // setup the HTTPS context and parameters
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
            server.setHttpsConfigurator(new HttpsConfigurator(sslContext) {
                public void configure(HttpsParameters params) {
                    try {
                        // initialise the SSL context
                        SSLContext c = SSLContext.getDefault();
                        SSLEngine engine = c.createSSLEngine();
                        params.setNeedClientAuth(false);
                        params.setCipherSuites(engine.getEnabledCipherSuites());
                        params.setProtocols(engine.getEnabledProtocols());
                        // get the default parameters
                        SSLParameters defaultSSLParameters = c.getDefaultSSLParameters();
                        params.setSSLParameters(defaultSSLParameters);

                    } catch (Exception ex) {
                        System.out.println("Failed to create HTTPS port");
                    }
                }
            });
            System.out.println("server start at: " + address.getAddress() + ":" + address.getPort());
            return server;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Deprecated
    public static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "This is the response";
            t.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
