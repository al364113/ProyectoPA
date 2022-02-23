package practica1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import practica1.CSV.CSVTest;
import practica1.RegresionLineal.RegresionLinealTest;


@RunWith(Suite.class)
@SuiteClasses({CSVTest.class, RegresionLinealTest.class})
public class Practica1Suite {
}
