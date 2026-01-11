import java.io.Serializable;

public class Membership implements Serializable {
    private String membershipId;
    private String startDate;
    private String endDate;
    private MembershipType membershipType;
    private Duration duration;

    public Membership(String membershipId, String startDate, String endDate, 
                     MembershipType membershipType, Duration duration) {
        this.membershipId = membershipId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.membershipType = membershipType;
        this.duration = duration;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public double getBasePrice() {
        if (membershipType.getType().equalsIgnoreCase("Basic")) return 5000.0;
        if (membershipType.getType().equalsIgnoreCase("Premium")) return 10000.0;
        if (membershipType.getType().equalsIgnoreCase("Elite")) return 15000.0;
        return 0.0;
    }

    public double getDiscountPercentage() {
        String type = membershipType.getType();
        int months = duration.getNumberOfMonths();
        
        if (type.equalsIgnoreCase("Premium")) {
            if (months == 3) return 20.0;
            if (months == 12) return 40.0;
        } else if (type.equalsIgnoreCase("Elite")) {
            if (months == 3) return 30.0;
            if (months == 12) return 50.0;
        }
        return 0.0;
    }

    public double calculateOriginalAmount() {
        return getBasePrice() * duration.getNumberOfMonths();
    }

    public double calculateFinalAmount() {
        double monthlyAmount = getBasePrice() * (1 - (getDiscountPercentage() / 100.0));
        return monthlyAmount * duration.getNumberOfMonths();
    }

    @Override
    public String toString() {
        return "Membership{" +
                "membershipId='" + membershipId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", membershipType=" + membershipType +
                ", duration=" + duration +
                '}';
    }
}
