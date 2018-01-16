package com.company;

import sun.awt.geom.AreaOp;

import java.util.*;

/**
 * Created by ttc on 17-12-28.
 */
public class poker {
    List<card> cards = new ArrayList<>();
    int colors[] = {1, 2, 3, 4};
    int values[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13};


    poker() {
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < values.length; j++) {
                card a = new card();
                a.setColor(colors[i]);
                a.setValue(values[j]);
                cards.add(a);
            }
        }
    }


//随机抽取五张牌
    public List<card> takeCard() {
        List<card> takeCard = new ArrayList<>();
        int index = 0;
        for (card card1 : cards) {
            takeCard.add(card1);
            index++;
            if (index == 5) {
                break;
            }
        }
        return takeCard;
    }

//输出
    public void output() {
        for (card a : cards) {
            System.out.print(a);
        }
        System.out.println();
    }

//洗牌
    void shuffle() {
        Collections.shuffle(cards);
    }

//判断牌型
    public void judeCard(List<card> cards) {
        boolean isSameColor=false;
        boolean isshuizi=false;
        Set<Integer> colorvalues = new HashSet<>();
        for (card card : cards) {
            colorvalues.add(card.getColor());
        }
        if (colorvalues.size() == 5) {
//            System.out.println("同花");
            isSameColor=true;
        }

        List<Integer> values = new ArrayList<>();
        Set<Integer> setVailes = new HashSet<>();
        for (card card : cards) {
            values.add(card.getValue());
            setVailes.add(card.getValue());
        }
        Collections.sort(values);
        if (values.get(4) - values.get(0) == 4 && setVailes.size() == 5) {
//            System.out.println("顺子");
            isshuizi=true;
        }
        if(isSameColor&&isshuizi)
        {
            System.out.println("同花顺");
        }
        else if (isSameColor)
        {
            System.out.println("同花");
        }
        else if(isshuizi)
        {
            System.out.println("顺子");
        }
        else if(setVailes.size()==5)
        {
            System.out.println("杂牌");
        }
        else if(setVailes.size()==4)
        {
            System.out.println("一对");
        }
        else if(setVailes.size()==2)
        {
//            (9,4)(5,1)
//            (3,3)(6,2)
            boolean foo=false;
            Map<Integer,Integer>values2count=new HashMap<>();
            for(card c:cards)
            {
                if(values2count.containsKey(c.getValue()))
                {
                    int num=values2count.get(c.getValue());
                    num++;
                    values2count.put(c.getValue(),num);
                }
                else{
                    values2count.put(c.getValue(),1);
                }
            }
            for(Integer a:values2count.keySet())
            {
                if(values2count.get(a)==1)
                {
                    foo=true;
                    System.out.println("四带一");
                }

            }
            if(!foo)
            {
                System.out.println("三带二");
            }
        }
        else if(setVailes.size()==3)
        {
            boolean foo=false;
//            三条或者两对
//            （9,2）（10,2）（4,1）
//              （9,3）（4,1）（6,1）
            Map<Integer,Integer>values2count=new HashMap<>();
            for(card a:cards)
            {
                if(values2count.containsKey(a.getValue()))
                {
                    int count=values2count.get(a.getValue());
                    count++;
//
                    values2count.put(a.getValue(),count);
                }
                else{
                    values2count.put(a.getValue(),1);
                }
            }
            for(Integer a:values2count.keySet())
            {

                if(values2count.get(a)==2);
                {
                    foo=true;
                    System.out.println("两对");
                }
            }
            if(!foo)
            {
                System.out.println("三条");
            }
        }
    }
}
