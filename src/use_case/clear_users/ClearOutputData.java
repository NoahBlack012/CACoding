package use_case.clear_users;

// TODO Complete me

import java.util.Set;

public class ClearOutputData {
    private Set<String> deletedUsers;
    private boolean useCaseFailed;
    public ClearOutputData(Set<String> deletedUsers, boolean useCaseFailed){
        this.deletedUsers = deletedUsers;
        this.useCaseFailed = useCaseFailed;
    }

    public Set<String> getDeletedUsers() { return this.deletedUsers;}
}
