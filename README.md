# Huffman Encoder
Huffman coding is a lossless data compression algorithm. The idea is to assign variable-length codes to input characters, lengths of the assigned codes are based on the frequencies of corresponding characters. The most frequent character gets the smallest code and the least frequent character gets the largest code. In this program, the Huffman tree is first built with a text file given by the user, which is then used to encode a word or sentence inputed. The encoding will thus depend on the frequency of characters used in the text file. 
## How to use
1. Create a text file that will be used to build the Huffman tree. Note that this program was meant to be used through a terminal, and should be run as "java Huffman <File_Name>"
2. Run the program and enter the name of the file created in step 1
3. When prompted, enter the sentences that the user wishes to encode

## Result
![huffman](https://user-images.githubusercontent.com/35940376/43358026-3a78514e-9259-11e8-8b59-6a7744a4ad1f.gif)

