/*
Reverse bits of a given 32 bits unsigned integer.

Example 1:
Input: 00000010100101000001111010011100
Output: 00111001011110000010100101000000
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.

Example 2:
Input: 11111111111111111111111111111101
Output: 10111111111111111111111111111111

*/
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    for (int i = 0; i < 16; i++) {
		n = swapBits(n, i, 32 - i - 1);
	}
 
	return n;
}
 
public int swapBits(int n, int i, int j) {
	int a = (n >> i) & 1;
	int b = (n >> j) & 1;
 
	if ((a ^ b) != 0) {
		return n ^= (1 << i) | (1 << j);
	}
 
	return n;
    }
}


