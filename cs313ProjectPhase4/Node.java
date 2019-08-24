class Node {

     public char data;
    public Node leftChild;
    public Node rightChild;

    public Node(char x){
        data = x;
    }

    public void returnNode(){
        System.out.print(data);
    }

    private char getData(){
        return data;
    }

}
