import java.util.ArrayList;

public abstract interface ClaimProcessManager {


        // Add a new claim to the system
        void add();


        // Update an existing claim in the system
        void update(Claim claim);

        // Delete a claim from the system
        void delete(String claimId);

        // Retrieve a specific claim from the system based on its ID
        Claim getOne(String claimId);

        // Retrieve all claims from the system
        ArrayList<Claim> getAll();
    }

