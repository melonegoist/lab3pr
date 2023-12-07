package edu.action;

import java.util.Objects;

public class FullAction extends Activity{
    final String name;
    public FullAction(String name){
        this.name = name;
    }
    @Override
    public String interact(){
        String full_string = "";

        for (String dep: super.dependencies){
            full_string += " " + dep + " ";
        }

        return full_string + " " + name;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;
        FullAction activity = (FullAction) object;

        return (super.dependencies == activity.dependencies && Objects.equals(this.name, activity.name));
    }

    @Override
    public int hashCode(){
        return name == null? 23*17: name.hashCode();
    }

    @Override
    public String toString(){
        String deps = "";
        String[] to_deps = super.dependencies;

        if (to_deps != null){
            for (String el: to_deps){
                if (el != null){
                    deps += el;
                }
            }
        }
        return String.format("{classname: %s, name: %s, dependencies: %s}",
                this.getClass(), this.name, deps);
    }
}
