class TreeNode{
    Object data;
    TreeNode llink;
    TreeNode rlink;
    Boolean LT;
    Boolean RT;

    static TreeNode build(TreeNode L, Object data, TreeNode R, Boolean bl, Boolean br){
        TreeNode temp = new TreeNode();
        temp.data = data;
        temp.llink = L;
        temp.rlink = R;
        temp.LT = bl;
        temp.RT = br;
        return temp;
    }

    TreeNode inorder_successor(TreeNode node){
        TreeNode p = node.rlink;
        if(!node.RT){
            while(!p.LT)
                p = p.llink;
        }
        return p;
    }

    void inorder(TreeNode tree_head){
        TreeNode p = tree_head;
        TreeNode temp = p;
        while(true){
            temp = inorder_successor(temp);
            if(temp == p)
                break;
            System.out.print(temp.data + " ");
        }
    }

    static TreeNode create(){
        TreeNode n15 = build(null, 15, null, true, true);
        TreeNode n49 = build(null, 49, null, true, true);
        TreeNode n75 = build(null, 75, null, true, true);
        TreeNode n14 = build(null, 14, n15, true, false);
        TreeNode n66 = build(n49, 66, n75, false, false);
        TreeNode n20 = build(n14, 20, null, false, true);
        TreeNode n32 = build(null, 32, null, true, true);
        TreeNode n46 = build(null, 46, n66, true, false);
        TreeNode n7 = build(null, 7, n20, true, false);
        TreeNode n39 = build(n32, 39, n46, false, false);
        TreeNode root = build(n7, 29, n39, false, false);
        TreeNode head = build(root, null, null, false, false);

        n15.llink = n14; n15.rlink = n20;
        n49.llink = n46; n49.rlink = n66;
        n75.llink = n66; n75.rlink = head;
        n14.llink = n7;
        n20.rlink = root;
        n32.llink = root; n32.rlink = n39;
        n46.llink = n39;
        n7.llink = head;
        head.rlink = head;

        // return root;
        return head;
    }

    int[] higher(TreeNode tree_head, int num){
        TreeNode p = tree_head;
        TreeNode temp = p;
        int[] arr = new int[10];

        while(true){
            temp = inorder_successor(p);
            if((int)temp.data == num)
                break;
            if(temp == p)
                return null;
        }

        int i = 0;
        while(true){
            temp = inorder_successor(p);
            if(temp == p)
                break;
            arr[i++] = (int)temp.data;
        }
        return arr;
    }
}

public class BST{
    public static void main(String args[]){
        TreeNode head = TreeNode.create();
        System.out.println(head.higher(head, 40));
    }
}
