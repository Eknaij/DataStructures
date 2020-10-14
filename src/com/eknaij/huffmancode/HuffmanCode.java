package com.eknaij.huffmancode;

import java.io.*;
import java.util.*;

/**
 * @Author Eknaij
 * @Date 2020/10/9 16:07
 * @Description 赫夫曼编码
 */
public class HuffmanCode {
    public static void main(String[] args) throws IOException {

//        String str = "i like like like java do you like a java";
//        byte[] contentByte = str.getBytes();
//        List<Node> list = getNodes(contentByte);
//        System.out.println(list);
//        Node root = createHuffmanTree(list);
//        preOrder(root);
//        getCodes(root, "", new StringBuilder());
//        System.out.println(huffmanCodes);//哈弗曼编码表
//        byte[] bytes = zip(contentByte, huffmanCodes);
//        System.out.println("压缩后的字节数组为" + Arrays.toString(bytes));

//        byte[] b = decode(huffmanCodes, bytes);
//        System.out.println("解压后的字符为：" + new String(b));


        String srcFile = "C:\\Users\\admin\\Desktop\\cat.png";
        String destFile = "C:\\Users\\admin\\Desktop\\zipCat.zip";
//        zipFile(srcFile, destFile);
//        System.out.println("压缩文件成功");
        String unzipFile = "C:\\Users\\admin\\Desktop\\unzip.png";
        unzipFile(destFile,unzipFile);
        System.out.println("解压成功");
    }


    /**
     * @param bytes        初始字节数组，记录了每个字符的顺序
     * @param huffmanCodes 哈弗曼编码表
     * @return 返回经过哈弗曼编码处理后的字节数组
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //1.利用huffmanCodes将bytes转成哈弗编码对应的字符
        StringBuilder stringBuilder = new StringBuilder();
        for (Byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        //循环结束后，stringBuilder是一个二进制字符串：
        //1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
        //要将二进制字符串转成字节数组
        //转化时，每个字节取八位10101000，这八位是补码高位为符号位，需要转成原码
        //补码->原码    符号位不变，补码减一后得到反码再取反
        //10101000 -1 = 10100111（反码）
        //符号位不变反码取反得到原码 11011000（原码）

        //统计返回byte[] huffmanCodes的长度
//        int len = (stringBuilder.length() + 7) / 8;
        int len = 0;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] huffmanBytes = new byte[len];
        int index = 0;//记录是第几字节
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String str;
            //每次截取八个字符
            if (i + 8 > stringBuilder.length())
                str = stringBuilder.substring(i);
            else
                str = stringBuilder.substring(i, i + 8);
            //将截取到的八位二进制字符转成字节，并且放入到字节数组中
            huffmanBytes[index++] = (byte) Integer.parseInt(str, 2);
        }
        return huffmanBytes;
    }

    /**
     * @param srcFile  需要压缩的文件路径
     * @param destFile 存放解压文件的路径
     * @throws IOException
     */
    private static void zipFile(String srcFile, String destFile) throws IOException {
        //创建文件输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        //创建文件输入流
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFile);
            byte[] b = new byte[fileInputStream.available()];
            //读取文件
            fileInputStream.read(b);
            //对源文件进行压缩
            byte[] huffmanBytes = huffmanZip(b);
            //创建文件输出流存放压缩文件
            os = new FileOutputStream(destFile);
            //创建一个和文件相关的ObjectOutputStream
            oos = new ObjectOutputStream(os);

            //把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //以对象流的方式写入Huffman编码，为了解压时使用（一定要写入）
            oos.writeObject(huffmanCodes);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            fileInputStream.close();
            os.close();
            oos.close();
        }
    }

    /**
     *
     * @param zipFile   需要解压的文件
     * @param destFile  解压文件的存放路径
     * @throws IOException
     */
    private static void unzipFile(String zipFile, String destFile) throws IOException {
        //文件输入流
        InputStream inputStream = null;
        //定一个对象输入流
        ObjectInputStream ois = null;
        //定义文件输出流
        OutputStream os = null;
        try {
            //创建文件输入流
            inputStream = new FileInputStream(zipFile);
            //创建和一个inputStream的对象输入流
            ois = new ObjectInputStream(inputStream);
            //读取byte数组 huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取赫夫曼编码表
            Map<Byte,String> map = (Map<Byte, String>) ois.readObject();
            //解码
            byte[] bytes = decode(map,huffmanBytes);
            //将文件流输出
            os = new FileOutputStream(destFile);
            os.write(bytes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            inputStream.close();
            ois.close();
            os.close();
        }
    }

    /**
     * 压缩文件得到压缩后的字节数组
     * 注意：最后一位如果是正数，可能会有bug
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        //根据 nodes 创建的赫夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        //对应的赫夫曼编码(根据 赫夫曼树)
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        //根据生成的赫夫曼编码， 压缩得到压缩后的赫夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }

    static StringBuilder stringBuilder = new StringBuilder();

    //为了调用方便， 我们重载 getCodes
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return null;
        }
        //处理 root 的左子树
        getCodes(root.left, "0", stringBuilder);
        //处理 root 的右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    //记录赫夫曼编码表
    static Map<Byte, String> huffmanCodes = new HashMap<>();

    /**
     * 功能： 将传入的 node 结点的所有叶子结点的赫夫曼编码得到， 并放入到 huffmanCodes 集合
     *
     * @param node          传入结点
     * @param code          路径： 左子结点是 0, 右子结点 1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        //将code加入到stringBuilder
        stringBuilder1.append(code);
        if (node != null) {
            if (node.data == null) {
                //向左递归
                getCodes(node.left, "0", stringBuilder1);
                //向右递归
                getCodes(node.right, "1", stringBuilder1);
            } else {
                huffmanCodes.put(node.data, stringBuilder1.toString());
            }
        }
    }

    /**
     * @param flag 标识符，标识需不需要补位，true标识需要补位,最后一个字节不需要补高位
     * @param b
     * @return 返回相应的二进制补码
     */
    private static String byteToBitString(boolean flag, byte b) {
        //用一个int变量保存byte字符
        int temp = b;
        //如果是正数，需要进行补位
        if (flag) {
            temp |= 256; //按位与 256 的二进制为 1 0000 0000 | 0000 0001 => 1 0000 0001
        }
        //利用Integer包装类的toBinaryString可以得到一个temp对应的二进制补码 ，原码符号位不变，取反再加一
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    /**
     * @param huffmanCodes 哈夫曼编码表
     * @param buffmanBytes 已经过哈弗曼编码加密的字节数组
     * @return 原始字符串对应的数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] buffmanBytes) {
        //1.将哈弗曼编码加密的字节数组还原
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < buffmanBytes.length; i++) {
            boolean flag = (i == buffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, buffmanBytes[i]));
        }
        System.out.println("哈弗曼编码字节数组对应的二进制字符串:" + stringBuilder.toString());
        //交换哈弗曼编码表，便于找到相应的字符
        Map<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
//        System.out.println(map);
        //创建一个集合
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 0;//计数器，标识遍历到第几个字符
            boolean flag = false;//标识是否根据哈弗曼编码匹配到一个字符，
            Byte b = null;
            //用一个循环去找到字符
            while (!flag) {
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    //没找到，拼接多一个stringBuilder的字符
                    count++;
                } else {
                    //找到一个合适的字符
                    flag = true;
                }
            }
            list.add(b);
            i += count;
        }
        //返回一个字节数组
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    /**
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        //先创建一个arrayList
        ArrayList<Node> nodes = new ArrayList();
        //利用hashmap来统计每个字符出现的次数
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            Integer count = map.get(b);
            if (count == null) {
                map.put(b, 1);
            } else {
                map.put(b, count + 1);
            }
        }
        //遍历map
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * 创建一个赫夫曼树
     *
     * @param nodes
     * @return 赫夫曼树的根节点
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            nodes.add(parent);
            nodes.remove(left);
            nodes.remove(right);
        }
        return nodes.get(0);
    }

    //编写一个前序遍历的方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树， 不能遍历~~");
        }
    }
}

class Node implements Comparable<Node> {
    Byte data;
    int weight;
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //写一个前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (
                this.right != null) {
            this.right.preOrder();
        }
    }
}
