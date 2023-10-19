package interface_adapter.clear_users;

import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInputData;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

// TODO Complete me
public class ClearController {
    final ClearInputBoundary clearUseCaseInteractor;
    public ClearController(ClearInputBoundary clearUseCaseInteractor) {
        this.clearUseCaseInteractor = clearUseCaseInteractor;
    }

    public void execute() {
        ClearInputData clearInputData = new ClearInputData();

        clearUseCaseInteractor.execute(clearInputData);
    }
}
