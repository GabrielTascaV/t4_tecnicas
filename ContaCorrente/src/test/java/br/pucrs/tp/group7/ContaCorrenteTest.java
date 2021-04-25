package br.pucrs.tp.group7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

public class ContaCorrenteTest{
    private ContaCorrente cc = null;


    @BeforeEach
    void setUp(){ cc = new ContaCorrente("Gabriel",001);}

    @Test
    public void CT1(){ //CT1 (0,SILVER) 
        Boolean dep = cc.deposito(49000.00);
        String cat = cc.getCategoria();
        double saldo = cc.getSaldo();
        Assertions.assertEquals(true,dep);
        Assertions.assertEquals("Silver",cat);
        Assertions.assertEquals(49000.00,saldo);
    }

    @Test
    public void CT2(){//CT2 (49.000,SILVER)
        Boolean dep = cc.deposito(49000.00);
        dep = cc.deposito(1000.00);
        String cat = cc.getCategoria();
        double saldo = cc.getSaldo();
        Assertions.assertEquals(true,dep);
        Assertions.assertEquals("Gold",cat);
        Assertions.assertEquals(50000.00,saldo);
    }

    @Test
    public void CT3(){//CT3 (50.000,GOLD)
        Boolean dep = cc.deposito(50000.00);
        dep = cc.deposito(1000.00);
        String cat = cc.getCategoria();
        double saldo = cc.getSaldo();
        Assertions.assertEquals(true,dep);
        Assertions.assertEquals("Gold",cat);
        Assertions.assertEquals(51010.00,saldo);
    }

    @Test
    public void CT4(){//CT4 (199.000,GOLD)
        Boolean dep = cc.deposito(199000.00);
        String cat = cc.getCategoria();
        double saldo = cc.getSaldo();
        Assertions.assertEquals(true,dep);
        Assertions.assertEquals("Gold",cat);
        Assertions.assertEquals(199000.0,saldo);
    }
    
    @Test
    public void CT5(){//CT5 (200.000,PLATINUM)
        Boolean dep = cc.deposito(199000.00);
        dep = cc.deposito(1000.00);
        dep = cc.deposito(1000.00);
        String cat = cc.getCategoria();
        double saldo = cc.getSaldo();
        Assertions.assertEquals(true,dep);
        Assertions.assertEquals("Platinum",cat);
        Assertions.assertEquals(201035.00,saldo);
    }
    /*
    @Test
    public void CT6(){//CT6 (0-20,SILVER)--- erro proposital
        Boolean dep = cc.deposito(-20.0);
        String cat = cc.getCategoria();
        double saldo = cc.getSaldo();
        Assertions.assertEquals(true,dep);
        Assertions.assertEquals("Silver",cat);
        Assertions.assertEquals(0,saldo);
    }
    */
    
    @Test
    public void CT7(){//CT7 (0+200.000,GOLD)
        Boolean dep = cc.deposito(200000.00);
        String cat = cc.getCategoria();
        double saldo = cc.getSaldo();
        Assertions.assertEquals(true,dep);
        Assertions.assertEquals("Gold",cat);
        Assertions.assertEquals(200000.00,saldo);
    }

    @Test
    public void CT8(){//CT8 (50.000 - 25.000,GOLD)
        Boolean dep = cc.deposito(50000.00);
        dep = cc.retirada(25000.0);
        String cat = cc.getCategoria();
        double saldo = cc.getSaldo();
        Assertions.assertEquals(true,dep);
        Assertions.assertEquals("Gold",cat);
        Assertions.assertEquals(25000.00,saldo);
    }

    @Test
    public void CT9(){//CT9 (50.000 - 26.000,SILVER)
        Boolean dep = cc.deposito(50000.00);
        dep = cc.retirada(26000.00);
        String cat = cc.getCategoria();
        double saldo = cc.getSaldo();
        Assertions.assertEquals(true,dep);
        Assertions.assertEquals("Silver",cat);
        Assertions.assertEquals(24000.00,saldo);
    }

    @Test
    public void CT10(){//CT10 (200.000 - 100.000,PLATINUM)
        Boolean dep = cc.deposito(199000.00);
        dep = cc.deposito(1000.00);
        dep = cc.retirada(100000.00);
        String cat = cc.getCategoria();
        double saldo = cc.getSaldo();
        Assertions.assertEquals(true,dep);
        Assertions.assertEquals(100010.00,saldo);
        Assertions.assertEquals("Platinum",cat);
    }

    @Test
    public void CT11(){//CT11 (200.000 - 101.000,GOLD)
        Boolean dep = cc.deposito(199000.00);
        dep = cc.deposito(1000.00);
        dep = cc.retirada(101000.00);
        String cat = cc.getCategoria();
        double saldo = cc.getSaldo();
        Assertions.assertEquals(true,dep);
        Assertions.assertEquals("Gold",cat);
        Assertions.assertEquals(99010.00,saldo);
    }
    @Test
    public void CT12(){//CT12 (200.000 - 200.000,GOLD)
        Boolean dep = cc.deposito(199000.00);
        dep = cc.deposito(1000.00);
        dep = cc.retirada(200010.00);
        String cat = cc.getCategoria();
        double saldo = cc.getSaldo();
        Assertions.assertEquals(true,dep);
        Assertions.assertEquals("Gold",cat);
        Assertions.assertEquals(0.0,saldo);
    }



}