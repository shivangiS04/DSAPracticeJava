class Solution {
    public List<String> findAllRecipes(String[] rec, List<List<String>> ing, String[] sup) {
        HashSet<String> h = new HashSet<>();
        HashSet<String> ans = new HashSet<>();
        HashMap<String , List<String>> rem = new HashMap<>();
        HashMap<String , List<String>> hm = new HashMap<>();
        for(String s : sup){
            h.add(s);
        }
        for(int i = 0 ; i < ing.size() ; i++){
            List<String> ls = ing.get(i);
            if(h.containsAll(ls)){
                h.add(rec[i]);
                ans.add(rec[i]);
            }else{
                List<String> pt = new ArrayList<>();
                for(String s : ls){
                    if(!h.contains(s))pt.add(s);
                }
                rem.put(rec[i],pt);
            }
        }
        for(Map.Entry<String,List<String>> e : rem.entrySet()){
            List<String> pts = e.getValue();
            for(String temp : pts){
                // System.out.println(temp);
                List<String> ghate = hm.getOrDefault(temp , new ArrayList<>());
                ghate.add(e.getKey());
                hm.put(temp,ghate);
            }
        }
        // System.out.println(h);
        // System.out.println(rem);
        // System.out.println(hm);
        // System.out.println();
        // System.out.println();
        for(Map.Entry<String,List<String>> e : rem.entrySet()){
            List<String> temp = e.getValue();
            if(h.containsAll(temp)){
                // System.out.println("yehh leee "+e.getKey());
                h.add(e.getKey());
                ans.add(e.getKey());
                haish( e.getKey() , hm , rem , h , ans);
            }
        }


        // System.out.println(h);
        // System.out.println(rem);
        // System.out.println(hm);
        return new ArrayList(ans);
    }
    void haish(String tp , HashMap<String , List<String>> hm , HashMap<String , List<String>> rem , HashSet<String> h , HashSet<String> ans){
        if(hm.containsKey(tp)){
            List<String> pts = hm.get(tp);
            for(String temp : pts){
                List<String> ghate = rem.get(temp);
                ghate.remove(tp);
                if(ghate.isEmpty()){
                    h.add(temp);
                    ans.add(temp);
                    haish( temp , hm , rem , h , ans);
                }
                hm.put(temp,ghate);
            }
            hm.remove(tp);
        }
    }
}