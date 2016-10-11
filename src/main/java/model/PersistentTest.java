package model;

import clojure.lang.IPersistentMap;
import clojure.lang.IPersistentSet;
import clojure.lang.IPersistentVector;
import clojure.lang.PersistentHashMap;
import clojure.lang.PersistentHashSet;
import clojure.lang.PersistentVector;

import java.util.concurrent.Callable;

import clojure.lang.LockingTransaction;
import clojure.lang.Ref;

import java.io.PushbackReader;
import java.io.StringReader;

import clojure.lang.EdnReader;
import clojure.lang.PersistentHashMap;

public class PersistentTest {
  public static void demo() {

    IPersistentMap m = PersistentHashMap.create("abc", "xyz");
    m = m.assoc(1, 4); // add a new key/value pair
    m = m.assoc("key", "value");
    m = m.without("abc"); // remove key "abc"
    System.out.println(m);

    IPersistentVector v = PersistentVector.create(1, 2, 3);
    v = v.assocN(0, "a string"); // change index 0
    v = v.cons("should be last"); // add a string at the end
    System.out.println(v);

    IPersistentSet s = PersistentHashSet.create("a", "b", "c");
    s = (IPersistentSet) s.cons("d"); // add d to the set
    s = (IPersistentSet) s.cons("a"); // should nOT add a to the set
    s = (IPersistentSet) s.cons("x"); // add x to the set
    s = s.disjoin("c"); // remove x from the set
    String answer = new StringBuilder()
      .append("Set contains c : ")
      .append(s.contains("c"))
      .toString();
    System.out.println(answer); // should return false
    System.out.println(s);

  }
}
