package cn.chinotan;

import org.junit.Test;

/**
 * @program: test
 * @description: 兑换码自动生成
 * @author: xingcheng
 * @create: 2019-04-05 16:08
 **/
public class GenerateCodeNumber {

    /**
     * 基础字符 32个 必须是2的n次幂个
     */
    private final String BASE_CHAR = "vST7K12CDJG4UR8dX3Babcyrfghjpq9A";

    /**
     * 基础字符长度
     */
    private final int BASE_CHAR_LEN = BASE_CHAR.length();

    /**
     * 用于 位与 运算，映射到BASE_CHARS
     */
    private int CHAR_AND = BASE_CHAR_LEN - 1;

    /**
     * 检测字符长度
     */
    private int CHECK_CHAR_LEN = 3;

    /**
     * 总长度（除id位）
     */
    private int TOTAL_LEN = 9;

    /**
     * 单个字符长度
     */
    private final int SINGLE_CHAR_LEN = (int)(Math.log(BASE_CHAR_LEN)/Math.log(2));

    public String generateCode(int actId) {
        // 校验
        int bitLen = SINGLE_CHAR_LEN * TOTAL_LEN;
        if (bitLen > 64) {
            throw new IllegalArgumentException("bitLen too bigger");
        }
        // 转化actId为二级制获取其长度
        int idLen = Integer.toBinaryString(actId).length();
        // 获取首字母 由catId转化而来
        String firstChar = String.valueOf(BASE_CHAR.charAt(idLen & CHAR_AND));
        int leftNum = bitLen - idLen;
        // 定义总数大小
        long sum = actId << leftNum;
        // 计算剩余的随机位长度
        int remainLen = bitLen - CHECK_CHAR_LEN - idLen;
        long randData = (long)((1L << remainLen) * Math.random());
        sum += randData << CHECK_CHAR_LEN;
        // 计算校验位
        long checkNUm = (sum >> CHECK_CHAR_LEN) % ((1 << CHECK_CHAR_LEN) - 1);
        sum += checkNUm;

        StringBuilder sb = new StringBuilder();
        String remainString = serialToCode(sum);
        return sb.append(firstChar).append(remainString).toString();
    }

    public String serialToCode(long sum) {
        StringBuffer codeSerial = new StringBuffer();
        long tmpValue = sum;
        for (int i = 0; i < TOTAL_LEN; i++) {
            int code = (int) (tmpValue & CHAR_AND);
            codeSerial.append(BASE_CHAR.charAt(code));
            tmpValue = tmpValue >> SINGLE_CHAR_LEN;
        }

        return codeSerial.reverse().toString();
    }

    public boolean verify(long sum){
        if(sum < 0){
            return false;
        }
        int checkModData = (1 << CHECK_CHAR_LEN) - 1;

        long data = sum >> CHECK_CHAR_LEN;
        long checkNum = sum & checkModData; // 截取后面几位校验码

        if (data % checkModData == checkNum) {// 判断截取的检验码跟计算出的校验码是否一致
            return true;
        }

        return false;

    }

    private long getSerial(String code) {
        long sum = 0L;
        int codeLength = code.length();
        for (int i = 1; i < codeLength; i++) {
            int originNum = BASE_CHAR.indexOf(code.charAt(i));
            if (originNum >= BASE_CHAR_LEN) {
                return -1;  
            }
            sum = sum << SINGLE_CHAR_LEN;
            sum += originNum;
        }
        return sum;
    }

    public int getActId(String code){
        long sum = getSerial(code);
        if (verify(sum)) {
            int idBitLength = BASE_CHAR.indexOf(code.charAt(0));
            int totalBitLength = SINGLE_CHAR_LEN * (code.length() - 1);
            int randBitLength = totalBitLength - idBitLength - CHECK_CHAR_LEN;
            return (int) sum >> (randBitLength + CHECK_CHAR_LEN);
        } else {
            return -1;
        }
    }
    
    @Test
    public void test() {
        String code = generateCode(121);
        System.out.println(code);
        int actId = getActId("Cv7p272RBJ");
        System.out.println(actId);
    }
}
