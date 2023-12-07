package edu.entity;

import edu.action.Activity;

public interface Entity_types {
    void set_state(String state);
    void set_activities(Activity activities);
    String get_name();
    String start_action();
}
