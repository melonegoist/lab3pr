package edu.action;


public abstract class Activity {
    protected String[] dependencies;

    public abstract String interact();

    public void set_dependencies(String[] dependencies){
        this.dependencies = dependencies;
    }

    @Override
    public int hashCode(){
        int result = 0;

        if (dependencies != null){
            for (String el: dependencies){
                result = el == null ? result: result + el.hashCode();
            }
        }

        return result;
    }

    @Override
    public String toString(){
        String result = "";

        if (dependencies != null){
            for (String el: dependencies){
                if (el != null){
                    result += el;
                }
            }
        }

        return result;
    }
}
