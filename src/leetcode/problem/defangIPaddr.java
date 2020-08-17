package leetcode.problem;

public class defangIPaddr {
    /**
     * 1108
     * https://leetcode-cn.com/problems/defanging-an-ip-address/
     */
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
