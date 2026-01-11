import java.io.Serializable;

public class MembershipType implements Serializable {
    private String type;
    
    public static final MembershipType BASIC = new MembershipType("Basic");
    public static final MembershipType PREMIUM = new MembershipType("Premium");
    public static final MembershipType ELITE = new MembershipType("Elite");

    private MembershipType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
