package org.codingdojo;

import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Yatzy1Test {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = Yatzy1.chance(2,3,4,5,1);
        assertEquals(expected, actual);
        assertEquals(16, Yatzy1.chance(3,3,4,5,1));
    }

    @Test public void yatzyTest() {
        int expected = 50;

        assertEquals(expected, Yatzy1.yatzy(6,6,6,6,6));
        assertEquals(expected, Yatzy1.yatzy(3,3,3,3,3));
        assertEquals(0, Yatzy1.yatzy(6,6,6,6,2));
        assertEquals(0, Yatzy1.yatzy(6,6,6,6,3));
    }

    @Test public void onesTest() {
        assertTrue(Yatzy1.ones(1,2,3,4,5) == 1);
        assertEquals(2, Yatzy1.ones(1,2,1,4,5));
        assertEquals(0, Yatzy1.ones(6,2,2,4,5));
        assertEquals(4, Yatzy1.ones(1,2,1,1,1));
    }

    @Test
    public void twosTest() {
        assertEquals(4, Yatzy1.twos(1,2,3,2,6));
        assertEquals(10, Yatzy1.twos(2,2,2,2,2));
    }

    @Test
    public void threesTest() {
        assertEquals(6, Yatzy1.threes(1,2,3,2,3));
        assertEquals(12, Yatzy1.threes(2,3,3,3,3));
    }

    @Test
    public void foursTest()
    {
        assertEquals(12, new Yatzy1(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy1(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy1(4,5,5,5,5).fours());
    }

    @Test
    public void fives() {
        assertEquals(10, new Yatzy1(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy1(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy1(4,5,5,5,5).fives());
    }

    @Test
    public void sixesTest() {
        assertEquals(0, new Yatzy1(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy1(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy1(6,5,6,6,5).sixes());
    }

    @Test
    public void onePairTest() {
        assertEquals(6, new Yatzy1().scorePair(3,4,3,5,6));
        assertEquals(10, new Yatzy1().scorePair(5,3,3,3,5));
        assertEquals(12, new Yatzy1().scorePair(5,3,6,6,5));
    }

    @Test
    public void twoPairTest() {
        assertEquals(16, Yatzy1.twoPair(3,3,5,4,5));
        assertEquals(16, Yatzy1.twoPair(3,3,5,5,5));
        assertEquals(6, Yatzy1.twoPair(2,2,1,1,5));
        assertEquals(12, Yatzy1.twoPair(2,2,4,1,4));
    }

    @Test
    public void threeOfAKindTest()
    {
        assertEquals(9, Yatzy1.threeOfAKind(3,3,3,4,5));
        assertEquals(15, Yatzy1.threeOfAKind(5,3,5,4,5));
        assertEquals(9, Yatzy1.threeOfAKind(3,3,3,3,5));
    }

    @Test
    public void fourOfAKndTest() {
        assertEquals(12, Yatzy1.fourOfAKind(3,3,3,3,5));
        assertEquals(20, Yatzy1.fourOfAKind(5,5,5,4,5));
        assertEquals(8, Yatzy1.fourOfAKind(1,2,2,2,2));
        assertEquals(4, Yatzy1.fourOfAKind(1,1,1,1,5));

    }

    @Test
    public void smallStraightTest() {
        assertEquals(15, Yatzy1.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy1.smallStraight(2,3,4,5,1));
        assertEquals(15, Yatzy1.smallStraight(5,3,4,2,1));
        assertEquals(0, Yatzy1.smallStraight(1,2,2,4,5));
        assertEquals(0, Yatzy1.smallStraight(1,2,1,4,5));
        assertEquals(0, Yatzy1.smallStraight(1,2,3,4,3));
    }



    @Test
    public void largeStraightTest() {
        assertEquals(20, Yatzy1.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy1.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy1.largeStraight(1,2,2,4,5));
    }

    @Test
    public void fullHouseTest() {
        assertEquals(18, Yatzy1.fullHouse(6,2,2,2,6));
        assertEquals(18, Yatzy1.fullHouse(5,3,3,3,5));
        assertEquals(18, Yatzy1.fullHouse(4,1,1,1,4));
        assertEquals(18, Yatzy1.fullHouse(3,3,1,1,1));
        assertEquals(0, Yatzy1.fullHouse(2,3,4,5,6));
        assertEquals(0, Yatzy1.fullHouse(2,3,4,1,6));
        assertEquals(0, Yatzy1.fullHouse(2,3,4,5,5));
        assertEquals(0, Yatzy1.fullHouse(3,3,3,5,6));
    }
}
