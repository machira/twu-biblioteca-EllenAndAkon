import com.sun.tools.internal.xjc.reader.dtd.bindinfo.BIAttribute;
import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

/**
 * Created by angoh on 6/17/15.
 */
public class MenuTest {

    private BufferedReader reader;
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private List<Book> books;
    private Menu menu;

    @Before
    public void setUp() {
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        biblioteca = mock(Biblioteca.class);
        menu = new Menu(printStream, biblioteca, reader);
    }

    @Test
    public void testWelcomeMessagePrints() throws IOException {
        when(reader.readLine()).thenReturn("foo");
        menu.start();
        verify(printStream).println("Welcome to Biblioteca!");

    }

    @Test
    public void shouldDisplayMenuOnStart(){
        menu.start();

        verify(printStream).println(contains("MAIN MENU"));
    }

    @Test
    public void shouldAskForUserInputWhenMenuIsShown() {
        menu.start();
        verify(printStream).println("Enter your selection");
    }

    @Test
    public void shouldHandleInvalidUserInput() {
        menu.start();
        menu.selectOption("boo");
        verify(printStream).println("That's not a valid option");
    }

    @Test
    public void shouldHandleValidUserInput(){
        menu.selectOption("LISt books");
        verify(biblioteca).listBooks();
    }

}
