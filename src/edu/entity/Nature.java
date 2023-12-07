package edu.entity;
import edu.action.Activity;

import java.util.Objects;

public class Nature implements Entity_types{
    final String name;
    public Nature(String name){
        this.name = name;
    }
    private String qualities = "";
    private Activity activity;
    @Override
    public void set_state(String quality){
        qualities += quality;
    }

    @Override
    public void set_activities(Activity acts){
        activity = acts;
    }
    @Override
    public String get_name(){
        if (qualities != null){
            return " " + name + " " + qualities + " ";
        }
        else {
            return " " + name + " ";
        }
    }
    @Override
    public String start_action(){
        try {
            return " " + get_name() + " " + activity.interact() + " ";
        }
        catch (Exception ex){
            return " " + get_name() + " ";
        }
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        Nature nature = (Nature) object;

        return (Objects.equals(this.name, nature.name) && Objects.equals(this.qualities, nature.qualities) && this.activity == nature.activity);
    }

    @Override
    public int hashCode(){
        int result = 0;

        result = name == null? result: result + name.hashCode();
        result = qualities == null? result: result + qualities.hashCode();
        result = activity == null? result: result + activity.hashCode();

        return result;
    }

    @Override
    public String toString(){
        return String.format("{Class: %s, name: %s, quality: %s, activity: %s}",
                this.getClass(), this.get_name(), this.qualities, this.activity.toString());
    }
}
