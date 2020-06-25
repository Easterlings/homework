package test;

import org.junit.Before;
import org.junit.Test;
import poker.poker;
import poker.point;

import static org.junit.Assert.*;

public class pokerTest {
    @Test
    public void test1(){
        point black = new point("2H 3D 5S 9C KD"  );
        point white = new point("2C 3H 4S 8C AH"  );
        poker p = new poker(black,white);
        p.compare();
    }

    @Test
    public void test2(){
        point black = new point("2H 4S 4C 2D 4H"  );
        point white = new point("2S 8S AS QS 3S"  );
        poker p = new poker(black,white);
        p.compare();
    }

    @Test
    public void test3(){
        point black = new point("2H 3H 5H 9H KH"  );
        point white = new point("2C 3H 4S 5C 6H"  );
        poker p = new poker(black,white);
        p.compare();
    }

    @Test
    public void test4(){
        point black = new point("2H 3D 5S 9C KD"  );
        point white = new point("2D 3H 5C 9S KH"  );
        poker p = new poker(black,white);
        p.compare();
    }

    @Test
    public void test5(){
        point black = new point("1D 2H 3S 4H 5C"  );
        point white = new point("3C 4C 5C 6C 7C"  );
        poker p = new poker(black,white);
        p.compare();
    }

    @Test
    public void test6(){
        point black = new point("JH 6H 3H QH 5H"  );
        point white = new point("3C 4C 5C 6C 7C"  );
        poker p = new poker(black,white);
        p.compare();
    }

    @Test
    public void test7(){
        point black = new point("1H 2D 3H 4C 5H"  );
        point white = new point("3C 4C 5C 4D 4H"  );
        poker p = new poker(black,white);
        p.compare();
    }

    @Test
    public void test8(){
        point black = new point("1H 2H 3H 4H 5H"  );
        point white = new point("3C 4C 5C 6C 7C"  );
        poker p = new poker(black,white);
        p.compare();
    }

}