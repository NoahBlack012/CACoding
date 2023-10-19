package use_case.clear_users;

// TODO Complete me

import java.util.Set;

public class ClearInteractor implements ClearInputBoundary{
    private final ClearUserDataAccessInterface clearUserDataAccessObject;
    private final ClearOutputBoundary clearPresenter;
    public ClearInteractor(ClearUserDataAccessInterface clearUserDataAccessObject, ClearOutputBoundary clearPresenter) {
        this.clearUserDataAccessObject = clearUserDataAccessObject;
        this.clearPresenter = clearPresenter;
    }
    public void execute(ClearInputData inputData){
        try {
            // Delete all users from the database
            Set<String> deletedUsers = clearUserDataAccessObject.deleteAllUsers();
            clearPresenter.prepareSuccessView(new ClearOutputData(deletedUsers, true));
        } catch (Exception e) {
            // Render fail view if there is an error
            clearPresenter.prepareFailView(e.toString());
        }
    }

}
