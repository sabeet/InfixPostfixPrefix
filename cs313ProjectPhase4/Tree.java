class Tree{
    public Node root;

    public Tree(){
        root = null;
    }

    public void preOrder(Node nearRt) {
        if (nearRt!= null)
        {
            nearRt.returnNode();
            preOrder(nearRt.leftChild);
            preOrder(nearRt.rightChild);
        }
    }

    public void inOrder(Node nearRt) {
        if (nearRt != null) {
            inOrder(nearRt.leftChild);
            nearRt.returnNode();
            inOrder(nearRt.rightChild);
        }
    }

    public void postOrder(Node nearRt) {
        if (nearRt != null) {
            postOrder(nearRt.leftChild);
            postOrder(nearRt.rightChild);
            nearRt.returnNode();
        }
    }

    public void insert(String str) {
        Conversion c = new Conversion(str);
        str = c.inToPost();
        StackA stk = new StackA(str.length());
        str = str + "#";
        int i = 0;
        char sy = str.charAt(i);
        Node newNode;
        while (sy != '#') {
            if (sy >= '0' && sy <= '9') {
                newNode = new Node(sy);
                stk.push(newNode);
            } else if (sy == '+' || sy == '-' || sy == '/'
                    || sy == '*') {


                    Node pip1 = stk.pop();
                    Node pip2 = stk.pop();
                    newNode = new Node(sy);

                    newNode.leftChild = pip2;
                    newNode.rightChild = pip1;
                    stk.push(newNode);
            }
            sy = str.charAt(++i);
        }
        root = stk.pop();
    }

    public void traverse(int type) {
        switch (type) {
            case 1:
                //Preorder
                System.out.print("   The Prefix Output is: ");
                preOrder(root);
                break;
            case 2:
                //Inorder
                System.out.print("   The Infix Output is: ");
                inOrder(root);
                break;
            case 3:
                //Postorder
                System.out.print("   The Postfix Output is: ");
                postOrder(root);
                break;
            default:
                System.out.println("There was an issue, please restart the program");
        }
    }
}
