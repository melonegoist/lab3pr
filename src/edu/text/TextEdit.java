package edu.text;

public class TextEdit implements TextFunc {
    public static boolean is_closed = true;
    String new_text;
    public String add_text(String text, String new_words){
        if (!is_closed){
            this.new_text = text + new_words;
            return new_text;
        }
        System.out.println("text is closed, we can't change it");
        return text;
    }
    @Override
    public int count_letters(String text){
        int counter = 0;
        int counter_new = 0;

        for (char el: text.toCharArray()){
            counter ++;
        }

        for (char el: new_text.toCharArray()){
            counter_new ++;
        }

        return counter_new - counter;
    }

    @Override
    public int count_words(String text){
        return new_text.split(" ").length - text.split(" ").length;
    }
}
