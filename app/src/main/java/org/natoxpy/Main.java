package org.natoxpy;

import java.io.IOException;
import java.io.Reader;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp.Capability;

public class Main {
  public static void main(String[] args) throws IOException, InterruptedException {
    Terminal terminal = TerminalBuilder.builder().build();
    terminal.enterRawMode();

    terminal.puts(Capability.clear_screen);
    terminal.writer().flush();

    Reader reader = terminal.reader();

    Size size = terminal.getSize();

    terminal.writer().printf("Press Any Key");
    terminal.writer().flush();

    terminal.puts(Capability.clear_screen);

    int c;
    while ((c = reader.read()) != 'q') {
      terminal.writer().printf("You pressed: %c (ASCII: %d)%n", (char) c, c);
      terminal.writer().printf("size %s", size);
      terminal.writer().flush();
      terminal.puts(Capability.clear_screen);
    }

    terminal.close();
  }
}
