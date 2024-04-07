import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author <Dong Dang Khoa- s3986281>
 */

public abstract interface ClaimProcessManager {


        // Add a new claim to the system
        void add();


        // Update an existing claim in the system
        void update();

        // Delete a claim from the system
        void delete();

        // Retrieve a specific claim from the system based on its ID
        void getOne();

        // Retrieve all claims from the system
        HashMap<String, Claim> getAll();
    }

