class TreeNode{
    Object data;
    TreeNode llink;
    TreeNode rlink;

    void inorder(TreeNode p){
        if(p != null){
            inorder(p.llink);
            System.out.print(p.data + " "); // VISIT
            inorder(p.rlink);
        }
    }

    void postorder(TreeNode p){
        if(p != null){
            postorder(p.llink);
            postorder(p.rlink);
            System.out.print(p.data + " "); // VISIT
        }
    }

    void preorder(TreeNode p){
        if(p != null){
            System.out.print(p.data + " "); // VISIT
            preorder(p.llink);
            preorder(p.rlink);
        }
    }

    static TreeNode build(TreeNode L, Object data, TreeNode R){
        TreeNode temp = new TreeNode();
        temp.data = data;
        temp.llink = L;
        temp.rlink = R;
        return temp;
    }

    static TreeNode create(){
        TreeNode n4 = build(null, 'A', null);
        TreeNode n8 = build(null, 'B', null);
        TreeNode n9 = build(null, 'C', null);
        TreeNode n6 = build(null, 'D', null);
        TreeNode n7 = build(null, 'E', null);
        TreeNode n5 = build(n8, '/', n9);
        TreeNode n2 = build(n4, '+', n5);
        TreeNode n3 = build(n6, '-', n7);
        TreeNode root = build(n2, '*', n3);
        return root;
    }

    static TreeNode createBST(){
        TreeNode n24 = build(null, 24, null);
        TreeNode n12 = build(null, 12, n24);
        TreeNode n37 = build(null, 37, null);
        TreeNode n67 = build(null, 67, null);
        TreeNode n48 = build(null, 48, n67);
        TreeNode n45 = build(n37, 45, n48);
        TreeNode root = build(n12, 35, n45);
        return root;
    }

    // Boolean Add(TreeNode e){
    //     for
    //     if(e)
    // }
}

public class TreeNodeTraversal{
    public static void main(String args[]){
        TreeNode n1 = TreeNode.create();
        System.out.print("Preorder : ");
        n1.preorder(n1);
        System.out.println();
        System.out.print("Inorder : ");
        n1.inorder(n1);
        System.out.println();
        System.out.print("Postorder : ");
        n1.postorder(n1);
        System.out.println();

        System.out.println();

        TreeNode n2 = TreeNode.createBST();
        System.out.print("Preorder : ");
        n2.preorder(n2);
        System.out.println();
        System.out.print("Inorder : ");
        n2.inorder(n2);
        System.out.println();
        System.out.print("Postorder : ");
        n2.postorder(n2);
        System.out.println();
    }
}
