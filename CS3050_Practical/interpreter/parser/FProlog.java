/* FProlog.java */
/* Generated By:JavaCC: Do not edit this line. FProlog.java */
package parser;

import java.util.ArrayList;
import parser.ast.*;

public class FProlog implements FPrologConstants {
  public static void main(String[] args) throws Exception {
    FPProg result = new FProlog(new java.io.StringReader(args[0])).P();
    System.out.println(result);
  }

// A head is an atom with an arbitrary number of atom/variable parameters.
  static final public FPHead Head() throws ParseException {Token ta; FPTerm tp, ti; ArrayList<FPTerm> ts = new ArrayList<FPTerm>();
    ta = jj_consume_token(ATOM);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LPAREN:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      jj_consume_token(LPAREN);
      tp = Term();
ts.add(tp);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case COMMA:{
          ;
          break;
          }
        default:
          jj_la1[1] = jj_gen;
          break label_2;
        }
        jj_consume_token(COMMA);
        ti = Term();
ts.add(ti);
      }
      jj_consume_token(RPAREN);
    }
{if ("" != null) return new FPHead(ta.image, ts);}
    throw new Error("Missing return statement in function");
}

  static final public FPTerm Term() throws ParseException {Token ta;
    FPTerm t1, ti = null;
    ArrayList<FPTerm> ts = new ArrayList<FPTerm>();
    FPTerm t;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ATOM:{
      ta = jj_consume_token(ATOM);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LPAREN:{
        jj_consume_token(LPAREN);
        t1 = Term();
ts.add(t1);
        label_3:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case COMMA:{
            ;
            break;
            }
          default:
            jj_la1[2] = jj_gen;
            break label_3;
          }
          jj_consume_token(COMMA);
          ti = Term();
ts.add(ti);
        }
        jj_consume_token(RPAREN);
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        ;
      }
if (ts.size() == 0) {
            t = new FPTerm(TKind.CONST, ta.image);
          } else {
            t = new FPTerm(TKind.CTERM, ta.image, ts);
          }
      break;
      }
    case VAR:{
      ta = jj_consume_token(VAR);
t = new FPTerm(TKind.IDENT, ta.image);
      break;
      }
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return t;}
    throw new Error("Missing return statement in function");
}

// A body is a comma-separated sequence of terms.
  static final public FPBody Body() throws ParseException {FPTerm t, ti; ArrayList<FPTerm> ts = new ArrayList<FPTerm>();
    t = Term();
ts.add(t);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        break label_4;
      }
      jj_consume_token(COMMA);
      ti = Term();
ts.add(ti);
    }
{if ("" != null) return new FPBody(ts);}
    throw new Error("Missing return statement in function");
}

  static final public FPBody Query() throws ParseException {FPBody b;
    jj_consume_token(PROMPT);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ATOM:
    case VAR:{
      b = Body();
{if ("" != null) return b;}
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      ;
    }
{if ("" != null) return new FPBody(new ArrayList<FPTerm>());}
    throw new Error("Missing return statement in function");
}

// A clause is headless (a query), bodiless (a fact), or neither (a rule).
  static final public FPClause Clause() throws ParseException {FPHead h = null; FPBody b = null;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ATOM:{
      h = Head();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IMPL:{
        jj_consume_token(IMPL);
        b = Body();
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        ;
      }
      break;
      }
    case PROMPT:{
      b = Query();
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(STOP);
{if ("" != null) return new FPClause(h, b);}
    throw new Error("Missing return statement in function");
}

// A program is a sequence of facts, rules, and queries.
  static final public FPProg P() throws ParseException {FPProg p = new FPProg(); FPClause t1; FPClause ti;
    t1 = Clause();
p.add(t1);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ATOM:
      case PROMPT:{
        ;
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        break label_5;
      }
      ti = Clause();
p.add(ti);
    }
    jj_consume_token(0);
{if ("" != null) return p;}
    throw new Error("Missing return statement in function");
}

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public FPrologTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[10];
  static private int[] jj_la1_0;
  static {
	   jj_la1_init_0();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x400,0x1000,0x1000,0x400,0x60,0x1000,0x60,0x4000,0x8020,0x8020,};
	}

  /** Constructor with InputStream. */
  public FProlog(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public FProlog(java.io.InputStream stream, String encoding) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser.  ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new FPrologTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public FProlog(java.io.Reader stream) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new FPrologTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new FPrologTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public FProlog(FPrologTokenManager tm) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(FPrologTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 10; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  static private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[18];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 10; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 18; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  static private boolean trace_enabled;

/** Trace enabled. */
  static final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
