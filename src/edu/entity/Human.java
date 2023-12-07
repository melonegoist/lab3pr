package edu.entity;
import edu.action.Action;
import edu.action.Activity;

import java.util.Objects;

public class Human implements Entity_types{
    final String name;
    private String gender;
    private Activity activity;
    public Human(String name){
         this.name = name;
    }

    @Override
    public void set_state(String state){
        gender = state;
    }

    @Override
    public void set_activities(Activity acts){
        activity = acts;
    }
    @Override
    public String get_name(){
        return " " + name + " " + gender + " ";
    }

    @Override
    public String start_action(){
        String full = activity.interact();

        return " " + get_name() + " " + full + " ";
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;

        Human human = (Human) object;

        return (this.name.equals(human.name) && this.gender.equals(human.gender) && this.activity.equals(human.activity));
    }

    @Override
    public int hashCode(){
        int result = name == null? 0: name.hashCode();
        result = gender == null? result: result + gender.hashCode();

        result = activity == null? result: result + activity.hashCode();

        return result;
    }

    @Override
    public String toString(){
        return String.format("{classname: %s, name: %s, gender: %s, activity: %s}",
                this.getClass(), this.get_name(), this.gender, activity.toString());
    }
}
