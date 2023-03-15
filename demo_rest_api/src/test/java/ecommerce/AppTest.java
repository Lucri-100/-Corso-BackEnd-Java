package ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest{

@Test
    void checkProdotti(){
    assertNotNull(App.mapGet());
}

}
