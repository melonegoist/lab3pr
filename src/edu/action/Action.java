package edu.action;

import java.util.Objects;

public class Action extends Activity{
    final String name;
    public Action(String name){
        this.name = name;
    }
    @Override
    public String interact(){
        return " " + name + " ";
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        Action activity = (Action) object;

        return (super.dependencies == activity.dependencies && Objects.equals(this.name, activity.name));
    }

    @Override
    public int hashCode(){
        return name == null? 323*13131: name.hashCode();
    }

    @Override
    public String toString(){
        String deps = "";

        if (dependencies != null){
            for (String el: dependencies){
                if (el != null){
                    deps += el;
                }
            }
        }
        return String.format("{classname: %s, name: %s, dependencies: %s}",
                this.getClass(), this.name, deps);
    }
}
