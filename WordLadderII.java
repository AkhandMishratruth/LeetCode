class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        HashMap<String, Integer> wordToInd = new HashMap<String, Integer>();
        
        HashSet<String> words = new HashSet<String>(wordList);
        words.add(beginWord);
        
        int end=0, start=0, k=1;
        int l = words.size();
        for(String s : words){
            if(s.equals(beginWord))
                start = k;
            if(s.equals(endWord))
                end = k;
            map.put(k, s);
            wordToInd.put(s, k);
            k++;
        }
        
        Graph gra = new Graph(words.size());
        for(HashMap.Entry<String, Integer> ent : wordToInd.entrySet()){
            String word = ent.getKey();
            for(int i =0;i<word.length(); i++){
                for(char c = 'a'; c<='z'; c++){
                    String temp = word.substring(0, i) + Character.toString(c) + word.substring(i+1, word.length());
                    if(!temp.equals(word) && wordToInd.containsKey(temp) && wordToInd.get(temp)>ent.getValue()){
                        gra.addEdge(wordToInd.get(word), wordToInd.get(temp));
                    }
                }
            }
        }
        
        gra.shortestPathBFS(start, end);
        List<List<String>> ar = new ArrayList<List<String>>();
        if(gra.ar.size()==0)
            return ar;
        int min = Integer.MAX_VALUE;
        for(List<Integer> a : gra.ar)
            min  = Math.min(min, a.size());
        
        for(int i=0;i<gra.ar.size();i++){
            if(gra.ar.get(i).size() == min){
                ArrayList<String> temp = new ArrayList<String>();
                for(int j=0; j<gra.ar.get(i).size(); j++){
                    temp.add(map.get(gra.ar.get(i).get(j)));
                }
                ar.add(temp);
            }
        }
        return ar;
    }
    
    class Pair{
        int v;
        ArrayList<Integer> list;
        Pair(int a, ArrayList<Integer> ls){
            v = a;
            list = ls;
        }
    }
    
    class Graph{
        int v;
        HashMap<Integer, LinkedList<Integer>> adj;
        List<List<Integer>> ar;
        Graph(int v){
            adj = new HashMap<Integer, LinkedList<Integer>>();
            ar = new ArrayList<List<Integer>>();
            this.v = v;
            for(int i=1;i<=v;i++)
                adj.put(i, new LinkedList<Integer>());
        }
        
        void addEdge(int s, int d){
            //System.out.println(s);
            adj.get(s).add(d);
            adj.get(d).add(s);
        }
        
        void shortestPathBFS(int s, int d){
            LinkedList<Pair> q = new LinkedList<>();
            q.add(new Pair(s, new ArrayList<Integer>(Arrays.asList(s))));        
            HashSet<Integer> visited = new HashSet<Integer>();
            
            while(!q.isEmpty()){
                Pair p = q.poll();
                if(p.v==d)
                    ar.add(p.list);
                else{
                    visited.add(p.v);
                    for(Integer i : adj.get(p.v)){
                        if(!visited.contains(i)){
                            ArrayList<Integer> l = new ArrayList<Integer>(p.list);
                            l.add(i);
                            q.add(new Pair(i, l));
                        }
                    }
                }
            }
        }
        
        boolean isVisited(int i, ArrayList<Integer> path){
            for(Integer l : path)
                if(l==i)
                    return true;
            return false;
        }
        
        void pushIntoAr(ArrayList<Integer> path){
            if(ar.size()==0)
                ar.add((ArrayList<Integer>)path.clone());
            else if(ar.size()>0 && ar.get(0).size()>path.size()){
                ar = new ArrayList<List<Integer>>();
                ar.add((ArrayList<Integer>)path.clone());
            }
            else if(ar.size()>0 && ar.get(0).size()==path.size())
                    ar.add((ArrayList<Integer>)path.clone());
        }
    }
}
