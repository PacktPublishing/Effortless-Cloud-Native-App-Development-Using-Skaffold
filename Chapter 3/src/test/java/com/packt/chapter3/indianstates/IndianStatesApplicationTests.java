package com.packt.chapter3.indianstates;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IndianStatesApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testRecordAccessors() {
        String name = "Maharashtra";
        String capital = "Mumbai";
        State state = new State("Maharashtra", "Mumbai");
        Assert.assertEquals(name, state.name());
        Assert.assertEquals(capital, state.capital());
    }

    @Test
    public void testRecordToString() {
        State state = new State("Maharashtra", "Mumbai");
        System.out.println(state);
        //Output:-State[name=Maharashtra, capital=Mumbai]
    }

    @Test
    public void testRecordEquals() {
        State state1 = new State("Maharashtra", "Mumbai");
        State state2 = new State("Maharashtra", "Mumbai");
        Assert.assertTrue(state1.equals(state2));
    }

    @Test
    public void testRecordHashCode() {
        State state1 = new State("Maharashtra", "Mumbai");
        State state2 = new State("Maharashtra", "Mumbai");
        Assert.assertEquals(state1.hashCode(), state2.hashCode());
    }

}
