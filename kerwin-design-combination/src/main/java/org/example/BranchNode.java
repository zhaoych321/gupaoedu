package org.example;

import java.util.ArrayList;
import java.util.List;

public class BranchNode extends Node{

    private List<Node> tree;

    private int level;

    public BranchNode(String name,int level) {
        super(name);
        tree = new ArrayList<>();
        this.level = level;
    }

    public void addChild(Node node){
        this.tree.add(node);
    }

    @Override
    String show(int level) {
        StringBuilder sb = new StringBuilder();
        if(tree == null || tree.size() == 0){
            return sb.toString();
        }
        sb.append("+").append(name);
        //遍历下级节点
        for (Node node : tree) {
            sb.append("\n");
            for (int i = 0; i < level; i++) {
                sb.append("  ");
            }
            //名称并换行
            sb.append(node.show(level + 1));
        }

        return sb.toString();
    }
}
