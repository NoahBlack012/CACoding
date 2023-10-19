package interface_adapter.clear_users;

// TODO Complete me

import interface_adapter.ViewManagerModel;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;

import java.util.Set;

public class ClearPresenter implements ClearOutputBoundary {
    private final ClearViewModel clearViewModel;
    private ViewManagerModel viewManagerModel;

    public ClearPresenter(ViewManagerModel viewManagerModel,
                          ClearViewModel clearViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.clearViewModel = clearViewModel;
    }

    @Override
    public void prepareSuccessView(ClearOutputData response) {
        // On success, switch to the logged in view.
        ClearState clearState = clearViewModel.getState();
        Set<String> deletedUsersSet = response.getDeletedUsers();
        String deletedUsers = "Cleared users:\n";
        for (String i: deletedUsersSet){
            deletedUsers += i + "\n";
        }
        clearState.setDeletedUsers(deletedUsers);
        clearViewModel.setState(clearState);

        this.viewManagerModel.setActiveView(clearViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

        this.clearViewModel.setState(clearState);
        this.clearViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ClearState clearState = clearViewModel.getState();
        clearState.setDeleteUsersError("Sorry, we could not delete the requested users");
        clearViewModel.setState(clearState);
        this.viewManagerModel.setActiveView(clearViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

        this.clearViewModel.setState(clearState);
        this.clearViewModel.firePropertyChanged();
    }
}
