package com.dsxy.util;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    /**
     * 加密密码
     * @param rawPassword 原始密码
     * @return 加密后的哈希值
     */
    public static String hashPassword(String rawPassword) {
        // 生成盐值并加密密码
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }

    /**
     * 校验密码是否匹配
     * @param rawPassword 用户输入的原始密码
     * @param storedHash 存储在数据库中的哈希值
     * @return 是否匹配
     */
    public static boolean checkPassword(String rawPassword, String storedHash) {
        return BCrypt.checkpw(rawPassword, storedHash);
    }

}
