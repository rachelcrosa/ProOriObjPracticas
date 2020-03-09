package Jarra.Jarrilla1.Test;
//--------------------------------------------------------------------------
import Jarra.Jarrilla1.Jarra;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

//--------------------------------------------------------------------------

//--------------------------------------------------------------------------

public class JarraTest {
    //----------------------------------------------------------------------
    //--JUnitTest-----------------------------------------------------------
    //----------------------------------------------------------------------
    public static class JUnitTestJarra {
        private Jarra j5;
        @BeforeClass
        public static void beforeClass() {
            // Code executed before the first test method
            System.out.println("Start of Jarra JUnit Test");
        }
        @AfterClass
        public static void  afterClass() {
            // Code executed after the last test method
            System.out.println("End of Jarra JUnit Test");
        }
        @Before
        public void setUp() throws Exception {
            // Code executed before each test
            j5 = new Jarra(5);
        }
        @After
        public void tearDown() {
            // Code executed after each test
        }
        @Test(timeout = 1000)
        public void jarraCtorTest1() {
            assertEquals("\n> Error: new Jarra(5): Capacidad:", 5, j5.capacidad());
            assertEquals("\n> Error: new Jarra(5): Contenido:", 0, j5.contenido());
        }
        @Test(timeout = 1000)
        public void jarraCtorTestX1() {
            try {
                Jarra j2 = new Jarra(-1);
                fail("\n> Error: new Jarra(-1): No se lanzo ninguna excepcion");
            } catch (RuntimeException e) {
                //assertEquals("\n> Error: new Jarra(-1): exception.getMessage():", "", e.getMessage());
            } catch (Exception e) {
                fail("\n> Error: new Jarra(-1): la excepcion lanzada no es RuntimeException");
            }
        }
        @Test(timeout = 1000)
        public void jarraLlenaTest1() {
            precond(5, j5.capacidad());
            precond(0, j5.contenido());
            j5.llena();
            assertEquals("\n> Error: j50.llena(): Capacidad:", 5, j5.capacidad());
            assertEquals("\n> Error: j50.llena(): Contenido:", 5, j5.contenido());
        }
        @Test(timeout = 1000)
        public void jarraVaciaTest1() {
            j5.llena();
            precond(5, j5.capacidad());
            precond(5, j5.contenido());
            j5.vacia();
            assertEquals("\n> Error: j55.vacia(): Capacidad:", 5, j5.capacidad());
            assertEquals("\n> Error: j55.vacia(): Contenido:", 0, j5.contenido());
        }
        @Test(timeout = 1000)
        public void jarraLlenaDesdeTest1() throws Exception {
            Jarra j2 = new Jarra(2);
            j2.llena();
            precond(5, j5.capacidad());
            precond(0, j5.contenido());
            precond(2, j2.capacidad());
            precond(2, j2.contenido());
            j5.llenaDesde(j2);
            assertEquals("\n> Error: j50.llenaDesde(j22): j5.Capacidad:", 5, j5.capacidad());
            assertEquals("\n> Error: j50.llenaDesde(j22): j5.Contenido:", 2, j5.contenido());
            assertEquals("\n> Error: j50.llenaDesde(j22): j2.Capacidad:", 2, j2.capacidad());
            assertEquals("\n> Error: j50.llenaDesde(j22): j2.Contenido:", 0, j2.contenido());
        }
        @Test(timeout = 1000)
        public void jarraLlenaDesdeTest2() throws Exception {
            Jarra j2 = new Jarra(2);
            j5.llena();
            precond(5, j5.capacidad());
            precond(5, j5.contenido());
            precond(2, j2.capacidad());
            precond(0, j2.contenido());
            j2.llenaDesde(j5);
            assertEquals("\n> Error: j20.llenaDesde(j55): j5.Capacidad:", 5, j5.capacidad());
            assertEquals("\n> Error: j20.llenaDesde(j55): j5.Contenido:", 3, j5.contenido());
            assertEquals("\n> Error: j20.llenaDesde(j55): j2.Capacidad:", 2, j2.capacidad());
            assertEquals("\n> Error: j20.llenaDesde(j55): j2.Contenido:", 2, j2.contenido());
        }
        @Test(timeout = 1000)
        public void jarraLlenaDesdeTest3() throws Exception {
            Jarra j2 = new Jarra(2);
            j2.llena();
            precond(5, j5.capacidad());
            precond(0, j5.contenido());
            precond(2, j2.capacidad());
            precond(2, j2.contenido());
            j5.llenaDesde(j2);
            assertEquals("\n> Error: j50.llenaDesde(j22): j5.Capacidad:", 5, j5.capacidad());
            assertEquals("\n> Error: j50.llenaDesde(j22): j5.Contenido:", 2, j5.contenido());
            assertEquals("\n> Error: j50.llenaDesde(j22): j2.Capacidad:", 2, j2.capacidad());
            assertEquals("\n> Error: j50.llenaDesde(j22): j2.Contenido:", 0, j2.contenido());
            j2.llena();
            precond(5, j5.capacidad());
            precond(2, j5.contenido());
            precond(2, j2.capacidad());
            precond(2, j2.contenido());
            j5.llenaDesde(j2);
            assertEquals("\n> Error: j52.llenaDesde(j22): j5.Capacidad:", 5, j5.capacidad());
            assertEquals("\n> Error: j52.llenaDesde(j22): j5.Contenido:", 4, j5.contenido());
            assertEquals("\n> Error: j52.llenaDesde(j22): j2.Capacidad:", 2, j2.capacidad());
            assertEquals("\n> Error: j52.llenaDesde(j22): j2.Contenido:", 0, j2.contenido());
            j2.llena();
            precond(5, j5.capacidad());
            precond(4, j5.contenido());
            precond(2, j2.capacidad());
            precond(2, j2.contenido());
            j5.llenaDesde(j2);
            assertEquals("\n> Error: j54.llenaDesde(j22): j5.Capacidad:", 5, j5.capacidad());
            assertEquals("\n> Error: j54.llenaDesde(j22): j5.Contenido:", 5, j5.contenido());
            assertEquals("\n> Error: j54.llenaDesde(j22): j2.Capacidad:", 2, j2.capacidad());
            assertEquals("\n> Error: j54.llenaDesde(j22): j2.Contenido:", 1, j2.contenido());
        }
        @Test(timeout = 1000)
        public void jarraLlenaDesdeTestX1() {
            try {
                j5.llenaDesde(j5);
                fail("\n> Error: j5.llenaDesde(j5): No se lanzo ninguna excepcion");
            } catch (RuntimeException e) {
                //assertEquals("\n> Error: j5.llenaDesde(j5): exception.getMessage():", "", e.getMessage());
            } catch (Exception e) {
                fail("\n> Error: j5.llenaDesde(j5): la excepcion lanzada no es RuntimeException");
            }
        }
        @Test(timeout = 1000)
        public void jarraToStringTest1() {
            precond(5, j5.capacidad());
            precond(0, j5.contenido());
            assertEquals("\n> Error: j50.toString():",
                    normalize("J(5,0)"),
                    normalize(j5.toString()));
        }
        @Test(timeout = 1000)
        public void jarraToStringTest2() {
            j5.llena();
            precond(5, j5.capacidad());
            precond(5, j5.contenido());
            assertEquals("\n> Error: new j55.toString():",
                    normalize("J(5,5)"),
                    normalize(j5.toString()));
        }
        //------------------------------------------------------------------
    }
    //----------------------------------------------------------------------
    //--JUnitTestSuite------------------------------------------------------
    //----------------------------------------------------------------------
    @RunWith(Suite.class)
    @Suite.SuiteClasses({ JUnitTestJarra.class ,
    })
    public static class JUnitTestSuite { /*empty*/ }
    //----------------------------------------------------------------------
    //--JUnitTestRunner-----------------------------------------------------
    //----------------------------------------------------------------------
    public static Result result = null;
    public static void main(String[] args) {
        result = JUnitCore.runClasses(JUnitTestSuite.class);
        int rc = result.getRunCount();
        int fc = result.getFailureCount();
        int ac = 0;//result.getAssumptionFailureCount();
        int ic = result.getIgnoreCount();
        if (fc > 0) {
            System.out.println(">>> ------");
        }
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if ((ac > 0)||(fc > 0)) {
            System.out.println(">>> ------");
            if (ac > 0) {
                System.out.println(">>> Error: No se pudieron realizar "+ac+" tests debido a errores en otros metodos");
            }
            if (fc > 0) {
                System.out.println(">>> Error: Fallaron "+fc+" tests debido a errores en metodos");
            }
        }
        if (result.wasSuccessful()) {
            System.out.print(">>> JUnit Test Succeeded");
        } else {
            System.out.print(">>> Error: JUnit Test Failed");
        }
        System.out.println(" ("+rc+", "+fc+", "+ac+", "+ic+")");
    }
    //----------------------------------------------------------------------
    //-- Utils -------------------------------------------------------------
    //----------------------------------------------------------------------
    private static char normalizeUnicode(char ch) {
        switch (ch) {
            case '\n':
            case '\r':
            case '\t':
            case '\f':
                ch = ' ';
                break;
            case '\u20AC':
                ch = 'E';
                break;
            case '\u00A1':
                ch = '!';
                break;
            case '\u00AA':
                ch = 'a';
                break;
            case '\u00BA':
                ch = 'o';
                break;
            case '\u00BF':
                ch = '?';
                break;
            case '\u00C0':
            case '\u00C1':
            case '\u00C2':
            case '\u00C3':
            case '\u00C4':
            case '\u00C5':
            case '\u00C6':
                ch = 'A';
                break;
            case '\u00C7':
                ch = 'C';
                break;
            case '\u00C8':
            case '\u00C9':
            case '\u00CA':
            case '\u00CB':
                ch = 'E';
                break;
            case '\u00CC':
            case '\u00CD':
            case '\u00CE':
            case '\u00CF':
                ch = 'I';
                break;
            case '\u00D0':
                ch = 'D';
                break;
            case '\u00D1':
                ch = 'N';
                break;
            case '\u00D2':
            case '\u00D3':
            case '\u00D4':
            case '\u00D5':
            case '\u00D6':
                ch = 'O';
                break;
            case '\u00D9':
            case '\u00DA':
            case '\u00DB':
            case '\u00DC':
                ch = 'U';
                break;
            case '\u00DD':
                ch = 'Y';
                break;
            case '\u00E0':
            case '\u00E1':
            case '\u00E2':
            case '\u00E3':
            case '\u00E4':
            case '\u00E5':
            case '\u00E6':
                ch = 'a';
                break;
            case '\u00E7':
                ch = 'c';
                break;
            case '\u00E8':
            case '\u00E9':
            case '\u00EA':
            case '\u00EB':
                ch = 'e';
                break;
            case '\u00EC':
            case '\u00ED':
            case '\u00EE':
            case '\u00EF':
                ch = 'i';
                break;
            case '\u00F0':
                ch = 'd';
                break;
            case '\u00F1':
                ch = 'n';
                break;
            case '\u00F2':
            case '\u00F3':
            case '\u00F4':
            case '\u00F5':
            case '\u00F6':
                ch = 'o';
                break;
            case '\u00F9':
            case '\u00FA':
            case '\u00FB':
            case '\u00FC':
                ch = 'u';
                break;
            case '\u00FD':
            case '\u00FF':
                ch = 'y';
                break;
        }
        return ch;
    }
    //----------------------------------------------------------------------
    private static String normalize(String s1) {
        int sz = s1 == null ? 16 : s1.length() == 0 ? 16 : 2*s1.length();
        StringBuilder sb = new StringBuilder(sz);
        sb.append(' ');
        if (s1 != null) {
            for (int i = 0; i < s1.length(); ++i) {
                char ch = normalizeUnicode(s1.charAt(i));
                char sbLastChar = sb.charAt(sb.length()-1);
                if (Character.isLetter(ch)) {
                    if ( ! Character.isLetter(sbLastChar)) {
                        if ( ! Character.isSpaceChar(sbLastChar)) {
                            sb.append(' ');
                        }
                    }
                    sb.append(ch);
                } else if (Character.isDigit(ch)) {
                    if ((i >= 2)
                            && (s1.charAt(i-1) == '.')
                            && Character.isDigit(s1.charAt(i-2))) {
                        sb.setLength(sb.length()-2); // "9 ."
                        sb.append('.');
                    } else if ((i >= 2)
                            && ((s1.charAt(i-1) == 'e')||(s1.charAt(i-1) == 'E'))
                            && Character.isDigit(s1.charAt(i-2))) {
                        sb.setLength(sb.length()-2); // "9 e"
                        sb.append('e');
                    } else if ((i >= 3)
                            && (s1.charAt(i-1) == '+')
                            && ((s1.charAt(i-2) == 'e')||(s1.charAt(i-2) == 'E'))
                            && Character.isDigit(s1.charAt(i-3))) {
                        sb.setLength(sb.length()-4); // "9 e +"
                        sb.append('e');
                    } else if ((i >= 3)
                            && (s1.charAt(i-1) == '-')
                            && ((s1.charAt(i-2) == 'e')||(s1.charAt(i-2) == 'E'))
                            && Character.isDigit(s1.charAt(i-3))) {
                        sb.setLength(sb.length()-4); // "9 e -"
                        sb.append("e-");
                    } else if ( (sbLastChar != '-') && ! Character.isDigit(sbLastChar)) {
                        if ( ! Character.isSpaceChar(sbLastChar)) {
                            sb.append(' ');
                        }
                    }
                    sb.append(ch);
                } else if (Character.isSpaceChar(ch)) {
                    if ( ! Character.isSpaceChar(sbLastChar)) {
                        sb.append(' ');
                    }
                } else {
                    if ( ! Character.isSpaceChar(sbLastChar)) {
                        sb.append(' ');
                    }
                    sb.append(ch);
                }
            }
        }
        if (Character.isSpaceChar(sb.charAt(sb.length()-1))) {
            sb.setLength(sb.length()-1);
        }
        if ((sb.length() > 0) && Character.isSpaceChar(sb.charAt(0))) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    //----------------------------------------------------------------------
    private static final String precondMessage = "\n> Aviso: No se pudo realizar el test debido a errores en otros metodos";
    //----------------------------------------------------------------------
    private static void precond(boolean expectedValue, boolean currValue) {
        assumeTrue(precondMessage, expectedValue == currValue);
    }
    private static void precond(char expectedValue, char currValue) {
        assumeTrue(precondMessage, expectedValue == currValue);
    }
    private static void precond(short expectedValue, short currValue) {
        assumeTrue(precondMessage, expectedValue == currValue);
    }
    private static void precond(int expectedValue, int currValue) {
        assumeTrue(precondMessage, expectedValue == currValue);
    }
    private static void precond(long expectedValue, long currValue) {
        assumeTrue(precondMessage, expectedValue == currValue);
    }
    private static void precond(float expectedValue, float currValue, float delta) {
        assumeTrue(precondMessage, Math.abs(expectedValue - currValue) <= delta);
    }
    private static void precond(double expectedValue, double currValue, double delta) {
        assumeTrue(precondMessage, Math.abs(expectedValue - currValue) <= delta);
    }
    private static void precond(Object expectedValue, Object currValue) {
        if ((expectedValue == null)||(currValue == null)) {
            assumeTrue(precondMessage, expectedValue == currValue);
        } else {
            assumeTrue(precondMessage, expectedValue.equals(currValue));
        }
    }
    //----------------------------------------------------------------------
    private static void precondNorm(String expectedValue, String currValue) {
        precond(normalize(expectedValue), normalize(currValue));
    }
    private static void assertEqualsNorm(String msg, String expectedValue, String currValue) {
        assertEquals(msg, normalize(expectedValue), normalize(currValue));
    }
    private static void assertArrayEqualsNorm(String msg, String[] expectedValue, String[] currValue) {
        assertEquals(msg, expectedValue.length, currValue.length);
        for (int i = 0; i < expectedValue.length; ++i) {
            assertEquals(msg, normalize(expectedValue[i]), normalize(currValue[i]));
        }
    }
    //----------------------------------------------------------------------
    private static void deleteFile(String filename) {
        new java.io.File(filename).delete();
    }
    private static void createFile(String filename, String inputData) throws Exception {
        try (java.io.PrintWriter pw = new java.io.PrintWriter(filename)) {
            pw.println(inputData);
        }
    }
    private static void createFile(String filename, String[] inputData) throws Exception {
        try (java.io.PrintWriter pw = new java.io.PrintWriter(filename)) {
            for (String linea : inputData) {
                pw.println(linea);
            }
        }
    }
    private static String loadFile(String filename) throws Exception {
        java.util.StringJoiner sj = new java.util.StringJoiner("\n");
        try (java.util.Scanner sc = new java.util.Scanner(new java.io.File(filename))) {
            while (sc.hasNextLine()) {
                sj.add(sc.nextLine());
            }
        }
        return sj.toString();
    }
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    private static class SysOutCapture {
        private SysOutErrCapture systemout;
        private SysOutErrCapture systemerr;
        public SysOutCapture() {
            systemout = new SysOutErrCapture(false);
            systemerr = new SysOutErrCapture(true);
        }
        public void sysOutCapture() throws RuntimeException {
            try {
                systemout.sysOutCapture();
            } finally {
                systemerr.sysOutCapture();
            }
        }
        public String sysOutRelease() throws RuntimeException {
            String s1 = "";
            String s2 = "";
            try {
                s1 = systemout.sysOutRelease();
            } finally {
                s2 = systemerr.sysOutRelease();
            }
            return s1 + " " + s2 ;
        }
        //--------------------------
        private static class SysOutErrCapture {
            //--------------------------------
            private java.io.PrintStream sysoutOld;
            private java.io.PrintStream sysoutstr;
            private java.io.ByteArrayOutputStream baos;
            private final boolean systemErr;
            private int estado;
            //--------------------------------
            public SysOutErrCapture(boolean syserr) {
                sysoutstr = null ;
                baos = null;
                sysoutOld = null ;
                estado = 0;
                systemErr = syserr;
            }
            //--------------------------------
            public void sysOutCapture() throws RuntimeException {
                if (estado != 0) {
                    throw new RuntimeException("sysOutCapture:BadState");
                } else {
                    estado = 1;
                    try {
                        if (systemErr) {
                            sysoutOld = System.err;
                        } else {
                            sysoutOld = System.out;
                        }
                        baos = new java.io.ByteArrayOutputStream();
                        sysoutstr = new java.io.PrintStream(baos);
                        if (systemErr) {
                            System.setErr(sysoutstr);
                        } else {
                            System.setOut(sysoutstr);
                        }
                    } catch (Throwable e) {
                        throw new RuntimeException("sysOutCapture:InternalError");
                    }
                }
            }
            //--------------------------------
            public String sysOutRelease() throws RuntimeException {
                String result = "";
                if (estado != 1) {
                    throw new RuntimeException("sysOutRelease:BadState");
                } else {
                    estado = 0;
                    try {
                        if (sysoutstr != null) {
                            sysoutstr.flush();
                        }
                        if (baos != null) {
                            baos.flush();
                            result = new String(baos.toByteArray()); //java.nio.charset.StandardCharsets.ISO_8859_1);
                        }
                    } catch (Throwable e) {
                        throw new RuntimeException("sysOutRelease:InternalError1");
                    } finally {
                        try {
                            if (systemErr) {
                                System.setErr(sysoutOld);
                            } else {
                                System.setOut(sysoutOld);
                            }
                            if (sysoutstr != null) {
                                sysoutstr.close();
                                sysoutstr = null;
                            }
                            if (baos != null) {
                                baos.close();
                                baos = null;
                            }
                        } catch (Throwable e) {
                            throw new RuntimeException("sysOutRelease:InternalError2");
                        }
                    }
                }
                return result;
            }
            //--------------------------------
        }
    }
    //----------------------------------------------------------------------
}
//--------------------------------------------------------------------------