package edu;

import edu.action.Action;
import edu.action.FullAction;
import edu.entity.*;
import edu.text.TextRemover;

import java.util.Scanner;

import static edu.entity.Entity.HUMAN;

public class Main {
    public static void main(String[] args) {
        // main_character init
        Entity entity;
        Entity_types main_character;

        Scanner scan = new Scanner(System.in);
        String scanned_character = scan.next();

        // release main_character enum_type
        switch (scanned_character) {
            case "Human" -> entity = Entity.HUMAN;
            case "Nature" -> entity = Entity.NATURE;
            default -> entity = HUMAN;
        }

        // release name depends on enum_type
        switch (entity) {
            case NATURE -> main_character = new Nature("РААААДУГА");
            default -> main_character = new Human("Freken Snork");
        }

        // first_line
        String first_line = null;
        if (main_character.getClass().equals(Human.class)) {
            main_character.set_state("(female)");

        } else {
            main_character.set_state("цветная");
        }

        FullAction woken = new FullAction("проснулась");
        woken.set_dependencies(new String[]{"от холода"});

        FullAction whistle = new FullAction("свистят");
        whistle.set_dependencies(new String[]{"Когда", "в театре"});

        main_character.set_activities(woken);

        first_line = whistle.interact() + main_character.start_action();


        // third_line

        Nature fog = new Nature("туман");

        FullAction act2 = new FullAction("клубился");
        act2.set_dependencies(new String[]{"Между деревьями"});
        fog.set_activities(act2);

        String third_line = fog.start_action();


        // second_line
        Nature hair = new Nature("чёлка");
        hair.set_state("её");

        FullAction wet = new FullAction("была");
        wet.set_dependencies(new String[]{"совершенно", "мокрая"});

        hair.set_activities(wet);

        String second_line = hair.start_action();

        // fourth_line
        Nature pelena = new Nature("в пелене");
        pelena.set_state("его серой густой");

        FullAction see = new FullAction("нельзя было разглядеть");
        see.set_dependencies(new String[]{"уже ничего", "и чуть подальше"});
        pelena.set_activities(see);

        String fourth_line = pelena.start_action();


        // fifth_line
        Nature plants = new Nature("мхи и лишайники");
        Nature trees = new Nature("на стволах деревьев");
        Nature night = new Nature("за ночь");
        trees.set_state("влажных, черных, как уголь");
        FullAction appear = new FullAction("выделялись");
        plants.set_state("облепившие их");
        plants.set_state("ставшие" + night.get_name() + "совершенно белыми");

        appear.set_dependencies(new String[]{"узорчатым рисунком"});

        plants.set_activities(appear);

        String fifth_line = trees.start_action() + plants.start_action();


        // text_init
        String text = first_line + "\n" + second_line + "\n" + third_line + "\n" + fourth_line + "\n" + fifth_line;

        System.out.println(text);

        //tests for equals, hashCode, toString
        Action action_for_test = new Action("grow");

        Nature test1 = new Nature("rose");
        test1.set_state("beautiful");
        test1.set_activities(action_for_test);

        Nature test2 = new Nature("rose");
        test2.set_state("beautiful");
        test2.set_activities(action_for_test);

        Nature test3 = new Nature("daisy");
        test3.set_state("beautiful");
        test3.set_activities(action_for_test);

        System.out.println("equals for tes1 and test2: " + test1.equals(test2));
        System.out.println("equals for test2 and test3: " + test2.equals(test3));

        System.out.println("equals for test1 and itself: " + test1.equals(test1));

        FullAction action_for_humans = new FullAction("walk");

        Human test4 = new Human("person1");
        test4.set_state("male");
        test4.set_activities(action_for_humans);

        Human test5 = new Human("person1");
        test5.set_state("male");
        test5.set_activities(action_for_humans);

        Human test6 = new Human("person2");
        test6.set_state("female");
        test6.set_activities(action_for_humans);

        System.out.println("equals for test4 and test5: " + test4.equals(test5));
        System.out.println("equals for test4 and test6: " + test4.equals(test6));
        System.out.println("equals for test6 abd itself: " + test6.equals(test6));

        System.out.println("hashCode for test4 and test5: " + test4.hashCode() + " " + test5.hashCode());

        System.out.println(test1.toString());

        Human test10 = new Human("just a person");
        FullAction just_a_person_activity = new FullAction("smth");

        System.out.println(test4.toString());

        FullAction test_for_toString = new FullAction("some action");
        String[] some_deps = new String[]{"first, second"};
        test_for_toString.set_dependencies(some_deps);

        System.out.println(test_for_toString.toString());

        TextRemover remover = new TextRemover();

        TextRemover.words_to_remove = 10;

        System.out.println(remover.start(text));
    }

//    public int sum(Integer... args){}
}
