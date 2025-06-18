package providers;

import org.demo.models.Challenge;
import org.demo.utils.CredentialLoader;
import org.testng.annotations.DataProvider;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChallengeDataProvider {

    @DataProvider(name = "challengeData")
    public Object[][] provideChallengeProvider() {

        String timeStr = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String title = "Challenge Testing _ " + timeStr;

        Challenge challenge = new Challenge(title, "CTFlearn{Testing}", "Challenge descriptions should be in English unless another language is specifically required to create a challenge.", "", "Binary", 40, "Challenge descriptions should be in English unless another language is specifically required to create a challenge.");
        challenge.setCreatedBy(CredentialLoader.getCredential("username"));
        return new Object[][] {
            {challenge}
        };
    }
}
