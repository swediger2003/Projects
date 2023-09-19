package cs3500.marblesolitaire.controller;

import java.io.IOException;


/**
 * My fake appendable class, throws an exception for everything.
 */
public class FakeAppendable implements Appendable {

  /**
   * Dummy append. Throws appendable.
   *
   * @param csq The character sequence to append.  If {@code csq} is
   *            {@code null}, then the four characters {@code "null"} are
   *            appended to this Appendable.
   * @return IOException
   * @throws IOException Throws no matter what.
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException();
  }


  /**
   * Dummy append. Throws appendable.
   *
   * @param csq   The character sequence from which a subsequence will be
   *              appended.  If {@code csq} is {@code null}, then characters
   *              will be appended as if {@code csq} contained the four
   *              characters {@code "null"}.
   * @param start The index of the first character in the subsequence
   * @param end   The index of the character following the last character in the
   *              subsequence
   * @return IOException
   * @throws IOException Throws no matter what.
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException();
  }

  /**
   * Dummy append. Throws appendable.
   *
   * @param c The character to append
   * @return IOException.
   * @throws IOException Throws no matter what.
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException();
  }
}
