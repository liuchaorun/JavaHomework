package cn.liuchaorun.firstHomework;

import org.jetbrains.annotations.NotNull;

public class Base64 {
    private static char[] table = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    @NotNull
    public static String encode(byte[] binaryData) {
        int count = binaryData.length / 3;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            byte[] data = new byte[3];
            System.arraycopy(binaryData, i * 3, data, 0, 3);
            builder.append(table[(byte) ((data[0] >>> 2) & 0x3f)]);
            builder.append(table[(byte) ((((data[0] & 0x03) << 4) | (((data[1]) >>> 4) & 0x0f)) & 0x3f)]);
            builder.append(table[(byte) (((data[1] & 0x0f) << 2 | (data[2] >>> 6 & 0x03)) & 0x3f)]);
            builder.append(table[(byte) (data[2] & 0x3f)]);
        }
        if (binaryData.length % 3 == 1) {
            byte one = binaryData[binaryData.length - 1];
            builder.append(table[(byte) ((one >>> 2) & 0x3f)]);
            builder.append(table[(byte) ((one & 0x03) << 4)]);
            builder.append('=');
            builder.append('=');
        }
        if (binaryData.length % 3 == 2) {
            byte[] rest = new byte[2];
            System.arraycopy(binaryData, binaryData.length - 2, rest, 0, 2);
            builder.append(table[(byte) ((rest[0] >>> 2) & 0x3f)]);
            builder.append(table[(byte) ((((rest[0] & 0x03) << 4) | (((rest[1]) >>> 4) & 0x0f)) & 0x3f)]);
            builder.append(table[(byte) (((rest[1] & 0x0f) << 2))]);
            builder.append('=');
        }
        return builder.toString();
    }

    public static byte[] decode(String s) {
        StringBuilder builder = new StringBuilder();
        for (char aTable : table) {
            builder.append(aTable);
        }
        String tableString = builder.toString();
        int stringLength = s.length();
        int l = stringLength / 4 * 3;
        if (s.charAt(s.length() - 1) == '=') l--;
        if (s.charAt(s.length() - 2) == '=') l--;
        byte[] decodeByte = new byte[l];
        for (int i = 0; i < stringLength /4; i++){
            if(s.charAt((4 * i) + 3) == '='){
                if(s.charAt((4 * i) + 2) == '='){
                    int[] temp = new int[2];
                    for (int j = 0; j < 2; j++){
                        temp[j] = tableString.indexOf(s.charAt((4 * i) + j));
                    }
                    decodeByte[3*i] = (byte)(temp[0]<<2 | temp[1] >>> 4);
                }
                else {
                    int[] temp = new int[3];
                    for (int j = 0; j < 3; j++){
                        temp[j] = tableString.indexOf(s.charAt((4 * i) + j));
                    }
                    decodeByte[3*i] = (byte)(temp[0]<<2 | temp[1] >>> 4);
                    decodeByte[(3 * i) + 1] = (byte)(temp[1] << 4 | temp[2] >>2);
                }
            }else{
                int[] temp = new int[4];
                for (int j = 0; j < 4; j++){
                    temp[j] = tableString.indexOf(s.charAt(4*i+j));
                }
                decodeByte[3*i] = (byte)(temp[0]<<2 | temp[1] >>> 4);
                decodeByte[(3 * i) + 1] = (byte)(temp[1] << 4 | temp[2] >>2);
                decodeByte[(3 * i) + 2] = (byte)(temp[2] << 6 | temp[3]);
            }
        }
        return decodeByte;
    }

    public static void main(String[] args) {
        byte[] a = {1, 2, 3, -7, -9, 110};
        String s = encode(a);
        System.out.println(s);
        byte[] b = decode(s);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

    }

}
