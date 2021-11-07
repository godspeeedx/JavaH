package ru.mephi.java.ch01.task12;

public class JDK {
    public static void main(String[] args) {

    }
    private int match(byte[] src, byte[] b, byte[] lastOcc, byte[] optoSft) {
        int len = src.length;
        int last = b.length - len;
        int i = 0;
        next:
        while (i <= last) {
            for (int j = (len - 1); j >= 0; j--) {
                byte c = b[i + j];
                if (c >= ' ' && c <= 'z') {
                    if (c >= 'a') c -= 32; // Canonicalize

                    if (c != src[j]) {
// no match
                        int badShift = lastOcc[c - 32];
                        i += Math.max(j + 1 - badShift, optoSft[j]);
                        continue next;
                    }
                } else {
// no match, character not valid for name
                    i += len;
                    continue next;
                }
            }
            return i;
        }
        return -1;
    }

    private int matchNew(byte[] src, byte[] b, byte[] lastOcc, byte[] optoSft) {
        int len = src.length;
        int last = b.length - len;
        int i = 0;

        while (i <= last) {
            boolean flag = false;
            for (int j = (len - 1); j >= 0; j--) {
                byte c = b[i + j];
                if (c >= ' ' && c <= 'z') {
                    if (c >= 'a') c -= 32; // Canonicalize

                    if (c != src[j]) {
// no match
                        int badShift = lastOcc[c - 32];
                        i += Math.max(j + 1 - badShift, optoSft[j]);
                        flag = true;
                        break;
                    }
                } else {
// no match, character not valid for name
                    i += len;
                    flag = true;
                    break;
                }
            }
            if (flag == true) continue;
            return i;
        }
        return -1;
    }
}
