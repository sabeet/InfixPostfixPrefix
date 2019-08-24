import java.awt.*;
import java.awt.event.*;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.*;

public class Gui extends JFrame{

    private JTextField tf;
    private JRadioButton in;
    private JRadioButton pre;
    private JRadioButton post;
    private Panel tree;


    public Gui(){
        super("Tree Drawer");
        setLayout(new FlowLayout());

        tf = new JTextField("Please input expression here. Select an option and then press enter" );
        tree = new Panel();
        in = new JRadioButton("Infix", true);
        pre = new JRadioButton("Prefix", false);
        post = new JRadioButton("Postfix", false);

        PrintStream ps = new PrintStream(
                new OutputStream() {
                    public void write(int c){
                        tf.setText(tf.getText() + (char) c);
                    }
                }
        );

        System.setOut(ps);


        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(in.isSelected()) {
                    Tree obj = new Tree();
                    String input = tf.getText();
                    obj.insert(input);
                    obj.traverse(2);
                }

                if(pre.isSelected()) {
                    Tree obj = new Tree();
                    String input = tf.getText();
                    obj.insert(input);
                    obj.traverse(1);
                }

                if(post.isSelected()) {
                    Tree obj = new Tree();
                    String input = tf.getText();
                    obj.insert(input);
                    obj.traverse(3);
                }

            }


        });




        add(tf);
        add(tree);
        add(in);
        add(pre);
        add(post);

        ButtonGroup group = new ButtonGroup();
        group.add(in);
        group.add(pre);
        group.add(post);



    }
}