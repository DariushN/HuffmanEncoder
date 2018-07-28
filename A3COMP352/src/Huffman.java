import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Huffman extends Tree {

    private static final int maxCharCount = 256;

    //figure out how to find the possible maximum occurence in the text later
    //static int maxCharLength=content.length();
    static int maxCharLength=50000;

    private static class encodedOutput {

        Node root;
        String encodedPath;
        int position;

        encodedOutput(String encodedData, Node root, int position) {
            this.encodedPath = encodedData;
            this.root = root;
            this.position=position;
        }
        String getEncodedPath() {
            return this.encodedPath;
        }
    }


//built a double array to store freq in index 0 and position in 1
    private static int[][] countFrequencyPosition(String toEncode) {
        int[][] freqPos = new int[maxCharCount][2];
        int count=0;
        for (char charEncode : toEncode.toCharArray()) {
            freqPos[charEncode][0]++;
            if (freqPos[charEncode][0]==1){
                freqPos[charEncode][1]=count;
            }
            count++;
        }
        return freqPos;
    }

    private static String encodedResult(String data, String[] pathTable) {
        String encodedResult="";
        char[] temp=data.toCharArray();
        for (int i=0;i<temp.length;i++) {
            encodedResult+=pathTable[temp[i]];
        }
        return encodedResult;
    }

    private static Node buildHuffTree(int[][] freqPos) {
        PQueue pq = new PQueue();
        for (char i = 0; i < maxCharCount; i++){
            if (freqPos[i][0] > 0) {
                pq.add(new Node(i, freqPos[i][0], null, null,freqPos[i][1]));
            }
        }
        //position 0 might cause problem, come check
        if (pq.size() == 1) {
            pq.add(new Node('\0', 0, null, null,'\0'));
        }
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('\0', left.characterFrequency + right.characterFrequency, left, right,++maxCharLength);
            pq.add(parent);
        }
        return pq.poll();
    }

    //index 0 of lookup array is character and 1 is path string
    private static void buildPath(Node x, String s, String[] pathArray) {
        if (!x.isLeaf()) {
            buildPath(x.leftChild, s + '0', pathArray);
            buildPath(x.rightChild, s + '1', pathArray);
        } else {
            pathArray[x.character]=s;
        }
    }

    public encodedOutput encode(String inEncode, String outEncode) {
        int[][] freqPos = countFrequencyPosition(inEncode);
        Node root = buildHuffTree(freqPos);
        String[] pathTable = new String[maxCharCount];
        buildPath(root, "", pathTable);
        String builder = encodedResult(outEncode, pathTable);
        return new encodedOutput(builder, root,'\0');
    }

    public static void main(String[] args) {
        String content="";

        try {
            content = new Scanner(new File(args[0])).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            System.out.println("Could not open source file!");;
        }
        System.out.println("What string would you like to encode?");
        Scanner MyKey=new Scanner(System.in);
        String toEncode=MyKey.nextLine();
        Huffman huffman = new Huffman();
        encodedOutput result = huffman.encode(content,toEncode);
        System.out.println("Your Huffman encoded message:");
        System.out.println(result.getEncodedPath());
    }


}