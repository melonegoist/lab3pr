package edu.text;

public class TextRemover implements TextFunc {
    public static int words_to_remove;
    String new_text;
    public String start(String text){
        int pointer = 0;
        while (words_to_remove != 0) {
            text = text.replace(text.charAt(pointer), ' ');
            pointer++;
            words_to_remove--;
        }
        this.new_text = text;

        return text;
    }
    @Override
    public int count_letters(String obj){
        int counter = 0;
        for (char el: new_text.toCharArray()){
            counter ++;
        }

        return counter;
    }

    @Override
    public int count_words(String text){
        return text.split(" ").length;
    }
}
