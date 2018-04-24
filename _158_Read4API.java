package hard;

public class _158_Read4API {

	private int buffPtr = 0;
	private int buffCnt = 0;
	private char[] buff = new char[4];

	public int read(char[] buf, int n) {
		int ptr = 0;
		while (ptr < n) {
			if (buffPtr == 0) {
				buffCnt = read4(buff);
			}
			if (buffCnt == 0)
				break;
			while (ptr < n && buffPtr < buffCnt) {
				buf[ptr++] = buff[buffPtr++];
			}
			if (buffPtr >= buffCnt)
				buffPtr = 0;
		}
		return ptr;
	}
	
	//DUMMY Read4 method

	public int read4(char[] buff) {
		return -1;
	}
}
