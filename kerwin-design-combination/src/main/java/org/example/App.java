package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        BranchNode root = new BranchNode("树木",1);

        BranchNode branch1 = new BranchNode("庭园树",2);
        LeafNode leaf1 = new LeafNode("雪松");
        LeafNode leaf2 = new LeafNode("银杏");
        branch1.addChild(leaf1);
        branch1.addChild(leaf2);

        BranchNode branch2 = new BranchNode("庭荫树",2);
        LeafNode leaf3 = new LeafNode("国槐");
        branch2.addChild(leaf3);

        BranchNode branch3 = new BranchNode("行道树",2);
        LeafNode leaf4 = new LeafNode("垂柳");
        branch3.addChild(leaf4);

        root.addChild(branch1);
        root.addChild(branch2);
        root.addChild(branch3);

        System.out.println(root.show(2));

    }
}
