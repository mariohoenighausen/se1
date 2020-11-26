package org.hbrs.se.ws20.uebung2;

import org.hbrs.se.ws20.uebung3.persistence.PersistenceException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    Container c;
    private PrintStream out;
    private ByteArrayOutputStream outputStreamCaptor;
    @BeforeEach
    void setUp() {
        c = Container.getInstance(); //new Container();
        try{
            c.addMember(new Factory(0));
            c.addMember(new Factory(1));
            c.addMember(new Factory(2));
        } catch(Exception ex){
            ex.printStackTrace();
        }
        out = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    void tearDown() {
        c = null;
        System.setOut(out);
    }
    @DisplayName("addMemberTest")
    @Test
    void addMember() {
        assertThrows(ContainerException.class, ()-> c.addMember(new Factory(1)));
        try{
            c.addMember(new Factory(3));
            c.addMember(new Factory(4));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        assertEquals("Member (ID = 3)",c.deleteMember(3));
        assertEquals("Member (ID = 4)",c.deleteMember(4));

        // Einfügen in einen leeren Container wird getest
        /*c = null;
        c = Container.getInstance();
        try{
            c.addMember(new Factory(1));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        assertEquals("Member (ID = 1)",c.deleteMember(1));*/
    }
    @DisplayName("deleteMemberTest")
    @Test
    void deleteMember() {
        assertEquals("Member (ID = 0)",c.deleteMember(0));
        assertEquals("Member (ID = 1)",c.deleteMember(1));
        assertEquals("-1",c.deleteMember(3));
        /*c = null;
        c = Container.getInstance();
        assertEquals("-1",c.deleteMember(1));*/
    }
    /*@DisplayName("dumpTest")
    @Test
    void dump() {
        c.dump();
        assertEquals("Member (ID = 0)\nMember (ID = 1)\nMember (ID = 2)", outputStreamCaptor.toString()
                .trim());
    }*/
    @DisplayName("sizeTest")
    @Test
    void size() {
        assertEquals(3,c.size());
        for(int idx = 0; idx < 3; idx++){
            c.deleteMember(idx);
        }
        assertEquals(0,c.size());
    }
    @Test
    public void load() {

        assertThrows(PersistenceException.class, () -> c.load());
        assertEquals(3,c.size());
        c.setPersistenceStrategyStream("file.txt","file.txt");
        try {
            c.store();
            Container c1 = Container.getInstance();
            c.load();
        }
        catch(PersistenceException pEX){
            assertEquals(PersistenceException.ExceptionType.LoadFailure,pEX.getExceptionTypeType());
        }
        assertEquals(3,c.size());
    }
    @Test
    public void store(){
        assertThrows(PersistenceException.class,()-> c.store());
        try{
            c.store();
        }
        catch(PersistenceException pEX){
            assertEquals(PersistenceException.ExceptionType.SaveFailure,pEX.getExceptionTypeType());
        }

    }
    @Test
    public void getCurrentList(){
        LinkedList<Member> m = (LinkedList<Member>) c.getCurrentList();
        assertEquals(c.size(),m.size());
    }
}
//TODO: assertSame() um die Identität zu testen.