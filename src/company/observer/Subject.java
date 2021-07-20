package company.observer;

import company.employee.User;

public interface Subject {
    void addObserver(User user);
    void removeObserver(User user);
    void notifyAllObservers();
}
