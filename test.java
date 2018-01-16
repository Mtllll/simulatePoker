package com.company;

import java.util.List;

/**
 * Created by ttc on 17-12-28.
 */
public class test {
    public static void main(String[] args) {
        poker a1=new poker();
        a1.output();
        a1.shuffle();
        a1.output();
        List<card> cards=a1.takeCard();
        a1.judeCard(cards);
    }
}
