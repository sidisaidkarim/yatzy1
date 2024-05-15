package org.codingdojo.yatzy1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Yatzy1 {


    private int[] dice;


    public Yatzy1() {
        dice = new int[5];
    }
    public Yatzy1(int d1, int d2, int d3, int d4, int d5)
    {
        this();
        dice = new int[]{d1, d2, d3, d4, d5};
    }

    public static int chance(int d1, int d2, int d3, int d4, int d5)
    {
        return d1 + d2 + d3 + d4 + d5;
    }

    public static int yatzy(int... dice)
    {
        Set<Integer> diceSet = new HashSet();
        for (int die : dice) {
            diceSet.add(die);
        }

        if(diceSet.size() == 1) return 50;
        return 0;
    }


    private static int someOFSpecificDice(int[] dices, int val){
        int sum = 0;
        for (int dice: dices){
            if(dice == val) sum += val;
        }
        return sum;
    }

    private static Map<Integer, Integer> getDiceValuesMap(int d1, int d2, int d3, int d4, int d5) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(d1, counts.getOrDefault(d1, 0) + 1);
        counts.put(d2, counts.getOrDefault(d2, 0) + 1);
        counts.put(d3, counts.getOrDefault(d3, 0) + 1);
        counts.put(d4, counts.getOrDefault(d4, 0) + 1);
        counts.put(d5, counts.getOrDefault(d5, 0) + 1);
        return counts;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        int[] dices = {d1,d2,d3,d4,d5} ;
        return someOFSpecificDice(dices,1);
    }



    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        int[] dices = {d1,d2,d3,d4,d5} ;
        return someOFSpecificDice(dices,2);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int[] dices = {d1,d2,d3,d4,d5} ;
        return someOFSpecificDice(dices,3);
    }



    public int fours()
    {
        return someOFSpecificDice(dice,4);
    }

    public int fives()
    {
        return someOFSpecificDice(dice,5);
    }

    public int sixes()
    {
        return someOFSpecificDice(dice,6);
    }

    public int scorePair(int d1, int d2, int d3, int d4, int d5)
    {

        Map<Integer, Integer> counts = getDiceValuesMap(d1, d2, d3, d4, d5);

        int maxPairValue = 0;
        for (int value : counts.keySet()) {
            if (counts.get(value) >= 2) {
                maxPairValue = Math.max(maxPairValue, value);
            }
        }

        return maxPairValue * 2;

    }

    public static int twoPair(int d1, int d2, int d3, int d4, int d5)
    {
        Map<Integer, Integer> counts = getDiceValuesMap(d1, d2, d3, d4, d5);
        int score = 0;
        int pairsFound = 0;
        for (Map.Entry<Integer,Integer> entry : counts.entrySet()) {
            if (entry.getValue() >= 2) {
                score += entry.getKey() * 2;
                pairsFound++;
            }
        }

        return (pairsFound == 2) ? score : 0;

    }

    public static int fourOfAKind(int d1, int d2, int d3, int d4, int d5)
    {
        Map<Integer, Integer> counts = getDiceValuesMap(d1, d2, d3, d4, d5);
        int score = 0;

        for (Map.Entry<Integer,Integer> entry : counts.entrySet()) {
            if (entry.getValue() >= 4) {
                score = entry.getKey() * 4;
            }
        }

        return score;
    }



    public static int threeOfAKind(int d1, int d2, int d3, int d4, int d5)
    {
        Map<Integer, Integer> counts = getDiceValuesMap(d1, d2, d3, d4, d5);
        int score = 0;

        for (Map.Entry<Integer,Integer> entry : counts.entrySet()) {
            if (entry.getValue() >= 3) {
                score = entry.getKey() * 3;
            }
        }
        return score;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        Set<Integer> diceSet = new HashSet();
        diceSet.add(d1);
        diceSet.add(d2);
        diceSet.add(d3);
        diceSet.add(d4);
        diceSet.add(d5);

        return diceSet.size() == 2 ? 18:0;
    }


    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        return d1 + d2 + d3 + d4 +d5 == 15 ? 15:0;
    }



    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        return d1 + d2 + d3 + d4 +d5 == 20 ? 20:0;
    }


}



