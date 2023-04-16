package es.unican.is2.listaordenada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class ListaOrdenadaTest {
   
    private ListaOrdenada<Integer> lista;
    
    @BeforeEach
    public void setUp() {
        lista = new ListaOrdenada<Integer>();
    }

    @Test
    public void addTest() {
        //clases validas 
        lista.add(2);
        assertTrue((lista.size()==1));
        assertTrue((lista.get(0)==2));

        lista.add(3);
        assertTrue((lista.size()==2));
        assertTrue((lista.get(0)==2 && lista.get(1)==3));
        

        lista.add(1);
        assertTrue((lista.size()==3));
        assertTrue((lista.get(0)==1 && lista.get(1)==2 && lista.get(2)==3));
        
        //clases no validas
        ListaOrdenada<Integer> listaNueva = new ListaOrdenada<Integer>();
        try {
            assertThrows(NullPointerException.class, () -> listaNueva.add(null));
        } catch (NullPointerException e) {
            // TODO: handle exception
            fail(e);
        }
    }
    @Test
    public void removeTest() {
        //clases validas
        lista.add(2);        
        assertTrue((lista.remove(0) == 2));
        assertTrue((lista.size()==0));

        lista.add(4);
        lista.add(1);
        assertTrue((lista.remove(1) == 4));
        assertTrue((lista.size()==1));

        lista.add(0);
        lista.add(6);
        assertTrue((lista.remove(0) == 0));
        assertTrue((lista.size()==2));
        assertTrue((lista.remove(1) == 6));
        assertTrue((lista.size()==1));
        
        //clases no validas 
        lista.remove(0);
        try {
            assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(0));
            lista.add(1);
            assertThrows(IndexOutOfBoundsException.class, ( ) -> lista.remove(lista.size()+1) );
        } catch (NullPointerException e) {
            fail(e);
        } catch (IndexOutOfBoundsException e2) {
            fail(e2);
        }
    }
    @Test
    public void clearTest() {
        lista.add(1);
        //clases valida
        lista.clear();
        assertTrue((lista.size() == 0));

        lista.add(1);
        lista.add(2);
        lista.clear();
        assertTrue((lista.size() == 0));

       //clases no validas
       try {
            ListaOrdenada<Integer> nuevaListaOrdenada = new ListaOrdenada<Integer>(); 
            assertThrows(NullPointerException.class, () -> nuevaListaOrdenada.clear());
       } catch (NullPointerException e) {
            fail(e);
       }
    }

    @Test
    public void sizeTest() {
        assertTrue((lista.size() == 0));
        lista.add(1);
        assertTrue((lista.size() == 1));
        lista.add(2);
        assertTrue((lista.size() == 2));
    }



}
