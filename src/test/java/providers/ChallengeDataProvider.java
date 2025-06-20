package providers;

import org.demo.models.Challenge;
import org.demo.utils.CredentialLoader;
import org.testng.annotations.DataProvider;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class ChallengeDataProvider {

    @DataProvider(name = "challengeData")
    public Object[][] provideChallengeProvider() {

        String timeStr = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String title = "Challenge Testing _ " + timeStr;

        //Below is can be replaced by csv file or database
        Challenge challenge = new Challenge(title, "CTFlearn{Testing}", "Challenge descriptions should be in English unless another language is specifically required to create a challenge.", "", "Binary", 40, "Challenge descriptions should be in English unless another language is specifically required to create a challenge.");
        challenge.setCreatedBy(CredentialLoader.getCredential("username"));
        String[] categories = new String[] {"Web", "Binary", "Forensics", "Reverse Engineering", "Cryptography", "Miscellaneous"};
        int[] points = new int[] {10, 20, 30, 40, 50, 60, 80, 90, 100};

        int categoryRandomIndex = ThreadLocalRandom.current().nextInt(categories.length);
        challenge.setCategory(categories[categoryRandomIndex]);

        int pointRandomIndex = ThreadLocalRandom.current().nextInt(points.length);
        challenge.setPoint(points[pointRandomIndex]);

        return new Object[][] {
            {challenge}
        };
    }
}
