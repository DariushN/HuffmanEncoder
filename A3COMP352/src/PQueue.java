
public class PQueue {
    private int maxChars;
    private Tree.Node[] nodes;
    private int size;
    public PQueue(){
        maxChars=258;
        nodes=new Tree.Node[maxChars];
        size=0;
    }
    public void add(Tree.Node value){
        int i;
        if(size==0){
            nodes[0]=value;
            size++;
        }
        else {
            for (i = size - 1; i >= 0; i--) {
                if (value.characterFrequency > nodes[i].characterFrequency) {
                    nodes[i + 1] = nodes[i];
                }
                else if ((value.characterFrequency == nodes[i].characterFrequency)&&(value.position<nodes[i].position)) {
                    nodes[i + 1] = nodes[i];
                }
                else{
                    break;
                }
            }
            nodes[i + 1] = value;
            size++;
        }
    }
    public Tree.Node poll(){
        //int temp2=size-1;
        Tree.Node temp=nodes[size-1];
        //nodes= Arrays.copyOf(nodes,nodes.length-1);
        nodes[size-1]=null;
        size--;
        return temp;
    }
    public int size(){
        return size;
    }

}
