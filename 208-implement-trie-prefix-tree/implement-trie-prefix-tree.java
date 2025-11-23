class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        char[] c = word.toCharArray();
        for(int i=0;i<c.length;i++){
            if(node.containsChar(c[i])){
                node = node.get(c[i]);
            }else{
                node.put(c[i],new Node());
                node = node.get(c[i]);
            }
        }

        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        char[] c = word.toCharArray();
        for(int i=0;i<c.length;i++){
            if(node.containsChar(c[i])){
                node = node.get(c[i]);
            }else{
                return false;
            }
        }

        return node.getFlag();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        char[] c = prefix.toCharArray();
        for(int i=0;i<c.length;i++){
            if(node.containsChar(c[i])){
                node = node.get(c[i]);
            }else{
                return false;
            }
        }

        return true;
    }
}


public class Node{

    public Node[] links = new Node[26];
    public boolean flag = false;

    public Node (){}

    public boolean containsChar(char ch){
        return (links[ch-'a']!=null);
    }

    public void put(char ch, Node node){
        links[ch-'a']=node;
    }

    public Node get(char ch){
        return links[ch-'a'];
    }

    public void setEnd(){
        this.flag = true;
    }

    public boolean getFlag(){
        return this.flag;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */