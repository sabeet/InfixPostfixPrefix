class StackA {
    private Node[] a;
    private int top, mVal;

    public StackA(int maxValue){

        mVal = maxValue;
        a = new Node[mVal];
        top = -1;
    }

    public void push(Node key) {
        a[++top] = key;
    }

    public Node pop() {
        return (a[top--]);
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}