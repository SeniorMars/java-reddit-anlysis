package src;
//File Name: Comment.java
//Name: Julian Singer
//OSIS: N/A

//Description:
/*
 */
//Known bugs:
/*
 */
//Learned:
/*
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Comment {

//--------------------------------------------------------------------------------------------------------
    private File goodWords = new File("positive-words.txt");
    private ArrayList<String> good = new ArrayList<String>();
    private Scanner gw;

    {
        try {
            gw = new Scanner(goodWords);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    {
        for (int i = 0; gw.hasNext(); i++) {
            String temp = gw.nextLine();
            good.add(temp);
            //System.out.println(good.get(i));
        }
    }

    //--------------------------------------------------------------------------------------------------------

    private File badWords = new File("negative-words.txt");
    private ArrayList<String> bad = new ArrayList<String>();
    private Scanner bw;
    {
        try {
            bw = new Scanner(badWords);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    { for (int i = 0; bw.hasNext(); i++)
    {
        String temp = bw.nextLine();
        bad.add(temp);
        //System.out.println(bad.get(i));
    }
    }

    //--------------------------------------------------------------------------------------------------------


    private String[] words;
    public int value;
    private final int BASE_VALUE = 50;
    private int positive = 2;
    private int negative = -2;

    //--------------------------------------------------------------------------------------------------------


    public Comment(String str){
        value = BASE_VALUE;

        if (str == null) {
            words = null;
            value = 0;
        }

        else {
            words = Sentence.breakDown(str);
            value = valueOfComment();
        }
    }
    private int valueOfComment(){
        //this will parse through the string of words, and compare it to the string[] of good words and the string[] of bad words
        //good words will add value to the base value of 50
        //bad words will detract from it
        for (int i = 0; i < words.length; i++){
            //System.out.println(words[i]);
            if (good.contains(words[i]))
                value = value + positive;
            else if (bad.contains(words[i]))
                value = value + negative; //its + negative bc negative stores a negative number
        }
        return value;
    }
    public static void main(String[] args){
        Comment test = new Comment("Good, I can feel your anger. Strike me down with all your hatred and your jounrey towards the dark side shall be complete");
        //System.out.println(test.valueOfComment());
        System.out.println("Value of test: " + test.value);
        Comment GoodComment = new Comment("good, amicable, yay, happy, cool, awesome");
        //System.out.println(GoodComment.valueOfComment());
        System.out.println("Value of GoodComment: " + GoodComment.value);
        Comment BadComment = new Comment("zaps, zealous, wrong, dead");
        System.out.println("Value of BadComment: " + BadComment.value);
    }
}

//increase value range
//associate different score with adjective that describes it