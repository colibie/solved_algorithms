package easy;

import java.util.*;

class flattenDictionary {
	
  static HashMap<String, String> solution(HashMap<String, Object> dict) {
    // your code goes here
    HashMap<String, String> result = new HashMap<>();
    flatten(dict, "", result);
    return result;
  }
  
  private static void flatten(HashMap<String, Object> subDict, String parentKey, HashMap<String, String> result) {
    for (String el : subDict.keySet()) {
      String key = el;
      if (!parentKey.equals("") && parentKey != null) {
        if (el == "") {
          key = parentKey;
        } else {
          key = new StringBuilder(parentKey).append(".").append(el).toString();
        }
      }

      if (subDict.get(el) instanceof String) {
        result.put(key, subDict.get(el).toString());
      } else {
        flatten((HashMap<String, Object>) subDict.get(el), key, result);
      }
    }
  }

  public static void main(String[] args) {
    HashMap<String, Object> f = new HashMap<>();
    f.put("", "awesome");
    HashMap<String, Object> e = new HashMap<>();
    e.put("f", f);
    HashMap<String, Object> d = new HashMap<>();
    d.put("e", e);
    HashMap<String, Object> c = new HashMap<>();
    c.put("d", d);
    HashMap<String, Object> b = new HashMap<>();
    b.put("c", c);
    HashMap<String, Object> a = new HashMap<>();
    a.put("b", b);
    HashMap<String, Object> dict = new HashMap<>();
    dict.put("a", a);
    HashMap<String, String> res = flattenDictionary.solution(dict);

    for (String string : res.keySet()) {
      System.out.println(string + " : " + res.get(string));
    }
  }

}