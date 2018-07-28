public class Tree{
    static class Node {
        protected char character;
        protected int data;
        protected int characterFrequency;
        protected Node leftChild;
        protected Node rightChild;
        protected int position;
        protected Node parent;

        Node(final char ch, int freq, Node left, Node right,int position) {
            this.character = ch;
            this.characterFrequency = freq;
            this.leftChild = left;
            this.rightChild = right;
            data='\0';
            this.position=position;
        }
        public Node(int data) {
            this.data = data;
            leftChild = null;
            rightChild = null;
            parent=null;
            character='\0';
            characterFrequency='\0';
        }

        boolean isLeaf() {
            return leftChild == null && rightChild == null;
        }

        public void print(){
            System.out.println(character+" and "+characterFrequency+" freq");
        }

    }
    public Node root;

    public Tree(){
        this.root = null;
    }
}
