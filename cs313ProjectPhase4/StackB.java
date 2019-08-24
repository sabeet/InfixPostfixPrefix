class StackB {
    private char[] a;
    private int top, mVal;

    public StackB(int maxValue){
        mVal = maxValue;
        a = new char[mVal];
        top = -1;
    }

    public void push(char key){
        a[++top] = key;
    }

    public char pop() {
        return (a[top--]);
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}