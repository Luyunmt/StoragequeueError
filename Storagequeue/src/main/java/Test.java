import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import com.azure.storage.common.credentials.SASTokenCredential;
import com.azure.storage.queue.QueueServiceClient;
import com.azure.storage.queue.QueueServiceClientBuilder;
import com.azure.storage.queue.models.StorageServiceStats;

public class Test {
    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException {
        SASTokenCredential SASToken = SASTokenCredential.fromSASTokenString(
                "Your SASTOKEN");
        String accountName = "Account Name";
        String queueServiceURL = String.format("https://%s.queue.core.windows.net", accountName);
        QueueServiceClient queueServiceClient = new QueueServiceClientBuilder()
            .endpoint(queueServiceURL)
            .credential(SASToken).buildClient();      
        StorageServiceStats queueStats = queueServiceClient.getStatistics();
     
    }
}