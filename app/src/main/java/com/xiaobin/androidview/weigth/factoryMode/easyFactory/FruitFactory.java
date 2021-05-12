package com.xiaobin.androidview.weigth.factoryMode.easyFactory;

/**
 * data:2021/3/31
 * Author:renbin
 */
public class FruitFactory {

    public static void main(String[] args) {
        FruitFactory.creatFruit("apple").eat();
        FruitFactory.creatFruit("banana").eat();
        FruitFactory.creatFruit("orange").eat();
    }

    public static Fruit creatFruit(String type){
        Fruit fruit = null;
        switch (type){
            case "apple":
                fruit = new Apple();
                break;
            case "banana":
                fruit = new Banana();
                break;
            case "orange":
                fruit = new Orange();
                break;
        }
        if (fruit!= null){
            return fruit;
        }
        return null;
    }
}
