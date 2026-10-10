import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
class LibraryMember {
    private String membershipId, name, securityAnswer;
    private boolean premiumMember;
    public String getMembershipId() { return membershipId; }
    public void setMembershipId(String id) { if (membershipId == null && id != null && !id.trim().isEmpty()) membershipId = id; }
    public String getName() { return name; }
    public void setName(String value) { name = value; }
    public boolean isPremiumMember() { return premiumMember; }
    public void setPremiumMember(boolean value) { premiumMember = value; }
    public void setSecurityAnswer(String answer) { securityAnswer = answer == null ? null : hash(answer); }
    private String hash(String value) {
        try {
            byte[] bytes = MessageDigest.getInstance("SHA-256").digest(value.getBytes(StandardCharsets.UTF_8));
            StringBuilder out = new StringBuilder();
            for (byte b : bytes) out.append(String.format("%02x", b & 255));
            return out.toString();
        } catch (NoSuchAlgorithmException e) { throw new IllegalStateException(e); }
    }
}
public class Main {
    public static void main(String[] args) {
        LibraryMember member = new LibraryMember();
        member.setMembershipId("LIB1001"); member.setMembershipId("LIB2002");
        member.setName("Asha"); member.setPremiumMember(true); member.setSecurityAnswer("blue");
        System.out.println(member.getMembershipId() + " | " + member.getName() + " | " + member.isPremiumMember());
    }
}