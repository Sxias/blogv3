package shop.mtcoding.blog.temp;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

public class HashTest {

    @Test
    public void encode_test() {
        // given
        String password = "1234";

        // when
        String encPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        // eye
        System.out.println(encPassword);

        // $2a$10$93SObxZRuYAOT5a22IQDj.3j5XK3EQSIlzsD31BCS1Dyt3ISSA6ci
        // $2a$10$lWwqfv9yWKKInp9DhCDFdOEb0v/cFy5NqUarY0Czk2X3uTLKK3IBG
    }

    @Test
    public void decode_test() {
        // given
        String password = "1234";
        String dbPassword = "$2a$10$93SObxZRuYAOT5a22IQDj.3j5XK3EQSIlzsD31BCS1Dyt3ISSA6ci";

        // when
        String encPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        // eye
        if (encPassword.equals(dbPassword)) System.out.println("비밀번호가 같아요");
        else System.out.println("비밀번호가 달라요");

        // $2a$10$93SObxZRuYAOT5a22IQDj.3j5XK3EQSIlzsD31BCS1Dyt3ISSA6ci
        // $2a$10$lWwqfv9yWKKInp9DhCDFdOEb0v/cFy5NqUarY0Czk2X3uTLKK3IBG
    }

    @Test
    public void decodeV2_test() {
        // given
        String password = "1234";
        String dbPassword = "$2a$10$93SObxZRuYAOT5a22IQDj.3j5XK3EQSIlzsD31BCS1Dyt3ISSA6ci";

        // when
        boolean isMatched = BCrypt.checkpw(password, dbPassword);

        // eye
        System.out.println(isMatched);

        // $2a$10$93SObxZRuYAOT5a22IQDj.3j5XK3EQSIlzsD31BCS1Dyt3ISSA6ci
        // $2a$10$lWwqfv9yWKKInp9DhCDFdOEb0v/cFy5NqUarY0Czk2X3uTLKK3IBG
    }
}
