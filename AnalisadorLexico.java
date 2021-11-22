package Analisador;

// See https://github.com/jflex-de/jflex/issues/222
@SuppressWarnings("FallThrough")
class AnalisadorLexico {

    public String tokens = "";
    public String[] tokensLexema = new String[10000];
    public String tokensDescricao = "";
    public int contadorToken = 0;
    public int i= 1;
    public int contador =0; 

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\2\1\2\2\1\1\22\0\1\1\1\3\4\0"+
    "\1\4\1\5\2\6\1\7\1\10\1\6\1\11\1\6"+
    "\1\12\1\13\11\14\1\0\1\6\1\15\1\16\1\15"+
    "\1\0\1\5\32\17\1\6\1\0\1\6\1\0\1\17"+
    "\1\0\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\17\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\17\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\6\1\50\1\6\7\0\1\2"+
    "\u01a2\0\2\2\326\0\u0100\2";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\2\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\2\12\1\13\1\14\20\15\1\2\1\16"+
    "\1\13\1\17\10\15\1\20\7\15\1\20\40\15\1\20"+
    "\52\15\1\20\7\15\1\20\20\15";

  private static int [] zzUnpackAction() {
    int [] result = new int[152];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\51\0\51\0\122\0\51\0\51\0\51\0\51"+
    "\0\51\0\51\0\173\0\51\0\244\0\315\0\366\0\u011f"+
    "\0\u0148\0\u0171\0\u019a\0\u01c3\0\u01ec\0\u0215\0\u023e\0\u0267"+
    "\0\u0290\0\u02b9\0\u02e2\0\u030b\0\u0334\0\u035d\0\u0386\0\u011f"+
    "\0\51\0\51\0\51\0\u03af\0\u03d8\0\u0401\0\u042a\0\u0453"+
    "\0\u047c\0\u04a5\0\u04ce\0\u04f7\0\u0520\0\u0549\0\u0572\0\u059b"+
    "\0\u05c4\0\u05ed\0\u0616\0\u011f\0\u063f\0\u0668\0\u0691\0\u06ba"+
    "\0\u06e3\0\u070c\0\u0735\0\u075e\0\u0787\0\u07b0\0\u07d9\0\u0802"+
    "\0\u082b\0\u0854\0\u087d\0\u08a6\0\u08cf\0\u08f8\0\u0921\0\u094a"+
    "\0\u0973\0\u099c\0\u09c5\0\u09ee\0\u0a17\0\u0a40\0\u0a69\0\u0a92"+
    "\0\u0abb\0\u0ae4\0\u0b0d\0\u0b36\0\u0b5f\0\u0b88\0\u0bb1\0\u0bda"+
    "\0\u0c03\0\u0c2c\0\u0c55\0\u0c7e\0\u0ca7\0\u0cd0\0\u0cf9\0\u0d22"+
    "\0\u0d4b\0\u0d74\0\u0d9d\0\u0dc6\0\u0def\0\u0e18\0\u0e41\0\u0e6a"+
    "\0\u0e93\0\u0ebc\0\u0ee5\0\u0f0e\0\u0f37\0\u0f60\0\u0f89\0\u0fb2"+
    "\0\u0fdb\0\u1004\0\u102d\0\u1056\0\u107f\0\u10a8\0\u10d1\0\u10fa"+
    "\0\u1123\0\u114c\0\u1175\0\u119e\0\u11c7\0\u11f0\0\u1219\0\u1242"+
    "\0\u126b\0\u1294\0\u12bd\0\u12e6\0\u130f\0\u1338\0\u1361\0\u0d74"+
    "\0\u138a\0\u13b3\0\u13dc\0\u1405\0\u142e\0\u1457\0\u1480\0\u14a9"+
    "\0\u14d2\0\u14fb\0\u1524\0\u154d\0\u1576\0\u159f\0\u15c8\0\u15f1";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[152];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\0\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\2\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\20\1\27"+
    "\1\20\1\30\1\20\1\31\1\20\1\32\1\33\1\34"+
    "\1\35\1\20\1\36\1\37\3\20\1\40\67\0\1\5"+
    "\44\0\1\41\51\0\2\15\52\0\1\42\50\0\1\43"+
    "\45\0\2\20\2\0\32\20\13\0\2\20\2\0\16\20"+
    "\1\44\1\20\1\45\6\20\1\46\2\20\13\0\2\20"+
    "\2\0\1\20\1\47\6\20\1\50\2\20\1\51\2\20"+
    "\1\52\13\20\13\0\2\20\2\0\5\20\1\53\10\20"+
    "\1\54\13\20\13\0\2\20\2\0\13\20\1\55\1\20"+
    "\1\56\10\20\1\57\3\20\13\0\2\20\2\0\11\20"+
    "\1\60\1\20\1\61\2\20\1\62\13\20\13\0\2\20"+
    "\2\0\16\20\1\63\13\20\13\0\2\20\2\0\6\20"+
    "\1\64\5\20\1\65\1\66\14\20\13\0\2\20\2\0"+
    "\16\20\1\67\13\20\13\0\2\20\2\0\1\20\1\70"+
    "\3\20\1\71\24\20\13\0\2\20\2\0\1\20\1\72"+
    "\16\20\1\73\2\20\1\74\6\20\13\0\2\20\2\0"+
    "\5\20\1\75\24\20\13\0\2\20\2\0\10\20\1\76"+
    "\11\20\1\77\1\100\1\20\1\101\1\20\1\102\2\20"+
    "\13\0\2\20\2\0\10\20\1\103\7\20\1\104\11\20"+
    "\13\0\2\20\2\0\16\20\1\105\13\20\13\0\2\20"+
    "\2\0\10\20\1\106\21\20\13\0\2\20\2\0\16\20"+
    "\1\107\13\20\13\0\2\20\2\0\5\20\1\110\24\20"+
    "\13\0\2\20\2\0\22\20\1\111\7\20\13\0\2\20"+
    "\2\0\21\20\1\111\1\112\7\20\13\0\2\20\2\0"+
    "\1\20\1\62\30\20\13\0\2\20\2\0\1\20\1\113"+
    "\30\20\13\0\2\20\2\0\15\20\1\114\14\20\13\0"+
    "\2\20\2\0\6\20\1\115\23\20\13\0\2\20\2\0"+
    "\23\20\1\116\6\20\13\0\2\20\2\0\21\20\1\111"+
    "\10\20\13\0\2\20\2\0\23\20\1\117\6\20\13\0"+
    "\2\20\2\0\22\20\1\120\7\20\13\0\2\20\2\0"+
    "\15\20\1\121\14\20\13\0\2\20\2\0\16\20\1\122"+
    "\13\20\13\0\2\20\2\0\20\20\1\64\11\20\13\0"+
    "\2\20\2\0\22\20\1\123\7\20\13\0\2\20\2\0"+
    "\17\20\1\124\12\20\13\0\2\20\2\0\22\20\1\125"+
    "\7\20\13\0\2\20\2\0\15\20\1\126\14\20\13\0"+
    "\2\20\2\0\22\20\1\127\7\20\13\0\2\20\2\0"+
    "\25\20\1\64\4\20\13\0\2\20\2\0\3\20\1\130"+
    "\26\20\13\0\2\20\2\0\11\20\1\131\4\20\1\132"+
    "\13\20\13\0\2\20\2\0\2\20\1\133\27\20\13\0"+
    "\2\20\2\0\22\20\1\134\7\20\13\0\2\20\2\0"+
    "\16\20\1\135\13\20\13\0\2\20\2\0\1\20\1\136"+
    "\30\20\13\0\2\20\2\0\17\20\1\137\12\20\13\0"+
    "\2\20\2\0\11\20\1\140\20\20\13\0\2\20\2\0"+
    "\15\20\1\141\14\20\13\0\2\20\2\0\11\20\1\142"+
    "\6\20\1\143\11\20\13\0\2\20\2\0\1\20\1\144"+
    "\25\20\1\64\2\20\13\0\2\20\2\0\11\20\1\145"+
    "\1\20\1\146\16\20\13\0\2\20\2\0\11\20\1\147"+
    "\20\20\13\0\2\20\2\0\13\20\1\150\16\20\13\0"+
    "\2\20\2\0\1\20\1\151\30\20\13\0\2\20\2\0"+
    "\5\20\1\64\24\20\13\0\2\20\2\0\3\20\1\152"+
    "\26\20\13\0\2\20\2\0\21\20\1\142\10\20\13\0"+
    "\2\20\2\0\21\20\1\153\1\154\7\20\13\0\2\20"+
    "\2\0\1\20\1\155\30\20\13\0\2\20\2\0\2\20"+
    "\1\147\27\20\13\0\2\20\2\0\14\20\1\64\15\20"+
    "\13\0\2\20\2\0\5\20\1\156\24\20\13\0\2\20"+
    "\2\0\1\20\1\157\30\20\13\0\2\20\2\0\1\20"+
    "\1\153\30\20\13\0\2\20\2\0\16\20\1\64\13\20"+
    "\13\0\2\20\2\0\13\20\1\160\2\20\1\135\13\20"+
    "\13\0\2\20\2\0\5\20\1\161\24\20\13\0\2\20"+
    "\2\0\7\20\1\64\22\20\13\0\2\20\2\0\11\20"+
    "\1\162\20\20\13\0\2\20\2\0\12\20\1\163\17\20"+
    "\13\0\2\20\2\0\24\20\1\164\5\20\13\0\2\20"+
    "\2\0\22\20\1\165\7\20\13\0\2\20\2\0\13\20"+
    "\1\166\16\20\13\0\2\20\2\0\23\20\1\167\6\20"+
    "\13\0\2\20\2\0\20\20\1\153\11\20\13\0\2\20"+
    "\2\0\22\20\1\166\7\20\13\0\2\20\2\0\5\20"+
    "\1\62\24\20\13\0\2\20\2\0\22\20\1\112\7\20"+
    "\13\0\2\20\2\0\3\20\1\170\26\20\13\0\2\20"+
    "\2\0\21\20\1\64\10\20\13\0\2\20\2\0\16\20"+
    "\1\171\13\20\13\0\2\20\2\0\15\20\1\172\14\20"+
    "\13\0\2\20\2\0\4\20\1\64\25\20\13\0\2\20"+
    "\2\0\1\20\1\173\30\20\13\0\2\20\2\0\13\20"+
    "\1\111\16\20\13\0\2\20\2\0\5\20\1\174\24\20"+
    "\13\0\2\20\2\0\12\20\1\64\17\20\13\0\2\20"+
    "\2\0\10\20\1\64\21\20\13\0\2\20\2\0\22\20"+
    "\1\64\7\20\13\0\2\20\2\0\11\20\1\175\20\20"+
    "\13\0\2\20\2\0\23\20\1\176\6\20\13\0\2\20"+
    "\2\0\15\20\1\177\14\20\13\0\2\20\2\0\13\20"+
    "\1\200\16\20\13\0\2\20\2\0\5\20\1\201\24\20"+
    "\13\0\2\20\2\0\20\20\1\202\11\20\13\0\2\20"+
    "\2\0\24\20\1\111\5\20\13\0\2\20\2\0\1\20"+
    "\1\203\30\20\13\0\2\20\2\0\1\20\1\46\30\20"+
    "\13\0\2\20\2\0\5\20\1\204\24\20\13\0\2\20"+
    "\2\0\11\20\1\205\20\20\13\0\2\20\2\0\20\20"+
    "\1\206\11\20\13\0\2\20\2\0\10\20\1\207\21\20"+
    "\13\0\2\20\2\0\25\20\1\210\4\20\13\0\2\20"+
    "\2\0\21\20\1\211\10\20\13\0\2\20\2\0\22\20"+
    "\1\106\7\20\13\0\2\20\2\0\1\20\1\206\30\20"+
    "\13\0\2\20\2\0\15\20\1\212\14\20\13\0\2\20"+
    "\2\0\13\20\1\153\16\20\13\0\2\20\2\0\4\20"+
    "\1\142\25\20\13\0\2\20\2\0\13\20\1\213\16\20"+
    "\13\0\2\20\2\0\14\20\1\214\15\20\13\0\2\20"+
    "\2\0\6\20\1\215\23\20\13\0\2\20\2\0\7\20"+
    "\1\111\22\20\13\0\2\20\2\0\3\20\1\216\26\20"+
    "\13\0\2\20\2\0\3\20\1\64\26\20\13\0\2\20"+
    "\2\0\15\20\1\64\14\20\13\0\2\20\2\0\20\20"+
    "\1\217\11\20\13\0\2\20\2\0\11\20\1\220\20\20"+
    "\13\0\2\20\2\0\23\20\1\111\6\20\13\0\2\20"+
    "\2\0\27\20\1\64\2\20\13\0\2\20\2\0\5\20"+
    "\1\221\24\20\13\0\2\20\2\0\1\20\1\222\30\20"+
    "\13\0\2\20\2\0\22\20\1\223\7\20\13\0\2\20"+
    "\2\0\16\20\1\224\13\20\13\0\2\20\2\0\5\20"+
    "\1\225\24\20\13\0\2\20\2\0\15\20\1\226\14\20"+
    "\13\0\2\20\2\0\3\20\1\111\26\20\13\0\2\20"+
    "\2\0\5\20\1\145\24\20\13\0\2\20\2\0\15\20"+
    "\1\227\14\20\13\0\2\20\2\0\15\20\1\153\14\20"+
    "\13\0\2\20\2\0\22\20\1\142\7\20\13\0\2\20"+
    "\2\0\11\20\1\230\20\20\13\0\2\20\2\0\30\20"+
    "\1\223\1\20";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5658];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\1\1\6\11\1\1\1\11\24\1\3\11"+
    "\165\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[152];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */

private int imprimir(String descricao, String lexema) {
    tokens +=  lexema + "  -- " + descricao+ "\n";
    tokensLexema[contadorToken] ="          "+ lexema + "  -- " + descricao+ "\n";
    tokensDescricao += "  --"+ descricao + "\n";
    contador += lexema.length();
    i = tokens.length();
    return i;
}



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  AnalisadorLexico(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public void yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;




    InterfaceAnalisador gui = new InterfaceAnalisador();
    while (i >0) {
      i = gui.contador(contador);


      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        //return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { throw new RuntimeException("Caractere inválido " + yytext());
            }
            // fall through
          case 17: break;
          case 2:
            { imprimir("   Espaço em branco", yytext());
            }
            // fall through
          case 18: break;
          case 3:
            { imprimir("   Operador logico", yytext());
            }
            // fall through
          case 19: break;
          case 4:
            { imprimir("   Operador especial", yytext());
            }
            // fall through
          case 20: break;
          case 5:
            { imprimir("   Operador delimitador", yytext());
            }
            // fall through
          case 21: break;
          case 6:
            { imprimir("   Operador de multiplicacao", yytext());
            }
            // fall through
          case 22: break;
          case 7:
            { imprimir("   Operador de soma", yytext());
            }
            // fall through
          case 23: break;
          case 8:
            { imprimir("   Operador de subtracao", yytext());
            }
            // fall through
          case 24: break;
          case 9:
            { imprimir("   Operador de divisao", yytext());
            }
            // fall through
          case 25: break;
          case 10:
            { imprimir("   Número Inteiro", yytext());
            }
            // fall through
          case 26: break;
          case 11:
            { imprimir("   Operador relacionais", yytext());
            }
            // fall through
          case 27: break;
          case 12:
            { imprimir("   Operador atribuicao", yytext());
            }
            // fall through
          case 28: break;
          case 13:
            { imprimir("   Identificador", yytext());
            }
            // fall through
          case 29: break;
          case 14:
            { imprimir("   Operador comentario", yytext());
            }
            // fall through
          case 30: break;
          case 15:
            { imprimir("   Operador comparacao", yytext());
            }
            // fall through
          case 31: break;
          case 16:
            { imprimir("   Palavra reservada", yytext());
            }
            // fall through
          case 32: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }

      contadorToken ++;
    }
  }


}
