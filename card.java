package com.company;

import javax.xml.bind.Element;

/**
 * Created by ttc on 17-12-28.
 */
public class card {
      private  int value;
      private int color;
      public String toString(){
          String str="";
          String str2="";
          if(color==1)
          {
              str="红桃";
          }
          else if(color==2)
          {
              str="黑桃";
          }
          else if(color==3)
          {
              str="方片";
          }
          else {
              str="草花";
          }
        if(value==1)
        {
            str2="A";
        }
        else if (value==11)
        {
            str2="J";
        }else  if(value==12)
        {
            str2="Q";
        }
        else if(value==13)
        {
            str2="K";
        }
        else{
              str2=""+value;
        }
          return str+str2;
      }
    public void setValue(int value) {
        this.value = value;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public int getColor() {
        return color;
    }
}
