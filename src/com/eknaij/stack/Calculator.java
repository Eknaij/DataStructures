package com.eknaij.stack;

/**
 * @ClassName Calculator
 * @Description 中缀简易综合计算器
 * @Author Eknaij
 * @Date 2020/7/22 10:53
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "111*1*2-5+1-5+3-4"; // 15//如何处理多位数的问题？
        //创建两个栈， 数栈， 一个符号栈
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        //定义需要的相关变量
        int index = 0;//用于扫描
        int num1 = 0;//第一次出栈的数字
        int num2 = 0;//第二次出栈的数字
        int oper = 0;//出栈的字符
        int res = 0;
        char ch = ' '; //将每次扫描得到 char 保存到 ch
        String keepNum = ""; //用于拼接 多位数
        //开始 while 循环的扫描 expression
        while (true) {
            //依次得到 expression 的每一个字符，substring返回的是一个单字符的字符串，所以用charAt
            ch = expression.substring(index, index + 1).charAt(0);
            //判断 ch 是什么， 然后做相应的处理
            if (operStack.isOper(ch)) {//如果是运算符
                //判断当前的符号栈是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符， 就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从数栈中 pop 出两个数,
                    //在从符号栈中 pop 出一个符号， 进行运算， 将得到结果， 入数栈， 然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算的结果如数栈
                        numStack.push(res);
                        //然后将当前的操作符入符号栈
                        operStack.push(ch);
                    } else {
                        //如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
                        operStack.push(ch);
                    }
                } else {
                    //如果为空直接入符号栈..
                    operStack.push(ch);
                }
            } else {
                //如果是数， 则直接入数栈
                //numStack.push(ch - 48); //由于数字的字符在ASCII中比实际数字大48，因此需要减去48
                //分析思路
                //1. 当处理多位数时， 不能发现是一个数就立即入栈， 因为他可能是多位数
                //2. 在处理数， 需要向 expression 的表达式的 index 后再看一位,如果是数就进行扫描， 如果是符号才入栈
                //3. 因此我们需要定义一个变量 字符串， 用于拼接
                //处理多位数
                keepNum += ch;
                //如果 ch 已经是 expression 的最后一位， 就直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                //判断下一个字符是不是数字， 如果是数字， 就继续扫描， 如果是运算符， 则入栈
                //注意是看后一位， 不是 index++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符， 则入栈 keepNum = "1" 或者 "123"
                        numStack.push(Integer.parseInt(keepNum));
                        //重要的!!!!!!, keepNum 清空
                        keepNum = "";
                    }
                }
            }
            //让 index +1, 并判断是否扫描到 expression 最后.
            index++;
            if (index >= expression.length())
                break;
        }
        //当表达式扫描完毕，就顺序的从 数栈和符号栈中 pop 出相应的数和符号，并运行.
        while (true) {
            //如果符号栈为空， 则计算到最后的结果, 数栈中只有一个数字【结果】
            if (operStack.isEmpty())
                break;
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
        }
        numStack.push(res);//入栈
        //将数栈的最后数，pop 出，就是结果
        int res2 = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, res2);
    }
}

