import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;


public class CertificateTest {

    //this method checks the name of the organization from the certificate

    public boolean check(String url, String companyName) throws Exception{
        URL destinationURL = new URL(url);
        HttpsURLConnection connection = (HttpsURLConnection) destinationURL.openConnection();
        connection.connect();
        java.security.cert.Certificate[] certs = connection.getServerCertificates();

        for (java.security.cert.Certificate cert : certs) {
            if (cert instanceof X509Certificate) {
                X509Certificate x = (X509Certificate) cert;
                String[] CertElements = x.getSubjectDN().getName().split(",");

                for (String a : CertElements) {
                    if  (a.contains("O=" + companyName)){
                        return true;
                    }
                }
            }
            break;
        }
        return false;
    }


}


